package oliverdev.com.blogradio.activities;

import android.graphics.Typeface;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import oliverdev.com.blogradio.R;


@EActivity(R.layout.splash_screen_activity)
public class SplashScreenActivity extends BaseActivity {
    private static final long DELAY_TIME = 10000L;
    @ViewById(R.id.progressBarSplashScreen)
    ProgressBar mProgressBar;
    @ViewById(R.id.tvBlogRadioTitle)
    TextView mTextViewBlogRadio;
    @ViewById(R.id.tvShowYourFeelsTitle)
    TextView mTextViewShowYourFeelsTitle;
    @ViewById(R.id.tvConfessionTitle)
    TextView mTextViewConfessTitle;

    @Override
    protected void initViews() {
        doInBackground();

        mTextViewBlogRadio.setTypeface(getFont(getString(R.string.textview_blog_radio_font)));
        mTextViewShowYourFeelsTitle.setTypeface(getFont(getString(R.string.textview_show_your_feels_font)));
        mTextViewConfessTitle.setTypeface(getFont(getString(R.string.textview_confession_font)));
    }

    /**
     * @param path path font from assets folder
     * @return typeFont
     */
    private Typeface getFont(String path) {
        return Typeface.createFromAsset(getAssets(), path);
    }

    @UiThread(delay = DELAY_TIME)
    void doInBackground() {
        MainActivity_.intent(this).start();
        finish();
    }

}
