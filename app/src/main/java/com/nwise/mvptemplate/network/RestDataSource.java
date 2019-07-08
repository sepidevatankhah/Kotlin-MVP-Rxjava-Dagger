package com.nwise.mvptemplate.network;

import com.nwise.mvptemplate.domain.models.Answer;
import com.nwise.mvptemplate.domain.models.ListWrapper;
import com.nwise.mvptemplate.domain.models.Question;
import io.reactivex.Flowable;
import retrofit2.Retrofit;

import javax.inject.Inject;

public class RestDataSource implements Repository {

    @Inject
    public RestDataSource(Retrofit retrofit) {
        restApi = retrofit.create(AppApi.class);
    }

    public AppApi restApi;

    @Override
    public Flowable<ListWrapper<Question>> getQuestions() {
        return restApi.getQuestions();
    }

    @Override
    public Flowable<ListWrapper<Answer>> getAnswersForQuestion(String questionId) {
        return restApi.getAnswersForQuestion(questionId);
    }

}
