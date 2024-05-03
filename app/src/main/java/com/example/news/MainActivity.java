package com.example.news;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LinearLayoutManager linearLayoutManager;
    RecyclerView HorizontalRecycler, VerticalRecycler;
    FragmentContainerView fragment_Container_View;
    ArrayList<String> dataSource;
    MyAdapter myAdapter;

    ImageButton news1,news2,news3,news4;
    private ImageView cabinet,qantas,housecrisis,nt;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        news1=findViewById(R.id.News1);
        news2=findViewById(R.id.News2);
        news3=findViewById(R.id.News3);
        news4=findViewById(R.id.News4);

        fragment_Container_View=findViewById(R.id.fragmentContainerView);

        HorizontalRecycler=findViewById(R.id.horizontal_recycler_view);

        dataSource=new ArrayList<>();
        dataSource.add("qantas.PNG");
        dataSource.add("cabinet.PNG");
        dataSource.add("sydnews.PNG");
        dataSource.add("housingcrisi.PNG");

        linearLayoutManager=new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
        myAdapter=new MyAdapter(dataSource);
        HorizontalRecycler.setAdapter(myAdapter);
        HorizontalRecycler.setLayoutManager(linearLayoutManager);

        fragment_Container_View.setVisibility(View.INVISIBLE);

        news1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment_Container_View.setVisibility(View.VISIBLE);
                FragmentManager fragmentManager=getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView,FirstNewsFragment.class,null)
                        .setReorderingAllowed(true)
                        .addToBackStack("FirstNews")
                        .commit();
            }
        });

        news2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment_Container_View.setVisibility(View.VISIBLE);
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction
                        .replace(R.id.fragmentContainerView,SecondNewsFragment.class,null)
                        .setReorderingAllowed(true)
                        .addToBackStack("SecondNews")
                        .commit();
            }
        });

        news3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment_Container_View.setVisibility(View.VISIBLE);
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction
                        .replace(R.id.fragmentContainerView,ThirdNewsFragment.class,null)
                        .setReorderingAllowed(true)
                        .addToBackStack("ThirdNews")
                        .commit();
            }
        });

        news4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment_Container_View.setVisibility(View.VISIBLE);
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction
                        .replace(R.id.fragmentContainerView,FourthNewsFragment.class,null)
                        .setReorderingAllowed(true)
                        .addToBackStack("FourthNews")
                        .commit();
            }
        });

    }

    public void handleImageButtonClick() {
        fragment_Container_View.setVisibility(View.INVISIBLE);
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder>
    {
        ArrayList<String> dataSource;
        public MyAdapter(ArrayList<String> data) {
            this.dataSource=data;
        }

        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(MainActivity.this).inflate(R.layout.topstories,parent,false);
            return new MyHolder(view);
        }

        @Override
        public int getItemCount() {
            return dataSource.size();
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        }

        class MyHolder extends RecyclerView.ViewHolder
        {
            ImageView imageView;
            public MyHolder(@NonNull View itemView) {
                super(itemView);
                imageView=findViewById(R.id.cabinet);
            }
        }
    }

}