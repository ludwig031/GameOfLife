package ludwig031.com.github.gameoflife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class GridActivity extends Activity{

    private static final int CELL_SIZE = 8;
    private static final int WIDTH = 320 / CELL_SIZE;
    private static final int HEIGHT = 480 / CELL_SIZE;

    private static final int[][] gridArray = new int[HEIGHT][WIDTH];

    private GridView gridView;

    /** Poziva se kod prvog kreiranja aktivnosti. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initializeGrid();

        gridView = new GridView(this);

        setContentView(gridView);
        gridView.requestFocus();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                startActivity(new Intent(this, PreferencesActivity.class));
                return true;
        }
        return false;
    }
}
