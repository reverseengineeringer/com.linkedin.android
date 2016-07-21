package com.linkedin.android.pegasus.gen.voyager.entities.common;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.entities.company.CompanyItem;
import com.linkedin.android.pegasus.gen.voyager.entities.company.CompanyItemBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.company.ShowcaseItemType;
import com.linkedin.android.pegasus.gen.voyager.entities.company.ShowcaseItemType.Builder;
import com.linkedin.android.pegasus.gen.voyager.entities.group.GroupItem;
import com.linkedin.android.pegasus.gen.voyager.entities.group.GroupItemBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.job.JobItem;
import com.linkedin.android.pegasus.gen.voyager.entities.job.JobItemBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolItem;
import com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolItemBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class SectionBuilder
  implements FissileDataModelBuilder<Section>, DataTemplateBuilder<Section>
{
  public static final SectionBuilder INSTANCE = new SectionBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("rank");
    JSON_KEY_STORE.put("items");
  }
  
  public static Section build(DataReader paramDataReader)
    throws DataReaderException
  {
    int i = 0;
    ArrayList localArrayList = null;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("rank", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("items", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            ItemsBuilder localItemsBuilder = ItemsBuilder.INSTANCE;
            localArrayList.add(ItemsBuilder.build(paramDataReader));
          }
        }
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: items when building com.linkedin.android.pegasus.gen.voyager.entities.common.Section");
    }
    return new Section(i, localArrayList, bool1, bool2);
  }
  
  public static Section readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Section");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building Section");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building Section");
    }
    if (((ByteBuffer)localObject1).getInt() != -1926940691)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building Section");
    }
    int j = 0;
    paramString = null;
    boolean bool1;
    boolean bool2;
    label238:
    int k;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        j = ((ByteBuffer)localObject1).getInt();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label371;
      }
      bool2 = true;
      if (!bool2) {
        break label389;
      }
      k = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localObject2 = new ArrayList();
      label262:
      paramString = (String)localObject2;
      if (k <= 0) {
        break label389;
      }
      paramString = null;
      i = 1;
      int m = ((ByteBuffer)localObject1).get();
      if (m == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
        ItemsBuilder localItemsBuilder = ItemsBuilder.INSTANCE;
        paramString = ItemsBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label377;
        }
        i = 1;
      }
      label316:
      if (m == 1)
      {
        paramString = ItemsBuilder.INSTANCE;
        paramString = ItemsBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
        if (paramString == null) {
          break label383;
        }
      }
    }
    label371:
    label377:
    label383:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject2).add(paramString);
      }
      k -= 1;
      break label262;
      bool1 = false;
      break;
      bool2 = false;
      break label238;
      i = 0;
      break label316;
    }
    label389:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
    }
    if (!bool2) {
      throw new IOException("Failed to find required field: items when reading com.linkedin.android.pegasus.gen.voyager.entities.common.Section from fission.");
    }
    return new Section(j, paramString, bool1, bool2);
  }
  
  public static final class ItemsBuilder
    implements FissileDataModelBuilder<Section.Items>, DataTemplateBuilder<Section.Items>
  {
    public static final ItemsBuilder INSTANCE = new ItemsBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.voyager.entities.company.CompanyItem");
      JSON_KEY_STORE.put("com.linkedin.voyager.entities.company.ShowcaseItemType");
      JSON_KEY_STORE.put("com.linkedin.voyager.entities.school.SchoolItem");
      JSON_KEY_STORE.put("com.linkedin.voyager.entities.job.JobItem");
      JSON_KEY_STORE.put("com.linkedin.voyager.entities.group.GroupItem");
    }
    
    public static Section.Items build(DataReader paramDataReader)
      throws DataReaderException
    {
      Object localObject4 = null;
      ShowcaseItemType localShowcaseItemType = null;
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
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.company.CompanyItem", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject4 = CompanyItemBuilder.INSTANCE;
          localObject4 = CompanyItemBuilder.build(paramDataReader);
          bool5 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.company.ShowcaseItemType", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localShowcaseItemType = (ShowcaseItemType)paramDataReader.readEnum(ShowcaseItemType.Builder.INSTANCE);
          bool4 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.school.SchoolItem", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject3 = SchoolItemBuilder.INSTANCE;
          localObject3 = SchoolItemBuilder.build(paramDataReader);
          bool3 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.job.JobItem", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = JobItemBuilder.INSTANCE;
          localObject2 = JobItemBuilder.build(paramDataReader);
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.group.GroupItem", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = GroupItemBuilder.INSTANCE;
          localObject1 = GroupItemBuilder.build(paramDataReader);
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
          throw new DataReaderException("Found more than 1 member when building .Items");
        }
        i = 1;
      }
      j = i;
      if (bool3)
      {
        if (i != 0) {
          throw new DataReaderException("Found more than 1 member when building .Items");
        }
        j = 1;
      }
      i = j;
      if (bool2)
      {
        if (j != 0) {
          throw new DataReaderException("Found more than 1 member when building .Items");
        }
        i = 1;
      }
      if ((bool1) && (i != 0)) {
        throw new DataReaderException("Found more than 1 member when building .Items");
      }
      return new Section.Items((CompanyItem)localObject4, localShowcaseItemType, (SchoolItem)localObject3, (JobItem)localObject2, (GroupItem)localObject1, bool5, bool4, bool3, bool2, bool1);
    }
    
    public static Section.Items readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building Section.Items");
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
            localObject4 = paramString;
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
        throw new IOException("Invalid header prefix. Can't read cached data when building Section.Items");
      }
      Object localObject4 = localObject1;
      if (((ByteBuffer)localObject1).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("Invalid header prefix. Can't read cached data when building Section.Items");
      }
      if (((ByteBuffer)localObject4).getInt() != -559321510)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject4);
        throw new IOException("UID mismatch. Can't read cached data when building Section.Items");
      }
      paramString = null;
      CompanyItemBuilder localCompanyItemBuilder = null;
      ShowcaseItemType localShowcaseItemType = null;
      localObject1 = null;
      SchoolItemBuilder localSchoolItemBuilder = null;
      Object localObject2 = null;
      JobItemBuilder localJobItemBuilder = null;
      Object localObject3 = null;
      GroupItemBuilder localGroupItemBuilder = null;
      boolean bool2;
      boolean bool1;
      label292:
      label318:
      boolean bool6;
      label330:
      boolean bool3;
      label360:
      label422:
      label451:
      boolean bool4;
      if (((ByteBuffer)localObject4).get() == 1)
      {
        bool2 = true;
        bool1 = bool2;
        if (bool2)
        {
          i = ((ByteBuffer)localObject4).get();
          paramString = localCompanyItemBuilder;
          bool1 = bool2;
          if (i == 0)
          {
            paramString = paramFissionAdapter.readString((ByteBuffer)localObject4);
            localCompanyItemBuilder = CompanyItemBuilder.INSTANCE;
            paramString = CompanyItemBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label710;
            }
            bool1 = true;
          }
          if (i == 1)
          {
            paramString = CompanyItemBuilder.INSTANCE;
            paramString = CompanyItemBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
            if (paramString == null) {
              break label716;
            }
            bool1 = true;
          }
        }
        if (((ByteBuffer)localObject4).get() != 1) {
          break label722;
        }
        bool6 = true;
        if (bool6) {
          localShowcaseItemType = ShowcaseItemType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject4));
        }
        if (((ByteBuffer)localObject4).get() != 1) {
          break label728;
        }
        bool3 = true;
        bool2 = bool3;
        if (bool3)
        {
          i = ((ByteBuffer)localObject4).get();
          localObject1 = localSchoolItemBuilder;
          bool2 = bool3;
          if (i == 0)
          {
            localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject4);
            localSchoolItemBuilder = SchoolItemBuilder.INSTANCE;
            localObject1 = SchoolItemBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
            if (localObject1 == null) {
              break label734;
            }
            bool2 = true;
          }
          if (i == 1)
          {
            localObject1 = SchoolItemBuilder.INSTANCE;
            localObject1 = SchoolItemBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
            if (localObject1 == null) {
              break label740;
            }
            bool2 = true;
          }
        }
        if (((ByteBuffer)localObject4).get() != 1) {
          break label746;
        }
        bool4 = true;
        label463:
        bool3 = bool4;
        if (bool4)
        {
          i = ((ByteBuffer)localObject4).get();
          localObject2 = localJobItemBuilder;
          bool3 = bool4;
          if (i == 0)
          {
            localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject4);
            localJobItemBuilder = JobItemBuilder.INSTANCE;
            localObject2 = JobItemBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
            if (localObject2 == null) {
              break label752;
            }
            bool3 = true;
          }
          label525:
          if (i == 1)
          {
            localObject2 = JobItemBuilder.INSTANCE;
            localObject2 = JobItemBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
            if (localObject2 == null) {
              break label758;
            }
            bool3 = true;
          }
        }
        label554:
        if (((ByteBuffer)localObject4).get() != 1) {
          break label764;
        }
        bool4 = true;
        label566:
        bool5 = bool4;
        if (bool4)
        {
          i = ((ByteBuffer)localObject4).get();
          localObject3 = localGroupItemBuilder;
          if (i == 0)
          {
            localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject4);
            localGroupItemBuilder = GroupItemBuilder.INSTANCE;
            localObject3 = GroupItemBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
            if (localObject3 == null) {
              break label770;
            }
            bool4 = true;
          }
          label624:
          bool5 = bool4;
          if (i == 1)
          {
            localObject3 = GroupItemBuilder.INSTANCE;
            localObject3 = GroupItemBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
            if (localObject3 == null) {
              break label776;
            }
          }
        }
      }
      label710:
      label716:
      label722:
      label728:
      label734:
      label740:
      label746:
      label752:
      label758:
      label764:
      label770:
      label776:
      for (boolean bool5 = true;; bool5 = false)
      {
        if (paramByteBuffer == null) {
          paramFissionAdapter.recycle((ByteBuffer)localObject4);
        }
        j = 0;
        if (bool1) {
          j = 1;
        }
        i = j;
        if (!bool6) {
          break label785;
        }
        if (j == 0) {
          break label782;
        }
        throw new IOException("Found more than 1 member when reading .Items from fission.");
        bool2 = false;
        break;
        bool1 = false;
        break label292;
        bool1 = false;
        break label318;
        bool6 = false;
        break label330;
        bool3 = false;
        break label360;
        bool2 = false;
        break label422;
        bool2 = false;
        break label451;
        bool4 = false;
        break label463;
        bool3 = false;
        break label525;
        bool3 = false;
        break label554;
        bool4 = false;
        break label566;
        bool4 = false;
        break label624;
      }
      label782:
      int i = 1;
      label785:
      int j = i;
      if (bool2)
      {
        if (i != 0) {
          throw new IOException("Found more than 1 member when reading .Items from fission.");
        }
        j = 1;
      }
      i = j;
      if (bool3)
      {
        if (j != 0) {
          throw new IOException("Found more than 1 member when reading .Items from fission.");
        }
        i = 1;
      }
      if ((bool5) && (i != 0)) {
        throw new IOException("Found more than 1 member when reading .Items from fission.");
      }
      return new Section.Items(paramString, localShowcaseItemType, (SchoolItem)localObject1, (JobItem)localObject2, (GroupItem)localObject3, bool1, bool6, bool2, bool3, bool5);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.common.SectionBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */