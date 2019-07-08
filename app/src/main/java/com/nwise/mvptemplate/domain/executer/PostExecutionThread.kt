package com.nwise.mvptemplate.domain.executer;

import io.reactivex.Scheduler

/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */
interface PostExecutionThread
{
    val scheduler: Scheduler
}