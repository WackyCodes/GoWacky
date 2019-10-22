package wackycodes.gowacky;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
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
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import wackycodes.gowacky.adaptor_model_fragment.W_FragmentTwoBookingInfoClass;
import wackycodes.gowacky.frame_fragment.W_HomeFragmentForReqOffer;

import static com.google.android.gms.common.api.GoogleApiClient.*;

public class Go_Activity11 extends AppCompatActivity
        implements OnMapReadyCallback, View.OnClickListener,
        NavigationView.OnNavigationItemSelectedListener {

    private static final int USER_DRIVER = 1901;
    private static final int USER_CUSTOMER = 1902;
    private static final int OPEN_DRAWER = 1911;
    private static final int CLOSE_DRAWER = 1912;
    private static final int NOTIFICATION = 1913;
    private static final int REQUEST = 1914;
    private static final int SHARE = 1915;
    private static final int HOME = 1916;


    private FrameLayout wMainMiddleStatusFrame;
    private FrameLayout wMainMiddleStatusFrame_;
    private FrameLayout wHomeFrameLayout2,wHomeFrameLayout3;
    private FrameLayout w_BottomNavHomeFrameLayout;

    private GoogleMap wMap;
    private GoogleApiClient wGoogleApiClient;
    Location wLocation;
    LocationRequest wLocationRequest;

    private DrawerLayout drawerLayout;

    // wHomeFrameLayout2 - ReqOffer Variable...
    private Button wRequestRideBtn, wOfferRideBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_11);


//        ----------- Variable declaration Start -----------------------
        // Layout...
        wMainMiddleStatusFrame = findViewById(R.id.wMainMiddleStatusFrame);
        wMainMiddleStatusFrame_ = findViewById(R.id.wMainMiddleStatusFrame_);
        wHomeFrameLayout2 = findViewById(R.id.wHomeFrameLayout2);
        wHomeFrameLayout3 = findViewById(R.id.wHomeFrameLayout3);
        w_BottomNavHomeFrameLayout = findViewById(R.id.w_BottomNavHomeFrameLayout);


        // wHomeFrameLayout2 - ReqOffer Variable...
        wRequestRideBtn = findViewById(R.id.wRequestRideBtn);
        wOfferRideBtn = findViewById(R.id.wOfferRideBtn);


//        ----------- Variable declaration End -----------------------

// -------- ToolBar and Top Nav view --- Start --------------
        Toolbar toolbar = findViewById(R.id.wToggleButton);
        setSupportActionBar(toolbar);

        NavigationView navigationView = findViewById(R.id.wNavigationTopLeft);
        navigationView.setNavigationItemSelectedListener(Go_Activity11.this);

        drawerLayout = findViewById(R.id.wHomeDrawerLayout);

        ActionBarDrawerToggle toggle;
        toggle = new ActionBarDrawerToggle(
                Go_Activity11.this, drawerLayout,
                toolbar, R.string.Open_Drawer,R.string.Close_Drawer );
        try {
            drawerLayout.addDrawerListener(toggle);
            toggle.syncState();
        }catch (Exception e){
            //-----
        }

        // ------------- Bottom Navigation view...:


// -------- ToolBar and Top Nav view --- End --------------

//   ---- Button SetOnClickListener...Start
        wOfferRideBtn.setOnClickListener(this);
        wRequestRideBtn.setOnClickListener(this);

//   ---- Button SetOnClickListener...End



//        ---------------------------------------------------------
        // Obtain the SupportMapFragment and get notified when the wackycodes.gowacky.map is ready to be used.
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.wMapViewFragment);
//        mapFragment.getMapAsync(this);
//
//        findViewById(R.id.wOfferRideOptionBtn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(Go_Activity11.this,"Method doesn't create for this button...", Toast.LENGTH_LONG).show();
//            }
//        });


        FrameLayout frameLayout1 = findViewById(R.id.wHomeFrameLayout21);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout1.getId(), new W_HomeFragmentForReqOffer());
        fragmentTransaction.commit();

    }
// ===== End OnCreate() ----------

    private void userType(){
        // check user is driver or customer...
    }

// -----  Fragment Transaction Start -------------------------

    private void wFragmentSetUp(FrameLayout frameLayout){
        if (frameLayout == wHomeFrameLayout2){
            FrameLayout frameLayout1 = findViewById(R.id.wHomeFrameLayout21);
            setFragment(new W_HomeFragmentForReqOffer(), frameLayout1 );
        }
    }

    private void setFragment(Fragment newFragment, FrameLayout getFrame){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(getFrame.getId(), newFragment);
        fragmentTransaction.commit();
    }
// -----  Fragment Transaction End -------------------------
// === ---------  onClick Method ----- Start -------------------------
    @Override
    public void onClick(View v) {
        // wHomeFrameLayout2 - ReqOffer...
        if (v == wRequestRideBtn){
            wSetFrameVisibility(wHomeFrameLayout2,wHomeFrameLayout3);
        }
        if (v == wOfferRideBtn){
            wSetFrameVisibility(wHomeFrameLayout2,wHomeFrameLayout3);
        }


    }
// === ---------  onClick Method ----- End  -------------------------


// ========= Google Maps and Methods...------------------==========================
    @Override
    public void onMapReady(GoogleMap googleMap) {
        wMap = googleMap;

//        wBuildGoogleApiClient();
//        wMap.setMyLocationEnabled(true);

    }

    // ========= Google Maps and Methods...------------------==========================

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.w_sampleHome:
                Toast.makeText(Go_Activity11.this, "Hey Home", Toast.LENGTH_LONG).show();
                break;

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

//=== ----------------- getVisibility Methods --------- Starts ---------------
    // Fragments Visibility...
    public FrameLayout wGetFrameVisibility(){

        if (wHomeFrameLayout2.getVisibility() == View.VISIBLE){
            return wHomeFrameLayout2;
        }
        if (wHomeFrameLayout3.getVisibility() == View.VISIBLE){
            return wHomeFrameLayout3;
        }
        return null;
    }
    public void wSetFrameVisibility(FrameLayout crrFrame, FrameLayout upComingFrame){
        if (crrFrame.getVisibility() == View.VISIBLE){
            crrFrame.setVisibility(View.GONE);
        }
        upComingFrame.setVisibility(View.VISIBLE);

        wFragmentSetUp(upComingFrame);
    }
    // bottom nav visibility...
    public void bottomNavVisibility( int ref ){

        if( ref == NOTIFICATION ){
            if ( w_BottomNavHomeFrameLayout.getVisibility() != View.VISIBLE ){
                w_BottomNavHomeFrameLayout.setVisibility(View.VISIBLE);
            }
            Toast.makeText(Go_Activity11.this, "Notification Click...", Toast.LENGTH_LONG).show();
        }

        if (ref == HOME ){
            if ( w_BottomNavHomeFrameLayout.getVisibility() == View.VISIBLE ){
                w_BottomNavHomeFrameLayout.setVisibility(View.GONE);
            }
        }

    }

//=== ----------------- getVisibility Methods --------- End ---------------

}
