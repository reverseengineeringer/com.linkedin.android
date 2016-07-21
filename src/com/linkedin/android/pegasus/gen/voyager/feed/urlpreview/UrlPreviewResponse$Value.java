package com.linkedin.android.pegasus.gen.voyager.feed.urlpreview;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class UrlPreviewResponse$Value
  implements FissileDataModel<Value>, UnionTemplate<Value>
{
  public static final UrlPreviewResponseBuilder.ValueBuilder BUILDER = UrlPreviewResponseBuilder.ValueBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasPreviewCreationFailedValue;
  public final boolean hasPreviewCreationInProgressValue;
  public final boolean hasPreviewCreationSuccessfulValue;
  public final PreviewCreationFailed previewCreationFailedValue;
  public final PreviewCreationInProgress previewCreationInProgressValue;
  public final PreviewCreationSuccessful previewCreationSuccessfulValue;
  
  UrlPreviewResponse$Value(PreviewCreationSuccessful paramPreviewCreationSuccessful, PreviewCreationInProgress paramPreviewCreationInProgress, PreviewCreationFailed paramPreviewCreationFailed, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    previewCreationSuccessfulValue = paramPreviewCreationSuccessful;
    previewCreationInProgressValue = paramPreviewCreationInProgress;
    previewCreationFailedValue = paramPreviewCreationFailed;
    hasPreviewCreationSuccessfulValue = paramBoolean1;
    hasPreviewCreationInProgressValue = paramBoolean2;
    hasPreviewCreationFailedValue = paramBoolean3;
    _cachedId = null;
  }
  
  public final Value accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    if (hasPreviewCreationSuccessfulValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.urlpreview.PreviewCreationSuccessful");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = previewCreationSuccessfulValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label197;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasPreviewCreationInProgressValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.urlpreview.PreviewCreationInProgress");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label206;
        }
        localObject1 = PreviewCreationInProgress.accept(paramDataProcessor);
        label91:
        if (localObject1 == null) {
          break label224;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      label102:
      localObject1 = null;
      bool3 = false;
      if (hasPreviewCreationFailedValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.urlpreview.PreviewCreationFailed");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label233;
        }
        localObject1 = PreviewCreationFailed.accept(paramDataProcessor);
        label138:
        if (localObject1 == null) {
          break label251;
        }
      }
    }
    label197:
    label206:
    label224:
    label233:
    label251:
    for (boolean bool3 = true;; bool3 = false)
    {
      paramDataProcessor.endUnion();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label257;
      }
      return new Value((PreviewCreationSuccessful)localObject2, (PreviewCreationInProgress)localObject3, (PreviewCreationFailed)localObject1, bool1, bool2, bool3);
      localObject1 = (PreviewCreationSuccessful)paramDataProcessor.processDataTemplate(previewCreationSuccessfulValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (PreviewCreationInProgress)paramDataProcessor.processDataTemplate(previewCreationInProgressValue);
      break label91;
      bool2 = false;
      localObject3 = localObject1;
      break label102;
      localObject1 = (PreviewCreationFailed)paramDataProcessor.processDataTemplate(previewCreationFailedValue);
      break label138;
    }
    label257:
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
      paramObject = (Value)paramObject;
      if (previewCreationSuccessfulValue != null)
      {
        if (previewCreationSuccessfulValue.equals(previewCreationSuccessfulValue)) {}
      }
      else {
        while (previewCreationSuccessfulValue != null) {
          return false;
        }
      }
      if (previewCreationInProgressValue != null)
      {
        if (previewCreationInProgressValue.equals(previewCreationInProgressValue)) {}
      }
      else {
        while (previewCreationInProgressValue != null) {
          return false;
        }
      }
      if (previewCreationFailedValue == null) {
        break;
      }
    } while (previewCreationFailedValue.equals(previewCreationFailedValue));
    for (;;)
    {
      return false;
      if (previewCreationFailedValue == null) {
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
    if (hasPreviewCreationSuccessfulValue)
    {
      if (previewCreationSuccessfulValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(previewCreationSuccessfulValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasPreviewCreationInProgressValue)
      {
        i = j + 1;
        if (previewCreationInProgressValue._cachedId == null) {
          break label156;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(previewCreationInProgressValue._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasPreviewCreationFailedValue)
      {
        i = j + 1;
        if (previewCreationFailedValue._cachedId == null) {
          break label169;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(previewCreationFailedValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = previewCreationSuccessfulValue.getSerializedSize() + 7;
      break;
      label156:
      i += previewCreationInProgressValue.getSerializedSize();
      break label93;
      label169:
      i += previewCreationFailedValue.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (previewCreationSuccessfulValue != null)
    {
      i = previewCreationSuccessfulValue.hashCode();
      if (previewCreationInProgressValue == null) {
        break label87;
      }
    }
    label87:
    for (int j = previewCreationInProgressValue.hashCode();; j = 0)
    {
      if (previewCreationFailedValue != null) {
        k = previewCreationFailedValue.hashCode();
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
    paramFissionAdapter.willWriteModel$30d0b508(this, paramBoolean);
    String str = _cachedId;
    if ((str == null) && (paramString == null) && (paramByteBuffer == null)) {
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Value");
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
    label230:
    label358:
    label383:
    label393:
    label418:
    label426:
    label428:
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
        localByteBuffer.putInt(698816662);
        if (hasPreviewCreationSuccessfulValue)
        {
          localByteBuffer.put((byte)1);
          if (previewCreationSuccessfulValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, previewCreationSuccessfulValue._cachedId);
            previewCreationSuccessfulValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasPreviewCreationInProgressValue) {
              break label383;
            }
            localByteBuffer.put((byte)1);
            if (previewCreationInProgressValue._cachedId == null) {
              break label358;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, previewCreationInProgressValue._cachedId);
            previewCreationInProgressValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasPreviewCreationFailedValue) {
              break label418;
            }
            localByteBuffer.put((byte)1);
            if (previewCreationFailedValue._cachedId == null) {
              break label393;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, previewCreationFailedValue._cachedId);
            previewCreationFailedValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label426;
          }
          if (str != null) {
            break label428;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          previewCreationSuccessfulValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          previewCreationInProgressValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          previewCreationFailedValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.UrlPreviewResponse.Value
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */