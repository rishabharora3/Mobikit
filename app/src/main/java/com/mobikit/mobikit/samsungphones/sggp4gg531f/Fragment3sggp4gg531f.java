package com.mobikit.mobikit.samsungphones.sggp4gg531f;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.mobikit.mobikit.R;

/**
 * Created by Rishabh on 07-10-2015.
 */
public class Fragment3sggp4gg531f extends Fragment {
    ImageView i1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_3sggp4gg531f, container, false);
        i1 = (ImageView) layout.findViewById(R.id.gmapssggp4gg531f);
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Linked to another app!",Toast.LENGTH_SHORT).show();
                openApp(getActivity(), "com.example.sony.demomaps");
            }
        });

        return layout;

    }
    public static boolean openApp(Context context, String packageName) {
        PackageManager manager = context.getPackageManager();
        try {
            Intent i = manager.getLaunchIntentForPackage(packageName);
            if (i == null) {
                return false;
                //throw new PackageManager.NameNotFoundException();
            }
            i.addCategory(Intent.CATEGORY_LAUNCHER);
            context.startActivity(i);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
