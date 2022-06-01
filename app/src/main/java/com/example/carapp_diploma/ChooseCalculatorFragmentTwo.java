package com.example.carapp_diploma;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class ChooseCalculatorFragmentTwo extends Fragment {

    private TextInputEditText textInputEditFuel;
    private TextInputEditText textInputEditPrice;
    private TextInputEditText textInputEditConsumption;

    private Button button;

    private TextView ready;

    public void priceDistance(){
        String Fuel = textInputEditFuel.getText().toString();
        String Price = textInputEditPrice.getText().toString();
        String Consumption = textInputEditConsumption.getText().toString();

        String message = "";

        try {
            float FuelInt = Float.parseFloat(Fuel);
            float PriceInt = Float.parseFloat(Price);
            float ConsumptionInt = Float.parseFloat(Consumption);

            double i = Math.ceil(FuelInt * ConsumptionInt);

            message = Double.toString(i) + " км";

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            ready.setText(message);
            textInputEditFuel.requestFocus();
            textInputEditPrice.requestFocus();
            textInputEditConsumption.requestFocus();
            textInputEditFuel.selectAll();
            textInputEditPrice.selectAll();
            textInputEditConsumption.selectAll();
        }
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_choose_calculator_two, container, false);

        textInputEditFuel = (TextInputEditText) view.findViewById(R.id.textInputEditFuel);
        textInputEditPrice = (TextInputEditText) view.findViewById(R.id.textInputEditPrice);
        textInputEditConsumption = (TextInputEditText) view.findViewById(R.id.textInputEditConsumption);

        button = (Button) view.findViewById(R.id.button2);
        ready = (TextView) view.findViewById(R.id.ready);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                priceDistance();
            }
        });




        return view;
    }

}