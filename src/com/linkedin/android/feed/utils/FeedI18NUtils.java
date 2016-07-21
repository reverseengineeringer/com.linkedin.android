package com.linkedin.android.feed.utils;

import android.support.v4.util.ArrayMap;
import android.text.style.ClickableSpan;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.ui.spans.EntityClickableSpan;
import com.linkedin.android.infra.ui.spans.TrackingClickableSpan;
import java.util.Map;

public final class FeedI18NUtils
{
  public static CharSequence attachActorSpan$282a9181(CharSequence paramCharSequence, EntityClickableSpan paramEntityClickableSpan)
  {
    return I18NManager.attachSpan(paramCharSequence, paramEntityClickableSpan, "<actorName>", "</actorName>");
  }
  
  public static CharSequence attachGroupSpan$2e4942b(CharSequence paramCharSequence, TrackingClickableSpan paramTrackingClickableSpan)
  {
    return I18NManager.attachSpan(paramCharSequence, paramTrackingClickableSpan, "<group>", "</group>");
  }
  
  public static CharSequence attachObjectSpan$7d2fa065(CharSequence paramCharSequence, ClickableSpan paramClickableSpan)
  {
    return I18NManager.attachSpan(paramCharSequence, paramClickableSpan, "<objectName>", "</objectName>");
  }
  
  public static Map<String, Object> createActorObjectMap(String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    if (paramMap == null) {
      paramMap = new ArrayMap(2);
    }
    for (;;)
    {
      paramMap.put("actorName", paramString1);
      paramMap.put("actorType", paramString2);
      return paramMap;
    }
  }
  
  public static Map<String, Object> createGroupObjectMap$38243ca5(String paramString)
  {
    ArrayMap localArrayMap = new ArrayMap(1);
    localArrayMap.put("group", paramString);
    return localArrayMap;
  }
  
  public static CharSequence translateActorString(I18NManager paramI18NManager, int paramInt, String paramString1, String paramString2, EntityClickableSpan paramEntityClickableSpan, Map<String, Object> paramMap)
  {
    paramI18NManager = paramI18NManager.getString(paramInt, createActorObjectMap(paramString1, paramString2, paramMap));
    if (paramEntityClickableSpan != null) {
      return attachActorSpan$282a9181(paramI18NManager, paramEntityClickableSpan);
    }
    return I18NManager.removeSpanTag(paramI18NManager, "<actorName>", "</actorName>");
  }
  
  public static CharSequence translateActorString$4fa0acfe(I18NManager paramI18NManager, int paramInt, String paramString1, String paramString2)
  {
    return translateActorString(paramI18NManager, paramInt, paramString1, paramString2, null, null);
  }
  
  public static CharSequence translateCommenterString(I18NManager paramI18NManager, int paramInt, String paramString1, String paramString2, EntityClickableSpan paramEntityClickableSpan, Map<String, Object> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new ArrayMap(2);
    }
    ((Map)localObject).put("commenterName", paramString1);
    ((Map)localObject).put("commenterType", paramString2);
    paramI18NManager = paramI18NManager.getString(paramInt, (Map)localObject);
    if (paramEntityClickableSpan != null) {
      return I18NManager.attachSpan(paramI18NManager, paramEntityClickableSpan, "<commenterName>", "</commenterName>");
    }
    return I18NManager.removeSpanTag(paramI18NManager, "<commenterName>", "</commenterName>");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.utils.FeedI18NUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */