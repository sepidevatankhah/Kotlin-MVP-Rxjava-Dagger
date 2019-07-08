package com.nwise.mvptemplate.ui.main

import com.nwise.mvptemplate.domain.models.Answer
import com.nwise.mvptemplate.domain.models.ListWrapper
import com.nwise.mvptemplate.domain.models.Question

/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */
interface MainViewInterface {

    fun onQuestionSucceed(questions: ListWrapper<Question>)
    fun onAnswerSucceed(questions: ListWrapper<Answer>)
    fun onFailed()
}
