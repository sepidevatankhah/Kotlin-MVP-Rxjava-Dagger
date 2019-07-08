package com.nwise.sunshine.ui.main;

import com.nwise.sunshine.network.model.Answer;
import com.nwise.sunshine.network.model.ListWrapper;
import com.nwise.sunshine.network.model.Question;

public interface MainViewInterface {

    void onQuestionSucceed(ListWrapper<Question> questions);
    void onAnswerSucceed(ListWrapper<Answer> questions);
    void onFailed();
}
