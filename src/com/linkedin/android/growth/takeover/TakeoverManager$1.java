package com.linkedin.android.growth.takeover;

import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.common.Takeover;
import com.linkedin.android.pegasus.gen.voyager.common.TakeoverType;
import com.linkedin.android.pegasus.gen.voyager.common.lego.ActionCategory;
import com.linkedin.android.pegasus.gen.voyager.common.lego.Visibility;
import java.util.Iterator;
import java.util.List;

public final class TakeoverManager$1
  implements RecordTemplateListener<CollectionTemplate<Takeover, CollectionMetadata>>
{
  public TakeoverManager$1(TakeoverManager paramTakeoverManager, BaseActivity paramBaseActivity) {}
  
  public final void onResponse(DataStoreResponse<CollectionTemplate<Takeover, CollectionMetadata>> paramDataStoreResponse)
  {
    if (model != null)
    {
      paramDataStoreResponse = Util.safeGet(model).elements).iterator();
      while (paramDataStoreResponse.hasNext())
      {
        Takeover localTakeover = (Takeover)paramDataStoreResponse.next();
        if (TakeoverType.NEW_TO_VOYAGER.equals(takeoverType))
        {
          val$activity.activityComponent.legoTrackingDataProvider().sendActionEvent$67c7f505(legoTrackingToken, ActionCategory.SECONDARY_ACTION);
          val$activity.activityComponent.legoTrackingDataProvider().sendWidgetImpressionEvent$4bb724c7(globalLegoTrackingToken, Visibility.SHOW);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.takeover.TakeoverManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */