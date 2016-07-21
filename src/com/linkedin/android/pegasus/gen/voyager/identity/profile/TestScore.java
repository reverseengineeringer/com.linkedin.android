package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Date;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class TestScore
  implements FissileDataModel<TestScore>, RecordTemplate<TestScore>
{
  public static final TestScoreBuilder BUILDER = TestScoreBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final Date date;
  public final String description;
  public final Urn entityUrn;
  public final boolean hasDate;
  public final boolean hasDescription;
  public final boolean hasEntityUrn;
  public final boolean hasName;
  public final boolean hasOccupation;
  public final boolean hasScore;
  public final String name;
  public final Urn occupation;
  public final String score;
  
  TestScore(Urn paramUrn1, String paramString1, Date paramDate, String paramString2, String paramString3, Urn paramUrn2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    entityUrn = paramUrn1;
    name = paramString1;
    date = paramDate;
    score = paramString2;
    description = paramString3;
    occupation = paramUrn2;
    hasEntityUrn = paramBoolean1;
    hasName = paramBoolean2;
    hasDate = paramBoolean3;
    hasScore = paramBoolean4;
    hasDescription = paramBoolean5;
    hasOccupation = paramBoolean6;
    paramString1 = UrnCoercer.INSTANCE;
    _cachedId = UrnCoercer.coerceFromCustomType(paramUrn1);
  }
  
  public final TestScore accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    if (hasName)
    {
      paramDataProcessor.startRecordField$505cff1c("name");
      paramDataProcessor.processString(name);
    }
    Object localObject = null;
    boolean bool = false;
    if (hasDate)
    {
      paramDataProcessor.startRecordField$505cff1c("date");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label233;
      }
      localObject = date.accept(paramDataProcessor);
      if (localObject == null) {
        break label250;
      }
    }
    label233:
    label250:
    for (bool = true;; bool = false)
    {
      if (hasScore)
      {
        paramDataProcessor.startRecordField$505cff1c("score");
        paramDataProcessor.processString(score);
      }
      if (hasDescription)
      {
        paramDataProcessor.startRecordField$505cff1c("description");
        paramDataProcessor.processString(description);
      }
      if (hasOccupation)
      {
        paramDataProcessor.startRecordField$505cff1c("occupation");
        UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
        paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(occupation));
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label305;
      }
      try
      {
        if (hasName) {
          break label255;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.TestScore", "name");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject = (Date)paramDataProcessor.processDataTemplate(date);
      break;
    }
    label255:
    return new TestScore(entityUrn, name, (Date)localObject, score, description, occupation, hasEntityUrn, hasName, bool, hasScore, hasDescription, hasOccupation);
    label305:
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
      paramObject = (TestScore)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (name != null)
      {
        if (name.equals(name)) {}
      }
      else {
        while (name != null) {
          return false;
        }
      }
      if (date != null)
      {
        if (date.equals(date)) {}
      }
      else {
        while (date != null) {
          return false;
        }
      }
      if (score != null)
      {
        if (score.equals(score)) {}
      }
      else {
        while (score != null) {
          return false;
        }
      }
      if (description != null)
      {
        if (description.equals(description)) {}
      }
      else {
        while (description != null) {
          return false;
        }
      }
      if (occupation == null) {
        break;
      }
    } while (occupation.equals(occupation));
    for (;;)
    {
      return false;
      if (occupation == null) {
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
    UrnCoercer localUrnCoercer;
    if (hasEntityUrn)
    {
      localUrnCoercer = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasName) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(name);
    }
    j = i + 1;
    i = j;
    if (hasDate)
    {
      i = j + 1;
      if (date._cachedId == null) {
        break label201;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(date._cachedId);
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasScore) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(score);
      }
      j = i + 1;
      i = j;
      if (hasDescription) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(description);
      }
      j = i + 1;
      i = j;
      if (hasOccupation)
      {
        localUrnCoercer = UrnCoercer.INSTANCE;
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(occupation));
      }
      __sizeOfObject = i;
      return i;
      label201:
      i += date.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (name == null) {
        break label154;
      }
      j = name.hashCode();
      if (date == null) {
        break label159;
      }
      k = date.hashCode();
      if (score == null) {
        break label164;
      }
      m = score.hashCode();
      label76:
      if (description == null) {
        break label170;
      }
    }
    label154:
    label159:
    label164:
    label170:
    for (int n = description.hashCode();; n = 0)
    {
      if (occupation != null) {
        i1 = occupation.hashCode();
      }
      i = (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31 + i1;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building TestScore");
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
    label170:
    label230:
    label256:
    label282:
    label359:
    label369:
    label394:
    label404:
    label414:
    label424:
    label432:
    label434:
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
        localByteBuffer.putInt(-598865038);
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasName) {
            break label359;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, name);
          if (!hasDate) {
            break label394;
          }
          localByteBuffer.put((byte)1);
          if (date._cachedId == null) {
            break label369;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, date._cachedId);
          date.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasScore) {
            break label404;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, score);
          if (!hasDescription) {
            break label414;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, description);
          if (!hasOccupation) {
            break label424;
          }
          localByteBuffer.put((byte)1);
          localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(occupation));
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label432;
          }
          if (str != null) {
            break label434;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label170;
          localByteBuffer.put((byte)1);
          date.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)0);
          break label256;
          localByteBuffer.put((byte)0);
          break label282;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.TestScore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */