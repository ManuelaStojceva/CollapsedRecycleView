package com.example.collapsedrecycleview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import adapters.MenuScreenAdapter;
import controlers.Engine;
import enums.MenuItemType;
import enums.MenuScreenItemType;
import interfaces.CollapseView;
import interfaces.MenuScreenItemView;
import models.MainMenu;
import models.MenuScreenItem;
import models.PersonEmail;
import models.PersonName;
import models.PersonView;

public class MainActivity extends AppCompatActivity implements CollapseView{

    private RecyclerView recyclerView;
    private List<MenuScreenItemView> listViews;
    private List<PersonName> personNames;
    private List<PersonEmail> personEmails;
    private List<PersonView> personViews;
    private MenuScreenAdapter menuScreenAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        initMenuData();
        setAdapter();
    }

    private void initMenuData() {
        listViews = new ArrayList<>();
        ArrayList<MainMenu> listMenu = getMenuOrdering(getApplicationContext());
        for(MainMenu menuItem: listMenu) {
            switch (menuItem.getMenuItemType()) {
                case PERSON_NAME:
                    listViews.add(new MenuScreenItem(getString(R.string.PERSON_NAME_TIT), MenuScreenItemType.PERSON_NAME_TITLE));
                    listViews.addAll(setPersonName());
                    break;
                case PERSON_EMAIL:
                    listViews.add(new MenuScreenItem(getString(R.string.PERSON_EMAIL_TIT), MenuScreenItemType.PERSON_EMAIL_TITLE));
                    listViews.addAll(setPersonEmail());
                    break;
                case PERSON_VIEW:
                    listViews.add(new MenuScreenItem(getString(R.string.PERSON_VIEW_TIT), MenuScreenItemType.PERSON_VIEW_TITLE));
                    listViews.addAll(setPersonDetailView());
                    break;
                default:
            }
        }
    }
    private void setAdapter() {
        if(menuScreenAdapter == null){
            menuScreenAdapter = new MenuScreenAdapter(listViews, MainActivity.this, MainActivity.this);
            recyclerView.setAdapter(menuScreenAdapter);
        }else {
            menuScreenAdapter.setmData(listViews);
        }
        menuScreenAdapter.notifyDataSetChanged();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private ArrayList<MainMenu> getMenuOrdering(Context context){
        String itemOrder= null;
        ArrayList<MainMenu> list = new ArrayList<MainMenu>();
        if(itemOrder == null){
            list.add(new MainMenu(MenuItemType.PERSON_NAME.name(), context.getString(R.string.PERSON_NAME_TIT), 1));
            list.add(new MainMenu(MenuItemType.PERSON_EMAIL.name(), context.getString(R.string.PERSON_EMAIL_TIT), 2));
            list.add(new MainMenu(MenuItemType.PERSON_VIEW.name(), context.getString(R.string.PERSON_VIEW_TIT),3));
        }
        return list;
    }
    private List<PersonName> setPersonName(){
        String personName = Engine.getInstance().readRaw(getApplicationContext(), R.raw.person_name);
        personNames= new ArrayList<PersonName>();
        try {
            final JSONObject object = new JSONObject(personName);
            final JSONArray array = object.getJSONArray(PersonName.PERSON);
            for (int i=0; i<array.length(); i++){
                PersonName personName1 = new PersonName(array.getJSONObject(i));
                personNames.add(personName1);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return personNames;
    }
    private List<PersonEmail> setPersonEmail(){
        String personEmail = Engine.getInstance().readRaw(getApplicationContext(), R.raw.person_email);
        personEmails = new ArrayList<PersonEmail>();
        try {
            final JSONObject object = new JSONObject(personEmail);
            final JSONArray array = object.getJSONArray(PersonEmail.PERSON_EMAIL);
            for (int i=0; i<array.length(); i++){
                PersonEmail personEmail1 = new PersonEmail(array.getJSONObject(i));
                personEmails.add(personEmail1);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return personEmails;
    }
    private List<PersonView> setPersonDetailView(){
        String personDetail = Engine.getInstance().readRaw(getApplicationContext(), R.raw.person_view);
        personViews = new ArrayList<PersonView>();
        try {
            final JSONObject object = new JSONObject(personDetail);
            final JSONArray array = object.getJSONArray(PersonView.PERSON_VIEW);
            for (int i=0; i<array.length(); i++){
                PersonView personView = new PersonView(array.getJSONObject(i));
                personViews.add(personView);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return personViews;
    }

    @Override
    public void onCollapsedNameSectionClick(int position) {
        Engine.getInstance().setIsCollapsedNameSection(!Engine.getInstance().isCollapsedNameSection());
        menuScreenAdapter.notifyItemRangeChanged(position + 1, setPersonName().size());
    }

    @Override
    public void onCollapsedEmailSectionClick(int position) {
        Engine.getInstance().setIsCollapsedEmailSection(!Engine.getInstance().isCollapsedEmailSection());
        menuScreenAdapter.notifyItemRangeChanged(position+1, setPersonEmail().size());
    }

    @Override
    public void onCollapseViewSectionClick(int position) {
        Engine.getInstance().setIsCollapsedViewSection(!Engine.getInstance().isCollapsedViewSection());
        menuScreenAdapter.notifyItemRangeChanged(position+1, setPersonDetailView().size());
    }
}
