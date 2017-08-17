package ludwig031.com.github.gameoflife;

import android.app.Activity;
import android.os.Bundle;

public class GridActivity extends Activity{
    /** Poziva se kod prvog kreiranja aktivnosti. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(Bundle savedInstanceState);
        setContentView(R.layout.grid);
    }
}
