package com.example.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Random;

public class easymode  extends AppCompatActivity {
    int[] board = {2,2,2,2,2,2,2,2,2};
    int[][] winningboard= {
            {0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}
    };
    int win;
    int winner1=0;
    int winner2=0;
    int elev=0;
    int move;
    boolean gamenotover=true;

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

    public int cpuMove()
    {   int count =0;
        Random rand =new Random();
        while(count!=1)
        {
            int no=rand.nextInt(9);
            for(int i=0;i<9;i++)
            {
                if(board[no]==2)
                {
                    count=1;
                    return no;

                }
            }
        }
        return -1;
    }

    public void cpuChance()
    { if(elev<=1)
       {   move = cpuMove();
           board[move]=1;
           elev++;
       }
       else{
        int count=tac.count(board);
        tac.Move bestMove = tac.findBestMove(board, winningboard,count);
        move=bestMove.bespos;
        board[move]=1;
    }
        switch(move)
        {
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
    public void playitagain(View view)
    {

        gamenotover = true;
        elev=0;


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

        if (win==1)
        {
            cpuChance();
        }


    }
    public void checkwin()
        {
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
                gamenotover=false;
                winner1++;
                textView3.setText("YOU: "+winner1);

            }
            else if(value==-10)
            {
                textView.setText("CPU WIN");
                linearLayout.setVisibility(View.VISIBLE);
                win=1;
                gamenotover=false;
                winner2++;
                textView2.setText("CPU: "+winner2);
            }
            else if(!tac.isMovesLeft(board))
            {
                textView.setText("It's a draw!!");
                linearLayout.setVisibility(View.VISIBLE);
                gamenotover=false;
                win=0;
            }

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
