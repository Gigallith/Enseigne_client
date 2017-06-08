package fr.unice.polytech.enseigne_client;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import fr.unice.polytech.enseigne_client.data.User;
import fr.unice.polytech.enseigne_client.fragments.GiftCardFragment;
import fr.unice.polytech.enseigne_client.fragments.GodfatherFragment;
import fr.unice.polytech.enseigne_client.fragments.HomeFragment;
import fr.unice.polytech.enseigne_client.fragments.LoginFragment;
import fr.unice.polytech.enseigne_client.fragments.LoyaltyFragment;
import fr.unice.polytech.enseigne_client.fragments.ShopsFragment;
import fr.unice.polytech.enseigne_client.fragments.SignupFragment;

import static fr.unice.polytech.enseigne_client.R.id.fragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static User current_user = new User("","");

    public static TextView usermail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);
        usermail = (TextView) navigationView.getHeaderView(0).findViewById(R.id.currentUserMail);

        //Set la vue de l'acceuil à l'ouverture de l'appli
        getSupportFragmentManager()
                .beginTransaction()
                .replace(fragment, new HomeFragment()).addToBackStack(null)
                .commit();
    }


    private SparseArrayCompat<Fragment> createFragments() {
        SparseArrayCompat<Fragment> fragments = new SparseArrayCompat<>();
        fragments.append(1, new GiftCardFragment());
        return fragments;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }else if(getFragmentManager().getBackStackEntryCount() > 0){
            //getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }

//
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_login) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(fragment, new LoginFragment()).addToBackStack(null)
                    .commit();
        } else if (id == R.id.action_sign_up) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(fragment, new SignupFragment()).addToBackStack(null)
                    .commit();

//            createAccount();
            return true;
        } else if (id == R.id.action_log_out_menu) {
            //AuthUI.getInstance().signOut(this);

            usermail.setVisibility(View.INVISIBLE);
            usermail.setText("");
            if (current_user.getMail().isEmpty())
                Toast.makeText(this, R.string.logout_failed, Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, R.string.logout, Toast.LENGTH_SHORT).show();
            current_user = new User("","");
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(fragment, new HomeFragment()).addToBackStack(null)
                    .commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        if (!current_user.getMail().isEmpty()){
            usermail.setVisibility(View.VISIBLE);
            usermail.setText(current_user.getMail());
        }
        else
            usermail.setVisibility(View.INVISIBLE);
        int id = item.getItemId();

        if (id == R.id.nav_acceuil) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(fragment, new HomeFragment()).addToBackStack(null)
                    .commit();
        } else if (id == R.id.nav_giftCard) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(fragment, new GiftCardFragment()).addToBackStack(null)
                    .commit();
        } else if (id == R.id.nav_loyalty) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(fragment, new LoyaltyFragment()).addToBackStack(null)
                    .commit();
        } else if (id == R.id.nav_magasin) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(fragment, new ShopsFragment()).addToBackStack(null)
                    .commit();
        } else if (id == R.id.nav_sponsoring) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(fragment, new GodfatherFragment()).addToBackStack(null)
                    .commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
