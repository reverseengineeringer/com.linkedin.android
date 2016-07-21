package com.linkedin.android.pegasus.gen.voyager.messaging.create;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
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

public final class StickerCreate
  implements FissileDataModel<StickerCreate>, RecordTemplate<StickerCreate>
{
  public static final StickerCreateBuilder BUILDER = StickerCreateBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final CustomContent customContent;
  public final boolean hasCustomContent;
  public final boolean hasStickerUrn;
  public final Urn stickerUrn;
  
  StickerCreate(Urn paramUrn, CustomContent paramCustomContent, boolean paramBoolean1, boolean paramBoolean2)
  {
    stickerUrn = paramUrn;
    customContent = paramCustomContent;
    hasStickerUrn = paramBoolean1;
    hasCustomContent = paramBoolean2;
    _cachedId = null;
  }
  
  public final StickerCreate accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasStickerUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("stickerUrn");
      localObject = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(stickerUrn));
    }
    Object localObject = null;
    boolean bool = false;
    if (hasCustomContent)
    {
      paramDataProcessor.startRecordField$505cff1c("customContent");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label125;
      }
      localObject = customContent.accept(paramDataProcessor);
      if (localObject == null) {
        break label142;
      }
    }
    label125:
    label142:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label165;
      }
      try
      {
        if (hasStickerUrn) {
          break label147;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.create.StickerCreate", "stickerUrn");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject = (CustomContent)paramDataProcessor.processDataTemplate(customContent);
      break;
    }
    label147:
    return new StickerCreate(stickerUrn, (CustomContent)localObject, hasStickerUrn, bool);
    label165:
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
      paramObject = (StickerCreate)paramObject;
      if (stickerUrn != null)
      {
        if (stickerUrn.equals(stickerUrn)) {}
      }
      else {
        while (stickerUrn != null) {
          return false;
        }
      }
      if (customContent == null) {
        break;
      }
    } while (customContent.equals(customContent));
    for (;;)
    {
      return false;
      if (customContent == null) {
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
    if (hasStickerUrn)
    {
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(stickerUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasCustomContent)
    {
      i = j + 1;
      if (customContent._cachedId == null) {
        break label94;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(customContent._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label94:
      i += customContent.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (stickerUrn != null) {}
    for (int i = stickerUrn.hashCode();; i = 0)
    {
      if (customContent != null) {
        j = customContent.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building StickerCreate");
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
    label247:
    label272:
    label280:
    label282:
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
        localByteBuffer.putInt(1916907643);
        if (hasStickerUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(stickerUrn));
          if (!hasCustomContent) {
            break label272;
          }
          localByteBuffer.put((byte)1);
          if (customContent._cachedId == null) {
            break label247;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, customContent._cachedId);
          customContent.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label280;
          }
          if (str != null) {
            break label282;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          customContent.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
    implements RecordTemplateBuilder<StickerCreate>
  {
    public StickerCreate.CustomContent customContent = null;
    public boolean hasCustomContent = false;
    private boolean hasStickerUrn = false;
    private Urn stickerUrn = null;
    
    public final StickerCreate build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (StickerCreate.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new StickerCreate(stickerUrn, customContent, hasStickerUrn, hasCustomContent);
      } while (hasStickerUrn);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.create.StickerCreate", "stickerUrn");
    }
    
    public final Builder setStickerUrn(Urn paramUrn)
    {
      if (paramUrn == null)
      {
        hasStickerUrn = false;
        stickerUrn = null;
        return this;
      }
      hasStickerUrn = true;
      stickerUrn = paramUrn;
      return this;
    }
  }
  
  public static final class CustomContent
    implements FissileDataModel<CustomContent>, UnionTemplate<CustomContent>
  {
    public static final StickerCreateBuilder.CustomContentBuilder BUILDER = StickerCreateBuilder.CustomContentBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final boolean hasMiniGroupUrnValue;
    public final Urn miniGroupUrnValue;
    
    public CustomContent(Urn paramUrn, boolean paramBoolean)
    {
      miniGroupUrnValue = paramUrn;
      hasMiniGroupUrnValue = paramBoolean;
      _cachedId = null;
    }
    
    public final CustomContent accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      if (hasMiniGroupUrnValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("string");
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(miniGroupUrnValue));
      }
      paramDataProcessor.endUnion();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        return new CustomContent(miniGroupUrnValue, hasMiniGroupUrnValue);
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
        paramObject = (CustomContent)paramObject;
        if (miniGroupUrnValue == null) {
          break;
        }
      } while (miniGroupUrnValue.equals(miniGroupUrnValue));
      for (;;)
      {
        return false;
        if (miniGroupUrnValue == null) {
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
      if (hasMiniGroupUrnValue)
      {
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(miniGroupUrnValue)) + 8;
      }
      __sizeOfObject = i;
      return i;
    }
    
    public final int hashCode()
    {
      if (_cachedHashCode > 0) {
        return _cachedHashCode;
      }
      if (miniGroupUrnValue != null) {}
      for (int i = miniGroupUrnValue.hashCode();; i = 0)
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
        throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building CustomContent");
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
      label187:
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
          localByteBuffer.putInt(13180648);
          if (hasMiniGroupUrnValue)
          {
            localByteBuffer.put((byte)1);
            UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
            paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(miniGroupUrnValue));
          }
          while (paramByteBuffer == null)
          {
            if (str != null) {
              break label187;
            }
            paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
            paramFissionAdapter.recycle(localByteBuffer);
            return;
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
      public boolean hasMiniGroupUrnValue = false;
      public Urn miniGroupUrnValue = null;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.create.StickerCreate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */