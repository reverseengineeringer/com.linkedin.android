package com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.recipientsuggestions;

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

public final class SuggestedRecipientBuilder
  implements FissileDataModelBuilder<SuggestedRecipient>, DataTemplateBuilder<SuggestedRecipient>
{
  public static final SuggestedRecipientBuilder INSTANCE = new SuggestedRecipientBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("text");
    JSON_KEY_STORE.put("subtext");
    JSON_KEY_STORE.put("lastMessagedAt");
    JSON_KEY_STORE.put("suggestedRecipientProfile");
  }
  
  public static SuggestedRecipient build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str2 = null;
    String str1 = null;
    long l = 0L;
    Object localObject = null;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("text", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("subtext", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("lastMessagedAt", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("suggestedRecipientProfile", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = SuggestedRecipientProfileBuilder.INSTANCE;
        localObject = SuggestedRecipientProfileBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: text when building com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.recipientsuggestions.SuggestedRecipient");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: suggestedRecipientProfile when building com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.recipientsuggestions.SuggestedRecipient");
    }
    return new SuggestedRecipient(str2, str1, l, (SuggestedRecipientProfile)localObject, bool4, bool3, bool2, bool1);
  }
  
  public static SuggestedRecipient readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SuggestedRecipient");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SuggestedRecipient");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building SuggestedRecipient");
    }
    if (((ByteBuffer)localObject1).getInt() != -1355924287)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building SuggestedRecipient");
    }
    localObject2 = null;
    String str = null;
    long l = 0L;
    paramString = null;
    SuggestedRecipientProfileBuilder localSuggestedRecipientProfileBuilder = null;
    boolean bool3;
    boolean bool4;
    label250:
    boolean bool5;
    label277:
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool3 = true;
      if (bool3) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label417;
      }
      bool4 = true;
      if (bool4) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label423;
      }
      bool5 = true;
      if (bool5) {
        l = ((ByteBuffer)localObject1).getLong();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label429;
      }
      bool1 = true;
      label301:
      bool2 = bool1;
      if (bool1)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = localSuggestedRecipientProfileBuilder;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localSuggestedRecipientProfileBuilder = SuggestedRecipientProfileBuilder.INSTANCE;
          paramString = SuggestedRecipientProfileBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label435;
          }
          bool1 = true;
        }
        label354:
        bool2 = bool1;
        if (i == 1)
        {
          paramString = SuggestedRecipientProfileBuilder.INSTANCE;
          paramString = SuggestedRecipientProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label441;
          }
        }
      }
    }
    label417:
    label423:
    label429:
    label435:
    label441:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool3) {
        break label447;
      }
      throw new IOException("Failed to find required field: text when reading com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.recipientsuggestions.SuggestedRecipient from fission.");
      bool3 = false;
      break;
      bool4 = false;
      break label250;
      bool5 = false;
      break label277;
      bool1 = false;
      break label301;
      bool1 = false;
      break label354;
    }
    label447:
    if (!bool2) {
      throw new IOException("Failed to find required field: suggestedRecipientProfile when reading com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.recipientsuggestions.SuggestedRecipient from fission.");
    }
    return new SuggestedRecipient((String)localObject2, str, l, paramString, bool3, bool4, bool5, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.recipientsuggestions.SuggestedRecipientBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */