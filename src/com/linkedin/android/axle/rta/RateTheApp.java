package com.linkedin.android.axle.rta;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.deeplink.helper.CrosslinkHelper;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.common.JsonModel;
import com.linkedin.android.pegasus.gen.voyager.common.lego.ActionCategory;
import com.linkedin.android.pegasus.gen.voyager.common.lego.LegoWidgetImpressionEvent.Builder;
import com.linkedin.android.pegasus.gen.voyager.common.lego.Visibility;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.crosspromo.fe.api.android.Promo;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;

public final class RateTheApp
{
  private boolean articleRead = false;
  public CoordinatorLayout container;
  View dislikeConfirmView;
  View dislikeView;
  View firstView;
  String legoTrackingToken;
  View likeView;
  RTADislikeCardViewModel rtaDislikeCardViewModel;
  RTADislikeConfirmCardViewModel rtaDislikeConfirmCardViewModel;
  public boolean rtaDisplayed;
  private RTAFirstCardViewModel rtaFirstCardViewModel;
  public View rtaFrameView;
  RTALikeCardViewModel rtaLikeCardViewModel;
  public boolean rtaToDisplay;
  
  public static void animationSet(FragmentComponent paramFragmentComponent)
  {
    Object localObject = paramFragmentComponent.context().getApplicationContext();
    Animation localAnimation = AnimationUtils.loadAnimation((Context)localObject, 2131034130);
    localObject = AnimationUtils.loadAnimation((Context)localObject, 2131034149);
    View localView = paramFragmentComponent.activity().findViewById(2131755189);
    paramFragmentComponent = paramFragmentComponent.activity().findViewById(2131755190);
    if (localView != null) {
      localView.startAnimation(localAnimation);
    }
    if (paramFragmentComponent != null) {
      paramFragmentComponent.startAnimation((Animation)localObject);
    }
  }
  
