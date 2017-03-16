package models;

import org.json.JSONException;
import org.json.JSONObject;

import enums.MenuScreenItemType;
import interfaces.MenuScreenItemView;

/**
 * Created by Manuela.Stojceva on 3/16/2017.
 */
public class PersonName implements MenuScreenItemView{

    public static final String PERSON = "person";
    private String name;
    private String surname;

    public PersonName(final String name, final String surname){
        this.name = name;
        this.surname= surname;
    }

    public PersonName(final JSONObject object)throws JSONException{
        this.name = object.getString("name");
        this.surname = object.getString("surname");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public MenuScreenItemType getMenuScreenItemType() {
        return MenuScreenItemType.PERSON_NAME_ITEM;
    }
}
