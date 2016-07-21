package com.linkedin.android.pegasus.gen.voyager.relationships.shared.annotation;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Annotation$Attribute
  implements FissileDataModel<Attribute>, UnionTemplate<Attribute>
{
  public static final AnnotationBuilder.AttributeBuilder BUILDER = AnnotationBuilder.AttributeBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final ExternalLink externalLinkValue;
  public final Format formatValue;
  public final boolean hasExternalLinkValue;
  public final boolean hasFormatValue;
  public final boolean hasMiniCompanyValue;
  public final boolean hasMiniProfileValue;
  public final MiniCompany miniCompanyValue;
  public final MiniProfile miniProfileValue;
  
  Annotation$Attribute(Format paramFormat, ExternalLink paramExternalLink, MiniProfile paramMiniProfile, MiniCompany paramMiniCompany, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    formatValue = paramFormat;
    externalLinkValue = paramExternalLink;
    miniProfileValue = paramMiniProfile;
    miniCompanyValue = paramMiniCompany;
    hasFormatValue = paramBoolean1;
    hasExternalLinkValue = paramBoolean2;
    hasMiniProfileValue = paramBoolean3;
    hasMiniCompanyValue = paramBoolean4;
    _cachedId = null;
  }
  
  public final Attribute accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
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
    if (hasFormatValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.relationships.shared.annotation.Format");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = formatValue.accept(paramDataProcessor);
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
      if (hasExternalLinkValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.relationships.shared.annotation.ExternalLink");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label270;
        }
        localObject1 = externalLinkValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label288;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasMiniProfileValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.shared.MiniProfile");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label297;
        }
        localObject1 = miniProfileValue.accept(paramDataProcessor);
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
      if (hasMiniCompanyValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.entities.shared.MiniCompany");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label325;
        }
        localObject1 = miniCompanyValue.accept(paramDataProcessor);
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
      paramDataProcessor.endUnion();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label349;
      }
      return new Attribute((Format)localObject2, (ExternalLink)localObject3, (MiniProfile)localObject4, (MiniCompany)localObject1, bool1, bool2, bool3, bool4);
      localObject1 = (Format)paramDataProcessor.processDataTemplate(formatValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (ExternalLink)paramDataProcessor.processDataTemplate(externalLinkValue);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (MiniProfile)paramDataProcessor.processDataTemplate(miniProfileValue);
      break label146;
      bool3 = false;
      localObject4 = localObject1;
      break label158;
      localObject1 = (MiniCompany)paramDataProcessor.processDataTemplate(miniCompanyValue);
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
      paramObject = (Attribute)paramObject;
      if (formatValue != null)
      {
        if (formatValue.equals(formatValue)) {}
      }
      else {
        while (formatValue != null) {
          return false;
        }
      }
      if (externalLinkValue != null)
      {
        if (externalLinkValue.equals(externalLinkValue)) {}
      }
      else {
        while (externalLinkValue != null) {
          return false;
        }
      }
      if (miniProfileValue != null)
      {
        if (miniProfileValue.equals(miniProfileValue)) {}
      }
      else {
        while (miniProfileValue != null) {
          return false;
        }
      }
      if (miniCompanyValue == null) {
        break;
      }
    } while (miniCompanyValue.equals(miniCompanyValue));
    for (;;)
    {
      return false;
      if (miniCompanyValue == null) {
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
    if (hasFormatValue)
    {
      if (formatValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(formatValue._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasExternalLinkValue)
      {
        i = j + 1;
        if (externalLinkValue._cachedId == null) {
          break label198;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(externalLinkValue._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasMiniProfileValue)
      {
        i = j + 1;
        if (miniProfileValue._cachedId == null) {
          break label211;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(miniProfileValue._cachedId);
      }
      label135:
      j = i + 1;
      i = j;
      if (hasMiniCompanyValue)
      {
        i = j + 1;
        if (miniCompanyValue._cachedId == null) {
          break label224;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(miniCompanyValue._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = formatValue.getSerializedSize() + 7;
      break;
      label198:
      i += externalLinkValue.getSerializedSize();
      break label93;
      label211:
      i += miniProfileValue.getSerializedSize();
      break label135;
      label224:
      i += miniCompanyValue.getSerializedSize();
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
    if (formatValue != null)
    {
      i = formatValue.hashCode();
      if (externalLinkValue == null) {
        break label110;
      }
      j = externalLinkValue.hashCode();
      label45:
      if (miniProfileValue == null) {
        break label115;
      }
    }
    label110:
    label115:
    for (int k = miniProfileValue.hashCode();; k = 0)
    {
      if (miniCompanyValue != null) {
        m = miniCompanyValue.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Attribute");
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
        localByteBuffer.putInt(-1839516704);
        if (hasFormatValue)
        {
          localByteBuffer.put((byte)1);
          if (formatValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, formatValue._cachedId);
            formatValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasExternalLinkValue) {
              break label443;
            }
            localByteBuffer.put((byte)1);
            if (externalLinkValue._cachedId == null) {
              break label418;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, externalLinkValue._cachedId);
            externalLinkValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasMiniProfileValue) {
              break label478;
            }
            localByteBuffer.put((byte)1);
            if (miniProfileValue._cachedId == null) {
              break label453;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, miniProfileValue._cachedId);
            miniProfileValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasMiniCompanyValue) {
              break label513;
            }
            localByteBuffer.put((byte)1);
            if (miniCompanyValue._cachedId == null) {
              break label488;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, miniCompanyValue._cachedId);
            miniCompanyValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
          formatValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          externalLinkValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          miniProfileValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label290;
          localByteBuffer.put((byte)0);
          break label290;
          localByteBuffer.put((byte)1);
          miniCompanyValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.relationships.shared.annotation.Annotation.Attribute
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */