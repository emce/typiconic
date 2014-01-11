package mobi.cwiklinski.typiconic_sample;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import mobi.cwiklinski.typiconic.TypiconicDrawable;
import mobi.cwiklinski.typiconic.Typiconify;

import java.util.List;

import static java.util.Arrays.asList;

public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

    protected GridView mGridView;
    public static List<Typiconify.IconValue> ICON_VALUES = asList(Typiconify.IconValue.values());

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mGridView = (GridView) findViewById(R.id.gridView);
        mGridView.setOnItemClickListener(this);
        mGridView.setAdapter(new ListAdapter(this, ICON_VALUES));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem item = menu.add(
            R.id.menu_group_main, R.id.menu_about, 100, R.string.menu_about);
        MenuItemCompat.setShowAsAction(item,
            MenuItemCompat.SHOW_AS_ACTION_ALWAYS | MenuItemCompat.SHOW_AS_ACTION_WITH_TEXT);
        Drawable aboutDrawable = new TypiconicDrawable(this, Typiconify.IconValue.ti_info_large_outline)
            .colorRes(R.color.black)
            .actionBarSize();
        item.setIcon(aboutDrawable);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_about:
                startActivity(new Intent(this, AboutActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        IconDialogFragment.newInstance(ICON_VALUES.get(i))
            .show(getSupportFragmentManager(), IconDialogFragment.FRAGMENT_TAG);
    }
}
