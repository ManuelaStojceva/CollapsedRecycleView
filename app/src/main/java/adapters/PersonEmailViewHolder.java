package adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.collapsedrecycleview.R;

import controlers.Engine;
import models.PersonEmail;

/**
 * Created by Manuela.Stojceva on 3/16/2017.
 */
public class PersonEmailViewHolder extends RecyclerView.ViewHolder {

    private View item;
    private TextView text1;
    private TextView text2;
    private PersonEmail personEmail;
    private LinearLayout.LayoutParams params;

    public PersonEmailViewHolder(View itemView) {
        super(itemView);
        params = new
                LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        item = itemView.findViewById(R.id.rlItem);
        text1 = (TextView)itemView.findViewById(R.id.text1);
        text2 = (TextView)itemView.findViewById(R.id.text2);
    }
    public void init(final PersonEmail personEmail){
        if(Engine.getInstance().isCollapsedEmailSection()){
            item.setVisibility(View.GONE);
            params.height=0;
            item.setLayoutParams(params);
            return;
        }else{
            item.setVisibility(View.VISIBLE);
            params.height=(int) itemView.getContext().getResources().getDimension(R.dimen.global_list_item_height);
            item.setLayoutParams(params);
        }
        this.personEmail=personEmail;
        text1.setText(personEmail.getFullName());
        text2.setText(personEmail.getEmail());
    }
}
