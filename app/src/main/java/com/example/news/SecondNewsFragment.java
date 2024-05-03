package com.example.news;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class SecondNewsFragment extends Fragment {
    private ImageButton BackButton2,relatedstory2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_second_news, container, false);
        BackButton2=(ImageButton) view.findViewById(R.id.Back2);
        BackButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).handleImageButtonClick();
            }
        });

        relatedstory2=(ImageButton) view.findViewById(R.id.RelatedStory2);
        relatedstory2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager= getParentFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView,ThirdNewsFragment.class,null)
                        .setReorderingAllowed(true)
                        .commit();
            }
        });

        return view;
    }
}