package com.linkedin.android.feed.followhub;

import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.imageloader.LiImageView;
import com.linkedin.android.infra.app.BaseViewHolder;
import java.util.ArrayList;

public final class FollowHubPackageRecyclerViewAdapter
  extends RecyclerView.Adapter<ViewHolder>
{
  private ArrayList<FollowHubPackageEntityTemporary> entitiesList = new ArrayList();
  
  public FollowHubPackageRecyclerViewAdapter(ArrayList<FollowHubPackageEntityTemporary> paramArrayList)
  {
    entitiesList.addAll(paramArrayList);
  }
  
  public final int getItemCount()
  {
    if (entitiesList == null) {
      return 0;
    }
    return entitiesList.size();
  }
  
  public static class ViewHolder
    extends BaseViewHolder
    implements View.OnClickListener
  {
    @InjectView(2131755890)
    TextView entity;
    @InjectView(2131755892)
    LiImageView followPlus;
    @InjectView(2131755891)
    TextView followText;
    @InjectView(2131755889)
    LiImageView imageView;
    
    public ViewHolder(View paramView)
    {
      super();
    }
    
    public void onClick(View paramView)
    {
      Log.d("onclick", "onClick " + getLayoutPosition() + " " + entity.getText());
    }
    
    public String toString()
    {
      return super.toString() + " '" + entity.getText();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.followhub.FollowHubPackageRecyclerViewAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */