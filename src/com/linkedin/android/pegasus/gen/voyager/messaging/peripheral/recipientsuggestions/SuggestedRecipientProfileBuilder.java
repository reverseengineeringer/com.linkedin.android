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

public final class SuggestedRecipientProfileBuilder
  implements FissileDataModelBuilder<SuggestedRecipientProfile>, DataTemplateBuilder<SuggestedRecipientProfile>
{
  public static final SuggestedRecipientProfileBuilder INSTANCE = new SuggestedRecipientProfileBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("com.linkedin.voyager.messaging.peripheral.recipientsuggestions.SuggestedMember");
  }
  
  public static SuggestedRecipientProfile build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject = null;
    boolean bool = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.messaging.peripheral.recipientsuggestions.SuggestedMember", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = SuggestedMemberBuilder.INSTANCE;
        localObject = SuggestedMemberBuilder.build(paramDataReader);
        bool = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    return new SuggestedRecipientProfile((SuggestedMember)localObject, bool);
  }
  
  public static SuggestedRecipientProfile readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SuggestedRecipientProfile");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SuggestedRecipientProfile");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building SuggestedRecipientProfile");
    }
    if (((ByteBuffer)localObject1).getInt() != 735823485)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building SuggestedRecipientProfile");
    }
    paramString = null;
    localObject2 = null;
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool1 = true;
      bool2 = bool1;
      if (bool1)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = (String)localObject2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localObject2 = SuggestedMemberBuilder.INSTANCE;
          paramString = SuggestedMemberBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label326;
          }
          bool1 = true;
        }
        label267:
        bool2 = bool1;
        if (i == 1)
        {
          paramString = SuggestedMemberBuilder.INSTANCE;
          paramString = SuggestedMemberBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label332;
          }
        }
      }
    }
    label326:
    label332:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      return new SuggestedRecipientProfile(paramString, bool2);
      bool1 = false;
      break;
      bool1 = false;
      break label267;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.recipientsuggestions.SuggestedRecipientProfileBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */