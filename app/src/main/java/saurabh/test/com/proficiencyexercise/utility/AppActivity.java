package saurabh.test.com.proficiencyexercise.utility;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import saurabh.test.com.proficiencyexercise.R;

/**
 * This will be a parent Activity of all other activities.
 * All common code among activities will go here.
 *
 * Created by saurabha on 18/10/18.
 */
public class AppActivity extends AppCompatActivity implements ProgressbarLoader {

    private ProgressDialog progressDialog;

    @BindView(R.id.toolbar_title)
    public TextView tvTitle;

    @Override
    public void setContentView(int layoutResID) {
        RelativeLayout fullView = (RelativeLayout) getLayoutInflater().inflate(R.layout.toolbar_layout, null);
        super.setContentView(fullView);
        ButterKnife.bind(fullView);
        FrameLayout activityContainer = (FrameLayout) fullView.findViewById(R.id.frame);
        getLayoutInflater().inflate(layoutResID, activityContainer, true);

    }


    /*
     * This method will show a progress dialog
     * With parameter
     * show - true -Showing progress dialog
     *        false -Dismiss progress dialog
     * */

    @Override
    public void showLoading(boolean show) {
        if (show) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage(getString(R.string.loading));
            progressDialog.show();
        } else {
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        }
    }

    @Override
    public void showLoading(boolean show, String msg) {
        if (show) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage(msg);
            progressDialog.show();
        } else {
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        }
    }

    /*
     * This method will check Network Connection
     * */

    protected boolean isNetworkConnected() {
        return NetworkConnection.getConnectivityStatus(this) !=
                NetworkConnection.NETWORK_STATUS_NOT_CONNECTED;
    }

    /*
     * This method will show a No Network Connection dialog
     * */
    protected void showNoNetworkError() {
        DialogPresenter.showDialog(this,"",
                getString(R.string.alert_network_not_available), getString(R.string.button_ok), null, null);

    }
}
