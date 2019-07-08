package com.nwise.mvptemplate.network;

import com.nwise.mvptemplate.domain.models.Answer;
import com.nwise.mvptemplate.domain.models.ListWrapper;
import com.nwise.mvptemplate.domain.models.Question;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AppApi {

    String BASE_URL = "https://api.stackexchange.com";

    @GET("/2.2/questions?order=desc&sort=votes&site=stackoverflow&tagged=android&filter=withbody")
    Flowable<ListWrapper<Question>> getQuestions();

    @GET("/2.2/questions/{id}/answers?order=desc&sort=votes&site=stackoverflow")
    Flowable<ListWrapper<Answer>> getAnswersForQuestion(@Path("id") String questionId);
}
