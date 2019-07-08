package com.nwise.mvptemplate.network

import com.nwise.mvptemplate.domain.models.Answer
import com.nwise.mvptemplate.domain.models.ListWrapper
import com.nwise.mvptemplate.domain.models.Question
import io.reactivex.Flowable

/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */
interface Repository {
    val questions: Flowable<ListWrapper<Question>>
    fun getAnswersForQuestion(questionId: String): Flowable<ListWrapper<Answer>>
}
