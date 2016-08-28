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
                .setCustomAnimations(
                        R.animator.slide_in,
                        R.animator.slide_out,
                        R.animator.slide_in,
                        R.animator.slide_out)
                .replace(R.id.fragment_container_frame_layout, new FirstScreenFragment())
                .commit();
    }

    @Override
    public void onSecondFragmentRequested() {
        mFragmentManager.beginTransaction()
                .setCustomAnimations(
                        R.animator.slide_in,
                        R.animator.quite)
                .replace(R.id.fragment_container_frame_layout, new SecondFragment(), "secondFragment")
//                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onBackPressed() {
        // If the back stack of the fragments exists, use it.
        Fragment fragment = getFragmentManager().findFragmentByTag("secondFragment");
        if (fragment != null) {
            // Replace the previous fragment
            mFragmentManager.beginTransaction()
                    .setCustomAnimations(
                            R.animator.quite,
                            R.animator.slide_out)
                    .replace(R.id.fragment_container_frame_layout, new FirstScreenFragment())
                    .commit();
            return;
        }

        super.onBackPressed();
    }
}
