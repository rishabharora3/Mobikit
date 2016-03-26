package com.mobikit.mobikit.samsungphones.sggp4gg531f;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobikit.mobikit.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by Rishabh on 28-11-2015.
 */
public class frag5adaptersggp4gg531f extends RecyclerView.Adapter<frag5adaptersggp4gg531f.MyViewHolder> {
    private final LayoutInflater inflater;
    List<rowinfofrag5sggp4gg531f> data = Collections.emptyList();

    public frag5adaptersggp4gg531f(Context context, List<rowinfofrag5sggp4gg531f> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.rowfrag5sggp4gg531f, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        rowinfofrag5sggp4gg531f current = data.get(position);
        holder.titleadp1.setText(current.title);
        holder.titleadp2.setText(current.title1);
        holder.i1.setImageResource(current.iconID);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView titleadp1, titleadp2;
        ImageView i1;

        public MyViewHolder(View itemView) {
            super(itemView);
            titleadp1 = (TextView) itemView.findViewById(R.id.listTextfrag5sggp4gg531f);
            titleadp2 = (TextView) itemView.findViewById(R.id.listText1frag5sggp4gg531f);
            i1 = (ImageView) itemView.findViewById(R.id.listIconfrag5sggp4gg531f);
            Typeface typeface = Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/banksb20.ttf");
            this.titleadp1.setTypeface(typeface);
            this.titleadp2.setTypeface(Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/RobotoSlab-Regular.ttf"));
        }
    }

}
