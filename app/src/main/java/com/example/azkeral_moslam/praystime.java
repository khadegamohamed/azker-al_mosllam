package com.example.azkeral_moslam;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link praystime#newInstance} factory method to
 * create an instance of this fragment.
 */
public class praystime extends Fragment {
RecyclerView recycler;
sheredprefrence sh ;
adepterpraytime adp;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public praystime() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment praystime.
     */
    // TODO: Rename and change types and number of parameters
    public static praystime newInstance(String param1, String param2) {
        praystime fragment = new praystime();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        sh = new sheredprefrence(getContext());
        ArrayList<itempraytimes> datatime= new ArrayList<>();
        datatime.add(new itempraytimes("الفجر",sh.getFager(),R.drawable.faher));
        datatime.add(new itempraytimes("الشروق",sh.getSunrise(),R.drawable.shrok));
        datatime.add(new itempraytimes("الظهر",sh.getDhur(),R.drawable.dhur));
        datatime.add(new itempraytimes("العصر",sh.getAsr(),R.drawable.asr));
        datatime.add(new itempraytimes("المغرب",sh.getMghred(),R.drawable.magrib));
        datatime.add(new itempraytimes("العشاء",sh.getIshaa(),R.drawable.magrib));
        adp = new adepterpraytime(datatime);
        View vv =inflater.inflate(R.layout.fragment_praystime, container, false);
        recycler= vv.findViewById(R.id.praytimes);
       recycler.setAdapter(adp);
        RecyclerView.LayoutManager im = new GridLayoutManager(getContext(),2);
        recycler.setLayoutManager(im);
        recycler.setHasFixedSize(true);
        return vv;
    }
}