package com.example.azkeral_moslam;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AL_AZKER#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AL_AZKER extends Fragment {
    ImageView moring,night,sleep,pray;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AL_AZKER() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AL_AZKER.
     */
    // TODO: Rename and change types and number of parameters
    public static AL_AZKER newInstance(String param1, String param2) {
        AL_AZKER fragment = new AL_AZKER();
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
        View view= inflater.inflate(R.layout.fragment_a_l__a_z_k_e_r, container, false);
        moring  = view.findViewById(R.id.moring);
        night = view.findViewById(R.id.night);
        sleep = view.findViewById(R.id.sleep);
        pray = view.findViewById(R.id.pray);
        moring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mornning = new Intent(getContext(),Morning.class);
                startActivity(mornning);
            }
        });
        night.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent night= new Intent(getContext(), night.class);
                startActivity(night);
            }
        });
        sleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sleep = new Intent(getContext(), sleep.class);
                startActivity(sleep);
            }
        });

        pray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pray = new Intent(getContext(), pray.class );
                startActivity(pray);
            }
        });

        return view;
    }
}