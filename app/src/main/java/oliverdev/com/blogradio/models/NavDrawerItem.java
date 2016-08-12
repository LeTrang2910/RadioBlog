package oliverdev.com.blogradio.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor(access = AccessLevel.PUBLIC, suppressConstructorProperties = true)
@Data
public class NavDrawerItem {
    private String title;
    private int count = 0;
    private int icon;
    private boolean isCounterVisible = false;

    public NavDrawerItem(String title, int icon) {
        this.title = title;
        this.icon = icon;
    }

    public boolean getIsCounterVisible() {
        return this.isCounterVisible;
    }
}
