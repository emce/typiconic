package mobi.cwiklinski.typiconic_sample;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import mobi.cwiklinski.typiconic.Typiconify;

import static mobi.cwiklinski.typiconic_sample.util.TypiconUtil.unicodeValue;

public class IconDialogFragment extends DialogFragment {

    public static final String FRAGMENT_TAG = IconDialogFragment.class.getSimpleName();
    public static final String EXTRA_ICON_VALUE = "icon_value";
    private TextView mIcon;
    private TextView mDescription;
    private Typiconify.IconValue mCurrentIcon;

    public static IconDialogFragment newInstance(Typiconify.IconValue iconValue) {
        IconDialogFragment fragment = new IconDialogFragment();
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_ICON_VALUE, iconValue);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle extras = getArguments();
        if (extras != null && extras.containsKey(EXTRA_ICON_VALUE)) {
            mCurrentIcon = (Typiconify.IconValue) extras.getSerializable(EXTRA_ICON_VALUE);
        } else {
            dismiss();
        }
        final String text = mCurrentIcon.formattedName();
        mIcon.setText(text);
        getDialog().setTitle(mCurrentIcon.name());
        Typiconify.addIcons(mIcon);
        mDescription.setText(unicodeValue(mCurrentIcon));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_icon, container);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mIcon = (TextView) view.findViewById(R.id.dialog_icon);
        mDescription = (TextView) view.findViewById(R.id.dialog_description);
    }
}
