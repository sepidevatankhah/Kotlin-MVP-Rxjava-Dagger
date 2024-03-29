package com.nwise.mvptemplate.domain.interactors.base

import com.nwise.mvptemplate.domain.executer.PostExecutionThread
import com.nwise.mvptemplate.domain.executer.UseCaseExecutor
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Scheduler

/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */

/**
 * Each `UseCase` of the system orchestrate the flow of data to and from the entities.
 *
 *
 * Outer layers of system can execute use cases by calling [.execute]} method.
 * ALso you can use [.useCaseExecutor] to execute the job in a background thread and [.postExecutionThread]
 * to post the result to another thread(UI thread).

 * @param <Params> The response value of a use case.
 * *
</Params> */
abstract class UseCase<Responses, Params>(val useCaseExecutor: UseCaseExecutor,
                                          val postExecutionThread: PostExecutionThread
) {

    fun getUseCaseExecutor(): Scheduler {
        return useCaseExecutor.scheduler
    }

    fun getPostExecutionThread(): Scheduler {
        return postExecutionThread.scheduler
    }

    fun <T> Observable<T>.applySchedulers(): Observable<T> {
        return subscribeOn(getUseCaseExecutor()).observeOn(getPostExecutionThread())
    }

    fun <T> Flowable<T>.applySchedulers(): Flowable<T> {
        return subscribeOn(getUseCaseExecutor()).observeOn(getPostExecutionThread())
    }
}