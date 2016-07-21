package com.linkedin.android.axle.tracking;

import android.net.Uri;
import android.net.Uri.Builder;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.pegasus.gen.voyager.common.lego.ActionCategory;
import com.linkedin.android.pegasus.gen.voyager.common.lego.LegoWidgetActionEvent.Builder;
import com.linkedin.android.pegasus.gen.voyager.common.lego.LegoWidgetImpressionEvent.Builder;
import com.linkedin.android.pegasus.gen.voyager.common.lego.Visibility;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;

public final class LegoTrackingUtils
{
  public static void sendLegoTrackingImpressionEvent(FlagshipDataManager paramFlagshipDataManager, String paramString1, String paramString2)
    throws BuilderException
  {
    LegoWidgetImpressionEvent.Builder localBuilder = new LegoWidgetImpressionEvent.Builder().setVisibility(Visibility.SHOW);
    if (paramString1 == null) {
      hasTrackingId = false;
    }
    for (trackingId = null;; trackingId = paramString1)
    {
      paramString1 = localBuilder.setTrackingToken(paramString2).build(RecordTemplate.Flavor.RECORD);
      paramString2 = Routes.LEGO_WIDGET_IMPRESSION.buildUponRoot().buildUpon().build().toString();
      paramFlagshipDataManager.submit(Request.post().url(paramString2).model(paramString1).filter(DataManager.DataStoreFilter.NETWORK_ONLY));
      return;
      hasTrackingId = true;
    }
  }
  
  public static void sendLegoWidgetActionEvent(FlagshipDataManager paramFlagshipDataManager, String paramString1, String paramString2, ActionCategory paramActionCategory)
    throws BuilderException
  {
    LegoWidgetActionEvent.Builder localBuilder = new LegoWidgetActionEvent.Builder();
    if (paramString1 == null) {
      hasTrackingId = false;
    }
    for (trackingId = null;; trackingId = paramString1)
    {
      paramString1 = localBuilder.setTrackingToken(paramString2).setActionCategory(paramActionCategory).setActionCount(Integer.valueOf(1)).build(RecordTemplate.Flavor.RECORD);
      paramString2 = Routes.LEGO_WIDGET_ACTION.buildUponRoot().buildUpon().build().toString();
      paramFlagshipDataManager.submit(Request.post().url(paramString2).model(paramString1).filter(DataManager.DataStoreFilter.NETWORK_ONLY));
      return;
      hasTrackingId = true;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.tracking.LegoTrackingUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */