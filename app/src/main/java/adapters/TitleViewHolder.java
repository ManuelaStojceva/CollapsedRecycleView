package adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.collapsedrecycleview.R;

import controlers.Engine;
import interfaces.CollapseView;

/**
 * Created by Manuela.Stojceva on 3/16/2017.
 */
public class TitleViewHolder extends RecyclerView.ViewHolder{
    private View item;
    private TextView title;
    private ImageView collapse;
    private CollapseView collapseView;

    public TitleViewHolder(View itemView, final CollapseView collapseView) {
        super(itemView);
        this.collapseView = collapseView;
        item = itemView.findViewById(R.id.header);
        title = (TextView)itemView.findViewById(R.id.txt_header);
        collapse = (ImageView)itemView.findViewById(R.id.collapse);
    }
    public void init(final String titleLBL, final int position){
        title.setText(titleLBL);

        collapse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(titleLBL.equals(item.getContext().getString(R.string.PERSON_NAME_TIT))) {
                    collapseView.onCollapsedNameSectionClick(position);
                    if(Engine.getInstance().isCollapsedNameSection())
                        collapse.setImageResource(R.drawable.collapse_down);
                    else
                        collapse.setImageResource(R.drawable.collapse_up);
                }else if(titleLBL.equals(item.getContext().getString(R.string.PERSON_EMAIL_TIT))){
                    collapseView.onCollapsedEmailSectionClick(position);
                    if(Engine.getInstance().isCollapsedEmailSection())
                        collapse.setImageResource(R.drawable.collapse_down);
                    else
                        collapse.setImageResource(R.drawable.collapse_up);
                }else if(titleLBL.equals(item.getContext().getString(R.string.PERSON_VIEW_TIT))){
                    collapseView.onCollapseViewSectionClick(position);
                    if(Engine.getInstance().isCollapsedViewSection())
                        collapse.setImageResource(R.drawable.collapse_down);
                    else
                        collapse.setImageResource(R.drawable.collapse_up);
                }
            }
        });
    }
}
