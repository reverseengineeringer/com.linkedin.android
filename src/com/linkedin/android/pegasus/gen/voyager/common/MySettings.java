package com.linkedin.android.pegasus.gen.voyager.common;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class MySettings
  implements FissileDataModel<MySettings>, RecordTemplate<MySettings>
{
  public static final MySettingsBuilder BUILDER = MySettingsBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final DiscloseAsProfileViewerInfo discloseAsProfileViewer;
  public final Urn entityUrn;
  public final boolean flagshipCrossLinkToJobSearchApp;
  public final boolean hasDiscloseAsProfileViewer;
  public final boolean hasEntityUrn;
  public final boolean hasFlagshipCrossLinkToJobSearchApp;
  
  MySettings(Urn paramUrn, DiscloseAsProfileViewerInfo paramDiscloseAsProfileViewerInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    entityUrn = paramUrn;
    discloseAsProfileViewer = paramDiscloseAsProfileViewerInfo;
    flagshipCrossLinkToJobSearchApp = paramBoolean1;
    hasEntityUrn = paramBoolean2;
    hasDiscloseAsProfileViewer = paramBoolean3;
    hasFlagshipCrossLinkToJobSearchApp = paramBoolean4;
    paramDiscloseAsProfileViewerInfo = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
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
      paramObject = (MySettings)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (discloseAsProfileViewer != null)
      {
        if (discloseAsProfileViewer.equals(discloseAsProfileViewer)) {}
      }
      else {
        while (discloseAsProfileViewer != null) {
          return false;
        }
      }
    } while (flagshipCrossLinkToJobSearchApp == flagshipCrossLinkToJobSearchApp);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasEntityUrn)
    {
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasDiscloseAsProfileViewer) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasFlagshipCrossLinkToJobSearchApp) {
      i = j + 1;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (discloseAsProfileViewer == null) {
        break label81;
      }
    }
    label81:
    for (int j = discloseAsProfileViewer.hashCode();; j = 0)
    {
      if (flagshipCrossLinkToJobSearchApp) {
        k = 1;
      }
      i = (j + (i + 527) * 31) * 31 + k;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public final void writeToFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, boolean paramBoolean, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    int i = 1;
    paramFissionAdapter.willWriteModel$30d0b508(this, paramBoolean);
    String str = _cachedId;
    if ((str == null) && (paramString == null) && (paramByteBuffer == null)) {
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building MySettings");
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
    label176:
    label197:
    label249:
    label259:
    label265:
    label273:
    label275:
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
        localByteBuffer.putInt(202602188);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasDiscloseAsProfileViewer) {
            break label249;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, discloseAsProfileViewer.ordinal());
          if (!hasFlagshipCrossLinkToJobSearchApp) {
            break label265;
          }
          localByteBuffer.put((byte)1);
          if (!flagshipCrossLinkToJobSearchApp) {
            break label259;
          }
          localByteBuffer.put((byte)i);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label273;
          }
          if (str != null) {
            break label275;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label176;
          i = 0;
          break label197;
          localByteBuffer.put((byte)0);
        }
      }
      paramFissionAdapter.writeToCache(str, localByteBuffer, getSerializedSize(), paramFissionTransaction);
      paramFissionAdapter.recycle(localByteBuffer);
    } while ((paramString == null) || (str.equals(paramString)));
    i = PegasusBinaryUtils.getEncodedLength(str) + 3;
    paramByteBuffer = paramFissionAdapter.getBuffer(i);
    paramByteBuffer.put((byte)0);
    paramFissionAdapter.writeString(paramByteBuffer, str);
    paramFissionAdapter.writeToCache(paramString, paramByteBuffer, i, paramFissionTransaction);
    paramFissionAdapter.recycle(paramByteBuffer);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.MySettings
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */