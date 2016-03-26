package com.mobikit.mobikit.samsungphones.sggp4gg531f;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobikit.mobikit.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by Rishabh on 24-11-2015.
 */
public class onlinestoresfrag2adapter extends RecyclerView.Adapter<onlinestoresfrag2adapter.MyViewHolder> {
    private final LayoutInflater inflater;
    List<infoonlinestoresfrag2sggp4gg531f> data = Collections.emptyList();
    private Context context;
    private ClickListener clickListener;


    public onlinestoresfrag2adapter(Context context, List<infoonlinestoresfrag2sggp4gg531f> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.rowfrag2onlinestoressggp4gg531f, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        infoonlinestoresfrag2sggp4gg531f current = data.get(position);
        holder.titleadp1.setText(current.title);
        holder.titleadp2.setText(current.title1);
        holder.titleadp3.setText(current.title2);
        holder.i1.setImageResource(current.iconID);
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView i1;
        TextView titleadp1, titleadp2, titleadp3;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            i1 = (ImageView) itemView.findViewById(R.id.listIconfrag2onlinestoressggp4gg531f);
            titleadp1 = (TextView) itemView.findViewById(R.id.listTextfrag2onlinestoressggp4gg531f);
            titleadp2 = (TextView) itemView.findViewById(R.id.listText1frag2onlinestoressggp4gg531f);
            titleadp3 = (TextView) itemView.findViewById(R.id.listText2frag2onlinestoressggp4gg531f);
            Typeface typeface = Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/banksb20.ttf");
            this.titleadp1.setTypeface(typeface);
            this.titleadp2.setTypeface(Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/RobotoSlab-Regular.ttf"));
            this.titleadp3.setTypeface(Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/RobotoSlab-Light.ttf"));
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
