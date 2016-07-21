package com.linkedin.android.pegasus.gen.voyager.relationships.shared.calendar;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.RelMiniProfile;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class MeetingDetail
  implements FissileDataModel<MeetingDetail>, RecordTemplate<MeetingDetail>
{
  public static final MeetingDetailBuilder BUILDER = MeetingDetailBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final List<RelMiniProfile> attendees;
  public final Urn entityUrn;
  public final List<MeetingAction> followupActions;
  public final boolean hasAttendees;
  public final boolean hasEntityUrn;
  public final boolean hasFollowupActions;
  public final boolean hasPrimaryActions;
  public final boolean hasTitle;
  public final boolean hasType;
  public final List<MeetingAction> primaryActions;
  public final List<AttributedText> title;
  public final MeetingStatus type;
  
  MeetingDetail(Urn paramUrn, MeetingStatus paramMeetingStatus, List<AttributedText> paramList, List<RelMiniProfile> paramList1, List<MeetingAction> paramList2, List<MeetingAction> paramList3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    entityUrn = paramUrn;
    type = paramMeetingStatus;
    if (paramList == null)
    {
      paramMeetingStatus = null;
      title = paramMeetingStatus;
      if (paramList1 != null) {
        break label132;
      }
      paramMeetingStatus = null;
      label45:
      attendees = paramMeetingStatus;
      if (paramList2 != null) {
        break label141;
      }
      paramMeetingStatus = null;
      label57:
      primaryActions = paramMeetingStatus;
      if (paramList3 != null) {
        break label150;
      }
    }
    label132:
    label141:
    label150:
    for (paramMeetingStatus = (MeetingStatus)localObject;; paramMeetingStatus = Collections.unmodifiableList(paramList3))
    {
      followupActions = paramMeetingStatus;
      hasEntityUrn = paramBoolean1;
      hasType = paramBoolean2;
      hasTitle = paramBoolean3;
      hasAttendees = paramBoolean4;
      hasPrimaryActions = paramBoolean5;
      hasFollowupActions = paramBoolean6;
      paramMeetingStatus = UrnCoercer.INSTANCE;
      _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
      return;
      paramMeetingStatus = Collections.unmodifiableList(paramList);
      break;
      paramMeetingStatus = Collections.unmodifiableList(paramList1);
      break label45;
      paramMeetingStatus = Collections.unmodifiableList(paramList2);
      break label57;
    }
  }
  
  private MeetingDetail accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    if (hasType)
    {
      paramDataProcessor.startRecordField$505cff1c("type");
      paramDataProcessor.processEnum(type);
    }
    Object localObject3 = null;
    Object localObject1 = null;
    boolean bool1 = false;
    int i;
    Object localObject4;
    boolean bool2;
    if (hasTitle)
    {
      paramDataProcessor.startRecordField$505cff1c("title");
      title.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject3 = title.iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (AttributedText)((Iterator)localObject3).next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localObject2 = ((AttributedText)localObject2).accept(paramDataProcessor);; localObject2 = (AttributedText)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
        {
          if ((localObject1 != null) && (localObject2 != null)) {
            ((List)localObject1).add(localObject2);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject1 != null)
      {
        bool1 = true;
        localObject3 = localObject1;
      }
    }
    else
    {
      localObject4 = null;
      localObject1 = null;
      bool2 = false;
      if (!hasAttendees) {
        break label427;
      }
      paramDataProcessor.startRecordField$505cff1c("attendees");
      attendees.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject4 = attendees.iterator();
      label311:
      if (!((Iterator)localObject4).hasNext()) {
        break label409;
      }
      localObject2 = (RelMiniProfile)((Iterator)localObject4).next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label393;
      }
    }
    label393:
    for (Object localObject2 = ((RelMiniProfile)localObject2).accept(paramDataProcessor);; localObject2 = (RelMiniProfile)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
    {
      if ((localObject1 != null) && (localObject2 != null)) {
        ((List)localObject1).add(localObject2);
      }
      i += 1;
      break label311;
      bool1 = false;
      localObject3 = localObject1;
      break;
    }
    label409:
    paramDataProcessor.endArray();
    label427:
    boolean bool3;
    if (localObject1 != null)
    {
      bool2 = true;
      localObject4 = localObject1;
      localObject1 = null;
      localObject2 = null;
      bool3 = false;
      if (!hasPrimaryActions) {
        break label615;
      }
      paramDataProcessor.startRecordField$505cff1c("primaryActions");
      primaryActions.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject2;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject5 = primaryActions.iterator();
      label502:
      if (!((Iterator)localObject5).hasNext()) {
        break label601;
      }
      localObject2 = (MeetingAction)((Iterator)localObject5).next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label585;
      }
    }
    label585:
    for (localObject2 = ((MeetingAction)localObject2).accept(paramDataProcessor);; localObject2 = (MeetingAction)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
    {
      if ((localObject1 != null) && (localObject2 != null)) {
        ((List)localObject1).add(localObject2);
      }
      i += 1;
      break label502;
      bool2 = false;
      localObject4 = localObject1;
      break;
    }
    label601:
    paramDataProcessor.endArray();
    if (localObject1 != null)
    {
      bool3 = true;
      label615:
      localObject2 = null;
      localObject5 = null;
      bool4 = false;
      if (!hasFollowupActions) {
        break label799;
      }
      paramDataProcessor.startRecordField$505cff1c("followupActions");
      followupActions.size();
      paramDataProcessor.startArray$13462e();
      localObject2 = localObject5;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject2 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = followupActions.iterator();
      label690:
      if (!localIterator.hasNext()) {
        break label785;
      }
      localObject5 = (MeetingAction)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label769;
      }
    }
    label769:
    for (Object localObject5 = ((MeetingAction)localObject5).accept(paramDataProcessor);; localObject5 = (MeetingAction)paramDataProcessor.processDataTemplate((DataTemplate)localObject5))
    {
      if ((localObject2 != null) && (localObject5 != null)) {
        ((List)localObject2).add(localObject5);
      }
      i += 1;
      break label690;
      bool3 = false;
      break;
    }
    label785:
    paramDataProcessor.endArray();
    if (localObject2 != null) {}
    for (boolean bool4 = true;; bool4 = false)
    {
      label799:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label1169;
      }
      if (!hasPrimaryActions) {
        localObject1 = Collections.emptyList();
      }
      if (!hasFollowupActions) {
        localObject2 = Collections.emptyList();
      }
      try
      {
        if (hasEntityUrn) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.calendar.MeetingDetail", "entityUrn");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasType) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.calendar.MeetingDetail", "type");
    }
    if (!hasTitle) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.calendar.MeetingDetail", "title");
    }
    if (!hasAttendees) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.calendar.MeetingDetail", "attendees");
    }
    if (title != null)
    {
      paramDataProcessor = title.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((AttributedText)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.calendar.MeetingDetail", "title");
        }
      }
    }
    if (attendees != null)
    {
      paramDataProcessor = attendees.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((RelMiniProfile)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.calendar.MeetingDetail", "attendees");
        }
      }
    }
    if (primaryActions != null)
    {
      paramDataProcessor = primaryActions.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((MeetingAction)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.calendar.MeetingDetail", "primaryActions");
        }
      }
    }
    if (followupActions != null)
    {
      paramDataProcessor = followupActions.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((MeetingAction)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.calendar.MeetingDetail", "followupActions");
        }
      }
    }
    return new MeetingDetail(entityUrn, type, (List)localObject3, (List)localObject4, (List)localObject1, (List)localObject2, hasEntityUrn, hasType, bool1, bool2, bool3, bool4);
    label1169:
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
      paramObject = (MeetingDetail)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (type != null)
      {
        if (type.equals(type)) {}
      }
      else {
        while (type != null) {
          return false;
        }
      }
      if (title != null)
      {
        if (title.equals(title)) {}
      }
      else {
        while (title != null) {
          return false;
        }
      }
      if (attendees != null)
      {
        if (attendees.equals(attendees)) {}
      }
      else {
        while (attendees != null) {
          return false;
        }
      }
      if (primaryActions != null)
      {
        if (primaryActions.equals(primaryActions)) {}
      }
      else {
        while (primaryActions != null) {
          return false;
        }
      }
      if (followupActions == null) {
        break;
      }
    } while (followupActions.equals(followupActions));
    for (;;)
    {
      return false;
      if (followupActions == null) {
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
    Object localObject1;
    if (hasEntityUrn)
    {
      localObject1 = UrnCoercer.INSTANCE;
      i = PegasusBinaryUtils.getEncodedLength(UrnCoercer.coerceFromCustomType(entityUrn)) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasType) {
      i = j + 2;
    }
    i += 1;
    j = i;
    Object localObject2;
    if (hasTitle)
    {
      i += 2;
      localObject1 = title.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (AttributedText)((Iterator)localObject1).next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((AttributedText)localObject2).getSerializedSize();
        }
      }
    }
    i = j + 1;
    j = i;
    if (hasAttendees)
    {
      i += 2;
      localObject1 = attendees.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (RelMiniProfile)((Iterator)localObject1).next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((RelMiniProfile)localObject2).getSerializedSize();
        }
      }
    }
    i = j + 1;
    j = i;
    if (hasPrimaryActions)
    {
      i += 2;
      localObject1 = primaryActions.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (MeetingAction)((Iterator)localObject1).next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((MeetingAction)localObject2).getSerializedSize();
        }
      }
    }
    i = j + 1;
    j = i;
    if (hasFollowupActions)
    {
      i += 2;
      localObject1 = followupActions.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (MeetingAction)((Iterator)localObject1).next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((MeetingAction)localObject2).getSerializedSize();
        }
      }
    }
    __sizeOfObject = j;
    return j;
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
    label62:
    int m;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (type == null) {
        break label162;
      }
      j = type.hashCode();
      if (title == null) {
        break label167;
      }
      k = title.hashCode();
      if (attendees == null) {
        break label172;
      }
      m = attendees.hashCode();
      label80:
      if (primaryActions == null) {
        break label178;
      }
    }
    label162:
    label167:
    label172:
    label178:
    for (int n = primaryActions.hashCode();; n = 0)
    {
      if (followupActions != null) {
        i1 = followupActions.hashCode();
      }
      i = (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31 + i1;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label62;
      m = 0;
      break label80;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building MeetingDetail");
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
    label175:
    label292:
    label325:
    label332:
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
        localByteBuffer.putInt(609824425);
        Object localObject1;
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          localObject1 = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (!hasType) {
            break label292;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, type.ordinal());
          if (!hasTitle) {
            break label325;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, title.size());
          localObject1 = title.iterator();
        }
        Object localObject2;
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label332;
          }
          localObject2 = (AttributedText)((Iterator)localObject1).next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            ((AttributedText)localObject2).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)0);
            break label175;
          }
          localByteBuffer.put((byte)1);
          ((AttributedText)localObject2).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasAttendees)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, attendees.size());
          localObject1 = attendees.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (RelMiniProfile)((Iterator)localObject1).next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((RelMiniProfile)localObject2).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              ((RelMiniProfile)localObject2).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasPrimaryActions)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, primaryActions.size());
          localObject1 = primaryActions.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (MeetingAction)((Iterator)localObject1).next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((MeetingAction)localObject2).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              ((MeetingAction)localObject2).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasFollowupActions)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, followupActions.size());
          localObject1 = followupActions.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (MeetingAction)((Iterator)localObject1).next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((MeetingAction)localObject2).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              ((MeetingAction)localObject2).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.relationships.shared.calendar.MeetingDetail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */