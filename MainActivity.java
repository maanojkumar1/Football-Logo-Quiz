package com.example.ryanh.footballlogo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button ans_b1, ans_b2, ans_b3, ans_b4;

    ImageView ft_logo;
    List<Logo> list;
    int turn =1;

    Random r ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r = new Random();

        ft_logo = (ImageView) findViewById(R.id.ft_logo);   //calls the image

        ans_b1 = (Button) findViewById(R.id.ans_b1);            //shows the button by calling it's id from the activity_main xml
        ans_b2 = (Button) findViewById(R.id.ans_b2);
        ans_b3 = (Button) findViewById(R.id.ans_b3);
        ans_b4 = (Button) findViewById(R.id.ans_b4);

        list =  new ArrayList<>();


        // add 20 questions and answers into the list
        for(int i = 0; i < new Dtb().answers.length;i++){
            list.add(new Logo(new Dtb().answers[i],new Dtb().logos[i]));
        }

        Collections.shuffle(list);   //shuffle the list of the question

        newQues(turn);

        ans_b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {    //determins the answer is right or wrong

                Log.i("btn1", ans_b1.getText().toString());

                if(ans_b1.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                    Toast.makeText(MainActivity.this,  "Correct", Toast.LENGTH_SHORT).show();

                    Log.i("Status", "Correct");

                    if(turn<list.size()) {

                        turn++;
                        newQues(turn);

                    }else {
                        Toast.makeText(MainActivity.this,  "Game is Done", Toast.LENGTH_SHORT).show();




                    }
                } else{
                    Log.i("Status", "Wrong");
                    Toast.makeText(MainActivity.this,  "Wrong", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this,  "LOSER !!!!", Toast.LENGTH_SHORT).show();
                    finish();

                }

            }
        });

        ans_b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("btn2", ans_b2.getText().toString());

                if(ans_b2.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                    Toast.makeText(MainActivity.this,  "Correct", Toast.LENGTH_SHORT).show();

                    Log.i("Status", "Correct");

                    if(turn<list.size()) {

                        turn++;
                        newQues(turn);

                    }else {
                        Toast.makeText(MainActivity.this,  "Game is Done", Toast.LENGTH_SHORT).show();




                    }
                } else{
                    Log.i("Status", "Wrong");
                    Toast.makeText(MainActivity.this,  "Wrong", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this,  "LOSER !!!!", Toast.LENGTH_SHORT).show();
                    finish();

                }

            }
        });

        ans_b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("btn3", ans_b3.getText().toString());

                if(ans_b3.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                    Toast.makeText(MainActivity.this,  "Correct", Toast.LENGTH_SHORT).show();

                    Log.i("Status", "Correct");

                    if(turn<list.size()) {

                        turn++;
                        newQues(turn);

                    }else {
                        Toast.makeText(MainActivity.this,  "Game is Done", Toast.LENGTH_SHORT).show();




                    }
                } else{
                    Log.i("Status", "Wrong");
                    Toast.makeText(MainActivity.this,  "Wrong", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this,  "LOSER !!!!", Toast.LENGTH_SHORT).show();
                    finish();

                }

            }
        });

        ans_b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("btn4", ans_b4.getText().toString());

                if(ans_b4.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                    Toast.makeText(MainActivity.this,  "Correct", Toast.LENGTH_SHORT).show();

                    Log.i("Status", "Correct");

                    if(turn<list.size()) {

                        turn++;
                        newQues(turn);

                    }else {
                        Toast.makeText(MainActivity.this,  "Game is Done", Toast.LENGTH_SHORT).show();




                    }
                } else{
                    Log.i("Status", "Wrong");
                    Toast.makeText(MainActivity.this,  "Wrong", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this,  "LOSER !!!!", Toast.LENGTH_SHORT).show();
                    finish();

                }

            }
        });



    }

    private void  newQues(int number) {
        ft_logo.setImageResource(list.get(number - 1).getImg()); // set logo

        int correct_ans = r.nextInt(4) + 1; // generate random number (correct answer)

        // DEBUG
        Log.i("Answer" + number, list.get(number - 1).getName());

        int firstButt = 0;
        int secButt = 0;
        int thirdButt = 0;
        int forthButt = 0;

        switch (correct_ans) {   // to display 1 correct answer and three wrong answers for the 4 switch case

            case 1:

                // set first option
                firstButt = number - 1;
                ans_b1.setText(list.get(firstButt).getName());

                // set second option
                do {
                    secButt = r.nextInt(list.size());
                } while (secButt == firstButt);
                ans_b2.setText(list.get(secButt).getName());

                // set third option
                do {
                    thirdButt = r.nextInt(list.size());
                } while (thirdButt == firstButt || thirdButt == secButt);
                ans_b3.setText(list.get(thirdButt).getName());

                // set forth option
                do {
                    forthButt = r.nextInt(list.size());
                } while (forthButt == firstButt || forthButt == secButt || forthButt == thirdButt);
                ans_b4.setText(list.get(forthButt).getName());

                break;


            case 2:

                // set second option
                secButt = number - 1;
                ans_b2.setText(list.get(secButt).getName());

                // set first option
                do {
                    firstButt = r.nextInt(list.size());
                } while (firstButt == secButt);
                ans_b1.setText(list.get(firstButt).getName());

                // set third option
                do {
                    thirdButt = r.nextInt(list.size());
                } while (thirdButt == firstButt || thirdButt == secButt);
                ans_b3.setText(list.get(thirdButt).getName());

                // set forth option
                do {
                    forthButt = r.nextInt(list.size());
                } while (forthButt == firstButt || forthButt == secButt || forthButt == thirdButt);
                ans_b4.setText(list.get(forthButt).getName());

                break;

            case 3:

                // set third option
                thirdButt = number - 1;
                ans_b3.setText(list.get(thirdButt).getName());

                // set first option
                do {
                    firstButt = r.nextInt(list.size());
                } while (firstButt == thirdButt);
                ans_b1.setText(list.get(firstButt).getName());

                // set second option
                do {
                    secButt = r.nextInt(list.size());
                } while (secButt == firstButt || secButt == thirdButt);
                ans_b2.setText(list.get(secButt).getName());

                // set forth option
                do {
                    forthButt = r.nextInt(list.size());
                } while (forthButt == firstButt || forthButt == secButt || forthButt == thirdButt);
                ans_b4.setText(list.get(forthButt).getName());

            break;



            case 4:

                // set forth option
                forthButt = number - 1;
                ans_b4.setText(list.get(forthButt).getName());

                // set first option
                do {
                    firstButt = r.nextInt(list.size());
                } while (firstButt == forthButt);
                ans_b1.setText(list.get(firstButt).getName());

                // set second option
                do {
                    secButt = r.nextInt(list.size());
                } while (secButt == firstButt || secButt == forthButt);
                ans_b2.setText(list.get(secButt).getName());

                // set third option
                do {
                    thirdButt = r.nextInt(list.size());
                } while (thirdButt == firstButt || thirdButt == secButt || thirdButt == forthButt);
                ans_b3.setText(list.get(thirdButt).getName());

            break;



        }

    }

    }

