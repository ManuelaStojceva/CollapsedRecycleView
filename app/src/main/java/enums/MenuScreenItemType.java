package enums;

/**
 * Created by Manuela.Stojceva on 3/15/2017.
 */
public enum  MenuScreenItemType {
    PERSON_NAME_TITLE(1),
    PERSON_NAME_ITEM(2),
    PERSON_EMAIL_TITLE(3),
    PERSON_EMAIL_ITEM(4),
    PERSON_VIEW_TITLE(5),
    PERSON_VIEW_ITEM(6),
    UNKNOWN(0);

    int type;
    MenuScreenItemType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public static MenuScreenItemType getByTypeValue(int typeValue){
        switch (typeValue){
            case 1:
                return PERSON_NAME_TITLE;
            case 2:
                return PERSON_NAME_ITEM;
            case 3:
                return PERSON_EMAIL_TITLE;
            case 4:
                return PERSON_EMAIL_ITEM;
            case 5:
                return PERSON_VIEW_TITLE;
            case 6:
                return PERSON_VIEW_ITEM;
            default:
                return UNKNOWN;
        }
    }
}
