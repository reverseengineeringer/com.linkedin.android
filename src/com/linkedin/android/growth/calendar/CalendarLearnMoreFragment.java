package com.linkedin.android.growth.calendar;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import com.linkedin.android.infra.app.BaseDialogFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public class CalendarLearnMoreFragment
  extends BaseDialogFragment
{
  public static final String TAG = CalendarLearnMoreFragment.class.getSimpleName();
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = new AlertDialog.Builder(getActivity());
    View localView = getActivity().getLayoutInflater().inflate(2130968809, null);
    ((Toolbar)localView.findViewById(2131755997)).setNavigationOnClickListener(new TrackingOnClickListener(fragmentComponent.tracker(), "back", new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        dismiss();
      }
    });
    paramBundle = paramBundle.setView(localView).create();
    paramBundle.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    return paramBundle;
  }
  
  public final String pageKey()
  {
    return "people_calendar_permission_learn_more";
  }
  
  public final boolean shouldTrackPageView()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.calendar.CalendarLearnMoreFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */