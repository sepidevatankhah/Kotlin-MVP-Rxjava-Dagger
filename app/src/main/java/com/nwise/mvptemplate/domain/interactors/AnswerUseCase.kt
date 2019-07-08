package com.nwise.mvptemplate.domain.interactors

import com.hamrah.sun.sunpayment.domain.executer.PostExecutionThread
import com.hamrah.sun.sunpayment.domain.executer.UseCaseExecutor
import com.hamrah.sun.sunpayment.domain.interactor.base.ObservableUseCase
import com.nwise.mvptemplate.domain.models.ListWrapper
import com.nwise.mvptemplate.domain.models.Question
import com.nwise.mvptemplate.network.Repository
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject

class QuestionUseCase @Inject constructor(useCaseExecutor: UseCaseExecutor,
                                          postExecutionThread: PostExecutionThread,
                                          apiRepository: Repository
) : ObservableUseCase<ListWrapper<Question>, Question>(useCaseExecutor, postExecutionThread, apiRepository) {
    override fun interact(params: Question?): Flowable<ListWrapper<Question>> {
        return apiRepository.getQuestions()
    }
}