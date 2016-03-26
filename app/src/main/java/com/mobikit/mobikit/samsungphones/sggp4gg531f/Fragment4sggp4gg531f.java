package com.mobikit.mobikit.samsungphones.sggp4gg531f;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.mobikit.mobikit.R;

/**
 * Created by Rishabh on 07-10-2015.
 */
public class Fragment4sggp4gg531f extends Fragment {
    ImageView i1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View layout=inflater.inflate(R.layout.fragment_4sggp4gg531f, container, false);
        i1=(ImageView)layout.findViewById(R.id.ytdsggp4gg531f);
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), YouTube.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        return layout;
    }
}
