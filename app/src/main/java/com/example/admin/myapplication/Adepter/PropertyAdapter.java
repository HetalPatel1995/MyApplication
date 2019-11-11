package com.example.admin.myapplication.Adepter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.myapplication.Helper.Property;
import com.example.admin.myapplication.R;

import java.util.List;

public class PropertyAdapter extends RecyclerView.Adapter<PropertyAdapter.ProductViewHolder> {
private  List<Property> itemList;
    private Context mCtx;
//    PropertyResponce propertyResponce;
    private PropertyInterface propertyInterface;


    public PropertyAdapter(Context mCtx,List<Property> itemList) {
        this.mCtx = mCtx;
        this.itemList=itemList;
//        this.propertyResponce = propertyResponce;
    }

    public interface PropertyInterface{
        void click(String data, int pos);
    }

    public void setUpInterface(PropertyInterface upInterface){
        this.propertyInterface=upInterface;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.view_data_list, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, final int position) {

//        Paper.init(mCtx);

//        String Address = propertyResponce.getProperty().get(position).getPropertySovietyName() + " ,"+propertyResponce.getProperty().get(position).getPropertyCity()+ " ," + propertyResponce.getProperty().get(position).getPropertyState();
//
//        holder.textViewTitle.setText(propertyResponce.getProperty().get(position).getPropertyBuy());
//        holder.textViewShortDesc.setText(propertyResponce.getProperty().get(position).getPropertyDescription());
//        holder.textViewAddress.setText(Address);
//        holder.textViewPrice.setText("₹ "+propertyResponce.getProperty().get(position).getPropertyPrice()+".00");
////        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(property.getImage()));
//        holder.BtnChat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mCtx.startActivity(new Intent(mCtx, ChatView.class));
//            }
//        });
//
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                propertyInterface.click(propertyResponce.getProperty().get(position).getPropertyId(),position);
//            }
//        });

        Property viewdata = itemList.get(position);

        holder.TxtName.setText(viewdata.getName());
//        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(viewdata.getImage()));
        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(viewdata.getImage()));
    }


    @Override
    public int getItemCount() {

//        return propertyResponce.getProperty().size();
        return itemList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView   TxtName;
        ImageView imageView;
//        Button BtnChat,BtnViewPhone;
        CardView property_card;

        public ProductViewHolder(View itemView) {
            super(itemView);


            TxtName = itemView.findViewById(R.id.HomeName);
            imageView = itemView.findViewById(R.id.ImgPgHome);
            property_card = itemView.findViewById(R.id.property_card);

        }
    }
}
