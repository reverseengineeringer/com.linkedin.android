package com.linkedin.android.axle.rta;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.common.lego.ActionCategory;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.data.lite.BuilderException;

final class RateTheApp$3
  extends TrackingOnClickListener
{
  RateTheApp$3(RateTheApp paramRateTheApp, Tracker paramTracker, String paramString, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, FragmentComponent paramVarArgs)
  {
    super(paramTracker, paramString, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    try
    {
      RateTheAppTransformer.sendLegoWidgetActionEvent(val$fragmentComponent, this$0.legoTrackingToken, ActionCategory.SECONDARY_ACTION);
      this$0.firstView.setVisibility(8);
      paramView = this$0;
      Object localObject1 = val$fragmentComponent.context().getApplicationContext();
      Object localObject2 = new RTADislikeCardViewModel();
      titleText = ((Context)localObject1).getString(2131230799);
      sendText = ((Context)localObject1).getString(2131230798);
      rtaDislikeCardViewModel = ((RTADislikeCardViewModel)localObject2);
      paramView = this$0;
      localObject1 = val$fragmentComponent;
      localObject2 = ((FragmentComponent)localObject1).context().getApplicationContext();
      rtaDislikeCardViewModel.cancelOnClickListener = new RateTheApp.6(paramView, ((FragmentComponent)localObject1).tracker(), "rta_dismiss_feedback", new TrackingEventBuilder[0], (FragmentComponent)localObject1);
      rtaDislikeCardViewModel.sendOnClickListener = new RateTheApp.7(paramView, ((FragmentComponent)localObject1).tracker(), "rta_send_feedback", new TrackingEventBuilder[0], (FragmentComponent)localObject1, (Context)localObject2);
      paramView = this$0.rtaDislikeCardViewModel;
      val$fragmentComponent.activity().getLayoutInflater();
      val$fragmentComponent.mediaCenter();
      paramView.onBindViewHolder$62a35ce2(new RTADislikeCardViewHolder(this$0.dislikeView));
      this$0.dislikeView.setVisibility(0);
      ((InputMethodManager)val$fragmentComponent.context().getApplicationContext().getSystemService("input_method")).toggleSoftInput(1, 0);
      return;
    }
    catch (BuilderException paramView)
    {
      for (;;)
      {
        val$fragmentComponent.context();
        Util.safeThrow$7a8b4789(new IllegalArgumentException("Failed to create SecondaryAction lego action event"));
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.rta.RateTheApp.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */