package com.example.news;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class FourthNewsFragment extends Fragment {
    private ImageButton BackButton4,relatedstory4;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_fourth_news, container, false);
        BackButton4=(ImageButton) view.findViewById(R.id.Back4);
        BackButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).handleImageButtonClick();
            }
        });
        relatedstory4=(ImageButton) view.findViewById(R.id.RelatedStory4);
        relatedstory4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager= getParentFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView,FirstNewsFragment.class,null)
                        .setReorderingAllowed(true)
                        .commit();
            }
        });

        return view;
    }
}