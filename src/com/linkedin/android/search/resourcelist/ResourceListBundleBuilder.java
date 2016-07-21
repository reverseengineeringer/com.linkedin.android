package com.linkedin.android.search.resourcelist;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.voyager.common.Industry;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.JsonGeneratorException;

public class ResourceListBundleBuilder
  implements BundleBuilder
{
  private static final String TAG = ResourceListBundleBuilder.class.getSimpleName();
  private Bundle bundle = new Bundle();
  
  public static ResourceListBundleBuilder create$74ee3329()
  {
    ResourceListBundleBuilder localResourceListBundleBuilder = new ResourceListBundleBuilder();
    bundle.putInt("type", 1);
    return localResourceListBundleBuilder;
  }
  
  public static String getCustomPageKey(Bundle paramBundle)
  {
    if (paramBundle != null) {
      return paramBundle.getString("custom_page_key");
    }
    return null;
  }
  
  public static Industry getIndustry(Bundle paramBundle)
  {
    if (paramBundle != null) {
      try
      {
        paramBundle = (Industry)RecordParceler.unparcel(Industry.BUILDER, "resource_pick_entity", paramBundle);
        return paramBundle;
      }
      catch (DataReaderException paramBundle)
      {
        return null;
      }
    }
    return null;
  }
  
  public static int getType(Bundle paramBundle)
  {
    int i = 2;
    if (paramBundle != null) {
      i = paramBundle.getInt("type", 2);
    }
    return i;
  }
  
  public final Bundle build()
  {
    return bundle;
  }
  
  public final ResourceListBundleBuilder setCustomPageKey(String paramString)
  {
    bundle.putString("custom_page_key", paramString);
    return this;
  }
  
  public final ResourceListBundleBuilder setIndustry(Industry paramIndustry)
  {
    try
    {
      RecordParceler.parcel(paramIndustry, "resource_pick_entity", bundle);
      return this;
    }
    catch (JsonGeneratorException paramIndustry)
    {
      Log.d(TAG, "can't set industry");
    }
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.search.resourcelist.ResourceListBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */