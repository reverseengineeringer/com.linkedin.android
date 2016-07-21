package com.linkedin.android.pegasus.gen.voyager.typeahead;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.GroupMembershipInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public class TypeaheadGroup
  implements FissileDataModel<TypeaheadGroup>, RecordTemplate<TypeaheadGroup>
{
  public static final TypeaheadGroupBuilder BUILDER = TypeaheadGroupBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final Urn backendUrn;
  public final MiniGroup group;
  public final boolean hasBackendUrn;
  public final boolean hasGroup;
  public final boolean hasId;
  public final boolean hasMembershipInfo;
  public final String id;
  public final GroupMembershipInfo membershipInfo;
  
  TypeaheadGroup(String paramString, Urn paramUrn, MiniGroup paramMiniGroup, GroupMembershipInfo paramGroupMembershipInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    id = paramString;
    backendUrn = paramUrn;
    group = paramMiniGroup;
    membershipInfo = paramGroupMembershipInfo;
    hasId = paramBoolean1;
    hasBackendUrn = paramBoolean2;
    hasGroup = paramBoolean3;
    hasMembershipInfo = paramBoolean4;
    _cachedId = null;
  }
  
  public final TypeaheadGroup accept(DataProcessor paramDataProcessor)
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
    if (hasGroup)
    {
      paramDataProcessor.startRecordField$505cff1c("group");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = group.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label222;
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
      if (hasMembershipInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("membershipInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label231;
        }
        localObject1 = membershipInfo.accept(paramDataProcessor);
        label153:
        if (localObject1 == null) {
          break label249;
        }
      }
    }
    label222:
    label231:
    label249:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label322;
      }
      try
      {
        if (hasId) {
          break label254;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadGroup", "id");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (MiniGroup)paramDataProcessor.processDataTemplate(group);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label114;
      localObject1 = (GroupMembershipInfo)paramDataProcessor.processDataTemplate(membershipInfo);
      break label153;
    }
    label254:
    if (!hasBackendUrn) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadGroup", "backendUrn");
    }
    if (!hasGroup) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadGroup", "group");
    }
    return new TypeaheadGroup(id, backendUrn, (MiniGroup)localObject2, (GroupMembershipInfo)localObject1, hasId, hasBackendUrn, bool1, bool2);
    label322:
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
      paramObject = (TypeaheadGroup)paramObject;
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
      if (group != null)
      {
        if (group.equals(group)) {}
      }
      else {
        while (group != null) {
          return false;
        }
      }
      if (membershipInfo == null) {
        break;
      }
    } while (membershipInfo.equals(membershipInfo));
    for (;;)
    {
      return false;
      if (membershipInfo == null) {
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
    if (hasGroup)
    {
      i = j + 1;
      if (group._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(group._cachedId);
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasMembershipInfo)
      {
        i = j + 1;
        if (membershipInfo._cachedId == null) {
          break label174;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(membershipInfo._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i += group.getSerializedSize();
      break;
      label174:
      i += membershipInfo.getSerializedSize();
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
        break label110;
      }
      j = backendUrn.hashCode();
      label45:
      if (group == null) {
        break label115;
      }
    }
    label110:
    label115:
    for (int k = group.hashCode();; k = 0)
    {
      if (membershipInfo != null) {
        m = membershipInfo.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building TypeaheadGroup");
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
    label333:
    label343:
    label368:
    label378:
    label403:
    label411:
    label413:
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
        localByteBuffer.putInt(-273836478);
        if (hasId)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, id);
          if (!hasBackendUrn) {
            break label333;
          }
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(backendUrn));
          if (!hasGroup) {
            break label368;
          }
          localByteBuffer.put((byte)1);
          if (group._cachedId == null) {
            break label343;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, group._cachedId);
          group.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasMembershipInfo) {
            break label403;
          }
          localByteBuffer.put((byte)1);
          if (membershipInfo._cachedId == null) {
            break label378;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, membershipInfo._cachedId);
          membershipInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label411;
          }
          if (str != null) {
            break label413;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label170;
          localByteBuffer.put((byte)1);
          group.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          membershipInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadGroup
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */