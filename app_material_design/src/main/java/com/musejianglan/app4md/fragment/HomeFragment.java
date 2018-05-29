package com.musejianglan.app4md.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.musejianglan.app4md.R;
import com.musejianglan.app4md.activity.ConstraintLayoutActivity;
import com.musejianglan.app4md.activity.bnv.BNVListActivity;
import com.musejianglan.app4md.activity.tab.TabListActivity;
import com.musejianglan.app4md.constraintLayout.GuidelinesActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    FloatingActionButton fab;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment HomeFragment.
     */
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_home, container, false);
        fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(view, "11111", Snackbar.LENGTH_SHORT).setAction("action", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), "点击", Toast.LENGTH_SHORT).show();
                    }
                });
                View snackbarView = snackbar.getView();
                if (snackbarView != null) {
                    snackbarView.setBackgroundColor(getResources().getColor(R.color.primary_light));
                }
                snackbar.show();
            }
        });

        Button tablayout = view.findViewById(R.id.tablayout);
        Button bnv = view.findViewById(R.id.bottom_nav);
        Button constraintLayout = view.findViewById(R.id.constraintLayout);
        Button guidelines = view.findViewById(R.id.guidelines);
        tablayout.setOnClickListener(this);
        bnv.setOnClickListener(this);
        constraintLayout.setOnClickListener(this);
        guidelines.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tablayout:
                startActivity(new Intent(getActivity(),TabListActivity.class));
                break;
            case R.id.bottom_nav:
                startActivity(new Intent(getActivity(),BNVListActivity.class));
                break;
            case R.id.constraintLayout:
                startActivity(new Intent(getActivity(),ConstraintLayoutActivity.class));
                break;
            case R.id.guidelines:
                startActivity(new Intent(getActivity(),GuidelinesActivity.class));
                break;

        }
    }
}
