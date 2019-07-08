package com.nwise.mvptemplate.network;

import com.nwise.mvptemplate.domain.models.Answer;
import com.nwise.mvptemplate.domain.models.ListWrapper;
import com.nwise.mvptemplate.domain.models.Question;
import io.reactivex.Flowable;

public interface Repository {
    Flowable<ListWrapper<Question>> getQuestions();
    Flowable<ListWrapper<Answer>> getAnswersForQuestion(String questionId);
}
