package com.linkedin.android.entities;

import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataRequestWrapper;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.infra.EndlessViewModelAdapter;
import com.linkedin.android.infra.performance.RUMHelper;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.perftimer.RUMTiming;
import java.util.List;

public abstract class EntityViewAllListBaseFragment$DataLoadListener<ROW_DATA_MODEL extends FissileDataModel<ROW_DATA_MODEL>>
  implements RecordTemplateListener<CollectionTemplate<ROW_DATA_MODEL, com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata>>
{
  public EntityViewAllListBaseFragment$DataLoadListener(EntityViewAllListBaseFragment paramEntityViewAllListBaseFragment) {}
  
  public final void onResponse(DataStoreResponse<CollectionTemplate<ROW_DATA_MODEL, com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata>> paramDataStoreResponse)
  {
    if (error != null)
    {
      this$0.arrayAdapter.showLoadingView(false);
      Log.e(EntityViewAllListBaseFragment.access$000(), "Error fetching load more data: " + error.getMessage());
      return;
    }
    onSuccess((CollectionTemplate)model, type, request.trackingSessionId);
  }
  
  public final void onSuccess(CollectionTemplate<ROW_DATA_MODEL, com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata> paramCollectionTemplate, DataStore.Type paramType, String paramString)
  {
    int j = 1;
    boolean bool;
    if (paramType == DataStore.Type.LOCAL)
    {
      bool = true;
      RUMTiming.renderStart(paramString, bool);
      this$0.arrayAdapter.showLoadingView(false);
      paramType = transformModels(paramCollectionTemplate.copyWithNewElements(elements));
      if ((hasPaging) && (paging.start != 0)) {
        break label74;
      }
    }
    label74:
    for (int i = 1;; i = 0)
    {
      if (paramType != null) {
        break label80;
      }
      return;
      bool = false;
      break;
    }
    label80:
    if ((i != 0) && (!bool)) {}
    for (i = j;; i = 0)
    {
      if (i != 0)
      {
        this$0.arrayAdapter.clearValues();
        paramCollectionTemplate = this$0.getHeaderViewModels();
        if (paramCollectionTemplate != null) {
          this$0.arrayAdapter.appendValues(paramCollectionTemplate);
        }
      }
      this$0.arrayAdapter.appendValues(paramType);
      RUMHelper.callRenderEndOnNextLoop(paramString, bool);
      return;
    }
  }
  
  public abstract List<? extends ViewModel> transformModels(CollectionTemplate<ROW_DATA_MODEL, com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata> paramCollectionTemplate);
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.EntityViewAllListBaseFragment.DataLoadListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */