package com.example.tictactoe;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    int[] board = {2,2,2,2,2,2,2,2,2};
    int[][] winningboard= {
            {0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}
    };
    int winner1=0;
    int winner2=0;
    int win;
    boolean gamenotover=true;
    Drawable Red=getDrawable(R.drawable.red);
    public void clicked(View view)
    {
        if(gamenotover) {
            ImageView counter = (ImageView) view;
            int tag = Integer.parseInt(counter.getTag().toString());
            board[tag] = 0;
            counter.setImageResource(R.drawable.yellow);
            counter.setEnabled(false);
            System.out.println(Arrays.toString(board));
            checkwin();
            if(gamenotover)
                cpuChance();
        }
    }

    public void playitagain(View view)
    {

        gamenotover = true;


        LinearLayout layout = (LinearLayout)findViewById(R.id.linearlay);

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

        if(win==1)
        {
            cpuChance();
            Toast.makeText(getApplicationContext(),"You made it tough, to normalize try to Draw",Toast.LENGTH_SHORT).show();
        }

    }
    public void cpuChance() {
        if (win==1)
        {
            board[4]=1;
            ImageView imageView4 = findViewById(R.id.imageView4);
            imageView4.setImageResource(R.drawable.red);
            imageView4.setEnabled(false);
            win=-1;

        }

      else{
           int count=tac.count(board);
            tac.Move bestMove = tac.findBestMove(board, winningboard,count);
            System.out.println(bestMove);
            board[bestMove.bespos] = 1;
            switch (bestMove.bespos) {
                case 0:
                    ImageView imageView0 = findViewById(R.id.imageView0);
                    imageView0.setImageResource(R.drawable.red);
                    imageView0.setEnabled(false);
                    break;
                case 1:
                    ImageView imageView1 = findViewById(R.id.imageView1);
                    imageView1.setImageResource(R.drawable.red);
                    imageView1.setEnabled(false);
                    break;

                case 2:
                    ImageView imageView2 = findViewById(R.id.imageView2);
                    imageView2.setImageResource(R.drawable.red);
                    imageView2.setEnabled(false);
                    break;
                case 3:
                    ImageView imageView3 = findViewById(R.id.imageView3);
                    imageView3.setImageResource(R.drawable.red);
                    imageView3.setEnabled(false);
                    break;
                case 4:
                    ImageView imageView4 = findViewById(R.id.imageView4);
                    imageView4.setImageResource(R.drawable.red);
                    imageView4.setEnabled(false);
                    break;
                case 5:
                    ImageView imageView5 = findViewById(R.id.imageView5);
                    imageView5.setImageResource(R.drawable.red);
                    imageView5.setEnabled(false);
                    break;
                case 6:
                    ImageView imageView6 = findViewById(R.id.imageView6);
                    imageView6.setImageResource(R.drawable.red);
                    imageView6.setEnabled(false);
                    break;
                case 7:
                    ImageView imageView7 = findViewById(R.id.imageView7);
                    imageView7.setImageResource(R.drawable.red);
                    imageView7.setEnabled(false);
                    break;
                case 8:
                    ImageView imageView8 = findViewById(R.id.imageView8);
                    imageView8.setImageResource(R.drawable.red);
                    imageView8.setEnabled(false);
                    break;


            }
            checkwin();
        }
    }
    public void checkwin()
    {
        System.out.println(Arrays.toString(board));
        int value=tac.evaluate(board,winningboard);
        TextView textView=findViewById(R.id.textViewinfo);
        LinearLayout linearLayout=findViewById(R.id.linearlay);
        TextView textView2=findViewById(R.id.textView2);
        TextView textView3=findViewById(R.id.textView3);

        if (value==10)
        {

            textView.setText("YOU WIN");
            linearLayout.setVisibility(View.VISIBLE);
            win=0;
            winner2++;
            textView3.setText("YOU: "+winner2);

            gamenotover=false;
        }
        else if(value==-10)
        {
            textView.setText("CPU WIN");
            linearLayout.setVisibility(View.VISIBLE);
            win=1;
            gamenotover=false;
            winner1++;
            textView2.setText("CPU: "+winner1);
        }
        else if(!tac.isMovesLeft(board))
        {
            textView.setText("It's a draw!!");
            linearLayout.setVisibility(View.VISIBLE);
            gamenotover=false;
        }
        System.out.println(Arrays.toString(board));

    }
    @Override
        protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView2=findViewById(R.id.textView2);
        TextView textView3=findViewById(R.id.textView3);
        textView2.setText("CPU: 0");
        textView3.setText("YOU: 0");
    }
}
