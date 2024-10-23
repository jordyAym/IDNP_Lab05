package com.example.listadelugares;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder> {

    private List<Place> places;
    private OnPlaceClickListener onPlaceClickListener;

    // Interfaz para manejar el clic en los elementos de la lista
    public interface OnPlaceClickListener {
        void onPlaceClick(Place place);
    }

    // Constructor
    public PlaceAdapter(List<Place> places, OnPlaceClickListener onPlaceClickListener) {
        this.places = places;
        this.onPlaceClickListener = onPlaceClickListener;
    }

    // Clase interna ViewHolder que contiene las vistas del item
    public static class PlaceViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView image;

        public PlaceViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.place_name);
            image = view.findViewById(R.id.place_image);
        }
    }

    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflar el layout de cada item (list_item.xml)
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new PlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewHolder holder, int position) {
        // Obtener el lugar actual
        Place place = places.get(position);
        // Asignar el nombre y la imagen del lugar
        holder.name.setText(place.getName());
        holder.image.setImageResource(place.getImageResId());
        // Manejar el clic en el elemento
        holder.itemView.setOnClickListener(v -> onPlaceClickListener.onPlaceClick(place));
    }

    @Override
    public int getItemCount() {
        return places.size();
    }
}
