package com.example.android1homework2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android1homework2.R;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private EditText editText2;
    private EditText editText3;
    private TextView textView;
    private int result;
    final String RESULT_KEY = "SUM";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText =  findViewById(R.id.editText);
        editText2 =  findViewById(R.id.editText2);
        editText3 =  findViewById(R.id.editText3);
        Button button = findViewById(R.id.button);
        textView =  findViewById(R.id.textView);

        button.setOnClickListener(view -> calculate());//можно и так

       /* button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
            }
        }); можно и так*/

    }

    public void calculate(){

        int digit1 = Integer.parseInt(editText.getText().toString());
        int digit2 = Integer.parseInt(editText2.getText().toString());
        int digit3 = Integer.parseInt(editText3.getText().toString());

        result = (digit1 + digit2 + digit3)/3;
        textView.setText(String.valueOf(result));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(RESULT_KEY, result);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        savedInstanceState.getInt(RESULT_KEY, result);
        textView.setText(String.valueOf(result));
    }
}