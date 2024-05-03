package com.example.news;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class FirstNewsFragment extends Fragment {
    private ImageButton BackButton1,relatedstory;
    private RecyclerView vertivcalOnly;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_first_news, container, false);

        BackButton1=(ImageButton) view.findViewById(R.id.Back1);

        relatedstory=(ImageButton) view.findViewById(R.id.RelatedStory1);

        vertivcalOnly=(RecyclerView) view.findViewById(R.id.VerticalRecycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        vertivcalOnly.setLayoutManager(layoutManager);

        BackButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).handleImageButtonClick();
            }
        });

        relatedstory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager= getParentFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView,SecondNewsFragment.class,null)
                        .setReorderingAllowed(true)
                        .commit();
            }
        });

        return view;

    }

}