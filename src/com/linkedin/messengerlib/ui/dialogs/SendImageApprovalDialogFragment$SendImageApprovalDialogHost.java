package com.linkedin.messengerlib.ui.dialogs;

import com.linkedin.android.imageloader.interfaces.ManagedBitmap;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.messengerlib.MessengerLibApi;

public abstract interface SendImageApprovalDialogFragment$SendImageApprovalDialogHost
{
  public abstract MessengerLibApi getMessengerLibApi();
  
  public abstract Tracker getTracker();
  
  public abstract void onCancelSendImageAction();
  
  public abstract void onSendImageAction(ManagedBitmap paramManagedBitmap);
}

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.ui.dialogs.SendImageApprovalDialogFragment.SendImageApprovalDialogHost
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */