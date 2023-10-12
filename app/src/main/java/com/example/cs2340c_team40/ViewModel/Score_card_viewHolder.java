package com.example.cs2340c_team40.ViewModel;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.cs2340c_team40.Model.Score;
import com.example.cs2340c_team40.R;

public class Score_card_viewHolder extends RecyclerView.ViewHolder {
    TextView scoreName;
    TextView scoreScore;
    TextView scoreDate;
    View view;

    public Score_card_viewHolder(View itemView) {
        super(itemView);
        scoreName = (TextView) itemView.findViewById(R.id.scoreName);
        scoreDate = (TextView) itemView.findViewById(R.id.scoreDate);
        scoreScore = (TextView) itemView.findViewById(R.id.scoreScore);
        view = itemView;

    }
}
