package com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchoolBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SharedEducationInfoBuilder
  implements FissileDataModelBuilder<SharedEducationInfo>, DataTemplateBuilder<SharedEducationInfo>
{
  public static final SharedEducationInfoBuilder INSTANCE = new SharedEducationInfoBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("school");
    JSON_KEY_STORE.put("overlapInfo");
  }
  
  public static SharedEducationInfo build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("school", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = MiniSchoolBuilder.INSTANCE;
        localObject1 = MiniSchoolBuilder.build(paramDataReader);
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("overlapInfo", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = OverlapInfoBuilder.INSTANCE;
        localObject2 = OverlapInfoBuilder.build(paramDataReader);
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: school when building com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.SharedEducationInfo");
    }
    return new SharedEducationInfo((MiniSchool)localObject1, (OverlapInfo)localObject2, bool1, bool2);
  }
  
  public static SharedEducationInfo readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SharedEducationInfo");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SharedEducationInfo");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building SharedEducationInfo");
    }
    if (((ByteBuffer)localObject2).getInt() != -2075650991)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building SharedEducationInfo");
    }
    paramString = null;
    MiniSchoolBuilder localMiniSchoolBuilder = null;
    localObject1 = null;
    OverlapInfoBuilder localOverlapInfoBuilder = null;
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
        paramString = localMiniSchoolBuilder;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localMiniSchoolBuilder = MiniSchoolBuilder.INSTANCE;
          paramString = MiniSchoolBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label439;
          }
          bool1 = true;
        }
        label277:
        if (i == 1)
        {
          paramString = MiniSchoolBuilder.INSTANCE;
          paramString = MiniSchoolBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label445;
          }
          bool1 = true;
        }
      }
      label303:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label451;
      }
      bool2 = true;
      label315:
      bool3 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        localObject1 = localOverlapInfoBuilder;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localOverlapInfoBuilder = OverlapInfoBuilder.INSTANCE;
          localObject1 = OverlapInfoBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label457;
          }
          bool2 = true;
        }
        label373:
        bool3 = bool2;
        if (i == 1)
        {
          localObject1 = OverlapInfoBuilder.INSTANCE;
          localObject1 = OverlapInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label463;
          }
        }
      }
    }
    label439:
    label445:
    label451:
    label457:
    label463:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (bool1) {
        break label469;
      }
      throw new IOException("Failed to find required field: school when reading com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.SharedEducationInfo from fission.");
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
    label469:
    return new SharedEducationInfo(paramString, (OverlapInfo)localObject1, bool1, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.SharedEducationInfoBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */