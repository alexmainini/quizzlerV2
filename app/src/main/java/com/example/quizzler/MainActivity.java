package com.example.quizzler;

import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button mTrueButton;
    Button mFalseButton;
    boolean risposta;
    int mPunteggio = 0;
    int mIndex = 0;
    private static final String TAG = "MainActivity";
    TextView mQuestionTextView;
    TextView mScoreTextView;
    ProgressBar mProgressBar;
    private TrueFalse[] mQuestionBank = new TrueFalse[] {
        new TrueFalse(R.string.question_1, true),
        new TrueFalse(R.string.question_2, true),
        new TrueFalse(R.string.question_3, true),
        new TrueFalse(R.string.question_4, true),
        new TrueFalse(R.string.question_5, true),
        new TrueFalse(R.string.question_6, false),
        new TrueFalse(R.string.question_7, true),
        new TrueFalse(R.string.question_8, false),
        new TrueFalse(R.string.question_9, true),
        new TrueFalse(R.string.question_10, true),
        new TrueFalse(R.string.question_11, false),
        new TrueFalse(R.string.question_12, false),
        new TrueFalse(R.string.question_13,true)
    };
    final int PROGRESS_BAR_INCREMENT = (int) Math.ceil(100.0 / mQuestionBank.length);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        mTrueButton = findViewById(R.id.true_button);
        mFalseButton = findViewById(R.id.false_button);
        mQuestionTextView = findViewById(R.id.question_text_view);
        mScoreTextView = findViewById(R.id.score);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"True Button Clicked");
                Toast toast = Toast.makeText(getApplicationContext(), "True Pressed", Toast.LENGTH_SHORT);
                toast.show();
                risposta = true;
                if(risposta == mQuestionBank[mIndex].isnAnswer() && mIndex < 12) {
                    mPunteggio++;
                }
                mIndex++;
                mQuestionTextView.setText(mQuestionBank[mIndex].getnQuestionsID());
                mScoreTextView.setText("score: "+mPunteggio +"/13");
                mProgressBar.incrementProgressBy(PROGRESS_BAR_INCREMENT);
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"False Button Clicked");
                Toast toast = Toast.makeText(getApplicationContext(), "False Pressed", Toast.LENGTH_SHORT);
                toast.show();
                risposta = false;
                if(risposta == mQuestionBank[mIndex].isnAnswer() && mIndex < 13) {
                    mPunteggio++;
                }
                mIndex++;
                mQuestionTextView.setText(mQuestionBank[mIndex].getnQuestionsID());
                mScoreTextView.setText("score: "+mPunteggio +"/13");
                mProgressBar.incrementProgressBy(PROGRESS_BAR_INCREMENT);
            }
        });
        TrueFalse exampleQuestion = new TrueFalse(R.string.question_1, false);
    }
}