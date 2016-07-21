package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.DateRange;
import com.linkedin.android.pegasus.gen.voyager.common.DateRangeBuilder;
import com.linkedin.android.pegasus.gen.voyager.identity.VolunteerCause;
import com.linkedin.android.pegasus.gen.voyager.identity.VolunteerCause.Builder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class VolunteerExperienceBuilder
  implements FissileDataModelBuilder<VolunteerExperience>, DataTemplateBuilder<VolunteerExperience>
{
  public static final VolunteerExperienceBuilder INSTANCE = new VolunteerExperienceBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("companyName");
    JSON_KEY_STORE.put("companyUrn");
    JSON_KEY_STORE.put("role");
    JSON_KEY_STORE.put("cause");
    JSON_KEY_STORE.put("timePeriod");
    JSON_KEY_STORE.put("description");
    JSON_KEY_STORE.put("company");
  }
  
  public static VolunteerExperience build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject4 = null;
    String str3 = null;
    Object localObject3 = null;
    String str2 = null;
    VolunteerCause localVolunteerCause = null;
    Object localObject2 = null;
    String str1 = null;
    Object localObject1 = null;
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
      if (paramDataReader.shouldReadField$11ca93e7("entityUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = UrnCoercer.INSTANCE;
        localObject4 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("companyName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("companyUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("role", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("cause", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localVolunteerCause = (VolunteerCause)paramDataReader.readEnum(VolunteerCause.Builder.INSTANCE);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("timePeriod", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = DateRangeBuilder.INSTANCE;
        localObject2 = DateRangeBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("description", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("company", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = VolunteerExperienceCompanyBuilder.INSTANCE;
        localObject1 = VolunteerExperienceCompanyBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool7) {
      throw new DataReaderException("Failed to find required field: companyName when building com.linkedin.android.pegasus.gen.voyager.identity.profile.VolunteerExperience");
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: role when building com.linkedin.android.pegasus.gen.voyager.identity.profile.VolunteerExperience");
    }
    return new VolunteerExperience((Urn)localObject4, str3, (Urn)localObject3, str2, localVolunteerCause, (DateRange)localObject2, str1, (VolunteerExperienceCompany)localObject1, bool8, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static VolunteerExperience readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building VolunteerExperience");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building VolunteerExperience");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building VolunteerExperience");
    }
    if (((ByteBuffer)localObject2).getInt() != -1580519910)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building VolunteerExperience");
    }
    Object localObject3 = null;
    String str1 = null;
    Object localObject4 = null;
    String str2 = null;
    VolunteerCause localVolunteerCause = null;
    paramString = null;
    DateRangeBuilder localDateRangeBuilder = null;
    String str3 = null;
    localObject1 = null;
    VolunteerExperienceCompanyBuilder localVolunteerExperienceCompanyBuilder = null;
    boolean bool4;
    boolean bool5;
    label273:
    boolean bool6;
    label300:
    boolean bool7;
    label335:
    boolean bool8;
    label362:
    boolean bool2;
    label392:
    boolean bool1;
    label449:
    label475:
    boolean bool9;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool4 = true;
      if (bool4)
      {
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject2));
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label638;
      }
      bool5 = true;
      if (bool5) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label644;
      }
      bool6 = true;
      if (bool6)
      {
        localObject4 = UrnCoercer.INSTANCE;
        localObject4 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject2));
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label650;
      }
      bool7 = true;
      if (bool7) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label656;
      }
      bool8 = true;
      if (bool8) {
        localVolunteerCause = VolunteerCause.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2));
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label662;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = localDateRangeBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localDateRangeBuilder = DateRangeBuilder.INSTANCE;
          paramString = DateRangeBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label668;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = DateRangeBuilder.INSTANCE;
          paramString = DateRangeBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label674;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label680;
      }
      bool9 = true;
      label487:
      if (bool9) {
        str3 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label686;
      }
      bool2 = true;
      label514:
      bool3 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        localObject1 = localVolunteerExperienceCompanyBuilder;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localVolunteerExperienceCompanyBuilder = VolunteerExperienceCompanyBuilder.INSTANCE;
          localObject1 = VolunteerExperienceCompanyBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label692;
          }
          bool2 = true;
        }
        label572:
        bool3 = bool2;
        if (i == 1)
        {
          localObject1 = VolunteerExperienceCompanyBuilder.INSTANCE;
          localObject1 = VolunteerExperienceCompanyBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label698;
          }
        }
      }
    }
    label638:
    label644:
    label650:
    label656:
    label662:
    label668:
    label674:
    label680:
    label686:
    label692:
    label698:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (bool5) {
        break label704;
      }
      throw new IOException("Failed to find required field: companyName when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.VolunteerExperience from fission.");
      bool4 = false;
      break;
      bool5 = false;
      break label273;
      bool6 = false;
      break label300;
      bool7 = false;
      break label335;
      bool8 = false;
      break label362;
      bool2 = false;
      break label392;
      bool1 = false;
      break label449;
      bool1 = false;
      break label475;
      bool9 = false;
      break label487;
      bool2 = false;
      break label514;
      bool2 = false;
      break label572;
    }
    label704:
    if (!bool7) {
      throw new IOException("Failed to find required field: role when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.VolunteerExperience from fission.");
    }
    return new VolunteerExperience((Urn)localObject3, str1, (Urn)localObject4, str2, localVolunteerCause, paramString, str3, (VolunteerExperienceCompany)localObject1, bool4, bool5, bool6, bool7, bool8, bool1, bool9, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.VolunteerExperienceBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */