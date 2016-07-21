package com.linkedin.android.entities.viewmodels.items;

import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import com.linkedin.android.entities.viewholders.ButtonViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class ButtonViewModel
  extends ViewModel<ButtonViewHolder>
{
  public TrackingOnClickListener clickListener;
  public boolean shouldCenterButton;
  public CharSequence text;
  
  private void updateViewHolder(ButtonViewHolder paramButtonViewHolder)
  {
    button.setText(text);
    button.setOnClickListener(clickListener);
    if (shouldCenterButton)
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      gravity = 17;
      button.setLayoutParams(localLayoutParams);
    }
  }
  
  public final ViewHolderCreator<ButtonViewHolder> getCreator()
  {
    return ButtonViewHolder.CREATOR;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewmodels.items.ButtonViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */