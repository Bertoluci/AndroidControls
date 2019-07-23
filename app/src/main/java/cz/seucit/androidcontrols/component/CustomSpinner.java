package cz.seucit.androidcontrols.component;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;

/**
 * Spinner, který volá onItemSelected, i když je výběr stejný jako předchozí.
 */
public class CustomSpinner extends android.support.v7.widget.AppCompatSpinner {

    //<editor-fold desc="Constructors">
    public CustomSpinner(Context context) {
        super(context);
    }

    public CustomSpinner(Context context, int mode) {
        super(context, mode);
    }

    public CustomSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomSpinner(Context context, AttributeSet attrs, int defStyleAttr, int mode) {
        super(context, attrs, defStyleAttr, mode);
    }

    public CustomSpinner(Context context, AttributeSet attrs, int defStyleAttr, int mode, Resources.Theme popupTheme) {
        super(context, attrs, defStyleAttr, mode, popupTheme);
    }
    //</editor-fold>

    @Override
    public void setSelection(int position, boolean animate) {
        super.setSelection(position, animate);
        // Spinner(předek) nevolá OnItemSelectedListener, pokud je vybrána stejná položka.
        if (position == getSelectedItemPosition()) {
            // vyvolání listeneru
            getOnItemSelectedListener().onItemSelected(this, getSelectedView(), position, getSelectedItemId());
        }
    }

    @Override
    public void setSelection(int position) {
        super.setSelection(position);
        // Spinner(předek) nevolá OnItemSelectedListener, pokud je vybrána stejná položka.
        if (position == getSelectedItemPosition()) {
            // vyvolání listeneru
            getOnItemSelectedListener().onItemSelected(this, getSelectedView(), position, getSelectedItemId());
        }
    }
}
