package com.linkedin.android.pegasus.gen.voyager.entities.company;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesMiniProfile;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesMiniProfileBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class EmployeeQuoteBuilder
  implements FissileDataModelBuilder<EmployeeQuote>, DataTemplateBuilder<EmployeeQuote>
{
  public static final EmployeeQuoteBuilder INSTANCE = new EmployeeQuoteBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("member");
    JSON_KEY_STORE.put("quote");
  }
  
  public static EmployeeQuote build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject = null;
    String str = null;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("member", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = EntitiesMiniProfileBuilder.INSTANCE;
        localObject = EntitiesMiniProfileBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("quote", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: member when building com.linkedin.android.pegasus.gen.voyager.entities.company.EmployeeQuote");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: quote when building com.linkedin.android.pegasus.gen.voyager.entities.company.EmployeeQuote");
    }
    return new EmployeeQuote((EntitiesMiniProfile)localObject, str, bool2, bool1);
  }
  
  public static EmployeeQuote readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building EmployeeQuote");
    }
    ByteBuffer localByteBuffer = paramByteBuffer;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building EmployeeQuote");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building EmployeeQuote");
    }
    if (((ByteBuffer)localObject).getInt() != 1906026603)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building EmployeeQuote");
    }
    paramString = null;
    EntitiesMiniProfileBuilder localEntitiesMiniProfileBuilder = null;
    localByteBuffer = null;
    boolean bool1;
    if (((ByteBuffer)localObject).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject).get();
        bool1 = bool2;
        paramString = localEntitiesMiniProfileBuilder;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject);
          localEntitiesMiniProfileBuilder = EntitiesMiniProfileBuilder.INSTANCE;
          paramString = EntitiesMiniProfileBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label362;
          }
          bool1 = true;
        }
        label274:
        if (i == 1)
        {
          paramString = EntitiesMiniProfileBuilder.INSTANCE;
          paramString = EntitiesMiniProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject, null, paramFissionTransaction);
          if (paramString == null) {
            break label368;
          }
          bool1 = true;
        }
      }
      label300:
      if (((ByteBuffer)localObject).get() != 1) {
        break label374;
      }
    }
    label362:
    label368:
    label374:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramFissionTransaction = localByteBuffer;
      if (bool2) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      if (bool1) {
        break label380;
      }
      throw new IOException("Failed to find required field: member when reading com.linkedin.android.pegasus.gen.voyager.entities.company.EmployeeQuote from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label274;
      bool1 = false;
      break label300;
    }
    label380:
    if (!bool2) {
      throw new IOException("Failed to find required field: quote when reading com.linkedin.android.pegasus.gen.voyager.entities.company.EmployeeQuote from fission.");
    }
    return new EmployeeQuote(paramString, paramFissionTransaction, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.company.EmployeeQuoteBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */