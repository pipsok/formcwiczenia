package com.example.kartkowkapowtora;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText nazwa;
    //RadioGroup grupa;
    SeekBar sekbar;
    //CheckBox checkBox;
    Switch checkBox;
    Spinner spinner;
    EditText waga;
    Button button;
    ArrayList<String> ryba;
    ArrayAdapter<String> arrayAdapter;
    ListView lista;
    //RadioButton roslinozerne;
    //RadioButton wszystkozerne;
    //RadioButton drapiezne;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        nazwa = findViewById(R.id.editTextText);
        spinner = findViewById(R.id.spinner);
        //grupa = findViewById(R.id.grupa);
        //roslinozerne = findViewById(R.id.roslinozerne);
        //wszystkozerne = findViewById(R.id.wszystkozerne);
        //drapiezne = findViewById(R.id.drapiezne);
        sekbar = findViewById(R.id.sekbar);
        checkBox = findViewById(R.id.checkBox);

        waga = findViewById(R.id.editTextNumber);
        button = findViewById(R.id.button);
        lista = findViewById(R.id.lista);
        ryba = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ryba);
        lista.setAdapter(arrayAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*String radiowynik = "";
                if (roslinozerne.isChecked()){
                    radiowynik = "roslinozerne";
                }
                else if(wszystkozerne.isChecked()){
                    radiowynik = "wszystkozerne";
                }
                else if(drapiezne.isChecked()){
                    radiowynik = "drapiezne";
                }*/
                String Okres = "";
                if (checkBox.isChecked()){
                    Okres = "Tak";
                }
                else{
                    Okres = "Nie";
                }
                String wynik = "Nazwa: "+nazwa.getText().toString()+" ,Sposob: "+spinner.getSelectedItem()+" ,Dlugosc: "+sekbar.getProgress()+" ,Czy okres ochronny: "+Okres+" ,Waga: "+waga.getText().toString();
                ryba.add(wynik);
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }
}