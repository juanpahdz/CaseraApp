package com.example.caseraapp.adapters;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.caseraapp.R;
import com.example.caseraapp.model.animal;

import org.w3c.dom.Text;

import java.util.List;

public class animalAdapter extends ArrayAdapter<animal>{

    private List<animal> mList;
    private Context mContext;
    private int resourceLayout;

    public animalAdapter(@NonNull Context context, int resource, List<animal> objects) {
        super(context, resource, objects);
        this.mList = objects;
        this.mContext = context;
        this.resourceLayout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(mContext).inflate(resourceLayout, null);
        }

        animal animalModel = mList.get(position);
        ImageView imagen = view.findViewById(R.id.imageViewIcon);

        TextView animalName = view.findViewById(R.id.textViewNombre);
        animalName.setText(animalModel.getNombre());

        TextView animalEdad = view.findViewById(R.id.textViewEdad);
        animalEdad.setText("Tiene "+ animalModel.getEdad() + " Años");

        return view;
    }
}
