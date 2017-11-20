package com.example.kevin.hamburguesas;

import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.kevin.hamburguesas.Fragments.CreacionFragment;
import com.example.kevin.hamburguesas.Fragments.InfoFragment;
import com.example.kevin.hamburguesas.Fragments.NuevosFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        InfoFragment.OnFragmentInteractionListener,
        CreacionFragment.OnFragmentInteractionListener,
        NuevosFragment.OnFragmentInteractionListener{
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Agregando elemento", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        Fragment fragment = null;
        boolean FragmentTransaction = false;
        if (id == R.id.nav_perfil) {
            getSupportActionBar().setTitle(item.getTitle());
            Toast.makeText(this, "Mi perfil", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_compras) {
            getSupportActionBar().setTitle(item.getTitle());
            Toast.makeText(this, "Nueva Compra", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_creaciones) {
            fragment = new CreacionFragment();
            FragmentTransaction = true;
            Toast.makeText(this, "Nueva Creación", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_comunidad) {
            fragment = new NuevosFragment();
            FragmentTransaction = true;
            Toast.makeText(this, "Otras Creaciones", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_aplicacion) {
            fragment = new InfoFragment();
            FragmentTransaction = true;

        } else if (id == R.id.nav_desarrollo) {
        }
        if (FragmentTransaction){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.contenedorFragments, fragment)
                    .commit();
            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}
