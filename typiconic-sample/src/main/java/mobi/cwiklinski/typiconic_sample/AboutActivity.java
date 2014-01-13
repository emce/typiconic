package mobi.cwiklinski.typiconic_sample;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.TypiconButton;
import mobi.cwiklinski.typiconic.TypiconicDrawable;
import mobi.cwiklinski.typiconic.Typiconify;

public class AboutActivity extends ActionBarActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        TypiconButton shareButton = (TypiconButton) findViewById(R.id.button_share);
        TypiconButton websiteButton = (TypiconButton) findViewById(R.id.button_website);
        TextView twitter = (TextView) findViewById(R.id.bulletTwitter);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_action));
                AboutActivity.this.startActivity(
                    Intent.createChooser(intent, getString(R.string.share_chooser)));
            }
        });
        websiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://cwiklinski.mobi/typiconic";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://twitter.com/em__ce";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem item = menu.add(
            R.id.menu_group_main, R.id.menu_share, 100, R.string.menu_share);
        MenuItemCompat.setShowAsAction(item,
            MenuItemCompat.SHOW_AS_ACTION_ALWAYS | MenuItemCompat.SHOW_AS_ACTION_WITH_TEXT);
        Drawable shareDrawable = new TypiconicDrawable(this, Typiconify.IconValue.ti_social_at_circular)
            .colorRes(R.color.black)
            .actionBarSize();
        item.setIcon(shareDrawable);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_share:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_action));
                this.startActivity(Intent.createChooser(intent, getString(R.string.share_chooser)));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
