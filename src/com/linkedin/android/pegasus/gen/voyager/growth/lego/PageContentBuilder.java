package com.linkedin.android.pegasus.gen.voyager.growth.lego;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class PageContentBuilder
  implements FissileDataModelBuilder<PageContent>, DataTemplateBuilder<PageContent>
{
  public static final PageContentBuilder INSTANCE = new PageContentBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("slots");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.lego.PageContentBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */