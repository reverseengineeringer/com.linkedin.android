package com.linkedin.android.infra.network;

import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.LaunchAlertEvent;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.voyager.common.Configuration;
import com.linkedin.android.pegasus.gen.voyager.common.MediaConfig;
import com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorConfig;
import com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorSize;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.inject.Inject;

public class ConfigurationManager
{
  public static final String TAG = ConfigurationManager.class.getSimpleName();
  private final Bus bus;
  public final FlagshipDataManager dataManager;
  private final ImageQualityManager imageQualityManager;
  public final Tracker tracker;
  
  @Inject
  public ConfigurationManager(FlagshipDataManager paramFlagshipDataManager, ImageQualityManager paramImageQualityManager, Bus paramBus, Tracker paramTracker)
  {
    dataManager = paramFlagshipDataManager;
    imageQualityManager = paramImageQualityManager;
    bus = paramBus;
    tracker = paramTracker;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.network.ConfigurationManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */