package com.nwise.mvptemplate.domain.interactors

import com.hamrah.sun.sunpayment.domain.interactor.base.ObservableUseCase
import com.nwise.mvptemplate.domain.executer.PostExecutionThread
import com.nwise.mvptemplate.domain.executer.UseCaseExecutor
import com.nwise.mvptemplate.domain.models.Answer
import com.nwise.mvptemplate.domain.models.ListWrapper
import com.nwise.mvptemplate.domain.models.Question
import com.nwise.mvptemplate.network.Repository
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject

class AnswerUseCase @Inject constructor(
    useCaseExecutor: UseCaseExecutor,
    postExecutionThread: PostExecutionThread,
    apiRepository: Repository
) :
    ObservableUseCase<ListWrapper<Answer>, String>(useCaseExecutor, postExecutionThread, apiRepository) {
    override fun interact(params: String?): Flowable<ListWrapper<Answer>> {
        return apiRepository.getAnswersForQuestion(params)
    }
}