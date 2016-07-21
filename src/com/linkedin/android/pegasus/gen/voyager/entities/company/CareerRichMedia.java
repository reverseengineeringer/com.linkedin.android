package com.linkedin.android.pegasus.gen.voyager.entities.company;

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

public final class CareerRichMedia
  implements FissileDataModel<CareerRichMedia>, RecordTemplate<CareerRichMedia>
{
  public static final CareerRichMediaBuilder BUILDER = CareerRichMediaBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final Content content;
  public final boolean hasContent;
  
  CareerRichMedia(Content paramContent, boolean paramBoolean)
  {
    content = paramContent;
    hasContent = paramBoolean;
    _cachedId = null;
  }
  
  public final CareerRichMedia accept(DataProcessor paramDataProcessor)
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
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.company.CareerRichMedia", "content");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localContent = (Content)paramDataProcessor.processDataTemplate(content);
      break;
    }
    label115:
    return new CareerRichMedia(localContent, bool);
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
      paramObject = (CareerRichMedia)paramObject;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building CareerRichMedia");
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
        localByteBuffer.putInt(468031772);
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
    public static final CareerRichMediaBuilder.ContentBuilder BUILDER = CareerRichMediaBuilder.ContentBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final CareerImage careerImageValue;
    public final CareerSlide careerSlideValue;
    public final CareerVideo careerVideoValue;
    public final boolean hasCareerImageValue;
    public final boolean hasCareerSlideValue;
    public final boolean hasCareerVideoValue;
    
    Content(CareerImage paramCareerImage, CareerVideo paramCareerVideo, CareerSlide paramCareerSlide, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      careerImageValue = paramCareerImage;
      careerVideoValue = paramCareerVideo;
      careerSlideValue = paramCareerSlide;
      hasCareerImageValue = paramBoolean1;
      hasCareerVideoValue = paramBoolean2;
      hasCareerSlideValue = paramBoolean3;
      _cachedId = null;
    }
    
    public final Content accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      Object localObject2 = null;
      boolean bool1 = false;
      Object localObject1;
      label56:
      Object localObject3;
      boolean bool2;
      if (hasCareerImageValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.company.CareerImage");
        if (paramDataProcessor.shouldAcceptTransitively())
        {
          localObject1 = careerImageValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label205;
          }
          bool1 = true;
          localObject2 = localObject1;
        }
      }
      else
      {
        localObject3 = null;
        bool2 = false;
        if (hasCareerVideoValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.company.CareerVideo");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label214;
          }
          localObject1 = careerVideoValue.accept(paramDataProcessor);
          label95:
          if (localObject1 == null) {
            break label232;
          }
          bool2 = true;
          localObject3 = localObject1;
        }
        label106:
        localObject1 = null;
        bool3 = false;
        if (hasCareerSlideValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.company.CareerSlide");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label241;
          }
          localObject1 = careerSlideValue.accept(paramDataProcessor);
          label146:
          if (localObject1 == null) {
            break label259;
          }
        }
      }
      label205:
      label214:
      label232:
      label241:
      label259:
      for (boolean bool3 = true;; bool3 = false)
      {
        paramDataProcessor.endUnion();
        if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
          break label265;
        }
        return new Content((CareerImage)localObject2, (CareerVideo)localObject3, (CareerSlide)localObject1, bool1, bool2, bool3);
        localObject1 = (CareerImage)paramDataProcessor.processDataTemplate(careerImageValue);
        break;
        bool1 = false;
        localObject2 = localObject1;
        break label56;
        localObject1 = (CareerVideo)paramDataProcessor.processDataTemplate(careerVideoValue);
        break label95;
        bool2 = false;
        localObject3 = localObject1;
        break label106;
        localObject1 = (CareerSlide)paramDataProcessor.processDataTemplate(careerSlideValue);
        break label146;
      }
      label265:
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
        if (careerImageValue != null)
        {
          if (careerImageValue.equals(careerImageValue)) {}
        }
        else {
          while (careerImageValue != null) {
            return false;
          }
        }
        if (careerVideoValue != null)
        {
          if (careerVideoValue.equals(careerVideoValue)) {}
        }
        else {
          while (careerVideoValue != null) {
            return false;
          }
        }
        if (careerSlideValue == null) {
          break;
        }
      } while (careerSlideValue.equals(careerSlideValue));
      for (;;)
      {
        return false;
        if (careerSlideValue == null) {
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
      if (hasCareerImageValue)
      {
        if (careerImageValue._cachedId != null) {
          i = PegasusBinaryUtils.getEncodedLength(careerImageValue._cachedId) + 9;
        }
      }
      else
      {
        int j = i + 1;
        i = j;
        if (hasCareerVideoValue)
        {
          i = j + 1;
          if (careerVideoValue._cachedId == null) {
            break label156;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(careerVideoValue._cachedId);
        }
        label93:
        j = i + 1;
        i = j;
        if (hasCareerSlideValue)
        {
          i = j + 1;
          if (careerSlideValue._cachedId == null) {
            break label169;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(careerSlideValue._cachedId);
        }
      }
      for (;;)
      {
        __sizeOfObject = i;
        return i;
        i = careerImageValue.getSerializedSize() + 7;
        break;
        label156:
        i += careerVideoValue.getSerializedSize();
        break label93;
        label169:
        i += careerSlideValue.getSerializedSize();
      }
    }
    
    public final int hashCode()
    {
      int k = 0;
      if (_cachedHashCode > 0) {
        return _cachedHashCode;
      }
      int i;
      if (careerImageValue != null)
      {
        i = careerImageValue.hashCode();
        if (careerVideoValue == null) {
          break label87;
        }
      }
      label87:
      for (int j = careerVideoValue.hashCode();; j = 0)
      {
        if (careerSlideValue != null) {
          k = careerSlideValue.hashCode();
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
      label230:
      label358:
      label383:
      label393:
      label418:
      label426:
      label428:
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
          localByteBuffer.putInt(-561705788);
          if (hasCareerImageValue)
          {
            localByteBuffer.put((byte)1);
            if (careerImageValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, careerImageValue._cachedId);
              careerImageValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasCareerVideoValue) {
                break label383;
              }
              localByteBuffer.put((byte)1);
              if (careerVideoValue._cachedId == null) {
                break label358;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, careerVideoValue._cachedId);
              careerVideoValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasCareerSlideValue) {
                break label418;
              }
              localByteBuffer.put((byte)1);
              if (careerSlideValue._cachedId == null) {
                break label393;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, careerSlideValue._cachedId);
              careerSlideValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
          }
          for (;;)
          {
            if (paramByteBuffer != null) {
              break label426;
            }
            if (str != null) {
              break label428;
            }
            paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
            paramFissionAdapter.recycle(localByteBuffer);
            return;
            localByteBuffer.put((byte)1);
            careerImageValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            careerVideoValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label230;
            localByteBuffer.put((byte)0);
            break label230;
            localByteBuffer.put((byte)1);
            careerSlideValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.company.CareerRichMedia
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */