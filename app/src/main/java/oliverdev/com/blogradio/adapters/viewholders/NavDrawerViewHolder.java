package oliverdev.com.blogradio.adapters.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import oliverdev.com.blogradio.R;
import oliverdev.com.blogradio.models.NavDrawerItem;

public class NavDrawerViewHolder extends RecyclerView.ViewHolder {

    private final ImageView mImgIcon;
    private final TextView mTvTitle;
    private final TextView mTvTitleCounter;

    public NavDrawerViewHolder(View itemView) {
        super(itemView);
        mTvTitle = (TextView) itemView.findViewById(R.id.TvTitle);
        mTvTitleCounter = (TextView) itemView.findViewById(R.id.tvCounter);
        mImgIcon = (ImageView) itemView.findViewById(R.id.imgIcon);

    }

    public void bind(NavDrawerItem item) {
        mTvTitle.setText(item.getTitle());
        mImgIcon.setImageResource(item.getIcon());
        if (item.getIsCounterVisible()) {
            mTvTitleCounter.setText(String.valueOf(item.getCount()));
        } else {
            mTvTitleCounter.setVisibility(View.GONE);
        }
    }

}
