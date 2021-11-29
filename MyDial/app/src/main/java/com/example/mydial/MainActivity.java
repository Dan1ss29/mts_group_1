package com.example.mydial;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        Dialog dial;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Button next = findViewById(R.id.btnNext);
            Button dial = findViewById(R.id.btnDial);
            next.setOnClickListener(v -> openSecondActivity());
            dial.setOnClickListener(v -> openDialog());

        }
        public void chkBoxClick(View view){
            CheckBox checkBox = (CheckBox) view;
            if(checkBox.isChecked()) {
                useToast(checkBox.getText() + " checked");
            }
            else {
                useToast(checkBox.getText() + " unchecked");
            }
        }
        public void useToast(String textMessage) {
            Toast.makeText(this, textMessage, Toast.LENGTH_SHORT).show();
        }
        public void openSecondActivity() {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        }

        public void openDialog(){
            dial = new Dialog(MainActivity.this);
            dial.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dial.setCancelable(true);
            dial.setContentView(R.layout.dialog);

            View[] checkBoxes = new View[]{
                    dial.findViewById(R.id.chkBoxMember1),
                    dial.findViewById(R.id.chkBoxMember2),
                    dial.findViewById(R.id.chkBoxMember3),
                    dial.findViewById(R.id.chkBoxMember4)
            };

            for(View view : checkBoxes){
                view.setOnClickListener(v -> chkBoxClick(view));
            }
            Button btnOK = dial.findViewById(R.id.btnOK);
            btnOK.setOnClickListener((v) -> useToast("You clicked OK"));

            Button btnClose = dial.findViewById(R.id.btnClose);
            btnClose.setOnClickListener(v -> {
                useToast("You closed dialog");
                dial.dismiss();
            });

            dial.show();
        }

}
