package personal.app.guia2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import personal.app.guia2.model.Persona;

public class AgregarNombreActivity extends AppCompatActivity {

    private static String TAG ="AgregarNombreActivity";
     Button guardar;
     EditText nombre;
     public static ArrayList<Persona> persona;
     ProgressBar pbCargar;
     Button btnLimpiar;
     private ProgressDialog progress;
     Integer counter =1;
     Boolean inicio = false;
     Handler h = new Handler();
     TextView txtProgreso;
     int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_nombre);

        if (getSupportActionBar()!= null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        guardar =(Button) findViewById(R.id.btnGuardar);
        txtProgreso = (TextView) findViewById(R.id.txtProgreso);
        nombre =(EditText) findViewById(R.id.txtNombre);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        pbCargar = (ProgressBar) findViewById(R.id.pbProgress);
        pbCargar.setMax(100);

        persona = new ArrayList<>();

    }

    public void GuardarRegistro(View view)
    {
        if (nombre.getText().toString().isEmpty()) {

            Toast.makeText(AgregarNombreActivity.this, "Escriba un nombre", Toast.LENGTH_SHORT).show();

        }
        else
        {
            persona.add(new Persona(nombre.getText().toString()));
            if(view.getId()==R.id.btnGuardar){
                if(!inicio){
                    Thread hilo = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            while (i<=100){
                                h.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        txtProgreso.setText(i + " %");
                                        pbCargar.setProgress(i);
                                    }
                                });
                                try {
                                    Thread.sleep(10);
                                }catch (InterruptedException e){
                                   e.printStackTrace();
                                }
                                if(i==100){
                                    Intent intent = new Intent(AgregarNombreActivity.this, VerListaActivity.class);
                                    startActivity(intent);
                                }
                                i++;
                                inicio=true;
                            }

                        }
                    });
                    Toast.makeText(AgregarNombreActivity.this,"Guardado con éxito",Toast.LENGTH_SHORT).show();
                    hilo.start();
                }

            }
        }
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    public void Reset(View view) {
        nombre.setText("");
        pbCargar.setProgress(0);
        i=0;
        inicio=false;
        txtProgreso.setText("0 %");
    }
}