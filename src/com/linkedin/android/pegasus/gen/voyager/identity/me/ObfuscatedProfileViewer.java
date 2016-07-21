package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.search.SearchQuery;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ObfuscatedProfileViewer
  implements FissileDataModel<ObfuscatedProfileViewer>, RecordTemplate<ObfuscatedProfileViewer>
{
  public static final ObfuscatedProfileViewerBuilder BUILDER = ObfuscatedProfileViewerBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasObfuscationString;
  public final boolean hasOccupation;
  public final boolean hasSearchQuery;
  public final String obfuscationString;
  public final Occupation occupation;
  public final SearchQuery searchQuery;
  
  ObfuscatedProfileViewer(String paramString, SearchQuery paramSearchQuery, Occupation paramOccupation, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    obfuscationString = paramString;
    searchQuery = paramSearchQuery;
    occupation = paramOccupation;
    hasObfuscationString = paramBoolean1;
    hasSearchQuery = paramBoolean2;
    hasOccupation = paramBoolean3;
    _cachedId = null;
  }
  
  public final ObfuscatedProfileViewer accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasObfuscationString)
    {
      paramDataProcessor.startRecordField$505cff1c("obfuscationString");
      paramDataProcessor.processString(obfuscationString);
    }
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    if (hasSearchQuery)
    {
      paramDataProcessor.startRecordField$505cff1c("searchQuery");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = searchQuery.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label189;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label81:
      localObject1 = null;
      bool2 = false;
      if (hasOccupation)
      {
        paramDataProcessor.startRecordField$505cff1c("occupation");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label198;
        }
        localObject1 = occupation.accept(paramDataProcessor);
        label120:
        if (localObject1 == null) {
          break label216;
        }
      }
    }
    label189:
    label198:
    label216:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label243;
      }
      try
      {
        if (hasObfuscationString) {
          break label221;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.me.ObfuscatedProfileViewer", "obfuscationString");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (SearchQuery)paramDataProcessor.processDataTemplate(searchQuery);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label81;
      localObject1 = (Occupation)paramDataProcessor.processDataTemplate(occupation);
      break label120;
    }
    label221:
    return new ObfuscatedProfileViewer(obfuscationString, (SearchQuery)localObject2, (Occupation)localObject1, hasObfuscationString, bool1, bool2);
    label243:
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
      paramObject = (ObfuscatedProfileViewer)paramObject;
      if (obfuscationString != null)
      {
        if (obfuscationString.equals(obfuscationString)) {}
      }
      else {
        while (obfuscationString != null) {
          return false;
        }
      }
      if (searchQuery != null)
      {
        if (searchQuery.equals(searchQuery)) {}
      }
      else {
        while (searchQuery != null) {
          return false;
        }
      }
      if (occupation == null) {
        break;
      }
    } while (occupation.equals(occupation));
    for (;;)
    {
      return false;
      if (occupation == null) {
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
    if (hasObfuscationString) {
      i = PegasusBinaryUtils.getEncodedLength(obfuscationString) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasSearchQuery)
    {
      i = j + 1;
      if (searchQuery._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(searchQuery._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasOccupation)
      {
        i = j + 1;
        if (occupation._cachedId == null) {
          break label142;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(occupation._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i += searchQuery.getSerializedSize();
      break;
      label142:
      i += occupation.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (obfuscationString != null)
    {
      i = obfuscationString.hashCode();
      if (searchQuery == null) {
        break label87;
      }
    }
    label87:
    for (int j = searchQuery.hashCode();; j = 0)
    {
      if (occupation != null) {
        k = occupation.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ObfuscatedProfileViewer");
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
    label196:
    label299:
    label324:
    label334:
    label359:
    label367:
    label369:
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
        localByteBuffer.putInt(682102249);
        if (hasObfuscationString)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, obfuscationString);
          if (!hasSearchQuery) {
            break label324;
          }
          localByteBuffer.put((byte)1);
          if (searchQuery._cachedId == null) {
            break label299;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, searchQuery._cachedId);
          searchQuery.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasOccupation) {
            break label359;
          }
          localByteBuffer.put((byte)1);
          if (occupation._cachedId == null) {
            break label334;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, occupation._cachedId);
          occupation.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label367;
          }
          if (str != null) {
            break label369;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          searchQuery.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label196;
          localByteBuffer.put((byte)0);
          break label196;
          localByteBuffer.put((byte)1);
          occupation.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.ObfuscatedProfileViewer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */