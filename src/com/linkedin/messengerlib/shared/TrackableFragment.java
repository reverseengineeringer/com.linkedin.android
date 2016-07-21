package com.linkedin.messengerlib.shared;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.linkedin.android.litrackinglib.metric.Tracker;

public class TrackableFragment
  extends Fragment
{
  public final Tracker getTracker()
  {
    Fragment localFragment = getParentFragment();
    if (localFragment == null) {
      return ((MessengerTrackableInterface)getActivity().getApplicationContext()).getParentFragmentTracker();
    }
    return ((MessengerTrackableInterface)localFragment).getParentFragmentTracker();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.shared.TrackableFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */