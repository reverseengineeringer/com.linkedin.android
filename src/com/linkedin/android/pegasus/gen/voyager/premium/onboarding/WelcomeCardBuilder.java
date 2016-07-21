package com.linkedin.android.pegasus.gen.voyager.premium.onboarding;

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

public final class WelcomeCardBuilder
  implements FissileDataModelBuilder<WelcomeCard>, DataTemplateBuilder<WelcomeCard>
{
  public static final WelcomeCardBuilder INSTANCE = new WelcomeCardBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("productName");
    JSON_KEY_STORE.put("productDescription");
  }
  
  public static WelcomeCard build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str1 = null;
    String str2 = null;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("productName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("productDescription", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: productName when building com.linkedin.android.pegasus.gen.voyager.premium.onboarding.WelcomeCard");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: productDescription when building com.linkedin.android.pegasus.gen.voyager.premium.onboarding.WelcomeCard");
    }
    return new WelcomeCard(str1, str2, bool1, bool2);
  }
  
  public static WelcomeCard readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    boolean bool2 = true;
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building WelcomeCard");
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
            break label170;
          }
          localObject = paramFissionAdapter.readString(paramString);
          paramFissionAdapter.recycle(paramString);
          localObject = paramFissionAdapter.readFromCache((String)localObject, paramFissionTransaction);
          if (localObject == null) {
            break;
          }
          j = ((ByteBuffer)localObject).get();
          paramString = (String)localObject;
          i = j;
        } while (j == 1);
        paramString = (String)localObject;
        i = j;
      } while (j == 0);
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("Invalid header prefix. Can't read cached data when building WelcomeCard");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building WelcomeCard");
    }
    label170:
    if (((ByteBuffer)localObject).getInt() != 1998172770)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building WelcomeCard");
    }
    paramString = null;
    paramFissionTransaction = null;
    boolean bool1;
    if (((ByteBuffer)localObject).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject);
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label284;
      }
    }
    for (;;)
    {
      if (bool2) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      if (bool1) {
        break label290;
      }
      throw new IOException("Failed to find required field: productName when reading com.linkedin.android.pegasus.gen.voyager.premium.onboarding.WelcomeCard from fission.");
      bool1 = false;
      break;
      label284:
      bool2 = false;
    }
    label290:
    if (!bool2) {
      throw new IOException("Failed to find required field: productDescription when reading com.linkedin.android.pegasus.gen.voyager.premium.onboarding.WelcomeCard from fission.");
    }
    return new WelcomeCard(paramString, paramFissionTransaction, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.premium.onboarding.WelcomeCardBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */