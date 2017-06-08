package fr.unice.polytech.enseigne_client.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import fr.unice.polytech.enseigne_client.MainActivity;
import fr.unice.polytech.enseigne_client.R;

import static fr.unice.polytech.enseigne_client.MainActivity.current_user;

/**
 * Created by user on 10/05/2017.
 */

public class GodfatherFragment extends Fragment {

    View godFatherView;
    Button contactButton;
    Button messageButton;

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
        contactButton = (Button) rootView.findViewById(R.id.sponsor_list_button);
        contactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listSponsored(v);
            }
        });

        messageButton = (Button) rootView.findViewById(R.id.send_message);
        messageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openSponsoringMessage(v);
            }
        });
        return rootView;
    }


     public void openSponsoringMessage(View view) {
         FragmentTransaction ft = this.getFragmentManager().beginTransaction();
         ft.replace(R.id.fragment,new SendMessageFragment());
         ft.commit();
     }

    public void listSponsored(View view) {
        if (!current_user.getMail().isEmpty()) {
            FragmentTransaction ft = this.getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment, new SponsoredListFragment());
            ft.commit();
        } else {
            Toast.makeText(getContext(), "Vous devez vous connecter", Toast.LENGTH_SHORT).show();
        }
    }

}
