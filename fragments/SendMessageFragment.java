package fr.unice.polytech.enseigne_client.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import fr.unice.polytech.enseigne_client.R;
import fr.unice.polytech.enseigne_client.data.Database;

import static fr.unice.polytech.enseigne_client.MainActivity.current_user;

/**
 * Created by user on 03/06/2017.
 */

public class SendMessageFragment extends Fragment {

    EditText numero;
    TextView messageText;
    TextView message;
    TextView numeroText;
    Button envoyer;

    ImageButton cancel;

    public SendMessageFragment() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_send_message, container, false);

        envoyer = (Button) rootView.findViewById(R.id.envoyer);
        cancel = (ImageButton) rootView.findViewById(R.id.cancel_send_message_Button);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelMessage(v);
            }
        });

        numero = (EditText) rootView.findViewById(R.id.numero);

        messageText = (TextView) rootView.findViewById(R.id.messageTextView);
        numeroText = (TextView) rootView.findViewById(R.id.numeroTextView);

        message = (TextView) rootView.findViewById(R.id.message);
        String messageRight = "Bonjour, je te propose d'essayer l'application To Be or To Have disponible à l'adresse suivante :\nhttps://play.google.com/store/apps?hl=fr\n N'oublie pas de renseigner mon adresse mail dans le champ \"Parrain\" lors de ton inscription :\n";
        if (current_user.getMail().isEmpty()) {
            messageText.setVisibility(View.INVISIBLE);
            numero.setVisibility(View.INVISIBLE);
            numeroText.setVisibility(View.INVISIBLE);
            envoyer.setVisibility(View.INVISIBLE);

            message.setText(R.string.messageWrong);
            message.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            message.setTextColor(getResources().getColor(R.color.colorTextButton));
            //message.setTextColor(0);
        } else {
            messageRight += current_user.getMail();
            message.setText(messageRight);
            message.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            message.setTextColor(getResources().getColor(R.color.colorTextButton));
            message.setTextSize(12);
            envoyer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sendSponsoringMessage(v);
                }
            });
        }
        return rootView;
    }

    public void sendSponsoringMessage(View view) {
        String num = numero.getText().toString();
        String msg = message.getText().toString();
        if (!current_user.getMail().isEmpty()) {
            if (num.length() >= 4) {

                Intent sms = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+num));
                sms.putExtra("sms_body", msg);
                startActivity(sms);


                //SmsManager.getDefault().sendTextMessage(num, null, msg, null, null);
                cancelMessage(view);
            } else {
                Toast.makeText(getContext(), "Enter le numero et/ou le message", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getContext(), R.string.messageWrong, Toast.LENGTH_SHORT).show();
        }
    }

    public void cancelMessage(View view) {
        FragmentTransaction ft = this.getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment, new GodfatherFragment());
        ft.commit();
    }
}
