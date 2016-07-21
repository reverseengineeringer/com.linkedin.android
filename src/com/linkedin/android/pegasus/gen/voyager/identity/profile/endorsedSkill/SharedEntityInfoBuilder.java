package com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompanyBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchoolBuilder;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.HighlightsMiniProfileBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class SharedEntityInfoBuilder
  implements FissileDataModelBuilder<SharedEntityInfo>, DataTemplateBuilder<SharedEntityInfo>
{
  public static final SharedEntityInfoBuilder INSTANCE = new SharedEntityInfoBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("endorsers");
    JSON_KEY_STORE.put("totalCount");
    JSON_KEY_STORE.put("sharedEntity");
  }
  
  public static SharedEntityInfo build(DataReader paramDataReader)
    throws DataReaderException
  {
    ArrayList localArrayList = null;
    int i = 0;
    Object localObject = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("endorsers", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            HighlightsMiniProfileBuilder localHighlightsMiniProfileBuilder = HighlightsMiniProfileBuilder.INSTANCE;
            localArrayList.add(HighlightsMiniProfileBuilder.build(paramDataReader));
          }
        }
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("totalCount", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("sharedEntity", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = SharedEntityBuilder.INSTANCE;
        localObject = SharedEntityBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: endorsers when building com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill.SharedEntityInfo");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: totalCount when building com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill.SharedEntityInfo");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: sharedEntity when building com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill.SharedEntityInfo");
    }
    return new SharedEntityInfo(localArrayList, i, (SharedEntityInfo.SharedEntity)localObject, bool3, bool2, bool1);
  }
  
  public static SharedEntityInfo readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SharedEntityInfo");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SharedEntityInfo");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building SharedEntityInfo");
    }
    if (((ByteBuffer)localObject1).getInt() != 1742512512)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building SharedEntityInfo");
    }
    localObject2 = null;
    int k = 0;
    Object localObject3 = null;
    SharedEntityBuilder localSharedEntityBuilder = null;
    boolean bool3;
    ArrayList localArrayList;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool3 = true;
      if (!bool3) {
        break label367;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localArrayList = new ArrayList();
      label245:
      localObject2 = localArrayList;
      if (j <= 0) {
        break label367;
      }
      paramString = null;
      i = 1;
      int m = ((ByteBuffer)localObject1).get();
      if (m == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
        localObject2 = HighlightsMiniProfileBuilder.INSTANCE;
        paramString = HighlightsMiniProfileBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label355;
        }
        i = 1;
      }
      label300:
      if (m == 1)
      {
        paramString = HighlightsMiniProfileBuilder.INSTANCE;
        paramString = HighlightsMiniProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
        if (paramString == null) {
          break label361;
        }
      }
    }
    label355:
    label361:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      j -= 1;
      break label245;
      bool3 = false;
      break;
      i = 0;
      break label300;
    }
    label367:
    boolean bool4;
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool4 = true;
      i = k;
      if (bool4) {
        i = ((ByteBuffer)localObject1).getInt();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label526;
      }
      bool1 = true;
      label407:
      paramString = (String)localObject3;
      bool2 = bool1;
      if (bool1)
      {
        j = ((ByteBuffer)localObject1).get();
        paramString = localSharedEntityBuilder;
        if (j == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localSharedEntityBuilder = SharedEntityBuilder.INSTANCE;
          paramString = SharedEntityBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label532;
          }
          bool1 = true;
        }
        label463:
        bool2 = bool1;
        if (j == 1)
        {
          paramString = SharedEntityBuilder.INSTANCE;
          paramString = SharedEntityBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label538;
          }
        }
      }
    }
    label526:
    label532:
    label538:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool3) {
        break label544;
      }
      throw new IOException("Failed to find required field: endorsers when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill.SharedEntityInfo from fission.");
      bool4 = false;
      break;
      bool1 = false;
      break label407;
      bool1 = false;
      break label463;
    }
    label544:
    if (!bool4) {
      throw new IOException("Failed to find required field: totalCount when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill.SharedEntityInfo from fission.");
    }
    if (!bool2) {
      throw new IOException("Failed to find required field: sharedEntity when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill.SharedEntityInfo from fission.");
    }
    return new SharedEntityInfo((List)localObject2, i, paramString, bool3, bool4, bool2);
  }
  
  public static final class SharedEntityBuilder
    implements FissileDataModelBuilder<SharedEntityInfo.SharedEntity>, DataTemplateBuilder<SharedEntityInfo.SharedEntity>
  {
    public static final SharedEntityBuilder INSTANCE = new SharedEntityBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.voyager.entities.shared.MiniCompany");
      JSON_KEY_STORE.put("com.linkedin.voyager.entities.shared.MiniSchool");
    }
    
    public static SharedEntityInfo.SharedEntity build(DataReader paramDataReader)
      throws DataReaderException
    {
      Object localObject2 = null;
      Object localObject1 = null;
      boolean bool2 = false;
      boolean bool1 = false;
      paramDataReader.startRecord();
      while (paramDataReader.hasMoreFields$255f299()) {
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.shared.MiniCompany", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = MiniCompanyBuilder.INSTANCE;
          localObject2 = MiniCompanyBuilder.build(paramDataReader);
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.shared.MiniSchool", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = MiniSchoolBuilder.INSTANCE;
          localObject1 = MiniSchoolBuilder.build(paramDataReader);
          bool1 = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
      int i = 0;
      if (bool2) {
        i = 1;
      }
      if ((bool1) && (i != 0)) {
        throw new DataReaderException("Found more than 1 member when building .SharedEntity");
      }
      return new SharedEntityInfo.SharedEntity((MiniCompany)localObject2, (MiniSchool)localObject1, bool2, bool1);
    }
    
    public static SharedEntityInfo.SharedEntity readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building SharedEntityInfo.SharedEntity");
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
        throw new IOException("Invalid header prefix. Can't read cached data when building SharedEntityInfo.SharedEntity");
      }
      Object localObject2 = localObject1;
      if (((ByteBuffer)localObject1).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("Invalid header prefix. Can't read cached data when building SharedEntityInfo.SharedEntity");
      }
      if (((ByteBuffer)localObject2).getInt() != 418351561)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
        throw new IOException("UID mismatch. Can't read cached data when building SharedEntityInfo.SharedEntity");
      }
      paramString = null;
      MiniCompanyBuilder localMiniCompanyBuilder = null;
      localObject1 = null;
      MiniSchoolBuilder localMiniSchoolBuilder = null;
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
          paramString = localMiniCompanyBuilder;
          if (i == 0)
          {
            paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
            localMiniCompanyBuilder = MiniCompanyBuilder.INSTANCE;
            paramString = MiniCompanyBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label455;
            }
            bool1 = true;
          }
          label277:
          if (i == 1)
          {
            paramString = MiniCompanyBuilder.INSTANCE;
            paramString = MiniCompanyBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
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
          localObject1 = localMiniSchoolBuilder;
          if (i == 0)
          {
            localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
            localMiniSchoolBuilder = MiniSchoolBuilder.INSTANCE;
            localObject1 = MiniSchoolBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
            if (localObject1 == null) {
              break label473;
            }
            bool2 = true;
          }
          label373:
          bool3 = bool2;
          if (i == 1)
          {
            localObject1 = MiniSchoolBuilder.INSTANCE;
            localObject1 = MiniSchoolBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
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
        throw new IOException("Found more than 1 member when reading .SharedEntity from fission.");
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
      return new SharedEntityInfo.SharedEntity(paramString, (MiniSchool)localObject1, bool1, bool3);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill.SharedEntityInfoBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */