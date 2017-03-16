package adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.collapsedrecycleview.R;

import java.util.List;

import enums.MenuScreenItemType;
import interfaces.CollapseView;
import interfaces.MenuScreenItemView;
import models.PersonEmail;
import models.PersonName;
import models.PersonView;

/**
 * Created by Manuela.Stojceva on 3/16/2017.
 */
public class MenuScreenAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;

    public void setmData(List<MenuScreenItemView> mData) {
        this.mData = mData;
    }

    private List<MenuScreenItemView> mData;
    private final LayoutInflater inflater;
    private CollapseView collapseView;

    public MenuScreenAdapter(List<MenuScreenItemView> mData,Context context, final CollapseView collapseView){
        this.mData = mData;
        this.context = context;
        this.collapseView = collapseView;
        inflater = ((Activity)context).getLayoutInflater();
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = inflater.inflate(R.layout.menu_screen_blank_view, viewGroup, false);
        switch (MenuScreenItemType.getByTypeValue(viewType)){
            case PERSON_NAME_TITLE:
            case PERSON_EMAIL_TITLE:
            case PERSON_VIEW_TITLE:
                view = inflater.inflate(R.layout.menu_screen_title_view, viewGroup, false);
                TitleViewHolder titleViewHolder = new TitleViewHolder(view, collapseView);
                return titleViewHolder;
            case PERSON_NAME_ITEM:
                view = inflater.inflate(R.layout.menu_screen_person_name, viewGroup, false);
                PersonNameViewHolder personNameViewHolder = new PersonNameViewHolder(view);
                return personNameViewHolder;
            case PERSON_EMAIL_ITEM:
                view = inflater.inflate(R.layout.menu_screen_person_email, viewGroup, false);
                PersonEmailViewHolder personEmailViewHolder = new PersonEmailViewHolder(view);
                return personEmailViewHolder;
            case PERSON_VIEW_ITEM:
                view = inflater.inflate(R.layout.menu_screen_person_view, viewGroup, false);
                PersonViewProfileHolder personViewProfileHolder = new PersonViewProfileHolder(view);
                return personViewProfileHolder;

        }
        return new BlankViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (mData.get(position).getMenuScreenItemType()){
            case PERSON_NAME_TITLE:
                ((TitleViewHolder) holder).init(context.getString(R.string.PERSON_NAME_TIT), position);
                break;
            case PERSON_NAME_ITEM:
                ((PersonNameViewHolder)holder).init((PersonName)mData.get(position));
                break;
            case PERSON_EMAIL_TITLE:
                ((TitleViewHolder) holder).init(context.getString(R.string.PERSON_EMAIL_TIT), position);
                break;
            case PERSON_EMAIL_ITEM:
                ((PersonEmailViewHolder)holder).init((PersonEmail)mData.get(position));
                break;
            case PERSON_VIEW_TITLE:
                ((TitleViewHolder) holder).init(context.getString(R.string.PERSON_VIEW_TIT), position);
                break;
            case PERSON_VIEW_ITEM:
                ((PersonViewProfileHolder)holder).init((PersonView)mData.get(position));
                break;
        }

    }
    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getMenuScreenItemType().getType();
    }
    @Override
    public int getItemCount() {
        return mData.size();
    }
}
