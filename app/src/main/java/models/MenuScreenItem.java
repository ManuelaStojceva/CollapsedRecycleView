package models;

import enums.MenuScreenItemType;
import interfaces.MenuScreenItemView;

/**
 * Created by Manuela.Stojceva on 3/16/2017.
 */
public class MenuScreenItem implements MenuScreenItemView {

    private String title;
    private MenuScreenItemType itemType;

    public MenuScreenItem(String title, MenuScreenItemType itemType) {
        this.title = title;
        this.itemType = itemType;
    }

    @Override
    public MenuScreenItemType getMenuScreenItemType() {
        return itemType;
    }
    public String getTitle() {
        return title;
    }
}
