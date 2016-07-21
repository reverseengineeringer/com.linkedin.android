package com.linkedin.android.pegasus.gen.voyager.identity.profile.actions;

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

public final class SendInMailBuilder
  implements FissileDataModelBuilder<SendInMail>, DataTemplateBuilder<SendInMail>
{
  public static final SendInMailBuilder INSTANCE = new SendInMailBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("upsell");
  }
  
  public static SendInMail build(DataReader paramDataReader)
    throws DataReaderException
  {
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("upsell", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool2 = paramDataReader.readBoolean();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    return new SendInMail(bool2, bool1);
  }
  
  public static SendInMail readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SendInMail");
    }
    Object localObject1 = paramByteBuffer;
    if (paramString != null)
    {
      paramString = paramFissionAdapter.readFromCache(paramString, paramFissionTransaction);
      if (paramString == null) {
        return null;
      }
      int i = paramString.get();
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SendInMail");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building SendInMail");
    }
    if (((ByteBuffer)localObject2).getInt() != -1324216599)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building SendInMail");
    }
    boolean bool1 = false;
    boolean bool2;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool2 = true;
      if (bool2) {
        if (((ByteBuffer)localObject2).get() != 1) {
          break label259;
        }
      }
    }
    label259:
    for (bool1 = true;; bool1 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      return new SendInMail(bool1, bool2);
      bool2 = false;
      break;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.actions.SendInMailBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */