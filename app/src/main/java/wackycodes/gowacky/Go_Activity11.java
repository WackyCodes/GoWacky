package wackycodes.gowacky;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import wackycodes.gowacky.W_Fragment.W_FragmentOneReqOffRide;

public class Go_Activity11 extends AppCompatActivity implements OnMapReadyCallback {

    private static final int USER_DRIVER = 1901;
    private static final int USER_CUSTOMER = 1902;

    private FrameLayout wMainMiddleStatusFrame;

    private Button wRequestRideBtn;
    private GoogleMap wMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_11);

//        ----------- Variable declaration  -----------------------
        // Layout...
        wMainMiddleStatusFrame = findViewById(R.id.wMainMiddleStatusFrame);

        setFragment(new W_FragmentOneReqOffRide());

//        ---------------------------------------------------------
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.wackyMap);
        mapFragment.getMapAsync(this);

        findViewById(R.id.wRequestRideBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Go_Activity11.this,"Method doesn't create for this button...", Toast.LENGTH_LONG).show();
            }
        });

    }
//    End OnCreate() ----------

    private void userType(){
        // check user is driver or customer...
    }

    private void setFragment(Fragment newFragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(wMainMiddleStatusFrame.getId(), newFragment);
        fragmentTransaction.commit();
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        wMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        wMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        wMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
