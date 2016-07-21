package com.linkedin.android.pegasus.gen.voyager.common;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class MySettingsBuilder
  implements FissileDataModelBuilder<MySettings>, DataTemplateBuilder<MySettings>
{
  public static final MySettingsBuilder INSTANCE = new MySettingsBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("discloseAsProfileViewer");
    JSON_KEY_STORE.put("flagshipCrossLinkToJobSearchApp");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.MySettingsBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */