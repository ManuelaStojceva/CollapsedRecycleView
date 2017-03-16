package enums;

/**
 * Created by Manuela.Stojceva on 3/16/2017.
 */
public enum  MenuItemType {
    PERSON_NAME,
    PERSON_EMAIL,
    PERSON_VIEW,
    UNDEFINED;
    public static MenuItemType getTypeByName(String name){
        try {
            if (name == null)
                return UNDEFINED;
            return MenuItemType.valueOf(name);
        }catch (Exception ex){
            return UNDEFINED;
        }
    }
}
