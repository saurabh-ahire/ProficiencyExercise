package saurabh.test.com.proficiencyexercise.utility;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.widget.Button;

import saurabh.test.com.proficiencyexercise.R;

/**
 * Created by saurabha on 18/10/18.
 *
 */
public class DialogPresenter {

    /*
    * This method will show a alert dialog
    * With parameters
    * mContext - Context
    * dialogTitle  - Title of dialog
    * message  - message of dialog
    * positiveButtonName - Positive button name of dialog
    * negativeButtonName  - Negative button name of dialog
    * listener  - Call back listener of positive and negative button
    * */

    public static void showDialog(Context mContext, String dialogTitle, String message, String positiveButtonName, String negativeButtonName, final CustomDialogView listener) {

        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        AlertDialog dialog = builder.create();
        builder.setTitle(dialogTitle);
        builder.setCancelable(false);
        builder.setMessage(message);

        builder.setPositiveButton(positiveButtonName, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                if (listener != null)
                    listener.onPositiveButtonClicked();
            }
        });

        if (negativeButtonName != null) {
            builder.setNegativeButton(negativeButtonName, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    if (listener != null)
                        listener.onNegativeButtonClicked();
                }
            });
        }

        Button neutral_button = dialog.getButton(DialogInterface.BUTTON_NEUTRAL);
        Button positive_button = dialog.getButton(DialogInterface.BUTTON_POSITIVE);

        if (neutral_button != null) {
            neutral_button.setTextColor(ContextCompat.getColor(mContext, R.color.black));
        }
        if (positive_button != null) {
            positive_button.setTextColor(ContextCompat.getColor(mContext, R.color.black));
        }
        if (! ((Activity) mContext).isFinishing()) {
            builder.show();
        }

    }

    public interface CustomDialogView {
        void onPositiveButtonClicked();

        void onNegativeButtonClicked();
    }
}
