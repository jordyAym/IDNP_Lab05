package com.example.listadelugares;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaFragment extends Fragment {

    private OnLugarClickListener onLugarClickListener;

    // Interfaz para manejar el clic en los lugares turísticos
    public interface OnLugarClickListener {
        void onLugarClick(Place place);
    }

    public ListaFragment(OnLugarClickListener listener) {
        this.onLugarClickListener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista, container, false);

        // Configurar el RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.places_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Crear la lista de lugares turísticos
        List<Place> places = new ArrayList<>();
        places.add(new Place("Catedral de Arequipa", R.drawable.catedral_de_arequipa, "Fue construida con ignimbrita (piedra de origen volcánico), y bóvedas de ladrillo; es el santuario principal de la ciudad ocupando todo el lado norte de la Plaza de Armas."));
        places.add(new Place("Claustro de la Compañía", R.drawable.claustro_de_la_compania, "El uso del sillar en la construcción de la Iglesia de la Compañía de Jesús es particular en Arequipa. Esta obra comenzó a ejecutarse en 1578 con la guía de los planos de Gaspar Báez. Pero con el terremoto del 13 de noviembre de 1582 destruyó gran parte de la iglesia y por eso en 1590 se inició con el proyecto de reconstrucción al mando del padre Diego Felipe."));

        // Configurar el adaptador y el evento de clic
        PlaceAdapter adapter = new PlaceAdapter(places, place -> {
            // Llamar al listener cuando se haga clic en un lugar
            onLugarClickListener.onLugarClick(place);
        });
        recyclerView.setAdapter(adapter);

        return view;
    }
}
