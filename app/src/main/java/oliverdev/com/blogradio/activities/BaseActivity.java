package oliverdev.com.blogradio.activities;

import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

/**
 * @author ConGa
 */
@EActivity
public abstract class BaseActivity extends AppCompatActivity {

    @AfterViews
    protected abstract void initViews();
}
