package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ProfileViewer
  implements FissileDataModel<ProfileViewer>, UnionTemplate<ProfileViewer>
{
  public static final ProfileViewerBuilder BUILDER = ProfileViewerBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final FullProfileViewer fullProfileViewerValue;
  public final boolean hasFullProfileViewerValue;
  public final boolean hasObfuscatedProfileViewerValue;
  public final ObfuscatedProfileViewer obfuscatedProfileViewerValue;
  
  ProfileViewer(FullProfileViewer paramFullProfileViewer, ObfuscatedProfileViewer paramObfuscatedProfileViewer, boolean paramBoolean1, boolean paramBoolean2)
  {
    fullProfileViewerValue = paramFullProfileViewer;
    obfuscatedProfileViewerValue = paramObfuscatedProfileViewer;
    hasFullProfileViewerValue = paramBoolean1;
    hasObfuscatedProfileViewerValue = paramBoolean2;
    _cachedId = null;
  }
  
  public final ProfileViewer accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    if (hasFullProfileViewerValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.FullProfileViewer");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = fullProfileViewerValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label149;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label56:
      localObject1 = null;
      bool2 = false;
      if (hasObfuscatedProfileViewerValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.me.ObfuscatedProfileViewer");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label158;
        }
        localObject1 = obfuscatedProfileViewerValue.accept(paramDataProcessor);
        label95:
        if (localObject1 == null) {
          break label176;
        }
      }
    }
    label149:
    label158:
    label176:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endUnion();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label181;
      }
      return new ProfileViewer((FullProfileViewer)localObject2, (ObfuscatedProfileViewer)localObject1, bool1, bool2);
      localObject1 = (FullProfileViewer)paramDataProcessor.processDataTemplate(fullProfileViewerValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (ObfuscatedProfileViewer)paramDataProcessor.processDataTemplate(obfuscatedProfileViewerValue);
      break label95;
    }
    label181:
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
      paramObject = (ProfileViewer)paramObject;
      if (fullProfileViewerValue != null)
      {
        if (fullProfileViewerValue.equals(fullProfileViewerValue)) {}
      }
      else {
        while (fullProfileViewerValue != null) {
          return false;
        }
      }
      if (obfuscatedProfileViewerValue == null) {
        break;
      }
    } while (obfuscatedProfileViewerValue.equals(obfuscatedProfileViewerValue));
    for (;;)
    {
      return false;
      if (obfuscatedProfileViewerValue == null) {
        break;
      }
    }
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasFullProfileViewerValue)
    {
      if (fullProfileViewerValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(fullProfileViewerValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasObfuscatedProfileViewerValue)
      {
        i = j + 1;
        if (obfuscatedProfileViewerValue._cachedId == null) {
          break label114;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(obfuscatedProfileViewerValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = fullProfileViewerValue.getSerializedSize() + 7;
      break;
      label114:
      i += obfuscatedProfileViewerValue.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (fullProfileViewerValue != null) {}
    for (int i = fullProfileViewerValue.hashCode();; i = 0)
    {
      if (obfuscatedProfileViewerValue != null) {
        j = obfuscatedProfileViewerValue.hashCode();
      }
      i = (i + 527) * 31 + j;
      _cachedHashCode = i;
      return i;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ProfileViewer");
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
    label298:
    label323:
    label331:
    label333:
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
        localByteBuffer.putInt(-1554082799);
        if (hasFullProfileViewerValue)
        {
          localByteBuffer.put((byte)1);
          if (fullProfileViewerValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, fullProfileViewerValue._cachedId);
            fullProfileViewerValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasObfuscatedProfileViewerValue) {
              break label323;
            }
            localByteBuffer.put((byte)1);
            if (obfuscatedProfileViewerValue._cachedId == null) {
              break label298;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, obfuscatedProfileViewerValue._cachedId);
            obfuscatedProfileViewerValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label331;
          }
          if (str != null) {
            break label333;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          fullProfileViewerValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          obfuscatedProfileViewerValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          continue;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.ProfileViewer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */