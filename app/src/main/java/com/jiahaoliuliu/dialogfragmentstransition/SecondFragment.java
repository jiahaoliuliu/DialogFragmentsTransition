package com.jiahaoliuliu.dialogfragmentstransition;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {

    private Button mBackButton;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layoutView = inflater.inflate(R.layout.fragment_second, container, false);
        mBackButton = (Button) layoutView.findViewById(R.id.back_button);
        mBackButton.setOnClickListener(mOnClickListener);
        return layoutView;
    }

    View.OnClickListener mOnClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.back_button:
                    getActivity().onBackPressed();
                    break;
            }
        }
    };
}
