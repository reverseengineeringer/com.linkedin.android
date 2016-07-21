package com.linkedin.android.pegasus.gen.voyager.messaging;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.relationships.invitation.Invitation;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Conversation
  implements FissileDataModel<Conversation>, RecordTemplate<Conversation>
{
  public static final ConversationBuilder BUILDER = ConversationBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final Urn entityUrn;
  public final List<Event> events;
  public final boolean hasEntityUrn;
  public final boolean hasEvents;
  public final boolean hasMuted;
  public final boolean hasName;
  public final boolean hasNotificationStatus;
  public final boolean hasParticipants;
  public final boolean hasPendingInvitation;
  public final boolean hasRead;
  public final boolean hasReceipts;
  public final boolean hasTotalEventCount;
  public final boolean hasUnreadCount;
  public final boolean muted;
  public final String name;
  public final NotificationStatus notificationStatus;
  public final List<MessagingProfile> participants;
  public final Invitation pendingInvitation;
  public final boolean read;
  public final List<ParticipantReceipts> receipts;
  public final int totalEventCount;
  public final int unreadCount;
  
  Conversation(Urn paramUrn, List<MessagingProfile> paramList, List<Event> paramList1, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, String paramString, Invitation paramInvitation, List<ParticipantReceipts> paramList2, NotificationStatus paramNotificationStatus, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13)
  {
    entityUrn = paramUrn;
    if (paramList == null)
    {
      paramList = null;
      participants = paramList;
      if (paramList1 != null) {
        break label182;
      }
      paramList = null;
      label36:
      events = paramList;
      read = paramBoolean1;
      muted = paramBoolean2;
      unreadCount = paramInt1;
      totalEventCount = paramInt2;
      name = paramString;
      pendingInvitation = paramInvitation;
      if (paramList2 != null) {
        break label190;
      }
    }
    label182:
    label190:
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList2))
    {
      receipts = paramList;
      notificationStatus = paramNotificationStatus;
      hasEntityUrn = paramBoolean3;
      hasParticipants = paramBoolean4;
      hasEvents = paramBoolean5;
      hasRead = paramBoolean6;
      hasMuted = paramBoolean7;
      hasUnreadCount = paramBoolean8;
      hasTotalEventCount = paramBoolean9;
      hasName = paramBoolean10;
      hasPendingInvitation = paramBoolean11;
      hasReceipts = paramBoolean12;
      hasNotificationStatus = paramBoolean13;
      paramList = UrnCoercer.INSTANCE;
      _cachedId = UrnCoercer.coerceFromCustomType(paramUrn);
      return;
      paramList = Collections.unmodifiableList(paramList);
      break;
      paramList = Collections.unmodifiableList(paramList1);
      break label36;
    }
  }
  
  public final Conversation accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEntityUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("entityUrn");
      localObject1 = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(entityUrn));
    }
    Object localObject3 = null;
    Object localObject1 = null;
    boolean bool1 = false;
    int i;
    boolean bool2;
    Object localObject4;
    if (hasParticipants)
    {
      paramDataProcessor.startRecordField$505cff1c("participants");
      participants.size();
      paramDataProcessor.startArray$13462e();
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject3 = participants.iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (MessagingProfile)((Iterator)localObject3).next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localObject2 = ((MessagingProfile)localObject2).accept(paramDataProcessor);; localObject2 = (MessagingProfile)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
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
      localObject1 = null;
      localObject2 = null;
      bool2 = false;
      if (!hasEvents) {
        break label402;
      }
      paramDataProcessor.startRecordField$505cff1c("events");
      events.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localObject2;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      localObject4 = events.iterator();
      label290:
      if (!((Iterator)localObject4).hasNext()) {
        break label388;
      }
      localObject2 = (Event)((Iterator)localObject4).next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label372;
      }
    }
    label372:
    for (Object localObject2 = ((Event)localObject2).accept(paramDataProcessor);; localObject2 = (Event)paramDataProcessor.processDataTemplate((DataTemplate)localObject2))
    {
      if ((localObject1 != null) && (localObject2 != null)) {
        ((List)localObject1).add(localObject2);
      }
      i += 1;
      break label290;
      bool1 = false;
      localObject3 = localObject1;
      break;
    }
    label388:
    paramDataProcessor.endArray();
    label402:
    boolean bool3;
    if (localObject1 != null)
    {
      bool2 = true;
      if (hasRead)
      {
        paramDataProcessor.startRecordField$505cff1c("read");
        paramDataProcessor.processBoolean(read);
      }
      if (hasMuted)
      {
        paramDataProcessor.startRecordField$505cff1c("muted");
        paramDataProcessor.processBoolean(muted);
      }
      if (hasUnreadCount)
      {
        paramDataProcessor.startRecordField$505cff1c("unreadCount");
        paramDataProcessor.processInt(unreadCount);
      }
      if (hasTotalEventCount)
      {
        paramDataProcessor.startRecordField$505cff1c("totalEventCount");
        paramDataProcessor.processInt(totalEventCount);
      }
      if (hasName)
      {
        paramDataProcessor.startRecordField$505cff1c("name");
        paramDataProcessor.processString(name);
      }
      localObject4 = null;
      bool3 = false;
      if (hasPendingInvitation)
      {
        paramDataProcessor.startRecordField$505cff1c("pendingInvitation");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label733;
        }
        localObject2 = pendingInvitation.accept(paramDataProcessor);
        label567:
        if (localObject2 == null) {
          break label751;
        }
        bool3 = true;
        localObject4 = localObject2;
      }
      label579:
      localObject2 = null;
      localParticipantReceipts = null;
      bool4 = false;
      if (!hasReceipts) {
        break label791;
      }
      paramDataProcessor.startRecordField$505cff1c("receipts");
      receipts.size();
      paramDataProcessor.startArray$13462e();
      localObject2 = localParticipantReceipts;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject2 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = receipts.iterator();
      label654:
      if (!localIterator.hasNext()) {
        break label777;
      }
      localParticipantReceipts = (ParticipantReceipts)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label761;
      }
    }
    label733:
    label751:
    label761:
    for (ParticipantReceipts localParticipantReceipts = localParticipantReceipts.accept(paramDataProcessor);; localParticipantReceipts = (ParticipantReceipts)paramDataProcessor.processDataTemplate(localParticipantReceipts))
    {
      if ((localObject2 != null) && (localParticipantReceipts != null)) {
        ((List)localObject2).add(localParticipantReceipts);
      }
      i += 1;
      break label654;
      bool2 = false;
      break;
      localObject2 = (Invitation)paramDataProcessor.processDataTemplate(pendingInvitation);
      break label567;
      bool3 = false;
      localObject4 = localObject2;
      break label579;
    }
    label777:
    paramDataProcessor.endArray();
    if (localObject2 != null) {}
    for (boolean bool4 = true;; bool4 = false)
    {
      label791:
      if (hasNotificationStatus)
      {
        paramDataProcessor.startRecordField$505cff1c("notificationStatus");
        paramDataProcessor.processEnum(notificationStatus);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label1157;
      }
      if (!hasEvents) {
        localObject1 = Collections.emptyList();
      }
      if (!hasReceipts) {
        localObject2 = Collections.emptyList();
      }
      try
      {
        if (hasEntityUrn) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.Conversation", "entityUrn");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasParticipants) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.Conversation", "participants");
    }
    if (!hasRead) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.Conversation", "read");
    }
    if (participants != null)
    {
      paramDataProcessor = participants.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((MessagingProfile)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.messaging.Conversation", "participants");
        }
      }
    }
    if (events != null)
    {
      paramDataProcessor = events.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((Event)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.messaging.Conversation", "events");
        }
      }
    }
    if (receipts != null)
    {
      paramDataProcessor = receipts.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((ParticipantReceipts)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.messaging.Conversation", "receipts");
        }
      }
    }
    return new Conversation(entityUrn, (List)localObject3, (List)localObject1, read, muted, unreadCount, totalEventCount, name, (Invitation)localObject4, (List)localObject2, notificationStatus, hasEntityUrn, bool1, bool2, hasRead, hasMuted, hasUnreadCount, hasTotalEventCount, hasName, bool3, bool4, hasNotificationStatus);
    label1157:
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
      paramObject = (Conversation)paramObject;
      if (entityUrn != null)
      {
        if (entityUrn.equals(entityUrn)) {}
      }
      else {
        while (entityUrn != null) {
          return false;
        }
      }
      if (participants != null)
      {
        if (participants.equals(participants)) {}
      }
      else {
        while (participants != null) {
          return false;
        }
      }
      if (events != null)
      {
        if (events.equals(events)) {}
      }
      else {
        while (events != null) {
          return false;
        }
      }
      if (read != read) {
        return false;
      }
      if (muted != muted) {
        return false;
      }
      if (unreadCount != unreadCount) {
        return false;
      }
      if (totalEventCount != totalEventCount) {
        return false;
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
      if (pendingInvitation != null)
      {
        if (pendingInvitation.equals(pendingInvitation)) {}
      }
      else {
        while (pendingInvitation != null) {
          return false;
        }
      }
      if (receipts != null)
      {
        if (receipts.equals(receipts)) {}
      }
      else {
        while (receipts != null) {
          return false;
        }
      }
      if (notificationStatus == null) {
        break;
      }
    } while (notificationStatus.equals(notificationStatus));
    for (;;)
    {
      return false;
      if (notificationStatus == null) {
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
    i += 1;
    int j = i;
    Object localObject2;
    if (hasParticipants)
    {
      i += 2;
      localObject1 = participants.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (MessagingProfile)((Iterator)localObject1).next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((MessagingProfile)localObject2).getSerializedSize();
        }
      }
    }
    i = j + 1;
    j = i;
    if (hasEvents)
    {
      i += 2;
      localObject1 = events.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (Event)((Iterator)localObject1).next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((Event)localObject2).getSerializedSize();
        }
      }
    }
    j += 1;
    i = j;
    if (hasRead) {
      i = j + 1;
    }
    j = i + 1;
    i = j;
    if (hasMuted) {
      i = j + 1;
    }
    j = i + 1;
    i = j;
    if (hasUnreadCount) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasTotalEventCount) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasName) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(name);
    }
    j = i + 1;
    i = j;
    if (hasPendingInvitation)
    {
      i = j + 1;
      if (pendingInvitation._cachedId != null) {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(pendingInvitation._cachedId);
      }
    }
    else
    {
      i += 1;
      j = i;
      if (!hasReceipts) {
        break label457;
      }
      i += 2;
      localObject1 = receipts.iterator();
    }
    for (;;)
    {
      j = i;
      if (!((Iterator)localObject1).hasNext()) {
        break label457;
      }
      localObject2 = (ParticipantReceipts)((Iterator)localObject1).next();
      i += 1;
      if (_cachedId != null)
      {
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        continue;
        i += pendingInvitation.getSerializedSize();
        break;
      }
      i += ((ParticipantReceipts)localObject2).getSerializedSize();
    }
    label457:
    j += 1;
    i = j;
    if (hasNotificationStatus) {
      i = j + 2;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int n = 1;
    int i4 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label50:
    int k;
    label67:
    int m;
    label77:
    label84:
    int i5;
    int i6;
    int i1;
    label112:
    int i2;
    if (entityUrn != null)
    {
      i = entityUrn.hashCode();
      if (participants == null) {
        break label238;
      }
      j = participants.hashCode();
      if (events == null) {
        break label243;
      }
      k = events.hashCode();
      if (!read) {
        break label248;
      }
      m = 1;
      if (!muted) {
        break label254;
      }
      i5 = unreadCount;
      i6 = totalEventCount;
      if (name == null) {
        break label260;
      }
      i1 = name.hashCode();
      if (pendingInvitation == null) {
        break label266;
      }
      i2 = pendingInvitation.hashCode();
      label128:
      if (receipts == null) {
        break label272;
      }
    }
    label238:
    label243:
    label248:
    label254:
    label260:
    label266:
    label272:
    for (int i3 = receipts.hashCode();; i3 = 0)
    {
      if (notificationStatus != null) {
        i4 = notificationStatus.hashCode();
      }
      i = (i3 + (i2 + (i1 + ((((m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + n) * 31 + i5) * 31 + i6) * 31) * 31) * 31) * 31 + i4;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label50;
      k = 0;
      break label67;
      m = 0;
      break label77;
      n = 0;
      break label84;
      i1 = 0;
      break label112;
      i2 = 0;
      break label128;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Conversation");
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
    label293:
    label463:
    label487:
    label496:
    label520:
    label544:
    label570:
    label630:
    label753:
    label759:
    label769:
    label779:
    label789:
    label799:
    label824:
    label857:
    label864:
    label936:
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
        localByteBuffer.putInt(-406963131);
        Object localObject1;
        Object localObject2;
        if (hasEntityUrn)
        {
          localByteBuffer.put((byte)1);
          localObject1 = UrnCoercer.INSTANCE;
          paramFissionAdapter.writeString(localByteBuffer, UrnCoercer.coerceFromCustomType(entityUrn));
          if (hasParticipants)
          {
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, participants.size());
            localObject1 = participants.iterator();
          }
        }
        else
        {
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label293;
            }
            localObject2 = (MessagingProfile)((Iterator)localObject1).next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((MessagingProfile)localObject2).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              continue;
              localByteBuffer.put((byte)0);
              break;
            }
            localByteBuffer.put((byte)1);
            ((MessagingProfile)localObject2).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          }
        }
        localByteBuffer.put((byte)0);
        if (hasEvents)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, events.size());
          localObject1 = events.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (Event)((Iterator)localObject1).next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((Event)localObject2).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              ((Event)localObject2).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasRead)
        {
          localByteBuffer.put((byte)1);
          if (read)
          {
            i = 1;
            localByteBuffer.put((byte)i);
            if (!hasMuted) {
              break label759;
            }
            localByteBuffer.put((byte)1);
            if (!muted) {
              break label753;
            }
            i = 1;
            localByteBuffer.put((byte)i);
            if (!hasUnreadCount) {
              break label769;
            }
            localByteBuffer.put((byte)1);
            localByteBuffer.putInt(unreadCount);
            if (!hasTotalEventCount) {
              break label779;
            }
            localByteBuffer.put((byte)1);
            localByteBuffer.putInt(totalEventCount);
            if (!hasName) {
              break label789;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, name);
            if (!hasPendingInvitation) {
              break label824;
            }
            localByteBuffer.put((byte)1);
            if (pendingInvitation._cachedId == null) {
              break label799;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, pendingInvitation._cachedId);
            pendingInvitation.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasReceipts) {
              break label857;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, receipts.size());
            localObject1 = receipts.iterator();
          }
        }
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label864;
          }
          localObject2 = (ParticipantReceipts)((Iterator)localObject1).next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            ((ParticipantReceipts)localObject2).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            i = 0;
            break;
            localByteBuffer.put((byte)0);
            break label463;
            i = 0;
            break label487;
            localByteBuffer.put((byte)0);
            break label496;
            localByteBuffer.put((byte)0);
            break label520;
            localByteBuffer.put((byte)0);
            break label544;
            localByteBuffer.put((byte)0);
            break label570;
            localByteBuffer.put((byte)1);
            pendingInvitation.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label630;
            localByteBuffer.put((byte)0);
            break label630;
          }
          localByteBuffer.put((byte)1);
          ((ParticipantReceipts)localObject2).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        localByteBuffer.put((byte)0);
        if (hasNotificationStatus)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, notificationStatus.ordinal());
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label936;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
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
  
  public static final class Builder
    implements RecordTemplateBuilder<Conversation>
  {
    private Urn entityUrn = null;
    public List<Event> events = null;
    private boolean hasEntityUrn = false;
    public boolean hasEvents = false;
    public boolean hasMuted = false;
    private boolean hasName = false;
    private boolean hasNotificationStatus = false;
    public boolean hasParticipants = false;
    private boolean hasPendingInvitation = false;
    public boolean hasRead = false;
    private boolean hasReceipts = false;
    private boolean hasTotalEventCount = false;
    private boolean hasUnreadCount = false;
    public boolean muted = false;
    private String name = null;
    private NotificationStatus notificationStatus = null;
    public List<MessagingProfile> participants = null;
    private Invitation pendingInvitation = null;
    public boolean read = false;
    private List<ParticipantReceipts> receipts = null;
    private int totalEventCount = 0;
    private int unreadCount = 0;
    
    private Conversation build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (Conversation.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (participants != null)
      {
        paramFlavor = participants.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((MessagingProfile)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.messaging.Conversation", "participants");
              if (!hasEvents) {
                events = Collections.emptyList();
              }
              if (!hasUnreadCount) {
                unreadCount = 0;
              }
              if (!hasReceipts) {
                receipts = Collections.emptyList();
              }
              if (!hasNotificationStatus) {
                notificationStatus = NotificationStatus.ACTIVE;
              }
              if (!hasEntityUrn) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.Conversation", "entityUrn");
              }
              if (!hasParticipants) {
                throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.Conversation", "participants");
              }
              if (hasRead) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.Conversation", "read");
            }
          }
        }
      }
      if (events != null)
      {
        paramFlavor = events.iterator();
        while (paramFlavor.hasNext()) {
          if ((Event)paramFlavor.next() == null) {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.messaging.Conversation", "events");
          }
        }
      }
      if (receipts != null)
      {
        paramFlavor = receipts.iterator();
        while (paramFlavor.hasNext()) {
          if ((ParticipantReceipts)paramFlavor.next() == null) {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.messaging.Conversation", "receipts");
          }
        }
      }
      return new Conversation(entityUrn, participants, events, read, muted, unreadCount, totalEventCount, name, pendingInvitation, receipts, notificationStatus, hasEntityUrn, hasParticipants, hasEvents, hasRead, hasMuted, hasUnreadCount, hasTotalEventCount, hasName, hasPendingInvitation, hasReceipts, hasNotificationStatus);
    }
    
    public final Conversation build()
      throws BuilderException
    {
      return build(RecordTemplate.Flavor.RECORD);
    }
    
    public final Builder setEntityUrn(Urn paramUrn)
    {
      if (paramUrn == null)
      {
        hasEntityUrn = false;
        entityUrn = null;
        return this;
      }
      hasEntityUrn = true;
      entityUrn = paramUrn;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.Conversation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */