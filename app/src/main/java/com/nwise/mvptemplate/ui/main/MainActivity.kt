package com.nwise.mvptemplate.ui.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.*
import com.nwise.mvptemplate.R
import com.nwise.mvptemplate.di.components.ActivityComponent
import com.nwise.mvptemplate.domain.models.Answer
import com.nwise.mvptemplate.domain.models.ListWrapper
import com.nwise.mvptemplate.domain.models.Question
import com.nwise.mvptemplate.ui.base.BaseActivity

/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */
 class MainActivity : BaseActivity<MainPresenter , MainViewInterface>(), MainViewInterface {


    private var questionsSpinner: Spinner? = null
    private var recyclerView: RecyclerView? = null

    override fun injectDependencies(component: ActivityComponent) {
        component.inject(this)
    }

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionsSpinner = findViewById<View>(R.id.questions_spinner) as Spinner

        questionsSpinner!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                Toast.makeText(this@MainActivity, "Spinner item selected", Toast.LENGTH_LONG).show()
                val question = parent.adapter.getItem(position) as Question
                question.questionId?.let { presenter!!.bindAnswers(it) }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

        recyclerView = findViewById<RecyclerView>(R.id.list)
        recyclerView!!.setHasFixedSize(true)
        recyclerView!!.layoutManager = LinearLayoutManager(getApplicationContext())


    }

    override fun onQuestionSucceed(questions: ListWrapper<Question>) {
        val arrayAdapter =
            ArrayAdapter(applicationContext, android.R.layout.simple_spinner_dropdown_item, questions.items!!)
        questionsSpinner!!.adapter = arrayAdapter
    }

    override fun onAnswerSucceed(answers: ListWrapper<Answer>) {
        recyclerView!!.adapter = RecyclerViewAdapter(answers, applicationContext)
    }

    override fun onFailed() {

    }
}



