package com.jiahaoliuliu.dialogfragmentstransition;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements FirstScreenFragment.ISecondFragmentRequestListener {

    private static final String TAG = "MainActivity";

    private Button mShowDialogFragmentsButton;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init the variables
        mFragmentManager = getFragmentManager();

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
                .add(R.id.fragment_container_frame_layout, new FirstScreenFragment(), "firstFragment")
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onSecondFragmentRequested() {
        mFragmentManager.beginTransaction()
                .setCustomAnimations(
                        R.animator.slide_in,
                        0,
                        R.animator.slide_out,
                        0)
                .replace(R.id.fragment_container_frame_layout, new SecondFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onBackPressed() {
        // If the back stack of the fragments exists, use it.
        Fragment fragment = getFragmentManager().findFragmentByTag("firstFragment");
        if (fragment != null) {
            getFragmentManager().popBackStack();
            return;
        }

        super.onBackPressed();
    }
}
