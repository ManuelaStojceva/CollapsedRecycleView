package controlers;

import android.app.Activity;
import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Manuela.Stojceva on 3/16/2017.
 */
public class Engine {
    private static Engine me = null;

    public boolean isCollapsedNameSection() {
        return isCollapsedNameSection;
    }

    public void setIsCollapsedNameSection(boolean isCollapsedNameSection) {
        this.isCollapsedNameSection = isCollapsedNameSection;
    }

    public boolean isCollapsedEmailSection() {
        return isCollapsedEmailSection;
    }

    public void setIsCollapsedEmailSection(boolean isCollapsedEmailSection) {
        this.isCollapsedEmailSection = isCollapsedEmailSection;
    }

    public boolean isCollapsedViewSection() {
        return isCollapsedViewSection;
    }

    public void setIsCollapsedViewSection(boolean isCollapsedViewSection) {
        this.isCollapsedViewSection = isCollapsedViewSection;
    }

    private boolean isCollapsedNameSection;
    private boolean isCollapsedEmailSection;
    private boolean isCollapsedViewSection;

    public static synchronized Engine getInstance() {
        if (me == null) {
            me = new Engine();
        }
        return me;
    }
    public String readRaw(final Context ctx, final int res_id) {

        final InputStream is = ctx.getResources().openRawResource(res_id);
        final BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String locs = "";
        String line = "";
        while (line != null) {
            try {
                line = reader.readLine();
                if (line != null) {
                    locs += line;
                }
            } catch (final IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        try {
            is.close();
            reader.close();
        } catch (final IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return locs;

    }
}
