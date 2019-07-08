package com.nwise.mvptemplate.domain.interactors.base

import com.hamrah.sun.sunpayment.domain.interactor.base.UseCase
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

/**
 * @param <Responses> The response value emitted by the Observable.
 * *
 * @param <Params> The request value.
 * * @author S.Vatankhah
</Params></Responses> */
abstract class FlowableUseCase<Responses, Params> constructor(private val threadExecutor: UseCaseExecutor,
                                                              postExecutionThread: PostExecutionThread,
                                                              protected var apiRepository: Repository
) :
        UseCase<Observable<Responses>, Params>(threadExecutor, postExecutionThread) {




    open fun execute(params: Params? = null): Flowable<Responses> {
       return interact(params).applySchedulers()
    }

    protected abstract fun interact(params: Params?): Flowable<Responses>



}
