package com.example.simpletodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText edItem;
    Button button_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        edItem = findViewById(R.id.edItem);
        button_save = findViewById(R.id.button_save);

        getSupportActionBar().setTitle("Edit item");
        edItem.setText(getIntent().getStringExtra(MainActivity.KI_TEXT));
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(MainActivity.KI_TEXT, edItem.getText().toString());
                intent.putExtra(MainActivity.KT_POSITION, getIntent().getExtras().getInt(MainActivity.KT_POSITION));
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}