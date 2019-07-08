package com.nwise.sunshine.domain.interactor

import com.hamrah.sun.sunpayment.domain.interactor.base.ObservableUseCase
import com.nwise.sunshine.domain.executer.PostExecutionThread
import com.nwise.sunshine.domain.executer.UseCaseExecutor
import com.nwise.sunshine.network.model.ListWrapper
import com.nwise.sunshine.network.model.Question
import com.nwise.sunshine.network.repository.Repository
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject

class QuestionUseCase @Inject constructor(useCaseExecutor: UseCaseExecutor,
                                         postExecutionThread: PostExecutionThread,
                                         apiRepository: Repository) : ObservableUseCase< ListWrapper<Question>, Question>(useCaseExecutor, postExecutionThread, apiRepository) {
    override fun interact(params: Question?): Flowable<ListWrapper<Question>> {
        return apiRepository.getQuestionss()
    }
}