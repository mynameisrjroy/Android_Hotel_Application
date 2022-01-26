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

import com.example.projecthotelreservation.KolkataHotel1Activity;
import com.example.projecthotelreservation.KolkataHotel2Activity;
import com.example.projecthotelreservation.KolkataHotel3Activity;
import com.example.projecthotelreservation.KolkataHotel4Activity;
import com.example.projecthotelreservation.MainActivity;
import com.example.projecthotelreservation.R;
import com.example.projecthotelreservation.RoomBookActivity;
import com.example.projecthotelreservation.RoomViewActivity;
import com.example.projecthotelreservation.constant.HotelConstant;

public class AdapterRecyclerItems extends RecyclerView.Adapter<AdapterRecyclerItems.AdapterInnerClass> {

    Context mContext;

    public AdapterRecyclerItems(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public AdapterRecyclerItems.AdapterInnerClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View myLayout = inflater.inflate(R.layout.recycler_items, parent, false);
        AdapterInnerClass adapterInnerClass = new AdapterInnerClass(myLayout);
        return adapterInnerClass;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecyclerItems.AdapterInnerClass holder, final int position) {
        holder.imageView.setImageResource(HotelConstant.IMAGE_KOL[position]);
        holder.textTitle.setText(HotelConstant.TITLE_KOL[position]);
        holder.textDesc.setText(HotelConstant.PRICE_KOL[position]);
//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent in = new Intent(mContext, RoomBookActivity.class);
//                in.putExtra("price", HotelConstant.PRICE_KOL[position]);
//                mContext.startActivity(in);
//            }
//        });

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (HotelConstant.TITLE_KOL[position].equals("Hyatt Regency")){
                    Intent in = new Intent(mContext, KolkataHotel1Activity.class);
                    mContext.startActivity(in);
                }
                else if (HotelConstant.TITLE_KOL[position].equals("JW Marriott")){
                    Intent in = new Intent(mContext, KolkataHotel2Activity.class);
                    mContext.startActivity(in);
                }
                else if (HotelConstant.TITLE_KOL[position].equals("The Oberoi")){
                    Intent in = new Intent(mContext, KolkataHotel3Activity.class);
                    mContext.startActivity(in);
                }
                else if (HotelConstant.TITLE_KOL[position].equals("Royal Bengal")){
                    Intent in = new Intent(mContext, KolkataHotel4Activity.class);
                    mContext.startActivity(in);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return HotelConstant.PRICE_KOL.length;
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
