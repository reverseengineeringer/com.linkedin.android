package com.linkedin.android.growth.abi;

import android.content.res.Resources;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.growth.lego.LegoPageContentWithParser;
import com.linkedin.android.growth.utils.GrowthLixHelper;
import com.linkedin.android.growth.utils.OwlTrackingUtils;
import com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.pegasus.gen.voyager.common.lego.Visibility;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.PageContent;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.WidgetContent;

public final class AbiAutoSyncToast$2
  implements RecordTemplateListener<PageContent>
{
  public AbiAutoSyncToast$2(BaseActivity paramBaseActivity) {}
  
  public final void onResponse(DataStoreResponse<PageContent> paramDataStoreResponse)
  {
    BaseActivity localBaseActivity;
    if ((error == null) && (statusCode == 200) && (model != null))
    {
      paramDataStoreResponse = new LegoPageContentWithParser((PageContent)model).findFirstWidgetContent("voyager_abi_autosync_toast", "autosync_toast");
      if (paramDataStoreResponse != null)
      {
        paramDataStoreResponse = trackingToken;
        if (!TextUtils.isEmpty(paramDataStoreResponse))
        {
          localBaseActivity = val$activity;
          if ((localBaseActivity != null) && (activityComponent != null) && (activityComponent.flagshipSharedPreferences() != null) && (activityComponent.tracker() != null) && (activityComponent.legoTrackingDataProvider() != null)) {
            break label115;
          }
        }
      }
    }
    label115:
    Snackbar localSnackbar;
    do
    {
      return;
      int i = GrowthLixHelper.parseInt(activityComponent.lixManager(), Lix.LIX_ABI_AUTO_SYNC_TOAST_DISPLAY_TIME, 0, "value_");
      localSnackbar = applicationComponent.snackbarUtil().make(2131231336, i);
    } while (localSnackbar == null);
    String str = OwlTrackingUtils.trackAbookImportImpressionEvent(activityComponent.tracker(), activityComponent.lixManager(), "mobile-voyager-autosync-toast");
    ActivityComponent localActivityComponent = activityComponent;
    localSnackbar.setAction(2131231335, new AbiAutoSyncToast.1(localBaseActivity, localActivityComponent, str)).setActionTextColor(localBaseActivity.getResources().getColor(2131624086)).show();
    localActivityComponent.flagshipSharedPreferences().saveHasNewAutoSyncContactsToToast(false);
    activityComponent.legoTrackingDataProvider().sendWidgetImpressionEvent$4bb724c7(paramDataStoreResponse, Visibility.SHOW);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiAutoSyncToast.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */