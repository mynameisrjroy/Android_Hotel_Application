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

import com.example.projecthotelreservation.DelhiHotel1Activity;
import com.example.projecthotelreservation.DelhiHotel2Activity;
import com.example.projecthotelreservation.DelhiHotel3Activity;
import com.example.projecthotelreservation.DelhiHotel4Activity;
import com.example.projecthotelreservation.KolkataHotel1Activity;
import com.example.projecthotelreservation.KolkataHotel2Activity;
import com.example.projecthotelreservation.KolkataHotel3Activity;
import com.example.projecthotelreservation.KolkataHotel4Activity;
import com.example.projecthotelreservation.R;
import com.example.projecthotelreservation.constant.HotelConstant;

public class AdapterRecyclerItems3 extends RecyclerView.Adapter<AdapterRecyclerItems3.AdapterInnerClass> {

    Context mContext;

    public AdapterRecyclerItems3(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public AdapterInnerClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View myLayout = inflater.inflate(R.layout.recycler_items, parent, false);
        AdapterInnerClass adapterInnerClass = new AdapterInnerClass(myLayout);
        return adapterInnerClass;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterInnerClass holder, final int position) {
        holder.imageView.setImageResource(HotelConstant.IMAGE_DEL[position]);
        holder.textTitle.setText(HotelConstant.TITLE_DEL[position]);
        holder.textDesc.setText(HotelConstant.PRICE_DEL[position]);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (HotelConstant.TITLE_DEL[position].equals("The Lodhi")){
                    Intent in = new Intent(mContext, DelhiHotel1Activity.class);
                    mContext.startActivity(in);
                }
                else if (HotelConstant.TITLE_DEL[position].equals("The Imperial")){
                    Intent in = new Intent(mContext, DelhiHotel2Activity.class);
                    mContext.startActivity(in);
                }
                else if (HotelConstant.TITLE_DEL[position].equals("Maidens")){
                    Intent in = new Intent(mContext, DelhiHotel3Activity.class);
                    mContext.startActivity(in);
                }
                else if (HotelConstant.TITLE_DEL[position].equals("Roseate House")){
                    Intent in = new Intent(mContext, DelhiHotel4Activity.class);
                    mContext.startActivity(in);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return HotelConstant.PRICE_DEL.length;
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
