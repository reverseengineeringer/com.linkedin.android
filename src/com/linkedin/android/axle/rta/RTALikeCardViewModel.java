package com.linkedin.android.axle.rta;

import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.viewmodel.ViewModel;

public final class RTALikeCardViewModel
  extends ViewModel<RTALikeCardViewHolder>
{
  public View.OnClickListener cancelOnClickListener;
  public String cancelText;
  public View.OnClickListener sendOnClickListener;
  public String sendText;
  public String titleText;
  
  public final ViewHolderCreator<RTALikeCardViewHolder> getCreator()
  {
    return RTALikeCardViewHolder.CREATOR;
  }
  
  public final void onBindViewHolder$2b327430(RTALikeCardViewHolder paramRTALikeCardViewHolder)
  {
    title.setText(titleText);
    dismiss.setText(cancelText);
    dismiss.setOnClickListener(cancelOnClickListener);
    send.setText(sendText);
    send.setOnClickListener(sendOnClickListener);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.rta.RTALikeCardViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */