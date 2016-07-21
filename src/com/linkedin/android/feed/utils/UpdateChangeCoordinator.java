package com.linkedin.android.feed.utils;

import android.support.v4.util.ArrayMap;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.consistency.ConsistencyManager;
import com.linkedin.consistency.ModelListConsistencyCoordinator;
import com.linkedin.data.lite.DataTemplate;
import java.util.Map;

public final class UpdateChangeCoordinator
  extends ModelListConsistencyCoordinator<Update>
{
  private final FlagshipApplication app;
  public final Map<String, UpdateActionModel> collapsedUpdates = new ArrayMap();
  
  public UpdateChangeCoordinator(FlagshipApplication paramFlagshipApplication, ConsistencyManager paramConsistencyManager)
  {
    super(paramConsistencyManager);
    app = paramFlagshipApplication;
  }
  
  protected final void handleTypeDiscrepancy(Class<? extends DataTemplate> paramClass1, Class<? extends DataTemplate> paramClass2, String paramString)
  {
    Util.safeThrow$7a8b4789(new IllegalArgumentException(makeTypeDiscrepancyMessage(paramClass1, paramClass2, paramString)));
  }
  
  public final void setCollapsed(Urn paramUrn, UpdateActionModel paramUpdateActionModel)
  {
    if (paramUrn != null) {
      collapsedUpdates.put(paramUrn.toString(), paramUpdateActionModel);
    }
  }
  
  public final void setExpanded(Urn paramUrn)
  {
    if (paramUrn != null) {
      collapsedUpdates.remove(paramUrn.toString());
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.utils.UpdateChangeCoordinator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */