package com.hamrah.sun.sunpayment.domain.executer

import io.reactivex.Scheduler

/**
 * Created by Suntech on 9/23/2017.
 */
interface PostExecutionThread
{
    val scheduler: Scheduler
}