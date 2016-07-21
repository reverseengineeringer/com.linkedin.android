package com.linkedin.android.pegasus.gen.voyager.messaging.event.message;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntityInsights;
import com.linkedin.android.pegasus.gen.voyager.messaging.shared.ContactInfo;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class InmailContent
  implements FissileDataModel<InmailContent>, RecordTemplate<InmailContent>
{
  public static final InmailContentBuilder BUILDER = InmailContentBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final InmailActionType actionType;
  public final boolean hasActionType;
  public final boolean hasInmailType;
  public final boolean hasRecruiterInmail;
  public final boolean hasRequestContactInfo;
  public final boolean hasSenderCompanyInsights;
  public final boolean hasSenderContactInfo;
  public final boolean hasStatus;
  public final InmailType inmailType;
  public final boolean recruiterInmail;
  public final boolean requestContactInfo;
  public final EntityInsights senderCompanyInsights;
  public final ContactInfo senderContactInfo;
  public final InmailStatus status;
  
  InmailContent(InmailType paramInmailType, InmailStatus paramInmailStatus, InmailActionType paramInmailActionType, boolean paramBoolean1, ContactInfo paramContactInfo, boolean paramBoolean2, EntityInsights paramEntityInsights, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9)
  {
    inmailType = paramInmailType;
    status = paramInmailStatus;
    actionType = paramInmailActionType;
    requestContactInfo = paramBoolean1;
    senderContactInfo = paramContactInfo;
    recruiterInmail = paramBoolean2;
    senderCompanyInsights = paramEntityInsights;
    hasInmailType = paramBoolean3;
    hasStatus = paramBoolean4;
    hasActionType = paramBoolean5;
    hasRequestContactInfo = paramBoolean6;
    hasSenderContactInfo = paramBoolean7;
    hasRecruiterInmail = paramBoolean8;
    hasSenderCompanyInsights = paramBoolean9;
    _cachedId = null;
  }
  
  public final InmailContent accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasInmailType)
    {
      paramDataProcessor.startRecordField$505cff1c("inmailType");
      paramDataProcessor.processEnum(inmailType);
    }
    if (hasStatus)
    {
      paramDataProcessor.startRecordField$505cff1c("status");
      paramDataProcessor.processEnum(status);
    }
    if (hasActionType)
    {
      paramDataProcessor.startRecordField$505cff1c("actionType");
      paramDataProcessor.processEnum(actionType);
    }
    if (hasRequestContactInfo)
    {
      paramDataProcessor.startRecordField$505cff1c("requestContactInfo");
      paramDataProcessor.processBoolean(requestContactInfo);
    }
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    if (hasSenderContactInfo)
    {
      paramDataProcessor.startRecordField$505cff1c("senderContactInfo");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = senderContactInfo.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label289;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label156:
      if (hasRecruiterInmail)
      {
        paramDataProcessor.startRecordField$505cff1c("recruiterInmail");
        paramDataProcessor.processBoolean(recruiterInmail);
      }
      localObject1 = null;
      bool2 = false;
      if (hasSenderCompanyInsights)
      {
        paramDataProcessor.startRecordField$505cff1c("senderCompanyInsights");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label298;
        }
        localObject1 = senderCompanyInsights.accept(paramDataProcessor);
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
        break label375;
      }
      try
      {
        if (hasInmailType) {
          break label321;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.event.message.InmailContent", "inmailType");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (ContactInfo)paramDataProcessor.processDataTemplate(senderContactInfo);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label156;
      localObject1 = (EntityInsights)paramDataProcessor.processDataTemplate(senderCompanyInsights);
      break label220;
    }
    label321:
    return new InmailContent(inmailType, status, actionType, requestContactInfo, (ContactInfo)localObject2, recruiterInmail, (EntityInsights)localObject1, hasInmailType, hasStatus, hasActionType, hasRequestContactInfo, bool1, hasRecruiterInmail, bool2);
    label375:
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
      paramObject = (InmailContent)paramObject;
      if (inmailType != null)
      {
        if (inmailType.equals(inmailType)) {}
      }
      else {
        while (inmailType != null) {
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
      if (actionType != null)
      {
        if (actionType.equals(actionType)) {}
      }
      else {
        while (actionType != null) {
          return false;
        }
      }
      if (requestContactInfo != requestContactInfo) {
        return false;
      }
      if (senderContactInfo != null)
      {
        if (senderContactInfo.equals(senderContactInfo)) {}
      }
      else {
        while (senderContactInfo != null) {
          return false;
        }
      }
      if (recruiterInmail != recruiterInmail) {
        return false;
      }
      if (senderCompanyInsights == null) {
        break;
      }
    } while (senderCompanyInsights.equals(senderCompanyInsights));
    for (;;)
    {
      return false;
      if (senderCompanyInsights == null) {
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
    if (hasInmailType) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasStatus) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasActionType) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasRequestContactInfo) {
      i = j + 1;
    }
    j = i + 1;
    i = j;
    if (hasSenderContactInfo)
    {
      i = j + 1;
      if (senderContactInfo._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(senderContactInfo._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasRecruiterInmail) {
        i = j + 1;
      }
      j = i + 1;
      i = j;
      if (hasSenderCompanyInsights)
      {
        i = j + 1;
        if (senderCompanyInsights._cachedId == null) {
          break label205;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(senderCompanyInsights._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i += senderContactInfo.getSerializedSize();
      break;
      label205:
      i += senderCompanyInsights.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i1 = 1;
    int i2 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label48:
    int k;
    label63:
    int m;
    label73:
    int n;
    if (inmailType != null)
    {
      i = inmailType.hashCode();
      if (status == null) {
        break label164;
      }
      j = status.hashCode();
      if (actionType == null) {
        break label169;
      }
      k = actionType.hashCode();
      if (!requestContactInfo) {
        break label174;
      }
      m = 1;
      if (senderContactInfo == null) {
        break label180;
      }
      n = senderContactInfo.hashCode();
      label89:
      if (!recruiterInmail) {
        break label186;
      }
    }
    for (;;)
    {
      if (senderCompanyInsights != null) {
        i2 = senderCompanyInsights.hashCode();
      }
      i = ((n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31 + i1) * 31 + i2;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      label164:
      j = 0;
      break label48;
      label169:
      k = 0;
      break label63;
      label174:
      m = 0;
      break label73;
      label180:
      n = 0;
      break label89;
      label186:
      i1 = 0;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building InmailContent");
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
    label197:
    label221:
    label230:
    label290:
    label314:
    label323:
    label426:
    label436:
    label446:
    label452:
    label462:
    label487:
    label497:
    label503:
    label513:
    label538:
    label546:
    label548:
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
        localByteBuffer.putInt(-1567132740);
        if (hasInmailType)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, inmailType.ordinal());
          if (!hasStatus) {
            break label426;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, status.ordinal());
          if (!hasActionType) {
            break label436;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, actionType.ordinal());
          if (!hasRequestContactInfo) {
            break label452;
          }
          localByteBuffer.put((byte)1);
          if (!requestContactInfo) {
            break label446;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasSenderContactInfo) {
            break label487;
          }
          localByteBuffer.put((byte)1);
          if (senderContactInfo._cachedId == null) {
            break label462;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, senderContactInfo._cachedId);
          senderContactInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasRecruiterInmail) {
            break label503;
          }
          localByteBuffer.put((byte)1);
          if (!recruiterInmail) {
            break label497;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasSenderCompanyInsights) {
            break label538;
          }
          localByteBuffer.put((byte)1);
          if (senderCompanyInsights._cachedId == null) {
            break label513;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, senderCompanyInsights._cachedId);
          senderCompanyInsights.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label546;
          }
          if (str != null) {
            break label548;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label168;
          localByteBuffer.put((byte)0);
          break label197;
          i = 0;
          break label221;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          senderContactInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label290;
          localByteBuffer.put((byte)0);
          break label290;
          i = 0;
          break label314;
          localByteBuffer.put((byte)0);
          break label323;
          localByteBuffer.put((byte)1);
          senderCompanyInsights.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.event.message.InmailContent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */