package hram.githubtrending.selecttimespan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import hram.githubtrending.R;

/**
 * @author Evgeny Khramov
 */

public class SelectTimeSpanActivity extends AppCompatActivity {

    public static void start(@NonNull Context context) {
        context.startActivity(new Intent(context, SelectTimeSpanActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_select_time_span);
    }
}
