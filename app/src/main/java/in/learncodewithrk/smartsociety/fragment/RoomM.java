package in.learncodewithrk.smartsociety.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;


import java.util.ArrayList;
import java.util.List;

import in.learncodewithrk.smartsociety.R;

public class RoomM extends AppCompatActivity {
    List<Book> lstBook ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_m);


        lstBook = new ArrayList<>();
        lstBook.add(new Book("2 Bedroom","Apartment","home is on the 8th floor & comes with ample parking place for car and bike. This home faces the East direction",R.drawable.img1));
        lstBook.add(new Book("2 Bedroom","Apartment","home is on the 8th floor & comes with ample parking place for car and bike. This home faces the East direction",R.drawable.img2));
        lstBook.add(new Book("2 Bedroom","Apartment","home is on the 8th floor & comes with ample parking place for car and bike. This home faces the East direction",R.drawable.img3));
        lstBook.add(new Book("2 Bedroom","Apartment","home is on the 8th floor & comes with ample parking place for car and bike. This home faces the East direction",R.drawable.img4));
        lstBook.add(new Book("2 Bedroom","Apartment","home is on the 8th floor & comes with ample parking place for car and bike. This home faces the East direction",R.drawable.img5));
        lstBook.add(new Book("2 Bedroom","Apartment","home is on the 8th floor & comes with ample parking place for car and bike. This home faces the East direction",R.drawable.img6));
        lstBook.add(new Book("2 Bedroom","Apartment","home is on the 8th floor & comes with ample parking place for car and bike. This home faces the East direction",R.drawable.img7));
        lstBook.add(new Book("2 Bedroom","Apartment","home is on the 8th floor & comes with ample parking place for car and bike. This home faces the East direction",R.drawable.img8));
        lstBook.add(new Book("2 Bedroom","Apartment","home is on the 8th floor & comes with ample parking place for car and bike. This home faces the East direction",R.drawable.img9));



        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,lstBook);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);


    }
}