package com.linkedin.android.shaky;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SelectFragment
  extends Fragment
{
  private FeedbackItem[] getData()
  {
    return new FeedbackItem[] { new FeedbackItem(getString(R.string.row1_title), getString(R.string.row1_subtitle), R.drawable.shaky_bug, 0), new FeedbackItem(getString(R.string.row2_title), getString(R.string.row2_subtitle), R.drawable.shaky_feature, 1), new FeedbackItem(getString(R.string.row3_title), getString(R.string.row3_subtitle), R.drawable.shaky_feedback, 2) };
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.shaky_select, paramViewGroup, false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramBundle = new FeedbackTypeAdapter(getActivity(), getData());
    RecyclerView localRecyclerView = (RecyclerView)paramView.findViewById(R.id.recyclerView);
    localRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    localRecyclerView.setAdapter(paramBundle);
    paramView = (Toolbar)paramView.findViewById(R.id.toolbar);
    paramView.setTitle(R.string.feedback_title);
    paramView.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
    paramView.setNavigationOnClickListener(new SelectFragment.1(this));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.shaky.SelectFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */