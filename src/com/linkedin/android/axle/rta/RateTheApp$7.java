package com.linkedin.android.axle.rta;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.common.JsonModel;
import com.linkedin.android.pegasus.gen.voyager.common.lego.ActionCategory;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate;

final class RateTheApp$7
  extends TrackingOnClickListener
{
  RateTheApp$7(RateTheApp paramRateTheApp, Tracker paramTracker, String paramString, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, FragmentComponent paramFragmentComponent, Context paramVarArgs)
  {
    super(paramTracker, paramString, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    paramView = new FeedbackPublisher(val$fragmentComponent);
    Object localObject1 = FeedbackPublisher.wrapFeedback(((EditText)val$fragmentComponent.activity().findViewById(2131755195)).getText().toString());
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = new FeedbackPublisher.1(paramView);
      fragmentComponent.dataManager().submit(Request.post().url("/voyager/api/rta/feedback").model((RecordTemplate)localObject1).builder(JsonModel.BUILDER).listener((RecordTemplateListener)localObject2).filter(DataManager.DataStoreFilter.NETWORK_ONLY));
    }
    try
    {
      RateTheAppTransformer.sendLegoWidgetActionEvent(val$fragmentComponent, this$0.legoTrackingToken, ActionCategory.PRIMARY_ACTION);
      RateTheApp.dismissSoftKeyboard(val$fragmentComponent);
      RateTheApp.animationSet(val$fragmentComponent);
      this$0.dislikeView.setVisibility(8);
      localObject1 = this$0;
      Object localObject3 = val$fragmentComponent;
      localObject2 = ((FragmentComponent)localObject3).context().getApplicationContext();
      RTADislikeConfirmCardViewModel localRTADislikeConfirmCardViewModel = new RTADislikeConfirmCardViewModel();
      paramView = "";
      localObject3 = ((FragmentComponent)localObject3).memberUtil().getMiniProfile();
      if (localObject3 != null) {
        paramView = firstName;
      }
      titleText = (((Context)localObject2).getString(2131230801) + " " + paramView + ((Context)localObject2).getString(2131230800));
      rtaDislikeConfirmCardViewModel = localRTADislikeConfirmCardViewModel;
      paramView = this$0.rtaDislikeConfirmCardViewModel;
      val$fragmentComponent.activity().getLayoutInflater();
      val$fragmentComponent.mediaCenter();
      paramView.onBindViewHolder$4d50d994(new RTADislikeConfirmCardViewHolder(this$0.dislikeConfirmView));
      this$0.dislikeConfirmView.setVisibility(0);
      paramView = AnimationUtils.loadAnimation(val$context, 2131034152);
      paramView.setDuration(val$context.getResources().getInteger(2131558409));
      this$0.dislikeConfirmView.startAnimation(paramView);
      new Handler().postDelayed(new Runnable()
      {
        public final void run()
        {
          Animation localAnimation = AnimationUtils.loadAnimation(val$context, 2131034149);
          this$0.dislikeConfirmView.startAnimation(localAnimation);
          this$0.dislikeConfirmView.setVisibility(8);
          this$0.container = null;
        }
      }, 4000L);
      return;
    }
    catch (BuilderException paramView)
    {
      for (;;)
      {
        val$fragmentComponent.context();
        Util.safeThrow$7a8b4789(new IllegalArgumentException("Failed to create PrimaryAction lego action event"));
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.rta.RateTheApp.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */