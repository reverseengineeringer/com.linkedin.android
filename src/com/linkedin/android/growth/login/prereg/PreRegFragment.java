package com.linkedin.android.growth.login.prereg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import butterknife.InjectView;
import com.linkedin.android.artdeco.components.HorizontalViewPagerCarousel;
import com.linkedin.android.growth.login.LoginIntentBundle;
import com.linkedin.android.growth.login.login.LoginManager;
import com.linkedin.android.growth.login.smartlock.SmartLockManager;
import com.linkedin.android.infra.ScreenElement;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.ui.ViewPager;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.gen.avro2pegasus.events.mobilesdk.ThirdPartyMobileSdkLoginImpressionEvent.Builder;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

public class PreRegFragment
  extends PageFragment
  implements PreRegFragmentPagerNavigationListener
{
  @InjectView(2131756185)
  HorizontalViewPagerCarousel carousel;
  @InjectView(2131756186)
  Button joinButton;
  @Inject
  LoginManager loginManager;
  PreRegPagerAdapter pagerAdapter;
  protected PreRegListener preRegListener;
  @InjectView(2131756187)
  Button signInButton;
  SmartLockManager smartLockManager;
  @Inject
  Tracker tracker;
  @InjectView(2131756184)
  ViewPager viewPager;
  
  public final void doEnter()
  {
    super.doEnter();
    Object localObject = getActivity().getIntent();
    Tracker localTracker;
    ThirdPartyMobileSdkLoginImpressionEvent.Builder localBuilder;
    if (localObject != null)
    {
      localObject = LoginIntentBundle.getThirdPartyApplicationPackageName(((Intent)localObject).getExtras());
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localTracker = tracker;
        localBuilder = new ThirdPartyMobileSdkLoginImpressionEvent.Builder();
        if (localObject != null) {
          break label64;
        }
        hasThirdPartyApplicationIdentifier = false;
      }
    }
    for (thirdPartyApplicationIdentifier = null;; thirdPartyApplicationIdentifier = ((String)localObject))
    {
      localTracker.send(localBuilder);
      return;
      label64:
      hasThirdPartyApplicationIdentifier = true;
    }
  }
  
  public final List<ScreenElement> getScreenElements()
  {
    return Collections.singletonList(viewPager);
  }
  
  public final void goToJoinPage()
  {
    if (preRegListener != null)
    {
      preRegListener.showJoinScreen();
      return;
    }
    getActivity();
    Util.safeThrow$7a8b4789(new IllegalStateException("Join button does not have a listener attached"));
  }
  
  public final void goToSignInPage()
  {
    if (preRegListener != null)
    {
      preRegListener.showSSOScreenIfApplicable();
      return;
    }
    getActivity();
    Util.safeThrow$7a8b4789(new IllegalStateException("Sign in button does not have a listener attached"));
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((paramActivity instanceof PreRegListener))
    {
      preRegListener = ((PreRegListener)paramActivity);
      return;
    }
    getActivity();
    Util.safeThrow$7a8b4789(new IllegalStateException("Attached to an Activity that does not implement PreRegListener"));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968856, paramViewGroup, false);
  }
  
  public void onDetach()
  {
    super.onDetach();
    preRegListener = null;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    smartLockManager = fragmentComponent.activity().activityComponent.smartLockManager();
    pagerAdapter = new PreRegPagerAdapter(getChildFragmentManager());
    viewPager.setAdapter(pagerAdapter);
    viewPager.enableInteractionTracking(tracker, "prereg");
    viewPager.addOnPageChangeListener(new PreRegPageChangeListener(pagerAdapter, carousel));
    viewPager.setPageTransformer(false, new PreRegPageTransformer());
    carousel.setViewPager(viewPager);
    joinButton.setVisibility(4);
    signInButton.setVisibility(4);
    carousel.setVisibility(0);
  }
  
  public final String pageKey()
  {
    return "";
  }
  
  public final boolean shouldTrack()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.prereg.PreRegFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */