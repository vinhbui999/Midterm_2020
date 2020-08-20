package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RatingBar ratingBar;//only for showing
    HelperInfor helperInfor = new HelperInfor(null,null,null,null,null,(float)0);
    private String file_name;
    Intent intentToHired =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        try {
            FileOutputStream fos = openFileOutput("test.txt", 0);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write("Bùi Xuân Vĩnh" + '\n');
            bw.write("0989778966"+'\n');
            bw.write("Male" +'\n');
            bw.write("14/09/2000" +'\n');
            bw.write("231/83/8A Dương Bá Trạc, Phường 1, Quận 8" + '\n');
            bw.write("Work early in the noon" +'\n');
            bw.write("2"+'\n');
            bw.write(String.valueOf(Integer.valueOf(R.drawable.vinh_avt)) +'\n');
            bw.write("true" +'\n');

            bw.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
        Button booking = findViewById(R.id.booking);
        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(helperInfor.available == true){
                    Toast.makeText(MainActivity.this, "You can book this helper, because they are available",
                            Toast.LENGTH_SHORT).show();

                    intentToHired = new Intent(MainActivity.this, CustomerHire.class);
                    intentToHired.putExtra("FullNameHelper", helperInfor.getHName());
                    startActivity(intentToHired);
                }
                else{
                    Toast.makeText(MainActivity.this, "You can not book this helper, because they are not available", Toast.LENGTH_SHORT).show();
                    //return to current page because they are not available
                }
            }
        });
        initinForHelper();
        initRatingBar();
        //initHistRating();

    }

    private void initHistRating() {
        //show list of history of rating of this helper
    }

    private void getHelperInforFromFile(int avt_ID) {
        //use id to find her/his infor in storage
        FileInputStream fis = null;
        file_name = "test.txt";

        try {
            fis = openFileInput("test.txt");
            InputStreamReader reader = new InputStreamReader(fis,"UTF-8");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String text =null;
            StringBuilder sb = new StringBuilder();
            int k=8;
            while((text = bufferedReader.readLine())!=null){
                sb.append(text).append('\n');
                if(k==8){
                    helperInfor.setHName(text);
                    k--;
                }
                else if(k==7){
                    helperInfor.setPhone(text);
                    k--;
                }
                else if(k==6){
                    helperInfor.setGender(text);
                    k--;
                }
                else if(k==5){
                    helperInfor.setDOB(text);
                    k--;
                }
                else if(k==4){
                    helperInfor.setAddress(text);
                    k--;
                }

                else if(k==3){
                    helperInfor.setNotes(text);
                    k--;
                }
                else if(k==2){
                    helperInfor.setRating(Float.parseFloat(text));
                    k--;
                }
                else if(k==1){
                    helperInfor.setAvatar(Integer.parseInt(text));
                    k--;
                }
                else if(k==0){
                    helperInfor.setAvailable(Boolean.parseBoolean(text));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private void initinForHelper() {
        ratingBar = findViewById(R.id.ratingCus);
        //add id of helper here to show his/her information

        getHelperInforFromFile(0);

        TextView name = findViewById(R.id.fullNameCus);
        TextView gender = findViewById(R.id.sexCus);
        TextView dob = findViewById(R.id.dob);
        TextView address = findViewById(R.id.addsCus);
        TextView note = findViewById(R.id.note);
        TextView phone = findViewById(R.id.phoneCus);
        ImageView avatar = (ImageView)findViewById(R.id.avatarCus);

        name.setText(helperInfor.getHName());
        gender.setText(helperInfor.getGender());
        dob.setText(helperInfor.getDOB());
        address.setText(helperInfor.getAddress());
        avatar.setImageDrawable(getResources().getDrawable(R.drawable.vinh_avt));
        note.setText(helperInfor.getNotes());
        phone.setText(helperInfor.getPhone());
        ratingBar.setRating(helperInfor.getRating());
    }

    private void initRatingBar() {
        ratingBar.setRating(helperInfor.getRating());
       // Toast.makeText(this, String.valueOf(ratingBar.getRating()) , Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View view) {

    }
}