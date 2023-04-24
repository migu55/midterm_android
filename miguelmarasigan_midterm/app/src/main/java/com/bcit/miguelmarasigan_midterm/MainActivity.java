package com.bcit.miguelmarasigan_midterm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    public static String key1 = "key1";
    public static String key2 = "key2";
    public static String key3 = "key3";
    public static String key4 = "key4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Hippo h1 = new Hippo("Jerry", 7, "Peanuts", R.drawable.hippo1);
        Hippo h2 = new Hippo("Matilda", 1, "Bananas", R.drawable.hippo2);
        Hippo h3 = new Hippo("Alison", 12, "Coconuts", R.drawable.hippo3);
        Hippo h4 = new Hippo("Craig", 2, "Potatoes", R.drawable.hippo4);

        Spinner spinner = findViewById(R.id.spinner_main);

        String[] hippoNames = {h1.getName(), h2.getName(), h3.getName(), h4.getName()};

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, hippoNames);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                if (i == 0) {
                    ft.replace(R.id.fragmentContainerView_main, PreviewFragment.newInstance(h1));
                } else if (i == 1) {
                    ft.replace(R.id.fragmentContainerView_main, PreviewFragment.newInstance(h2));
                } else if (i == 2) {
                    ft.replace(R.id.fragmentContainerView_main, PreviewFragment.newInstance(h3));
                } else if (i == 3) {
                    ft.replace(R.id.fragmentContainerView_main, PreviewFragment.newInstance(h4));

                }
                ft.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner.setAdapter(arrayAdapter);



        Button button1 = findViewById(R.id.button_main_inventory);

        button1.setBackgroundColor(getResources().getColor(R.color.button_front));
        button1.setTextColor(getResources().getColor(R.color.button_text));

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable(key1, h1);
                bundle.putSerializable(key2, h2);
                bundle.putSerializable(key3, h3);
                bundle.putSerializable(key4, h4);
                Intent intent = new Intent(view.getContext(), InventoryActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        Button button2 = findViewById(R.id.button_main_contact);

        button2.setBackgroundColor(getResources().getColor(R.color.button_front));
        button2.setTextColor(getResources().getColor(R.color.button_text));

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragmentContainerView_main, new ContactFragment());
                ft.commit();
            }
        });

    }

}