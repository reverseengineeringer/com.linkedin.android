package com.linkedin.android.pegasus.gen.voyager.common;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class File
  implements FissileDataModel<File>, RecordTemplate<File>
{
  public static final FileBuilder BUILDER = FileBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final long byteSize;
  public final boolean hasByteSize;
  public final boolean hasId;
  public final boolean hasMediaType;
  public final boolean hasName;
  public final boolean hasReference;
  public final String id;
  public final String mediaType;
  public final String name;
  public final Reference reference;
  
  File(String paramString1, String paramString2, long paramLong, String paramString3, Reference paramReference, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    id = paramString1;
    name = paramString2;
    byteSize = paramLong;
    mediaType = paramString3;
    reference = paramReference;
    hasId = paramBoolean1;
    hasName = paramBoolean2;
    hasByteSize = paramBoolean3;
    hasMediaType = paramBoolean4;
    hasReference = paramBoolean5;
    _cachedId = null;
  }
  
  public final File accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasId)
    {
      paramDataProcessor.startRecordField$505cff1c("id");
      paramDataProcessor.processString(id);
    }
    if (hasName)
    {
      paramDataProcessor.startRecordField$505cff1c("name");
      paramDataProcessor.processString(name);
    }
    if (hasByteSize)
    {
      paramDataProcessor.startRecordField$505cff1c("byteSize");
      paramDataProcessor.processLong(byteSize);
    }
    if (hasMediaType)
    {
      paramDataProcessor.startRecordField$505cff1c("mediaType");
      paramDataProcessor.processString(mediaType);
    }
    Reference localReference = null;
    boolean bool = false;
    if (hasReference)
    {
      paramDataProcessor.startRecordField$505cff1c("reference");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label193;
      }
      localReference = reference.accept(paramDataProcessor);
      if (localReference == null) {
        break label210;
      }
    }
    label193:
    label210:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label314;
      }
      try
      {
        if (hasId) {
          break label215;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.File", "id");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localReference = (Reference)paramDataProcessor.processDataTemplate(reference);
      break;
    }
    label215:
    if (!hasName) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.File", "name");
    }
    if (!hasMediaType) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.File", "mediaType");
    }
    if (!hasReference) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.File", "reference");
    }
    return new File(id, name, byteSize, mediaType, localReference, hasId, hasName, hasByteSize, hasMediaType, bool);
    label314:
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
      paramObject = (File)paramObject;
      if (id != null)
      {
        if (id.equals(id)) {}
      }
      else {
        while (id != null) {
          return false;
        }
      }
      if (name != null)
      {
        if (name.equals(name)) {}
      }
      else {
        while (name != null) {
          return false;
        }
      }
      if (byteSize != byteSize) {
        return false;
      }
      if (mediaType != null)
      {
        if (mediaType.equals(mediaType)) {}
      }
      else {
        while (mediaType != null) {
          return false;
        }
      }
      if (reference == null) {
        break;
      }
    } while (reference.equals(reference));
    for (;;)
    {
      return false;
      if (reference == null) {
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
    if (hasId) {
      i = PegasusBinaryUtils.getEncodedLength(id) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasName) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(name);
    }
    j = i + 1;
    i = j;
    if (hasByteSize) {
      i = j + 8;
    }
    j = i + 1;
    i = j;
    if (hasMediaType) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(mediaType);
    }
    j = i + 1;
    i = j;
    if (hasReference)
    {
      i = j + 1;
      if (reference._cachedId == null) {
        break label155;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(reference._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label155:
      i += reference.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int n;
    if (id != null)
    {
      i = id.hashCode();
      if (name == null) {
        break label131;
      }
      j = name.hashCode();
      n = (int)(byteSize ^ byteSize >>> 32);
      if (mediaType == null) {
        break label136;
      }
    }
    label131:
    label136:
    for (int k = mediaType.hashCode();; k = 0)
    {
      if (reference != null) {
        m = reference.hashCode();
      }
      i = (k + ((j + (i + 527) * 31) * 31 + n) * 31) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building File");
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
    label186:
    label212:
    label315:
    label325:
    label335:
    label345:
    label370:
    label378:
    label380:
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
        localByteBuffer.putInt(846054384);
        if (hasId)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, id);
          if (!hasName) {
            break label315;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, name);
          if (!hasByteSize) {
            break label325;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putLong(byteSize);
          if (!hasMediaType) {
            break label335;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, mediaType);
          if (!hasReference) {
            break label370;
          }
          localByteBuffer.put((byte)1);
          if (reference._cachedId == null) {
            break label345;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, reference._cachedId);
          reference.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label378;
          }
          if (str != null) {
            break label380;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label162;
          localByteBuffer.put((byte)0);
          break label186;
          localByteBuffer.put((byte)0);
          break label212;
          localByteBuffer.put((byte)1);
          reference.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
  
  public static final class Builder
    implements RecordTemplateBuilder<File>
  {
    public long byteSize = 0L;
    public boolean hasByteSize = false;
    public boolean hasId = false;
    public boolean hasMediaType = false;
    public boolean hasName = false;
    public boolean hasReference = false;
    public String id = null;
    public String mediaType = null;
    public String name = null;
    public File.Reference reference = null;
    
    public final File build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (File.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new File(id, name, byteSize, mediaType, reference, hasId, hasName, hasByteSize, hasMediaType, hasReference);
        if (!hasId) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.File", "id");
        }
        if (!hasName) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.File", "name");
        }
        if (!hasMediaType) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.File", "mediaType");
        }
      } while (hasReference);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.File", "reference");
    }
  }
  
  public static final class Reference
    implements FissileDataModel<Reference>, UnionTemplate<Reference>
  {
    public static final FileBuilder.ReferenceBuilder BUILDER = FileBuilder.ReferenceBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final boolean hasMediaProxyImageValue;
    public final boolean hasUrlValue;
    public final MediaProxyImage mediaProxyImageValue;
    public final String urlValue;
    
    public Reference(MediaProxyImage paramMediaProxyImage, String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      mediaProxyImageValue = paramMediaProxyImage;
      urlValue = paramString;
      hasMediaProxyImageValue = paramBoolean1;
      hasUrlValue = paramBoolean2;
      _cachedId = null;
    }
    
    public final Reference accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      MediaProxyImage localMediaProxyImage = null;
      boolean bool = false;
      if (hasMediaProxyImageValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.common.MediaProxyImage");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label107;
        }
        localMediaProxyImage = mediaProxyImageValue.accept(paramDataProcessor);
        if (localMediaProxyImage == null) {
          break label124;
        }
      }
      label107:
      label124:
      for (bool = true;; bool = false)
      {
        if (hasUrlValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("string");
          paramDataProcessor.processString(urlValue);
        }
        paramDataProcessor.endUnion();
        if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
          break label129;
        }
        return new Reference(localMediaProxyImage, urlValue, bool, hasUrlValue);
        localMediaProxyImage = (MediaProxyImage)paramDataProcessor.processDataTemplate(mediaProxyImageValue);
        break;
      }
      label129:
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
        paramObject = (Reference)paramObject;
        if (mediaProxyImageValue != null)
        {
          if (mediaProxyImageValue.equals(mediaProxyImageValue)) {}
        }
        else {
          while (mediaProxyImageValue != null) {
            return false;
          }
        }
        if (urlValue == null) {
          break;
        }
      } while (urlValue.equals(urlValue));
      for (;;)
      {
        return false;
        if (urlValue == null) {
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
      if (hasMediaProxyImageValue) {
        if (mediaProxyImageValue._cachedId == null) {
          break label83;
        }
      }
      label83:
      for (i = PegasusBinaryUtils.getEncodedLength(mediaProxyImageValue._cachedId) + 9;; i = mediaProxyImageValue.getSerializedSize() + 7)
      {
        int j = i + 1;
        i = j;
        if (hasUrlValue) {
          i = j + 2 + PegasusBinaryUtils.getEncodedLength(urlValue);
        }
        __sizeOfObject = i;
        return i;
      }
    }
    
    public final int hashCode()
    {
      int j = 0;
      if (_cachedHashCode > 0) {
        return _cachedHashCode;
      }
      if (mediaProxyImageValue != null) {}
      for (int i = mediaProxyImageValue.hashCode();; i = 0)
      {
        if (urlValue != null) {
          j = urlValue.hashCode();
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
        throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Reference");
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
      label264:
      label272:
      label274:
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
          localByteBuffer.putInt(659354824);
          if (hasMediaProxyImageValue)
          {
            localByteBuffer.put((byte)1);
            if (mediaProxyImageValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, mediaProxyImageValue._cachedId);
              mediaProxyImageValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasUrlValue) {
                break label264;
              }
              localByteBuffer.put((byte)1);
              paramFissionAdapter.writeString(localByteBuffer, urlValue);
            }
          }
          for (;;)
          {
            if (paramByteBuffer != null) {
              break label272;
            }
            if (str != null) {
              break label274;
            }
            paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
            paramFissionAdapter.recycle(localByteBuffer);
            return;
            localByteBuffer.put((byte)1);
            mediaProxyImageValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
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
    
    public static final class Builder
    {
      public boolean hasMediaProxyImageValue = false;
      public boolean hasUrlValue = false;
      public MediaProxyImage mediaProxyImageValue = null;
      public String urlValue = null;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.File
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */