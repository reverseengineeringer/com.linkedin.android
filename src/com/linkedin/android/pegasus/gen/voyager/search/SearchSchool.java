package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public class SearchSchool
  implements FissileDataModel<SearchSchool>, RecordTemplate<SearchSchool>
{
  public static final SearchSchoolBuilder BUILDER = SearchSchoolBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final Urn backendUrn;
  public final FollowingInfo following;
  public final boolean hasBackendUrn;
  public final boolean hasFollowing;
  public final boolean hasId;
  public final boolean hasLocation;
  public final boolean hasSchool;
  public final boolean hasStudentAndAlumniCount;
  public final String id;
  public final String location;
  public final MiniSchool school;
  public final int studentAndAlumniCount;
  
  SearchSchool(String paramString1, Urn paramUrn, MiniSchool paramMiniSchool, String paramString2, int paramInt, FollowingInfo paramFollowingInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    id = paramString1;
    backendUrn = paramUrn;
    school = paramMiniSchool;
    location = paramString2;
    studentAndAlumniCount = paramInt;
    following = paramFollowingInfo;
    hasId = paramBoolean1;
    hasBackendUrn = paramBoolean2;
    hasSchool = paramBoolean3;
    hasLocation = paramBoolean4;
    hasStudentAndAlumniCount = paramBoolean5;
    hasFollowing = paramBoolean6;
    _cachedId = null;
  }
  
  public final SearchSchool accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasId)
    {
      paramDataProcessor.startRecordField$505cff1c("id");
      paramDataProcessor.processString(id);
    }
    Object localObject1;
    if (hasBackendUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("backendUrn");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(backendUrn));
    }
    Object localObject2 = null;
    boolean bool1 = false;
    if (hasSchool)
    {
      paramDataProcessor.startRecordField$505cff1c("school");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = school.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label272;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label114:
      if (hasLocation)
      {
        paramDataProcessor.startRecordField$505cff1c("location");
        paramDataProcessor.processString(location);
      }
      if (hasStudentAndAlumniCount)
      {
        paramDataProcessor.startRecordField$505cff1c("studentAndAlumniCount");
        paramDataProcessor.processInt(studentAndAlumniCount);
      }
      localObject1 = null;
      bool2 = false;
      if (hasFollowing)
      {
        paramDataProcessor.startRecordField$505cff1c("following");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label281;
        }
        localObject1 = following.accept(paramDataProcessor);
        label203:
        if (localObject1 == null) {
          break label299;
        }
      }
    }
    label272:
    label281:
    label299:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label388;
      }
      try
      {
        if (hasId) {
          break label304;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchSchool", "id");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (MiniSchool)paramDataProcessor.processDataTemplate(school);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label114;
      localObject1 = (FollowingInfo)paramDataProcessor.processDataTemplate(following);
      break label203;
    }
    label304:
    if (!hasBackendUrn) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchSchool", "backendUrn");
    }
    if (!hasSchool) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchSchool", "school");
    }
    return new SearchSchool(id, backendUrn, (MiniSchool)localObject2, location, studentAndAlumniCount, (FollowingInfo)localObject1, hasId, hasBackendUrn, bool1, hasLocation, hasStudentAndAlumniCount, bool2);
    label388:
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (SearchSchool)paramObject;
      if (id != null)
      {
        if (id.equals(id)) {}
      }
      else {
        while (id != null) {
          return false;
        }
      }
      if (backendUrn != null)
      {
        if (backendUrn.equals(backendUrn)) {}
      }
      else {
        while (backendUrn != null) {
          return false;
        }
      }
      if (school != null)
      {
        if (school.equals(school)) {}
      }
      else {
        while (school != null) {
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
      if (studentAndAlumniCount != studentAndAlumniCount) {
        return false;
      }
      if (following == null) {
        break;
      }
    } while (following.equals(following));
    for (;;)
    {
      return false;
      if (following == null) {
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
    if (hasId) {
      i = PegasusBinaryUtils.getEncodedLength(id) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasBackendUrn)
    {
      UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(backendUrn));
    }
    j = i + 1;
    i = j;
    if (hasSchool)
    {
      i = j + 1;
      if (school._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(school._cachedId);
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
      if (hasStudentAndAlumniCount) {
        i = j + 4;
      }
      j = i + 1;
      i = j;
      if (hasFollowing)
      {
        i = j + 1;
        if (following._cachedId == null) {
          break label216;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(following._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i += school.getSerializedSize();
      break;
      label216:
      i += following.getSerializedSize();
    }
  }
  
  public int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    if (id != null)
    {
      i = id.hashCode();
      if (backendUrn == null) {
        break label144;
      }
      j = backendUrn.hashCode();
      if (school == null) {
        break label149;
      }
      k = school.hashCode();
      label60:
      if (location == null) {
        break label154;
      }
    }
    label144:
    label149:
    label154:
    for (int m = location.hashCode();; m = 0)
    {
      int i1 = studentAndAlumniCount;
      if (following != null) {
        n = following.hashCode();
      }
      i = ((m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + i1) * 31 + n;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SearchSchool");
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
    label280:
    label383:
    label393:
    label418:
    label428:
    label438:
    label448:
    label473:
    label481:
    label483:
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
        localByteBuffer.putInt(-1245649969);
        if (hasId)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, id);
          if (!hasBackendUrn) {
            break label383;
          }
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(backendUrn));
          if (!hasSchool) {
            break label418;
          }
          localByteBuffer.put((byte)1);
          if (school._cachedId == null) {
            break label393;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, school._cachedId);
          school.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasLocation) {
            break label428;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, location);
          if (!hasStudentAndAlumniCount) {
            break label438;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(studentAndAlumniCount);
          if (!hasFollowing) {
            break label473;
          }
          localByteBuffer.put((byte)1);
          if (following._cachedId == null) {
            break label448;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, following._cachedId);
          following.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label481;
          }
          if (str != null) {
            break label483;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label170;
          localByteBuffer.put((byte)1);
          school.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)0);
          break label256;
          localByteBuffer.put((byte)0);
          break label280;
          localByteBuffer.put((byte)1);
          following.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchSchool
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */