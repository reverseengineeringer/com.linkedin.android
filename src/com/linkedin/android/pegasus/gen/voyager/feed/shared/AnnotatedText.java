package com.linkedin.android.pegasus.gen.voyager.feed.shared;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
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

public final class AnnotatedText
  implements FissileDataModel<AnnotatedText>, RecordTemplate<AnnotatedText>
{
  public static final AnnotatedTextBuilder BUILDER = AnnotatedTextBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final boolean hasValues;
  public final List<AnnotatedString> values;
  
  AnnotatedText(List<AnnotatedString> paramList, boolean paramBoolean)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      values = paramList;
      hasValues = paramBoolean;
      _cachedId = null;
      return;
    }
  }
  
  public final AnnotatedText accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject = null;
    AnnotatedString localAnnotatedString = null;
    boolean bool = false;
    if (hasValues)
    {
      paramDataProcessor.startRecordField$505cff1c("values");
      values.size();
      paramDataProcessor.startArray$13462e();
      localObject = localAnnotatedString;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = values.iterator();
      if (localIterator.hasNext())
      {
        localAnnotatedString = (AnnotatedString)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localAnnotatedString = localAnnotatedString.accept(paramDataProcessor);; localAnnotatedString = (AnnotatedString)paramDataProcessor.processDataTemplate(localAnnotatedString))
        {
          if ((localObject != null) && (localAnnotatedString != null)) {
            ((List)localObject).add(localAnnotatedString);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label269;
      }
    }
    label269:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label285;
      }
      if (!hasValues) {
        localObject = Collections.emptyList();
      }
      try
      {
        if (values == null) {
          break;
        }
        paramDataProcessor = values.iterator();
        do
        {
          if (!paramDataProcessor.hasNext()) {
            break;
          }
        } while ((AnnotatedString)paramDataProcessor.next() != null);
        throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText", "values");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    return new AnnotatedText((List)localObject, bool);
    label285:
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
      paramObject = (AnnotatedText)paramObject;
      if (values == null) {
        break;
      }
    } while (values.equals(values));
    for (;;)
    {
      return false;
      if (values == null) {
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
    int j = i;
    if (hasValues)
    {
      i += 2;
      Iterator localIterator = values.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        AnnotatedString localAnnotatedString = (AnnotatedString)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localAnnotatedString.getSerializedSize();
        }
      }
    }
    __sizeOfObject = j;
    return j;
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (values != null) {}
    for (int i = values.hashCode();; i = 0)
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building AnnotatedText");
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
        localByteBuffer.putInt(2043626362);
        if (hasValues)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, values.size());
          Iterator localIterator = values.iterator();
          while (localIterator.hasNext())
          {
            AnnotatedString localAnnotatedString = (AnnotatedString)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localAnnotatedString.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              localAnnotatedString.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
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
    implements RecordTemplateBuilder<AnnotatedText>
  {
    private boolean hasValues = false;
    private List<AnnotatedString> values = null;
    
    private AnnotatedText build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (AnnotatedText.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (values != null)
      {
        paramFlavor = values.iterator();
        do
        {
          if (!paramFlavor.hasNext()) {
            break;
          }
        } while ((AnnotatedString)paramFlavor.next() != null);
        throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText", "values");
        if (!hasValues) {
          values = Collections.emptyList();
        }
      }
      return new AnnotatedText(values, hasValues);
    }
    
    public final AnnotatedText build()
      throws BuilderException
    {
      return build(RecordTemplate.Flavor.RECORD);
    }
    
    public final Builder setValues(List<AnnotatedString> paramList)
    {
      if ((paramList == null) || (paramList.equals(Collections.emptyList())))
      {
        hasValues = false;
        values = Collections.emptyList();
        return this;
      }
      hasValues = true;
      values = paramList;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */