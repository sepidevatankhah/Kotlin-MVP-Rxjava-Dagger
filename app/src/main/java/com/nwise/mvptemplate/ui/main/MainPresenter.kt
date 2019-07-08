package com.nwise.mvptemplate.ui.main

import android.util.Log
import com.nwise.mvptemplate.domain.interactors.AnswerUseCase
import com.nwise.mvptemplate.domain.interactors.QuestionUseCase
import com.nwise.mvptemplate.domain.models.ListWrapper
import com.nwise.mvptemplate.domain.models.Question
import com.nwise.mvptemplate.ui.base.BasePresenter
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */
class MainPresenter @Inject
constructor(private val questionUseCase: QuestionUseCase, private val answerUseCase: AnswerUseCase) :
    BasePresenter<MainViewInterface>() {

    internal var questionObserver: DisposableSingleObserver<ListWrapper<Question>> =
        object : DisposableSingleObserver<ListWrapper<Question>>() {
            override fun onSuccess(questionListWrapper: ListWrapper<Question>) {
                if (getView() != null)
                    getView()!!.onQuestionSucceed(questionListWrapper)
            }

            override fun onError(e: Throwable) {
                Log.d("QuestionsCallback", "Code: " + e.cause + " Message: " + e.message)
            }
        }


    override fun onViewAttached(view: MainViewInterface) {
        super.onViewAttached(view)
        getQuestions()
    }


    private fun getQuestions() {
        questionUseCase.execute(null).subscribe({ response ->
            if (getView() != null)
                getView()!!.onQuestionSucceed(response)
        }, { e -> Log.d("QuestionsCallback", "Code: " + e.cause + " Message: " + e.message) })
    }


    internal fun bindAnswers(questionId: String) {
        answerUseCase.execute(questionId).subscribe({ response ->
            if (getView() != null && response != null)
                getView()!!.onAnswerSucceed(response)
        }, { e -> Log.d("QuestionsCallback", "Code: " + e.cause + " Message: " + e.message) })
    }


}
