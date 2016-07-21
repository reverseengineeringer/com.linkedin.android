package com.linkedin.android.pegasus.gen.voyager.messaging;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.EventContent;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.EventContentBuilder;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.EventSubtype;
import com.linkedin.android.pegasus.gen.voyager.messaging.event.EventSubtype.Builder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class EventBuilder
  implements FissileDataModelBuilder<Event>, DataTemplateBuilder<Event>
{
  public static final EventBuilder INSTANCE = new EventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("createdAt");
    JSON_KEY_STORE.put("from");
    JSON_KEY_STORE.put("subtype");
    JSON_KEY_STORE.put("eventContent");
    JSON_KEY_STORE.put("previousEventInConversation");
  }
  
  public static Event build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject4 = null;
    long l = 0L;
    Object localObject3 = null;
    EventSubtype localEventSubtype = null;
    Object localObject2 = null;
    Object localObject1 = null;
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
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("createdAt", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("from", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = MessagingProfileBuilder.INSTANCE;
        localObject3 = MessagingProfileBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("subtype", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localEventSubtype = (EventSubtype)paramDataReader.readEnum(EventSubtype.Builder.INSTANCE);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("eventContent", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = EventContentBuilder.INSTANCE;
        localObject2 = EventContentBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("previousEventInConversation", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = UrnCoercer.INSTANCE;
        localObject1 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: entityUrn when building com.linkedin.android.pegasus.gen.voyager.messaging.Event");
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: createdAt when building com.linkedin.android.pegasus.gen.voyager.messaging.Event");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: from when building com.linkedin.android.pegasus.gen.voyager.messaging.Event");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: subtype when building com.linkedin.android.pegasus.gen.voyager.messaging.Event");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: eventContent when building com.linkedin.android.pegasus.gen.voyager.messaging.Event");
    }
    return new Event((Urn)localObject4, l, (MessagingProfile)localObject3, localEventSubtype, (EventContent)localObject2, (Urn)localObject1, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static Event readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Event");
    }
    Object localObject1 = paramByteBuffer;
    int i;
    if (paramString != null)
    {
      paramString = paramFissionAdapter.readFromCache(paramString, paramFissionTransaction);
      if (paramString == null) {
        return null;
      }
      i = paramString.get();
      int j;
      do
      {
        do
        {
          localObject2 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building Event");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building Event");
    }
    if (((ByteBuffer)localObject2).getInt() != -227089407)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building Event");
    }
    Object localObject3 = null;
    long l = 0L;
    paramString = null;
    MessagingProfileBuilder localMessagingProfileBuilder = null;
    EventSubtype localEventSubtype = null;
    localObject1 = null;
    EventContentBuilder localEventContentBuilder = null;
    Object localObject4 = null;
    boolean bool4;
    boolean bool5;
    label267:
    boolean bool2;
    label291:
    boolean bool1;
    label348:
    label374:
    boolean bool6;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool4 = true;
      if (bool4)
      {
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject2));
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label576;
      }
      bool5 = true;
      if (bool5) {
        l = ((ByteBuffer)localObject2).getLong();
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label582;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = localMessagingProfileBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localMessagingProfileBuilder = MessagingProfileBuilder.INSTANCE;
          paramString = MessagingProfileBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label588;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = MessagingProfileBuilder.INSTANCE;
          paramString = MessagingProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label594;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label600;
      }
      bool6 = true;
      label386:
      if (bool6) {
        localEventSubtype = EventSubtype.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2));
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label606;
      }
      bool3 = true;
      label416:
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject2).get();
        localObject1 = localEventContentBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localEventContentBuilder = EventContentBuilder.INSTANCE;
          localObject1 = EventContentBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label612;
          }
          bool2 = true;
        }
        label478:
        if (i == 1)
        {
          localObject1 = EventContentBuilder.INSTANCE;
          localObject1 = EventContentBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label618;
          }
          bool2 = true;
        }
      }
      label507:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label624;
      }
    }
    label576:
    label582:
    label588:
    label594:
    label600:
    label606:
    label612:
    label618:
    label624:
    for (boolean bool3 = true;; bool3 = false)
    {
      paramFissionTransaction = (FissionTransaction)localObject4;
      if (bool3)
      {
        paramFissionTransaction = UrnCoercer.INSTANCE;
        paramFissionTransaction = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject2));
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (bool4) {
        break label630;
      }
      throw new IOException("Failed to find required field: entityUrn when reading com.linkedin.android.pegasus.gen.voyager.messaging.Event from fission.");
      bool4 = false;
      break;
      bool5 = false;
      break label267;
      bool2 = false;
      break label291;
      bool1 = false;
      break label348;
      bool1 = false;
      break label374;
      bool6 = false;
      break label386;
      bool3 = false;
      break label416;
      bool2 = false;
      break label478;
      bool2 = false;
      break label507;
    }
    label630:
    if (!bool5) {
      throw new IOException("Failed to find required field: createdAt when reading com.linkedin.android.pegasus.gen.voyager.messaging.Event from fission.");
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: from when reading com.linkedin.android.pegasus.gen.voyager.messaging.Event from fission.");
    }
    if (!bool6) {
      throw new IOException("Failed to find required field: subtype when reading com.linkedin.android.pegasus.gen.voyager.messaging.Event from fission.");
    }
    if (!bool2) {
      throw new IOException("Failed to find required field: eventContent when reading com.linkedin.android.pegasus.gen.voyager.messaging.Event from fission.");
    }
    return new Event((Urn)localObject3, l, paramString, localEventSubtype, (EventContent)localObject1, paramFissionTransaction, bool4, bool5, bool1, bool6, bool2, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.EventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */