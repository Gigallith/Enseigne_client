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

import fr.unice.polytech.enseigne_client.R;
import fr.unice.polytech.enseigne_client.data.User;

import static fr.unice.polytech.enseigne_client.MainActivity.current_user;
import static fr.unice.polytech.enseigne_client.MainActivity.usermail;
import static fr.unice.polytech.enseigne_client.data.Database.userDatabase;

/**
 * Created by user on 02/06/2017.
 */

public class LoginFragment extends Fragment {

    private View loginView;

    private Button login_verify_button;
    private ImageButton quit_login;
    private EditText mail;
    private EditText password;

    public LoginFragment() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        loginView = rootView.findViewById(R.id.login_view);

        quit_login = (ImageButton) rootView.findViewById(R.id.cancel_login_Button);
        quit_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeLoginMenu(v);
            }
        });


        mail = (EditText) rootView.findViewById(R.id.mail_editText);
        password = (EditText) rootView.findViewById(R.id.password_editText);
        login_verify_button = (Button) rootView.findViewById(R.id.accept_login_button);
        login_verify_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acceptLogin(v);
            }
        });

        return rootView;
    }


    public void acceptLogin(View view) {
        String inputMail = mail.getText().toString();
        String inputPassword = password.getText().toString();
        User inputUser = userDatabase.get(inputMail);
        if (!userDatabase.containsKey(inputMail)) {
            Toast.makeText(getContext(), R.string.auth_failed, Toast.LENGTH_SHORT).show();
            return;
        }
        if (inputUser.getPassword().equals(inputPassword)) {
            closeLoginMenu(view);
            current_user = inputUser;
            Toast.makeText(getContext(), R.string.login, Toast.LENGTH_SHORT).show();
            usermail.setVisibility(View.VISIBLE);
            usermail.setText(current_user.getMail());
        } else {
            Toast.makeText(getContext(), R.string.wrong_password, Toast.LENGTH_SHORT).show();
        }

    }

    public void closeLoginMenu(View view) {
        FragmentTransaction ft = this.getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment,new HomeFragment());
        ft.commit();
    }


}
