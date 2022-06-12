package com.example.carapp_diploma;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.carapp_diploma.Models.Car;
import com.example.carapp_diploma.Models.Events;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class EventsFragment extends Fragment {

    ArrayList<String> list_car = new ArrayList<>();
    ArrayList<String> list_to = new ArrayList<>();
    DatabaseReference events;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser mUser = mAuth.getCurrentUser();
        String onlineUserID = mUser.getUid();
        events = FirebaseDatabase.getInstance().getReference("Users").child("Cars").child("Events").child(onlineUserID);

        View view = inflater.inflate(R.layout.fragment_events, container, false);


        //Создание раскрывающегося меню для автомобиля
        AutoCompleteTextView listCar = (AutoCompleteTextView) view.findViewById(R.id.list_car);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, list_car);
        listCar.setAdapter(adapter);

        //Создание раскрывающегося меню для типа события
        AutoCompleteTextView listTo = (AutoCompleteTextView) view.findViewById(R.id.list_TO);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, list_to);
        listTo.setAdapter(adapter1);
        list_to.add("Сервис");
        list_to.add("Обслуживание");
        list_to.add("Регистрация");
        list_to.add("Парковка");
        list_to.add("Мойка");
        list_to.add("Платный проезд");
        list_to.add("Штрафы");
        list_to.add("Тюнинг");
        list_to.add("Страховка");
        list_to.add("Заправка");

        list_car.add("Приора");

        /*events.child("Cars").child(onlineUserID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String cars = snapshot.getValue(Car.class).getName();

                list_car.add(cars);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/

        Button add_events = (Button) view.findViewById(R.id.addEvents);

        final TextInputEditText NameEvents = (TextInputEditText) view.findViewById(R.id.InputEditNameEvents);
        final TextInputEditText ManyPrice = (TextInputEditText) view.findViewById(R.id.InputEditManyPrice);
        final TextInputEditText Date = (TextInputEditText) view.findViewById(R.id.InputEditDate);
        final TextInputEditText CurrentMileage = (TextInputEditText) view.findViewById(R.id.InputEditCurrentMileage);
        final TextInputEditText Comment = (TextInputEditText) view.findViewById(R.id.InputEditComment);




        add_events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Добавление события
                String name = NameEvents.getText().toString();
                String manyPrice = ManyPrice.getText().toString();
                String date = Date.getText().toString();
                String currentMileage = CurrentMileage.getText().toString();
                String comment = Comment.getText().toString();
                String Car_user = adapter.getItem(0);
                String type_events = adapter1.getItem(4);

                String id = events.push().getKey();

                Events event = new Events(name, manyPrice, date, currentMileage, comment, Car_user, type_events);

                events.child(id).setValue(event).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(getActivity(), "Событие добавлено", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                NameEvents.getText().clear();
                ManyPrice.getText().clear();
                Date.getText().clear();
                CurrentMileage.getText().clear();
                Comment.getText().clear();

            }
        });




        return view;
    }
}