package com.nwise.mvptemplate.domain.models

import com.google.gson.annotations.SerializedName

/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */
class Question {


    var title: String? = null
    var body: String? = null


    @SerializedName("question_id")
    var questionId: String? = null

    override fun toString(): String {
        return title!!
    }
}
