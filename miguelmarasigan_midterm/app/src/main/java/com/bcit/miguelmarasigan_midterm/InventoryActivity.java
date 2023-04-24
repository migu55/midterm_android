package com.bcit.miguelmarasigan_midterm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class InventoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        Intent intent = getIntent();
        Hippo h1 = (Hippo) intent.getSerializableExtra(MainActivity.key1);
        Hippo h2 = (Hippo) intent.getSerializableExtra(MainActivity.key2);
        Hippo h3 = (Hippo) intent.getSerializableExtra(MainActivity.key3);
        Hippo h4 = (Hippo) intent.getSerializableExtra(MainActivity.key4);
        Hippo[] hippos = {h1, h2, h3, h4};

        RecyclerView recyc = findViewById(R.id.recyclerView_inventory);

        InventoryAdapter inventoryAdapter = new InventoryAdapter(hippos);
        recyc.setAdapter(inventoryAdapter);
        recyc.setLayoutManager(new LinearLayoutManager(this));

    }
}