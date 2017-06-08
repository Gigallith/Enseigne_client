package fr.unice.polytech.enseigne_client.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import fr.unice.polytech.enseigne_client.R;
import fr.unice.polytech.enseigne_client.data.User;

import static fr.unice.polytech.enseigne_client.MainActivity.current_user;
import static fr.unice.polytech.enseigne_client.MainActivity.usermail;
import static fr.unice.polytech.enseigne_client.data.Database.userDatabase;

/**
 * Created by user on 10/05/2017.
 */

public class HomeFragment extends Fragment{

    private View homeView;
    private Button login_button;
    private View map;

    TextView bienvenueMessage;

    public HomeFragment() {
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        homeView = rootView.findViewById(R.id.home_view);
        map = rootView.findViewById(R.id.map_home_fragment);
        bienvenueMessage = (TextView) rootView.findViewById(R.id.messageBienvenue);

        login_button = (Button) rootView.findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginMenu(v);
            }
        });
        if (!current_user.getMail().isEmpty()) {
            login_button.setVisibility(View.INVISIBLE);
            String message = "Bienvenue " + current_user.getName();
            bienvenueMessage.setText(message);
        }

        return rootView;
    }

    public void openLoginMenu(View view) {
        FragmentTransaction ft = this.getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment,new LoginFragment()).addToBackStack(null);
        ft.commit();

    }

}
