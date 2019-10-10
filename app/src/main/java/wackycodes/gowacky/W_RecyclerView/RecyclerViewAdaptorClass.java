package wackycodes.gowacky.W_RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import wackycodes.gowacky.R;

public class RecyclerViewAdaptorClass extends RecyclerView.Adapter<RecyclerViewAdaptorClass.ViewHolder> {


    private List<RecyclerViewModelClass> offerRecyclerViewModelList;

    public RecyclerViewAdaptorClass(List <RecyclerViewModelClass> offerRecyclerViewModelList) {
        this.offerRecyclerViewModelList = offerRecyclerViewModelList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from( viewGroup.getContext() ).inflate( R.layout.w_fragment_one_requst_ride_item, viewGroup,false);
        return new ViewHolder( view ) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        int resource = offerRecyclerViewModelList.get( position ).getxOfferItemImage();
        String price = offerRecyclerViewModelList.get( position ).getxOfferItemPrice();
        String name = offerRecyclerViewModelList.get( position ).getxOfferItemName();


    }



    @Override
    public int getItemCount() {
        return offerRecyclerViewModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView wVehicleImage;
        private TextView wAvailableSeaats, wVehicleReachTime,wVehicleType;

        public ViewHolder(View itemView) {
            super( itemView );
//            xOfferItemImage = itemView.findViewById( R.id.x_offer_item_image );
//            xOfferItemPrice = itemView.findViewById( R.id.x_offer_item_price );
//            xOfferItemName = itemView.findViewById( R.id.x_offer_item_name);
        }


    }
}