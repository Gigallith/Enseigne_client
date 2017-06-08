package fr.unice.polytech.enseigne_client.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.unice.polytech.enseigne_client.R;

/**
 * Created by user on 10/05/2017.
 */

public class GiftCardFragment extends Fragment {

    View giftCardView;

    public GiftCardFragment() {
    }

    public static GiftCardFragment NewInstance() {
        GiftCardFragment fragment = new GiftCardFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_gift_card, container, false);
        giftCardView = rootView.findViewById(R.id.gift_card_view);
        return rootView;

    }



}
