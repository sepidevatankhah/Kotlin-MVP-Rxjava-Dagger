package com.nwise.mvptemplate.ui.main;

import android.util.Log;
import com.nwise.mvptemplate.domain.interactors.AnswerUseCase;
import com.nwise.mvptemplate.domain.interactors.QuestionUseCase;
import com.nwise.mvptemplate.domain.models.Answer;
import com.nwise.mvptemplate.domain.models.ListWrapper;
import com.nwise.mvptemplate.domain.models.Question;
import com.nwise.mvptemplate.ui.base.BasePresenter;
import io.reactivex.observers.DisposableSingleObserver;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.inject.Inject;

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

    @Override
    protected void onViewAttachedForFirstTime(MainViewInterface view) {
        super.onViewAttachedForFirstTime(view);

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

    Callback<ListWrapper<Question>> questionsCallback = new Callback<ListWrapper<Question>>() {
        @Override
        public void onResponse(Call<ListWrapper<Question>> call, Response<ListWrapper<Question>> response) {
            if (response.isSuccessful()) {
                ListWrapper<Question> questions = response.body();
                getView().onQuestionSucceed(questions);
            } else {
                Log.d("QuestionsCallback", "Code: " + response.code() + " Message: " + response.message());
            }
        }

        @Override
        public void onFailure(Call<ListWrapper<Question>> call, Throwable t) {
            t.printStackTrace();
        }
    };

    Callback<ListWrapper<Answer>> answersCallback = new Callback<ListWrapper<Answer>>() {
        @Override
        public void onResponse(Call<ListWrapper<Answer>> call, Response<ListWrapper<Answer>> response) {
            if (response.isSuccessful()) {
                ListWrapper<Answer> answers = response.body();
                getView().onAnswerSucceed(answers);
            } else {
                Log.d("QuestionsCallback", "Code: " + response.code() + " Message: " + response.message());
            }
        }

        @Override
        public void onFailure(Call<ListWrapper<Answer>> call, Throwable t) {
            t.printStackTrace();
        }
    };

}
