package com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.prompts;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SingleTextPrompt
  implements FissileDataModel<SingleTextPrompt>, RecordTemplate<SingleTextPrompt>
{
  public static final SingleTextPromptBuilder BUILDER = SingleTextPromptBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final boolean hasImage;
  public final boolean hasText;
  public final Image image;
  public final AttributedText text;
  
  SingleTextPrompt(AttributedText paramAttributedText, Image paramImage, boolean paramBoolean1, boolean paramBoolean2)
  {
    text = paramAttributedText;
    image = paramImage;
    hasText = paramBoolean1;
    hasImage = paramBoolean2;
    _cachedId = null;
  }
  
  public final SingleTextPrompt accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    if (hasText)
    {
      paramDataProcessor.startRecordField$505cff1c("text");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = text.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label164;
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
      if (hasImage)
      {
        paramDataProcessor.startRecordField$505cff1c("image");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label173;
        }
        localObject1 = image.accept(paramDataProcessor);
        label95:
        if (localObject1 == null) {
          break label191;
        }
      }
    }
    label164:
    label173:
    label191:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label210;
      }
      try
      {
        if (hasText) {
          break label196;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.prompts.SingleTextPrompt", "text");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (AttributedText)paramDataProcessor.processDataTemplate(text);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (Image)paramDataProcessor.processDataTemplate(image);
      break label95;
    }
    label196:
    return new SingleTextPrompt((AttributedText)localObject2, (Image)localObject1, bool1, bool2);
    label210:
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
      paramObject = (SingleTextPrompt)paramObject;
      if (text != null)
      {
        if (text.equals(text)) {}
      }
      else {
        while (text != null) {
          return false;
        }
      }
      if (image == null) {
        break;
      }
    } while (image.equals(image));
    for (;;)
    {
      return false;
      if (image == null) {
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
    if (hasText)
    {
      if (text._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(text._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasImage)
      {
        i = j + 1;
        if (image._cachedId == null) {
          break label114;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(image._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = text.getSerializedSize() + 7;
      break;
      label114:
      i += image.getSerializedSize();
    }
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
      if (image != null) {
        j = image.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SingleTextPrompt");
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
        localByteBuffer.putInt(-171727874);
        if (hasText)
        {
          localByteBuffer.put((byte)1);
          if (text._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, text._cachedId);
            text.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasImage) {
              break label323;
            }
            localByteBuffer.put((byte)1);
            if (image._cachedId == null) {
              break label298;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, image._cachedId);
            image.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
          text.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          image.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.prompts.SingleTextPrompt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */