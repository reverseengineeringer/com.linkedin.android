package com.linkedin.android.axle.rta;

import android.widget.TextView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.viewmodel.ViewModel;

public final class RTADislikeConfirmCardViewModel
  extends ViewModel<RTADislikeConfirmCardViewHolder>
{
  public String titleText;
  
  public final ViewHolderCreator<RTADislikeConfirmCardViewHolder> getCreator()
  {
    return RTADislikeConfirmCardViewHolder.CREATOR;
  }
  
  public final void onBindViewHolder$4d50d994(RTADislikeConfirmCardViewHolder paramRTADislikeConfirmCardViewHolder)
  {
    title.setText(titleText);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.rta.RTADislikeConfirmCardViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */