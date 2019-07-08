package com.hamrah.sun.sunpayment.domain.interactor.base

import com.hamrah.sun.sunpayment.domain.executer.PostExecutionThread
import com.hamrah.sun.sunpayment.domain.executer.UseCaseExecutor
import com.hamrah.sun.sunpayment.network.Repository
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


/**
 * @param <Responses> The response value emitted by the Observable.
 * *
 * @param <Params> The request value.
 * * @author S.Vatankhah
</Params></Responses> */
abstract class FlowableUseCase<Responses, Params> constructor(private val threadExecutor: UseCaseExecutor,
                                                              postExecutionThread: PostExecutionThread,
                                                              protected var apiRepository: Repository) :
        UseCase<Observable<Responses>, Params>(threadExecutor, postExecutionThread) {


    private val disposables = CompositeDisposable()


    open fun execute(params: Params? = null): Flowable<Responses> {
       return interact(params).applySchedulers()
    }

    protected abstract fun interact(params: Params?): Flowable<Responses>

    /**
     * Dispose from current [CompositeDisposable].
     */
    fun dispose() {
        if (!disposables.isDisposed) disposables.dispose()
    }

    /**
     * Dispose from current [CompositeDisposable].
     */
    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

}
