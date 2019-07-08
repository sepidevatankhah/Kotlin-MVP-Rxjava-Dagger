package com.nwise.mvptemplate.domain.interactors.base
import com.nwise.mvptemplate.domain.executer.PostExecutionThread
import com.nwise.mvptemplate.domain.executer.UseCaseExecutor
import com.nwise.mvptemplate.network.Repository
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
abstract class ObservableUseCase<Responses, Params>(
    useCaseExecutor: UseCaseExecutor,
    postExecutionThread: PostExecutionThread,
    protected var apiRepository: Repository
) :
    UseCase<Observable<Responses>, Params>(useCaseExecutor, postExecutionThread) {

    open fun execute(params: Params?): Observable<Responses> {
        return interact(params).applySchedulers()
    }

    protected abstract fun interact(params: Params?): Observable<Responses>

}
