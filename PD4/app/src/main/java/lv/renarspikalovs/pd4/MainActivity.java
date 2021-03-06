package lv.renarspikalovs.pd4;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonAdd, buttonSub, buttonDivision,
            buttonMul, button10, buttonC, buttonEqual , buttonMC , buttonMR , buttonMS;
    EditText EditTextCalculate;

    float mValueOne, mValueTwo, savedValue, randomValue=0;

    boolean calculateAddition, calculateSubtract, calculateMultiplication, calculateDivision;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        buttonAdd = (Button) findViewById(R.id.buttonadd);
        buttonSub = (Button) findViewById(R.id.buttonsub);
        buttonMul = (Button) findViewById(R.id.buttonmul);
        buttonDivision = (Button) findViewById(R.id.buttondiv);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonEqual = (Button) findViewById(R.id.buttoneql);
        buttonMC = (Button) findViewById(R.id.buttonMC);
        buttonMR = (Button) findViewById(R.id.buttonMR);
        buttonMS = (Button) findViewById(R.id.buttonMS);
        EditTextCalculate = (EditText) findViewById(R.id.edt1);

        buttonMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedValue= Float.parseFloat(EditTextCalculate.getText() + "");
            }
        });
        buttonMR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditTextCalculate.setText(EditTextCalculate.getText() + "" + savedValue);
            }
        });
        buttonMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedValue= randomValue;
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditTextCalculate.setText(EditTextCalculate.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditTextCalculate.setText(EditTextCalculate.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditTextCalculate.setText(EditTextCalculate.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditTextCalculate.setText(EditTextCalculate.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditTextCalculate.setText(EditTextCalculate.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditTextCalculate.setText(EditTextCalculate.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditTextCalculate.setText(EditTextCalculate.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditTextCalculate.setText(EditTextCalculate.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditTextCalculate.setText(EditTextCalculate.getText() + "9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditTextCalculate.setText(EditTextCalculate.getText() + "0");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (EditTextCalculate == null) {
                    EditTextCalculate.setText("");
                } else {
                    mValueOne = Float.parseFloat(EditTextCalculate.getText() + "");
                    calculateAddition = true;
                    EditTextCalculate.setText(null);
                }
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(EditTextCalculate.getText() + "");
                calculateSubtract = true;
                EditTextCalculate.setText(null);
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(EditTextCalculate.getText() + "");
                calculateMultiplication = true;
                EditTextCalculate.setText(null);
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(EditTextCalculate.getText() + "");
                calculateDivision = true;
                EditTextCalculate.setText(null);
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueTwo = Float.parseFloat(EditTextCalculate.getText() + "");

                if (calculateAddition == true) {
                    EditTextCalculate.setText(mValueOne + mValueTwo + "");
                    calculateAddition = false;
                }

                if (calculateSubtract == true) {
                    EditTextCalculate.setText(mValueOne - mValueTwo + "");
                    calculateSubtract = false;
                }

                if (calculateMultiplication == true) {
                    EditTextCalculate.setText(mValueOne * mValueTwo + "");
                    calculateMultiplication = false;
                }

                if (calculateDivision == true) {
                    EditTextCalculate.setText(mValueOne / mValueTwo + "");
                    calculateDivision = false;
                }
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditTextCalculate.setText("");
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditTextCalculate.setText(EditTextCalculate.getText() + ".");
            }
        });
    }
}