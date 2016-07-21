package com.linkedin.android.pegasus.gen.voyager.entities.school;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.PhoneNumber;
import com.linkedin.android.pegasus.gen.common.PhoneNumberBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SchoolDetailsBuilder
  implements FissileDataModelBuilder<SchoolDetails>, DataTemplateBuilder<SchoolDetails>
{
  public static final SchoolDetailsBuilder INSTANCE = new SchoolDetailsBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("totalPopulation");
    JSON_KEY_STORE.put("homepageUrl");
    JSON_KEY_STORE.put("emailAddress");
    JSON_KEY_STORE.put("phoneNumber");
    JSON_KEY_STORE.put("schoolType");
    JSON_KEY_STORE.put("address");
    JSON_KEY_STORE.put("yearLevel");
    JSON_KEY_STORE.put("graduationPercentage");
    JSON_KEY_STORE.put("inStateTuition");
    JSON_KEY_STORE.put("outOfStateTuition");
  }
  
  public static SchoolDetails build(DataReader paramDataReader)
    throws DataReaderException
  {
    int i = 0;
    String str7 = null;
    String str6 = null;
    Object localObject = null;
    String str5 = null;
    String str4 = null;
    String str3 = null;
    float f = 0.0F;
    String str2 = null;
    String str1 = null;
    boolean bool10 = false;
    boolean bool9 = false;
    boolean bool8 = false;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("totalPopulation", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool10 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("homepageUrl", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str7 = paramDataReader.readString();
        bool9 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("emailAddress", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str6 = paramDataReader.readString();
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("phoneNumber", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = PhoneNumberBuilder.INSTANCE;
        localObject = PhoneNumberBuilder.build(paramDataReader);
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("schoolType", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str5 = paramDataReader.readString();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("address", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str4 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("yearLevel", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("graduationPercentage", JSON_KEY_STORE))
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
    return new SchoolDetails(i, str7, str6, (PhoneNumber)localObject, str5, str4, str3, f, str2, str1, bool10, bool9, bool8, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static SchoolDetails readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SchoolDetails");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SchoolDetails");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building SchoolDetails");
    }
    if (((ByteBuffer)localObject1).getInt() != -413774918)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building SchoolDetails");
    }
    int i = 0;
    localObject2 = null;
    String str1 = null;
    paramString = null;
    PhoneNumberBuilder localPhoneNumberBuilder = null;
    Object localObject3 = null;
    String str2 = null;
    String str3 = null;
    float f = 0.0F;
    String str4 = null;
    String str5 = null;
    boolean bool3;
    boolean bool4;
    label265:
    boolean bool5;
    label292:
    boolean bool2;
    label319:
    boolean bool1;
    label376:
    label402:
    label414:
    boolean bool6;
    label443:
    boolean bool7;
    label470:
    boolean bool8;
    label497:
    boolean bool9;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool3 = true;
      if (bool3) {
        i = ((ByteBuffer)localObject1).getInt();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label627;
      }
      bool4 = true;
      if (bool4) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label633;
      }
      bool5 = true;
      if (bool5) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label639;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        j = ((ByteBuffer)localObject1).get();
        paramString = localPhoneNumberBuilder;
        bool1 = bool2;
        if (j == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localPhoneNumberBuilder = PhoneNumberBuilder.INSTANCE;
          paramString = PhoneNumberBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label645;
          }
          bool1 = true;
        }
        if (j == 1)
        {
          paramString = PhoneNumberBuilder.INSTANCE;
          paramString = PhoneNumberBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label651;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label657;
      }
      bool2 = true;
      paramFissionTransaction = (FissionTransaction)localObject3;
      if (bool2) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label663;
      }
      bool6 = true;
      if (bool6) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label669;
      }
      bool7 = true;
      if (bool7) {
        str3 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label675;
      }
      bool8 = true;
      if (bool8) {
        f = ((ByteBuffer)localObject1).getFloat();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label681;
      }
      bool9 = true;
      label521:
      if (bool9) {
        str4 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label687;
      }
    }
    label627:
    label633:
    label639:
    label645:
    label651:
    label657:
    label663:
    label669:
    label675:
    label681:
    label687:
    for (boolean bool10 = true;; bool10 = false)
    {
      if (bool10) {
        str5 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      return new SchoolDetails(i, (String)localObject2, str1, paramString, paramFissionTransaction, str2, str3, f, str4, str5, bool3, bool4, bool5, bool1, bool2, bool6, bool7, bool8, bool9, bool10);
      bool3 = false;
      break;
      bool4 = false;
      break label265;
      bool5 = false;
      break label292;
      bool2 = false;
      break label319;
      bool1 = false;
      break label376;
      bool1 = false;
      break label402;
      bool2 = false;
      break label414;
      bool6 = false;
      break label443;
      bool7 = false;
      break label470;
      bool8 = false;
      break label497;
      bool9 = false;
      break label521;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolDetailsBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */