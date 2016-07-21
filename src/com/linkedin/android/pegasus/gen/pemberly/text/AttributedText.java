package com.linkedin.android.pegasus.gen.pemberly.text;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class AttributedText
  implements FissileDataModel<AttributedText>, RecordTemplate<AttributedText>
{
  public static final AttributedTextBuilder BUILDER = AttributedTextBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final List<Attribute> attributes;
  public final boolean hasAttributes;
  public final boolean hasText;
  public final String text;
  
  AttributedText(String paramString, List<Attribute> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    text = paramString;
    if (paramList == null) {}
    for (paramString = null;; paramString = Collections.unmodifiableList(paramList))
    {
      attributes = paramString;
      hasText = paramBoolean1;
      hasAttributes = paramBoolean2;
      _cachedId = null;
      return;
    }
  }
  
  public final AttributedText accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasText)
    {
      paramDataProcessor.startRecordField$505cff1c("text");
      paramDataProcessor.processString(text);
    }
    Object localObject = null;
    Attribute localAttribute = null;
    boolean bool = false;
    if (hasAttributes)
    {
      paramDataProcessor.startRecordField$505cff1c("attributes");
      attributes.size();
      paramDataProcessor.startArray$13462e();
      localObject = localAttribute;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = attributes.iterator();
      if (localIterator.hasNext())
      {
        localAttribute = (Attribute)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localAttribute = localAttribute.accept(paramDataProcessor);; localAttribute = (Attribute)paramDataProcessor.processDataTemplate(localAttribute))
        {
          if ((localObject != null) && (localAttribute != null)) {
            ((List)localObject).add(localAttribute);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label263;
      }
    }
    label263:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label337;
      }
      if (!hasAttributes) {
        localObject = Collections.emptyList();
      }
      try
      {
        if (hasText) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.pemberly.text.AttributedText", "text");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (attributes != null)
    {
      paramDataProcessor = attributes.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((Attribute)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.pemberly.text.AttributedText", "attributes");
        }
      }
    }
    return new AttributedText(text, (List)localObject, hasText, bool);
    label337:
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
      paramObject = (AttributedText)paramObject;
      if (text != null)
      {
        if (text.equals(text)) {}
      }
      else {
        while (text != null) {
          return false;
        }
      }
      if (attributes == null) {
        break;
      }
    } while (attributes.equals(attributes));
    for (;;)
    {
      return false;
      if (attributes == null) {
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
    if (hasText) {
      i = PegasusBinaryUtils.getEncodedLength(text) + 8;
    }
    i += 1;
    int j = i;
    if (hasAttributes)
    {
      i += 2;
      Iterator localIterator = attributes.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        Attribute localAttribute = (Attribute)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localAttribute.getSerializedSize();
        }
      }
    }
    __sizeOfObject = j;
    return j;
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (text != null) {}
    for (int i = text.hashCode();; i = 0)
    {
      if (attributes != null) {
        j = attributes.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building AttributedText");
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
    label283:
    do
    {
      ByteBuffer localByteBuffer;
      do
      {
        return;
        localByteBuffer = paramByteBuffer;
        if (paramByteBuffer == null) {
          localByteBuffer = paramFissionAdapter.getBuffer(getSerializedSize());
        }
        localByteBuffer.put((byte)1);
        localByteBuffer.putInt(481208648);
        Iterator localIterator;
        if (hasText)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, text);
          if (hasAttributes)
          {
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, attributes.size());
            localIterator = attributes.iterator();
          }
        }
        else
        {
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label283;
            }
            Attribute localAttribute = (Attribute)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localAttribute.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              continue;
              localByteBuffer.put((byte)0);
              break;
            }
            localByteBuffer.put((byte)1);
            localAttribute.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          }
        }
        localByteBuffer.put((byte)0);
      } while (paramByteBuffer != null);
      if (str == null)
      {
        paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
        paramFissionAdapter.recycle(localByteBuffer);
        return;
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
    implements RecordTemplateBuilder<AttributedText>
  {
    private List<Attribute> attributes = null;
    private boolean hasAttributes = false;
    private boolean hasText = false;
    private String text = null;
    
    public final AttributedText build()
      throws BuilderException
    {
      return build(RecordTemplate.Flavor.RECORD);
    }
    
    public final AttributedText build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (AttributedText.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (attributes != null)
      {
        paramFlavor = attributes.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((Attribute)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.android.pegasus.gen.pemberly.text.AttributedText", "attributes");
              if (!hasAttributes) {
                attributes = Collections.emptyList();
              }
              if (hasText) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.pemberly.text.AttributedText", "text");
            }
          }
        }
      }
      return new AttributedText(text, attributes, hasText, hasAttributes);
    }
    
    public final Builder setAttributes(List<Attribute> paramList)
    {
      if ((paramList == null) || (paramList.equals(Collections.emptyList())))
      {
        hasAttributes = false;
        attributes = Collections.emptyList();
        return this;
      }
      hasAttributes = true;
      attributes = paramList;
      return this;
    }
    
    public final Builder setText(String paramString)
    {
      if (paramString == null)
      {
        hasText = false;
        text = null;
        return this;
      }
      hasText = true;
      text = paramString;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.pemberly.text.AttributedText
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */