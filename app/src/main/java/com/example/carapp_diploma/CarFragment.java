package com.example.carapp_diploma;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.carapp_diploma.Models.Car;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CarFragment extends Fragment {

    DatabaseReference cars;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        cars = FirebaseDatabase.getInstance().getReference("Cars");

        View view = inflater.inflate(R.layout.fragment_car, container, false);

        Button add_car = (Button) view.findViewById(R.id.buttonAdd);

        final TextInputEditText NameCar = (TextInputEditText) view.findViewById(R.id.InputEditNameCar);
        final TextInputEditText Brand = (TextInputEditText) view.findViewById(R.id.InputEditBrand);
        final TextInputEditText TypeFuel = (TextInputEditText) view.findViewById(R.id.InputEditTypeFuel);
        final TextInputEditText Year = (TextInputEditText) view.findViewById(R.id.InputEditYear);
        final TextInputEditText Mileage = (TextInputEditText) view.findViewById(R.id.InputEditMileage);
        final TextInputEditText Consumption = (TextInputEditText) view.findViewById(R.id.InputEditConsumption);

        add_car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Добавление автомобиля
                String name = NameCar.getText().toString();
                String brand = Brand.getText().toString();
                String fuel = TypeFuel.getText().toString();
                String year = Year.getText().toString();
                String mileage = Mileage.getText().toString();
                String consumption = Consumption.getText().toString();

                String id = cars.push().getKey();

                Car car = new Car(name, brand, fuel, year, mileage, consumption);

                cars.child(id).setValue(car);

                Toast.makeText(getActivity(), "Автомобиль добавлен", Toast.LENGTH_LONG).show();

                NameCar.getText().clear();
                Brand.getText().clear();
                TypeFuel.getText().clear();
                Year.getText().clear();
                Mileage.getText().clear();
                Consumption.getText().clear();
            }
        });

        return view;
    }
}