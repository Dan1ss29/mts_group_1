package com.example.pw2;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button activitySwitch = findViewById(R.id.activitySwitch);
        activitySwitch.setOnClickListener(v -> openActivity2());

        Button dialog = findViewById(R.id.dialog);
        dialog.setOnClickListener(v -> openDialog());

    }
    public void openActivity2(){
        startActivity(new Intent(this, MainActivity2.class));
    }

    void openDialog(){
        dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.custom_dialog);

        View[] checkBoxViews = new View[]{
                dialog.findViewById(R.id.member1),
                dialog.findViewById(R.id.member2),
                dialog.findViewById(R.id.member3),
                dialog.findViewById(R.id.member4)
        };

        for(View view : checkBoxViews){
            view.setOnClickListener(v -> onCheckBoxClicked(view));
        }

        Button btnOK = dialog.findViewById(R.id.btnOK);
        btnOK.setOnClickListener((v) -> setToast("You clicked OK"));

        Button btnClose = dialog.findViewById(R.id.btnClose);
        btnClose.setOnClickListener(v -> {
            setToast("You closed dialog");
            dialog.dismiss();
        });

        dialog.show();

    }

    public void onCheckBoxClicked(View view){

        CheckBox checkBox = (CheckBox) view;

        // Display a toast when a checkbox is checked or unchecked
        if(checkBox.isChecked())
        {
            setToast(checkBox.getText() + " checked");
        }
        else
        {
            setToast(checkBox.getText() + " unchecked");
        }
    }

    public void setToast(String textMessage)
    {
        Toast.makeText(this, textMessage, Toast.LENGTH_SHORT).show();
    }
}