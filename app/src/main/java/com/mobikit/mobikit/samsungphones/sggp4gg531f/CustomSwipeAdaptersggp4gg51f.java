package com.mobikit.mobikit.samsungphones.sggp4gg531f;

import android.content.Context;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mobikit.mobikit.R;

/**
 * Created by Rishabh on 05-10-2015.
 */
public class CustomSwipeAdaptersggp4gg51f extends PagerAdapter {
    private int[] imageResources = {R.drawable.samsunggalaxygrandprime4g, R.drawable.samsunggalaxygrandprime4g14365219391,
            R.drawable.samsunggalaxygrandprime4g14365219392, R.drawable.samsunggalaxygrandprime4g14365219393, R.drawable.samsunggalaxygrandprime4g14365219394};
    private Context ctx;
    private LayoutInflater layoutInflater;

    public CustomSwipeAdaptersggp4gg51f(Context ctx) {

        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return imageResources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {



        return (view==(CollapsingToolbarLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemVew = layoutInflater.inflate(R.layout.sggp4gg531f_swipe_layout, container, false);
        ImageView imageView = (ImageView) itemVew.findViewById(R.id.image_sggp4gg531f);
        imageView.setImageResource(imageResources[position]);
        container.addView(itemVew);
        return itemVew;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((CollapsingToolbarLayout) object);

    }
}

