package com.linkedin.android.axle.rta;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.common.lego.ActionCategory;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.data.lite.BuilderException;

final class RateTheApp$6
  extends TrackingOnClickListener
{
  RateTheApp$6(RateTheApp paramRateTheApp, Tracker paramTracker, String paramString, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, FragmentComponent paramVarArgs)
  {
    super(paramTracker, paramString, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    try
    {
      RateTheAppTransformer.sendLegoWidgetActionEvent(val$fragmentComponent, this$0.legoTrackingToken, ActionCategory.SKIP);
      if (this$0.rtaDislikeCardViewModel.isEdited.booleanValue())
      {
        Object localObject = this$0;
        paramView = val$fragmentComponent;
        RateTheApp.8 local8 = new RateTheApp.8((RateTheApp)localObject, paramView);
        localObject = new RateTheApp.9((RateTheApp)localObject);
        new AlertDialog.Builder(paramView.activity()).setTitle(2131230795).setMessage(2131230794).setPositiveButton(2131230793, local8).setNegativeButton(2131230792, (DialogInterface.OnClickListener)localObject).show();
        return;
      }
    }
    catch (BuilderException paramView)
    {
      for (;;)
      {
        val$fragmentComponent.context();
        Util.safeThrow$7a8b4789(new IllegalArgumentException("Failed to create Skip lego action event"));
      }
      RateTheApp.dismissSoftKeyboard(val$fragmentComponent);
      RateTheApp.animationSet(val$fragmentComponent);
      this$0.dislikeView.setVisibility(8);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.rta.RateTheApp.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */