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

import com.example.projecthotelreservation.ChennaiHotel1Activity;
import com.example.projecthotelreservation.ChennaiHotel2Activity;
import com.example.projecthotelreservation.ChennaiHotel3Activity;
import com.example.projecthotelreservation.ChennaiHotel4Activity;
import com.example.projecthotelreservation.KolkataHotel1Activity;
import com.example.projecthotelreservation.KolkataHotel2Activity;
import com.example.projecthotelreservation.KolkataHotel3Activity;
import com.example.projecthotelreservation.KolkataHotel4Activity;
import com.example.projecthotelreservation.R;
import com.example.projecthotelreservation.constant.HotelConstant;

public class AdapterRecyclerItems4 extends RecyclerView.Adapter<AdapterRecyclerItems4.AdapterInnerClass> {

    Context mContext;

    public AdapterRecyclerItems4(Context mContext) {
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
        holder.imageView.setImageResource(HotelConstant.IMAGE_CHE[position]);
        holder.textTitle.setText(HotelConstant.TITLE_CHE[position]);
        holder.textDesc.setText(HotelConstant.PRICE_CHE[position]);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (HotelConstant.TITLE_CHE[position].equals("Citadines")){
                    Intent in = new Intent(mContext, ChennaiHotel1Activity.class);
                    mContext.startActivity(in);
                }
                else if (HotelConstant.TITLE_CHE[position].equals("Feathers")){
                    Intent in = new Intent(mContext, ChennaiHotel2Activity.class);
                    mContext.startActivity(in);
                }
                else if (HotelConstant.TITLE_CHE[position].equals("Leela Palace")){
                    Intent in = new Intent(mContext, ChennaiHotel3Activity.class);
                    mContext.startActivity(in);
                }
                else if (HotelConstant.TITLE_CHE[position].equals("Novotel")){
                    Intent in = new Intent(mContext, ChennaiHotel4Activity.class);
                    mContext.startActivity(in);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return HotelConstant.PRICE_CHE.length;
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
