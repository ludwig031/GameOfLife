package com.quesucede.gameoflife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import ludwig031.com.github.gameoflife.R;

public class MainActivity extends Activity implements OnClickListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View aboutButton = findViewById(R.id.about_button);
        aboutButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.about_button:
                Intent i = new Intent(this, ludwig031.com.github.gameoflife.AboutActivity.AboutActivity.class);
                startActivity(i);
                break;
        }
    }
}