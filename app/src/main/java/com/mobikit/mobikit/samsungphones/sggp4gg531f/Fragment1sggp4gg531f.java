package com.mobikit.mobikit.samsungphones.sggp4gg531f;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobikit.mobikit.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rishabh on 07-10-2015.
 */
public class Fragment1sggp4gg531f extends Fragment {
    private RecyclerView recyclerView;

    private rvadapterfrag1sggp4gg531f rvadapterfrag1sggp4gg531f;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_1sggp4gg531f, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.RVfragment1sggp4gg531f);
       rvadapterfrag1sggp4gg531f = new rvadapterfrag1sggp4gg531f(getActivity(),getData());
       recyclerView.setAdapter(rvadapterfrag1sggp4gg531f);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return layout;


    }

    public static List<SpecsInfofrag1sggp4gg531f>   getData()

    {
        List<SpecsInfofrag1sggp4gg531f> data = new ArrayList<>();
        String[] titles1 = {"Released","Operating System","CPU","RAM","Size","Type","Pixel Density","Card Slot","Internal Storage","External Memory","Sim Card Type","Sim Type","Network Type","Type","Rear Camera","Front Camera"};
        String[] titles2 = {"7 months ago","Android(4.4)","1.2 GHz,Qualcomm Snapdragon","1 GB","5 inches","LCD Touch Screen","220 PPI","microSD","8 GB","expandable","Micro Sim","Dual","GSM+GSM","Removable 2600maH","8mp","5mp"};
        for (int i = 0; i < titles1.length && i < titles2.length; i++) {
            SpecsInfofrag1sggp4gg531f current = new SpecsInfofrag1sggp4gg531f();
            current.title1 = titles1[i];
            current.title2 = titles2[i];
            data.add(current);


        }
        return data;
    }

}
