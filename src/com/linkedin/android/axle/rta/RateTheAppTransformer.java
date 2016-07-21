package com.linkedin.android.axle.rta;

import android.net.Uri;
import android.net.Uri.Builder;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.pegasus.gen.voyager.common.lego.ActionCategory;
import com.linkedin.android.pegasus.gen.voyager.common.lego.LegoWidgetActionEvent.Builder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;

public final class RateTheAppTransformer
{
  public static void sendLegoWidgetActionEvent(FragmentComponent paramFragmentComponent, String paramString, ActionCategory paramActionCategory)
    throws BuilderException
  {
    paramString = new LegoWidgetActionEvent.Builder().setTrackingToken(paramString).setActionCategory(paramActionCategory).setActionCount(Integer.valueOf(1)).build(RecordTemplate.Flavor.RECORD);
    paramActionCategory = Routes.LEGO_WIDGET_ACTION.buildUponRoot().buildUpon().build().toString();
    paramFragmentComponent.dataManager().submit(Request.post().url(paramActionCategory).model(paramString).filter(DataManager.DataStoreFilter.NETWORK_ONLY));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.rta.RateTheAppTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */