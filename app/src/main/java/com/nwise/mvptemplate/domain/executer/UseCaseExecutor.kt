package com.hamrah.sun.sunpayment.domain.executer

import io.reactivex.Scheduler

/**
 * Created by Suntech on 9/18/2017.
 */
interface UseCaseExecutor
{
    val scheduler: Scheduler
}