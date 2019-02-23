package com.practice.olegtojgildin.unittestpractice_meet_20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.practice.olegtojgildin.unittestpractice_meet_20.db.DBManager;

public class MainActivity extends AppCompatActivity {

    private DBManager mDBManager = DBManager.getInstance(this);
    public TextView mResultTextView;
    private int res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        res = Calculator.calculate(getLastResult(), 9, Operators.ADD);
        saveResult(res);
        res = Calculator.calculate(getLastResult(), 3, Operators.MULTIPLY);
        saveResult(res);

        updateUI();
    }

    public void initView() {
        mResultTextView = findViewById(R.id.result);
    }

    private void updateUI() {
        mResultTextView.setText(String.valueOf(res));
    }
    private int getLastResult() {
        return mDBManager.getResult();
    }

    private void saveResult(final int result) {
        mDBManager.saveResult(result);
    }
}
