package fr.unice.polytech.enseigne_client.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import fr.unice.polytech.enseigne_client.R;
import fr.unice.polytech.enseigne_client.data.User;

import static fr.unice.polytech.enseigne_client.MainActivity.current_user;

/**
 * Created by user on 03/06/2017.
 */
public class SponsoredListFragment extends Fragment {

    ImageButton close;
    TextView list;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sponsored_list, container, false);

        close = (ImageButton) rootView.findViewById(R.id.close_sponsored_list);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeList(v);
            }
        });
        list = (TextView) rootView.findViewById(R.id.list_sponsor);
        String users = "";
        if (!current_user.getLoyaltyCard().getSponsored().isEmpty()) {
            for (User user : current_user.getLoyaltyCard().getSponsored()) {
                users += (user.getName() + "\n" + user.getMail() + "\n");
            }
            list.setText(users);
            list.setTextColor(getResources().getColor(R.color.colorTextButton));
        } else {
            list.setText("Vous n'avez aucun contact parrainé");
            list.setTextColor(getResources().getColor(R.color.colorTextButton));
        }

        return rootView;

    }

    public void closeList(View view) {
        FragmentTransaction ft = this.getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment, new GodfatherFragment()).addToBackStack(null);
        ft.commit();
    }
}
