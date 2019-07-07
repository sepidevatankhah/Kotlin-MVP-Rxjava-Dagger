package com.nwise.sunshine.network.model;

import com.google.gson.annotations.SerializedName;

public class Answer {
    @SerializedName("answer_id")
    public int answerId;

    @SerializedName("is_accepted")
    public boolean accepted;

    public int score;

    @SerializedName("owner")
    public Owner owner;

    @Override
    public String toString() {
        return answerId + " - Score: " + score + " - Accepted: " + (accepted ? "Yes" : "No");
    }
}