  public static void dismissSoftKeyboard(FragmentComponent paramFragmentComponent)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)paramFragmentComponent.context().getApplicationContext().getSystemService("input_method");
    paramFragmentComponent = (EditText)paramFragmentComponent.activity().findViewById(2131755195);
    if (paramFragmentComponent != null) {
      localInputMethodManager.hideSoftInputFromWindow(paramFragmentComponent.getWindowToken(), 0);
    }
  }
  
  public final void onResume(Promo paramPromo)
  {
    legoTrackingToken = legoTrackingToken;
  }
  
  public final void showRTA(final FragmentComponent paramFragmentComponent)
  {
    if (!"enabled".equals(paramFragmentComponent.lixManager().getTreatment(Lix.AXLE_RATE_THE_APP))) {}
    label22:
    do
    {
      do
      {
        do
        {
          break label22;
          do
          {
            return;
          } while ((legoTrackingToken == null) || (rtaDisplayed));
          localObject1 = paramFragmentComponent.activity();
        } while (localObject1 == null);
        localObject1 = ((Activity)localObject1).findViewById(2131755465);
      } while (!(localObject1 instanceof CoordinatorLayout));
      container = ((CoordinatorLayout)localObject1);
    } while (container == null);
    container.removeView(rtaFrameView);
    rtaFrameView = LayoutInflater.from(container.getContext()).inflate(2130968612, container, false);
    Object localObject1 = new FrameLayout.LayoutParams(-1, -1);
    container.addView(rtaFrameView, (ViewGroup.LayoutParams)localObject1);
    firstView = paramFragmentComponent.activity().findViewById(2131755207);
    likeView = paramFragmentComponent.activity().findViewById(2131755208);
    dislikeView = paramFragmentComponent.activity().findViewById(2131755209);
    dislikeConfirmView = paramFragmentComponent.activity().findViewById(2131755210);
    localObject1 = paramFragmentComponent.context().getApplicationContext();
    final Object localObject2 = paramFragmentComponent.context().getApplicationContext();
    RTAFirstCardViewModel localRTAFirstCardViewModel = new RTAFirstCardViewModel();
    titleText = ((Context)localObject2).getString(2131230804);
    leftButtonText = ((Context)localObject2).getString(2131230802);
    rightButtonText = ((Context)localObject2).getString(2131230803);
    rtaFirstCardViewModel = localRTAFirstCardViewModel;
    localObject2 = paramFragmentComponent.context().getApplicationContext();
    rtaFirstCardViewModel.cancelOnClickListener = new TrackingOnClickListener(paramFragmentComponent.tracker(), "rta_dismiss_first_frame", new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        try
        {
          RateTheAppTransformer.sendLegoWidgetActionEvent(paramFragmentComponent, legoTrackingToken, ActionCategory.DISMISS);
          paramAnonymousView = AnimationUtils.loadAnimation(localObject2, 2131034149);
          firstView.startAnimation(paramAnonymousView);
          firstView.setVisibility(8);
          return;
        }
        catch (BuilderException paramAnonymousView)
        {
          for (;;)
          {
            paramFragmentComponent.context();
            Util.safeThrow$7a8b4789(new IllegalArgumentException("Failed to create Dismiss lego action event"));
          }
        }
      }
    };
    rtaFirstCardViewModel.likeOnClickListener = new TrackingOnClickListener(paramFragmentComponent.tracker(), "rta_love_it", new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        try
        {
          RateTheAppTransformer.sendLegoWidgetActionEvent(paramFragmentComponent, legoTrackingToken, ActionCategory.SECONDARY_ACTION);
          paramAnonymousView = AnimationUtils.loadAnimation(localObject2, 2131034166);
          paramFragmentComponent.activity().findViewById(2131755199).startAnimation(paramAnonymousView);
          firstView.setVisibility(8);
          paramAnonymousView = RateTheApp.this;
          Object localObject1 = paramFragmentComponent.context().getApplicationContext();
          Object localObject2 = new RTALikeCardViewModel();
          titleText = ((Context)localObject1).getString(2131230807);
          sendText = ((Context)localObject1).getString(2131230806);
          cancelText = ((Context)localObject1).getString(2131230805);
          rtaLikeCardViewModel = ((RTALikeCardViewModel)localObject2);
          paramAnonymousView = RateTheApp.this;
          localObject1 = paramFragmentComponent;
          localObject2 = ((FragmentComponent)localObject1).context().getApplicationContext();
          rtaLikeCardViewModel.cancelOnClickListener = new RateTheApp.4(paramAnonymousView, ((FragmentComponent)localObject1).tracker(), "rta_not_now", new TrackingEventBuilder[0], (FragmentComponent)localObject1, (Context)localObject2);
          rtaLikeCardViewModel.sendOnClickListener = new RateTheApp.5(paramAnonymousView, ((FragmentComponent)localObject1).tracker(), "rta_sure", new TrackingEventBuilder[0], (FragmentComponent)localObject1, (Context)localObject2);
          paramAnonymousView = rtaLikeCardViewModel;
          paramFragmentComponent.activity().getLayoutInflater();
          paramFragmentComponent.mediaCenter();
          paramAnonymousView.onBindViewHolder$2b327430(new RTALikeCardViewHolder(likeView));
          likeView.setVisibility(0);
          paramAnonymousView = AnimationUtils.loadAnimation(localObject2, 2131034162);
          paramFragmentComponent.activity().findViewById(2131755215).startAnimation(paramAnonymousView);
          paramAnonymousView = paramFragmentComponent.activity().findViewById(2131755213);
          localObject1 = paramFragmentComponent.activity().findViewById(2131755214);
          localObject2 = AnimationUtils.loadAnimation(localObject2, 2131034152);
          ((Animation)localObject2).setDuration(localObject2.getResources().getInteger(2131558409));
          paramAnonymousView.startAnimation((Animation)localObject2);
          ((View)localObject1).startAnimation((Animation)localObject2);
          return;
        }
        catch (BuilderException paramAnonymousView)
        {
          for (;;)
          {
            paramFragmentComponent.context();
            Util.safeThrow$7a8b4789(new IllegalArgumentException("Failed to create SecondaryAction lego action event"));
          }
        }
      }
    };
    rtaFirstCardViewModel.dislikeOnClickListener = new TrackingOnClickListener(paramFragmentComponent.tracker(), "rta_could_be_better", new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        try
        {
          RateTheAppTransformer.sendLegoWidgetActionEvent(paramFragmentComponent, legoTrackingToken, ActionCategory.SECONDARY_ACTION);
          firstView.setVisibility(8);
          paramAnonymousView = RateTheApp.this;
          Object localObject1 = paramFragmentComponent.context().getApplicationContext();
          Object localObject2 = new RTADislikeCardViewModel();
          titleText = ((Context)localObject1).getString(2131230799);
          sendText = ((Context)localObject1).getString(2131230798);
          rtaDislikeCardViewModel = ((RTADislikeCardViewModel)localObject2);
          paramAnonymousView = RateTheApp.this;
          localObject1 = paramFragmentComponent;
          localObject2 = ((FragmentComponent)localObject1).context().getApplicationContext();
          rtaDislikeCardViewModel.cancelOnClickListener = new RateTheApp.6(paramAnonymousView, ((FragmentComponent)localObject1).tracker(), "rta_dismiss_feedback", new TrackingEventBuilder[0], (FragmentComponent)localObject1);
          rtaDislikeCardViewModel.sendOnClickListener = new RateTheApp.7(paramAnonymousView, ((FragmentComponent)localObject1).tracker(), "rta_send_feedback", new TrackingEventBuilder[0], (FragmentComponent)localObject1, (Context)localObject2);
          paramAnonymousView = rtaDislikeCardViewModel;
          paramFragmentComponent.activity().getLayoutInflater();
          paramFragmentComponent.mediaCenter();
          paramAnonymousView.onBindViewHolder$62a35ce2(new RTADislikeCardViewHolder(dislikeView));
          dislikeView.setVisibility(0);
          ((InputMethodManager)paramFragmentComponent.context().getApplicationContext().getSystemService("input_method")).toggleSoftInput(1, 0);
          return;
        }
        catch (BuilderException paramAnonymousView)
        {
          for (;;)
          {
            paramFragmentComponent.context();
            Util.safeThrow$7a8b4789(new IllegalArgumentException("Failed to create SecondaryAction lego action event"));
          }
        }
      }
    };
    localObject2 = rtaFirstCardViewModel;
    paramFragmentComponent.activity().getLayoutInflater();
    paramFragmentComponent.mediaCenter();
    ((RTAFirstCardViewModel)localObject2).onBindViewHolder$30b73eb7(new RTAFirstCardViewHolder(firstView));
    firstView.setVisibility(0);
    localObject2 = AnimationUtils.loadAnimation((Context)localObject1, 2131034152);
    ((Animation)localObject2).setDuration(((Context)localObject1).getResources().getInteger(2131558409));
    firstView.startAnimation((Animation)localObject2);
    try
    {
      localObject1 = legoTrackingToken;
      localObject1 = new LegoWidgetImpressionEvent.Builder().setTrackingToken((String)localObject1).setVisibility(Visibility.SHOW).build(RecordTemplate.Flavor.RECORD);
      localObject2 = Routes.LEGO_WIDGET_IMPRESSION.buildUponRoot().buildUpon().build().toString();
      paramFragmentComponent.dataManager().submit(Request.post().url((String)localObject2).model((RecordTemplate)localObject1).filter(DataManager.DataStoreFilter.NETWORK_ONLY));
      rtaDisplayed = true;
      return;
    }
    catch (BuilderException localBuilderException)
    {
      for (;;)
      {
        paramFragmentComponent.context();
        Util.safeThrow$7a8b4789(new IllegalArgumentException("Failed to create lego impression event"));
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.rta.RateTheApp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */