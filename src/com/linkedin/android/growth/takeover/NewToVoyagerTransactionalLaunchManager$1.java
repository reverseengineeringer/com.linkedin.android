package com.linkedin.android.growth.takeover;

import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.common.Takeover;
import com.linkedin.android.pegasus.gen.voyager.common.TakeoverType;
import java.util.Iterator;
import java.util.List;

public final class NewToVoyagerTransactionalLaunchManager$1
  implements RecordTemplateListener<CollectionTemplate<Takeover, CollectionMetadata>>
{
  public NewToVoyagerTransactionalLaunchManager$1(NewToVoyagerTransactionalLaunchManager paramNewToVoyagerTransactionalLaunchManager) {}
  
  public final void onResponse(DataStoreResponse<CollectionTemplate<Takeover, CollectionMetadata>> paramDataStoreResponse)
  {
    if ((model != null) && (model).hasElements))
    {
      paramDataStoreResponse = Util.safeGet(model).elements).iterator();
      while (paramDataStoreResponse.hasNext())
      {
        Takeover localTakeover = (Takeover)paramDataStoreResponse.next();
        if (takeoverType == TakeoverType.NEW_TO_VOYAGER) {
          Bus.publishStickyEvent(localTakeover);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.takeover.NewToVoyagerTransactionalLaunchManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */