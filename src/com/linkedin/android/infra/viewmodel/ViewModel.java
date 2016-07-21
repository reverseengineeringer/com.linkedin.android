package com.linkedin.android.infra.viewmodel;

import android.view.LayoutInflater;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.litrackinglib.viewport.ImpressionData;
import com.linkedin.android.litrackinglib.viewport.Mapper;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;

public abstract class ViewModel<VIEW_HOLDER extends BaseViewHolder>
{
  public ViewModelListener<ViewModel> viewModelListener;
  
  public abstract ViewHolderCreator<VIEW_HOLDER> getCreator();
  
  public boolean handlesViewModelChanges()
  {
    return false;
  }
  
  public boolean isChangeableTo(ViewModel paramViewModel)
  {
    return (getClass().equals(paramViewModel.getClass())) && (getCreator().getLayoutId() == paramViewModel.getCreator().getLayoutId());
  }
  
  public Mapper onBindTrackableViews(Mapper paramMapper, VIEW_HOLDER paramVIEW_HOLDER, int paramInt)
  {
    return paramMapper;
  }
  
  public abstract void onBindViewHolder(LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, VIEW_HOLDER paramVIEW_HOLDER);
  
  public void onRecycleViewHolder(VIEW_HOLDER paramVIEW_HOLDER) {}
  
  public TrackingEventBuilder onTrackImpression(ImpressionData paramImpressionData)
  {
    return null;
  }
  
  public void onViewModelChange(ViewModel<VIEW_HOLDER> paramViewModel, VIEW_HOLDER paramVIEW_HOLDER, LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter) {}
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.viewmodel.ViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */