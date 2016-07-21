package com.linkedin.android.tracking.v2.event;

import android.support.v4.util.Pair;
import android.util.Base64;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.tracking.v2.utils.DataUtils;
import java.util.UUID;

public class PageInstance
{
  private static final String TAG = PageInstance.class.getSimpleName();
  public final String pageKey;
  public final UUID trackingId;
  
  public PageInstance(Tracker paramTracker, String paramString, UUID paramUUID)
  {
    this(trackingCodePrefix + '_' + paramString, paramUUID);
  }
  
  public PageInstance(String paramString, UUID paramUUID)
  {
    pageKey = paramString;
    trackingId = paramUUID;
  }
  
  public static Pair<String, String> createPageUrnAndTrackingIdFromString(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      paramString = paramString.split("\\;");
    } while (paramString.length != 2);
    try
    {
      paramString = new Pair(paramString[0], paramString[1]);
      return paramString;
    }
    catch (NullPointerException paramString)
    {
      Log.e(TAG, "Cannot create pageInstance", paramString);
      return null;
    }
    catch (IllegalArgumentException paramString)
    {
      for (;;) {}
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof PageInstance))) {}
    do
    {
      return false;
      paramObject = (PageInstance)paramObject;
    } while ((!pageKey.equals(pageKey)) || (!trackingId.equals(trackingId)));
    return true;
  }
  
  public final String toHeaderString()
  {
    return "urn:li:page:" + pageKey + ';' + Base64.encodeToString(DataUtils.uuidToBytes(trackingId), 2);
  }
  
  public String toString()
  {
    return "pageKey: " + pageKey + ", trackingId: " + trackingId.toString();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.tracking.v2.event.PageInstance
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */