package com.example.group_4_shoppingapp.Activities;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.group_4_shoppingapp.Fragment.AboutFragment;
import com.example.group_4_shoppingapp.Fragment.CartFragment;
import com.example.group_4_shoppingapp.Fragment.ContactFragment;
import com.example.group_4_shoppingapp.Fragment.ProductsFragment;
import com.example.group_4_shoppingapp.R;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


public class ListActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout,R.string.open,R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                   new ProductsFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_product);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_product:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ProductsFragment()).commit();
                break;
            case R.id.nav_cart:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CartFragment()).commit();
                break;
            case R.id.nav_aboutUs:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AboutFragment()).commit();
                break;
            case R.id.nav_contactUs:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ContactFragment()).commit();
                break;
            case R.id.nav_logout:
                logout();
                Intent in = new Intent(this, LoginMainActivity.class);
                startActivity(in);
                finish();
                break;

            default:
                break;

        }

        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void logout() {

                Intent mIntent = new Intent(ListActivity.this, SignupActivity.class);
                //Set value to pass on next activity
                startActivity(mIntent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

