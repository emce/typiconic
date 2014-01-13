package mobi.cwiklinski.typiconic_sample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TypiconTextView;
import mobi.cwiklinski.typiconic.Typiconify;

import java.util.List;

import static java.lang.String.format;

public class ListAdapter extends ArrayAdapter<Typiconify.IconValue> {

    private Context mContext;
    private List<Typiconify.IconValue> mList;

    public ListAdapter(Context context, List<Typiconify.IconValue> list) {
        super(context, R.layout.item, list);
        mContext = context;
        mList = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        ViewHolder holder;

        if (v == null) {
            v = LayoutInflater.from(mContext).inflate(R.layout.item, null);
            holder = new ViewHolder();
            holder.iconText = (TypiconTextView) v.findViewById(R.id.icon_text);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }

        Typiconify.IconValue iconValue = mList.get(position);
        String iconName = iconValue.toString().replaceAll("_", "-");
        holder.iconText.setText(format("{%s}  %s", iconName, iconName));
        Typiconify.addIcons(holder.iconText);
        return v;
    }

    static class ViewHolder {
        TypiconTextView iconText;
    }
}
