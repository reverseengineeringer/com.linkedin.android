package com.linkedin.android.pegasus.gen.voyager.entities.school;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.PhoneNumber;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SchoolDetails
  implements FissileDataModel<SchoolDetails>, RecordTemplate<SchoolDetails>
{
  public static final SchoolDetailsBuilder BUILDER = SchoolDetailsBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String address;
  public final String emailAddress;
  public final float graduationPercentage;
  public final boolean hasAddress;
  public final boolean hasEmailAddress;
  public final boolean hasGraduationPercentage;
  public final boolean hasHomepageUrl;
  public final boolean hasInStateTuition;
  public final boolean hasOutOfStateTuition;
  public final boolean hasPhoneNumber;
  public final boolean hasSchoolType;
  public final boolean hasTotalPopulation;
  public final boolean hasYearLevel;
  public final String homepageUrl;
  public final String inStateTuition;
  public final String outOfStateTuition;
  public final PhoneNumber phoneNumber;
  public final String schoolType;
  public final int totalPopulation;
  public final String yearLevel;
  
  SchoolDetails(int paramInt, String paramString1, String paramString2, PhoneNumber paramPhoneNumber, String paramString3, String paramString4, String paramString5, float paramFloat, String paramString6, String paramString7, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10)
  {
    totalPopulation = paramInt;
    homepageUrl = paramString1;
    emailAddress = paramString2;
    phoneNumber = paramPhoneNumber;
    schoolType = paramString3;
    address = paramString4;
    yearLevel = paramString5;
    graduationPercentage = paramFloat;
    inStateTuition = paramString6;
    outOfStateTuition = paramString7;
    hasTotalPopulation = paramBoolean1;
    hasHomepageUrl = paramBoolean2;
    hasEmailAddress = paramBoolean3;
    hasPhoneNumber = paramBoolean4;
    hasSchoolType = paramBoolean5;
    hasAddress = paramBoolean6;
    hasYearLevel = paramBoolean7;
    hasGraduationPercentage = paramBoolean8;
    hasInStateTuition = paramBoolean9;
    hasOutOfStateTuition = paramBoolean10;
    _cachedId = null;
  }
  
  public final SchoolDetails accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasTotalPopulation)
    {
      paramDataProcessor.startRecordField$505cff1c("totalPopulation");
      paramDataProcessor.processInt(totalPopulation);
    }
    if (hasHomepageUrl)
    {
      paramDataProcessor.startRecordField$505cff1c("homepageUrl");
      paramDataProcessor.processString(homepageUrl);
    }
    if (hasEmailAddress)
    {
      paramDataProcessor.startRecordField$505cff1c("emailAddress");
      paramDataProcessor.processString(emailAddress);
    }
    PhoneNumber localPhoneNumber = null;
    boolean bool = false;
    if (hasPhoneNumber)
    {
      paramDataProcessor.startRecordField$505cff1c("phoneNumber");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label371;
      }
      localPhoneNumber = phoneNumber.accept(paramDataProcessor);
      if (localPhoneNumber == null) {
        break label388;
      }
    }
    label371:
    label388:
    for (bool = true;; bool = false)
    {
      if (hasSchoolType)
      {
        paramDataProcessor.startRecordField$505cff1c("schoolType");
        paramDataProcessor.processString(schoolType);
      }
      if (hasAddress)
      {
        paramDataProcessor.startRecordField$505cff1c("address");
        paramDataProcessor.processString(address);
      }
      if (hasYearLevel)
      {
        paramDataProcessor.startRecordField$505cff1c("yearLevel");
        paramDataProcessor.processString(yearLevel);
      }
      if (hasGraduationPercentage)
      {
        paramDataProcessor.startRecordField$505cff1c("graduationPercentage");
        paramDataProcessor.processFloat(graduationPercentage);
      }
      if (hasInStateTuition)
      {
        paramDataProcessor.startRecordField$505cff1c("inStateTuition");
        paramDataProcessor.processString(inStateTuition);
      }
      if (hasOutOfStateTuition)
      {
        paramDataProcessor.startRecordField$505cff1c("outOfStateTuition");
        paramDataProcessor.processString(outOfStateTuition);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label393;
      }
      return new SchoolDetails(totalPopulation, homepageUrl, emailAddress, localPhoneNumber, schoolType, address, yearLevel, graduationPercentage, inStateTuition, outOfStateTuition, hasTotalPopulation, hasHomepageUrl, hasEmailAddress, bool, hasSchoolType, hasAddress, hasYearLevel, hasGraduationPercentage, hasInStateTuition, hasOutOfStateTuition);
      localPhoneNumber = (PhoneNumber)paramDataProcessor.processDataTemplate(phoneNumber);
      break;
    }
    label393:
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
      paramObject = (SchoolDetails)paramObject;
      if (totalPopulation != totalPopulation) {
        return false;
      }
      if (homepageUrl != null)
      {
        if (homepageUrl.equals(homepageUrl)) {}
      }
      else {
        while (homepageUrl != null) {
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
      if (phoneNumber != null)
      {
        if (phoneNumber.equals(phoneNumber)) {}
      }
      else {
        while (phoneNumber != null) {
          return false;
        }
      }
      if (schoolType != null)
      {
        if (schoolType.equals(schoolType)) {}
      }
      else {
        while (schoolType != null) {
          return false;
        }
      }
      if (address != null)
      {
        if (address.equals(address)) {}
      }
      else {
        while (address != null) {
          return false;
        }
      }
      if (yearLevel != null)
      {
        if (yearLevel.equals(yearLevel)) {}
      }
      else {
        while (yearLevel != null) {
          return false;
        }
      }
      if (graduationPercentage != graduationPercentage) {
        return false;
      }
      if (inStateTuition != null)
      {
        if (inStateTuition.equals(inStateTuition)) {}
      }
      else {
        while (inStateTuition != null) {
          return false;
        }
      }
      if (outOfStateTuition == null) {
        break;
      }
    } while (outOfStateTuition.equals(outOfStateTuition));
    for (;;)
    {
      return false;
      if (outOfStateTuition == null) {
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
    if (hasTotalPopulation) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasHomepageUrl) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(homepageUrl);
    }
    j = i + 1;
    i = j;
    if (hasEmailAddress) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(emailAddress);
    }
    j = i + 1;
    i = j;
    if (hasPhoneNumber)
    {
      i = j + 1;
      if (phoneNumber._cachedId == null) {
        break label274;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(phoneNumber._cachedId);
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasSchoolType) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(schoolType);
      }
      j = i + 1;
      i = j;
      if (hasAddress) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(address);
      }
      j = i + 1;
      i = j;
      if (hasYearLevel) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(yearLevel);
      }
      j = i + 1;
      i = j;
      if (hasGraduationPercentage) {
        i = j + 4;
      }
      j = i + 1;
      i = j;
      if (hasInStateTuition) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(inStateTuition);
      }
      j = i + 1;
      i = j;
      if (hasOutOfStateTuition) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(outOfStateTuition);
      }
      __sizeOfObject = i;
      return i;
      label274:
      i += phoneNumber.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i4 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i5 = totalPopulation;
    int i;
    int j;
    label51:
    int k;
    label66:
    int m;
    label82:
    int n;
    label98:
    int i1;
    label114:
    int i2;
    if (homepageUrl != null)
    {
      i = homepageUrl.hashCode();
      if (emailAddress == null) {
        break label234;
      }
      j = emailAddress.hashCode();
      if (phoneNumber == null) {
        break label239;
      }
      k = phoneNumber.hashCode();
      if (schoolType == null) {
        break label244;
      }
      m = schoolType.hashCode();
      if (address == null) {
        break label250;
      }
      n = address.hashCode();
      if (yearLevel == null) {
        break label256;
      }
      i1 = yearLevel.hashCode();
      if (graduationPercentage == 0.0F) {
        break label262;
      }
      i2 = Float.floatToIntBits(graduationPercentage);
      label132:
      if (inStateTuition == null) {
        break label268;
      }
    }
    label234:
    label239:
    label244:
    label250:
    label256:
    label262:
    label268:
    for (int i3 = inStateTuition.hashCode();; i3 = 0)
    {
      if (outOfStateTuition != null) {
        i4 = outOfStateTuition.hashCode();
      }
      i = (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + (i5 + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i4;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label51;
      k = 0;
      break label66;
      m = 0;
      break label82;
      n = 0;
      break label98;
      i1 = 0;
      break label114;
      i2 = 0;
      break label132;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SchoolDetails");
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
    label160:
    label186:
    label246:
    label272:
    label298:
    label324:
    label348:
    label374:
    label443:
    label453:
    label463:
    label488:
    label498:
    label508:
    label518:
    label528:
    label538:
    label548:
    label556:
    label558:
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
        localByteBuffer.putInt(-413774918);
        if (hasTotalPopulation)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(totalPopulation);
          if (!hasHomepageUrl) {
            break label443;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, homepageUrl);
          if (!hasEmailAddress) {
            break label453;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, emailAddress);
          if (!hasPhoneNumber) {
            break label488;
          }
          localByteBuffer.put((byte)1);
          if (phoneNumber._cachedId == null) {
            break label463;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, phoneNumber._cachedId);
          phoneNumber.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasSchoolType) {
            break label498;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, schoolType);
          if (!hasAddress) {
            break label508;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, address);
          if (!hasYearLevel) {
            break label518;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, yearLevel);
          if (!hasGraduationPercentage) {
            break label528;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putFloat(graduationPercentage);
          if (!hasInStateTuition) {
            break label538;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, inStateTuition);
          if (!hasOutOfStateTuition) {
            break label548;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, outOfStateTuition);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label556;
          }
          if (str != null) {
            break label558;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label160;
          localByteBuffer.put((byte)0);
          break label186;
          localByteBuffer.put((byte)1);
          phoneNumber.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label246;
          localByteBuffer.put((byte)0);
          break label246;
          localByteBuffer.put((byte)0);
          break label272;
          localByteBuffer.put((byte)0);
          break label298;
          localByteBuffer.put((byte)0);
          break label324;
          localByteBuffer.put((byte)0);
          break label348;
          localByteBuffer.put((byte)0);
          break label374;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolDetails
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */