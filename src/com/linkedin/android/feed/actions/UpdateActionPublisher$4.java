package com.linkedin.android.feed.actions;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class UpdateActionPublisher$4
  implements DialogInterface.OnClickListener
{
  UpdateActionPublisher$4(UpdateActionPublisher.DeleteUpdateActionListener paramDeleteUpdateActionListener) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (val$deleteUpdateActionListener != null) {
      val$deleteUpdateActionListener.onDeleteUpdateAction();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.actions.UpdateActionPublisher.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */