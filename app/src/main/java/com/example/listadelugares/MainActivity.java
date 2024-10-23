package com.example.listadelugares;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ListaFragment.OnLugarClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Verifica si hay un estado guardado para evitar crear fragmentos duplicados
        if (savedInstanceState == null) {
            // Cargar el fragmento de lista al iniciar la aplicación
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new ListaFragment(this))  // ListaFragment gestiona la lista de lugares
                    .commit();
        }
    }

    @Override
    public void onLugarClick(Place place) {
        // Cuando el usuario hace clic en un lugar, reemplaza el fragmento con el fragmento de descripción
        DescriptionFragment descripcionFragment = DescriptionFragment.newInstance(place);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, descripcionFragment)
                .addToBackStack(null)  // Permitir al usuario volver a la lista
                .commit();
    }
}