package com.linkedin.android.pegasus.gen.voyager.entities.school;

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

public final class FinancialInformationBuilder
  implements FissileDataModelBuilder<FinancialInformation>, DataTemplateBuilder<FinancialInformation>
{
  public static final FinancialInformationBuilder INSTANCE = new FinancialInformationBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("financialAidAvailable");
    JSON_KEY_STORE.put("financialAidPercentage");
    JSON_KEY_STORE.put("inStateTuition");
    JSON_KEY_STORE.put("outOfStateTuition");
  }
  
  public static FinancialInformation build(DataReader paramDataReader)
    throws DataReaderException
  {
    boolean bool4 = false;
    float f = 0.0F;
    String str2 = null;
    String str1 = null;
    boolean bool5 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("financialAidAvailable", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool4 = paramDataReader.readBoolean();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("financialAidPercentage", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        f = paramDataReader.readFloat();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("inStateTuition", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("outOfStateTuition", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    return new FinancialInformation(bool4, f, str2, str1, bool5, bool3, bool2, bool1);
  }
  
  public static FinancialInformation readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building FinancialInformation");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building FinancialInformation");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building FinancialInformation");
    }
    if (((ByteBuffer)localObject).getInt() != -1614407804)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building FinancialInformation");
    }
    boolean bool1 = false;
    float f = 0.0F;
    paramString = null;
    paramFissionTransaction = null;
    boolean bool2;
    label236:
    boolean bool3;
    label248:
    boolean bool4;
    if (((ByteBuffer)localObject).get() == 1)
    {
      bool2 = true;
      if (bool2)
      {
        if (((ByteBuffer)localObject).get() != 1) {
          break label352;
        }
        bool1 = true;
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label358;
      }
      bool3 = true;
      if (bool3) {
        f = ((ByteBuffer)localObject).getFloat();
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label364;
      }
      bool4 = true;
      label272:
      if (bool4) {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject);
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label370;
      }
    }
    label352:
    label358:
    label364:
    label370:
    for (boolean bool5 = true;; bool5 = false)
    {
      if (bool5) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      return new FinancialInformation(bool1, f, paramString, paramFissionTransaction, bool2, bool3, bool4, bool5);
      bool2 = false;
      break;
      bool1 = false;
      break label236;
      bool3 = false;
      break label248;
      bool4 = false;
      break label272;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.school.FinancialInformationBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */