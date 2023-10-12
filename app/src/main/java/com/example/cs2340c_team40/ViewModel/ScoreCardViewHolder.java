package com.example.cs2340c_team40.ViewModel;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

//import com.example.cs2340c_team40.Model.Score;
import androidx.annotation.NonNull;
import com.example.cs2340c_team40.R;

public class ScoreCardViewHolder extends RecyclerView.ViewHolder {
    private TextView scoreName;
    private TextView scoreScore;
    private TextView scoreDate;

    public ScoreCardViewHolder(@NonNull View itemView) {
        super(itemView);
        scoreName = itemView.findViewById(R.id.scoreName);
        scoreDate = itemView.findViewById(R.id.scoreDate);
        scoreScore = itemView.findViewById(R.id.scoreScore);
    }

    public TextView getScoreName() {
        return scoreName;
    }
    public TextView getScoreScore() {
        return  scoreScore;
    }
    public TextView getScoreDate() {
        return  scoreDate;
    }
}
