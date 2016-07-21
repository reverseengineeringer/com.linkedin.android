package com.linkedin.android.publishing.reader;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

public final class ArticleBundle
  implements BundleBuilder
{
  private final Bundle bundle = new Bundle();
  
  public ArticleBundle(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Update paramUpdate)
  {
    bundle.putString("urn", paramString1);
    bundle.putString("url", paramString2);
    bundle.putString("title", paramString3);
    bundle.putString("subtitle", paramString4);
    bundle.putString("pageKeySuffix", paramString5);
    if (paramUpdate != null) {
      RecordParceler.quietParcel(paramUpdate, "update", bundle);
    }
  }
  
  public static ArticleBundle createFeedViewer(String paramString1, String paramString2, String paramString3, String paramString4, Update paramUpdate)
  {
    return new ArticleBundle(paramString1, paramString2, paramString3, paramString4, null, paramUpdate);
  }
  
  public static String getTitle(Bundle paramBundle)
  {
    return paramBundle.getString("title", "");
  }
  
  public static Update getUpdate(Bundle paramBundle)
  {
    return (Update)RecordParceler.quietUnparcel(Update.BUILDER, "update", paramBundle);
  }
  
  public static String getUrl(Bundle paramBundle)
  {
    return paramBundle.getString("url", "");
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.publishing.reader.ArticleBundle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */