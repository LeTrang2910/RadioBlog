package oliverdev.com.blogradio.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Created by ConGa on 8/11/2016.
 */
@RequiredArgsConstructor(access = AccessLevel.PUBLIC, suppressConstructorProperties = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC, suppressConstructorProperties = true)
@Data
public class NavDrawerTitleCategoryItem {
    private String titleCategory;
}
