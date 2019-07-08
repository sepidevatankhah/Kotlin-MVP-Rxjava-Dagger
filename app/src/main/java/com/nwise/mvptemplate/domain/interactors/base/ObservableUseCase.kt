package com.hamrah.sun.sunpayment.domain.interactor.base

import com.nwise.mvptemplate.domain.executer.PostExecutionThread
import com.nwise.mvptemplate.domain.executer.UseCaseExecutor
import com.nwise.mvptemplate.network.Repository
import io.reactivex.Flowable
import io.reactivex.Observable


abstract class ObservableUseCase<Responses, Params>(
    useCaseExecutor: UseCaseExecutor,
    postExecutionThread: PostExecutionThread,
    protected var apiRepository: Repository
) :
    UseCase<Observable<Responses>, Params>(useCaseExecutor, postExecutionThread) {

    open fun execute(params: Params?): Flowable<Responses> {
        return interact(params).applySchedulers()
    }

    protected abstract fun interact(params: Params?): Flowable<Responses>

}
