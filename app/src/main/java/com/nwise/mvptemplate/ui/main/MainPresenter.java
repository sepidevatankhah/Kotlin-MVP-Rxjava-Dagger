package com.nwise.mvptemplate.ui.main;

import android.util.Log;
import com.nwise.mvptemplate.domain.interactors.AnswerUseCase;
import com.nwise.mvptemplate.domain.interactors.QuestionUseCase;
import com.nwise.mvptemplate.domain.models.ListWrapper;
import com.nwise.mvptemplate.domain.models.Question;
import com.nwise.mvptemplate.ui.base.BasePresenter;
import io.reactivex.observers.DisposableSingleObserver;
import javax.inject.Inject;

/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */
public class MainPresenter extends BasePresenter<MainViewInterface> {

    private QuestionUseCase questionUseCase;
    private AnswerUseCase answerUseCase;

    @Inject
    public MainPresenter(QuestionUseCase questionUseCase, AnswerUseCase answerUseCase) {

        this.questionUseCase = questionUseCase;
        this.answerUseCase = answerUseCase;
    }


    @Override
    public void onViewAttached(MainViewInterface view) {
        super.onViewAttached(view);
        getQuestions();
    }



    private void getQuestions() {
        questionUseCase.execute(null).subscribe(response -> {
            if (getView() != null)
                getView().onQuestionSucceed(response);
        }, e -> {
            Log.d("QuestionsCallback", "Code: " + e.getCause() + " Message: " + e.getMessage());
        });
    }

    DisposableSingleObserver<ListWrapper<Question>> questionObserver = new DisposableSingleObserver<ListWrapper<Question>>() {
        @Override
        public void onSuccess(ListWrapper<Question> questionListWrapper) {
            if (getView() != null)
                getView().onQuestionSucceed(questionListWrapper);
        }

        @Override
        public void onError(Throwable e) {
            Log.d("QuestionsCallback", "Code: " + e.getCause() + " Message: " + e.getMessage());
        }
    };


     void bindAnswers(String questionId) {
        answerUseCase.execute(questionId).subscribe(response -> {
            if (getView() != null && response != null)
                getView().onAnswerSucceed(response);
        }, e -> {
            Log.d("QuestionsCallback", "Code: " + e.getCause() + " Message: " + e.getMessage());
        });
    }





}
