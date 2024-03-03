package in.learncodewithrk.smartsociety.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import in.learncodewithrk.smartsociety.R;

public class vistor_page extends AppCompatActivity {
    TextInputLayout name, contact, email;
    FloatingActionButton fb;
    Button sbmt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vistor_page);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        name = (TextInputLayout) findViewById(R.id.nametext);
        contact = (TextInputLayout) findViewById(R.id.contacttext);
        email = (TextInputLayout) findViewById(R.id.emailtext);
        fb = (FloatingActionButton) findViewById(R.id.fbtn);
        sbmt = (Button) findViewById(R.id.sbmt_add);


        sbmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                processinsert(name.getEditText().getText().toString(),contact.getEditText().getText().toString(),email.getEditText().getText().toString());
            }
        });


        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),fetchdata.class));
            }
        });


    }

    private void processinsert(String n, String c, String e)
    {
        String res=new dbmanager(this).addrecord(n,c,e);
        name.getEditText().setText("");
        contact.getEditText().setText("");
        email.getEditText().setText("");
        Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();
    }


}