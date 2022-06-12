package com.example.carapp_diploma;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.carapp_diploma.databinding.InfoCoefficientBinding;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class ChooseCalculatorFragmentThree extends Fragment {

    private TextInputEditText textInputEditFuelThreeFragment;
    private TextInputEditText textInputEditCoefficient;
    private TextInputEditText textInputEditDistanceThreeFragment;

    private TextView readyThree;

    private ImageButton imageButton;

    Button buttonThree;


    public void getConsumption(){
        String Distance = Objects.requireNonNull(textInputEditDistanceThreeFragment.getText()).toString();
        String Coefficient = Objects.requireNonNull(textInputEditCoefficient.getText()).toString();
        String Fuel = Objects.requireNonNull(textInputEditFuelThreeFragment.getText()).toString();

        String message = "";

        try {
            float DistanceFloat = Float.parseFloat(Distance);
            float CoefficientFloat = Float.parseFloat(Coefficient);
            float FuelFloat = Float.parseFloat(Fuel);

            float i = (float) (0.01 * FuelFloat * DistanceFloat * (1 + 0.01 * (CoefficientFloat/100)));

            message = i + " л/100км";
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            readyThree.setText(message);
            textInputEditFuelThreeFragment.requestFocus();
            textInputEditDistanceThreeFragment.requestFocus();
            textInputEditCoefficient.requestFocus();
            textInputEditFuelThreeFragment.selectAll();
            textInputEditDistanceThreeFragment.selectAll();
            textInputEditCoefficient.selectAll();
        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_choose_calculator_three, container, false);

        textInputEditFuelThreeFragment = (TextInputEditText) view.findViewById(R.id.textInputEditFuelThreeFragment);
        textInputEditCoefficient = (TextInputEditText) view.findViewById(R.id.textInputEditCoefficient);
        textInputEditDistanceThreeFragment = (TextInputEditText) view.findViewById(R.id.textInputEditDistanceThreeFragment);

        buttonThree = (Button) view.findViewById(R.id.buttonThree);
        readyThree = (TextView) view.findViewById(R.id.readyThree);

        imageButton = (ImageButton) view.findViewById(R.id.imageButton);



        buttonThree.setOnClickListener(v -> getConsumption());
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInfoCoefficient();
            }
        });




        return view;
    }

    private void getInfoCoefficient() {
        AlertDialog.Builder myDialog = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View Info = inflater.inflate(R.layout.info_coefficient, null);
        myDialog.setView(Info);

        Button coefficient_button = (Button) Info.findViewById(R.id.coefficient_button);

        AlertDialog dialog = myDialog.create();
        dialog.setCancelable(false);
        dialog.show();

        coefficient_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.hide();
            }
        });

    }
}