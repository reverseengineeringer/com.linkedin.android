package com.linkedin.android.pegasus.gen.voyager.messaging;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class MessagingCompany
  implements FissileDataModel<MessagingCompany>, RecordTemplate<MessagingCompany>
{
  public static final MessagingCompanyBuilder BUILDER = MessagingCompanyBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final Image alternateImage;
  public final String alternateName;
  public final Urn entityUrn;
  public final boolean hasAlternateImage;
  public final boolean hasAlternateName;
  public final boolean hasEntityUrn;
  public final boolean hasMiniCompany;
  public final boolean hasMiniProfile;
  public final MiniCompany miniCompany;
  public final MiniCompany miniProfile;
  
  MessagingCompany(Urn paramUrn, MiniCompany paramMiniCompany1, MiniCompany paramMiniCompany2, String paramString, Image paramImage, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    entityUrn = paramUrn;
    miniProfile = paramMiniCompany1;
    miniCompany = paramMiniCompany2;
    alternateName = paramString;
    alternateImage = paramImage;
    hasEntityUrn = paramBoolean1;
    hasMiniProfile = paramBoolean2;
    hasMiniCompany = paramBoolean3;
    hasAlternateName = paramBoolean4;
    hasAlternateImage = paramBoolean5;
    paramMiniCompany1 = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
  }
  
  public final MessagingCompany accept(DataProcessor paramDataProcessor)
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
    label89:
    Object localObject3;
    boolean bool2;
    if (hasMiniProfile)
    {
      paramDataProcessor.startRecordField$505cff1c("miniProfile");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = miniProfile.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label279;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasMiniCompany)
      {
        paramDataProcessor.startRecordField$505cff1c("miniCompany");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label288;
        }
        localObject1 = miniCompany.accept(paramDataProcessor);
        label128:
        if (localObject1 == null) {
          break label306;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      label139:
      if (hasAlternateName)
      {
        paramDataProcessor.startRecordField$505cff1c("alternateName");
        paramDataProcessor.processString(alternateName);
      }
      localObject1 = null;
      bool3 = false;
      if (hasAlternateImage)
      {
        paramDataProcessor.startRecordField$505cff1c("alternateImage");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label315;
        }
        localObject1 = alternateImage.accept(paramDataProcessor);
        label204:
        if (localObject1 == null) {
          break label333;
        }
      }
    }
    label279:
    label288:
    label306:
    label315:
    label333:
    for (boolean bool3 = true;; bool3 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label339;
      }
      return new MessagingCompany(entityUrn, (MiniCompany)localObject2, (MiniCompany)localObject3, alternateName, (Image)localObject1, hasEntityUrn, bool1, bool2, hasAlternateName, bool3);
      localObject1 = (MiniCompany)paramDataProcessor.processDataTemplate(miniProfile);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label89;
      localObject1 = (MiniCompany)paramDataProcessor.processDataTemplate(miniCompany);
      break label128;
      bool2 = false;
      localObject3 = localObject1;
      break label139;
      localObject1 = (Image)paramDataProcessor.processDataTemplate(alternateImage);
      break label204;
    }
    label339:
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
      paramObject = (MessagingCompany)paramObject;
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
      if (miniCompany != null)
      {
        if (miniCompany.equals(miniCompany)) {}
      }
      else {
        while (miniCompany != null) {
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
      if (hasMiniCompany)
      {
        i = j + 1;
        if (miniCompany._cachedId == null) {
          break label216;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(miniCompany._cachedId);
      }
      label129:
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
          break label229;
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
      label216:
      i += miniCompany.getSerializedSize();
      break label129;
      label229:
      i += alternateImage.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (miniProfile == null) {
        break label132;
      }
      j = miniProfile.hashCode();
      if (miniCompany == null) {
        break label137;
      }
      k = miniCompany.hashCode();
      label60:
      if (alternateName == null) {
        break label142;
      }
    }
    label132:
    label137:
    label142:
    for (int m = alternateName.hashCode();; m = 0)
    {
      if (alternateImage != null) {
        n = alternateImage.hashCode();
      }
      i = (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building MessagingCompany");
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
    label264:
    label290:
    label393:
    label418:
    label428:
    label453:
    label463:
    label473:
    label498:
    label506:
    label508:
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
        localByteBuffer.putInt(1383087796);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasMiniProfile) {
            break label418;
          }
          localByteBuffer.put((byte)1);
          if (miniProfile._cachedId == null) {
            break label393;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, miniProfile._cachedId);
          miniProfile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasMiniCompany) {
            break label453;
          }
          localByteBuffer.put((byte)1);
          if (miniCompany._cachedId == null) {
            break label428;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, miniCompany._cachedId);
          miniCompany.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasAlternateName) {
            break label463;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, alternateName);
          if (!hasAlternateImage) {
            break label498;
          }
          localByteBuffer.put((byte)1);
          if (alternateImage._cachedId == null) {
            break label473;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, alternateImage._cachedId);
          alternateImage.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label506;
          }
          if (str != null) {
            break label508;
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
          localByteBuffer.put((byte)1);
          miniCompany.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label264;
          localByteBuffer.put((byte)0);
          break label264;
          localByteBuffer.put((byte)0);
          break label290;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.MessagingCompany
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */