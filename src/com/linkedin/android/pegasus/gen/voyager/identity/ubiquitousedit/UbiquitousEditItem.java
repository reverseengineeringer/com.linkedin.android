package com.linkedin.android.pegasus.gen.voyager.identity.ubiquitousedit;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class UbiquitousEditItem
  implements FissileDataModel<UbiquitousEditItem>, RecordTemplate<UbiquitousEditItem>
{
  public static final UbiquitousEditItemBuilder BUILDER = UbiquitousEditItemBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final Content content;
  public final boolean hasContent;
  
  UbiquitousEditItem(Content paramContent, boolean paramBoolean)
  {
    content = paramContent;
    hasContent = paramBoolean;
    _cachedId = null;
  }
  
  private UbiquitousEditItem accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Content localContent = null;
    boolean bool = false;
    if (hasContent)
    {
      paramDataProcessor.startRecordField$505cff1c("content");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label93;
      }
      localContent = content.accept(paramDataProcessor);
      if (localContent == null) {
        break label110;
      }
    }
    label93:
    label110:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label125;
      }
      try
      {
        if (hasContent) {
          break label115;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.ubiquitousedit.UbiquitousEditItem", "content");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localContent = (Content)paramDataProcessor.processDataTemplate(content);
      break;
    }
    label115:
    return new UbiquitousEditItem(localContent, bool);
    label125:
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
      paramObject = (UbiquitousEditItem)paramObject;
      if (content == null) {
        break;
      }
    } while (content.equals(content));
    for (;;)
    {
      return false;
      if (content == null) {
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
    if (hasContent) {
      if (content._cachedId == null) {
        break label58;
      }
    }
    label58:
    for (i = PegasusBinaryUtils.getEncodedLength(content._cachedId) + 9;; i = content.getSerializedSize() + 7)
    {
      __sizeOfObject = i;
      return i;
    }
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (content != null) {}
    for (int i = content.hashCode();; i = 0)
    {
      i += 527;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building UbiquitousEditItem");
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
    label238:
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
        localByteBuffer.putInt(32809090);
        if (hasContent)
        {
          localByteBuffer.put((byte)1);
          if (content._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, content._cachedId);
            content.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label238;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          content.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
  
  public static final class Content
    implements FissileDataModel<Content>, UnionTemplate<Content>
  {
    public static final UbiquitousEditItemBuilder.ContentBuilder BUILDER = UbiquitousEditItemBuilder.ContentBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final boolean hasUbiquitousEditFeedItemValue;
    public final boolean hasUbiquitousEditPymkItemValue;
    public final UbiquitousEditFeedItem ubiquitousEditFeedItemValue;
    public final UbiquitousEditPymkItem ubiquitousEditPymkItemValue;
    
    Content(UbiquitousEditPymkItem paramUbiquitousEditPymkItem, UbiquitousEditFeedItem paramUbiquitousEditFeedItem, boolean paramBoolean1, boolean paramBoolean2)
    {
      ubiquitousEditPymkItemValue = paramUbiquitousEditPymkItem;
      ubiquitousEditFeedItemValue = paramUbiquitousEditFeedItem;
      hasUbiquitousEditPymkItemValue = paramBoolean1;
      hasUbiquitousEditFeedItemValue = paramBoolean2;
      _cachedId = null;
    }
    
    public final Content accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      Object localObject2 = null;
      boolean bool1 = false;
      Object localObject1;
      if (hasUbiquitousEditPymkItemValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.ubiquitousedit.UbiquitousEditPymkItem");
        if (paramDataProcessor.shouldAcceptTransitively())
        {
          localObject1 = ubiquitousEditPymkItemValue.accept(paramDataProcessor);
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
        if (hasUbiquitousEditFeedItemValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.ubiquitousedit.UbiquitousEditFeedItem");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label158;
          }
          localObject1 = ubiquitousEditFeedItemValue.accept(paramDataProcessor);
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
        return new Content((UbiquitousEditPymkItem)localObject2, (UbiquitousEditFeedItem)localObject1, bool1, bool2);
        localObject1 = (UbiquitousEditPymkItem)paramDataProcessor.processDataTemplate(ubiquitousEditPymkItemValue);
        break;
        bool1 = false;
        localObject2 = localObject1;
        break label56;
        localObject1 = (UbiquitousEditFeedItem)paramDataProcessor.processDataTemplate(ubiquitousEditFeedItemValue);
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
        paramObject = (Content)paramObject;
        if (ubiquitousEditPymkItemValue != null)
        {
          if (ubiquitousEditPymkItemValue.equals(ubiquitousEditPymkItemValue)) {}
        }
        else {
          while (ubiquitousEditPymkItemValue != null) {
            return false;
          }
        }
        if (ubiquitousEditFeedItemValue == null) {
          break;
        }
      } while (ubiquitousEditFeedItemValue.equals(ubiquitousEditFeedItemValue));
      for (;;)
      {
        return false;
        if (ubiquitousEditFeedItemValue == null) {
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
      if (hasUbiquitousEditPymkItemValue)
      {
        if (ubiquitousEditPymkItemValue._cachedId != null) {
          i = PegasusBinaryUtils.getEncodedLength(ubiquitousEditPymkItemValue._cachedId) + 9;
        }
      }
      else
      {
        int j = i + 1;
        i = j;
        if (hasUbiquitousEditFeedItemValue)
        {
          i = j + 1;
          if (ubiquitousEditFeedItemValue._cachedId == null) {
            break label114;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(ubiquitousEditFeedItemValue._cachedId);
        }
      }
      for (;;)
      {
        __sizeOfObject = i;
        return i;
        i = ubiquitousEditPymkItemValue.getSerializedSize() + 7;
        break;
        label114:
        i += ubiquitousEditFeedItemValue.getSerializedSize();
      }
    }
    
    public final int hashCode()
    {
      int j = 0;
      if (_cachedHashCode > 0) {
        return _cachedHashCode;
      }
      if (ubiquitousEditPymkItemValue != null) {}
      for (int i = ubiquitousEditPymkItemValue.hashCode();; i = 0)
      {
        if (ubiquitousEditFeedItemValue != null) {
          j = ubiquitousEditFeedItemValue.hashCode();
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
        throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Content");
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
          localByteBuffer.putInt(535806872);
          if (hasUbiquitousEditPymkItemValue)
          {
            localByteBuffer.put((byte)1);
            if (ubiquitousEditPymkItemValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, ubiquitousEditPymkItemValue._cachedId);
              ubiquitousEditPymkItemValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasUbiquitousEditFeedItemValue) {
                break label323;
              }
              localByteBuffer.put((byte)1);
              if (ubiquitousEditFeedItemValue._cachedId == null) {
                break label298;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, ubiquitousEditFeedItemValue._cachedId);
              ubiquitousEditFeedItemValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
            ubiquitousEditPymkItemValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            ubiquitousEditFeedItemValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.ubiquitousedit.UbiquitousEditItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */