package oliverdev.com.blogradio.activities;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

import oliverdev.com.blogradio.R;
import oliverdev.com.blogradio.adapters.NavDrawerRecyclerViewAdapter;
import oliverdev.com.blogradio.models.NavDrawerItem;
import oliverdev.com.blogradio.models.NavDrawerTitleCategoryItem;

/**
 * @author ConGa
 */
@SuppressWarnings("ALL")
@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    @ViewById(R.id.toolBar)
    Toolbar mToolbar;
    @ViewById(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @ViewById(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    //action bar toggle
    ActionBarDrawerToggle mActionBarDrawerToggle;
    @StringRes
    int resString_drawer_open = R.string.drawerlayout_text_open;
    //message when close drawerLayout
    @StringRes
    int resString_drawer_close = R.string.drawerlayout_text_close;
    NavDrawerRecyclerViewAdapter mNavDrawerRecyclerViewAdapter;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private String[] mNavMenuCategoryItems;
    private TypedArray mNavMenuCategoryIcons;
    private String[] mNavMenuMyFolfersItems;
    private TypedArray mNavMenuMyFoldesIcons;
    private String[] mNavMenuAddOnItems;
    private TypedArray mNavMenuAddOnIcons;
    private String[] mNavMenuCategoryTitles;
    private List<Object> mAObjects;

    private static final int CATEGORY_ITEM = 0;
    private static final int MYFOLDERS_ITEM = 1;
    private static final int ADD_ON = 2;

    @Override
    protected void initViews() {
        Bundle savedInstanceState = null;
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mNavDrawerRecyclerViewAdapter = new NavDrawerRecyclerViewAdapter(getListItems(), this);
        mRecyclerView.setAdapter(mNavDrawerRecyclerViewAdapter);
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
    }

    /**
     *
     * @return list items object on navigation view
     */
    private List<Object> getListItems() {
        mAObjects = new ArrayList<>();
        // load slide menu items
        mNavMenuCategoryTitles = getResources().getStringArray(R.array.nav_drawer_category_title);
        mNavMenuAddOnItems = getResources().getStringArray(R.array.nav_drawer_add_on_items);
        mNavMenuCategoryItems = getResources().getStringArray(R.array.nav_drawer_category_items);
        mNavMenuMyFolfersItems = getResources().getStringArray(R.array.nav_drawer_my_folder_items);
        // nav drawer icons from resources
        mNavMenuAddOnIcons = getResources()
                .obtainTypedArray(R.array.nav_drawer_add_on_icons);
        mNavMenuCategoryIcons = getResources()
                .obtainTypedArray(R.array.nav_drawer_category_icons);
        mNavMenuMyFoldesIcons = getResources()
                .obtainTypedArray(R.array.nav_drawer_my_folder_icons);
        mAObjects.add(getString(R.string.navmenu_image));
        for (int i = 0; i < mNavMenuCategoryTitles.length; i++) {
            mAObjects.add(new NavDrawerTitleCategoryItem(mNavMenuCategoryTitles[i]));
            switch (i) {
                case CATEGORY_ITEM:
                    setItemForType(mNavMenuCategoryItems, mNavMenuCategoryIcons);
                    mNavMenuCategoryIcons.recycle();
                    break;
                case MYFOLDERS_ITEM:
                    setItemForType(mNavMenuMyFolfersItems, mNavMenuMyFoldesIcons);
                    mNavMenuMyFoldesIcons.recycle();
                    break;
                case ADD_ON:
                    setItemForType(mNavMenuAddOnItems, mNavMenuAddOnIcons);
                    mNavMenuAddOnIcons.recycle();
                    break;
            }
        }
        return mAObjects;
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

    /**
     *
     * @param strings set of titles
     * @param arrays set of id-icons
     */
    private void setItemForType(String[] strings, TypedArray arrays) {
        for (int i = 0; i < strings.length; i++) {
            mAObjects.add(new NavDrawerItem(strings[i], arrays.getResourceId(i, -1)));
        }
    }

}
