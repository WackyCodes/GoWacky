package wackycodes.gowacky.adaptor_model_fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import wackycodes.gowacky.R;

public class W_FragmentOneReqOffRide extends Fragment implements View.OnClickListener {

    // Final Static...
    private static final int _CAR_ = 1901, _BIKE_ = 1902, _MINI_TRUCK_ = 1903, _BUS_ = 1904;
    // Variable declaration ...
    private RecyclerView wRequestRideRecyclerView;

    // button
    private Button wRequestRideBtn,wOfferRideBtn;


    public W_FragmentOneReqOffRide() {
        // Required empty public constructor
    }


    public static W_FragmentOneReqOffRide newInstance(String param1, String param2) {
        W_FragmentOneReqOffRide fragment = new W_FragmentOneReqOffRide();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view =  inflater.inflate(R.layout.w__fragment__one_req_offer_ride_options, container, false);


   // Request Ride items in horizontally....--------------------------------

        // Reference of RecyclerView ....
        wRequestRideRecyclerView = view.findViewById(R.id.wRequestRideRecyclerView);
        wRequestRideBtn = view.findViewById(R.id.wOfferRideOptionBtn);
        wOfferRideBtn = view.findViewById(R.id.wOfferRideOptionBtn);

        ArrayList<W_FragmentOneModelClass> wFragmentOneModelClassArrayList = new ArrayList<>();
        // Add list item here...

        wFragmentOneModelClassArrayList.add(new W_FragmentOneModelClass(_CAR_,R.drawable.icgo_car_24dp,2,13));
        wFragmentOneModelClassArrayList.add(new W_FragmentOneModelClass(_BIKE_,R.drawable.icgo_motorcycle_24dp,3,12));
        wFragmentOneModelClassArrayList.add(new W_FragmentOneModelClass(_BUS_,R.drawable.icgo_directions_bus_24dp,2,13));
        wFragmentOneModelClassArrayList.add(new W_FragmentOneModelClass(_MINI_TRUCK_,R.drawable.icgo_mini_truck_24dp,3,12));
        wFragmentOneModelClassArrayList.add(new W_FragmentOneModelClass(_BIKE_,R.drawable.icgo_motorcycle_24dp,2,13));
        wFragmentOneModelClassArrayList.add(new W_FragmentOneModelClass(_CAR_,R.drawable.icgo_car_24dp,3,12));

        // adaptor class...
        W_FragmentOneAdaptorClass w_fragmentOneAdaptor = new W_FragmentOneAdaptorClass(wFragmentOneModelClassArrayList);

        LinearLayoutManager requestRideLinearLayout = new LinearLayoutManager( getContext());
        requestRideLinearLayout.setOrientation(LinearLayoutManager.HORIZONTAL);

        wRequestRideRecyclerView.setLayoutManager(requestRideLinearLayout);
        wRequestRideRecyclerView.setAdapter(w_fragmentOneAdaptor);

        w_fragmentOneAdaptor.notifyDataSetChanged();

    // Request Ride items in horizontally....-------------------------------

    // On Button Click ...
        wRequestRideBtn.setOnClickListener(this);
        wOfferRideBtn.setOnClickListener(this);

    // On Button Click ...

        return view;
    }

    // OnClick -----------------------
    @Override
    public void onClick(View v) {
        if (v == wRequestRideBtn){
            Drawable tempColor = wRequestRideBtn.getBackground();

            wRequestRideBtn.setBackground(wOfferRideBtn.getBackground());
            wOfferRideBtn.setBackground(tempColor);
        }
        if (v == wOfferRideBtn){
            Drawable tempColor = wOfferRideBtn.getBackground();

            wOfferRideBtn.setBackground(wRequestRideBtn.getBackground());
            wRequestRideBtn.setBackground(tempColor);

        }
    }

    // OnClick -----------------------



}
