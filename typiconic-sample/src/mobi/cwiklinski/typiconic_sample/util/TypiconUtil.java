package mobi.cwiklinski.typiconic_sample.util;

import android.graphics.Typeface;
import android.widget.TextView;
import mobi.cwiklinski.typiconic.Typiconify;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.lang.Integer.toHexString;

public final class TypiconUtil {

    private TypiconUtil() {
        // Singleton
    }

    public static List<Typiconify.IconValue> sort(List<Typiconify.IconValue> iconValues) {
        Collections.sort(iconValues, new Comparator<Typiconify.IconValue>() {
            @Override
            public int compare(Typiconify.IconValue lhs, Typiconify.IconValue rhs) {
                return lhs.toString().compareTo(rhs.toString());
            }
        });
        return iconValues;
    }

    public static String unicodeValue(Typiconify.IconValue iconValue) {
        return "\\u" + toHexString(iconValue.character() | 0x10000).substring(1);
    }

    public static void setTypefaces(Typeface typeface, TextView... views) {
        for (TextView view : views) {
            view.setTypeface(typeface);
        }
    }
}
