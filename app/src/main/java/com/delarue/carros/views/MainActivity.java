package com.delarue.carros.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.delarue.carros.R;
import com.delarue.carros.adapter.CarListAdapter;
import com.delarue.carros.data.CarMock;
import com.delarue.carros.entities.Car;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewHolder mViewHolder = new ViewHolder();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CarMock carMock = new CarMock();
        List<Car> carList = new ArrayList<>();
        carList.addAll(carMock.getList());

        // Obter a recyclerView
        this.mViewHolder.recyclerCars = this.findViewById(R.id.recycler_cars);

        // Definir o Adapter
        CarListAdapter carListAdapter = new CarListAdapter(carList);
        this.mViewHolder.recyclerCars.setAdapter(carListAdapter);

        // Definir o Layout
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.mViewHolder.recyclerCars.setLayoutManager(linearLayoutManager);


    }


    private static class ViewHolder {
        RecyclerView recyclerCars;

    }
}
