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

public final class PhoneNumberBuilder
  implements FissileDataModelBuilder<PhoneNumber>, DataTemplateBuilder<PhoneNumber>
{
  public static final PhoneNumberBuilder INSTANCE = new PhoneNumberBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("number");
    JSON_KEY_STORE.put("extension");
    JSON_KEY_STORE.put("type");
    JSON_KEY_STORE.put("primary");
  }
  
  public static PhoneNumber build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str3 = null;
    String str2 = null;
    String str1 = null;
    boolean bool1 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("number", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("extension", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("type", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("primary", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool1 = paramDataReader.readBoolean();
        bool3 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      bool1 = false;
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: number when building com.linkedin.android.pegasus.gen.voyager.growth.abi.PhoneNumber");
    }
    return new PhoneNumber(str3, str2, str1, bool1, bool5, bool4, bool2, bool3);
  }
  
  public static PhoneNumber readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building PhoneNumber");
    }
    Object localObject2 = paramByteBuffer;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building PhoneNumber");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building PhoneNumber");
    }
    if (((ByteBuffer)localObject1).getInt() != 1652141165)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building PhoneNumber");
    }
    paramString = null;
    paramFissionTransaction = null;
    localObject2 = null;
    boolean bool1 = false;
    boolean bool2;
    boolean bool3;
    label245:
    boolean bool4;
    label271:
    boolean bool5;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool2 = true;
      if (bool2) {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label356;
      }
      bool3 = true;
      if (bool3) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label362;
      }
      bool4 = true;
      if (bool4) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label368;
      }
      bool5 = true;
      label298:
      if (bool5) {
        if (((ByteBuffer)localObject1).get() != 1) {
          break label374;
        }
      }
    }
    label356:
    label362:
    label368:
    label374:
    for (bool1 = true;; bool1 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (!bool5) {
        bool1 = false;
      }
      if (bool2) {
        break label380;
      }
      throw new IOException("Failed to find required field: number when reading com.linkedin.android.pegasus.gen.voyager.growth.abi.PhoneNumber from fission.");
      bool2 = false;
      break;
      bool3 = false;
      break label245;
      bool4 = false;
      break label271;
      bool5 = false;
      break label298;
    }
    label380:
    return new PhoneNumber(paramString, paramFissionTransaction, (String)localObject2, bool1, bool2, bool3, bool4, bool5);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.abi.PhoneNumberBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */