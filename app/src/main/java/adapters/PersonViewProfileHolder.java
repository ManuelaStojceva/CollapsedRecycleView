package adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.collapsedrecycleview.R;

import controlers.Engine;
import models.PersonView;

/**
 * Created by Manuela.Stojceva on 3/16/2017.
 */
public class PersonViewProfileHolder extends RecyclerView.ViewHolder{
    private View item;
    private TextView text1;
    private Button viewProfile;
    private Button editProfile;
    private PersonView personView;
    private LinearLayout.LayoutParams params;

    public PersonViewProfileHolder(View itemView) {
        super(itemView);
        params = new
                LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        item = itemView.findViewById(R.id.rlAuthItem);
        text1 = (TextView)itemView.findViewById(R.id.text1);
        viewProfile = (Button)itemView.findViewById(R.id.btnViewProfile);
        editProfile = (Button)itemView.findViewById(R.id.btnEditProfile);
    }
    public void init(final PersonView personView){
        if(Engine.getInstance().isCollapsedViewSection()){
            item.setVisibility(View.GONE);
            params.height=0;
            item.setLayoutParams(params);
            return;
        }else {
            item.setVisibility(View.VISIBLE);
            params.height=LinearLayout.LayoutParams.WRAP_CONTENT;
            item.setLayoutParams(params);
        }
        this.personView = personView;
        text1.setText(personView.getName() + " " + personView.getSurname());
    }
}
