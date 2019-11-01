package wackycodes.gowacky.frame_fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.fragment.app.FragmentTransaction;
import wackycodes.gowacky.R;
import wackycodes.gowacky.adaptor_model_fragment.W_FragmentOneReqOffRide;
import wackycodes.gowacky.map.GoMapForDriver;
import wackycodes.gowacky.navbar.NavMainActivity;

public class W_HomeFragmentForReqOffer extends Fragment {

    private OnFragmentInteractionListener mListener;
    private FrameLayout wMainMiddleStatusFrame;

    public W_HomeFragmentForReqOffer() {
        // Required empty public constructor
    }

    public static W_HomeFragmentForReqOffer newInstance(String param1, String param2) {
        W_HomeFragmentForReqOffer fragment = new W_HomeFragmentForReqOffer();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.w__fragment_one_req_offer, container, false);

        view.findViewById(R.id.wRequestRideBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), GoMapForDriver.class));
            }
        });

        wMainMiddleStatusFrame = view.findViewById(R.id.wMainMiddleStatusFrame);

        setFragment(wMainMiddleStatusFrame, new W_FragmentOneReqOffRide());


//        -----------------------------------------------
        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

// ===============  Wacky Methods... ===========================================

    public void setFragment( FrameLayout wMainMiddleStatusFrame, Fragment fragment ){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(wMainMiddleStatusFrame.getId(), fragment);
        fragmentTransaction.commit();
    }


}
