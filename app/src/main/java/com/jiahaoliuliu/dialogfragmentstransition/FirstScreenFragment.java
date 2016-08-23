package com.jiahaoliuliu.dialogfragmentstransition;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstScreenFragment extends Fragment {

    private static final String TAG = "FirstScreenFragment";

    private Button mShowSecondFragmentButton;
    private ISecondFragmentRequestListener mSecondFragmentRequestListener;

    public FirstScreenFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mSecondFragmentRequestListener = (ISecondFragmentRequestListener) context;
        } catch (ClassCastException classCastException) {
            throw new ClassCastException("The attached class must implements ISecondFragmentRequestListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layoutView = inflater.inflate(R.layout.fragment_first_screen_dialog, container, false);
        mShowSecondFragmentButton = (Button) layoutView.findViewById(R.id.show_second_fragment_button);
        mShowSecondFragmentButton.setOnClickListener(mOnClickListener);

        return layoutView;
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.show_second_fragment_button:
                    showSecondFragment();
                    break;
            }
        }
    };

    private void showSecondFragment() {
        Log.v(TAG, "Showing the second fragment");
        // TODO: Add transition
        mSecondFragmentRequestListener.onSecondFragmentRequested();
    }

    /**
     * Interface used to request the second fragment
     */
    public interface ISecondFragmentRequestListener {

        void onSecondFragmentRequested();
    }
}
