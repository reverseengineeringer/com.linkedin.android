package com.linkedin.android.pegasus.gen.voyager.growth.abi;

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

public final class EmailBuilder
  implements FissileDataModelBuilder<Email>, DataTemplateBuilder<Email>
{
  public static final EmailBuilder INSTANCE = new EmailBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("emailAddress");
    JSON_KEY_STORE.put("primary");
    JSON_KEY_STORE.put("type");
  }
  
  public static Email build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str2 = null;
    boolean bool1 = false;
    String str1 = null;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("emailAddress", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("primary", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool1 = paramDataReader.readBoolean();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("type", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
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
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: emailAddress when building com.linkedin.android.pegasus.gen.voyager.growth.abi.Email");
    }
    return new Email(str2, bool1, str1, bool3, bool4, bool2);
  }
  
  public static Email readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Email");
    }
    ByteBuffer localByteBuffer = paramByteBuffer;
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
          localObject = paramString;
          if (i != 0) {
            break;
          }
          localObject = paramFissionAdapter.readString(paramString);
          paramFissionAdapter.recycle(paramString);
          localObject = paramFissionAdapter.readFromCache((String)localObject, paramFissionTransaction);
          if (localObject == null) {
            return null;
          }
          j = ((ByteBuffer)localObject).get();
          paramString = (String)localObject;
          i = j;
        } while (j == 1);
        paramString = (String)localObject;
        i = j;
      } while (j == 0);
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("Invalid header prefix. Can't read cached data when building Email");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building Email");
    }
    if (((ByteBuffer)localObject).getInt() != -122837850)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building Email");
    }
    paramString = null;
    boolean bool1 = false;
    paramFissionTransaction = null;
    boolean bool2;
    boolean bool3;
    if (((ByteBuffer)localObject).get() == 1)
    {
      bool2 = true;
      if (bool2) {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject);
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label326;
      }
      bool3 = true;
      label242:
      if (bool3)
      {
        if (((ByteBuffer)localObject).get() != 1) {
          break label332;
        }
        bool1 = true;
      }
      label259:
      if (((ByteBuffer)localObject).get() != 1) {
        break label338;
      }
    }
    label326:
    label332:
    label338:
    for (boolean bool4 = true;; bool4 = false)
    {
      if (bool4) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      if (!bool3) {
        bool1 = false;
      }
      if (bool2) {
        break label344;
      }
      throw new IOException("Failed to find required field: emailAddress when reading com.linkedin.android.pegasus.gen.voyager.growth.abi.Email from fission.");
      bool2 = false;
      break;
      bool3 = false;
      break label242;
      bool1 = false;
      break label259;
    }
    label344:
    return new Email(paramString, bool1, paramFissionTransaction, bool2, bool3, bool4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.abi.EmailBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */