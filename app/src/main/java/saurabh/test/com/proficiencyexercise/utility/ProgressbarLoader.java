package saurabh.test.com.proficiencyexercise.utility;

/**
 * This is a interface to set rules to show and hide progressbar.
 *
 * Created by saurabha on 18/10/18.
 *
 */
public interface ProgressbarLoader {

    /**
     * Method to show and hide progress dialog
     *
     * @param show - true to show and false to hide the dialog box
     */
    void showLoading(boolean show);
    /**
     * Method to show and hide progress dialog with message
     *
     * @param show - true to show otherwise false
     * @param message  - message to be displayed
     */
    void showLoading(boolean show, String message);

}
