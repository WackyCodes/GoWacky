package wackycodes.gowacky.map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import wackycodes.gowacky.R;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.firebase.geofire.GeoFire;
import com.firebase.geofire.GeoLocation;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static wackycodes.gowacky.R.anim.nav_default_enter_anim;

public class GoMapForDriver extends FragmentActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        com.google.android.gms.location.LocationListener, View.OnClickListener {

    private GoogleMap wMap;
    private GoogleApiClient wGoogleApiClient;
    Location wLocation;
    LocationRequest wLocationRequest;

    // Bottom Navigation View Button...
    BottomNavigationItemView wNavHomeBtn,wNavShareBtn,wNavNotificationBtn,wNavRequestBtn;

    // Button
    private Button wCancelPlanDriverBtn;
    //FrameLayout
    private FrameLayout wShowBottomNavContentFram;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.go_map_for_driver);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.wDriverMap);
        mapFragment.getMapAsync(this);

        // Bottom Nav Codes...-----------------------------------------
        wNavHomeBtn = findViewById(R.id.wNav_home);
        wNavShareBtn = findViewById(R.id.wNav_share);
        wNavNotificationBtn = findViewById(R.id.wNav_Notification);
        wNavRequestBtn = findViewById(R.id.wNav_request);

        ((BottomNavigationItemView) wNavHomeBtn).setOnClickListener(this);
        ((BottomNavigationItemView) wNavShareBtn).setOnClickListener(this);
        ((BottomNavigationItemView) wNavNotificationBtn).setOnClickListener(this);
        ((BottomNavigationItemView) wNavRequestBtn).setOnClickListener(this);

        // Bottom Nav Codes...-----------------------------------------


    }
//  ========== End OnCreate() ============

//  ========== Start Map Methods() ============

    @Override
    public void onMapReady(GoogleMap googleMap) {
        wMap = googleMap;

//        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        wMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        wMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        wBuildGoogleApiClient();
        wMap.setMyLocationEnabled(true);

    }

    protected synchronized void wBuildGoogleApiClient(){
        wGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        wGoogleApiClient.connect();
    }

    //-------------- On Location activity---
    @Override
    public void onLocationChanged(Location location) {
        wLocation = location;
        LatLng latLng = new LatLng(location.getLatitude(),location.getLongitude());
        wMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        wMap.animateCamera(CameraUpdateFactory.zoomTo(18));


        Double a = location.getLatitude(), b = location.getLatitude();
        String wUser = FirebaseAuth.getInstance().getUid();
        DatabaseReference wRef = FirebaseDatabase.getInstance().getReference("godriver");

        if ((!a.isNaN()) && (!b.isNaN())){
            GeoFire geoFire = new GeoFire(wRef);
            geoFire.setLocation("driver",
                    new GeoLocation(location.getLatitude(), location.getLongitude()),
                    new GeoFire.CompletionListener() {
                        @Override
                        public void onComplete(String key, DatabaseError error) {
                            if (error != null) {
                                Toast.makeText(getApplicationContext(),"There was an error saving the location to GeoFire: " + error, Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(getApplicationContext(),"Update Location on server Successfully..!! Baba.!", Toast.LENGTH_LONG).show();
                            }
                        }
            });
        }
        else {
            Toast.makeText(getApplicationContext(),wRef.toString() , Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        wLocationRequest = new LocationRequest();
        wLocationRequest.setInterval(2000);
        wLocationRequest.setFastestInterval(2000);
        wLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        LocationServices.FusedLocationApi.requestLocationUpdates(
                wGoogleApiClient, wLocationRequest, this);
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    protected void onStop() {
        super.onStop();
//        String wUser = FirebaseAuth.getInstance().getUid();
        DatabaseReference wRef = FirebaseDatabase.getInstance().getReference("godriver");

        GeoFire geoFire = new GeoFire(wRef);
        geoFire.removeLocation("driver");

    }

//  ========== End Map Methods() ============
//  ========== Start Sample Codes () ============

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    @Override
    public void onClick(View v) {
        if (v == findViewById(R.id.wNav_home)){
            wNavMethods(wNavHomeBtn);
            Toast.makeText(GoMapForDriver.this,"Home Activity...",Toast.LENGTH_SHORT).show();
        }
        if (v == findViewById(R.id.wNav_share)){
            wNavMethods(wNavShareBtn);
            Toast.makeText(GoMapForDriver.this,"share Activity...",Toast.LENGTH_SHORT).show();
        }
        if (v == findViewById(R.id.wNav_Notification)){
            wNavMethods(wNavNotificationBtn);
            Toast.makeText(GoMapForDriver.this,"Not Activity...",Toast.LENGTH_SHORT).show();
        }
        if (v == findViewById(R.id.wNav_request)){
            wNavMethods(wNavRequestBtn);
            Toast.makeText(GoMapForDriver.this,"Request Activity...",Toast.LENGTH_SHORT).show();
        }
    }

//  ========== End Sample Codes () ============
//  ========== Start Wacky Methods  () ============


    @SuppressLint({"RestrictedApi", "ResourceAsColor"})
    private void wNavMethods(BottomNavigationItemView wNavItemBtn){
        wNavHomeBtn.setChecked(false);
        wNavShareBtn.setChecked(false);
        wNavNotificationBtn.setChecked(false);
        wNavRequestBtn.setChecked(false);

        wNavItemBtn.setChecked(true);

//        if (wNavItemBtn.isEnabled()){
//            Toast.makeText(GoMapForDriver.this,"hey Activity...",Toast.LENGTH_SHORT).show();
//        }

    }




}
