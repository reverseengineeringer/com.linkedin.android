package com.linkedin.android.pegasus.gen.voyager.typeahead;

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

public class TypeaheadCompany
  implements FissileDataModel<TypeaheadCompany>, RecordTemplate<TypeaheadCompany>
{
  public static final TypeaheadCompanyBuilder BUILDER = TypeaheadCompanyBuilder.INSTANCE;
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
  public final boolean hasIndustryId;
  public final String id;
  public final int industryId;
  
  TypeaheadCompany(String paramString, Urn paramUrn, MiniCompany paramMiniCompany, FollowingInfo paramFollowingInfo, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    id = paramString;
    backendUrn = paramUrn;
    company = paramMiniCompany;
    following = paramFollowingInfo;
    industryId = paramInt;
    hasId = paramBoolean1;
    hasBackendUrn = paramBoolean2;
    hasCompany = paramBoolean3;
    hasFollowing = paramBoolean4;
    hasIndustryId = paramBoolean5;
    _cachedId = null;
  }
  
  public final TypeaheadCompany accept(DataProcessor paramDataProcessor)
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
          break label247;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label114:
      localObject1 = null;
      bool2 = false;
      if (hasFollowing)
      {
        paramDataProcessor.startRecordField$505cff1c("following");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label256;
        }
        localObject1 = following.accept(paramDataProcessor);
        label153:
        if (localObject1 == null) {
          break label274;
        }
      }
    }
    label247:
    label256:
    label274:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (hasIndustryId)
      {
        paramDataProcessor.startRecordField$505cff1c("industryId");
        paramDataProcessor.processInt(industryId);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label355;
      }
      try
      {
        if (hasId) {
          break label279;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadCompany", "id");
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
      break label153;
    }
    label279:
    if (!hasBackendUrn) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadCompany", "backendUrn");
    }
    if (!hasCompany) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadCompany", "company");
    }
    return new TypeaheadCompany(id, backendUrn, (MiniCompany)localObject2, (FollowingInfo)localObject1, industryId, hasId, hasBackendUrn, bool1, bool2, hasIndustryId);
    label355:
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
      paramObject = (TypeaheadCompany)paramObject;
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
      if (following != null)
      {
        if (following.equals(following)) {}
      }
      else {
        while (following != null) {
          return false;
        }
      }
    } while (industryId == industryId);
    return false;
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
      if (hasFollowing)
      {
        i = j + 1;
        if (following._cachedId == null) {
          break label191;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(following._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasIndustryId) {
        i = j + 4;
      }
      __sizeOfObject = i;
      return i;
      i += company.getSerializedSize();
      break;
      label191:
      i += following.getSerializedSize();
    }
  }
  
  public int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    if (id != null)
    {
      i = id.hashCode();
      if (backendUrn == null) {
        break label118;
      }
      j = backendUrn.hashCode();
      label45:
      if (company == null) {
        break label123;
      }
    }
    label118:
    label123:
    for (int k = company.hashCode();; k = 0)
    {
      if (following != null) {
        m = following.hashCode();
      }
      i = ((k + (j + (i + 527) * 31) * 31) * 31 + m) * 31 + industryId;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building TypeaheadCompany");
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
    label290:
    label357:
    label367:
    label392:
    label402:
    label427:
    label437:
    label445:
    label447:
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
        localByteBuffer.putInt(-212830758);
        if (hasId)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, id);
          if (!hasBackendUrn) {
            break label357;
          }
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(backendUrn));
          if (!hasCompany) {
            break label392;
          }
          localByteBuffer.put((byte)1);
          if (company._cachedId == null) {
            break label367;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, company._cachedId);
          company.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasFollowing) {
            break label427;
          }
          localByteBuffer.put((byte)1);
          if (following._cachedId == null) {
            break label402;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, following._cachedId);
          following.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasIndustryId) {
            break label437;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(industryId);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label445;
          }
          if (str != null) {
            break label447;
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
          localByteBuffer.put((byte)1);
          following.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label290;
          localByteBuffer.put((byte)0);
          break label290;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadCompany
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */