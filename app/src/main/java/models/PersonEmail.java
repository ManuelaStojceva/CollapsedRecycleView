package models;

import org.json.JSONException;
import org.json.JSONObject;

import enums.MenuScreenItemType;
import interfaces.MenuScreenItemView;

/**
 * Created by Manuela.Stojceva on 3/16/2017.
 */
public class PersonEmail implements MenuScreenItemView {

    public static final String PERSON_EMAIL = "emails";
    private String fullName;
    private String email;

    public PersonEmail(final JSONObject object)throws JSONException {
        this.fullName = object.getString("fullName");
        this.email = object.getString("email");
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public MenuScreenItemType getMenuScreenItemType() {
        return MenuScreenItemType.PERSON_EMAIL_ITEM;
    }
}
