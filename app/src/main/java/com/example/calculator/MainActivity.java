package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {
    TextView inputtxt,outputtxt;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnin;
    Button btnadd,btnsub,btnmul,btndiv,btnmod,btnbrak,btnclr,btndot,btnequal;
    String data;
    Boolean leftBrak = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        inputtxt = (TextView)findViewById(R.id.inputtxt);
        outputtxt = (TextView)findViewById(R.id.outputtxt);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn7 = (Button)findViewById(R.id.btn7);
        btn8 = (Button)findViewById(R.id.btn8);
        btn9 = (Button)findViewById(R.id.btn9);
        btnadd = (Button)findViewById(R.id.btnadd);
        btnsub = (Button)findViewById(R.id.btnsub);
        btnmul = (Button)findViewById(R.id.btnmul);
        btndiv = (Button)findViewById(R.id.btndiv);
        btnmod = (Button)findViewById(R.id.btnmod);
        btnbrak = (Button)findViewById(R.id.btnbrak);
        btnclr = (Button)findViewById(R.id.btnclr);
        btndot = (Button)findViewById(R.id.btndot);
        btnequal = (Button)findViewById(R.id.btnequal);
        btnin = (Button)findViewById(R.id.btnin);


        btnclr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputtxt.setText("");
                outputtxt.setText("");

            }
        });

        btnin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputtxt.getText().toString();
                inputtxt.setText(data+"0");

            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputtxt.getText().toString();
                inputtxt.setText(data+"1");

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputtxt.getText().toString();
                inputtxt.setText(data+"2");

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputtxt.getText().toString();
                inputtxt.setText(data+"3");

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputtxt.getText().toString();
                inputtxt.setText(data+"4");

            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputtxt.getText().toString();
                inputtxt.setText(data+"5");

            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputtxt.getText().toString();
                inputtxt.setText(data+"6");

            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputtxt.getText().toString();
                inputtxt.setText(data+"7");

            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputtxt.getText().toString();
                inputtxt.setText(data+"8");

            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputtxt.getText().toString();
                inputtxt.setText(data+"9");

            }
        });
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputtxt.getText().toString();
                inputtxt.setText(data+"+");

            }
        });
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputtxt.getText().toString();
                inputtxt.setText(data+"-");

            }
        });
        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputtxt.getText().toString();
                inputtxt.setText(data+"×");

            }
        });
        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputtxt.getText().toString();
                inputtxt.setText(data+"÷");

            }
        });
        btnmod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputtxt.getText().toString();
                inputtxt.setText(data+"%");

            }
        });
        btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputtxt.getText().toString();
                inputtxt.setText(data+".");

            }
        });

        btnbrak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (leftBrak){
                    data = inputtxt.getText().toString();
                    inputtxt.setText(data+"(");
                    leftBrak = false;

                }else {
                    data = inputtxt.getText().toString();
                    inputtxt.setText(data+")");
                    leftBrak = true;
                }


            }
        });
        btnequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputtxt.getText().toString();

                data = data.replaceAll("×","*");
                data = data.replaceAll("%","/100");
                data = data.replaceAll("÷","/");

                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);

                String finalresult="";

                try {
                    Scriptable scriptable = rhino.initStandardObjects();
                    finalresult = rhino.evaluateString(scriptable, data, "Javascript", 1, null).toString();
                }catch (Exception e){
                    finalresult= "0";
                }



                outputtxt.setText(finalresult);

            }
        });



    }
}