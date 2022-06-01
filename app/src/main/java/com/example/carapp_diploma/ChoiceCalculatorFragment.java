package com.example.carapp_diploma;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class ChoiceCalculatorFragment extends Fragment {

    private TextInputEditText textInputEditConsumptionOneFragment;
    private TextInputEditText textInputEditPriceOneFragment;
    private TextInputEditText textInputEditDistanceOneFragment;

    private Button buttonRub;

    private TextView readyRub;

    public void priceTrip(){
        String Distance = textInputEditDistanceOneFragment.getText().toString();
        String Price = textInputEditPriceOneFragment.getText().toString();
        String Consumption = textInputEditConsumptionOneFragment.getText().toString();

        String message = "";
        try {
            float DistanceFloat = Float.parseFloat(Distance);
            float PriceFloat = Float.parseFloat(Price);
            float ConsumptionFloat = Float.parseFloat(Consumption);

            float i = (DistanceFloat/100) * ConsumptionFloat * PriceFloat;

            message = Float.toString(i) + " рублей";


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readyRub.setText(message);
            textInputEditDistanceOneFragment.requestFocus();
            textInputEditPriceOneFragment.requestFocus();
            textInputEditConsumptionOneFragment.requestFocus();
            textInputEditDistanceOneFragment.selectAll();
            textInputEditPriceOneFragment.selectAll();
            textInputEditConsumptionOneFragment.selectAll();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_choice_calculator, container, false);

        textInputEditConsumptionOneFragment = (TextInputEditText) view.findViewById(R.id.textInputEditConsumptionOneFragment);
        textInputEditPriceOneFragment = (TextInputEditText) view.findViewById(R.id.textInputEditPriceOneFragment);
        textInputEditDistanceOneFragment = (TextInputEditText) view.findViewById(R.id.textInputEditDistanceOneFragment);

        buttonRub = (Button) view.findViewById(R.id.buttonRub);
        readyRub = (TextView) view.findViewById(R.id.readyRub);

        buttonRub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                priceTrip();
            }
        });

        return view;
    }
}