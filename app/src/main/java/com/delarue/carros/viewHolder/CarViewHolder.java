package com.delarue.carros.viewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.delarue.carros.R;
import com.delarue.carros.entities.Car;
import com.delarue.carros.listener.OnListClickInteractionListener;

public class CarViewHolder extends RecyclerView.ViewHolder {

    private TextView mTextModel;

    public CarViewHolder(@NonNull View itemView) {

        super(itemView);
        this.mTextModel = itemView.findViewById(R.id.text_model);

    }

    public void bindData(final Car car, final OnListClickInteractionListener listener){
        this.mTextModel.setText(car.model);
        this.mTextModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClic(car.id);
            }
        });
    }

}
