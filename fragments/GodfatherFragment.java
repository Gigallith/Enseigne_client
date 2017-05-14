package fr.unice.polytech.enseigne_client.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.unice.polytech.enseigne_client.R;

/**
 * Created by user on 10/05/2017.
 */

public class GodfatherFragment extends Fragment {

    View godFatherView;

    public static GodfatherFragment newInstance(){
        GodfatherFragment fragment = new GodfatherFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_sponsoring, container, false);
        godFatherView = rootView.findViewById(R.id.sponsoring_view);
        return rootView;

    }



}
