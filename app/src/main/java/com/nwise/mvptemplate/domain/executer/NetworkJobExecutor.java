package com.nwise.mvptemplate.domain.executer;


import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;


public class NetworkJobExecutor implements UseCaseExecutor {

    @Override
    public Scheduler getScheduler() {
        return Schedulers.io();
    }
}
