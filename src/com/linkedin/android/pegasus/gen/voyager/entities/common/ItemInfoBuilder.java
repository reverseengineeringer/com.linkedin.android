package com.linkedin.android.pegasus.gen.voyager.entities.common;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.entities.company.CompanyItemType;
import com.linkedin.android.pegasus.gen.voyager.entities.company.CompanyItemType.Builder;
import com.linkedin.android.pegasus.gen.voyager.entities.company.ShowcaseItemType;
import com.linkedin.android.pegasus.gen.voyager.entities.company.ShowcaseItemType.Builder;
import com.linkedin.android.pegasus.gen.voyager.entities.group.GroupItemType;
import com.linkedin.android.pegasus.gen.voyager.entities.group.GroupItemType.Builder;
import com.linkedin.android.pegasus.gen.voyager.entities.job.JobItemType;
import com.linkedin.android.pegasus.gen.voyager.entities.job.JobItemType.Builder;
import com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolItemType;
import com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolItemType.Builder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ItemInfoBuilder
  implements FissileDataModelBuilder<ItemInfo>, DataTemplateBuilder<ItemInfo>
{
  public static final ItemInfoBuilder INSTANCE = new ItemInfoBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("itemType");
    JSON_KEY_STORE.put("rank");
    JSON_KEY_STORE.put("trackingId");
  }
  
  public static ItemInfo build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject = null;
    int i = 0;
    String str = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("itemType", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = ItemTypeBuilder.INSTANCE;
        localObject = ItemTypeBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("rank", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("trackingId", JSON_KEY_STORE))
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
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: itemType when building com.linkedin.android.pegasus.gen.voyager.entities.common.ItemInfo");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: trackingId when building com.linkedin.android.pegasus.gen.voyager.entities.common.ItemInfo");
    }
    return new ItemInfo((ItemInfo.ItemType)localObject, i, str, bool3, bool2, bool1);
  }
  
  public static ItemInfo readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building ItemInfo");
    }
    ByteBuffer localByteBuffer = paramByteBuffer;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building ItemInfo");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building ItemInfo");
    }
    if (((ByteBuffer)localObject).getInt() != -872974866)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building ItemInfo");
    }
    paramString = null;
    ItemTypeBuilder localItemTypeBuilder = null;
    int i = 0;
    localByteBuffer = null;
    boolean bool2;
    boolean bool1;
    if (((ByteBuffer)localObject).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        j = ((ByteBuffer)localObject).get();
        paramString = localItemTypeBuilder;
        bool1 = bool2;
        if (j == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject);
          localItemTypeBuilder = ItemTypeBuilder.INSTANCE;
          paramString = ItemTypeBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label389;
          }
          bool1 = true;
        }
        label277:
        if (j == 1)
        {
          paramString = ItemTypeBuilder.INSTANCE;
          paramString = ItemTypeBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject, null, paramFissionTransaction);
          if (paramString == null) {
            break label395;
          }
          bool1 = true;
        }
      }
      label303:
      if (((ByteBuffer)localObject).get() != 1) {
        break label401;
      }
      bool2 = true;
      label315:
      if (bool2) {
        i = ((ByteBuffer)localObject).getInt();
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label407;
      }
    }
    label389:
    label395:
    label401:
    label407:
    for (boolean bool3 = true;; bool3 = false)
    {
      paramFissionTransaction = localByteBuffer;
      if (bool3) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      if (bool1) {
        break label413;
      }
      throw new IOException("Failed to find required field: itemType when reading com.linkedin.android.pegasus.gen.voyager.entities.common.ItemInfo from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label277;
      bool1 = false;
      break label303;
      bool2 = false;
      break label315;
    }
    label413:
    if (!bool3) {
      throw new IOException("Failed to find required field: trackingId when reading com.linkedin.android.pegasus.gen.voyager.entities.common.ItemInfo from fission.");
    }
    return new ItemInfo(paramString, i, paramFissionTransaction, bool1, bool2, bool3);
  }
  
  public static final class ItemTypeBuilder
    implements FissileDataModelBuilder<ItemInfo.ItemType>, DataTemplateBuilder<ItemInfo.ItemType>
  {
    public static final ItemTypeBuilder INSTANCE = new ItemTypeBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.voyager.entities.company.CompanyItemType");
      JSON_KEY_STORE.put("com.linkedin.voyager.entities.company.ShowcaseItemType");
      JSON_KEY_STORE.put("com.linkedin.voyager.entities.school.SchoolItemType");
      JSON_KEY_STORE.put("com.linkedin.voyager.entities.group.GroupItemType");
      JSON_KEY_STORE.put("com.linkedin.voyager.entities.job.JobItemType");
    }
    
    public static ItemInfo.ItemType build(DataReader paramDataReader)
      throws DataReaderException
    {
      CompanyItemType localCompanyItemType = null;
      ShowcaseItemType localShowcaseItemType = null;
      SchoolItemType localSchoolItemType = null;
      GroupItemType localGroupItemType = null;
      JobItemType localJobItemType = null;
      boolean bool5 = false;
      boolean bool4 = false;
      boolean bool3 = false;
      boolean bool2 = false;
      boolean bool1 = false;
      paramDataReader.startRecord();
      while (paramDataReader.hasMoreFields$255f299()) {
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.company.CompanyItemType", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localCompanyItemType = (CompanyItemType)paramDataReader.readEnum(CompanyItemType.Builder.INSTANCE);
          bool5 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.company.ShowcaseItemType", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localShowcaseItemType = (ShowcaseItemType)paramDataReader.readEnum(ShowcaseItemType.Builder.INSTANCE);
          bool4 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.school.SchoolItemType", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localSchoolItemType = (SchoolItemType)paramDataReader.readEnum(SchoolItemType.Builder.INSTANCE);
          bool3 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.group.GroupItemType", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localGroupItemType = (GroupItemType)paramDataReader.readEnum(GroupItemType.Builder.INSTANCE);
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.job.JobItemType", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localJobItemType = (JobItemType)paramDataReader.readEnum(JobItemType.Builder.INSTANCE);
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
          throw new DataReaderException("Found more than 1 member when building .ItemType");
        }
        i = 1;
      }
      j = i;
      if (bool3)
      {
        if (i != 0) {
          throw new DataReaderException("Found more than 1 member when building .ItemType");
        }
        j = 1;
      }
      i = j;
      if (bool2)
      {
        if (j != 0) {
          throw new DataReaderException("Found more than 1 member when building .ItemType");
        }
        i = 1;
      }
      if ((bool1) && (i != 0)) {
        throw new DataReaderException("Found more than 1 member when building .ItemType");
      }
      return new ItemInfo.ItemType(localCompanyItemType, localShowcaseItemType, localSchoolItemType, localGroupItemType, localJobItemType, bool5, bool4, bool3, bool2, bool1);
    }
    
    public static ItemInfo.ItemType readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building ItemInfo.ItemType");
      }
      Object localObject2 = paramByteBuffer;
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
        throw new IOException("Invalid header prefix. Can't read cached data when building ItemInfo.ItemType");
      }
      Object localObject1 = localObject2;
      if (((ByteBuffer)localObject2).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
        throw new IOException("Invalid header prefix. Can't read cached data when building ItemInfo.ItemType");
      }
      if (((ByteBuffer)localObject1).getInt() != -540795029)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("UID mismatch. Can't read cached data when building ItemInfo.ItemType");
      }
      paramString = null;
      paramFissionTransaction = null;
      localObject2 = null;
      GroupItemType localGroupItemType = null;
      JobItemType localJobItemType = null;
      boolean bool1;
      boolean bool2;
      label251:
      boolean bool3;
      label280:
      boolean bool4;
      if (((ByteBuffer)localObject1).get() == 1)
      {
        bool1 = true;
        if (bool1) {
          paramString = CompanyItemType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1));
        }
        if (((ByteBuffer)localObject1).get() != 1) {
          break label411;
        }
        bool2 = true;
        if (bool2) {
          paramFissionTransaction = ShowcaseItemType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1));
        }
        if (((ByteBuffer)localObject1).get() != 1) {
          break label417;
        }
        bool3 = true;
        if (bool3) {
          localObject2 = SchoolItemType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1));
        }
        if (((ByteBuffer)localObject1).get() != 1) {
          break label423;
        }
        bool4 = true;
        label310:
        if (bool4) {
          localGroupItemType = GroupItemType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1));
        }
        if (((ByteBuffer)localObject1).get() != 1) {
          break label429;
        }
      }
      label411:
      label417:
      label423:
      label429:
      for (boolean bool5 = true;; bool5 = false)
      {
        if (bool5) {
          localJobItemType = JobItemType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1));
        }
        if (paramByteBuffer == null) {
          paramFissionAdapter.recycle((ByteBuffer)localObject1);
        }
        j = 0;
        if (bool1) {
          j = 1;
        }
        i = j;
        if (!bool2) {
          break label438;
        }
        if (j == 0) {
          break label435;
        }
        throw new IOException("Found more than 1 member when reading .ItemType from fission.");
        bool1 = false;
        break;
        bool2 = false;
        break label251;
        bool3 = false;
        break label280;
        bool4 = false;
        break label310;
      }
      label435:
      int i = 1;
      label438:
      int j = i;
      if (bool3)
      {
        if (i != 0) {
          throw new IOException("Found more than 1 member when reading .ItemType from fission.");
        }
        j = 1;
      }
      i = j;
      if (bool4)
      {
        if (j != 0) {
          throw new IOException("Found more than 1 member when reading .ItemType from fission.");
        }
        i = 1;
      }
      if ((bool5) && (i != 0)) {
        throw new IOException("Found more than 1 member when reading .ItemType from fission.");
      }
      return new ItemInfo.ItemType(paramString, paramFissionTransaction, (SchoolItemType)localObject2, localGroupItemType, localJobItemType, bool1, bool2, bool3, bool4, bool5);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.common.ItemInfoBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */