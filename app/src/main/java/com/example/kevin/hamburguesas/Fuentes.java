package com.example.kevin.hamburguesas;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by kevin on 16/11/2017.
 */

public class Fuentes {
    public static Typeface miFuente1(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "fonts/POPWEI__.TTF");
    }
    public static Typeface miFuente2(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "fonts/youarewhatyoueat.ttf");
    }
}
