package com.linkedin.android.infra.network;

import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.LaunchAlertEvent;
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

public final class ConfigurationManager$1
  implements RecordTemplateListener<Configuration>
{
  public ConfigurationManager$1(ConfigurationManager paramConfigurationManager) {}
  
  public final void onResponse(DataStoreResponse<Configuration> paramDataStoreResponse)
  {
    if ((type == DataStore.Type.NETWORK) && (error != null)) {
      Log.e(ConfigurationManager.access$000(), "Failed to load Configuration model", error);
    }
    Configuration localConfiguration;
    do
    {
      return;
      localConfiguration = (Configuration)model;
    } while (localConfiguration == null);
    ImageQualityManager localImageQualityManager = ConfigurationManager.access$100(this$0);
    Object localObject1 = mediaConfig.mprConfig;
    filters = filters;
    ratioToSizes = new TreeMap();
    Iterator localIterator = sizes.iterator();
    label95:
    MediaProcessorSize localMediaProcessorSize;
    float f;
    Object localObject2;
    if (localIterator.hasNext())
    {
      localMediaProcessorSize = (MediaProcessorSize)localIterator.next();
      f = width / height;
      localObject1 = ratioToSizes.keySet().iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (Float)((Iterator)localObject1).next();
      } while (Math.abs(f - ((Float)localObject2).floatValue()) >= 5.96E-8F);
    }
    for (localObject1 = (SortedSet)ratioToSizes.get(localObject2);; localObject1 = null)
    {
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new TreeSet(comparator);
        ratioToSizes.put(Float.valueOf(f), localObject2);
      }
      ((SortedSet)localObject2).add(localMediaProcessorSize);
      break label95;
      ratioToSizes = Collections.unmodifiableSortedMap(ratioToSizes);
      Log.i(ConfigurationManager.access$000(), "Loaded Configuration model from " + type);
      if (launchAlert == null) {
        break;
      }
      Log.i(ConfigurationManager.access$000(), "Received LaunchAlert from the server, firing event");
      ConfigurationManager.access$200(this$0);
      Bus.publish(new LaunchAlertEvent(launchAlert));
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.network.ConfigurationManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */