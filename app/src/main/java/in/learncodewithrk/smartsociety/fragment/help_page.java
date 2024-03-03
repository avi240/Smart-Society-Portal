package in.learncodewithrk.smartsociety.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import in.learncodewithrk.smartsociety.R;

public class help_page extends AppCompatActivity {

    Button callnow1,callnow2,callnow3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_page);

        callnow1 = findViewById(R.id.callnow1);

        callnow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:7820906537"));
                startActivity(intent);
            }
        });

        callnow2 = findViewById(R.id.callnow2);

        callnow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:7820906537"));
                startActivity(intent);
            }
        });

        callnow3 = findViewById(R.id.callnow3);

        callnow3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:7820906537"));
                startActivity(intent);
            }
        });

    }
}