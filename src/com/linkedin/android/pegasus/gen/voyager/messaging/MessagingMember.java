package com.linkedin.android.pegasus.gen.voyager.messaging;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class MessagingMember
  implements FissileDataModel<MessagingMember>, RecordTemplate<MessagingMember>
{
  public static final MessagingMemberBuilder BUILDER = MessagingMemberBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final Image alternateImage;
  public final String alternateName;
  public final Urn entityUrn;
  public final boolean hasAlternateImage;
  public final boolean hasAlternateName;
  public final boolean hasEntityUrn;
  public final boolean hasMiniProfile;
  public final MiniProfile miniProfile;
  
  MessagingMember(Urn paramUrn, MiniProfile paramMiniProfile, String paramString, Image paramImage, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    entityUrn = paramUrn;
    miniProfile = paramMiniProfile;
    alternateName = paramString;
    alternateImage = paramImage;
    hasEntityUrn = paramBoolean1;
    hasMiniProfile = paramBoolean2;
    hasAlternateName = paramBoolean3;
    hasAlternateImage = paramBoolean4;
    paramMiniProfile = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
  }
  
  public final MessagingMember accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject1;
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    Object localObject2 = null;
    boolean bool1 = false;
    if (hasMiniProfile)
    {
      paramDataProcessor.startRecordField$505cff1c("miniProfile");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = miniProfile.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label222;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label89:
      if (hasAlternateName)
      {
        paramDataProcessor.startRecordField$505cff1c("alternateName");
        paramDataProcessor.processString(alternateName);
      }
      localObject1 = null;
      bool2 = false;
      if (hasAlternateImage)
      {
        paramDataProcessor.startRecordField$505cff1c("alternateImage");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label231;
        }
        localObject1 = alternateImage.accept(paramDataProcessor);
        label153:
        if (localObject1 == null) {
          break label249;
        }
      }
    }
    label222:
    label231:
    label249:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label284;
      }
      try
      {
        if (hasMiniProfile) {
          break label254;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.MessagingMember", "miniProfile");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (MiniProfile)paramDataProcessor.processDataTemplate(miniProfile);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label89;
      localObject1 = (Image)paramDataProcessor.processDataTemplate(alternateImage);
      break label153;
    }
    label254:
    return new MessagingMember(entityUrn, (MiniProfile)localObject2, alternateName, (Image)localObject1, hasEntityUrn, bool1, hasAlternateName, bool2);
    label284:
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
      paramObject = (MessagingMember)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (miniProfile != null)
      {
        if (miniProfile.equals(miniProfile)) {}
      }
      else {
        while (miniProfile != null) {
          return false;
        }
      }
      if (alternateName != null)
      {
        if (alternateName.equals(alternateName)) {}
      }
      else {
        while (alternateName != null) {
          return false;
        }
      }
      if (alternateImage == null) {
        break;
      }
    } while (alternateImage.equals(alternateImage));
    for (;;)
    {
      return false;
      if (alternateImage == null) {
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
    if (hasEntityUrn)
    {
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasMiniProfile)
    {
      i = j + 1;
      if (miniProfile._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(miniProfile._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasAlternateName) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(alternateName);
      }
      j = i + 1;
      i = j;
      if (hasAlternateImage)
      {
        i = j + 1;
        if (alternateImage._cachedId == null) {
          break label174;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(alternateImage._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i += miniProfile.getSerializedSize();
      break;
      label174:
      i += alternateImage.getSerializedSize();
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
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (miniProfile == null) {
        break label110;
      }
      j = miniProfile.hashCode();
      label45:
      if (alternateName == null) {
        break label115;
      }
    }
    label110:
    label115:
    for (int k = alternateName.hashCode();; k = 0)
    {
      if (alternateImage != null) {
        m = alternateImage.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building MessagingMember");
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
    label204:
    label230:
    label333:
    label358:
    label368:
    label378:
    label403:
    label411:
    label413:
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
        localByteBuffer.putInt(860468491);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasMiniProfile) {
            break label358;
          }
          localByteBuffer.put((byte)1);
          if (miniProfile._cachedId == null) {
            break label333;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, miniProfile._cachedId);
          miniProfile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasAlternateName) {
            break label368;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, alternateName);
          if (!hasAlternateImage) {
            break label403;
          }
          localByteBuffer.put((byte)1);
          if (alternateImage._cachedId == null) {
            break label378;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, alternateImage._cachedId);
          alternateImage.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label411;
          }
          if (str != null) {
            break label413;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          miniProfile.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label204;
          localByteBuffer.put((byte)0);
          break label204;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          alternateImage.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.MessagingMember
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */