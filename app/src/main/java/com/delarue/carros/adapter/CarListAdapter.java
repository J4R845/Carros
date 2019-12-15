package com.delarue.carros.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.delarue.carros.R;
import com.delarue.carros.entities.Car;
import com.delarue.carros.listener.OnListClickInteractionListener;
import com.delarue.carros.viewHolder.CarViewHolder;

import java.util.List;

public class CarListAdapter extends RecyclerView.Adapter<CarViewHolder>{

    private List<Car> mListCars;
    private OnListClickInteractionListener mOnListClickInteractionListener;

    //private int mCountOnCreator = 0;
    //private int mCountOnBind = 0;

    public CarListAdapter(List<Car> cars, OnListClickInteractionListener listener){
        this.mListCars = cars;
        this.mOnListClickInteractionListener = listener;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //this.mCountOnCreator++;
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View carView = inflater.inflate(R.layout.row_car_list, parent,false);

        return new CarViewHolder(carView);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
       // this.mCountOnBind++;
        Car car = this.mListCars.get(position);
        holder.bindData(car, this.mOnListClickInteractionListener);
    }

    @Override
    public int getItemCount() {
        return this.mListCars.size();
    }
}
