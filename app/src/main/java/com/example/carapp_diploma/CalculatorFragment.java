package com.example.carapp_diploma;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class CalculatorFragment extends Fragment {

    Spinner spinner;

    ChoiceCalculatorFragment choiceCalculatorFragment;
    ChooseCalculatorFragmentTwo chooseCalculatorFragmentTwo;
    ChooseCalculatorFragmentThree chooseCalculatorFragmentThree;

    ArrayList<String> spinner_list = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFragment(new ChoiceCalculatorFragment());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_calculator, container, false);
        spinner = view.findViewById(R.id.spinner);

        choiceCalculatorFragment = new ChoiceCalculatorFragment();
        chooseCalculatorFragmentTwo = new ChooseCalculatorFragmentTwo();
        chooseCalculatorFragmentThree = new ChooseCalculatorFragmentThree();

        spinner_list.add("Стоимость поездки");
        spinner_list.add("Расстояние");
        spinner_list.add("Расход топлива");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, spinner_list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        setFragment(new ChoiceCalculatorFragment());
                        break;
                    case 1:
                        setFragment(new ChooseCalculatorFragmentTwo());
                        break;
                    case 2:
                        setFragment(new ChooseCalculatorFragmentThree());
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }
    private void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment);
        fragmentTransaction.commit();
    }
}