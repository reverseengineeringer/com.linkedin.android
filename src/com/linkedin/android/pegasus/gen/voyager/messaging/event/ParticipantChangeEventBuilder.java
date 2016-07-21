package com.linkedin.android.pegasus.gen.voyager.messaging.event;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.messaging.MessagingProfileBuilder;
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

public final class ParticipantChangeEventBuilder
  implements FissileDataModelBuilder<ParticipantChangeEvent>, DataTemplateBuilder<ParticipantChangeEvent>
{
  public static final ParticipantChangeEventBuilder INSTANCE = new ParticipantChangeEventBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("addedParticipants");
    JSON_KEY_STORE.put("removedParticipants");
  }
  
  public static ParticipantChangeEvent build(DataReader paramDataReader)
    throws DataReaderException
  {
    ArrayList localArrayList = null;
    Object localObject = null;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299())
    {
      MessagingProfileBuilder localMessagingProfileBuilder;
      if (paramDataReader.shouldReadField$11ca93e7("addedParticipants", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            localMessagingProfileBuilder = MessagingProfileBuilder.INSTANCE;
            localArrayList.add(MessagingProfileBuilder.build(paramDataReader));
          }
        }
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("removedParticipants", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            localMessagingProfileBuilder = MessagingProfileBuilder.INSTANCE;
            ((List)localObject).add(MessagingProfileBuilder.build(paramDataReader));
          }
        }
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool1) {
      localObject = Collections.emptyList();
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: addedParticipants when building com.linkedin.android.pegasus.gen.voyager.messaging.event.ParticipantChangeEvent");
    }
    return new ParticipantChangeEvent(localArrayList, (List)localObject, bool2, bool1);
  }
  
  public static ParticipantChangeEvent readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building ParticipantChangeEvent");
    }
    Object localObject2 = paramByteBuffer;
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
          localObject1 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building ParticipantChangeEvent");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building ParticipantChangeEvent");
    }
    if (((ByteBuffer)localObject1).getInt() != 1724797289)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building ParticipantChangeEvent");
    }
    localObject2 = null;
    ArrayList localArrayList = null;
    boolean bool1;
    Object localObject3;
    label239:
    int k;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool1 = true;
      if (!bool1) {
        break label361;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localObject3 = new ArrayList();
      localObject2 = localObject3;
      if (j <= 0) {
        break label361;
      }
      paramString = null;
      i = 1;
      k = ((ByteBuffer)localObject1).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
        localObject2 = MessagingProfileBuilder.INSTANCE;
        paramString = MessagingProfileBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label349;
        }
        i = 1;
      }
      label294:
      if (k == 1)
      {
        paramString = MessagingProfileBuilder.INSTANCE;
        paramString = MessagingProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
        if (paramString == null) {
          break label355;
        }
      }
    }
    label349:
    label355:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject3).add(paramString);
      }
      j -= 1;
      break label239;
      bool1 = false;
      break;
      i = 0;
      break label294;
    }
    label361:
    boolean bool2;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool2 = true;
      paramString = localArrayList;
      if (!bool2) {
        break label521;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localArrayList = new ArrayList();
      label400:
      paramString = localArrayList;
      if (j <= 0) {
        break label521;
      }
      paramString = null;
      i = 1;
      k = ((ByteBuffer)localObject1).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
        localObject3 = MessagingProfileBuilder.INSTANCE;
        paramString = MessagingProfileBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label509;
        }
        i = 1;
      }
      label454:
      if (k == 1)
      {
        paramString = MessagingProfileBuilder.INSTANCE;
        paramString = MessagingProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
        if (paramString == null) {
          break label515;
        }
      }
    }
    label509:
    label515:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      j -= 1;
      break label400;
      bool2 = false;
      break;
      i = 0;
      break label454;
    }
    label521:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
    }
    if (!bool2) {
      paramString = Collections.emptyList();
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: addedParticipants when reading com.linkedin.android.pegasus.gen.voyager.messaging.event.ParticipantChangeEvent from fission.");
    }
    return new ParticipantChangeEvent((List)localObject2, paramString, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.event.ParticipantChangeEventBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */