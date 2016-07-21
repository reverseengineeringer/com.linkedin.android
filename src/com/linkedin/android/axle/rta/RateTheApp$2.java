package com.linkedin.android.axle.rta;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.common.lego.ActionCategory;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.data.lite.BuilderException;

final class RateTheApp$2
  extends TrackingOnClickListener
{
  RateTheApp$2(RateTheApp paramRateTheApp, Tracker paramTracker, String paramString, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, FragmentComponent paramFragmentComponent, Context paramVarArgs)
  {
    super(paramTracker, paramString, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    try
    {
      RateTheAppTransformer.sendLegoWidgetActionEvent(val$fragmentComponent, this$0.legoTrackingToken, ActionCategory.SECONDARY_ACTION);
      paramView = AnimationUtils.loadAnimation(val$context, 2131034166);
      val$fragmentComponent.activity().findViewById(2131755199).startAnimation(paramView);
      this$0.firstView.setVisibility(8);
      paramView = this$0;
      Object localObject1 = val$fragmentComponent.context().getApplicationContext();
      Object localObject2 = new RTALikeCardViewModel();
      titleText = ((Context)localObject1).getString(2131230807);
      sendText = ((Context)localObject1).getString(2131230806);
      cancelText = ((Context)localObject1).getString(2131230805);
      rtaLikeCardViewModel = ((RTALikeCardViewModel)localObject2);
      paramView = this$0;
      localObject1 = val$fragmentComponent;
      localObject2 = ((FragmentComponent)localObject1).context().getApplicationContext();
      rtaLikeCardViewModel.cancelOnClickListener = new RateTheApp.4(paramView, ((FragmentComponent)localObject1).tracker(), "rta_not_now", new TrackingEventBuilder[0], (FragmentComponent)localObject1, (Context)localObject2);
      rtaLikeCardViewModel.sendOnClickListener = new RateTheApp.5(paramView, ((FragmentComponent)localObject1).tracker(), "rta_sure", new TrackingEventBuilder[0], (FragmentComponent)localObject1, (Context)localObject2);
      paramView = this$0.rtaLikeCardViewModel;
      val$fragmentComponent.activity().getLayoutInflater();
      val$fragmentComponent.mediaCenter();
      paramView.onBindViewHolder$2b327430(new RTALikeCardViewHolder(this$0.likeView));
      this$0.likeView.setVisibility(0);
      paramView = AnimationUtils.loadAnimation(val$context, 2131034162);
      val$fragmentComponent.activity().findViewById(2131755215).startAnimation(paramView);
      paramView = val$fragmentComponent.activity().findViewById(2131755213);
      localObject1 = val$fragmentComponent.activity().findViewById(2131755214);
      localObject2 = AnimationUtils.loadAnimation(val$context, 2131034152);
      ((Animation)localObject2).setDuration(val$context.getResources().getInteger(2131558409));
      paramView.startAnimation((Animation)localObject2);
      ((View)localObject1).startAnimation((Animation)localObject2);
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
 * Qualified Name:     com.linkedin.android.axle.rta.RateTheApp.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */