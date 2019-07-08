package com.hamrah.sun.sunpayment.domain.interactor.base

import com.nwise.mvptemplate.domain.executer.PostExecutionThread
import com.nwise.mvptemplate.domain.executer.UseCaseExecutor
import com.nwise.mvptemplate.network.Repository
import io.reactivex.Flowable
import io.reactivex.Observable

/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */
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
