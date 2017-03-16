package models;

import org.json.JSONException;
import org.json.JSONObject;

import enums.MenuScreenItemType;
import interfaces.MenuScreenItemView;

/**
 * Created by Manuela.Stojceva on 3/16/2017.
 */
public class PersonView implements MenuScreenItemView {
    public static final String PERSON_VIEW = "personDetail";
    private String name;
    private String surname;
    private String email;
    private String gender;

    public PersonView(final JSONObject object)throws JSONException {
        this.name = object.getString("name");
        this.email = object.getString("email");
        this.surname = object.getString("surname");
        this.gender = object.getString("gender");
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public MenuScreenItemType getMenuScreenItemType() {
        return MenuScreenItemType.PERSON_VIEW_ITEM;
    }
}
