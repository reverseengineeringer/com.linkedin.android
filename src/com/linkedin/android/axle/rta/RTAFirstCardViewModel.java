package com.linkedin.android.axle.rta;

import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.viewmodel.ViewModel;

public final class RTAFirstCardViewModel
  extends ViewModel<RTAFirstCardViewHolder>
{
  public View.OnClickListener cancelOnClickListener;
  public View.OnClickListener dislikeOnClickListener;
  public String leftButtonText;
  public View.OnClickListener likeOnClickListener;
  public String rightButtonText;
  public String titleText;
  
  public final ViewHolderCreator<RTAFirstCardViewHolder> getCreator()
  {
    return RTAFirstCardViewHolder.CREATOR;
  }
  
  public final void onBindViewHolder$30b73eb7(RTAFirstCardViewHolder paramRTAFirstCardViewHolder)
  {
    title.setText(titleText);
    cancelButton.setOnClickListener(cancelOnClickListener);
    cancel.setOnClickListener(cancelOnClickListener);
    leftButton.setText(leftButtonText);
    leftButton.setOnClickListener(dislikeOnClickListener);
    rightButton.setText(rightButtonText);
    rightButton.setOnClickListener(likeOnClickListener);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.rta.RTAFirstCardViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */