package com.linkedin.android.infra.app;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.Optional;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.Page;
import com.linkedin.android.tracking.v2.event.PageInstance;
import com.linkedin.android.tracking.v2.event.PageViewEvent;
import com.squareup.leakcanary.RefWatcher;
import java.util.UUID;

public abstract class BaseDialogFragment
  extends DialogFragment
  implements Page
{
  public FragmentComponent fragmentComponent;
  private PageInstance previousPageInstance;
  
  public final BaseActivity getBaseActivity()
  {
    return fragmentComponent.activity();
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    paramContext = getActivity();
    BaseActivity localBaseActivity = (BaseActivity)getActivity();
    paramContext.getApplication();
    fragmentComponent = FlagshipApplication.fragmentComponent$2dbaac8a(activityComponent, this);
    if ((shouldTrackPageView()) && (!TextUtils.isEmpty(pageKey())))
    {
      paramContext = fragmentComponent.tracker();
      if (isAnchorPage())
      {
        previousPageInstance = paramContext.getCurrentPageInstance();
        currentPageInstance = new PageInstance(paramContext, pageKey(), UUID.randomUUID());
      }
      new PageViewEvent(paramContext, pageKey(), isAnchorPage()).send();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Optional localOptional = fragmentComponent.refWatcher();
    if (localOptional.isPresent()) {
      ((RefWatcher)localOptional.get()).watch(this);
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (previousPageInstance != null) {
      fragmentComponent.tracker().currentPageInstance = previousPageInstance;
    }
  }
  
  public abstract boolean shouldTrackPageView();
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.app.BaseDialogFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */