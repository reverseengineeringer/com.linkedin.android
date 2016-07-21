package com.linkedin.android.growth.takeover;

import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.common.Takeover;
import com.linkedin.android.pegasus.gen.voyager.common.TakeoverType;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

public final class NewToVoyagerTransactionalLaunchManager
{
  public final FlagshipDataManager dataManager;
  private final Bus eventBus;
  
  @Inject
  public NewToVoyagerTransactionalLaunchManager(Bus paramBus, FlagshipDataManager paramFlagshipDataManager)
  {
    eventBus = paramBus;
    dataManager = paramFlagshipDataManager;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.takeover.NewToVoyagerTransactionalLaunchManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */