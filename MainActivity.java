package fr.unice.polytech.enseigne_client;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import fr.unice.polytech.enseigne_client.fragments.GiftCardFragment;
import fr.unice.polytech.enseigne_client.fragments.GodfatherFragment;
import fr.unice.polytech.enseigne_client.fragments.HomeFragment;
import fr.unice.polytech.enseigne_client.fragments.LoyaltyFragment;
import fr.unice.polytech.enseigne_client.fragments.ShopsFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {



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

        //Set la vue de l'acceuil à l'ouverture de l'appli
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment, new HomeFragment())
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
        } else {
            super.onBackPressed();
        }
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_acceuil) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment, new HomeFragment())
                    .commit();
        } else if (id == R.id.nav_giftCard) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment, new GiftCardFragment())
                    .commit();
        } else if (id == R.id.nav_loyalty) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment, new LoyaltyFragment())
                    .commit();
        } else if (id == R.id.nav_magasin) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment, new ShopsFragment())
                    .commit();
        } else if (id == R.id.nav_sponsoring) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment, new GodfatherFragment())
                    .commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
