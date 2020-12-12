package kr.co.my.thermotrans;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    EditText editCent;
    EditText editFha;
    RadioButton rtoFha;
    RadioButton rtoCent;
    Button cancell;
    Button convert;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editCent = findViewById(R.id.editCent);
        editFha = findViewById(R.id.editFha);
        rtoFha = findViewById(R.id.rtoFha);
        rtoCent = findViewById(R.id.rtoCent);
        cancell = findViewById(R.id.cancell);
        convert = findViewById(R.id.convert);

        convert.setOnClickListener(this);
        cancell.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == convert && rtoFha.isChecked()){
            double val = Double.parseDouble(editCent.getText().toString());
            convertCentToFha(val);
        }else if( v == convert && rtoCent.isChecked()){
            double val = Double.parseDouble(editFha.getText().toString());
            convertFhaToCent(val);
        }else if (v == cancell){
            editCent.setText("0.0");
            editFha.setText("0.0");
        }
    }
    protected String formats(double degree){
        return String.format("%1$.2f",degree);
    }
    public double celsiusToFahrenheit(double c){
        return 9.0/5.0*c+32.0;
    }
    public double fahrenheitToCelsius(double f){
        return 5.0/9.0*(f-32);
    }
    protected void convertFhaToCent(double val) {
        editCent.setText(formats(fahrenheitToCelsius(val)));
    }

    protected void convertCentToFha(double val) {
        editFha.setText(formats(celsiusToFahrenheit(val)));
    }
}