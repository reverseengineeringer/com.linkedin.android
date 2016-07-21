package com.linkedin.messengerlib.ui.dialogs;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.linkedin.android.imageloader.LiImageView;
import com.linkedin.android.imageloader.interfaces.ManagedBitmap;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.messengerlib.MessengerLibApi;
import com.linkedin.messengerlib.R.drawable;
import com.linkedin.messengerlib.R.id;
import com.linkedin.messengerlib.R.layout;

public final class SendImageApprovalDialogFragment
  extends DialogFragment
{
  private SendImageApprovalDialogHost listener;
  private SendImageApprovalDialogFragment.SendButtonClickListener sendButtonClickListener;
  
  public static SendImageApprovalDialogFragment newInstance(String paramString)
  {
    SendImageApprovalDialogFragment localSendImageApprovalDialogFragment = new SendImageApprovalDialogFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("imageUri", paramString);
    localSendImageApprovalDialogFragment.setArguments(localBundle);
    return localSendImageApprovalDialogFragment;
  }
  
  public final void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    try
    {
      listener = ((SendImageApprovalDialogHost)paramActivity);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new ClassCastException(paramActivity.toString() + " must implement SendImageApprovalDialogHost");
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setStyle(2, 16973934);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.msglib_send_image_approval, paramViewGroup, false);
    paramViewGroup = getArguments().getString("imageUri");
    paramBundle = (Button)paramLayoutInflater.findViewById(R.id.action_send);
    paramBundle.setVisibility(4);
    paramBundle = new SendImageApprovalDialogFragment.1(this, paramBundle);
    LiImageView localLiImageView = (LiImageView)paramLayoutInflater.findViewById(R.id.preview_image);
    if (listener.getMessengerLibApi() != null) {
      listener.getMessengerLibApi().loadImageFromUri(Uri.parse(paramViewGroup), R.drawable.msglib_image_attachment_placeholder, localLiImageView, paramBundle);
    }
    ((Button)paramLayoutInflater.findViewById(R.id.action_cancel)).setOnClickListener(new SendImageApprovalDialogFragment.2(this, listener.getTracker(), "cancel_selected_photo", new TrackingEventBuilder[0]));
    return paramLayoutInflater;
  }
  
  public final void onDestroyView()
  {
    if (sendButtonClickListener != null) {
      sendButtonClickListener.recycle();
    }
    super.onDestroyView();
  }
  
  public static abstract interface SendImageApprovalDialogHost
  {
    public abstract MessengerLibApi getMessengerLibApi();
    
    public abstract Tracker getTracker();
    
    public abstract void onCancelSendImageAction();
    
    public abstract void onSendImageAction(ManagedBitmap paramManagedBitmap);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.ui.dialogs.SendImageApprovalDialogFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */