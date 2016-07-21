package com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail;

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

public final class SpInmailContent
  implements FissileDataModel<SpInmailContent>, RecordTemplate<SpInmailContent>
{
  public static final SpInmailContentBuilder BUILDER = SpInmailContentBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final String body;
  public final String bodyTracking;
  public final boolean hasBody;
  public final boolean hasBodyTracking;
  public final boolean hasLegalText;
  public final boolean hasOpenTracking;
  public final boolean hasSpInmailType;
  public final boolean hasStatus;
  public final boolean hasSubContent;
  public final SpInmailLegalText legalText;
  public final String openTracking;
  public final SpInmailType spInmailType;
  public final SpInmailStatus status;
  public final SubContent subContent;
  
  SpInmailContent(SpInmailType paramSpInmailType, SpInmailStatus paramSpInmailStatus, String paramString1, String paramString2, String paramString3, SpInmailLegalText paramSpInmailLegalText, SubContent paramSubContent, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    spInmailType = paramSpInmailType;
    status = paramSpInmailStatus;
    body = paramString1;
    bodyTracking = paramString2;
    openTracking = paramString3;
    legalText = paramSpInmailLegalText;
    subContent = paramSubContent;
    hasSpInmailType = paramBoolean1;
    hasStatus = paramBoolean2;
    hasBody = paramBoolean3;
    hasBodyTracking = paramBoolean4;
    hasOpenTracking = paramBoolean5;
    hasLegalText = paramBoolean6;
    hasSubContent = paramBoolean7;
    _cachedId = null;
  }
  
  public final SpInmailContent accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasSpInmailType)
    {
      paramDataProcessor.startRecordField$505cff1c("spInmailType");
      paramDataProcessor.processEnum(spInmailType);
    }
    if (hasStatus)
    {
      paramDataProcessor.startRecordField$505cff1c("status");
      paramDataProcessor.processEnum(status);
    }
    if (hasBody)
    {
      paramDataProcessor.startRecordField$505cff1c("body");
      paramDataProcessor.processString(body);
    }
    if (hasBodyTracking)
    {
      paramDataProcessor.startRecordField$505cff1c("bodyTracking");
      paramDataProcessor.processString(bodyTracking);
    }
    if (hasOpenTracking)
    {
      paramDataProcessor.startRecordField$505cff1c("openTracking");
      paramDataProcessor.processString(openTracking);
    }
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    if (hasLegalText)
    {
      paramDataProcessor.startRecordField$505cff1c("legalText");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = legalText.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label289;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label181:
      localObject1 = null;
      bool2 = false;
      if (hasSubContent)
      {
        paramDataProcessor.startRecordField$505cff1c("subContent");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label298;
        }
        localObject1 = subContent.accept(paramDataProcessor);
        label220:
        if (localObject1 == null) {
          break label316;
        }
      }
    }
    label289:
    label298:
    label316:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label413;
      }
      try
      {
        if (hasSpInmailType) {
          break label321;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailContent", "spInmailType");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (SpInmailLegalText)paramDataProcessor.processDataTemplate(legalText);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label181;
      localObject1 = (SubContent)paramDataProcessor.processDataTemplate(subContent);
      break label220;
    }
    label321:
    if (!hasStatus) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailContent", "status");
    }
    if (!hasSubContent) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailContent", "subContent");
    }
    return new SpInmailContent(spInmailType, status, body, bodyTracking, openTracking, (SpInmailLegalText)localObject2, (SubContent)localObject1, hasSpInmailType, hasStatus, hasBody, hasBodyTracking, hasOpenTracking, bool1, bool2);
    label413:
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
      paramObject = (SpInmailContent)paramObject;
      if (spInmailType != null)
      {
        if (spInmailType.equals(spInmailType)) {}
      }
      else {
        while (spInmailType != null) {
          return false;
        }
      }
      if (status != null)
      {
        if (status.equals(status)) {}
      }
      else {
        while (status != null) {
          return false;
        }
      }
      if (body != null)
      {
        if (body.equals(body)) {}
      }
      else {
        while (body != null) {
          return false;
        }
      }
      if (bodyTracking != null)
      {
        if (bodyTracking.equals(bodyTracking)) {}
      }
      else {
        while (bodyTracking != null) {
          return false;
        }
      }
      if (openTracking != null)
      {
        if (openTracking.equals(openTracking)) {}
      }
      else {
        while (openTracking != null) {
          return false;
        }
      }
      if (legalText != null)
      {
        if (legalText.equals(legalText)) {}
      }
      else {
        while (legalText != null) {
          return false;
        }
      }
      if (subContent == null) {
        break;
      }
    } while (subContent.equals(subContent));
    for (;;)
    {
      return false;
      if (subContent == null) {
        break;
      }
    }
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasSpInmailType) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasStatus) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasBody) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(body);
    }
    j = i + 1;
    i = j;
    if (hasBodyTracking) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(bodyTracking);
    }
    j = i + 1;
    i = j;
    if (hasOpenTracking) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(openTracking);
    }
    j = i + 1;
    i = j;
    if (hasLegalText)
    {
      i = j + 1;
      if (legalText._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(legalText._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasSubContent)
      {
        i = j + 1;
        if (subContent._cachedId == null) {
          break label229;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(subContent._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i += legalText.getSerializedSize();
      break;
      label229:
      i += subContent.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i2 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    label76:
    int n;
    if (spInmailType != null)
    {
      i = spInmailType.hashCode();
      if (status == null) {
        break label176;
      }
      j = status.hashCode();
      if (body == null) {
        break label181;
      }
      k = body.hashCode();
      if (bodyTracking == null) {
        break label186;
      }
      m = bodyTracking.hashCode();
      if (openTracking == null) {
        break label192;
      }
      n = openTracking.hashCode();
      label92:
      if (legalText == null) {
        break label198;
      }
    }
    label176:
    label181:
    label186:
    label192:
    label198:
    for (int i1 = legalText.hashCode();; i1 = 0)
    {
      if (subContent != null) {
        i2 = subContent.hashCode();
      }
      i = (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31 + i2;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
      m = 0;
      break label76;
      n = 0;
      break label92;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SpInmailContent");
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
    label168:
    label194:
    label220:
    label246:
    label306:
    label409:
    label419:
    label429:
    label439:
    label449:
    label474:
    label484:
    label509:
    label517:
    label519:
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
        localByteBuffer.putInt(1315362582);
        if (hasSpInmailType)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, spInmailType.ordinal());
          if (!hasStatus) {
            break label409;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, status.ordinal());
          if (!hasBody) {
            break label419;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, body);
          if (!hasBodyTracking) {
            break label429;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, bodyTracking);
          if (!hasOpenTracking) {
            break label439;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, openTracking);
          if (!hasLegalText) {
            break label474;
          }
          localByteBuffer.put((byte)1);
          if (legalText._cachedId == null) {
            break label449;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, legalText._cachedId);
          legalText.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasSubContent) {
            break label509;
          }
          localByteBuffer.put((byte)1);
          if (subContent._cachedId == null) {
            break label484;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, subContent._cachedId);
          subContent.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label517;
          }
          if (str != null) {
            break label519;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label168;
          localByteBuffer.put((byte)0);
          break label194;
          localByteBuffer.put((byte)0);
          break label220;
          localByteBuffer.put((byte)0);
          break label246;
          localByteBuffer.put((byte)1);
          legalText.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label306;
          localByteBuffer.put((byte)0);
          break label306;
          localByteBuffer.put((byte)1);
          subContent.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
  
  public static final class SubContent
    implements FissileDataModel<SubContent>, UnionTemplate<SubContent>
  {
    public static final SpInmailContentBuilder.SubContentBuilder BUILDER = SpInmailContentBuilder.SubContentBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final boolean hasSpInmailLeadGenSubContentValue;
    public final boolean hasSpInmailStandardSubContentValue;
    public final SpInmailLeadGenSubContent spInmailLeadGenSubContentValue;
    public final SpInmailStandardSubContent spInmailStandardSubContentValue;
    
    SubContent(SpInmailStandardSubContent paramSpInmailStandardSubContent, SpInmailLeadGenSubContent paramSpInmailLeadGenSubContent, boolean paramBoolean1, boolean paramBoolean2)
    {
      spInmailStandardSubContentValue = paramSpInmailStandardSubContent;
      spInmailLeadGenSubContentValue = paramSpInmailLeadGenSubContent;
      hasSpInmailStandardSubContentValue = paramBoolean1;
      hasSpInmailLeadGenSubContentValue = paramBoolean2;
      _cachedId = null;
    }
    
    public final SubContent accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      Object localObject2 = null;
      boolean bool1 = false;
      Object localObject1;
      if (hasSpInmailStandardSubContentValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.messaging.event.message.spinmail.SpInmailStandardSubContent");
        if (paramDataProcessor.shouldAcceptTransitively())
        {
          localObject1 = spInmailStandardSubContentValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label149;
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
        if (hasSpInmailLeadGenSubContentValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.messaging.event.message.spinmail.SpInmailLeadGenSubContent");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label158;
          }
          localObject1 = spInmailLeadGenSubContentValue.accept(paramDataProcessor);
          label95:
          if (localObject1 == null) {
            break label176;
          }
        }
      }
      label149:
      label158:
      label176:
      for (boolean bool2 = true;; bool2 = false)
      {
        paramDataProcessor.endUnion();
        if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
          break label181;
        }
        return new SubContent((SpInmailStandardSubContent)localObject2, (SpInmailLeadGenSubContent)localObject1, bool1, bool2);
        localObject1 = (SpInmailStandardSubContent)paramDataProcessor.processDataTemplate(spInmailStandardSubContentValue);
        break;
        bool1 = false;
        localObject2 = localObject1;
        break label56;
        localObject1 = (SpInmailLeadGenSubContent)paramDataProcessor.processDataTemplate(spInmailLeadGenSubContentValue);
        break label95;
      }
      label181:
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
        paramObject = (SubContent)paramObject;
        if (spInmailStandardSubContentValue != null)
        {
          if (spInmailStandardSubContentValue.equals(spInmailStandardSubContentValue)) {}
        }
        else {
          while (spInmailStandardSubContentValue != null) {
            return false;
          }
        }
        if (spInmailLeadGenSubContentValue == null) {
          break;
        }
      } while (spInmailLeadGenSubContentValue.equals(spInmailLeadGenSubContentValue));
      for (;;)
      {
        return false;
        if (spInmailLeadGenSubContentValue == null) {
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
      if (hasSpInmailStandardSubContentValue)
      {
        if (spInmailStandardSubContentValue._cachedId != null) {
          i = PegasusBinaryUtils.getEncodedLength(spInmailStandardSubContentValue._cachedId) + 9;
        }
      }
      else
      {
        int j = i + 1;
        i = j;
        if (hasSpInmailLeadGenSubContentValue)
        {
          i = j + 1;
          if (spInmailLeadGenSubContentValue._cachedId == null) {
            break label114;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(spInmailLeadGenSubContentValue._cachedId);
        }
      }
      for (;;)
      {
        __sizeOfObject = i;
        return i;
        i = spInmailStandardSubContentValue.getSerializedSize() + 7;
        break;
        label114:
        i += spInmailLeadGenSubContentValue.getSerializedSize();
      }
    }
    
    public final int hashCode()
    {
      int j = 0;
      if (_cachedHashCode > 0) {
        return _cachedHashCode;
      }
      if (spInmailStandardSubContentValue != null) {}
      for (int i = spInmailStandardSubContentValue.hashCode();; i = 0)
      {
        if (spInmailLeadGenSubContentValue != null) {
          j = spInmailLeadGenSubContentValue.hashCode();
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
        throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SubContent");
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
          localByteBuffer.putInt(-1762311460);
          if (hasSpInmailStandardSubContentValue)
          {
            localByteBuffer.put((byte)1);
            if (spInmailStandardSubContentValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, spInmailStandardSubContentValue._cachedId);
              spInmailStandardSubContentValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasSpInmailLeadGenSubContentValue) {
                break label323;
              }
              localByteBuffer.put((byte)1);
              if (spInmailLeadGenSubContentValue._cachedId == null) {
                break label298;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, spInmailLeadGenSubContentValue._cachedId);
              spInmailLeadGenSubContentValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
            spInmailStandardSubContentValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            spInmailLeadGenSubContentValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailContent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */