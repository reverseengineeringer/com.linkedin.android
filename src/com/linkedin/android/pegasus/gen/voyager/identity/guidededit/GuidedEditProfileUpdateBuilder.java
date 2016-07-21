package com.linkedin.android.pegasus.gen.voyager.identity.guidededit;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormEducation;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormEducationBuilder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormPosition;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormPositionBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class GuidedEditProfileUpdateBuilder
  implements FissileDataModelBuilder<GuidedEditProfileUpdate>, DataTemplateBuilder<GuidedEditProfileUpdate>
{
  public static final GuidedEditProfileUpdateBuilder INSTANCE = new GuidedEditProfileUpdateBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("profileUpdate");
  }
  
  public static final class ProfileUpdateBuilder
    implements FissileDataModelBuilder<GuidedEditProfileUpdate.ProfileUpdate>, DataTemplateBuilder<GuidedEditProfileUpdate.ProfileUpdate>
  {
    public static final ProfileUpdateBuilder INSTANCE = new ProfileUpdateBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.voyager.identity.profile.NormPosition");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.profile.NormEducation");
    }
    
    public static GuidedEditProfileUpdate.ProfileUpdate build(DataReader paramDataReader)
      throws DataReaderException
    {
      Object localObject1 = null;
      Object localObject2 = null;
      boolean bool1 = false;
      boolean bool2 = false;
      paramDataReader.startRecord();
      while (paramDataReader.hasMoreFields$255f299()) {
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.NormPosition", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = NormPositionBuilder.INSTANCE;
          localObject1 = NormPositionBuilder.build(paramDataReader);
          bool1 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.NormEducation", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = NormEducationBuilder.INSTANCE;
          localObject2 = NormEducationBuilder.build(paramDataReader);
          bool2 = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
      int i = 0;
      if (bool1) {
        i = 1;
      }
      if ((bool2) && (i != 0)) {
        throw new DataReaderException("Found more than 1 member when building .ProfileUpdate");
      }
      return new GuidedEditProfileUpdate.ProfileUpdate((NormPosition)localObject1, (NormEducation)localObject2, bool1, bool2);
    }
    
    public static GuidedEditProfileUpdate.ProfileUpdate readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building GuidedEditProfileUpdate.ProfileUpdate");
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
        throw new IOException("Invalid header prefix. Can't read cached data when building GuidedEditProfileUpdate.ProfileUpdate");
      }
      Object localObject2 = localObject1;
      if (((ByteBuffer)localObject1).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("Invalid header prefix. Can't read cached data when building GuidedEditProfileUpdate.ProfileUpdate");
      }
      if (((ByteBuffer)localObject2).getInt() != -518974580)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
        throw new IOException("UID mismatch. Can't read cached data when building GuidedEditProfileUpdate.ProfileUpdate");
      }
      paramString = null;
      NormPositionBuilder localNormPositionBuilder = null;
      localObject1 = null;
      NormEducationBuilder localNormEducationBuilder = null;
      boolean bool2;
      boolean bool1;
      if (((ByteBuffer)localObject2).get() == 1)
      {
        bool2 = true;
        bool1 = bool2;
        if (bool2)
        {
          i = ((ByteBuffer)localObject2).get();
          bool1 = bool2;
          paramString = localNormPositionBuilder;
          if (i == 0)
          {
            paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
            localNormPositionBuilder = NormPositionBuilder.INSTANCE;
            paramString = NormPositionBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label455;
            }
            bool1 = true;
          }
          label277:
          if (i == 1)
          {
            paramString = NormPositionBuilder.INSTANCE;
            paramString = NormPositionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
            if (paramString == null) {
              break label461;
            }
            bool1 = true;
          }
        }
        label303:
        if (((ByteBuffer)localObject2).get() != 1) {
          break label467;
        }
        bool2 = true;
        label315:
        bool3 = bool2;
        if (bool2)
        {
          i = ((ByteBuffer)localObject2).get();
          localObject1 = localNormEducationBuilder;
          if (i == 0)
          {
            localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
            localNormEducationBuilder = NormEducationBuilder.INSTANCE;
            localObject1 = NormEducationBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
            if (localObject1 == null) {
              break label473;
            }
            bool2 = true;
          }
          label373:
          bool3 = bool2;
          if (i == 1)
          {
            localObject1 = NormEducationBuilder.INSTANCE;
            localObject1 = NormEducationBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
            if (localObject1 == null) {
              break label479;
            }
          }
        }
      }
      label455:
      label461:
      label467:
      label473:
      label479:
      for (boolean bool3 = true;; bool3 = false)
      {
        if (paramByteBuffer == null) {
          paramFissionAdapter.recycle((ByteBuffer)localObject2);
        }
        i = 0;
        if (bool1) {
          i = 1;
        }
        if ((!bool3) || (i == 0)) {
          break label485;
        }
        throw new IOException("Found more than 1 member when reading .ProfileUpdate from fission.");
        bool2 = false;
        break;
        bool1 = false;
        break label277;
        bool1 = false;
        break label303;
        bool2 = false;
        break label315;
        bool2 = false;
        break label373;
      }
      label485:
      return new GuidedEditProfileUpdate.ProfileUpdate(paramString, (NormEducation)localObject1, bool1, bool3);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditProfileUpdateBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */