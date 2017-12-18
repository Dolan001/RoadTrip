package com.project250.roadtrip;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class CarAdapter extends BaseAdapter {

    ArrayList<Car> carList;
    Activity activity;

    public CarAdapter(ArrayList<Car> carList, Activity activity) {
        this.carList = carList;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return carList.size();
    }

    @Override
    public Object getItem(int position) {
        return carList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        convertView = inflater.inflate(R.layout.custom_car_layout, null);

        TextView name = (TextView) convertView.findViewById(R.id.car1name);
        TextView price = (TextView) convertView.findViewById(R.id.priceperday);
        TextView carlocation = (TextView) convertView.findViewById(R.id.carlocation);
        TextView date = (TextView) convertView.findViewById(R.id.date);
        TextView time = (TextView) convertView.findViewById(R.id.time);

        name.setText(carList.get(position).getCarname());
        price.setText(carList.get(position).getPriceperday());
        carlocation.setText(carList.get(position).getCarlocation());
        date.setText(carList.get(position).getDate());
        time.setText(carList.get(position).getTime());

        return convertView;
    }
}
