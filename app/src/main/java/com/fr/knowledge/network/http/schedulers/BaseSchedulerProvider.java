package com.fr.knowledge.network.http.schedulers;

import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;

public interface BaseSchedulerProvider {

    Scheduler computation();

    Scheduler io();

    Scheduler ui();

    <T> ObservableTransformer<T, T> applySchedulers();
}
