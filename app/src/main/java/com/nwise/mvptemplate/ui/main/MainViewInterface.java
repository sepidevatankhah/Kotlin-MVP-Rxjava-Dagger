package com.nwise.mvptemplate.ui.main;


import com.nwise.mvptemplate.domain.models.Answer;
import com.nwise.mvptemplate.domain.models.ListWrapper;
import com.nwise.mvptemplate.domain.models.Question;

public interface MainViewInterface {

    void onQuestionSucceed(ListWrapper<Question> questions);
    void onAnswerSucceed(ListWrapper<Answer> questions);
    void onFailed();
}
