package com.linkedin.android.pegasus.gen.voyager.relationships.shared.annotation;

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
  public final List<Annotation> annotations;
  public final boolean hasAnnotations;
  public final boolean hasText;
  public final String text;
  
  AnnotatedText(String paramString, List<Annotation> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    text = paramString;
    if (paramList == null) {}
    for (paramString = null;; paramString = Collections.unmodifiableList(paramList))
    {
      annotations = paramString;
      hasText = paramBoolean1;
      hasAnnotations = paramBoolean2;
      _cachedId = null;
      return;
    }
  }
  
  public final AnnotatedText accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasText)
    {
      paramDataProcessor.startRecordField$505cff1c("text");
      paramDataProcessor.processString(text);
    }
    Object localObject = null;
    Annotation localAnnotation = null;
    boolean bool = false;
    if (hasAnnotations)
    {
      paramDataProcessor.startRecordField$505cff1c("annotations");
      annotations.size();
      paramDataProcessor.startArray$13462e();
      localObject = localAnnotation;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = annotations.iterator();
      if (localIterator.hasNext())
      {
        localAnnotation = (Annotation)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localAnnotation = localAnnotation.accept(paramDataProcessor);; localAnnotation = (Annotation)paramDataProcessor.processDataTemplate(localAnnotation))
        {
          if ((localObject != null) && (localAnnotation != null)) {
            ((List)localObject).add(localAnnotation);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label294;
      }
    }
    label294:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label318;
      }
      if (!hasAnnotations) {
        localObject = Collections.emptyList();
      }
      try
      {
        if (annotations == null) {
          break;
        }
        paramDataProcessor = annotations.iterator();
        do
        {
          if (!paramDataProcessor.hasNext()) {
            break;
          }
        } while ((Annotation)paramDataProcessor.next() != null);
        throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.annotation.AnnotatedText", "annotations");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    return new AnnotatedText(text, (List)localObject, hasText, bool);
    label318:
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
      if (text != null)
      {
        if (text.equals(text)) {}
      }
      else {
        while (text != null) {
          return false;
        }
      }
      if (annotations == null) {
        break;
      }
    } while (annotations.equals(annotations));
    for (;;)
    {
      return false;
      if (annotations == null) {
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
    if (hasAnnotations)
    {
      i += 2;
      Iterator localIterator = annotations.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        Annotation localAnnotation = (Annotation)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localAnnotation.getSerializedSize();
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
      if (annotations != null) {
        j = annotations.hashCode();
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
        localByteBuffer.putInt(854774837);
        Iterator localIterator;
        if (hasText)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, text);
          if (hasAnnotations)
          {
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, annotations.size());
            localIterator = annotations.iterator();
          }
        }
        else
        {
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label283;
            }
            Annotation localAnnotation = (Annotation)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localAnnotation.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              continue;
              localByteBuffer.put((byte)0);
              break;
            }
            localByteBuffer.put((byte)1);
            localAnnotation.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
    private List<Annotation> annotations = null;
    private boolean hasAnnotations = false;
    private boolean hasText = false;
    private String text = null;
    
    private AnnotatedText build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (AnnotatedText.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (annotations != null)
      {
        paramFlavor = annotations.iterator();
        do
        {
          if (!paramFlavor.hasNext()) {
            break;
          }
        } while ((Annotation)paramFlavor.next() != null);
        throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.annotation.AnnotatedText", "annotations");
        if (!hasText) {
          text = "";
        }
        if (!hasAnnotations) {
          annotations = Collections.emptyList();
        }
      }
      return new AnnotatedText(text, annotations, hasText, hasAnnotations);
    }
    
    public final AnnotatedText build()
      throws BuilderException
    {
      return build(RecordTemplate.Flavor.RECORD);
    }
    
    public final Builder setAnnotations(List<Annotation> paramList)
    {
      if (paramList.equals(Collections.emptyList()))
      {
        hasAnnotations = false;
        annotations = Collections.emptyList();
        return this;
      }
      hasAnnotations = true;
      annotations = paramList;
      return this;
    }
    
    public final Builder setText(String paramString)
    {
      if ((paramString == null) || (paramString.equals("")))
      {
        hasText = false;
        text = "";
        return this;
      }
      hasText = true;
      text = paramString;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.relationships.shared.annotation.AnnotatedText
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */