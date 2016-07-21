package com.linkedin.android.pegasus.gen.restli.common;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Link
  implements FissileDataModel<Link>, RecordTemplate<Link>
{
  public static final LinkBuilder BUILDER = LinkBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final boolean hasHref;
  public final boolean hasRel;
  public final boolean hasType;
  public final String href;
  public final String rel;
  public final String type;
  
  Link(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    rel = paramString1;
    href = paramString2;
    type = paramString3;
    hasRel = paramBoolean1;
    hasHref = paramBoolean2;
    hasType = paramBoolean3;
    _cachedId = null;
  }
  
  public final Link accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasRel)
    {
      paramDataProcessor.startRecordField$505cff1c("rel");
      paramDataProcessor.processString(rel);
    }
    if (hasHref)
    {
      paramDataProcessor.startRecordField$505cff1c("href");
      paramDataProcessor.processString(href);
    }
    if (hasType)
    {
      paramDataProcessor.startRecordField$505cff1c("type");
      paramDataProcessor.processString(type);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasRel) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.restli.common.Link", "rel");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasHref) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.restli.common.Link", "href");
      }
      if (!hasType) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.restli.common.Link", "type");
      }
      return new Link(rel, href, type, hasRel, hasHref, hasType);
    }
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
      paramObject = (Link)paramObject;
      if (rel != null)
      {
        if (rel.equals(rel)) {}
      }
      else {
        while (rel != null) {
          return false;
        }
      }
      if (href != null)
      {
        if (href.equals(href)) {}
      }
      else {
        while (href != null) {
          return false;
        }
      }
      if (type == null) {
        break;
      }
    } while (type.equals(type));
    for (;;)
    {
      return false;
      if (type == null) {
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
    if (hasRel) {
      i = PegasusBinaryUtils.getEncodedLength(rel) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasHref) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(href);
    }
    j = i + 1;
    i = j;
    if (hasType) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(type);
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
    if (rel != null)
    {
      i = rel.hashCode();
      if (href == null) {
        break label87;
      }
    }
    label87:
    for (int j = href.hashCode();; j = 0)
    {
      if (type != null) {
        k = type.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Link");
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
    label231:
    label241:
    label249:
    label251:
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
        localByteBuffer.putInt(1988116859);
        if (hasRel)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, rel);
          if (!hasHref) {
            break label231;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, href);
          if (!hasType) {
            break label241;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, type);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label249;
          }
          if (str != null) {
            break label251;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label162;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.restli.common.Link
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */