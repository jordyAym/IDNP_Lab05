package com.example.listadelugares;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DescriptionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DescriptionFragment extends Fragment {

    private static final String ARG_PLACE_NAME = "place_name";
    private static final String ARG_PLACE_DESCRIPTION = "place_description";
    private static final String ARG_PLACE_IMAGE = "place_image";

    private String placeName;
    private String placeDescription;
    private int placeImageResId;

    public static DescriptionFragment newInstance(Place place) {
        DescriptionFragment fragment = new DescriptionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PLACE_NAME, place.getName());
        args.putString(ARG_PLACE_DESCRIPTION, place.getDescription());
        args.putInt(ARG_PLACE_IMAGE, place.getImageResId());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            placeName = getArguments().getString(ARG_PLACE_NAME);
            placeDescription = getArguments().getString(ARG_PLACE_DESCRIPTION);
            placeImageResId = getArguments().getInt(ARG_PLACE_IMAGE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_description, container, false);

        // Asignar los datos a las vistas del fragmento
        TextView nameTextView = view.findViewById(R.id.place_name);
        TextView descriptionTextView = view.findViewById(R.id.place_description);
        ImageView imageView = view.findViewById(R.id.place_image);

        nameTextView.setText(placeName);
        descriptionTextView.setText(placeDescription);
        imageView.setImageResource(placeImageResId);

        return view;
    }
}
