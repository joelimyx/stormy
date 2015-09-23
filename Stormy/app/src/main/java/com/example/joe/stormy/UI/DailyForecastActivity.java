package com.example.joe.stormy.UI;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.joe.stormy.R;
import com.example.joe.stormy.Weather.Day;
import com.example.joe.stormy.adapters.DayAdapter;

import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DailyForecastActivity extends AppCompatActivity {
    private Day[] mDays;
    @Bind(android.R.id.list) ListView mListView;
    @Bind(android.R.id.empty) TextView mEmptyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        Parcelable[] parcelable =intent.getParcelableArrayExtra(MainActivity.DAILY_FORECAST);
        mDays = Arrays.copyOf(parcelable, parcelable.length,Day[].class);
        DayAdapter adapter = new DayAdapter(this, mDays);
        mListView.setAdapter(adapter);
        mListView.setEmptyView(mEmptyTextView);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String dayOfTheWeek= mDays[position].getDayOfTheWeek();
                String condition = mDays[position].getSummary();
                String highTemp = mDays[position].getTemperatureMax()+"";
                String message = String.format("On %s, the high temperature will be %s and it will be %s",
                        dayOfTheWeek,
                        highTemp,
                        condition);
                Toast.makeText(DailyForecastActivity.this, message,Toast.LENGTH_LONG).show();
            }
        });
    }
}
