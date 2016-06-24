package com.example.almgwary.almgwarycalender;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {



    // get date from x days
    Date getDayFromThisDay (Date day , int n){
        Calendar c = Calendar.getInstance();
        c.setTime(day);
        c.add(Calendar.DATE, n);
        day = c.getTime();
        return  day ;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        HashSet<Date> events = new HashSet<>();
        events.add(new Date());
        events.add(getDayFromThisDay (new Date() , 2));
        events.add(getDayFromThisDay (new Date() , 5));
        events.add(getDayFromThisDay (new Date() , 20));
        events.add(getDayFromThisDay (new Date() , -3));

        CalenderView cv = ((CalenderView)findViewById(R.id.calendar_view));
        cv.updateCalendar(events);



        // assign event handler
        cv.setEventHandler(new CalenderView.EventHandler()
        {
            @Override
            public void onDayLongPress(Date date)
            {
                // show returned day
                DateFormat df = SimpleDateFormat.getDateInstance();
                Toast.makeText(MainActivity.this, df.format(date), Toast.LENGTH_SHORT).show();
            }
        });
    }



}
