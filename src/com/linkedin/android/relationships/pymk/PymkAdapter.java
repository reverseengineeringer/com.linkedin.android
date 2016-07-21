package com.linkedin.android.relationships.pymk;

import android.text.TextUtils;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.mergeAdapter.MergeAdapter;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.infra.viewmodel.TrackableViewModelArrayAdapter;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.litrackinglib.viewport.ViewPortManager;
import com.linkedin.android.relationships.shared.events.InvitationUpdatedEvent;
import com.linkedin.android.relationships.shared.events.InvitationUpdatedEvent.Type;
import com.linkedin.android.relationships.shared.events.PymkRemovedEvent;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;

public final class PymkAdapter
  extends TrackableViewModelArrayAdapter<ViewModel>
{
  private Bus eventBus;
  private TrackableFragment fragment;
  private MergeAdapter parentMergeAdapter;
  private ViewPortManager viewPortManager;
  
  public PymkAdapter(FragmentComponent paramFragmentComponent, MergeAdapter paramMergeAdapter)
  {
    super(paramFragmentComponent.context(), paramFragmentComponent.mediaCenter());
    eventBus = paramFragmentComponent.eventBus();
    Bus.subscribe(this);
    fragment = ((TrackableFragment)paramFragmentComponent.fragment());
    viewPortManager = paramFragmentComponent.viewportManager();
    parentMergeAdapter = paramMergeAdapter;
  }
  
  @Subscribe
  public final void onEvent(InvitationUpdatedEvent paramInvitationUpdatedEvent)
  {
    int k = 0;
    int j = getValues().size() - 1;
    if (j >= 0)
    {
      Object localObject = (ViewModel)getValues().get(j);
      int i = k;
      if ((localObject instanceof PymkCardViewModel))
      {
        localObject = (PymkCardViewModel)localObject;
        i = k;
        if (TextUtils.equals(profileId, profileId))
        {
          if ((type != InvitationUpdatedEvent.Type.SENT) || (isInvitationSent)) {
            break label106;
          }
          isInvitationSent = true;
          i = 1;
        }
      }
      for (;;)
      {
        j -= 1;
        k = i;
        break;
        label106:
        i = k;
        if (type == InvitationUpdatedEvent.Type.ACCEPT)
        {
          getValues().remove(j);
          i = 1;
        }
      }
    }
    if (k != 0) {
      notifyDataSetChanged();
    }
  }
  
  @Subscribe
  public final void onEvent(PymkRemovedEvent paramPymkRemovedEvent)
  {
    int i = getValues().size() - 1;
    while (i >= 0)
    {
      ViewModel localViewModel = (ViewModel)getValues().get(i);
      if (((localViewModel instanceof PymkCardViewModel)) && (TextUtils.equals(profileId, profileId)))
      {
        if (fragment.isActive) {
          viewPortManager.untrackAndRemove(parentMergeAdapter.getAbsolutePosition(i, this));
        }
        getValues().remove(i);
        notifyItemRemoved(i);
        return;
      }
      i -= 1;
    }
    CrashReporter.reportNonFatal(new Exception("Failed to delete pymk cell, event profileId " + profileId + " doesn't match with any cell profileId"));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.relationships.pymk.PymkAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */