package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.DateRange;
import com.linkedin.android.pegasus.gen.voyager.common.DateRangeBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class OrganizationBuilder
  implements FissileDataModelBuilder<Organization>, DataTemplateBuilder<Organization>
{
  public static final OrganizationBuilder INSTANCE = new OrganizationBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("name");
    JSON_KEY_STORE.put("timePeriod");
    JSON_KEY_STORE.put("position");
    JSON_KEY_STORE.put("occupation");
    JSON_KEY_STORE.put("description");
  }
  
  public static Organization build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject3 = null;
    String str3 = null;
    Object localObject2 = null;
    String str2 = null;
    Object localObject1 = null;
    String str1 = null;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("entityUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("name", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("timePeriod", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = DateRangeBuilder.INSTANCE;
        localObject2 = DateRangeBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("position", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("occupation", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = UrnCoercer.INSTANCE;
        localObject1 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("description", JSON_KEY_STORE))
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
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: name when building com.linkedin.android.pegasus.gen.voyager.identity.profile.Organization");
    }
    return new Organization((Urn)localObject3, str3, (DateRange)localObject2, str2, (Urn)localObject1, str1, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static Organization readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Organization");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building Organization");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building Organization");
    }
    if (((ByteBuffer)localObject1).getInt() != -788564116)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building Organization");
    }
    localObject2 = null;
    String str1 = null;
    paramString = null;
    DateRangeBuilder localDateRangeBuilder = null;
    Object localObject4 = null;
    Object localObject3 = null;
    String str2 = null;
    boolean bool3;
    boolean bool4;
    label264:
    boolean bool2;
    label291:
    boolean bool1;
    label348:
    label374:
    label386:
    boolean bool5;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool3 = true;
      if (bool3)
      {
        localObject2 = UrnCoercer.INSTANCE;
        localObject2 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject1));
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label498;
      }
      bool4 = true;
      if (bool4) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label504;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = localDateRangeBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localDateRangeBuilder = DateRangeBuilder.INSTANCE;
          paramString = DateRangeBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label510;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = DateRangeBuilder.INSTANCE;
          paramString = DateRangeBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label516;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label522;
      }
      bool2 = true;
      paramFissionTransaction = (FissionTransaction)localObject4;
      if (bool2) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label528;
      }
      bool5 = true;
      label415:
      if (bool5)
      {
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject1));
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label534;
      }
    }
    label498:
    label504:
    label510:
    label516:
    label522:
    label528:
    label534:
    for (boolean bool6 = true;; bool6 = false)
    {
      if (bool6) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool4) {
        break label540;
      }
      throw new IOException("Failed to find required field: name when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.Organization from fission.");
      bool3 = false;
      break;
      bool4 = false;
      break label264;
      bool2 = false;
      break label291;
      bool1 = false;
      break label348;
      bool1 = false;
      break label374;
      bool2 = false;
      break label386;
      bool5 = false;
      break label415;
    }
    label540:
    return new Organization((Urn)localObject2, str1, paramString, paramFissionTransaction, (Urn)localObject3, str2, bool3, bool4, bool1, bool2, bool5, bool6);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.OrganizationBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */