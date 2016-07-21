package com.linkedin.android.growth.newtovoyager;

import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.GroupContent;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.PageContent;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.SlotContent;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.WidgetContent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class NewToVoyagerManager
{
  public final FlagshipDataManager dataManager;
  final FlagshipSharedPreferences flagshipSharedPreferences;
  public final Tracker tracker;
  
  public NewToVoyagerManager(FlagshipDataManager paramFlagshipDataManager, FlagshipSharedPreferences paramFlagshipSharedPreferences, Tracker paramTracker)
  {
    dataManager = paramFlagshipDataManager;
    flagshipSharedPreferences = paramFlagshipSharedPreferences;
    tracker = paramTracker;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.NewToVoyagerManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */