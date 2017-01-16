package com.example.android.layoutexperiment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hernandez on 1/15/2017.
 */
public class LandscapeAdapter extends RecyclerView.Adapter<LandscapeAdapter.LandscapeViewHolder> {

    private List<Landscape> landscapes;

    public LandscapeAdapter(List<Landscape> landscapes) {
        this.landscapes = landscapes;
    }

    @Override
    public LandscapeViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.landscape_card_view, viewGroup, false);

        return new LandscapeViewHolder(v);

    }

    @Override
    public void onBindViewHolder(LandscapeViewHolder landscapeViewHolder, int i) {

        Landscape landscape = landscapes.get(i);
        landscapeViewHolder.imgPicture.setImageResource(landscape.getPicture());
        landscapeViewHolder.tvName.setText(landscape.getName());

    }

    @Override
    public int getItemCount() {
        return landscapes.size();
    }

    public static class LandscapeViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgPicture;
        private TextView tvName;

        public LandscapeViewHolder(View itemView) {
            super(itemView);

            imgPicture = (ImageView) itemView.findViewById(R.id.imgPicture);
            tvName = (TextView) itemView.findViewById(R.id.tvLandscapeName);

        }
    }



}
