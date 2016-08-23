package com.jiahaoliuliu.dialogfragmentstransition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Button mShowDialogFragmentsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link the views
        mShowDialogFragmentsButton = (Button) findViewById(R.id.show_dialogs_button);
        mShowDialogFragmentsButton.setOnClickListener(mOnClickListener);
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.show_dialogs_button:
                    showDialogs();
                    break;
            }
        }
    };

    private void showDialogs() {
        Log.v(TAG, "Showing dialogs");
    }
}
