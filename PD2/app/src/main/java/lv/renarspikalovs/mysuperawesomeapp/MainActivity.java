package lv.renarspikalovs.mysuperawesomeapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Dialog dialog;

    // String TAG ="MPT1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button opDialog = findViewById(R.id.btnDialog);
        opDialog.setOnClickListener(v -> showGroupDialog());

        Button second = findViewById(R.id.gotosecond);

        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
    });
    }

    private void showGroupDialog() {
        dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.group_dialog);

        View[] checkBoxViews = new View[]{
                dialog.findViewById(R.id.cbxDev1),
                dialog.findViewById(R.id.cbxDev2),
                dialog.findViewById(R.id.cbxDev3),
                dialog.findViewById(R.id.cbxDev4)
        };

        for(View view : checkBoxViews){
            view.setOnClickListener(v -> onCheckBoxClicked(view));
        }

        Button OK = dialog.findViewById(R.id.btnOK);
        OK.setOnClickListener((v) -> setToast("You have clicked OK"));

        Button Close = dialog.findViewById(R.id.btnClose);
        Close.setOnClickListener(v -> {
            setToast("You have closed dialog");
            dialog.dismiss();
        });

        dialog.show();
    }
    public void onCheckBoxClicked(View view){

        CheckBox checkBox = (CheckBox) view;

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