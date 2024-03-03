package in.learncodewithrk.smartsociety.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.google.android.gms.common.internal.service.Common;

import java.util.Objects;

import in.learncodewithrk.smartsociety.R;

public class HomeFragment extends Fragment {
    View v;

   ImageView dashevent,dashannouce,help,dashpayment,dashintruder,dashcomplaint,dashfirealarm,Dashadmin;

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_home, container, false);

        dashevent = v.findViewById(R.id.dashevent);
        dashevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), EventActivity.class);
                startActivity(intent);
            }
        });


        dashannouce = v.findViewById(R.id.dashannouce);
        dashannouce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MYsociety_page.class);
                startActivity(intent);
            }
        });

        help = v.findViewById(R.id.help);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), help_page.class);
                startActivity(intent);
            }
        });

        dashpayment = v.findViewById(R.id.dashpayment);
        dashpayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), payment_page.class);
                startActivity(intent);
            }
        });

        dashintruder = v.findViewById(R.id.dashintruder);
        dashintruder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), vistor_page.class);
                startActivity(intent);
            }
        });

        dashcomplaint = v.findViewById(R.id.dashcomplaint);
        dashcomplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Announcement.class);
                startActivity(intent);
            }
        });


        dashfirealarm = v.findViewById(R.id.dashfirealarm);
        dashfirealarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), notice.class);
                startActivity(intent);
            }
        });

        Dashadmin = v.findViewById(R.id.Dashadmin);
        Dashadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), RoomM.class);
                startActivity(intent);
            }
        });



        return v;
    }
}