package models;

import android.content.Context;

import com.example.collapsedrecycleview.R;

import enums.MenuItemType;

/**
 * Created by Manuela.Stojceva on 3/15/2017.
 */
public class MainMenu {
    private String type;
    private String title;
    private int sort;
    private boolean selected;

    public MainMenu(String type, String title, int sort) {
        this.type = type;
        this.title = title;
        this.sort = sort;
        this.selected = false;
    }

    public MenuItemType getMenuItemType() {
        return MenuItemType.getTypeByName(type);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle(Context context) {
        MenuItemType itemType = getMenuItemType();
        switch (itemType) {
            case PERSON_NAME:
                return context.getString(R.string.PERSON_NAME_TIT);
            case PERSON_EMAIL:
                return context.getString(R.string.PERSON_EMAIL_TIT);
            case PERSON_VIEW:
                return context.getString(R.string.PERSON_VIEW_TIT);
            default:
                return title;
        }
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isSelected() {
        return selected;
    }
}
