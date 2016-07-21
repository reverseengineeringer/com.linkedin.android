package com.linkedin.android.pegasus.gen.voyager.identity.ubiquitousedit;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.feed.HighlightedUpdateType;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class UbiquitousEditFeedItem
  implements FissileDataModel<UbiquitousEditFeedItem>, RecordTemplate<UbiquitousEditFeedItem>
{
  public static final UbiquitousEditFeedItemBuilder BUILDER = UbiquitousEditFeedItemBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final HighlightedUpdateType cause;
  public final boolean hasCause;
  public final boolean hasHighlightedContentUrn;
  public final Urn highlightedContentUrn;
  
  UbiquitousEditFeedItem(Urn paramUrn, HighlightedUpdateType paramHighlightedUpdateType, boolean paramBoolean1, boolean paramBoolean2)
  {
    highlightedContentUrn = paramUrn;
    cause = paramHighlightedUpdateType;
    hasHighlightedContentUrn = paramBoolean1;
    hasCause = paramBoolean2;
    _cachedId = null;
  }
  
  public final UbiquitousEditFeedItem accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasHighlightedContentUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("highlightedContentUrn");
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(highlightedContentUrn));
    }
    if (hasCause)
    {
      paramDataProcessor.startRecordField$505cff1c("cause");
      paramDataProcessor.processEnum(cause);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasHighlightedContentUrn) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.ubiquitousedit.UbiquitousEditFeedItem", "highlightedContentUrn");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasCause) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.ubiquitousedit.UbiquitousEditFeedItem", "cause");
      }
      return new UbiquitousEditFeedItem(highlightedContentUrn, cause, hasHighlightedContentUrn, hasCause);
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
      paramObject = (UbiquitousEditFeedItem)paramObject;
      if (highlightedContentUrn != null)
      {
        if (highlightedContentUrn.equals(highlightedContentUrn)) {}
      }
      else {
        while (highlightedContentUrn != null) {
          return false;
        }
      }
      if (cause == null) {
        break;
      }
    } while (cause.equals(cause));
    for (;;)
    {
      return false;
      if (cause == null) {
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
    if (hasHighlightedContentUrn)
    {
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(highlightedContentUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasCause) {
      i = j + 2;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (highlightedContentUrn != null) {}
    for (int i = highlightedContentUrn.hashCode();; i = 0)
    {
      if (cause != null) {
        j = cause.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building UbiquitousEditFeedItem");
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
    label216:
    label224:
    label226:
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
        localByteBuffer.putInt(-1686635843);
        if (hasHighlightedContentUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(highlightedContentUrn));
          if (!hasCause) {
            break label216;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, cause.ordinal());
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label224;
          }
          if (str != null) {
            break label226;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.ubiquitousedit.UbiquitousEditFeedItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */