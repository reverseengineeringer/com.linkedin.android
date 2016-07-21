package com.linkedin.android.pegasus.gen.voyager.messaging.create;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class ParticipantChangeCreateBuilder
  implements FissileDataModelBuilder<ParticipantChangeCreate>, DataTemplateBuilder<ParticipantChangeCreate>
{
  public static final ParticipantChangeCreateBuilder INSTANCE = new ParticipantChangeCreateBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("addParticipants");
    JSON_KEY_STORE.put("showHistory");
    JSON_KEY_STORE.put("removeParticipants");
  }
  
  public static ParticipantChangeCreate build(DataReader paramDataReader)
    throws DataReaderException
  {
    ArrayList localArrayList2 = null;
    boolean bool1 = false;
    ArrayList localArrayList1 = null;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299())
    {
      String str;
      if (paramDataReader.shouldReadField$11ca93e7("addParticipants", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList2 = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            str = paramDataReader.readString();
            if (str != null) {
              localArrayList2.add(str);
            }
          }
        }
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("showHistory", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool1 = paramDataReader.readBoolean();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("removeParticipants", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList1 = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            str = paramDataReader.readString();
            if (str != null) {
              localArrayList1.add(str);
            }
          }
        }
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool4) {
      bool1 = false;
    }
    return new ParticipantChangeCreate(localArrayList2, bool1, localArrayList1, bool3, bool4, bool2);
  }
  
  public static ParticipantChangeCreate readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building ParticipantChangeCreate");
    }
    Object localObject2 = paramByteBuffer;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building ParticipantChangeCreate");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building ParticipantChangeCreate");
    }
    if (((ByteBuffer)localObject1).getInt() != -1728487660)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building ParticipantChangeCreate");
    }
    paramString = null;
    boolean bool1 = false;
    paramFissionTransaction = null;
    if (((ByteBuffer)localObject1).get() == 1) {}
    for (boolean bool2 = true; bool2; bool2 = false)
    {
      i = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localObject2 = new ArrayList();
      for (;;)
      {
        paramString = (String)localObject2;
        if (i <= 0) {
          break;
        }
        ((List)localObject2).add(paramFissionAdapter.readString((ByteBuffer)localObject1));
        i -= 1;
      }
    }
    boolean bool3;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool3 = true;
      if (bool3)
      {
        if (((ByteBuffer)localObject1).get() != 1) {
          break label383;
        }
        bool1 = true;
      }
      label308:
      if (((ByteBuffer)localObject1).get() != 1) {
        break label389;
      }
    }
    label383:
    label389:
    for (boolean bool4 = true;; bool4 = false)
    {
      if (!bool4) {
        break label395;
      }
      i = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localObject2 = new ArrayList();
      for (;;)
      {
        paramFissionTransaction = (FissionTransaction)localObject2;
        if (i <= 0) {
          break;
        }
        ((List)localObject2).add(paramFissionAdapter.readString((ByteBuffer)localObject1));
        i -= 1;
      }
      bool3 = false;
      break;
      bool1 = false;
      break label308;
    }
    label395:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
    }
    if (!bool3) {
      bool1 = false;
    }
    return new ParticipantChangeCreate(paramString, bool1, paramFissionTransaction, bool2, bool3, bool4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.create.ParticipantChangeCreateBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */