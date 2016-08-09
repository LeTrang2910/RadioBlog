package oliverdev.com.blogradio;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.splash_screen_activity)
public class SplashScreenMainActivity extends AppCompatActivity {
    private static final long DELAY_TIME = 10000L;

    @ViewById(R.id.progressbar_slash_screen)
    ProgressBar mProgressBar;

    @ViewById(R.id.textView_title_blog_radio)
    TextView mTextViewBlogRadio;

    @ViewById(R.id.textView_title_phat_thanh_xuc_cam_cua_ban)
    TextView mTextViewPhatThanhXucCamCuaBan;

    @ViewById(R.id.textView_tam_su)
    TextView mTextViewTamSu;

    Typeface mTypeface;

    @AfterViews
    void initViews() {
        doInBackground();

        mTextViewBlogRadio.setTypeface(getFont("VietAPK.vn-RixLoveFool.ttf"));
        mTextViewPhatThanhXucCamCuaBan.setTypeface(getFont("VNF-FuturaRegular.ttf"));
        mTextViewTamSu.setTypeface(getFont("VietAPK.vn-Alba.ttf"));
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
