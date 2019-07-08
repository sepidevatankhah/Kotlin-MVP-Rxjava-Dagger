package com.nwise.mvptemplate.domain.interactors
import com.nwise.mvptemplate.domain.executer.PostExecutionThread
import com.nwise.mvptemplate.domain.executer.UseCaseExecutor
import com.nwise.mvptemplate.domain.interactors.base.FlowableUseCase
import com.nwise.mvptemplate.domain.models.ListWrapper
import com.nwise.mvptemplate.domain.models.Question
import com.nwise.mvptemplate.network.Repository
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */
class QuestionUseCase @Inject constructor(useCaseExecutor: UseCaseExecutor,
                                          postExecutionThread: PostExecutionThread,
                                          apiRepository: Repository
) : FlowableUseCase<ListWrapper<Question>, Question>(useCaseExecutor, postExecutionThread, apiRepository) {
    override fun interact(params: Question?): Flowable<ListWrapper<Question>> {
        return apiRepository.questions
    }
}