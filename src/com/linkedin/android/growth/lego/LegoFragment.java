package com.linkedin.android.growth.lego;

import android.os.Bundle;
import android.view.View;
import com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.pegasus.gen.voyager.common.lego.ActionCategory;
import com.linkedin.android.pegasus.gen.voyager.common.lego.Visibility;

public abstract class LegoFragment
  extends PageFragment
{
  public LegoTrackingDataProvider legoTrackingDataProvider;
  public LegoWidget legoWidget;
  
  private void trackLegoWidgetAction(ActionCategory paramActionCategory, int paramInt, String paramString)
  {
    legoTrackingDataProvider.sendActionEvent$3082e732(legoWidget.getTrackingToken(), paramActionCategory, paramInt, paramString);
  }
  
  public void doResume()
  {
    super.doResume();
    trackLegoWidgetImpression();
    trackLegoPageImpression();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    legoWidget = ((LegoWidget)getParentFragment());
    legoTrackingDataProvider = getActivityactivityComponent.legoTrackingDataProvider();
    super.onViewCreated(paramView, paramBundle);
  }
  
  public void trackLegoPageImpression()
  {
    legoTrackingDataProvider.sendPageImpressionEvent$505cbf4b(legoWidget.getTrackingToken());
  }
  
  public void trackLegoWidgetImpression()
  {
    legoTrackingDataProvider.sendWidgetImpressionEvent$4bb724c7(legoWidget.getTrackingToken(), Visibility.SHOW);
  }
  
  public final void trackLegoWidgetPrimaryAction(int paramInt)
  {
    trackLegoWidgetAction(ActionCategory.PRIMARY_ACTION, paramInt, null);
  }
  
  public final void trackLegoWidgetSecondaryAction(int paramInt, String paramString)
  {
    trackLegoWidgetAction(ActionCategory.SECONDARY_ACTION, paramInt, paramString);
  }
  
  public void trackLegoWidgetSkipAction(String paramString)
  {
    trackLegoWidgetAction(ActionCategory.SKIP, 1, paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.lego.LegoFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */