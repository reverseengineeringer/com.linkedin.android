package com.linkedin.messengerlib.ui.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.linkedin.messengerlib.R.id;
import com.linkedin.messengerlib.R.layout;

public final class EventLongPressDialogFragment
  extends DialogFragment
{
  private EventLongPressDialogHost listener;
  
  public static EventLongPressDialogFragment newInstance()
  {
    EventLongPressDialogFragment localEventLongPressDialogFragment = new EventLongPressDialogFragment();
    localEventLongPressDialogFragment.setArguments(new Bundle());
    return localEventLongPressDialogFragment;
  }
  
  public final void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    try
    {
      listener = ((EventLongPressDialogHost)paramActivity);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new ClassCastException(paramActivity.toString() + " must implement EventLongPressDialogHost");
    }
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = super.onCreateDialog(paramBundle);
    paramBundle.getWindow().requestFeature(1);
    return paramBundle;
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.msglib_event_long_press_options, paramViewGroup, false);
    ((TextView)paramLayoutInflater.findViewById(R.id.event_long_press_options_copy)).setOnClickListener(new EventLongPressDialogFragment.1(this));
    return paramLayoutInflater;
  }
  
  public static abstract interface EventLongPressDialogHost
  {
    public abstract void onEventLongPressCopyAction();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.ui.dialogs.EventLongPressDialogFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */