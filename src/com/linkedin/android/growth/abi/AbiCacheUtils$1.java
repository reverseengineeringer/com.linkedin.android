package com.linkedin.android.growth.abi;

import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.PageContent;

public final class AbiCacheUtils$1
  implements RecordTemplateListener<PageContent>
{
  public AbiCacheUtils$1(AbiCacheUtils paramAbiCacheUtils) {}
  
  public final void onResponse(DataStoreResponse<PageContent> paramDataStoreResponse)
  {
    this$0.updatePastImportedContactsLegoCacheUpdatedTimestamp(paramDataStoreResponse, true);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiCacheUtils.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */