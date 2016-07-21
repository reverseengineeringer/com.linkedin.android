package android.support.design.internal;

import android.support.design.R.layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

final class NavigationMenuPresenter$NormalViewHolder
  extends NavigationMenuPresenter.ViewHolder
{
  public NavigationMenuPresenter$NormalViewHolder(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    super(paramLayoutInflater.inflate(R.layout.design_navigation_item, paramViewGroup, false));
    itemView.setOnClickListener(paramOnClickListener);
  }
}

/* Location:
 * Qualified Name:     android.support.design.internal.NavigationMenuPresenter.NormalViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */