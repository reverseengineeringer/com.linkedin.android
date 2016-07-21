package com.linkedin.android.identity.me.notifications.props;

import android.text.TextUtils;
import android.view.View;
import com.linkedin.android.infra.ScreenElement;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.DelayedExecution;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.litrackinglib.TrackingException;
import com.linkedin.android.litrackinglib.viewport.ImpressionData;
import com.linkedin.android.litrackinglib.viewport.Mapper;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.PropType;
import com.linkedin.android.relationships.home.AbstractPropViewModel;
import com.linkedin.android.relationships.home.RemoveTopCardEvent;
import com.linkedin.android.relationships.home.propstacklisteners.FirePropPageViewEventListener;
import com.linkedin.android.relationships.shared.events.InvitationUpdatedEvent;
import com.linkedin.android.relationships.widgets.cardstack.CardContainer;
import com.linkedin.android.relationships.widgets.cardstack.ListCardStackAdapter;
import com.linkedin.android.relationships.widgets.cardstack.ListCardStackViewModelAdapterImpl;
import com.linkedin.android.relationships.widgets.cardstack.PropStackView;
import com.linkedin.android.relationships.widgets.cardstack.PropStackView.Listener;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.consistency.ConsistencyManager;
import com.linkedin.consistency.ConsistencyManagerListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.greenrobot.eventbus.Subscribe;

public final class MePropStackViewModel
  extends ViewModel<MePropStackViewHolder>
  implements ScreenElement
{
  public final ListCardStackAdapter<AbstractPropViewModel> adapter;
  public ConsistencyManager consistencyManager;
  public List<ConsistencyManagerListener> consistencyManagerPropListeners;
  private DelayedExecution delayedExecution;
  public FirePropPageViewEventListener firePropPageViewEventListener;
  public FragmentComponent fragmentComponent;
  private MePropStackViewHolder holder;
  boolean isOnScreen;
  public Set<PropStackView.Listener> listeners;
  public String pushNotificationPropId;
  
  public MePropStackViewModel(FragmentComponent paramFragmentComponent)
  {
    fragmentComponent = paramFragmentComponent;
    delayedExecution = paramFragmentComponent.delayedExecution();
    consistencyManager = paramFragmentComponent.consistencyManager();
    adapter = new ListCardStackViewModelAdapterImpl(paramFragmentComponent.context(), paramFragmentComponent.mediaCenter());
    listeners = new HashSet();
    firePropPageViewEventListener = new FirePropPageViewEventListener(paramFragmentComponent);
    pushNotificationPropId = null;
  }
  
  private static Mapper onBindTrackableViews$306976ec(Mapper paramMapper, MePropStackViewHolder paramMePropStackViewHolder)
  {
    try
    {
      paramMapper.bindTrackableViews(new View[] { itemView });
      return paramMapper;
    }
    catch (TrackingException localTrackingException)
    {
      itemView.getContext();
      Util.safeThrow$7a8b4789(new RuntimeException(localTrackingException));
    }
    return paramMapper;
  }
  
  public final void clearPropConsistencyManagerListeners()
  {
    if (consistencyManagerPropListeners != null)
    {
      Iterator localIterator = consistencyManagerPropListeners.iterator();
      while (localIterator.hasNext())
      {
        ConsistencyManagerListener localConsistencyManagerListener = (ConsistencyManagerListener)localIterator.next();
        consistencyManager.removeListener(localConsistencyManagerListener);
      }
      consistencyManagerPropListeners.clear();
      consistencyManagerPropListeners = null;
    }
  }
  
  public final boolean didEnter()
  {
    return isOnScreen;
  }
  
  public final void dismissTopProp(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (holder == null) {}
    PropStackView localPropStackView;
    do
    {
      return;
      localPropStackView = holder.propStackView;
    } while ((paramString == null) || (localPropStackView == null));
    DelayedExecution localDelayedExecution = delayedExecution;
    paramString = new MePropStackViewModel.2(this, localPropStackView, paramString, paramBoolean2);
    if (paramBoolean1) {}
    for (long l = 500L;; l = 0L)
    {
      localDelayedExecution.postDelayedExecution(paramString, l);
      return;
    }
  }
  
  public final ViewHolderCreator<MePropStackViewHolder> getCreator()
  {
    return MePropStackViewHolder.CREATOR;
  }
  
  public final List<AbstractPropViewModel> getPropViewModels()
  {
    return adapter.getValues();
  }
  
  public final void onBindViewHolder$32a4625a(MePropStackViewHolder paramMePropStackViewHolder)
  {
    if (holder == paramMePropStackViewHolder) {
      return;
    }
    holder = paramMePropStackViewHolder;
    propStackView.getCardContainer().setAdapter(adapter);
    setListeners();
  }
  
  public final void onEnter()
  {
    isOnScreen = true;
  }
  
  @Subscribe
  public final void onEvent(RemoveTopCardEvent paramRemoveTopCardEvent)
  {
    dismissTopProp(propId, false, false);
  }
  
  @Subscribe
  public final void onEvent(InvitationUpdatedEvent paramInvitationUpdatedEvent)
  {
    if (holder == null) {
      break label7;
    }
    for (;;)
    {
      label7:
      return;
      if (!fragmentComponent.fragment()).isActive)
      {
        CardContainer localCardContainer = holder.propStackView.getCardContainer();
        Object localObject = localCardContainer.getAdapter();
        if (localObject == null) {
          break;
        }
        localObject = ((ListCardStackAdapter)localObject).getValues();
        int i = 0;
        while (i < ((List)localObject).size())
        {
          if ((((List)localObject).get(i) instanceof PropCardViewModel))
          {
            PropCardViewModel localPropCardViewModel = (PropCardViewModel)((List)localObject).get(i);
            if ((propType == PropType.INVITATION) && (TextUtils.equals(profileId, profileId)))
            {
              localCardContainer.removeItemAtIndexInAdapter(i);
              return;
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public final void onLeave()
  {
    isOnScreen = false;
  }
  
  public final TrackingEventBuilder onTrackImpression(ImpressionData paramImpressionData)
  {
    if (holder != null)
    {
      paramImpressionData = holder.propStackView.getCardContainer().getTopCardAdapterItem();
      View localView = holder.propStackView.getCardContainer().getTopCard();
      if ((localView != null) && ((paramImpressionData instanceof AbstractPropViewModel)))
      {
        int i = localView.getMeasuredWidth();
        int j = localView.getMeasuredHeight();
        ((AbstractPropViewModel)paramImpressionData).trackImpressionEvent(i, j);
      }
    }
    return null;
  }
  
  public final void setListeners()
  {
    if (holder == null) {
      return;
    }
    holder.propStackView.setListeners(listeners);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.me.notifications.props.MePropStackViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */