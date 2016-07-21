package com.linkedin.android.pegasus.gen.voyager.entities.job;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.PhoneNumber;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Applicant
  implements FissileDataModel<Applicant>, RecordTemplate<Applicant>
{
  public static final ApplicantBuilder BUILDER = ApplicantBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String emailAddress;
  public final boolean hasEmailAddress;
  public final boolean hasLocation;
  public final boolean hasMiniProfile;
  public final boolean hasOtherEmailAddresses;
  public final boolean hasPhoneNumber;
  public final String location;
  public final MiniProfile miniProfile;
  public final List<String> otherEmailAddresses;
  public final PhoneNumber phoneNumber;
  
  Applicant(MiniProfile paramMiniProfile, String paramString1, PhoneNumber paramPhoneNumber, String paramString2, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    miniProfile = paramMiniProfile;
    location = paramString1;
    phoneNumber = paramPhoneNumber;
    emailAddress = paramString2;
    if (paramList == null) {}
    for (paramMiniProfile = null;; paramMiniProfile = Collections.unmodifiableList(paramList))
    {
      otherEmailAddresses = paramMiniProfile;
      hasMiniProfile = paramBoolean1;
      hasLocation = paramBoolean2;
      hasPhoneNumber = paramBoolean3;
      hasEmailAddress = paramBoolean4;
      hasOtherEmailAddresses = paramBoolean5;
      _cachedId = null;
      return;
    }
  }
  
  public final Applicant accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    boolean bool2;
    if (hasMiniProfile)
    {
      paramDataProcessor.startRecordField$505cff1c("miniProfile");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = miniProfile.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label310;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      if (hasLocation)
      {
        paramDataProcessor.startRecordField$505cff1c("location");
        paramDataProcessor.processString(location);
      }
      localObject3 = null;
      bool2 = false;
      if (hasPhoneNumber)
      {
        paramDataProcessor.startRecordField$505cff1c("phoneNumber");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label319;
        }
        localObject1 = phoneNumber.accept(paramDataProcessor);
        label121:
        if (localObject1 == null) {
          break label337;
        }
        bool2 = true;
      }
    }
    for (Object localObject3 = localObject1;; localObject3 = localObject1)
    {
      if (hasEmailAddress)
      {
        paramDataProcessor.startRecordField$505cff1c("emailAddress");
        paramDataProcessor.processString(emailAddress);
      }
      localObject1 = null;
      Iterator localIterator = null;
      bool3 = false;
      if (!hasOtherEmailAddresses) {
        break label361;
      }
      paramDataProcessor.startRecordField$505cff1c("otherEmailAddresses");
      otherEmailAddresses.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localIterator;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      int i = 0;
      localIterator = otherEmailAddresses.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processString(str);
        if (localObject1 != null) {
          ((List)localObject1).add(str);
        }
        i += 1;
      }
      localObject1 = (MiniProfile)paramDataProcessor.processDataTemplate(miniProfile);
      break;
      label310:
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      label319:
      localObject1 = (PhoneNumber)paramDataProcessor.processDataTemplate(phoneNumber);
      break label121;
      label337:
      bool2 = false;
    }
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool3 = true;; bool3 = false)
    {
      label361:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label508;
      }
      if (!hasOtherEmailAddresses) {
        localObject1 = Collections.emptyList();
      }
      try
      {
        if (hasMiniProfile) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.job.Applicant", "miniProfile");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (otherEmailAddresses != null)
    {
      paramDataProcessor = otherEmailAddresses.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((String)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.entities.job.Applicant", "otherEmailAddresses");
        }
      }
    }
    return new Applicant((MiniProfile)localObject2, location, (PhoneNumber)localObject3, emailAddress, (List)localObject1, bool1, hasLocation, bool2, hasEmailAddress, bool3);
    label508:
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
      paramObject = (Applicant)paramObject;
      if (miniProfile != null)
      {
        if (miniProfile.equals(miniProfile)) {}
      }
      else {
        while (miniProfile != null) {
          return false;
        }
      }
      if (location != null)
      {
        if (location.equals(location)) {}
      }
      else {
        while (location != null) {
          return false;
        }
      }
      if (phoneNumber != null)
      {
        if (phoneNumber.equals(phoneNumber)) {}
      }
      else {
        while (phoneNumber != null) {
          return false;
        }
      }
      if (emailAddress != null)
      {
        if (emailAddress.equals(emailAddress)) {}
      }
      else {
        while (emailAddress != null) {
          return false;
        }
      }
      if (otherEmailAddresses == null) {
        break;
      }
    } while (otherEmailAddresses.equals(otherEmailAddresses));
    for (;;)
    {
      return false;
      if (otherEmailAddresses == null) {
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
    if (hasMiniProfile)
    {
      if (miniProfile._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(miniProfile._cachedId) + 9;
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasLocation) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(location);
      }
      j = i + 1;
      i = j;
      if (hasPhoneNumber)
      {
        i = j + 1;
        if (phoneNumber._cachedId == null) {
          break label215;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(phoneNumber._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasEmailAddress) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(emailAddress);
      }
      i += 1;
      j = i;
      if (!hasOtherEmailAddresses) {
        break label228;
      }
      i += 2;
      Iterator localIterator = otherEmailAddresses.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength((String)localIterator.next());
      }
      i = miniProfile.getSerializedSize() + 7;
      break;
      label215:
      i += phoneNumber.getSerializedSize();
    }
    label228:
    __sizeOfObject = j;
    return j;
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
    if (miniProfile != null)
    {
      i = miniProfile.hashCode();
      if (location == null) {
        break label134;
      }
      j = location.hashCode();
      if (phoneNumber == null) {
        break label139;
      }
      k = phoneNumber.hashCode();
      label60:
      if (emailAddress == null) {
        break label144;
      }
    }
    label134:
    label139:
    label144:
    for (int m = emailAddress.hashCode();; m = 0)
    {
      if (otherEmailAddresses != null) {
        n = otherEmailAddresses.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Applicant");
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
    label196:
    label256:
    label390:
    label400:
    label425:
    label435:
    label445:
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
        localByteBuffer.putInt(273881679);
        if (hasMiniProfile)
        {
          localByteBuffer.put((byte)1);
          if (miniProfile._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, miniProfile._cachedId);
            miniProfile.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasLocation) {
              break label390;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, location);
            if (!hasPhoneNumber) {
              break label425;
            }
            localByteBuffer.put((byte)1);
            if (phoneNumber._cachedId == null) {
              break label400;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, phoneNumber._cachedId);
            phoneNumber.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasEmailAddress) {
              break label435;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, emailAddress);
          }
        }
        for (;;)
        {
          if (!hasOtherEmailAddresses) {
            break label445;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, otherEmailAddresses.size());
          Iterator localIterator = otherEmailAddresses.iterator();
          while (localIterator.hasNext()) {
            paramFissionAdapter.writeString(localByteBuffer, (String)localIterator.next());
          }
          localByteBuffer.put((byte)1);
          miniProfile.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label196;
          localByteBuffer.put((byte)1);
          phoneNumber.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label256;
          localByteBuffer.put((byte)0);
          break label256;
          localByteBuffer.put((byte)0);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.job.Applicant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */