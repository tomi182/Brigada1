package com.example.ziacka_knizka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView tv1 = (TextView) findViewById(R.id.textView);
        TextView tv2 = (TextView) findViewById(R.id.textView2);
        Button btn = (Button) findViewById(R.id.button);
         et = (EditText) findViewById(R.id.editTextTextPersonName);

        Intent intent = getIntent();
        String ziak = intent.getStringExtra("ziak");
        String znamky = intent.getStringExtra("znamky");

        tv1.setText(ziak);
        tv2.setText(znamky);

    }

    public void poKlik(View view) {
        finish();
    }

    public void poKlik2(View view) {
        Intent intt = new Intent(DetailActivity.this, MainActivity.class);
        intt.putExtra("znamka", et.getText().toString());
        setResult(RESULT_OK,intt);
        finish();
    }
}