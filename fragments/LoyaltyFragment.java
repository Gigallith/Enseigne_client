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

public class LoyaltyFragment extends Fragment {

    View loyaltyView;

    public LoyaltyFragment() {
    }

    public static LoyaltyFragment newInstance(){
        LoyaltyFragment fragment = new LoyaltyFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_loyalty, container, false);
        loyaltyView = rootView.findViewById(R.id.loyalty_view);
        return rootView;

    }



}
