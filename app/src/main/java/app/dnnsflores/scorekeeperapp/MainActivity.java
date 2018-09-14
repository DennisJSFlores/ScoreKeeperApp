package app.dnnsflores.scorekeeperapp;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tv_Score_A, tv_Score_B, tv_Team_A, tv_Team_B;

    Dialog d_Goal;
    private int  scoreTeamA, scoreTeamB;
    private static final String TEAM_A_SCORE = "A";
    private static final String TEAM_B_SCORE = "B";
    private Button btn_Goal, btn_Foul, btn_Penal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null){
            scoreTeamA = savedInstanceState.getInt(TEAM_A_SCORE);
            scoreTeamB = savedInstanceState.getInt(TEAM_B_SCORE);
        }else{
            scoreTeamA = 0;
            scoreTeamB = 0;
        }

        tv_Score_A = findViewById(R.id.tv_score_a);
        tv_Score_B = findViewById(R.id.tv_score_b);
        tv_Team_A = findViewById(R.id.tv_team_a);
        tv_Team_B = findViewById(R.id.tv_team_b);

        tv_Score_A.setText(String.valueOf(scoreTeamA));
        tv_Score_B.setText(String.valueOf(scoreTeamB));

        d_Goal = new Dialog(this);

        btn_Goal = findViewById(R.id.btn_goal);
        btn_Foul = findViewById(R.id.btn_foul);
        btn_Penal = findViewById(R.id.btn_penal);

        btn_Goal.setOnClickListener(this);
        btn_Foul.setOnClickListener(this);
        btn_Penal.setOnClickListener(this);


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(TEAM_A_SCORE, scoreTeamA);
        outState.putInt(TEAM_B_SCORE, scoreTeamB);
        super.onSaveInstanceState(outState);
    }

    public void scoreA (int i){
        scoreTeamA = scoreTeamA + 1;
    }

    public void scoreB (int i){
        scoreTeamB = scoreTeamB + 1;
    }

    @Override
    public void onClick(View v) {

        if (v == btn_Goal) {
           TextView tv_close;
           Button btn_Confirm;
           d_Goal.setContentView(R.layout.goal_popup);
           tv_close = d_Goal.findViewById(R.id.tv_close);
           btn_Confirm = d_Goal.findViewById(R.id.btn_confirm);
           tv_close.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   d_Goal.dismiss();
               }
           });
           d_Goal.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
           d_Goal.show();
        }

    }
}
