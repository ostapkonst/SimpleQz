package com.android.smplqz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.github.lzyzsd.circleprogress.DonutProgress;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        {
            DonutProgress dnPrgr = (DonutProgress) findViewById(R.id.donutProgress);
            dnPrgr.setProgress((int) ((double) QuizResult.getDone() / QuizResult.getCount() * 100));
        }

        {
            String stats;
            stats = Integer.toString(QuizResult.getDone());
            ((TextView) findViewById(R.id.fDone)).setText(stats);
            stats = Integer.toString(QuizResult.getFailed());
            ((TextView) findViewById(R.id.fFailed)).setText(stats);
            stats = Integer.toString(QuizResult.getSkipped());
            ((TextView) findViewById(R.id.fSkipped)).setText(stats);
        }

        {
            TextView tv;

            for (int i = 1; i <= QuizResult.getCount(); i++) {
                switch (QuizResult.getState(i - 1)) {
                    case DONE:
                        tv = ((TextView) findViewById(R.id.fieldDone));
                        tv.setText(tv.getText() + " " + Integer.toString(i));
                        break;
                    case FAILED:
                        tv = ((TextView) findViewById(R.id.fieldFailed));
                        tv.setText(tv.getText() + " " + Integer.toString(i));
                        break;
                    case SKIPPED:
                        tv = ((TextView) findViewById(R.id.fieldSkipped));
                        tv.setText(tv.getText() + " " + Integer.toString(i));
                        break;
                }
            }
        }
    }
}
