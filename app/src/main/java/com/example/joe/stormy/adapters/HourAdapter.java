package com.example.joe.stormy.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joe.stormy.R;
import com.example.joe.stormy.Weather.Hour;

import org.w3c.dom.Text;

/**
 * Created by Joe on 9/20/2015.
 */
public class HourAdapter extends RecyclerView.Adapter<HourAdapter.HourViewHolder>{

    private Hour[] mHours;

    public HourAdapter(Hour[] hours){
        mHours=hours;
    }

    @Override
    public HourViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hourly_list_item,parent,false);
        HourViewHolder viewHolder = new HourViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HourViewHolder holder, int position) {
        holder.bindHour(mHours[position]);
    }

    @Override
    public int getItemCount() {
        return mHours.length;
    }

    public class HourViewHolder extends RecyclerView.ViewHolder{
        public TextView mTimeLabel;
        public TextView mSummaryLabel;
        public TextView mTemperature;
        public ImageView mIconImageView;

        public HourViewHolder(View itemView) {
            super(itemView);
            mTimeLabel = (TextView) itemView.findViewById(R.id.timeLabel);
            mSummaryLabel = (TextView) itemView.findViewById(R.id.summaryLabel);
            mTemperature = (TextView) itemView.findViewById(R.id.temperatureLabel);
            mIconImageView = (ImageView) itemView.findViewById(R.id.iconImageView);
        }
        public void bindHour(Hour hour){
            mTimeLabel.setText(hour.getHour());
            mSummaryLabel.setText(hour.getSummary());
            mTemperature.setText(hour.getTemperature()+ "");
            mIconImageView.setImageResource(hour.getIconId());
        }
    }
}