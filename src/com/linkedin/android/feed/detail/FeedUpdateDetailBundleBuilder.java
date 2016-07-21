package com.linkedin.android.feed.detail;

import android.os.Bundle;
import com.linkedin.android.feed.utils.FeedUpdateUtils;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.DiscussionUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.Update.Value;

public final class FeedUpdateDetailBundleBuilder
  implements BundleBuilder
{
  public final Bundle bundle = new Bundle();
  
  private FeedUpdateDetailBundleBuilder(String paramString, Urn paramUrn, int paramInt)
  {
    bundle.putString("updateUrn", paramString);
    bundle.putInt("feedType", paramInt);
    if (paramUrn != null) {
      bundle.putString("updateEntityUrn", paramUrn.toString());
    }
  }
  
  public static FeedUpdateDetailBundleBuilder create(String paramString, Urn paramUrn)
  {
    return new FeedUpdateDetailBundleBuilder(paramString, paramUrn, 1);
  }
  
  public static FeedUpdateDetailBundleBuilder create(String paramString, Urn paramUrn, Update paramUpdate)
  {
    paramString = create(paramString, paramUrn);
    if (paramUpdate != null)
    {
      RecordParceler.quietParcel(paramUpdate, "update", bundle);
      if (entityUrn != null) {
        bundle.putString("updateEntityUrn", entityUrn.toString());
      }
      bundle.putString("updateUrn", urn.toString());
      paramUrn = FeedUpdateUtils.getGroupDiscussionUpdate(paramUpdate);
      if (paramUrn == null) {
        break label97;
      }
      bundle.putString("updateUrn", urn.toString());
      bundle.putInt("feedType", 9);
    }
    label97:
    while (value.propUpdateValue == null) {
      return paramString;
    }
    bundle.putInt("feedType", 8);
    return paramString;
  }
  
  public static FeedUpdateDetailBundleBuilder create$69efdd29(String paramString, int paramInt)
  {
    return new FeedUpdateDetailBundleBuilder(paramString, null, paramInt);
  }
  
  public static int getFeedType(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return 1;
    }
    return paramBundle.getInt("feedType");
  }
  
  public static String getViralUpdateUrn(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    return paramBundle.getString("viralUpdateUrn");
  }
  
  public final FeedUpdateDetailBundleBuilder anchor(int paramInt)
  {
    bundle.putInt("anchorPoint", paramInt);
    return this;
  }
  
  public final Bundle build()
  {
    return bundle;
  }
  
  public final FeedUpdateDetailBundleBuilder highlightedCommentUrns(String[] paramArrayOfString)
  {
    bundle.putStringArray("highlightedCommentUrns", paramArrayOfString);
    return this;
  }
  
  public final FeedUpdateDetailBundleBuilder highlightedReplyUrns(String[] paramArrayOfString)
  {
    bundle.putStringArray("highlightedReplyUrns", paramArrayOfString);
    return this;
  }
  
  public final FeedUpdateDetailBundleBuilder trackingId(String paramString)
  {
    bundle.putString("trackingId", paramString);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.detail.FeedUpdateDetailBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */