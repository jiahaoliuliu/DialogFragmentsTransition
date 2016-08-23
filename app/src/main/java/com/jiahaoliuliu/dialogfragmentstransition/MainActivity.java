package com.jiahaoliuliu.dialogfragmentstransition;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Button mShowDialogFragmentsButton;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init the variables
        mFragmentManager = getSupportFragmentManager();

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
        mFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_frame_layout, new FirstScreenDialogFragment()).commit();
    }
}
