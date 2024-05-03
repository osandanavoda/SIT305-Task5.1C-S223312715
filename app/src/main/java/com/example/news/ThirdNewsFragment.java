package com.example.news;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class ThirdNewsFragment extends Fragment {
    private ImageButton BackButton3,relatedstory3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_third_news, container, false);
        BackButton3=(ImageButton) view.findViewById(R.id.Back3);
        BackButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).handleImageButtonClick();
            }
        });
        relatedstory3=(ImageButton) view.findViewById(R.id.RelatedStory3);
        relatedstory3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager= getParentFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView,FourthNewsFragment.class,null)
                        .setReorderingAllowed(true)
                        .commit();
            }
        });

        return view;
    }
}