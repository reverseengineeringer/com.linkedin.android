package com.linkedin.android.pegasus.gen.voyager.entities.job;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.PhoneNumber;
import com.linkedin.android.pegasus.gen.common.PhoneNumberBuilder;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfileBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ApplicantBuilder
  implements FissileDataModelBuilder<Applicant>, DataTemplateBuilder<Applicant>
{
  public static final ApplicantBuilder INSTANCE = new ApplicantBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("miniProfile");
    JSON_KEY_STORE.put("location");
    JSON_KEY_STORE.put("phoneNumber");
    JSON_KEY_STORE.put("emailAddress");
    JSON_KEY_STORE.put("otherEmailAddresses");
  }
  
  public static Applicant build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject3 = null;
    String str2 = null;
    Object localObject2 = null;
    String str1 = null;
    Object localObject1 = null;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("miniProfile", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = MiniProfileBuilder.INSTANCE;
        localObject3 = MiniProfileBuilder.build(paramDataReader);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("location", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("phoneNumber", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = PhoneNumberBuilder.INSTANCE;
        localObject2 = PhoneNumberBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("emailAddress", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("otherEmailAddresses", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            String str3 = paramDataReader.readString();
            if (str3 != null) {
              ((List)localObject1).add(str3);
            }
          }
        }
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool1) {
      localObject1 = Collections.emptyList();
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: miniProfile when building com.linkedin.android.pegasus.gen.voyager.entities.job.Applicant");
    }
    return new Applicant((MiniProfile)localObject3, str2, (PhoneNumber)localObject2, str1, (List)localObject1, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static Applicant readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Applicant");
    }
    Object localObject1 = paramByteBuffer;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building Applicant");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building Applicant");
    }
    if (((ByteBuffer)localObject2).getInt() != 273881679)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building Applicant");
    }
    paramString = null;
    MiniProfileBuilder localMiniProfileBuilder = null;
    String str1 = null;
    localObject1 = null;
    PhoneNumberBuilder localPhoneNumberBuilder = null;
    String str2 = null;
    ArrayList localArrayList = null;
    boolean bool2;
    boolean bool1;
    label286:
    label312:
    boolean bool4;
    label324:
    boolean bool3;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = localMiniProfileBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localMiniProfileBuilder = MiniProfileBuilder.INSTANCE;
          paramString = MiniProfileBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label547;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = MiniProfileBuilder.INSTANCE;
          paramString = MiniProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label553;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label559;
      }
      bool4 = true;
      if (bool4) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label565;
      }
      bool3 = true;
      label351:
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject2).get();
        localObject1 = localPhoneNumberBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localPhoneNumberBuilder = PhoneNumberBuilder.INSTANCE;
          localObject1 = PhoneNumberBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label571;
          }
          bool2 = true;
        }
        label413:
        if (i == 1)
        {
          localObject1 = PhoneNumberBuilder.INSTANCE;
          localObject1 = PhoneNumberBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label577;
          }
          bool2 = true;
        }
      }
      label442:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label583;
      }
      bool3 = true;
      label454:
      if (bool3) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label589;
      }
    }
    label547:
    label553:
    label559:
    label565:
    label571:
    label577:
    label583:
    label589:
    for (boolean bool5 = true;; bool5 = false)
    {
      paramFissionTransaction = localArrayList;
      if (!bool5) {
        break label595;
      }
      i = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2);
      localArrayList = new ArrayList();
      for (;;)
      {
        paramFissionTransaction = localArrayList;
        if (i <= 0) {
          break;
        }
        localArrayList.add(paramFissionAdapter.readString((ByteBuffer)localObject2));
        i -= 1;
      }
      bool2 = false;
      break;
      bool1 = false;
      break label286;
      bool1 = false;
      break label312;
      bool4 = false;
      break label324;
      bool3 = false;
      break label351;
      bool2 = false;
      break label413;
      bool2 = false;
      break label442;
      bool3 = false;
      break label454;
    }
    label595:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
    }
    if (!bool5) {
      paramFissionTransaction = Collections.emptyList();
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: miniProfile when reading com.linkedin.android.pegasus.gen.voyager.entities.job.Applicant from fission.");
    }
    return new Applicant(paramString, str1, (PhoneNumber)localObject1, str2, paramFissionTransaction, bool1, bool4, bool2, bool3, bool5);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.job.ApplicantBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */