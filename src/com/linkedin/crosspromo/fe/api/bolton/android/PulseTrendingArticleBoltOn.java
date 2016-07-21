package com.linkedin.crosspromo.fe.api.bolton.android;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.crosspromo.common.android.RichText;
import com.linkedin.crosspromo.fe.api.android.Image;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class PulseTrendingArticleBoltOn
  implements FissileDataModel<PulseTrendingArticleBoltOn>, RecordTemplate<PulseTrendingArticleBoltOn>
{
  public static final PulseTrendingArticleBoltOnBuilder BUILDER = PulseTrendingArticleBoltOnBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final RichText boltonText;
  public final boolean hasBoltonText;
  public final boolean hasHeadlineText;
  public final boolean hasIcon;
  public final boolean hasText;
  public final RichText headlineText;
  public final Image icon;
  public final RichText text;
  
  PulseTrendingArticleBoltOn(RichText paramRichText1, Image paramImage, RichText paramRichText2, RichText paramRichText3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    text = paramRichText1;
    icon = paramImage;
    boltonText = paramRichText2;
    headlineText = paramRichText3;
    hasText = paramBoolean1;
    hasIcon = paramBoolean2;
    hasBoltonText = paramBoolean3;
    hasHeadlineText = paramBoolean4;
    _cachedId = null;
  }
  
  public final PulseTrendingArticleBoltOn accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    label95:
    label106:
    Object localObject4;
    boolean bool3;
    if (hasText)
    {
      paramDataProcessor.startRecordField$505cff1c("text");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = text.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label261;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasIcon)
      {
        paramDataProcessor.startRecordField$505cff1c("icon");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label270;
        }
        localObject1 = icon.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label288;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasBoltonText)
      {
        paramDataProcessor.startRecordField$505cff1c("boltonText");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label297;
        }
        localObject1 = boltonText.accept(paramDataProcessor);
        label146:
        if (localObject1 == null) {
          break label315;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      label158:
      localObject1 = null;
      bool4 = false;
      if (hasHeadlineText)
      {
        paramDataProcessor.startRecordField$505cff1c("headlineText");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label325;
        }
        localObject1 = headlineText.accept(paramDataProcessor);
        label198:
        if (localObject1 == null) {
          break label343;
        }
      }
    }
    label261:
    label270:
    label288:
    label297:
    label315:
    label325:
    label343:
    for (boolean bool4 = true;; bool4 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label349;
      }
      return new PulseTrendingArticleBoltOn((RichText)localObject2, (Image)localObject3, (RichText)localObject4, (RichText)localObject1, bool1, bool2, bool3, bool4);
      localObject1 = (RichText)paramDataProcessor.processDataTemplate(text);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (Image)paramDataProcessor.processDataTemplate(icon);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (RichText)paramDataProcessor.processDataTemplate(boltonText);
      break label146;
      bool3 = false;
      localObject4 = localObject1;
      break label158;
      localObject1 = (RichText)paramDataProcessor.processDataTemplate(headlineText);
      break label198;
    }
    label349:
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
      paramObject = (PulseTrendingArticleBoltOn)paramObject;
      if (text != null)
      {
        if (text.equals(text)) {}
      }
      else {
        while (text != null) {
          return false;
        }
      }
      if (icon != null)
      {
        if (icon.equals(icon)) {}
      }
      else {
        while (icon != null) {
          return false;
        }
      }
      if (boltonText != null)
      {
        if (boltonText.equals(boltonText)) {}
      }
      else {
        while (boltonText != null) {
          return false;
        }
      }
      if (headlineText == null) {
        break;
      }
    } while (headlineText.equals(headlineText));
    for (;;)
    {
      return false;
      if (headlineText == null) {
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
      if (hasIcon)
      {
        i = j + 1;
        if (icon._cachedId == null) {
          break label198;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(icon._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasBoltonText)
      {
        i = j + 1;
        if (boltonText._cachedId == null) {
          break label211;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(boltonText._cachedId);
      }
      label135:
      j = i + 1;
      i = j;
      if (hasHeadlineText)
      {
        i = j + 1;
        if (headlineText._cachedId == null) {
          break label224;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(headlineText._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = text.getSerializedSize() + 7;
      break;
      label198:
      i += icon.getSerializedSize();
      break label93;
      label211:
      i += boltonText.getSerializedSize();
      break label135;
      label224:
      i += headlineText.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    if (text != null)
    {
      i = text.hashCode();
      if (icon == null) {
        break label110;
      }
      j = icon.hashCode();
      label45:
      if (boltonText == null) {
        break label115;
      }
    }
    label110:
    label115:
    for (int k = boltonText.hashCode();; k = 0)
    {
      if (headlineText != null) {
        m = headlineText.hashCode();
      }
      i = (k + (j + (i + 527) * 31) * 31) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building PulseTrendingArticleBoltOn");
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
    label290:
    label418:
    label443:
    label453:
    label478:
    label488:
    label513:
    label521:
    label523:
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
        localByteBuffer.putInt(557770338);
        if (hasText)
        {
          localByteBuffer.put((byte)1);
          if (text._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, text._cachedId);
            text.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasIcon) {
              break label443;
            }
            localByteBuffer.put((byte)1);
            if (icon._cachedId == null) {
              break label418;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, icon._cachedId);
            icon.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasBoltonText) {
              break label478;
            }
            localByteBuffer.put((byte)1);
            if (boltonText._cachedId == null) {
              break label453;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, boltonText._cachedId);
            boltonText.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasHeadlineText) {
              break label513;
            }
            localByteBuffer.put((byte)1);
            if (headlineText._cachedId == null) {
              break label488;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, headlineText._cachedId);
            headlineText.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label521;
          }
          if (str != null) {
            break label523;
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
          icon.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          boltonText.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label290;
          localByteBuffer.put((byte)0);
          break label290;
          localByteBuffer.put((byte)1);
          headlineText.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.crosspromo.fe.api.bolton.android.PulseTrendingArticleBoltOn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */