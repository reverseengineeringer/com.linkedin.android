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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class SocialProofBoltOn
  implements FissileDataModel<SocialProofBoltOn>, RecordTemplate<SocialProofBoltOn>
{
  public static final SocialProofBoltOnBuilder BUILDER = SocialProofBoltOnBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final RichText boltonText;
  public final boolean hasBoltonText;
  public final boolean hasHeadlineText;
  public final boolean hasProfileImages;
  public final boolean hasText;
  public final RichText headlineText;
  public final List<Image> profileImages;
  public final RichText text;
  
  SocialProofBoltOn(RichText paramRichText1, RichText paramRichText2, RichText paramRichText3, List<Image> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    text = paramRichText1;
    boltonText = paramRichText2;
    headlineText = paramRichText3;
    if (paramList == null) {}
    for (paramRichText1 = null;; paramRichText1 = Collections.unmodifiableList(paramList))
    {
      profileImages = paramRichText1;
      hasText = paramBoolean1;
      hasBoltonText = paramBoolean2;
      hasHeadlineText = paramBoolean3;
      hasProfileImages = paramBoolean4;
      _cachedId = null;
      return;
    }
  }
  
  public final SocialProofBoltOn accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    label96:
    label108:
    Object localObject4;
    boolean bool3;
    label148:
    label160:
    int i;
    if (hasText)
    {
      paramDataProcessor.startRecordField$505cff1c("text");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = text.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label326;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasBoltonText)
      {
        paramDataProcessor.startRecordField$505cff1c("boltonText");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label335;
        }
        localObject1 = boltonText.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label353;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasHeadlineText)
      {
        paramDataProcessor.startRecordField$505cff1c("headlineText");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label363;
        }
        localObject1 = headlineText.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label381;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      localObject1 = null;
      localImage = null;
      bool4 = false;
      if (!hasProfileImages) {
        break label421;
      }
      paramDataProcessor.startRecordField$505cff1c("profileImages");
      profileImages.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localImage;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = profileImages.iterator();
      label235:
      if (!localIterator.hasNext()) {
        break label407;
      }
      localImage = (Image)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label391;
      }
    }
    label326:
    label335:
    label353:
    label363:
    label381:
    label391:
    for (Image localImage = localImage.accept(paramDataProcessor);; localImage = (Image)paramDataProcessor.processDataTemplate(localImage))
    {
      if ((localObject1 != null) && (localImage != null)) {
        ((List)localObject1).add(localImage);
      }
      i += 1;
      break label235;
      localObject1 = (RichText)paramDataProcessor.processDataTemplate(text);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (RichText)paramDataProcessor.processDataTemplate(boltonText);
      break label96;
      bool2 = false;
      localObject3 = localObject1;
      break label108;
      localObject1 = (RichText)paramDataProcessor.processDataTemplate(headlineText);
      break label148;
      bool3 = false;
      localObject4 = localObject1;
      break label160;
    }
    label407:
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool4 = true;; bool4 = false)
    {
      label421:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break;
      }
      return new SocialProofBoltOn((RichText)localObject2, (RichText)localObject3, (RichText)localObject4, (List)localObject1, bool1, bool2, bool3, bool4);
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
      paramObject = (SocialProofBoltOn)paramObject;
      if (text != null)
      {
        if (text.equals(text)) {}
      }
      else {
        while (text != null) {
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
      if (headlineText != null)
      {
        if (headlineText.equals(headlineText)) {}
      }
      else {
        while (headlineText != null) {
          return false;
        }
      }
      if (profileImages == null) {
        break;
      }
    } while (profileImages.equals(profileImages));
    for (;;)
    {
      return false;
      if (profileImages == null) {
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
    int j;
    label93:
    label135:
    Iterator localIterator;
    if (hasText)
    {
      if (text._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(text._cachedId) + 9;
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasBoltonText)
      {
        i = j + 1;
        if (boltonText._cachedId == null) {
          break label226;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(boltonText._cachedId);
      }
      j = i + 1;
      i = j;
      if (hasHeadlineText)
      {
        i = j + 1;
        if (headlineText._cachedId == null) {
          break label239;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(headlineText._cachedId);
      }
      i += 1;
      j = i;
      if (!hasProfileImages) {
        break label263;
      }
      i += 2;
      localIterator = profileImages.iterator();
    }
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break label263;
      }
      Image localImage = (Image)localIterator.next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i = text.getSerializedSize() + 7;
        break;
        label226:
        i += boltonText.getSerializedSize();
        break label93;
        label239:
        i += headlineText.getSerializedSize();
        break label135;
      }
      i += localImage.getSerializedSize();
    }
    label263:
    __sizeOfObject = j;
    return j;
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
      if (boltonText == null) {
        break label112;
      }
      j = boltonText.hashCode();
      label45:
      if (headlineText == null) {
        break label117;
      }
    }
    label112:
    label117:
    for (int k = headlineText.hashCode();; k = 0)
    {
      if (profileImages != null) {
        m = profileImages.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SocialProofBoltOn");
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
    label432:
    label457:
    label467:
    label492:
    label525:
    label532:
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
        localByteBuffer.putInt(-15902824);
        Iterator localIterator;
        if (hasText)
        {
          localByteBuffer.put((byte)1);
          if (text._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, text._cachedId);
            text.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasBoltonText) {
              break label457;
            }
            localByteBuffer.put((byte)1);
            if (boltonText._cachedId == null) {
              break label432;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, boltonText._cachedId);
            boltonText.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasHeadlineText) {
              break label492;
            }
            localByteBuffer.put((byte)1);
            if (headlineText._cachedId == null) {
              break label467;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, headlineText._cachedId);
            headlineText.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasProfileImages) {
              break label525;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, profileImages.size());
            localIterator = profileImages.iterator();
          }
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label532;
          }
          Image localImage = (Image)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localImage.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)1);
            text.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            boltonText.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label230;
            localByteBuffer.put((byte)0);
            break label230;
            localByteBuffer.put((byte)1);
            headlineText.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label290;
            localByteBuffer.put((byte)0);
            break label290;
          }
          localByteBuffer.put((byte)1);
          localImage.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.crosspromo.fe.api.bolton.android.SocialProofBoltOn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */