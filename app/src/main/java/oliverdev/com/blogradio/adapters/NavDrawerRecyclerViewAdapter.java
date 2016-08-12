package oliverdev.com.blogradio.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import oliverdev.com.blogradio.R;
import oliverdev.com.blogradio.adapters.viewholders.NavDrawerHeaderViewHolder;
import oliverdev.com.blogradio.adapters.viewholders.NavDrawerTitleCategoryViewHolder;
import oliverdev.com.blogradio.adapters.viewholders.NavDrawerViewHolder;
import oliverdev.com.blogradio.models.NavDrawerItem;
import oliverdev.com.blogradio.models.NavDrawerTitleCategoryItem;

public class NavDrawerRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<Object> mItems;
    protected final Context mContext;
    private static final int NAV_IMAGE_HEADER = 0;
    private static final int NAV_ITEM_INFORMATION = 1;
    private static final int NAV_CATEGORY_TITLE = 2;

    public NavDrawerRecyclerViewAdapter(List<Object> mItems, Context mContext) {
        this.mItems = mItems;
        this.mContext = mContext;
    }

    @Override
    public int getItemViewType(int position) {
        if (mItems.get(position) instanceof NavDrawerItem) {
            return NAV_ITEM_INFORMATION;
        } else if (mItems.get(position) instanceof String) {
            return NAV_IMAGE_HEADER;
        } else if (mItems.get(position) instanceof NavDrawerTitleCategoryItem) {
            return NAV_CATEGORY_TITLE;
        }
        return -1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {

            case NAV_IMAGE_HEADER:
                View navHeaderItem = inflater.inflate(R.layout.item_recyclerview_header_navigation, parent, false);
                viewHolder = new NavDrawerHeaderViewHolder(navHeaderItem);
                break;
            case NAV_ITEM_INFORMATION:
                View navItemInfomation = inflater.inflate(R.layout.item_recyclerview_navigation, parent, false);
                viewHolder = new NavDrawerViewHolder(navItemInfomation);
                break;
            case NAV_CATEGORY_TITLE:
                View navCategoryItem = inflater.inflate(R.layout.item_recyclerview_category_title_navigation, parent, false);
                viewHolder = new NavDrawerTitleCategoryViewHolder(navCategoryItem);
                break;

        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case NAV_ITEM_INFORMATION:
                NavDrawerViewHolder navDrawerViewHolder = (NavDrawerViewHolder) holder;
                configViewHolderNavDrawer(navDrawerViewHolder, position);
                break;
            case NAV_CATEGORY_TITLE:
                NavDrawerTitleCategoryViewHolder navDrawerTitleCategoryViewHolder = (NavDrawerTitleCategoryViewHolder) holder;
                configViewHolderNavDrawerTitleCategory(navDrawerTitleCategoryViewHolder, position);
                break;
        }
    }

    private void configViewHolderNavDrawerTitleCategory(NavDrawerTitleCategoryViewHolder navDrawerTitleCategoryViewHolder, int position) {
        NavDrawerTitleCategoryItem navDrawerTitleCategoryItem = (NavDrawerTitleCategoryItem) mItems.get(position);
        if (navDrawerTitleCategoryItem != null) {
            navDrawerTitleCategoryViewHolder.bind(navDrawerTitleCategoryItem);
        }
    }

    private void configViewHolderNavDrawer(NavDrawerViewHolder navDrawerViewHolder, int position) {
        NavDrawerItem navDrawerItem = (NavDrawerItem) mItems.get(position);
        if (navDrawerItem != null) {
            navDrawerViewHolder.bind(navDrawerItem);
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }


}
