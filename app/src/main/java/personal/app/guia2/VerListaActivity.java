package personal.app.guia2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import personal.app.guia2.model.Persona;

import static personal.app.guia2.AgregarNombreActivity.persona;

public class VerListaActivity extends AppCompatActivity {

    private ListView lstverLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_lista);

        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        lstverLista = (ListView) findViewById(R.id.lstverLista);

        ArrayAdapter<Persona> adapterPersona = new ArrayAdapter(this, android.R.layout.simple_list_item_1, persona);
        lstverLista.setAdapter(adapterPersona);

        adapterPersona.notifyDataSetChanged();
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
}