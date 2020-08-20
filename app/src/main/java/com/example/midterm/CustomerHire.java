package com.example.midterm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.Helper;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class CustomerHire extends AppCompatActivity {
    TextInputEditText  address, description, day,time, purchase;
    ActionBar actionBar;
    Intent intentHelper = null;
    String fullNameHelper;
    Bundle get;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_hire);

        actionBar = getSupportActionBar();
        intentHelper=getIntent();
        get = intentHelper.getExtras();
        fullNameHelper = get.getString("FullNameHelper");

        modifyActionBar();

        initEditTexts();
    }

    private void modifyActionBar() {
        actionBar.setTitle("Request to " + fullNameHelper);
    }

    private void initEditTexts() {
        address= findViewById(R.id.addHire);
        description = findViewById(R.id.descripWork);
        day=findViewById(R.id.requDay);
        time = findViewById(R.id.requTime);
        purchase = findViewById(R.id.purchase);

    }

    public void btn_send_request_to_helper(View view) {
        //send it to customer hist
        // send purchase, time, date

        Snackbar.make(view, "Send request to helper", Snackbar.LENGTH_LONG)
                .setAction("DISMISS", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                }).show();
    }
}
