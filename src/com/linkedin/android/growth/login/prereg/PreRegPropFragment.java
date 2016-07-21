package com.linkedin.android.growth.login.prereg;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import butterknife.InjectView;
import com.linkedin.android.growth.boost.BoostUtil;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.BaseViewHolder;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.PageInstance;
import com.linkedin.android.tracking.v2.event.PegasusTrackingEventBuilder;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.gen.avro2pegasus.events.promotions.PromotionActionEvent.Builder;
import java.util.Collections;

public abstract class PreRegPropFragment<VH extends BaseViewHolder, VM extends PreRegBaseFragmentViewModel<VH>>
  extends PreRegBaseFragment<VH, VM>
{
  public static boolean promoViewed;
  @InjectView(2131756186)
  Button joinButton;
  private PreRegFragmentPagerNavigationListener navigationListener;
  @InjectView(2131756187)
  Button signInButton;
  
  public static boolean getPromoViewed()
  {
    return promoViewed;
  }
  
  public static void setPromoViewed(boolean paramBoolean)
  {
    promoViewed = paramBoolean;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((getParentFragment() instanceof PreRegFragmentPagerNavigationListener))
    {
      navigationListener = ((PreRegFragmentPagerNavigationListener)getParentFragment());
      return;
    }
    if ((getActivity() instanceof PreRegFragmentPagerNavigationListener))
    {
      navigationListener = ((PreRegFragmentPagerNavigationListener)getActivity());
      return;
    }
    getActivity();
    Util.safeThrow$7a8b4789(new IllegalStateException("Parent fragment/Activity does not support navigation"));
  }
  
  public void onDetach()
  {
    super.onDetach();
    navigationListener = null;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = fragmentComponent.tracker();
    signInButton.setOnClickListener(new TrackingOnClickListener(paramView, "sign_in", new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        navigationListener.goToSignInPage();
      }
    });
    joinButton.setOnClickListener(new TrackingOnClickListener(paramView, "join", new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        if (PreRegPropFragment.promoViewed)
        {
          Tracker localTracker = tracker;
          PromotionActionEvent.Builder localBuilder = new PromotionActionEvent.Builder().setControlUrn(PegasusTrackingEventBuilder.buildControlUrn(tracker.getCurrentPageInstance().pageKey, "join")).setPhoneNumberInfo(BoostUtil.getPhoneNumberInfo(getActivity()));
          FlagshipSharedPreferences localFlagshipSharedPreferences = fragmentComponent.flagshipSharedPreferences();
          getActivity();
          localTracker.send(localBuilder.setProductUrns(Collections.singletonList(BoostUtil.getProductUrn$63ab225c(localFlagshipSharedPreferences))));
        }
        super.onClick(paramAnonymousView);
        navigationListener.goToJoinPage();
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.prereg.PreRegPropFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */