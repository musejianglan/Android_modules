package com.musejianglan.app4md.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.musejianglan.app4md.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThemeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThemeFragment extends Fragment {

    RecyclerView recyclerview;



    public ThemeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment ThemeFragment.
     */
    public static ThemeFragment newInstance() {
        ThemeFragment fragment = new ThemeFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_theme, container, false);


        recyclerview = view.findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview.setAdapter(new ThemeRecyclerAdapter(getActivity()));

        return view;
    }

}
