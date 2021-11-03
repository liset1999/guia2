package personal.app.guia2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import static personal.app.guia2.AgregarNombreActivity.persona;

public class MainActivity extends AppCompatActivity {

    Button AgregarNombre;
    Button VerLista;
    Button MisDatos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AgregarNombre = (Button) findViewById(R.id.btnAgregarNombre);
        MisDatos = (Button) findViewById(R.id.btnMisDatos);
        VerLista = (Button) findViewById(R.id.btnVLista);

        AgregarNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AgregarNombreActivity.class));
            }
        });

        MisDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MisDatosActivity.class));
            }
        });

        VerLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (persona.isEmpty() ){
                    Toast.makeText(MainActivity.this, "Lista vacia", Toast.LENGTH_SHORT).show();
                }else {
                    startActivity(new Intent(MainActivity.this, VerListaActivity.class));
                }
            }

        });
    }
}