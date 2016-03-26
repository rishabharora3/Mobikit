package com.mobikit.mobikit.HTCphones;


import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobikit.mobikit.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by Rishabh on 05-10-2015.
 */
public class htcAdapter extends RecyclerView.Adapter<htcAdapter.MyViewHolder>{
    private final LayoutInflater inflater;
    List<htcList> data= Collections.emptyList();
    private Context context;
    private ClickListener clickListener;

    public htcAdapter(Context context,List<htcList> data) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.data = data;

    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.htc_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
       htcList current=data.get(position);
        holder.titleadp.setText(current.title);
        holder.titleadp1.setText(current.title1);
        holder.titleadp2.setText(current.title2);
        holder.iconadp.setImageResource(current.iconId);
    }
    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;

    }
    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView titleadp, titleadp1, titleadp2;
        ImageView iconadp;
        CheckBox chadp;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            titleadp = (TextView) itemView.findViewById(R.id.listhtcText);
            iconadp = (ImageView) itemView.findViewById(R.id.listhtcIcon);
            titleadp1 = (TextView) itemView.findViewById(R.id.listhtcText1);
            titleadp2 = (TextView) itemView.findViewById(R.id.listhtcText2);
            chadp= (CheckBox) itemView.findViewById(R.id.htccheck);
            Typeface typeface = Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/banksb20.ttf");
            this.titleadp.setTypeface(typeface);
            this.titleadp1.setTypeface(Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/RobotoSlab-Regular.ttf"));
            this.titleadp2.setTypeface(Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/RobotoSlab-Light.ttf"));
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) {
                clickListener.itemClicked(view, getAdapterPosition());
            }
        }
    }
    public interface ClickListener {
        public void itemClicked(View view, int position);

    }

}
