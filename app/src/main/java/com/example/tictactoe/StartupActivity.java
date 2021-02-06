package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class StartupActivity extends AppCompatActivity {

    EditText textBox,textBox2;
    Button passButton;
    String str="pl";
    String str2="pl";

    Dialog myDialog;
   // Dialog myDialog1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);
        myDialog = new Dialog(this);


        Button btn1 = findViewById(R.id.exitbutton);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }
    public void aboutwindow(View view){
        myDialog.setContentView(R.layout.activity_about);
        TextView txtclose =myDialog.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void openmultiplayer() {
        Intent intent = new Intent(getApplicationContext(), multiplayer.class);
        intent.putExtra("message", str);
        intent.putExtra("anothermessage", str2);

        //startActivity(intent);
    }
    public void mpwindow(View view)
    {
        myDialog.setContentView(R.layout.actvity_entername);
        textBox = myDialog.findViewById(R.id.editText2);
        textBox2 = myDialog.findViewById(R.id.editText3);
        passButton =myDialog.findViewById(R.id.easybutton);
        TextView txtclose =myDialog.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myDialog.dismiss();
            }
        });

        passButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                str = textBox.getText().toString();
                str2 = textBox2.getText().toString();

                openmultiplayer();
                myDialog.dismiss();
            }
        });

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

    public void playwindow(View view) {
        myDialog.setContentView(R.layout.activity_popup);

        TextView txtclose =myDialog.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });

        Button easybutton = myDialog.findViewById(R.id.easybutton);
        easybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openeasymode();
                myDialog.dismiss();
            }
        });
        Button hardbutton = myDialog.findViewById(R.id.hardbutton);
        hardbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openhardmode();
                myDialog.dismiss();
            }
        });

        Button mdbutton = myDialog.findViewById(R.id.mdbutton);
        mdbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
                myDialog.dismiss();
            }
        });

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

    public void openMainActivity(){
       Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openeasymode(){
        Intent intent = new Intent(this,easymode.class);
        startActivity(intent);
    }
    public void openhardmode(){
        Intent intent = new Intent(this, hardmode.class);
        startActivity(intent);
    }


}
