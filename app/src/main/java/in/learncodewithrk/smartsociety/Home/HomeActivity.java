package in.learncodewithrk.smartsociety.Home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

import in.learncodewithrk.smartsociety.R;
import in.learncodewithrk.smartsociety.fragment.HomeFragment;
import in.learncodewithrk.smartsociety.aboutFragment;
import in.learncodewithrk.smartsociety.login.LoginandregisterActivity;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    String url = "https://goo.gl/maps/bVi3oWbGrhjs2uY56";
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mAuth = FirebaseAuth.getInstance();
        setToolbar();
        initViews();
        initComponentsNavHeader();
        loadFragment(new HomeFragment());
    }

    private void setToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(0);
    }

    private void initViews() {
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        /**
         * Menu Navigation Drawer
         **/
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(false);
        toggle.setToolbarNavigationClickListener(view -> drawer.openDrawer(GravityCompat.START));
        toggle.setHomeAsUpIndicator(R.drawable.ic_drawer);
        toggle.syncState();
    }

    /**
     * Fragment
     **/
    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }



    /**
     * Menu Bottom Navigation Drawer
     * */


    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.nav_menu_home:
                fragment = new HomeFragment();
                break;
            case R.id.nav_menu_search:
                fragment = new aboutFragment();
                break;

        }
        return loadFragment(fragment);
    }

    private void initComponentsNavHeader(){
        NavigationView navigationView = findViewById(R.id.nav_view);
//        navigationView.setItemIconTintList(null); //disable tint on each icon to use color icon svg
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {


                    case R.id.nav_my_account:


                        if (Build.VERSION.SDK_INT < 23) {
                            Intent in = new Intent(Intent.ACTION_CALL, Uri.parse("tel:+91" + "9599695872"));

                            try {
                                startActivity(in);
                            } catch (android.content.ActivityNotFoundException ex) {
                                Toast.makeText(getApplicationContext(), "yourActivity is not founded", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            int REQUEST_CODE_ASK_PERMISSIONS = 123;

                            int hasWriteContactsPermission = checkSelfPermission(Manifest.permission.CALL_PHONE);
                            if (hasWriteContactsPermission != PackageManager.PERMISSION_GRANTED) {
                                requestPermissions(new String[]{Manifest.permission.CALL_PHONE},
                                        REQUEST_CODE_ASK_PERMISSIONS);

                            }

                            Intent in = new Intent(Intent.ACTION_CALL, Uri.parse("tel:+91" + "9599695872"));

                            try {
                                startActivity(in);
                            } catch (Exception ex) {
                                Toast.makeText(getApplicationContext(), "Permissions required", Toast.LENGTH_SHORT).show();
                            }

                        }


                        break;
                    case R.id.nav_support:
                        Intent intent = new Intent("android.intent.action.VIEW",
                                Uri.parse("https://goo.gl/maps/bVi3oWbGrhjs2uY56"));
                        startActivity(intent);
                        break;


                    case R.id.Share:
                        Intent shareintent = new Intent();
                        shareintent.setAction(Intent.ACTION_SEND);
                        shareintent.putExtra(Intent.EXTRA_TEXT, "Download LP Practice App\n https://play.google.com/store/apps/details?id=in.gcfiber.gcfiber");
                        shareintent.setType("text/plain");
                        startActivity(Intent.createChooser(shareintent, " Share via"));
                        break;


                    case R.id.logout:
                        mAuth.signOut();
                        if (mAuth.getCurrentUser() == null) {
                            startActivity(new Intent(getApplicationContext(), LoginandregisterActivity.class));
                            finish();
                            break;

                        }
                }

                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }

            private void Pesan(String pesan) {
                //Toast.makeText(Home_page.this, pesan, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed () {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you wants to exit?")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        HomeActivity.super.onBackPressed();

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setNeutralButton("youtube", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_profile) {
            Uri uri = Uri.parse("https://goo.gl/maps/bVi3oWbGrhjs2uY56");
            startActivity(Intent.createChooser(new Intent(Intent.ACTION_VIEW, uri), "Choose Browser"));
        }
        return true;
    }
}