package com.example.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;

public class multiplayer extends AppCompatActivity {
    int[] board = {2,2,2,2,2,2,2,2,2};
    int count1=0,count2=0;
    int[][] winningboard= {
            {0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}
    };
    String str;
    String str2;

    int winningplayer=0;
    boolean gamenotover=true;
    int chance=1;
    public void clicked(View view)
    {
        if(gamenotover && winningplayer==0) {
            ImageView counter = (ImageView) view;
            int tag = Integer.parseInt(counter.getTag().toString());
            board[tag] = 0;
            counter.setImageResource(R.drawable.yellow);
            counter.setEnabled(false);
            System.out.println(Arrays.toString(board));
            mpcheckwin();
            if(gamenotover)
               winningplayer=1;
        }
        else if(gamenotover && winningplayer==1) {
            ImageView counter = (ImageView) view;
            int tag = Integer.parseInt(counter.getTag().toString());
            board[tag] = 1;
            counter.setImageResource(R.drawable.red);
            counter.setEnabled(false);
            System.out.println(Arrays.toString(board));
            mpcheckwin();
            if(gamenotover)
                winningplayer=0;
        }
    }

    public void mpcheckwin()
    {   TextView textView=findViewById(R.id.textViewinfo);
        LinearLayout linearLayout=findViewById(R.id.linearlay);
        TextView textView2=findViewById(R.id.textView3);
        TextView textView3=findViewById(R.id.textView2);
        int value=evaluatempboard();
        if (value==10)
        {
            textView.setText(str+" WIN");
            linearLayout.setVisibility(View.VISIBLE);
            textView2.setText(str+": "+(count1));

            gamenotover=false;

        }
        else if(value==-10)
        {
            textView.setText(str2+" WIN");
            linearLayout.setVisibility(View.VISIBLE);
            textView3.setText(str2+": "+count2);
            gamenotover=false;
        }
        else if(value==0)
        {
            textView.setText("It's a draw!!");
            linearLayout.setVisibility(View.VISIBLE);
            gamenotover=false;
        }
    }

    public int evaluatempboard()
    {
        for(int wins[]:winningboard) {
            if (board[wins[0]] == board[wins[1]] && board[wins[1]] == board[wins[2]] && board[wins[0]] != 2) {
                if (board[wins[0]] == 0) {
                    winningplayer = 0;
                    count1++;
                    return 10;
                } else {
                    winningplayer = 1;
                    count2++;
                    return -10;
                }
            }
        }
        if(!tac.isMovesLeft(board))
            {
                chance++;
                if(chance%2!=0)
                {
                    winningplayer=0;
                }
                else
                {
                    winningplayer=1;
                }
                if(winningplayer==0) {
                    Toast.makeText(getApplicationContext(), "Next First Turn WIll Be of " +str, Toast.LENGTH_LONG).show();
                    return 0;
                }
                else if(winningplayer==1) {
                    Toast.makeText(getApplicationContext(), "Next First Turn WIll Be of " +str2, Toast.LENGTH_LONG).show();
                    return 0;
                }
                return 0;
            }
            else
            {
                return -1;
            }
        }
        public void playitagain(View view)
        {  gamenotover = true;


            LinearLayout layout = findViewById(R.id.linearlay);

            layout.setVisibility(View.INVISIBLE);
            for (int i = 0; i < 9; i++) {

                board[i] = 2;

            }
            androidx.gridlayout.widget.GridLayout gridLayout = findViewById(R.id.gridLayout);
            for (int i = 0; i< gridLayout.getChildCount(); i++) {

                ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);

            }
            ImageView imageView0= findViewById(R.id.imageView0);
            imageView0.setEnabled(true);

            ImageView imageView1= findViewById(R.id.imageView1);
            imageView1.setEnabled(true);

            ImageView imageView2= findViewById(R.id.imageView2);
            imageView2.setEnabled(true);

            ImageView imageView3= findViewById(R.id.imageView3);
            imageView3.setEnabled(true);

            ImageView imageView4= findViewById(R.id.imageView4);
            imageView4.setEnabled(true);

            ImageView imageView5= findViewById(R.id.imageView5);
            imageView5.setEnabled(true);

            ImageView imageView6= findViewById(R.id.imageView6);
            imageView6.setEnabled(true);

            ImageView imageView7= findViewById(R.id.imageView7);
            imageView7.setEnabled(true);

            ImageView imageView8= findViewById(R.id.imageView8);
            imageView8.setEnabled(true);

        }



     TextView textView,textView2;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView3);
        textView2=findViewById(R.id.textView2);
        Intent intent = getIntent();
        str = intent.getStringExtra("message");
        str2 = intent.getStringExtra("anothermessage");
        textView.setText(str+": 0");
        textView2.setText(str2+": 0");

    }

}
