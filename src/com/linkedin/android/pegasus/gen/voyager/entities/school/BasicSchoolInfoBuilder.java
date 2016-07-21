package com.linkedin.android.pegasus.gen.voyager.entities.school;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfoBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchoolBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class BasicSchoolInfoBuilder
  implements FissileDataModelBuilder<BasicSchoolInfo>, DataTemplateBuilder<BasicSchoolInfo>
{
  public static final BasicSchoolInfoBuilder INSTANCE = new BasicSchoolInfoBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("miniSchool");
    JSON_KEY_STORE.put("followingInfo");
    JSON_KEY_STORE.put("followerCount");
    JSON_KEY_STORE.put("location");
  }
  
  public static BasicSchoolInfo build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i = 0;
    String str = null;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("miniSchool", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = MiniSchoolBuilder.INSTANCE;
        localObject2 = MiniSchoolBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("followingInfo", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = FollowingInfoBuilder.INSTANCE;
        localObject1 = FollowingInfoBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("followerCount", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("location", JSON_KEY_STORE))
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
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: miniSchool when building com.linkedin.android.pegasus.gen.voyager.entities.school.BasicSchoolInfo");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: followingInfo when building com.linkedin.android.pegasus.gen.voyager.entities.school.BasicSchoolInfo");
    }
    return new BasicSchoolInfo((MiniSchool)localObject2, (FollowingInfo)localObject1, i, str, bool4, bool3, bool2, bool1);
  }
  
  public static BasicSchoolInfo readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building BasicSchoolInfo");
    }
    Object localObject1 = paramByteBuffer;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building BasicSchoolInfo");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building BasicSchoolInfo");
    }
    if (((ByteBuffer)localObject2).getInt() != -1802369130)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building BasicSchoolInfo");
    }
    paramString = null;
    MiniSchoolBuilder localMiniSchoolBuilder = null;
    localObject1 = null;
    FollowingInfoBuilder localFollowingInfoBuilder = null;
    int i = 0;
    Object localObject3 = null;
    boolean bool2;
    boolean bool1;
    label283:
    label309:
    boolean bool3;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        j = ((ByteBuffer)localObject2).get();
        paramString = localMiniSchoolBuilder;
        bool1 = bool2;
        if (j == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localMiniSchoolBuilder = MiniSchoolBuilder.INSTANCE;
          paramString = MiniSchoolBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label498;
          }
          bool1 = true;
        }
        if (j == 1)
        {
          paramString = MiniSchoolBuilder.INSTANCE;
          paramString = MiniSchoolBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label504;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label510;
      }
      bool3 = true;
      label321:
      bool2 = bool3;
      if (bool3)
      {
        j = ((ByteBuffer)localObject2).get();
        localObject1 = localFollowingInfoBuilder;
        bool2 = bool3;
        if (j == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localFollowingInfoBuilder = FollowingInfoBuilder.INSTANCE;
          localObject1 = FollowingInfoBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label516;
          }
          bool2 = true;
        }
        label383:
        if (j == 1)
        {
          localObject1 = FollowingInfoBuilder.INSTANCE;
          localObject1 = FollowingInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label522;
          }
          bool2 = true;
        }
      }
      label412:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label528;
      }
      bool3 = true;
      label424:
      if (bool3) {
        i = ((ByteBuffer)localObject2).getInt();
      }
      if (((ByteBuffer)localObject2).get() != 1) {
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
    for (boolean bool4 = true;; bool4 = false)
    {
      paramFissionTransaction = (FissionTransaction)localObject3;
      if (bool4) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (bool1) {
        break label540;
      }
      throw new IOException("Failed to find required field: miniSchool when reading com.linkedin.android.pegasus.gen.voyager.entities.school.BasicSchoolInfo from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label283;
      bool1 = false;
      break label309;
      bool3 = false;
      break label321;
      bool2 = false;
      break label383;
      bool2 = false;
      break label412;
      bool3 = false;
      break label424;
    }
    label540:
    if (!bool2) {
      throw new IOException("Failed to find required field: followingInfo when reading com.linkedin.android.pegasus.gen.voyager.entities.school.BasicSchoolInfo from fission.");
    }
    return new BasicSchoolInfo(paramString, (FollowingInfo)localObject1, i, paramFissionTransaction, bool1, bool2, bool3, bool4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.school.BasicSchoolInfoBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */