package com.delarue.carros.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.delarue.carros.R;
import com.delarue.carros.constants.CarrosConstants;
import com.delarue.carros.data.CarMock;
import com.delarue.carros.entities.Car;

public class DetailsActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();
    private CarMock mCarMock;
    private Car mCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.mCarMock = new CarMock();

        this.mViewHolder.textModel = this.findViewById(R.id.text_model);
        this.mViewHolder.textHorsePower = this.findViewById(R.id.text_horse_power);
        this.mViewHolder.textPrice = this.findViewById(R.id.text_price);

        this.getDataFromActivity();

        this.setData();
    }

    private void setData() {

        this.mViewHolder.textModel.setText(this.mCar.model);
        this.mViewHolder.textHorsePower.setText(String.valueOf(this.mCar.horsePower));
        this.mViewHolder.textPrice.setText(String.valueOf(this.mCar.price));

    }

    private void getDataFromActivity() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.mCar = this.mCarMock.get(extras.getInt(CarrosConstants.CARRO_ID));
        }
    }
    private static class ViewHolder {
        TextView textModel;
        TextView textHorsePower;
        TextView textPrice;
    }
}
