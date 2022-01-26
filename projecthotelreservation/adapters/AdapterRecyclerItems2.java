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
import com.example.projecthotelreservation.MumbaiHotel1Activity;
import com.example.projecthotelreservation.MumbaiHotel2Activity;
import com.example.projecthotelreservation.MumbaiHotel3Activity;
import com.example.projecthotelreservation.MumbaiHotel4Activity;
import com.example.projecthotelreservation.R;
import com.example.projecthotelreservation.constant.HotelConstant;

import java.util.zip.Inflater;

public class AdapterRecyclerItems2 extends RecyclerView.Adapter<AdapterRecyclerItems2.AdapterInnerClass> {

    Context mContext;

    public AdapterRecyclerItems2(Context mContext){
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
        holder.imageView.setImageResource(HotelConstant.IMAGE_MUM[position]);
        holder.textTitle.setText(HotelConstant.TITLE_MUM[position]);
        holder.textDesc.setText(HotelConstant.PRICE_MUM[position]);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (HotelConstant.TITLE_MUM[position].equals("Four Seasons")){
                    Intent in = new Intent(mContext, MumbaiHotel1Activity.class);
                    mContext.startActivity(in);
                }
                else if (HotelConstant.TITLE_MUM[position].equals("Hilton")){
                    Intent in = new Intent(mContext, MumbaiHotel2Activity.class);
                    mContext.startActivity(in);
                }
                else if (HotelConstant.TITLE_MUM[position].equals("Maratha")){
                    Intent in = new Intent(mContext, MumbaiHotel3Activity.class);
                    mContext.startActivity(in);
                }
                else if (HotelConstant.TITLE_MUM[position].equals("Taj Palace")){
                    Intent in = new Intent(mContext, MumbaiHotel4Activity.class);
                    mContext.startActivity(in);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return HotelConstant.PRICE_MUM.length;
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
