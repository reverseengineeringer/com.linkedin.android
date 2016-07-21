package com.linkedin.android.pegasus.gen.voyager.messaging;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.relationships.invitation.Invitation;
import com.linkedin.android.pegasus.gen.voyager.relationships.invitation.InvitationBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ConversationBuilder
  implements FissileDataModelBuilder<Conversation>, DataTemplateBuilder<Conversation>
{
  public static final ConversationBuilder INSTANCE = new ConversationBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("participants");
    JSON_KEY_STORE.put("events");
    JSON_KEY_STORE.put("read");
    JSON_KEY_STORE.put("muted");
    JSON_KEY_STORE.put("unreadCount");
    JSON_KEY_STORE.put("totalEventCount");
    JSON_KEY_STORE.put("name");
    JSON_KEY_STORE.put("pendingInvitation");
    JSON_KEY_STORE.put("receipts");
    JSON_KEY_STORE.put("notificationStatus");
  }
  
  public static Conversation build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject4 = null;
    ArrayList localArrayList = null;
    Object localObject2 = null;
    boolean bool13 = false;
    boolean bool12 = false;
    int i = 0;
    int j = 0;
    String str = null;
    Object localObject3 = null;
    Object localObject1 = null;
    NotificationStatus localNotificationStatus = null;
    boolean bool11 = false;
    boolean bool10 = false;
    boolean bool8 = false;
    boolean bool9 = false;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("entityUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = UrnCoercer.INSTANCE;
        localObject4 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool11 = true;
      }
      else
      {
        Object localObject5;
        if (paramDataReader.shouldReadField$11ca93e7("participants", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localArrayList = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              localObject5 = MessagingProfileBuilder.INSTANCE;
              localArrayList.add(MessagingProfileBuilder.build(paramDataReader));
            }
          }
          bool10 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("events", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              localObject5 = EventBuilder.INSTANCE;
              ((List)localObject2).add(EventBuilder.build(paramDataReader));
            }
          }
          bool8 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("read", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          bool13 = paramDataReader.readBoolean();
          bool9 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("muted", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          bool12 = paramDataReader.readBoolean();
          bool7 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("unreadCount", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          i = paramDataReader.readInt();
          bool6 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("totalEventCount", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          j = paramDataReader.readInt();
          bool5 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("name", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          str = paramDataReader.readString();
          bool4 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("pendingInvitation", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject3 = InvitationBuilder.INSTANCE;
          localObject3 = InvitationBuilder.build(paramDataReader);
          bool3 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("receipts", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              localObject5 = ParticipantReceiptsBuilder.INSTANCE;
              ((List)localObject1).add(ParticipantReceiptsBuilder.build(paramDataReader));
            }
          }
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("notificationStatus", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localNotificationStatus = (NotificationStatus)paramDataReader.readEnum(NotificationStatus.Builder.INSTANCE);
          bool1 = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
    }
    if (!bool8) {
      localObject2 = Collections.emptyList();
    }
    if (!bool6) {
      i = 0;
    }
    if (!bool2) {
      localObject1 = Collections.emptyList();
    }
    if (!bool1) {
      localNotificationStatus = NotificationStatus.ACTIVE;
    }
    if (!bool11) {
      throw new DataReaderException("Failed to find required field: entityUrn when building com.linkedin.android.pegasus.gen.voyager.messaging.Conversation");
    }
    if (!bool10) {
      throw new DataReaderException("Failed to find required field: participants when building com.linkedin.android.pegasus.gen.voyager.messaging.Conversation");
    }
    if (!bool9) {
      throw new DataReaderException("Failed to find required field: read when building com.linkedin.android.pegasus.gen.voyager.messaging.Conversation");
    }
    return new Conversation((Urn)localObject4, localArrayList, (List)localObject2, bool13, bool12, i, j, str, (Invitation)localObject3, (List)localObject1, localNotificationStatus, bool11, bool10, bool8, bool9, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static Conversation readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Conversation");
    }
    Object localObject1 = paramByteBuffer;
    int j;
    if (paramString != null)
    {
      paramString = paramFissionAdapter.readFromCache(paramString, paramFissionTransaction);
      if (paramString == null) {
        return null;
      }
      i = paramString.get();
      do
      {
        do
        {
          localObject3 = paramString;
          if (i != 0) {
            break;
          }
          localObject1 = paramFissionAdapter.readString(paramString);
          paramFissionAdapter.recycle(paramString);
          localObject1 = paramFissionAdapter.readFromCache((String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            return null;
          }
          j = ((ByteBuffer)localObject1).get();
          paramString = (String)localObject1;
          i = j;
        } while (j == 1);
        paramString = (String)localObject1;
        i = j;
      } while (j == 0);
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building Conversation");
    }
    Object localObject3 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building Conversation");
    }
    if (((ByteBuffer)localObject3).getInt() != -406963131)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject3);
      throw new IOException("UID mismatch. Can't read cached data when building Conversation");
    }
    Urn localUrn = null;
    Object localObject4 = null;
    Object localObject7 = null;
    boolean bool3 = false;
    boolean bool4 = false;
    int m = 0;
    int k = 0;
    String str = null;
    localObject1 = null;
    Object localObject6 = null;
    Object localObject2 = null;
    Object localObject5 = null;
    boolean bool5;
    boolean bool6;
    label279:
    Object localObject8;
    label303:
    int n;
    if (((ByteBuffer)localObject3).get() == 1)
    {
      bool5 = true;
      if (bool5)
      {
        paramString = UrnCoercer.INSTANCE;
        localUrn = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject3));
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label413;
      }
      bool6 = true;
      if (!bool6) {
        break label431;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject3);
      localObject8 = new ArrayList();
      localObject4 = localObject8;
      if (j <= 0) {
        break label431;
      }
      paramString = null;
      i = 1;
      n = ((ByteBuffer)localObject3).get();
      if (n == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject3);
        localObject4 = MessagingProfileBuilder.INSTANCE;
        paramString = MessagingProfileBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label419;
        }
        i = 1;
      }
      label358:
      if (n == 1)
      {
        paramString = MessagingProfileBuilder.INSTANCE;
        paramString = MessagingProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
        if (paramString == null) {
          break label425;
        }
      }
    }
    label413:
    label419:
    label425:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject8).add(paramString);
      }
      j -= 1;
      break label303;
      bool5 = false;
      break;
      bool6 = false;
      break label279;
      i = 0;
      break label358;
    }
    label431:
    boolean bool7;
    if (((ByteBuffer)localObject3).get() == 1)
    {
      bool7 = true;
      paramString = (String)localObject7;
      if (!bool7) {
        break label591;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject3);
      localObject7 = new ArrayList();
      label470:
      paramString = (String)localObject7;
      if (j <= 0) {
        break label591;
      }
      paramString = null;
      i = 1;
      n = ((ByteBuffer)localObject3).get();
      if (n == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject3);
        localObject8 = EventBuilder.INSTANCE;
        paramString = EventBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label579;
        }
        i = 1;
      }
      label524:
      if (n == 1)
      {
        paramString = EventBuilder.INSTANCE;
        paramString = EventBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
        if (paramString == null) {
          break label585;
        }
      }
    }
    label579:
    label585:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject7).add(paramString);
      }
      j -= 1;
      break label470;
      bool7 = false;
      break;
      i = 0;
      break label524;
    }
    label591:
    boolean bool8;
    label620:
    boolean bool9;
    label632:
    label649:
    boolean bool10;
    label661:
    boolean bool11;
    label689:
    boolean bool12;
    label713:
    boolean bool2;
    label740:
    boolean bool1;
    if (((ByteBuffer)localObject3).get() == 1)
    {
      bool8 = true;
      if (bool8)
      {
        if (((ByteBuffer)localObject3).get() != 1) {
          break label986;
        }
        bool3 = true;
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label992;
      }
      bool9 = true;
      if (bool9)
      {
        if (((ByteBuffer)localObject3).get() != 1) {
          break label998;
        }
        bool4 = true;
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label1004;
      }
      bool10 = true;
      j = m;
      if (bool10) {
        j = ((ByteBuffer)localObject3).getInt();
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label1010;
      }
      bool11 = true;
      if (bool11) {
        k = ((ByteBuffer)localObject3).getInt();
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label1016;
      }
      bool12 = true;
      if (bool12) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject3);
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label1022;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject3).get();
        localObject1 = localObject6;
        bool1 = bool2;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localObject6 = InvitationBuilder.INSTANCE;
          localObject1 = InvitationBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label1028;
          }
          bool1 = true;
        }
        label802:
        if (i == 1)
        {
          localObject1 = InvitationBuilder.INSTANCE;
          localObject1 = InvitationBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label1034;
          }
          bool1 = true;
        }
      }
      label831:
      if (((ByteBuffer)localObject3).get() != 1) {
        break label1040;
      }
      bool2 = true;
      label843:
      if (!bool2) {
        break label1058;
      }
      m = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject3);
      localObject6 = new ArrayList();
      label867:
      localObject2 = localObject6;
      if (m <= 0) {
        break label1058;
      }
      localObject2 = null;
      i = 1;
      n = ((ByteBuffer)localObject3).get();
      if (n == 0)
      {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject3);
        localObject7 = ParticipantReceiptsBuilder.INSTANCE;
        localObject2 = ParticipantReceiptsBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
        if (localObject2 == null) {
          break label1046;
        }
        i = 1;
      }
      label927:
      if (n == 1)
      {
        localObject2 = ParticipantReceiptsBuilder.INSTANCE;
        localObject2 = ParticipantReceiptsBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
        if (localObject2 == null) {
          break label1052;
        }
      }
    }
    label986:
    label992:
    label998:
    label1004:
    label1010:
    label1016:
    label1022:
    label1028:
    label1034:
    label1040:
    label1046:
    label1052:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject6).add(localObject2);
      }
      m -= 1;
      break label867;
      bool8 = false;
      break;
      bool3 = false;
      break label620;
      bool9 = false;
      break label632;
      bool4 = false;
      break label649;
      bool10 = false;
      break label661;
      bool11 = false;
      break label689;
      bool12 = false;
      break label713;
      bool2 = false;
      break label740;
      bool1 = false;
      break label802;
      bool1 = false;
      break label831;
      bool2 = false;
      break label843;
      i = 0;
      break label927;
    }
    label1058:
    if (((ByteBuffer)localObject3).get() == 1) {}
    for (boolean bool13 = true;; bool13 = false)
    {
      paramFissionTransaction = (FissionTransaction)localObject5;
      if (bool13) {
        paramFissionTransaction = NotificationStatus.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject3));
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject3);
      }
      if (!bool7) {
        paramString = Collections.emptyList();
      }
      if (!bool10) {
        j = 0;
      }
      if (!bool2) {
        localObject2 = Collections.emptyList();
      }
      if (!bool13) {
        paramFissionTransaction = NotificationStatus.ACTIVE;
      }
      if (bool5) {
        break;
      }
      throw new IOException("Failed to find required field: entityUrn when reading com.linkedin.android.pegasus.gen.voyager.messaging.Conversation from fission.");
    }
    if (!bool6) {
      throw new IOException("Failed to find required field: participants when reading com.linkedin.android.pegasus.gen.voyager.messaging.Conversation from fission.");
    }
    if (!bool8) {
      throw new IOException("Failed to find required field: read when reading com.linkedin.android.pegasus.gen.voyager.messaging.Conversation from fission.");
    }
    return new Conversation(localUrn, (List)localObject4, paramString, bool3, bool4, j, k, str, (Invitation)localObject1, (List)localObject2, paramFissionTransaction, bool5, bool6, bool7, bool8, bool9, bool10, bool11, bool12, bool1, bool2, bool13);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.ConversationBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */