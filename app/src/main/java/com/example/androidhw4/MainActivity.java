package com.example.androidhw4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    double defaultcost=75,defaultdistanceplus=250,defaultplus=5,total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText distance=(EditText)findViewById(R.id.distance);
        final EditText defaultmoney =(EditText)findViewById(R.id.Money);
        final TextView totalcostView=(TextView)findViewById(R.id.total);
        final EditText plusmoney=(EditText)findViewById(R.id.plusmoney);
        final EditText plusdistance=(EditText)findViewById((R.id.plusdistance));
       final Button calculate=(Button)findViewById(R.id.costcalculation);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast toast = Toast.makeText(MainActivity.this, "我被按了", Toast.LENGTH_SHORT);
                //toast.show();
                if (    !("".equals(distance.getText().toString()))
                        &&
                        !("".equals(defaultmoney.getText().toString()))
                        &&
                        !("".equals(plusmoney.getText().toString()))
                        &&
                        !("".equals(plusdistance.getText().toString()))){
                    Double DT=Double.parseDouble(distance.getEditableText().toString());
                    Double MO=Double.parseDouble(defaultmoney.getEditableText().toString());
                    Double PM=Double.parseDouble(plusmoney.getEditableText().toString() );
                    Double Ddistance =Double.parseDouble(plusdistance.getEditableText().toString());
                    defaultplus=PM;
                    defaultdistanceplus=Ddistance;
                    defaultcost=MO;
                    total=defaultcost+(Math.ceil(DT/defaultdistanceplus))*defaultplus;

                    totalcostView.setText("總費用:"+total);

                }
            }
        });

    }
}
