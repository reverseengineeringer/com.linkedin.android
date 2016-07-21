package com.linkedin.android.pegasus.gen.voyager.identity.shared;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.networkHighlights.NetworkHighlight;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.ProfileHighlight;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Highlight$Detail
  implements FissileDataModel<Detail>, UnionTemplate<Detail>
{
  public static final HighlightBuilder.DetailBuilder BUILDER = HighlightBuilder.DetailBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasNetworkHighlightValue;
  public final boolean hasProfileHighlightValue;
  public final NetworkHighlight networkHighlightValue;
  public final ProfileHighlight profileHighlightValue;
  
  Highlight$Detail(ProfileHighlight paramProfileHighlight, NetworkHighlight paramNetworkHighlight, boolean paramBoolean1, boolean paramBoolean2)
  {
    profileHighlightValue = paramProfileHighlight;
    networkHighlightValue = paramNetworkHighlight;
    hasProfileHighlightValue = paramBoolean1;
    hasNetworkHighlightValue = paramBoolean2;
    _cachedId = null;
  }
  
  public final Detail accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    if (hasProfileHighlightValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.shared.profileHighlights.ProfileHighlight");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = profileHighlightValue.accept(paramDataProcessor);
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
      if (hasNetworkHighlightValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.shared.networkHighlights.NetworkHighlight");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label158;
        }
        localObject1 = networkHighlightValue.accept(paramDataProcessor);
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
      return new Detail((ProfileHighlight)localObject2, (NetworkHighlight)localObject1, bool1, bool2);
      localObject1 = (ProfileHighlight)paramDataProcessor.processDataTemplate(profileHighlightValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (NetworkHighlight)paramDataProcessor.processDataTemplate(networkHighlightValue);
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
      paramObject = (Detail)paramObject;
      if (profileHighlightValue != null)
      {
        if (profileHighlightValue.equals(profileHighlightValue)) {}
      }
      else {
        while (profileHighlightValue != null) {
          return false;
        }
      }
      if (networkHighlightValue == null) {
        break;
      }
    } while (networkHighlightValue.equals(networkHighlightValue));
    for (;;)
    {
      return false;
      if (networkHighlightValue == null) {
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
    if (hasProfileHighlightValue)
    {
      if (profileHighlightValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(profileHighlightValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasNetworkHighlightValue)
      {
        i = j + 1;
        if (networkHighlightValue._cachedId == null) {
          break label114;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(networkHighlightValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = profileHighlightValue.getSerializedSize() + 7;
      break;
      label114:
      i += networkHighlightValue.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (profileHighlightValue != null) {}
    for (int i = profileHighlightValue.hashCode();; i = 0)
    {
      if (networkHighlightValue != null) {
        j = networkHighlightValue.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Detail");
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
        localByteBuffer.putInt(-1140694555);
        if (hasProfileHighlightValue)
        {
          localByteBuffer.put((byte)1);
          if (profileHighlightValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, profileHighlightValue._cachedId);
            profileHighlightValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasNetworkHighlightValue) {
              break label323;
            }
            localByteBuffer.put((byte)1);
            if (networkHighlightValue._cachedId == null) {
              break label298;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, networkHighlightValue._cachedId);
            networkHighlightValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
          profileHighlightValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          networkHighlightValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.shared.Highlight.Detail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */