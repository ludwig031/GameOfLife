package ludwig031.com.github.gameoflife;
 /*import android paketa*/
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View newButton = findViewById(R.id.new_button);
        newButton.setOnClickListener(this);
        View aboutButton = findViewById(R.id.about_button);
        aboutButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.new_button:
                Intent gridIntent = new Intent(this, GridActivity.class);
                startActivity(gridIntent);
                break;
            case R.id.about_button:
                Intent i = new Intent(this, AboutActivity.class);
                startActivity(i);
                break;
        }
    }
}