package com.nwise.mvptemplate.network;

import com.nwise.mvptemplate.domain.models.Answer;
import com.nwise.mvptemplate.domain.models.ListWrapper;
import com.nwise.mvptemplate.domain.models.Question;
import io.reactivex.Flowable;
import retrofit2.Retrofit;
import javax.inject.Inject;

/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */
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
