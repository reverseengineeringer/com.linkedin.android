package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompanyBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroupBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchoolBuilder;
import com.linkedin.android.pegasus.gen.voyager.growth.interests.Channel;
import com.linkedin.android.pegasus.gen.voyager.growth.interests.ChannelBuilder;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfileBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class FollowableEntityBuilder$EntityBuilder
  implements FissileDataModelBuilder<FollowableEntity.Entity>, DataTemplateBuilder<FollowableEntity.Entity>
{
  public static final EntityBuilder INSTANCE = new EntityBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("com.linkedin.voyager.identity.shared.MiniProfile");
    JSON_KEY_STORE.put("com.linkedin.voyager.entities.shared.MiniCompany");
    JSON_KEY_STORE.put("com.linkedin.voyager.entities.shared.MiniSchool");
    JSON_KEY_STORE.put("com.linkedin.voyager.entities.shared.MiniGroup");
    JSON_KEY_STORE.put("com.linkedin.voyager.growth.interests.Channel");
  }
  
  public static FollowableEntity.Entity build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.shared.MiniProfile", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject5 = MiniProfileBuilder.INSTANCE;
        localObject5 = MiniProfileBuilder.build(paramDataReader);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.shared.MiniCompany", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = MiniCompanyBuilder.INSTANCE;
        localObject4 = MiniCompanyBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.shared.MiniSchool", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = MiniSchoolBuilder.INSTANCE;
        localObject3 = MiniSchoolBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.shared.MiniGroup", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = MiniGroupBuilder.INSTANCE;
        localObject2 = MiniGroupBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.growth.interests.Channel", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = ChannelBuilder.INSTANCE;
        localObject1 = ChannelBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    int j = 0;
    if (bool5) {
      j = 1;
    }
    int i = j;
    if (bool4)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .Entity");
      }
      i = 1;
    }
    j = i;
    if (bool3)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .Entity");
      }
      j = 1;
    }
    i = j;
    if (bool2)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .Entity");
      }
      i = 1;
    }
    if ((bool1) && (i != 0)) {
      throw new DataReaderException("Found more than 1 member when building .Entity");
    }
    return new FollowableEntity.Entity((MiniProfile)localObject5, (MiniCompany)localObject4, (MiniSchool)localObject3, (MiniGroup)localObject2, (Channel)localObject1, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static FollowableEntity.Entity readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building FollowableEntity.Entity");
    }
    Object localObject1 = paramByteBuffer;
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
          localObject5 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building FollowableEntity.Entity");
    }
    Object localObject5 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building FollowableEntity.Entity");
    }
    if (((ByteBuffer)localObject5).getInt() != 1829020713)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject5);
      throw new IOException("UID mismatch. Can't read cached data when building FollowableEntity.Entity");
    }
    paramString = null;
    MiniProfileBuilder localMiniProfileBuilder = null;
    localObject1 = null;
    MiniCompanyBuilder localMiniCompanyBuilder = null;
    Object localObject2 = null;
    MiniSchoolBuilder localMiniSchoolBuilder = null;
    Object localObject3 = null;
    MiniGroupBuilder localMiniGroupBuilder = null;
    Object localObject4 = null;
    ChannelBuilder localChannelBuilder = null;
    boolean bool2;
    boolean bool1;
    label295:
    label321:
    boolean bool3;
    label333:
    label395:
    label424:
    boolean bool4;
    label436:
    label498:
    label527:
    boolean bool5;
    if (((ByteBuffer)localObject5).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject5).get();
        paramString = localMiniProfileBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localMiniProfileBuilder = MiniProfileBuilder.INSTANCE;
          paramString = MiniProfileBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label786;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = MiniProfileBuilder.INSTANCE;
          paramString = MiniProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (paramString == null) {
            break label792;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label798;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject5).get();
        localObject1 = localMiniCompanyBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localMiniCompanyBuilder = MiniCompanyBuilder.INSTANCE;
          localObject1 = MiniCompanyBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label804;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject1 = MiniCompanyBuilder.INSTANCE;
          localObject1 = MiniCompanyBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label810;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label816;
      }
      bool4 = true;
      bool3 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject5).get();
        localObject2 = localMiniSchoolBuilder;
        bool3 = bool4;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localMiniSchoolBuilder = MiniSchoolBuilder.INSTANCE;
          localObject2 = MiniSchoolBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label822;
          }
          bool3 = true;
        }
        if (i == 1)
        {
          localObject2 = MiniSchoolBuilder.INSTANCE;
          localObject2 = MiniSchoolBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label828;
          }
          bool3 = true;
        }
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label834;
      }
      bool5 = true;
      label539:
      bool4 = bool5;
      if (bool5)
      {
        i = ((ByteBuffer)localObject5).get();
        localObject3 = localMiniGroupBuilder;
        bool4 = bool5;
        if (i == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localMiniGroupBuilder = MiniGroupBuilder.INSTANCE;
          localObject3 = MiniGroupBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label840;
          }
          bool4 = true;
        }
        label601:
        if (i == 1)
        {
          localObject3 = MiniGroupBuilder.INSTANCE;
          localObject3 = MiniGroupBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label846;
          }
          bool4 = true;
        }
      }
      label630:
      if (((ByteBuffer)localObject5).get() != 1) {
        break label852;
      }
      bool5 = true;
      label642:
      bool6 = bool5;
      if (bool5)
      {
        i = ((ByteBuffer)localObject5).get();
        localObject4 = localChannelBuilder;
        if (i == 0)
        {
          localObject4 = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localChannelBuilder = ChannelBuilder.INSTANCE;
          localObject4 = ChannelBuilder.readFromFission(paramFissionAdapter, null, (String)localObject4, paramFissionTransaction);
          if (localObject4 == null) {
            break label858;
          }
          bool5 = true;
        }
        label700:
        bool6 = bool5;
        if (i == 1)
        {
          localObject4 = ChannelBuilder.INSTANCE;
          localObject4 = ChannelBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (localObject4 == null) {
            break label864;
          }
        }
      }
    }
    label786:
    label792:
    label798:
    label804:
    label810:
    label816:
    label822:
    label828:
    label834:
    label840:
    label846:
    label852:
    label858:
    label864:
    for (boolean bool6 = true;; bool6 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject5);
      }
      j = 0;
      if (bool1) {
        j = 1;
      }
      i = j;
      if (!bool2) {
        break label873;
      }
      if (j == 0) {
        break label870;
      }
      throw new IOException("Found more than 1 member when reading .Entity from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label295;
      bool1 = false;
      break label321;
      bool3 = false;
      break label333;
      bool2 = false;
      break label395;
      bool2 = false;
      break label424;
      bool4 = false;
      break label436;
      bool3 = false;
      break label498;
      bool3 = false;
      break label527;
      bool5 = false;
      break label539;
      bool4 = false;
      break label601;
      bool4 = false;
      break label630;
      bool5 = false;
      break label642;
      bool5 = false;
      break label700;
    }
    label870:
    int i = 1;
    label873:
    int j = i;
    if (bool3)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading .Entity from fission.");
      }
      j = 1;
    }
    i = j;
    if (bool4)
    {
      if (j != 0) {
        throw new IOException("Found more than 1 member when reading .Entity from fission.");
      }
      i = 1;
    }
    if ((bool6) && (i != 0)) {
      throw new IOException("Found more than 1 member when reading .Entity from fission.");
    }
    return new FollowableEntity.Entity(paramString, (MiniCompany)localObject1, (MiniSchool)localObject2, (MiniGroup)localObject3, (Channel)localObject4, bool1, bool2, bool3, bool4, bool6);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.FollowableEntityBuilder.EntityBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */