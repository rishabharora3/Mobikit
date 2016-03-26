package com.mobikit.mobikit.topphone;

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
 * Created by Rishabh on 30-11-2015.
 */
public class topphonesadapter extends RecyclerView.Adapter<topphonesadapter.MyViewHolder> {

    private LayoutInflater inflater;
    List<topphoneslist> data = Collections.emptyList();
    private Context context;
    private ClickListener clickListener;

    public topphonesadapter(Context context, List<topphoneslist> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.topphonesrow, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        topphoneslist current = data.get(position);
        holder.title.setText(current.title);
        holder.title1.setText(current.title1);
        holder.title2.setText(current.title2);
        holder.icon.setImageResource(current.iconId);
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title, title1, title2;
        ImageView icon;
        CheckBox ch;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title = (TextView) itemView.findViewById(R.id.topphoneslistText);
            icon = (ImageView) itemView.findViewById(R.id.topphoneslistIcon);
            title1 = (TextView) itemView.findViewById(R.id.topphoneslistText1);
            title2 = (TextView) itemView.findViewById(R.id.topphoneslistText2);
            ch= (CheckBox) itemView.findViewById(R.id.topphonescheck);
            Typeface typeface = Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/banksb20.ttf");
            this.title.setTypeface(typeface);
            this.title1.setTypeface(Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/RobotoSlab-Regular.ttf"));
            this.title2.setTypeface(Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/RobotoSlab-Light.ttf"));

        }

        @Override
        public void onClick(View view) {

            //context.startActivity(new Intent(context, sggp4gg531f.class));
            if (clickListener != null) {
                clickListener.itemClicked(view, getAdapterPosition());
            }
        }
    }

    public interface ClickListener {
        public void itemClicked(View view, int position);

    }
}
