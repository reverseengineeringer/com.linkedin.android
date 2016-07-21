package com.linkedin.android.feed.page.feed;

import android.os.Bundle;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

public final class FeedBundleBuilder
  implements BundleBuilder
{
  public final Bundle bundle = new Bundle();
  
  public static String[] getHighlightedTypes(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    return paramBundle.getStringArray("highlightedUpdateTypes");
  }
  
  public static String[] getHighlightedUrns(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    return paramBundle.getStringArray("highlightedUpdateUrns");
  }
  
  public static void loadUpdateFromCache(FlagshipDataManager paramFlagshipDataManager, RecordTemplateListener<Update> paramRecordTemplateListener, String paramString)
  {
    paramFlagshipDataManager.submit(Request.get().cacheKey(paramString).builder(Update.BUILDER).listener(paramRecordTemplateListener).filter(DataManager.DataStoreFilter.LOCAL_ONLY));
  }
  
  public static void saveCommentToCache(FlagshipDataManager paramFlagshipDataManager, Comment paramComment)
  {
    paramFlagshipDataManager.submit(Request.put().cacheKey(entityUrn.toString()).model(paramComment).filter(DataManager.DataStoreFilter.LOCAL_ONLY));
  }
  
  public static void saveUpdateToCache(FlagshipDataManager paramFlagshipDataManager, Update paramUpdate)
  {
    paramFlagshipDataManager.submit(Request.put().cacheKey(entityUrn.toString()).model(paramUpdate).filter(DataManager.DataStoreFilter.LOCAL_ONLY));
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.FeedBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */