package com.linkedin.android.infra.spinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.viewmodel.ViewModel;
import java.util.List;

public final class ViewModelSpinnerAdapter<V extends ViewModel<VH>, VH extends BaseViewHolder>
  extends ArrayAdapter<V>
{
  private final LayoutInflater layoutInflater;
  private final MediaCenter mediaCenter;
  
  public ViewModelSpinnerAdapter(Context paramContext, MediaCenter paramMediaCenter, int paramInt, List<V> paramList)
  {
    super(paramContext, paramInt, paramList);
    layoutInflater = LayoutInflater.from(paramContext);
    mediaCenter = paramMediaCenter;
  }
  
  public final View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ViewModel localViewModel = (ViewModel)getItem(paramInt);
    ViewHolderCreator localViewHolderCreator = localViewModel.getCreator();
    if (paramView == null)
    {
      paramView = layoutInflater.inflate(localViewHolderCreator.getLayoutId(), paramViewGroup, false);
      paramViewGroup = localViewHolderCreator.createViewHolder(paramView);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      localViewModel.onBindViewHolder(layoutInflater, mediaCenter, paramViewGroup);
      return paramView;
      paramViewGroup = (BaseViewHolder)paramView.getTag();
    }
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return getDropDownView(paramInt, paramView, paramViewGroup);
  }
  
  @Deprecated
  public final void setDropDownViewResource(int paramInt)
  {
    throw new RuntimeException("setDropDownViewResource should not be used with with adapter.");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.spinner.ViewModelSpinnerAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */