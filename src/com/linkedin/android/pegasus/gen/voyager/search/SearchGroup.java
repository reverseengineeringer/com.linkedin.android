package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.GroupMembershipInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.annotation.AnnotatedText;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public class SearchGroup
  implements FissileDataModel<SearchGroup>, RecordTemplate<SearchGroup>
{
  public static final SearchGroupBuilder BUILDER = SearchGroupBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final Urn backendUrn;
  public final DiscussionActivityInfo discussionActivity;
  public final MiniGroup group;
  public final boolean hasBackendUrn;
  public final boolean hasDiscussionActivity;
  public final boolean hasGroup;
  public final boolean hasId;
  public final boolean hasMemberCount;
  public final boolean hasMembershipInfo;
  public final boolean hasOpen;
  public final boolean hasSummary;
  public final String id;
  public final int memberCount;
  public final GroupMembershipInfo membershipInfo;
  public final boolean open;
  public final AnnotatedText summary;
  
  SearchGroup(String paramString, Urn paramUrn, MiniGroup paramMiniGroup, boolean paramBoolean1, AnnotatedText paramAnnotatedText, int paramInt, DiscussionActivityInfo paramDiscussionActivityInfo, GroupMembershipInfo paramGroupMembershipInfo, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9)
  {
    id = paramString;
    backendUrn = paramUrn;
    group = paramMiniGroup;
    open = paramBoolean1;
    summary = paramAnnotatedText;
    memberCount = paramInt;
    discussionActivity = paramDiscussionActivityInfo;
    membershipInfo = paramGroupMembershipInfo;
    hasId = paramBoolean2;
    hasBackendUrn = paramBoolean3;
    hasGroup = paramBoolean4;
    hasOpen = paramBoolean5;
    hasSummary = paramBoolean6;
    hasMemberCount = paramBoolean7;
    hasDiscussionActivity = paramBoolean8;
    hasMembershipInfo = paramBoolean9;
    _cachedId = null;
  }
  
  public final SearchGroup accept(DataProcessor paramDataProcessor)
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
    label114:
    Object localObject3;
    boolean bool2;
    label178:
    label189:
    Object localObject4;
    boolean bool3;
    if (hasGroup)
    {
      paramDataProcessor.startRecordField$505cff1c("group");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = group.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label376;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      if (hasOpen)
      {
        paramDataProcessor.startRecordField$505cff1c("open");
        paramDataProcessor.processBoolean(open);
      }
      localObject3 = null;
      bool2 = false;
      if (hasSummary)
      {
        paramDataProcessor.startRecordField$505cff1c("summary");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label385;
        }
        localObject1 = summary.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label403;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      if (hasMemberCount)
      {
        paramDataProcessor.startRecordField$505cff1c("memberCount");
        paramDataProcessor.processInt(memberCount);
      }
      localObject4 = null;
      bool3 = false;
      if (hasDiscussionActivity)
      {
        paramDataProcessor.startRecordField$505cff1c("discussionActivity");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label412;
        }
        localObject1 = discussionActivity.accept(paramDataProcessor);
        label254:
        if (localObject1 == null) {
          break label430;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      label266:
      localObject1 = null;
      bool4 = false;
      if (hasMembershipInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("membershipInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label440;
        }
        localObject1 = membershipInfo.accept(paramDataProcessor);
        label306:
        if (localObject1 == null) {
          break label458;
        }
      }
    }
    label376:
    label385:
    label403:
    label412:
    label430:
    label440:
    label458:
    for (boolean bool4 = true;; bool4 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label575;
      }
      try
      {
        if (hasId) {
          break label464;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchGroup", "id");
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
      localObject1 = (AnnotatedText)paramDataProcessor.processDataTemplate(summary);
      break label178;
      bool2 = false;
      localObject3 = localObject1;
      break label189;
      localObject1 = (DiscussionActivityInfo)paramDataProcessor.processDataTemplate(discussionActivity);
      break label254;
      bool3 = false;
      localObject4 = localObject1;
      break label266;
      localObject1 = (GroupMembershipInfo)paramDataProcessor.processDataTemplate(membershipInfo);
      break label306;
    }
    label464:
    if (!hasBackendUrn) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchGroup", "backendUrn");
    }
    if (!hasGroup) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchGroup", "group");
    }
    if (!hasOpen) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchGroup", "open");
    }
    return new SearchGroup(id, backendUrn, (MiniGroup)localObject2, open, (AnnotatedText)localObject3, memberCount, (DiscussionActivityInfo)localObject4, (GroupMembershipInfo)localObject1, hasId, hasBackendUrn, bool1, hasOpen, bool2, hasMemberCount, bool3, bool4);
    label575:
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
      paramObject = (SearchGroup)paramObject;
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
      if (open != open) {
        return false;
      }
      if (summary != null)
      {
        if (summary.equals(summary)) {}
      }
      else {
        while (summary != null) {
          return false;
        }
      }
      if (memberCount != memberCount) {
        return false;
      }
      if (discussionActivity != null)
      {
        if (discussionActivity.equals(discussionActivity)) {}
      }
      else {
        while (discussionActivity != null) {
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
      if (hasOpen) {
        i = j + 1;
      }
      j = i + 1;
      i = j;
      if (hasSummary)
      {
        i = j + 1;
        if (summary._cachedId == null) {
          break label292;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(summary._cachedId);
      }
      label171:
      j = i + 1;
      i = j;
      if (hasMemberCount) {
        i = j + 4;
      }
      j = i + 1;
      i = j;
      if (hasDiscussionActivity)
      {
        i = j + 1;
        if (discussionActivity._cachedId == null) {
          break label305;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(discussionActivity._cachedId);
      }
      label230:
      j = i + 1;
      i = j;
      if (hasMembershipInfo)
      {
        i = j + 1;
        if (membershipInfo._cachedId == null) {
          break label318;
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
      label292:
      i += summary.getSerializedSize();
      break label171;
      label305:
      i += discussionActivity.getSerializedSize();
      break label230;
      label318:
      i += membershipInfo.getSerializedSize();
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
    label70:
    int n;
    label86:
    int i3;
    if (id != null)
    {
      i = id.hashCode();
      if (backendUrn == null) {
        break label182;
      }
      j = backendUrn.hashCode();
      if (group == null) {
        break label187;
      }
      k = group.hashCode();
      if (!open) {
        break label192;
      }
      m = 1;
      if (summary == null) {
        break label198;
      }
      n = summary.hashCode();
      i3 = memberCount;
      if (discussionActivity == null) {
        break label204;
      }
    }
    label182:
    label187:
    label192:
    label198:
    label204:
    for (int i1 = discussionActivity.hashCode();; i1 = 0)
    {
      if (membershipInfo != null) {
        i2 = membershipInfo.hashCode();
      }
      i = (i1 + ((n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31 + i3) * 31) * 31 + i2;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
      m = 0;
      break label70;
      n = 0;
      break label86;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building SearchGroup");
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
    label171:
    label231:
    label255:
    label264:
    label324:
    label348:
    label408:
    label511:
    label521:
    label546:
    label556:
    label562:
    label572:
    label597:
    label607:
    label617:
    label642:
    label652:
    label677:
    label685:
    label687:
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
        localByteBuffer.putInt(-176530318);
        if (hasId)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, id);
          if (!hasBackendUrn) {
            break label511;
          }
          localByteBuffer.put((byte)1);
          UrnCoercer localUrnCoercer = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(backendUrn));
          if (!hasGroup) {
            break label546;
          }
          localByteBuffer.put((byte)1);
          if (group._cachedId == null) {
            break label521;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, group._cachedId);
          group.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasOpen) {
            break label562;
          }
          localByteBuffer.put((byte)1);
          if (!open) {
            break label556;
          }
          i = 1;
          localByteBuffer.put((byte)i);
          if (!hasSummary) {
            break label597;
          }
          localByteBuffer.put((byte)1);
          if (summary._cachedId == null) {
            break label572;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, summary._cachedId);
          summary.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasMemberCount) {
            break label607;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(memberCount);
          if (!hasDiscussionActivity) {
            break label642;
          }
          localByteBuffer.put((byte)1);
          if (discussionActivity._cachedId == null) {
            break label617;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, discussionActivity._cachedId);
          discussionActivity.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          if (!hasMembershipInfo) {
            break label677;
          }
          localByteBuffer.put((byte)1);
          if (membershipInfo._cachedId == null) {
            break label652;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, membershipInfo._cachedId);
          membershipInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label685;
          }
          if (str != null) {
            break label687;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label171;
          localByteBuffer.put((byte)1);
          group.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label231;
          localByteBuffer.put((byte)0);
          break label231;
          i = 0;
          break label255;
          localByteBuffer.put((byte)0);
          break label264;
          localByteBuffer.put((byte)1);
          summary.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label324;
          localByteBuffer.put((byte)0);
          break label324;
          localByteBuffer.put((byte)0);
          break label348;
          localByteBuffer.put((byte)1);
          discussionActivity.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label408;
          localByteBuffer.put((byte)0);
          break label408;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchGroup
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */