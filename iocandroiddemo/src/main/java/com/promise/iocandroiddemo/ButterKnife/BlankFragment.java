package com.promise.iocandroiddemo.ButterKnife;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.promise.iocandroiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


    @BindView(R.id.button)
    Button mButton;
    @BindView(R.id.checkBox)
    CheckBox mCheckBox;
    @BindView(R.id.radioButton)
    RadioButton mRadioButton;
    @BindView(R.id.spinner)
    Spinner mSpinner;
    @BindView(R.id.ratingBar)
    RatingBar mRatingBar;
    @BindView(R.id.textView)
    TextView mTextView;
    @BindView(R.id.editText)
    EditText mEditText;
    @BindView(R.id.imageView2)
    ImageView mImageView2;
    Unbinder unbinder;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //unbinder.unbind();
    }

    @OnClick({R.id.button, R.id.checkBox, R.id.radioButton})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button:
                Toast.makeText(getActivity(),"button----",Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkBox:
                Toast.makeText(getActivity(),"checkBox----",Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioButton:
                Toast.makeText(getActivity(),"radioButton----",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
