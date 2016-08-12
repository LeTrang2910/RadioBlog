package oliverdev.com.blogradio.adapters.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import oliverdev.com.blogradio.R;
import oliverdev.com.blogradio.models.NavDrawerTitleCategoryItem;

public class NavDrawerTitleCategoryViewHolder extends RecyclerView.ViewHolder {
    TextView mTvTitleCategory;

    public NavDrawerTitleCategoryViewHolder(View itemView) {
        super(itemView);
        mTvTitleCategory = (TextView) itemView.findViewById(R.id.TvTitleCategory);
    }

    public void bind(NavDrawerTitleCategoryItem navDrawerTitleCategoryItem) {
        mTvTitleCategory.setText(navDrawerTitleCategoryItem.getTitleCategory());
    }

}
