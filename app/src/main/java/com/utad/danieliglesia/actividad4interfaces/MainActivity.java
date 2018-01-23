package com.utad.danieliglesia.actividad4interfaces;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ImageView imageView;
//terminado
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
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

        SettingsFragment miFragmentSettings = null;
        boolean fragmentSelecionadoS = false;

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            miFragmentSettings = new SettingsFragment();
            fragmentSelecionadoS = true;
            if (fragmentSelecionadoS == true) {
                getSupportFragmentManager().beginTransaction().replace(R.id.content_main, miFragmentSettings).commit();

            }

            //return super.onOptionsItemSelected(item);
            return true;

        }
        return fragmentSelecionadoS;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentRojo miFragmentRojo=null;
        FragmentVerde miFragmentVerde=null;
        FragmentAmarillo miFragmentAmarillo=null;

        boolean fragmentSelecionadoR=false;
        boolean fragmentSelecionadoA=false;
        boolean fragmentSelecionadoV=false;

        if (id == R.id.nav_camera) {
            miFragmentRojo=new FragmentRojo();
            fragmentSelecionadoR=true;
            if(fragmentSelecionadoR==true){
                getSupportFragmentManager().beginTransaction().replace(R.id.content_main,miFragmentRojo).commit();

            }
        } else if (id == R.id.nav_gallery) {
            miFragmentAmarillo=new FragmentAmarillo();
            fragmentSelecionadoA=true;
            if(fragmentSelecionadoA==true){
                getSupportFragmentManager().beginTransaction().replace(R.id.content_main,miFragmentAmarillo).commit();

            }
        } else if (id == R.id.nav_slideshow) {
            miFragmentVerde=new FragmentVerde();
            fragmentSelecionadoV=true;
            if(fragmentSelecionadoV==true){
                getSupportFragmentManager().beginTransaction().replace(R.id.content_main,miFragmentVerde).commit();

            }
        }else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
