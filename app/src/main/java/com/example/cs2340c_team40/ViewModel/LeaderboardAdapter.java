package com.example.cs2340c_team40.ViewModels;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.cs2340c_team40.Model.Leaderboard;
import com.example.cs2340c_team40.R;

public class LeaderboardAdapter extends RecyclerView.Adapter<Score_card_viewHolder> {
    Leaderboard leaderboard;

    Context context;

    public LeaderboardAdapter(Context context) {
        this.leaderboard = Leaderboard.getInstance();
        this.context = context;
    }

    @Override
    public Score_card_viewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the layout

        View photoView = inflater.inflate(R.layout.score_card, parent, false);

        Score_card_viewHolder viewHolder = new Score_card_viewHolder(photoView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final Score_card_viewHolder viewHolder, final int position) {
        final int index = viewHolder.getAdapterPosition();
        viewHolder.scoreName.setText(leaderboard.getScore(position).getName());
        viewHolder.scoreDate.setText(leaderboard.getScore(position).getTime());
        viewHolder.scoreScore.setText(leaderboard.getScore(position).getScore());
    }

    @Override
    public int getItemCount() {
        return leaderboard.getSize();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}

