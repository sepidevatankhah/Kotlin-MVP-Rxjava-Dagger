package com.nwise.mvptemplate.domain.executer;

import io.reactivex.Scheduler

interface UseCaseExecutor
{
    val scheduler: Scheduler
}