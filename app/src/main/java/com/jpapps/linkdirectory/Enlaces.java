package com.jpapps.linkdirectory;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Enlaces extends AppCompatActivity {

    private static final ArrayList<String> arrayEnlaces = new ArrayList();

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

    public void añadirEnlace_Click(View view)
    {
        final EditText editText = new EditText(this);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("Añadir enlace");
        alert.setMessage("Escribe el enlace:");
        alert.setView(editText);
        alert.setPositiveButton("Añadir", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int whichButton) {

                String nuevoEnlace = editText.getText().toString();

                if(!nuevoEnlace.startsWith("http://"))
                    nuevoEnlace = "http://" + nuevoEnlace;

                arrayEnlaces.add(nuevoEnlace);

                ListView listaEnlaces = findViewById(R.id.listaEnlaces);

                listaEnlaces.setAdapter(new ArrayAdapter<String>(Enlaces.this, android.R.layout.simple_list_item_1, arrayEnlaces));
                Toast.makeText(Enlaces.this, "Enlace añadido correctamente.", Toast.LENGTH_LONG).show();
            }
        });

        alert.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int whichButton) {

                Toast.makeText(Enlaces.this, "No se ha añadido el enlace.", Toast.LENGTH_LONG).show();
            }
        });

        alert.show();
    }
}
