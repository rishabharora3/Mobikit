package com.mobikit.mobikit.samsungphones.sggp4gg531f;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mobikit.mobikit.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by Rishabh on 07-10-2015.
 */
public class rvadapterfrag1sggp4gg531f extends RecyclerView.Adapter<rvadapterfrag1sggp4gg531f.MyViewHolder> {
    private final LayoutInflater inflater;
    List<SpecsInfofrag1sggp4gg531f> data = Collections.emptyList();

    public rvadapterfrag1sggp4gg531f(Context context,List<SpecsInfofrag1sggp4gg531f> data ) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.specscustomrowfrag1sggp4gg531f, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        SpecsInfofrag1sggp4gg531f current = data.get(position);
        holder.titleadp1.setText(current.title1);
        holder.titleadp2.setText(current.title2);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView titleadp1, titleadp2;

        public MyViewHolder(View itemView) {
            super(itemView);
            titleadp1 = (TextView) itemView.findViewById(R.id.specstext1frag1sggp4gg531f);
            titleadp2 = (TextView) itemView.findViewById(R.id.specstext2frag1sggp4gg531f);
            Typeface typeface = Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/RobotoSlab-Regular.ttf");
            this.titleadp1.setTypeface(typeface);
            this.titleadp2.setTypeface(typeface);
        }
    }

}

