package com.linkedin.android.feed.followhub;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.InjectView;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import java.util.ArrayList;

public class FollowHubPackageFragment
  extends PageFragment
{
  @InjectView(2131755781)
  RecyclerView recyclerView;
  
  public final boolean isAnchorPage()
  {
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968750, paramViewGroup, false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    int j = -1;
    super.onViewCreated(paramView, paramBundle);
    paramView = recyclerView;
    paramBundle = new ArrayList();
    int i = 0;
    while (i < 40)
    {
      paramBundle.add(new FollowHubPackageEntityTemporary("Item " + i));
      i += 1;
    }
    paramView.setLayoutManager(new LinearLayoutManager(fragmentComponent.context()));
    paramView.setAdapter(new FollowHubPackageRecyclerViewAdapter(paramBundle));
    paramView = getArguments();
    i = j;
    if (paramView != null) {
      i = paramView.getInt("package_ID", -1);
    }
    if (i % 2 == 0) {}
    for (i = 2131624011;; i = 2131624020)
    {
      recyclerView.setBackgroundColor(ContextCompat.getColor(getContext(), i));
      return;
    }
  }
  
  public final String pageKey()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.followhub.FollowHubPackageFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */