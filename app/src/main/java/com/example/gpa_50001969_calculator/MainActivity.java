package com.example.gpa_50001969_calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
// This is the button to calculate the gpa.
    //Also I have the lines so that the user can enter the grades.
    Button b;
    EditText L1,L2,L3,L4,L5;
    TextView t;
    int count=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(Button)findViewById(R.id.b);
        L1=(EditText)findViewById(R.id.L1);
        L2=(EditText)findViewById(R.id.L2);
        L3=(EditText)findViewById(R.id.L3);
        L4=(EditText)findViewById(R.id.L4);
        L5=(EditText)findViewById(R.id.L5);
        t=(TextView)findViewById(R.id.t);
        t.setBackgroundColor(Color.WHITE);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            //If the user clicks to calculate the gpa, then the message will appear.
            public void onClick(View v) {
                float g1, g2, g3, g4, g5;
                if (count % 2 == 0) {
                    if (L1.getText().toString().equals("") || L2.getText().toString().equals("") || L3.getText().toString().equals("") || L4.getText().toString().equals("") || L5.getText().toString().equals("")) {
                        t.setText("Please fill in all grades ");
                    }
                    else {
                        // These are the 5 grades that the user will end up entering.
                        g1 = Float.parseFloat(L1.getText().toString());
                        g2 = Float.parseFloat(L2.getText().toString());
                        g3 = Float.parseFloat(L3.getText().toString());
                        g4 = Float.parseFloat(L4.getText().toString());
                        g5 = Float.parseFloat(L5.getText().toString());
                        float avg = g1 + g2 + g3 + g4 + g5;
                        avg = avg / 5;
                        if (avg < 60) {
                            t.setText(Float.toString(avg));
                            t.setBackgroundColor(Color.RED);
                        } else if (avg > 60 && avg < 80) {
                            t.setText(Float.toString(avg));
                            t.setBackgroundColor(Color.YELLOW);
                        } else if (avg >= 80 && avg <= 100) {
                            t.setText(Float.toString(avg));
                            t.setBackgroundColor(Color.GREEN);
                        }
                        count++;
                        //After the gpa has appeared then the user can click on it
                        b.setText("Clear GPA");
                    }

                }
                else
                {
            // Setting the button to calculate the gpa
                    L1.setText("");
                    L2.setText("");
                    L3.setText("");
                    L4.setText("");
                    L5.setText("");
                    t.setText("");
                    b.setText("Calculate GPA");
                    t.setBackgroundColor(Color.WHITE);
                    count++;
                }
            }
        });
    }
}