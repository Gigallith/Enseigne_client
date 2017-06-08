package fr.unice.polytech.enseigne_client.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import fr.unice.polytech.enseigne_client.R;

import static fr.unice.polytech.enseigne_client.MainActivity.current_user;

/**
 * Created by user on 10/05/2017.
 */

public class LoyaltyFragment extends Fragment {

    View loyaltyView;
    TextView points;

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
        points = (TextView) rootView.findViewById(R.id.pointsTextView);
        if (!current_user.getMail().isEmpty()) {
            String strPoints = "Mes points : " + current_user.getLoyaltyCard().getPoints();
            points.setText(strPoints);
        } else {
            points.setText(R.string.No_points);
        }
        return rootView;

    }

}
