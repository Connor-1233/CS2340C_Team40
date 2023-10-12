package com.example.cs2340c_team40.ViewModel;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.cs2340c_team40.Model.Score;
import androidx.annotation.NonNull;
import com.example.cs2340c_team40.R;

public class Score_card_viewHolder extends RecyclerView.ViewHolder {
    TextView scoreName;
    TextView scoreScore;
    TextView scoreDate;

    public Score_card_viewHolder(@NonNull View itemView) {
        super(itemView);
        scoreName = itemView.findViewById(R.id.scoreName);
        scoreDate = itemView.findViewById(R.id.scoreDate);
        scoreScore = itemView.findViewById(R.id.scoreScore);
    }
}
