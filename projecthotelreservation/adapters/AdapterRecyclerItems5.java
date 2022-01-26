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

import com.example.projecthotelreservation.HyderabadHotel1Activity;
import com.example.projecthotelreservation.HyderabadHotel2Activity;
import com.example.projecthotelreservation.HyderabadHotel3Activity;
import com.example.projecthotelreservation.HyderabadHotel4Activity;
import com.example.projecthotelreservation.KolkataHotel1Activity;
import com.example.projecthotelreservation.KolkataHotel2Activity;
import com.example.projecthotelreservation.KolkataHotel3Activity;
import com.example.projecthotelreservation.KolkataHotel4Activity;
import com.example.projecthotelreservation.R;
import com.example.projecthotelreservation.constant.HotelConstant;

public class AdapterRecyclerItems5 extends RecyclerView.Adapter<AdapterRecyclerItems5.AdapterInnerClass> {

    Context mContext;

    public AdapterRecyclerItems5(Context mContext) {
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
        holder.imageView.setImageResource(HotelConstant.IMAGE_HYD[position]);
        holder.textTitle.setText(HotelConstant.TITLE_HYD[position]);
        holder.textDesc.setText(HotelConstant.PRICE_HYD[position]);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (HotelConstant.TITLE_HYD[position].equals("ITC Kohenur")){
                    Intent in = new Intent(mContext, HyderabadHotel1Activity.class);
                    mContext.startActivity(in);
                }
                else if (HotelConstant.TITLE_HYD[position].equals("Mercure")){
                    Intent in = new Intent(mContext, HyderabadHotel2Activity.class);
                    mContext.startActivity(in);
                }
                else if (HotelConstant.TITLE_HYD[position].equals("Taj Falaknuma Palace")){
                    Intent in = new Intent(mContext, HyderabadHotel3Activity.class);
                    mContext.startActivity(in);
                }
                else if (HotelConstant.TITLE_HYD[position].equals("Trident")){
                    Intent in = new Intent(mContext, HyderabadHotel4Activity.class);
                    mContext.startActivity(in);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return HotelConstant.PRICE_HYD.length;
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
