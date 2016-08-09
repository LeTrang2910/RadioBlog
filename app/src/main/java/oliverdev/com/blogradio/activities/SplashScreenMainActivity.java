package oliverdev.com.blogradio.activities;

import android.graphics.Typeface;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import oliverdev.com.blogradio.R;
import oliverdev.com.blogradio.abstracts.BaseActivity;

@EActivity(R.layout.splash_screen_activity)
public class SplashScreenMainActivity extends BaseActivity {
    private static final long DELAY_TIME = 10000L;

    @ViewById(R.id.progressBarSplashScreen)
    ProgressBar mProgressBar;

    @ViewById(R.id.tvBlogRadioTitle)
    TextView mTextViewBlogRadio;

    @ViewById(R.id.tvShowYourFeelsTitle)
    TextView mTextViewShowYourFeelsTitle;

    @ViewById(R.id.tvConfessionTitle)
    TextView mTextViewConfessTitle;

    Typeface mTypeface;

    @Override
    protected void initViews() {
        doInBackground();

        mTextViewBlogRadio.setTypeface(getFont(getString(R.string.textViewBolgRadio_font)));
        mTextViewShowYourFeelsTitle.setTypeface(getFont(getString(R.string.textViewShowYourFeels_font)));
        mTextViewConfessTitle.setTypeface(getFont(getString(R.string.textViewConfession_font)));
    }

    /**
     * @param path path font from assets folder
     * @return typeFont
     */
    private Typeface getFont(String path) {
        mTypeface = Typeface.createFromAsset(getAssets(), path);
        return mTypeface;
    }

    @UiThread(delay = DELAY_TIME)
    void doInBackground() {
        MainActivity_.intent(this).start();
        finish();
    }


}
