package edu.birzeit.firstin_classactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edtWeight;

    private EditText edtHeight;

    private Switch isMale;

    private Button btnCalculates;

    private TextView txtResult;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
    }

    private void setupViews() {
        edtHeight = findViewById(R.id.edtHeight);
        edtWeight = findViewById(R.id.edtWeight);
        isMale = findViewById(R.id.isMale);
        btnCalculates = findViewById(R.id.btnCalculates);
        txtResult = findViewById(R.id.txtResult);

        btnCalculates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double weight = Double.parseDouble(edtWeight.getText().toString());
                double height = Double.parseDouble(edtHeight.getText().toString());
                double result = weight/Math.pow(height,2);

                if (isMale.isChecked()){
                    result += (result * 0.05);
                }
                txtResult.setVisibility(View.VISIBLE);
                txtResult.setText("" + result);
            }
        });
    }
}
