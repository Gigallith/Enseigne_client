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
import android.widget.Toast;

import fr.unice.polytech.enseigne_client.MainActivity;
import fr.unice.polytech.enseigne_client.R;
import fr.unice.polytech.enseigne_client.data.User;

import static fr.unice.polytech.enseigne_client.MainActivity.current_user;
import static fr.unice.polytech.enseigne_client.MainActivity.usermail;
import static fr.unice.polytech.enseigne_client.data.Database.userDatabase;

/**
 * Created by user on 18/05/2017.
 */

public class SignupFragment extends Fragment {

    private View signupView;

    private ImageButton exit;
    private Button signupButton;

    private EditText nom;
    private EditText mail;
    private EditText password;
    private EditText confirmPassword;

    private EditText godFather;

    public SignupFragment() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_signup, container, false);
        signupView = rootView.findViewById(R.id.signup_view);

        exit = (ImageButton) rootView.findViewById(R.id.cancel_signup_Button);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeSignupMenu(v);
            }
        });

        signupButton = (Button) rootView.findViewById(R.id.accept_signup_button);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmSignup(v);
            }
        });

        nom = (EditText) rootView.findViewById(R.id.name_editText);
        mail = (EditText) rootView.findViewById(R.id.mail_editText);
        password = (EditText) rootView.findViewById(R.id.password_editText);
        confirmPassword = (EditText) rootView.findViewById(R.id.confirm_password_editText);
        godFather = (EditText) rootView.findViewById(R.id.sponsoredUser);

        return rootView;
    }

    public void confirmSignup(View view) {
        String inputName = nom.getText().toString();
        String inputMail = mail.getText().toString();
        String inputPassword = password.getText().toString();
        String inputConfirmPassword = confirmPassword.getText().toString();

        User inputUser = new User(inputName, inputMail, inputPassword);
        if (!godFather.getText().toString().isEmpty()) {
            String inputGodFather = godFather.getText().toString();
            if (!userDatabase.containsKey(inputGodFather)) {
                Toast.makeText(getContext(),"Cet utilisateur n'existe pas", Toast.LENGTH_SHORT).show();
            } else {
                userDatabase.get(inputGodFather).getLoyaltyCard().addSponsor(inputUser);
            }
        }

        if ((inputConfirmPassword.isEmpty() && inputPassword.isEmpty() && !inputConfirmPassword.equals(inputPassword))) {
            Toast.makeText(getContext(), "mauvais mdp", Toast.LENGTH_SHORT).show();
        } else if (userDatabase.containsKey(inputMail)){
            Toast.makeText(getContext(),"Erreur d'identification", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(),R.string.login, Toast.LENGTH_SHORT).show();
            userDatabase.put(inputMail,inputUser);
            current_user = inputUser;
            closeSignupMenu(view);
        }

    }

    public void closeSignupMenu(View view) {
        FragmentTransaction ft = this.getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment,new HomeFragment());
        ft.commit();
        usermail.setVisibility(View.VISIBLE);
        usermail.setText(current_user.getMail());
    }
}
