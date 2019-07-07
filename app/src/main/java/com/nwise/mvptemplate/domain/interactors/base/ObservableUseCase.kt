package com.hamrah.sun.sunpayment.domain.interactor.base

import com.hamrah.sun.sunpayment.domain.executer.PostExecutionThread
import com.hamrah.sun.sunpayment.domain.executer.UseCaseExecutor
import com.hamrah.sun.sunpayment.network.Repository
import io.reactivex.Observable

/**
 * Created by Suntech on 9/23/2017.
 */

abstract class ObservableUseCase<Responses, Params>(useCaseExecutor: UseCaseExecutor,
                                                    postExecutionThread: PostExecutionThread,
                                                    protected var apiRepository: Repository) :
        UseCase<Observable<Responses>, Params>(useCaseExecutor, postExecutionThread) {

    open fun execute(params: Params?): Observable<Responses> {
        return interact(params).applySchedulers()
    }

    protected abstract fun interact(params: Params?): Observable<Responses>

}
