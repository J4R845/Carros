package com.delarue.carros.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.delarue.carros.R;
import com.delarue.carros.adapter.CarListAdapter;
import com.delarue.carros.constants.CarrosConstants;
import com.delarue.carros.data.CarMock;
import com.delarue.carros.entities.Car;
import com.delarue.carros.listener.OnListClickInteractionListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewHolder mViewHolder = new ViewHolder();
    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mContext = this;

        CarMock carMock = new CarMock();
        List<Car> carList = new ArrayList<>();
        carList.addAll(carMock.getList());

        // Obter a recyclerView
        this.mViewHolder.recyclerCars = this.findViewById(R.id.recycler_cars);

        OnListClickInteractionListener listener = new OnListClickInteractionListener() {
            @Override
            public void onClic(int id) {

                Bundle bundle = new Bundle();
                bundle.putInt(CarrosConstants.CARRO_ID, id);
                Intent intent = new Intent(mContext, DetailsActivity.class);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        };

        // Definir o Adapter
        CarListAdapter carListAdapter = new CarListAdapter(carList, listener);
        this.mViewHolder.recyclerCars.setAdapter(carListAdapter);

        // Definir o Layout
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.mViewHolder.recyclerCars.setLayoutManager(linearLayoutManager);

    }

    private static class ViewHolder {
        RecyclerView recyclerCars;
    }
}
