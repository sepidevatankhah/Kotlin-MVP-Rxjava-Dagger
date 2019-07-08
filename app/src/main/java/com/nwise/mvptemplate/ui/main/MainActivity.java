package com.nwise.mvptemplate.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.nwise.mvptemplate.R;
import com.nwise.mvptemplate.di.components.ActivityComponent;
import com.nwise.mvptemplate.domain.models.Answer;
import com.nwise.mvptemplate.domain.models.ListWrapper;
import com.nwise.mvptemplate.domain.models.Question;
import com.nwise.mvptemplate.ui.base.BaseActivity;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity<MainPresenter> implements MainViewInterface {


    private String token;

    private Button authenticateButton;

    private Spinner questionsSpinner;
    private RecyclerView recyclerView;

    @Override
    protected void injectDependencies(ActivityComponent component) {
        component.inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionsSpinner = (Spinner) findViewById(R.id.questions_spinner);

        questionsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Spinner item selected", Toast.LENGTH_LONG).show();
                Question question = (Question) parent.getAdapter().getItem(position);
                presenter.bindAnswers(question.questionId);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        authenticateButton = (Button) findViewById(R.id.authenticate_button);

        recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


    }


    Callback<ResponseBody> upvoteCallback = new Callback<ResponseBody>() {
        @Override
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            if (response.isSuccessful()) {
                Toast.makeText(MainActivity.this, "Upvote successful", Toast.LENGTH_LONG).show();
            } else {
                Log.d("QuestionsCallback", "Code: " + response.code() + " Message: " + response.message());
                Toast.makeText(MainActivity.this, "You already upvoted this answer", Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onFailure(Call<ResponseBody> call, Throwable t) {
            t.printStackTrace();
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        if (token != null) {
            authenticateButton.setEnabled(false);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == 1) {
            token = data.getStringExtra("token");
        }
    }

    @Override
    public void onQuestionSucceed(ListWrapper<Question> questions) {
        ArrayAdapter<Question> arrayAdapter = new ArrayAdapter<Question>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, questions.items);
        questionsSpinner.setAdapter(arrayAdapter);
    }

    @Override
    public void onAnswerSucceed(ListWrapper<Answer> answers) {
        recyclerView.setAdapter(new RecyclerViewAdapter(answers , getApplicationContext()));
    }

    @Override
    public void onFailed() {

    }
}



