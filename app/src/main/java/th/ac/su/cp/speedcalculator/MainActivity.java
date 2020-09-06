package th.ac.su.cp.speedcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button calculate = findViewById(R.id.calculate);

        Button button_clear = findViewById(R.id.clear);
        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText Distance = findViewById(R.id.distance);
                EditText Time = findViewById(R.id.time);
                TextView Result = findViewById(R.id.result);
                Distance.setText("");
                Time.setText("");
                Result.setText("");

            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText distance = findViewById(R.id.distance);
                EditText time = findViewById(R.id.time);
                TextView Result = findViewById(R.id.result);
                String Distance = distance.getText().toString();
                String Time = time.getText().toString();
                if(Distance.isEmpty()||Time.isEmpty()){
                    Toast t = Toast.makeText(MainActivity.this, R.string.Distanceandtimearerequired,Toast.LENGTH_LONG);
                    t.show();
                }
                else {
                    Double X = Double.parseDouble(Distance);
                    Double Y = Double.parseDouble(Time);
                    if(Y==0){
                        Toast t = Toast.makeText(MainActivity.this, R.string.Timemustbegreaterthanzero,Toast.LENGTH_LONG);
                        t.show();
                    }
                    else {
                        Double ANS = (X / 1000) / (Y / 3600);
                        Result.setText(String.format("%.2f", ANS));
                        if(ANS>80){
                            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                            dialog.setTitle("SPEED CALCULATOR");
                            dialog.setMessage(R.string.Speedisoverlimit);
                            dialog.setPositiveButton("OK",null);
                            dialog.show();}
                    }
                }


            }
        });

    }
}