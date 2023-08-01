package com.example.almacenamiento;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    Button btnMostrarVuelos = findViewById(R.id.btnMostrarVuelos);
    Button btnRegistrarVuelo = findViewById(R.id.btnRegistrarVuelo);
    Button btnRegistrarAerolinea = findViewById(R.id.btnRegistrarAerolinea);

    // Configurar los listeners para los botones
        btnMostrarVuelos.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, MostrarVuelosActivity.class);
            startActivity(intent);

        }
        });

        btnRegistrarVuelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistrarVueloActivity.class);
                startActivity(intent);
            }
        });
        btnRegistrarAerolinea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDialogoRegistrarAerolinea();
            }
        });
    }

    private void mostrarDialogoRegistrarAerolinea() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Registrar Aerolinea");
        final EditText etNombreAerolinea = new EditText(this);
        builder.setView(etNombreAerolinea);

        builder.setPositiveButton("Registrar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String nombreAerolinea = etNombreAerolinea.getText().toString().trim();
                if (!nombreAerolinea.isEmpty()) {
                    // Aquí puedes guardar el nombre de la aerolínea en el archivo de la memoria.
                    // Puedes usar SharedPreferences o almacenamiento en archivos, por ejemplo.
                }
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}






