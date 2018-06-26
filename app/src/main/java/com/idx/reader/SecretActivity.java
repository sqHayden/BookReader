package com.idx.reader;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by xieshulan on 17-9-26.
 */

public class SecretActivity extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secret_main);
        ActionBar bar=getSupportActionBar();
        bar.hide();
        ImageButton close=(ImageButton) findViewById(R.id.id_secret_back_tv);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SecretActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}