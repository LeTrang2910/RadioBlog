package oliverdev.com.blogradio.abstracts;

import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

@EActivity
public abstract class BaseActivity extends AppCompatActivity {

    @AfterViews
    protected abstract void initViews();
}
