package com.linkedin.android.axle.rta;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.linkedin.android.deeplink.helper.CrosslinkHelper;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.common.lego.ActionCategory;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.data.lite.BuilderException;

final class RateTheApp$5
  extends TrackingOnClickListener
{
  RateTheApp$5(RateTheApp paramRateTheApp, Tracker paramTracker, String paramString, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, FragmentComponent paramFragmentComponent, Context paramVarArgs)
  {
    super(paramTracker, paramString, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    try
    {
      RateTheAppTransformer.sendLegoWidgetActionEvent(val$fragmentComponent, this$0.legoTrackingToken, ActionCategory.PRIMARY_ACTION);
      paramView = AnimationUtils.loadAnimation(val$context, 2131034149);
      this$0.likeView.startAnimation(paramView);
      this$0.likeView.setVisibility(8);
      paramView = val$fragmentComponent;
      CrosslinkHelper.create(paramView.context().getApplicationContext());
      localUri1 = Uri.parse("market://details?id=" + "com.linkedin.android");
    }
    catch (BuilderException paramView)
    {
      for (;;)
      {
        try
        {
          Uri localUri1;
          CrosslinkHelper.crosslink(paramView.activity(), CrosslinkHelper.buildCrosslinkIntent$4b1ae7cf(localUri1));
          return;
        }
        catch (ActivityNotFoundException localActivityNotFoundException)
        {
          Uri localUri2 = Uri.parse("https://play.google.com/store/apps/details?id=" + "com.linkedin.android");
          paramView.activity().startActivity(new Intent("android.intent.action.VIEW", localUri2));
        }
        paramView = paramView;
        val$fragmentComponent.context();
        Util.safeThrow$7a8b4789(new IllegalArgumentException("Failed to create PrimaryAction lego action event"));
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.rta.RateTheApp.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */