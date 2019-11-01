package wackycodes.gowacky.adaptor_model_fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import wackycodes.gowacky.R;

public class W_FragmentTwoAdaptorClass extends RecyclerView.Adapter<W_FragmentTwoAdaptorClass.BookingInfoViewHolder> {



    private ArrayList<W_FragmentTwoModelClass> wFragmentTwoModelClassArrayList;

    public W_FragmentTwoAdaptorClass(ArrayList<W_FragmentTwoModelClass> wFragmentTwoModelClassArrayList) {
        this.wFragmentTwoModelClassArrayList = wFragmentTwoModelClassArrayList;
    }

    @NonNull
    @Override
    public BookingInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.w_fragment_two_passager_info_item,parent,false);
        W_FragmentTwoAdaptorClass.BookingInfoViewHolder bookingInfoViewHolder = new BookingInfoViewHolder(view);
        return bookingInfoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BookingInfoViewHolder holder, int position) {
        W_FragmentTwoModelClass w_fragmentTwoModelClass = wFragmentTwoModelClassArrayList.get(position);
        holder.wPassengerName.setText(w_fragmentTwoModelClass.getwPassengerName());
        holder.wPassengerGender.setText(w_fragmentTwoModelClass.getwPassengerGender());
        holder.wPassengerAge.setText(Integer.toString(w_fragmentTwoModelClass.getwPassengerAge()));
        holder.wPassengerStartingPoint.setText(w_fragmentTwoModelClass.getwPassengerStartingPoint());
        holder.wPassengerEndPoint.setText(w_fragmentTwoModelClass.getwPassengerEndPoint());
        holder.wCallToPassengerTV.setText(w_fragmentTwoModelClass.getwCallToPassengerTV());
        holder.wMessageToPassengerTV.setText(w_fragmentTwoModelClass.getwMessageToPassengerTV());
//        holder.wPassengerOtpET.setText(Integer.toString(w_fragmentTwoModelClass.getwPassengerOtpET()));
    }

    @Override
    public int getItemCount() {
        return wFragmentTwoModelClassArrayList.size();
    }

    public static class BookingInfoViewHolder extends RecyclerView.ViewHolder{
        // variable declaration...
        public TextView wPassangerNo;
        public TextView wPassengerName,wPassengerGender,wPassengerAge;
        public TextView wPassengerStartingPoint,wPassengerEndPoint;
        public TextView wCallToPassengerTV, wMessageToPassengerTV;
        public EditText wPassengerOtpET;

        public BookingInfoViewHolder(@NonNull View itemView) {
            super(itemView);
            wPassengerName = itemView.findViewById(R.id.wPassengerName);
            wPassengerGender = itemView.findViewById(R.id.wPassengerGender);
            wPassengerAge = itemView.findViewById(R.id.wPassengerAge);
            wPassengerStartingPoint = itemView.findViewById(R.id.wPassengerStartingPoint);
            wPassengerEndPoint = itemView.findViewById(R.id.wPassengerEndPoint);
            wCallToPassengerTV = itemView.findViewById(R.id.wCallToPassengerTV);
            wMessageToPassengerTV = itemView.findViewById(R.id.wMessageToPassengerTV);
            wPassengerOtpET = itemView.findViewById(R.id.wPassengerOtpET);
        }
    }

}
