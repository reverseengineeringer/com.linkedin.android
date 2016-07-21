package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class AppActor
  implements FissileDataModel<AppActor>, RecordTemplate<AppActor>
{
  public static final AppActorBuilder BUILDER = AppActorBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final Image appIcon;
  public final String appId;
  public final String appName;
  public final String deeplink;
  public final boolean hasAppIcon;
  public final boolean hasAppId;
  public final boolean hasAppName;
  public final boolean hasDeeplink;
  public final boolean hasShowActionButton;
  public final boolean hasStoreUrl;
  public final boolean hasSubtitle;
  public final boolean showActionButton;
  public final String storeUrl;
  public final String subtitle;
  
  AppActor(String paramString1, String paramString2, String paramString3, Image paramImage, String paramString4, String paramString5, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8)
  {
    appId = paramString1;
    appName = paramString2;
    subtitle = paramString3;
    appIcon = paramImage;
    deeplink = paramString4;
    storeUrl = paramString5;
    showActionButton = paramBoolean1;
    hasAppId = paramBoolean2;
    hasAppName = paramBoolean3;
    hasSubtitle = paramBoolean4;
    hasAppIcon = paramBoolean5;
    hasDeeplink = paramBoolean6;
    hasStoreUrl = paramBoolean7;
    hasShowActionButton = paramBoolean8;
    _cachedId = null;
  }
  
  public final AppActor accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasAppId)
    {
      paramDataProcessor.startRecordField$505cff1c("appId");
      paramDataProcessor.processString(appId);
    }
    if (hasAppName)
    {
      paramDataProcessor.startRecordField$505cff1c("appName");
      paramDataProcessor.processString(appName);
    }
    if (hasSubtitle)
    {
      paramDataProcessor.startRecordField$505cff1c("subtitle");
      paramDataProcessor.processString(subtitle);
    }
    Image localImage = null;
    boolean bool = false;
    if (hasAppIcon)
    {
      paramDataProcessor.startRecordField$505cff1c("appIcon");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label243;
      }
      localImage = appIcon.accept(paramDataProcessor);
      if (localImage == null) {
        break label260;
      }
    }
    label243:
    label260:
    for (bool = true;; bool = false)
    {
      if (hasDeeplink)
      {
        paramDataProcessor.startRecordField$505cff1c("deeplink");
        paramDataProcessor.processString(deeplink);
      }
      if (hasStoreUrl)
      {
        paramDataProcessor.startRecordField$505cff1c("storeUrl");
        paramDataProcessor.processString(storeUrl);
      }
      if (hasShowActionButton)
      {
        paramDataProcessor.startRecordField$505cff1c("showActionButton");
        paramDataProcessor.processBoolean(showActionButton);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label437;
      }
      try
      {
        if (hasAppId) {
          break label265;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.AppActor", "appId");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localImage = (Image)paramDataProcessor.processDataTemplate(appIcon);
      break;
    }
    label265:
    if (!hasAppName) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.AppActor", "appName");
    }
    if (!hasSubtitle) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.AppActor", "subtitle");
    }
    if (!hasAppIcon) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.AppActor", "appIcon");
    }
    if (!hasDeeplink) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.AppActor", "deeplink");
    }
    if (!hasStoreUrl) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.AppActor", "storeUrl");
    }
    if (!hasShowActionButton) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.AppActor", "showActionButton");
    }
    return new AppActor(appId, appName, subtitle, localImage, deeplink, storeUrl, showActionButton, hasAppId, hasAppName, hasSubtitle, bool, hasDeeplink, hasStoreUrl, hasShowActionButton);
    label437:
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (AppActor)paramObject;
      if (appId != null)
      {
        if (appId.equals(appId)) {}
      }
      else {
        while (appId != null) {
          return false;
        }
      }
      if (appName != null)
      {
        if (appName.equals(appName)) {}
      }
      else {
        while (appName != null) {
          return false;
        }
      }
      if (subtitle != null)
      {
        if (subtitle.equals(subtitle)) {}
      }
      else {
        while (subtitle != null) {
          return false;
        }
      }
      if (appIcon != null)
      {
        if (appIcon.equals(appIcon)) {}
      }
      else {
        while (appIcon != null) {
          return false;
        }
      }
      if (deeplink != null)
      {
        if (deeplink.equals(deeplink)) {}
      }
      else {
        while (deeplink != null) {
          return false;
        }
      }
      if (storeUrl != null)
      {
        if (storeUrl.equals(storeUrl)) {}
      }
      else {
        while (storeUrl != null) {
          return false;
        }
      }
    } while (showActionButton == showActionButton);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasAppId) {
      i = PegasusBinaryUtils.getEncodedLength(appId) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasAppName) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(appName);
    }
    j = i + 1;
    i = j;
    if (hasSubtitle) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(subtitle);
    }
    j = i + 1;
    i = j;
    if (hasAppIcon)
    {
      i = j + 1;
      if (appIcon._cachedId == null) {
        break label204;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(appIcon._cachedId);
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasDeeplink) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(deeplink);
      }
      j = i + 1;
      i = j;
      if (hasStoreUrl) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(storeUrl);
      }
      j = i + 1;
      i = j;
      if (hasShowActionButton) {
        i = j + 1;
      }
      __sizeOfObject = i;
      return i;
      label204:
      i += appIcon.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i2 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    label76:
    int n;
    if (appId != null)
    {
      i = appId.hashCode();
      if (appName == null) {
        break label170;
      }
      j = appName.hashCode();
      if (subtitle == null) {
        break label175;
      }
      k = subtitle.hashCode();
      if (appIcon == null) {
        break label180;
      }
      m = appIcon.hashCode();
      if (deeplink == null) {
        break label186;
      }
      n = deeplink.hashCode();
      label92:
      if (storeUrl == null) {
        break label192;
      }
    }
    label170:
    label175:
    label180:
    label186:
    label192:
    for (int i1 = storeUrl.hashCode();; i1 = 0)
    {
      if (showActionButton) {
        i2 = 1;
      }
      i = (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31 + i2;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
      m = 0;
      break label76;
      n = 0;
      break label92;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public final void writeToFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, boolean paramBoolean, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    paramFissionAdapter.willWriteModel$30d0b508(this, paramBoolean);
    String str = _cachedId;
    if ((str == null) && (paramString == null) && (paramByteBuffer == null)) {
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building AppActor");
    }
    if (paramBoolean)
    {
      if (paramString != null) {
        paramFissionAdapter.writeToCache(paramString, null, 0, paramFissionTransaction);
      }
      if (str != null) {
        paramFissionAdapter.writeToCache(str, null, 0, paramFissionTransaction);
      }
    }
    label162:
    label188:
    label248:
    label274:
    label300:
    label324:
    label376:
    label386:
    label396:
    label421:
    label431:
    label441:
    label451:
    label457:
    label465:
    label467:
    do
    {
      ByteBuffer localByteBuffer;
      for (;;)
      {
        return;
        localByteBuffer = paramByteBuffer;
        if (paramByteBuffer == null) {
          localByteBuffer = paramFissionAdapter.getBuffer(getSerializedSize());
        }
        localByteBuffer.put((byte)1);
        localByteBuffer.putInt(1429191708);
        if (hasAppId)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, appId);
          if (!hasAppName) {
            break label376;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, appName);
          if (!hasSubtitle) {
            break label386;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, subtitle);
          if (!hasAppIcon) {
            break label421;
          }
          localByteBuffer.put((byte)1);
          if (appIcon._cachedId == null) {
            break label396;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, appIcon._cachedId);
          appIcon.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasDeeplink) {
            break label431;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, deeplink);
          if (!hasStoreUrl) {
            break label441;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, storeUrl);
          if (!hasShowActionButton) {
            break label457;
          }
          localByteBuffer.put((byte)1);
          if (!showActionButton) {
            break label451;
          }
          i = 1;
          localByteBuffer.put((byte)i);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label465;
          }
          if (str != null) {
            break label467;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label162;
          localByteBuffer.put((byte)0);
          break label188;
          localByteBuffer.put((byte)1);
          appIcon.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label248;
          localByteBuffer.put((byte)0);
          break label248;
          localByteBuffer.put((byte)0);
          break label274;
          localByteBuffer.put((byte)0);
          break label300;
          i = 0;
          break label324;
          localByteBuffer.put((byte)0);
        }
      }
      paramFissionAdapter.writeToCache(str, localByteBuffer, getSerializedSize(), paramFissionTransaction);
      paramFissionAdapter.recycle(localByteBuffer);
    } while ((paramString == null) || (str.equals(paramString)));
    int i = PegasusBinaryUtils.getEncodedLength(str) + 3;
    paramByteBuffer = paramFissionAdapter.getBuffer(i);
    paramByteBuffer.put((byte)0);
    paramFissionAdapter.writeString(paramByteBuffer, str);
    paramFissionAdapter.writeToCache(paramString, paramByteBuffer, i, paramFissionTransaction);
    paramFissionAdapter.recycle(paramByteBuffer);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.AppActor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */