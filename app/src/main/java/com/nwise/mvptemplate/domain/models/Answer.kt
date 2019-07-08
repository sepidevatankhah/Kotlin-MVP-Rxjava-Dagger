package com.nwise.mvptemplate.domain.models

import com.google.gson.annotations.SerializedName

/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */
class Answer {
    @SerializedName("answer_id")
    var answerId: Int = 0

    @SerializedName("is_accepted")
    var accepted: Boolean = false

    var score: Int = 0

    @SerializedName("owner")
    var owner: Owner? = null

    override fun toString(): String {
        return answerId.toString() + " - Score: " + score + " - Accepted: " + if (accepted) "Yes" else "No"
    }
}
