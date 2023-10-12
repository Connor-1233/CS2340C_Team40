package com.example.cs2340c_team40.ViewModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;

import com.example.cs2340c_team40.Model.Leaderboard;
import com.example.cs2340c_team40.R;

public class LeaderboardAdapter extends RecyclerView.Adapter<ScoreCardViewHolder> {
    private Leaderboard leaderboard;


    public LeaderboardAdapter() {
        this.leaderboard = Leaderboard.getInstance();
    }

    @Override
    public ScoreCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the layout

        View photoView = inflater.inflate(R.layout.score_card, parent, false);

        ScoreCardViewHolder viewHolder = new ScoreCardViewHolder(photoView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ScoreCardViewHolder viewHolder, int position) {
        if (position < leaderboard.getSize()) {
            viewHolder.getScoreName().setText(leaderboard.getScore(position).getName());
            viewHolder.getScoreDate().setText(leaderboard.getScore(position).getTime());
            viewHolder.getScoreScore().setText(leaderboard.getScore(position).getScore());
        }
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

