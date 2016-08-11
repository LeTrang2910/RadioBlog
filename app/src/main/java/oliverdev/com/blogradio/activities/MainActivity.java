package oliverdev.com.blogradio.activities;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import oliverdev.com.blogradio.R;
import oliverdev.com.blogradio.utils.FontsOverride;
import oliverdev.com.blogradio.utils.TypefaceSpan;

/**
 * @author ConGa
 */
@SuppressWarnings("ALL")
@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    @ViewById(R.id.toolBar)
    Toolbar mToolbar;
    @ViewById(R.id.navigationView)
    NavigationView mNavigationView;
    @ViewById(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    //action bar toggle
    ActionBarDrawerToggle mActionBarDrawerToggle;
    @StringRes
    int resString_drawer_open = R.string.drawerlayout_text_open;
    //message when close drawerLayout
    @StringRes
    int resString_drawer_close = R.string.drawerlayout_text_close;

    @Override
    protected void initViews() {
        Bundle savedInstanceState = null;
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setUpNavigationDrawerContent(mNavigationView);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this, mDrawerLayout, resString_drawer_open,
                resString_drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
        if (savedInstanceState == null) {
            selectItemOnNavigationView(mNavigationView.getMenu().findItem(R.id.menu_item_which_radio_you_will_listen_today));
        }
        FontsOverride.setDefaultFont(this,getString(R.string.navigationviewitem_style_font), getString(R.string.navigationviewitem_font) );
    }

    /**
     * @param mNavigationView handle select item on navigation view
     */
    private void setUpNavigationDrawerContent(NavigationView mNavigationView) {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                selectItemOnNavigationView(item);
                return true;
            }
        });
    }

    /**
     * @param menu
     */
    private void selectItemOnNavigationView(MenuItem menu) {
        menu.setChecked(true);
        //setTitle for toolbar
        SpannableString title = new SpannableString(menu.getTitle());
        title.setSpan(new TypefaceSpan(this, getString(R.string.toolbar_font)), 0, title.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        mToolbar.setTitle(title);
        mDrawerLayout.closeDrawers();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);

    }
}
