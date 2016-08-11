package oliverdev.com.blogradio.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;

import java.lang.reflect.Field;

public final class FontsOverride {
    public static String TAG = FontsOverride.class.getSimpleName();

    /**
     * @param context                 :
     * @param staticTypefaceFieldName :style of font return String
     * @param fontAssetName           : font of assets folder return String
     *                                function: get font from assets folder and call replace function current font of item text appearance on navigationview
     */
    public static void setDefaultFont(Context context,
                                      String staticTypefaceFieldName, String fontAssetName) {
        final Typeface regular = Typeface.createFromAsset(context.getAssets(),
                fontAssetName);
        replaceFont(staticTypefaceFieldName, regular);

    }

    /**
     * @param staticTypefaceFieldName :style of font return String
     * @param newTypeface             : new typeface of font get from assets folder return Typeface
     */
    protected static void replaceFont(String staticTypefaceFieldName,
                                      final Typeface newTypeface) {
        try {
            final Field staticField = Typeface.class
                    .getDeclaredField(staticTypefaceFieldName);
            staticField.setAccessible(true);
            staticField.set(null, newTypeface);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            Log.d(TAG, "NO SUCH FILE ");

        } catch (IllegalAccessException e) {
            e.printStackTrace();
            Log.d(TAG, "access is be denied");

        }
    }
}
