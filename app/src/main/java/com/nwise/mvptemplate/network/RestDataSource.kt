package com.nwise.mvptemplate.network

import com.nwise.mvptemplate.domain.models.Answer
import com.nwise.mvptemplate.domain.models.ListWrapper
import com.nwise.mvptemplate.domain.models.Question
import io.reactivex.Flowable
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */
class RestDataSource @Inject
constructor(retrofit: Retrofit) : Repository {

    var restApi: AppApi = retrofit.create(AppApi::class.java)

    override val questions: Flowable<ListWrapper<Question>>
        get() = restApi.questions

    override fun getAnswersForQuestion(questionId: String): Flowable<ListWrapper<Answer>> {
        return restApi.getAnswersForQuestion(questionId)
    }

}
