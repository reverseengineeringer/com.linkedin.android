package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public class SearchCompany
  implements FissileDataModel<SearchCompany>, RecordTemplate<SearchCompany>
{
  public static final SearchCompanyBuilder BUILDER = SearchCompanyBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final Urn backendUrn;
  public final MiniCompany company;
  public final FollowingInfo following;
  public final boolean hasBackendUrn;
  public final boolean hasCompany;
  public final boolean hasFollowing;
  public final boolean hasId;
  public final boolean hasIndustry;
  public final boolean hasLocation;
  public final boolean hasSize;
  public final String id;
  public final String industry;
  public final String location;
  public final String size;
  
  SearchCompany(String paramString1, Urn paramUrn, MiniCompany paramMiniCompany, String paramString2, String paramString3, String paramString4, FollowingInfo paramFollowingInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    id = paramString1;
    backendUrn = paramUrn;
    company = paramMiniCompany;
    location = paramString2;
    industry = paramString3;
    size = paramString4;
    following = paramFollowingInfo;
    hasId = paramBoolean1;
    hasBackendUrn = paramBoolean2;
    hasCompany = paramBoolean3;
    hasLocation = paramBoolean4;
    hasIndustry = paramBoolean5;
    hasSize = paramBoolean6;
    hasFollowing = paramBoolean7;
    _cachedId = null;
  }
  
  public final SearchCompany accept(DataProcessor paramDataProcessor)
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
    if (hasCompany)
    {
      paramDataProcessor.startRecordField$505cff1c("company");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = company.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label297;
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
      if (hasIndustry)
      {
        paramDataProcessor.startRecordField$505cff1c("industry");
        paramDataProcessor.processString(industry);
      }
      if (hasSize)
      {
        paramDataProcessor.startRecordField$505cff1c("size");
        paramDataProcessor.processString(size);
      }
      localObject1 = null;
      bool2 = false;
      if (hasFollowing)
      {
        paramDataProcessor.startRecordField$505cff1c("following");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label306;
        }
        localObject1 = following.accept(paramDataProcessor);
        label228:
        if (localObject1 == null) {
          break label324;
        }
      }
    }
    label297:
    label306:
    label324:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label440;
      }
      try
      {
        if (hasId) {
          break label329;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchCompany", "id");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (MiniCompany)paramDataProcessor.processDataTemplate(company);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label114;
      localObject1 = (FollowingInfo)paramDataProcessor.processDataTemplate(following);
      break label228;
    }
    label329:
    if (!hasBackendUrn) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchCompany", "backendUrn");
    }
    if (!hasCompany) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchCompany", "company");
    }
    if (!hasFollowing) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchCompany", "following");
    }
    return new SearchCompany(id, backendUrn, (MiniCompany)localObject2, location, industry, size, (FollowingInfo)localObject1, hasId, hasBackendUrn, bool1, hasLocation, hasIndustry, hasSize, bool2);
    label440:
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
      paramObject = (SearchCompany)paramObject;
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
      if (company != null)
      {
        if (company.equals(company)) {}
      }
      else {
        while (company != null) {
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
      if (industry != null)
      {
        if (industry.equals(industry)) {}
      }
      else {
        while (industry != null) {
          return false;
        }
      }
      if (size != null)
      {
        if (size.equals(size)) {}
      }
      else {
        while (size != null) {
          return false;
        }
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
    if (hasCompany)
    {
      i = j + 1;
      if (company._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(company._cachedId);
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
      if (hasIndustry) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(industry);
      }
      j = i + 1;
      i = j;
      if (hasSize) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(size);
      }
      j = i + 1;
      i = j;
      if (hasFollowing)
      {
        i = j + 1;
        if (following._cachedId == null) {
          break label249;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(following._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i += company.getSerializedSize();
      break;
      label249:
      i += following.getSerializedSize();
    }
  }
  
  public int hashCode()
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
    if (id != null)
    {
      i = id.hashCode();
      if (backendUrn == null) {
        break label176;
      }
      j = backendUrn.hashCode();
      if (company == null) {
        break label181;
      }
      k = company.hashCode();
      if (location == null) {
        break label186;
      }
      m = location.hashCode();
      if (industry == null) {
        break label192;
      }
      n = industry.hashCode();
      label92:
      if (size == null) {
        break label198;
      }
    }
    label176:
    label181:
    label186:
    label192:
    label198:
    for (int i1 = size.hashCode();; i1 = 0)
    {
      if (following != null) {
        i2 = following.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SearchCompany");
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
    label308:
    label411:
    label421:
    label446:
    label456:
    label466:
    label476:
    label486:
    label511:
    label519:
    label521:
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
        localByteBuffer.putInt(1913266021);
        if (hasId)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, id);
          if (!hasBackendUrn) {
            break label411;
          }
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(backendUrn));
          if (!hasCompany) {
            break label446;
          }
          localByteBuffer.put((byte)1);
          if (company._cachedId == null) {
            break label421;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, company._cachedId);
          company.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasLocation) {
            break label456;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, location);
          if (!hasIndustry) {
            break label466;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, industry);
          if (!hasSize) {
            break label476;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, size);
          if (!hasFollowing) {
            break label511;
          }
          localByteBuffer.put((byte)1);
          if (following._cachedId == null) {
            break label486;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, following._cachedId);
          following.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label519;
          }
          if (str != null) {
            break label521;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label170;
          localByteBuffer.put((byte)1);
          company.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)0);
          break label256;
          localByteBuffer.put((byte)0);
          break label282;
          localByteBuffer.put((byte)0);
          break label308;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchCompany
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */