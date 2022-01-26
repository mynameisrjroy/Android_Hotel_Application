package com.example.projecthotelreservation.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecthotelreservation.R;
import com.example.projecthotelreservation.RoomBookActivity;
import com.example.projecthotelreservation.constant.HotelConstant;

public class AdapterMum1 extends RecyclerView.Adapter<AdapterMum1.AdapterInnerClass> {

    Context mContext;

    public AdapterMum1(Context mContext){
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public AdapterInnerClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View myLayout = inflater.inflate(R.layout.recycler_mum1, parent, false);
        AdapterInnerClass adapterInnerClass = new AdapterInnerClass(myLayout);
        return adapterInnerClass;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterInnerClass holder, final int position) {
        holder.imageView.setImageResource(HotelConstant.IMAGE_MUM_HOTEL1[position]);
        holder.textTitle.setText(HotelConstant.TITLE_MUM_HOTEL1[position]);
        holder.textDesc.setText(HotelConstant.PRICE_MUM_HOTEL1[position]);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(mContext, RoomBookActivity.class);
                in.putExtra("rtype", HotelConstant.TITLE_MUM_HOTEL1[position]);
                in.putExtra("price", HotelConstant.PRICE_MUM_HOTEL1[position]);
                mContext.startActivity(in);
            }
        });
    }

    @Override
    public int getItemCount() {
        return HotelConstant.PRICE_MUM_HOTEL1.length;
    }

    public class AdapterInnerClass extends RecyclerView.ViewHolder {

        private CardView cardView;
        private TextView textTitle, textDesc;
        private ImageView imageView;

        public AdapterInnerClass(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardItem);
            textTitle = itemView.findViewById(R.id.textItem1);
            textDesc = itemView.findViewById(R.id.textItem2);
            imageView = itemView.findViewById(R.id.imageItem);
        }
    }
}
