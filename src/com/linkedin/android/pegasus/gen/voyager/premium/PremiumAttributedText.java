package com.linkedin.android.pegasus.gen.voyager.premium;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.pemberly.text.Attribute;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class PremiumAttributedText
  implements FissileDataModel<PremiumAttributedText>, RecordTemplate<PremiumAttributedText>
{
  public static final PremiumAttributedTextBuilder BUILDER = PremiumAttributedTextBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<PremiumTextAppearance> appearances;
  public final List<Attribute> attributes;
  public final boolean hasAppearances;
  public final boolean hasAttributes;
  public final boolean hasText;
  public final String text;
  
  PremiumAttributedText(String paramString, List<Attribute> paramList, List<PremiumTextAppearance> paramList1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    text = paramString;
    if (paramList == null)
    {
      paramString = null;
      attributes = paramString;
      if (paramList1 != null) {
        break label73;
      }
    }
    label73:
    for (paramString = null;; paramString = Collections.unmodifiableList(paramList1))
    {
      appearances = paramString;
      hasText = paramBoolean1;
      hasAttributes = paramBoolean2;
      hasAppearances = paramBoolean3;
      _cachedId = null;
      return;
      paramString = Collections.unmodifiableList(paramList);
      break;
    }
  }
  
  public final PremiumAttributedText accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasText)
    {
      paramDataProcessor.startRecordField$505cff1c("text");
      paramDataProcessor.processString(text);
    }
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool1 = false;
    int i;
    if (hasAttributes)
    {
      paramDataProcessor.startRecordField$505cff1c("attributes");
      attributes.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject2;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject3 = attributes.iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (Attribute)((Iterator)localObject3).next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localObject2 = ((Attribute)localObject2).accept(paramDataProcessor);; localObject2 = (Attribute)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
        {
          if ((localObject1 != null) && (localObject2 != null)) {
            ((List)localObject1).add(localObject2);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject1 != null) {
        bool1 = true;
      }
    }
    else
    {
      localObject2 = null;
      localObject3 = null;
      bool2 = false;
      if (!hasAppearances) {
        break label390;
      }
      paramDataProcessor.startRecordField$505cff1c("appearances");
      appearances.size();
      paramDataProcessor.startArray$13462e();
      localObject2 = localObject3;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject2 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = appearances.iterator();
      label282:
      if (!localIterator.hasNext()) {
        break label376;
      }
      localObject3 = (PremiumTextAppearance)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label360;
      }
    }
    label360:
    for (Object localObject3 = ((PremiumTextAppearance)localObject3).accept(paramDataProcessor);; localObject3 = (PremiumTextAppearance)paramDataProcessor.processDataTemplate((DataTemplate)localObject3))
    {
      if ((localObject2 != null) && (localObject3 != null)) {
        ((List)localObject2).add(localObject3);
      }
      i += 1;
      break label282;
      bool1 = false;
      break;
    }
    label376:
    paramDataProcessor.endArray();
    if (localObject2 != null) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      label390:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label575;
      }
      if (!hasAttributes) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (hasText) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.premium.PremiumAttributedText", "text");
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
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.premium.PremiumAttributedText", "attributes");
        }
      }
    }
    if (appearances != null)
    {
      paramDataProcessor = appearances.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((PremiumTextAppearance)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.premium.PremiumAttributedText", "appearances");
        }
      }
    }
    return new PremiumAttributedText(text, (List)localObject1, (List)localObject2, hasText, bool1, bool2);
    label575:
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
      paramObject = (PremiumAttributedText)paramObject;
      if (text != null)
      {
        if (text.equals(text)) {}
      }
      else {
        while (text != null) {
          return false;
        }
      }
      if (attributes != null)
      {
        if (attributes.equals(attributes)) {}
      }
      else {
        while (attributes != null) {
          return false;
        }
      }
      if (appearances == null) {
        break;
      }
    } while (appearances.equals(appearances));
    for (;;)
    {
      return false;
      if (appearances == null) {
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
    Iterator localIterator;
    Object localObject;
    if (hasAttributes)
    {
      i += 2;
      localIterator = attributes.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Attribute)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((Attribute)localObject).getSerializedSize();
        }
      }
    }
    i = j + 1;
    j = i;
    if (hasAppearances)
    {
      i += 2;
      localIterator = appearances.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (PremiumTextAppearance)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((PremiumTextAppearance)localObject).getSerializedSize();
        }
      }
    }
    __sizeOfObject = j;
    return j;
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (text != null)
    {
      i = text.hashCode();
      if (attributes == null) {
        break label91;
      }
    }
    label91:
    for (int j = attributes.hashCode();; j = 0)
    {
      if (appearances != null) {
        k = appearances.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building PremiumAttributedText");
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
        localByteBuffer.putInt(-437008408);
        Iterator localIterator;
        Object localObject;
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
            localObject = (Attribute)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((Attribute)localObject).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              continue;
              localByteBuffer.put((byte)0);
              break;
            }
            localByteBuffer.put((byte)1);
            ((Attribute)localObject).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          }
        }
        localByteBuffer.put((byte)0);
        if (hasAppearances)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, appearances.size());
          localIterator = appearances.iterator();
          while (localIterator.hasNext())
          {
            localObject = (PremiumTextAppearance)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((PremiumTextAppearance)localObject).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              ((PremiumTextAppearance)localObject).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.premium.PremiumAttributedText
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */