package wackycodes.gowacky.adaptor_model_fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import wackycodes.gowacky.R;


public class W_FragmentTwoBookingInfoClass extends Fragment {

    private RecyclerView wPassengerInfoRecyclerView;

    public W_FragmentTwoBookingInfoClass() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.w_fragment_two_booking_info, container, false);

//   _____________________________________________________________________________

        // Reference of RecyclerView ....
        wPassengerInfoRecyclerView = view.findViewById(R.id.wPassengerInfoRecyclerView);

        ArrayList<W_FragmentTwoModelClass> wFragmentTwoModelClassArrayList = new ArrayList<>();
        // Add list item here...

        wFragmentTwoModelClassArrayList.add(new W_FragmentTwoModelClass(
                "Shailendra Lodhi",
                "M",
                "H. No. 35, Indrapuri Bhopal",
                "Bhopal Junction Relwe Station",
                "",
                "",
                22 ));
        wFragmentTwoModelClassArrayList.add(new W_FragmentTwoModelClass(
                "Tarun Bisen",
                "M",
                "GovindPura, Bhopal, Madhya Pradesh",
                "Petrol Pump, Ratnagiri, Bhopal",
                "",
                "",
                21 ));
        wFragmentTwoModelClassArrayList.add(new W_FragmentTwoModelClass(
                "Shruti Bhimte",
                "F",
                "samarat ashoka college, vidisha",
                "H. No. 56, Ratnagiri, Bhopal ",
                "",
                "",
                19 ));
        wFragmentTwoModelClassArrayList.add(new W_FragmentTwoModelClass(
                "Shruti Bhimte",
                "F",
                "samarat ashoka college, vidisha",
                "H. No. 56, Ratnagiri, Bhopal ",
                "",
                "",
                19 ));

        // Add list item here...

        // adaptor class...
        W_FragmentTwoAdaptorClass w_fragmentTwoAdaptorClass = new W_FragmentTwoAdaptorClass(wFragmentTwoModelClassArrayList);

        LinearLayoutManager passagerInfoLayoutManager = new LinearLayoutManager( getContext());
        passagerInfoLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        wPassengerInfoRecyclerView.setLayoutManager(passagerInfoLayoutManager);
        wPassengerInfoRecyclerView.setAdapter(w_fragmentTwoAdaptorClass);

        w_fragmentTwoAdaptorClass.notifyDataSetChanged();

        // Request Ride items in horizontally....-------------------------------

//   _____________________________________________________________________________

        return view;

    }



}
