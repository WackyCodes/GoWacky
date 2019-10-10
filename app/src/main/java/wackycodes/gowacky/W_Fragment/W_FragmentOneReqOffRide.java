package wackycodes.gowacky.W_Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import wackycodes.gowacky.R;

public class W_FragmentOneReqOffRide extends Fragment {

    // Final Static...
    private static final int _CAR_ = 1901, _BIKE_ = 1902, _MINI_TRUCK_ = 1903;
    // Variable declaration ...
    private RecyclerView wRequestRideRecyclerView;


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
       View view =  inflater.inflate(R.layout.w__fragment__one_request_ride, container, false);


   // Request Ride items in horizontally....--------------------------------

        // Reference of RecyclerView ....
        wRequestRideRecyclerView = view.findViewById(R.id.wRequestRideRecyclerView);

        ArrayList<W_FragmentOneModelClass> wFragmentOneModelClassArrayList = new ArrayList<>();
        // Add list item here...

        wFragmentOneModelClassArrayList.add(new W_FragmentOneModelClass(_CAR_,R.drawable.icgo_car_24dp,2,13));
        wFragmentOneModelClassArrayList.add(new W_FragmentOneModelClass(_CAR_,R.drawable.icgo_car_24dp,3,12));
        wFragmentOneModelClassArrayList.add(new W_FragmentOneModelClass(_CAR_,R.drawable.icgo_car_24dp,2,13));
        wFragmentOneModelClassArrayList.add(new W_FragmentOneModelClass(_CAR_,R.drawable.icgo_car_24dp,3,12));
        wFragmentOneModelClassArrayList.add(new W_FragmentOneModelClass(_CAR_,R.drawable.icgo_car_24dp,2,13));
        wFragmentOneModelClassArrayList.add(new W_FragmentOneModelClass(_CAR_,R.drawable.icgo_car_24dp,3,12));

        // adaptor class...
        W_FragmentOneAdaptorClass w_fragmentOneAdaptor = new W_FragmentOneAdaptorClass(wFragmentOneModelClassArrayList);

        LinearLayoutManager requestRideLinearLayout = new LinearLayoutManager( getContext());
        requestRideLinearLayout.setOrientation(LinearLayoutManager.HORIZONTAL);

        wRequestRideRecyclerView.setLayoutManager(requestRideLinearLayout);
        wRequestRideRecyclerView.setAdapter(w_fragmentOneAdaptor);

        w_fragmentOneAdaptor.notifyDataSetChanged();

    // Request Ride items in horizontally....--------------------------------
        return view;
    }


}
