package com.jpapps.linkdirectory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class Enlaces extends AppCompatActivity {

    private static final ArrayList<String> arrayEnlaces = new ArrayList(Arrays.asList("http://www.google.es"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enlaces);

        ListView listaEnlaces = findViewById(R.id.listaEnlaces);

        listaEnlaces.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayEnlaces));
        listaEnlaces.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent enlace = new Intent();

                enlace.putExtra("enlace", parent.getItemAtPosition(position).toString());
                setResult(RESULT_OK, enlace);
                finish();
            }
        });
    }
}
