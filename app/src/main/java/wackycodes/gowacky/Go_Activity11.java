package wackycodes.gowacky;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import wackycodes.gowacky.W_Fragment.W_FragmentOneReqOffRide;
import wackycodes.gowacky.W_Fragment.W_FragmentOneModelClass;
import wackycodes.gowacky.W_Fragment.W_FragmentOneAdaptorClass;

public class Go_Activity11 extends AppCompatActivity {

    private static final int USER_DRIVER = 1901;
    private static final int USER_CUSTOMER = 1902;

    private FrameLayout wMainMiddleStatusFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_11);

//        ----------- Variable declaration  -----------------------
        // Layout...
        wMainMiddleStatusFrame = findViewById(R.id.wMainMiddleStatusFrame);

        setFragment(new W_FragmentOneReqOffRide());

//        ---------------------------------------------------------

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



}
