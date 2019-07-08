package com.nwise.mvptemplate.domain.executer

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */
class NetworkJobExecutor : UseCaseExecutor {

    override val scheduler: Scheduler
        get() = Schedulers.io()
}
