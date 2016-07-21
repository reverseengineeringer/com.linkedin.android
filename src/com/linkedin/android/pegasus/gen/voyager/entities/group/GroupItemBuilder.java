package com.linkedin.android.pegasus.gen.voyager.entities.group;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.entities.common.Description;
import com.linkedin.android.pegasus.gen.voyager.entities.common.DescriptionBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.common.ItemInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.common.ItemInfoBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class GroupItemBuilder
  implements FissileDataModelBuilder<GroupItem>, DataTemplateBuilder<GroupItem>
{
  public static final GroupItemBuilder INSTANCE = new GroupItemBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("itemInfo");
    JSON_KEY_STORE.put("item");
  }
  
  public static GroupItem build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("itemInfo", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = ItemInfoBuilder.INSTANCE;
        localObject1 = ItemInfoBuilder.build(paramDataReader);
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("item", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = ItemBuilder.INSTANCE;
        localObject2 = ItemBuilder.build(paramDataReader);
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: itemInfo when building com.linkedin.android.pegasus.gen.voyager.entities.group.GroupItem");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: item when building com.linkedin.android.pegasus.gen.voyager.entities.group.GroupItem");
    }
    return new GroupItem((ItemInfo)localObject1, (GroupItem.Item)localObject2, bool1, bool2);
  }
  
  public static GroupItem readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building GroupItem");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building GroupItem");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building GroupItem");
    }
    if (((ByteBuffer)localObject2).getInt() != 746222162)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building GroupItem");
    }
    paramString = null;
    ItemInfoBuilder localItemInfoBuilder = null;
    localObject1 = null;
    ItemBuilder localItemBuilder = null;
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
        paramString = localItemInfoBuilder;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localItemInfoBuilder = ItemInfoBuilder.INSTANCE;
          paramString = ItemInfoBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label439;
          }
          bool1 = true;
        }
        label277:
        if (i == 1)
        {
          paramString = ItemInfoBuilder.INSTANCE;
          paramString = ItemInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
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
        localObject1 = localItemBuilder;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localItemBuilder = ItemBuilder.INSTANCE;
          localObject1 = ItemBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label457;
          }
          bool2 = true;
        }
        label373:
        bool3 = bool2;
        if (i == 1)
        {
          localObject1 = ItemBuilder.INSTANCE;
          localObject1 = ItemBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
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
      throw new IOException("Failed to find required field: itemInfo when reading com.linkedin.android.pegasus.gen.voyager.entities.group.GroupItem from fission.");
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
    if (!bool3) {
      throw new IOException("Failed to find required field: item when reading com.linkedin.android.pegasus.gen.voyager.entities.group.GroupItem from fission.");
    }
    return new GroupItem(paramString, (GroupItem.Item)localObject1, bool1, bool3);
  }
  
  public static final class ItemBuilder
    implements FissileDataModelBuilder<GroupItem.Item>, DataTemplateBuilder<GroupItem.Item>
  {
    public static final ItemBuilder INSTANCE = new ItemBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.voyager.entities.group.NextGroupsCollection");
      JSON_KEY_STORE.put("com.linkedin.voyager.entities.common.Description");
    }
    
    public static GroupItem.Item build(DataReader paramDataReader)
      throws DataReaderException
    {
      Object localObject1 = null;
      Object localObject2 = null;
      boolean bool1 = false;
      boolean bool2 = false;
      paramDataReader.startRecord();
      while (paramDataReader.hasMoreFields$255f299()) {
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.group.NextGroupsCollection", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = NextGroupsCollectionBuilder.INSTANCE;
          localObject1 = NextGroupsCollectionBuilder.build(paramDataReader);
          bool1 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.common.Description", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = DescriptionBuilder.INSTANCE;
          localObject2 = DescriptionBuilder.build(paramDataReader);
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
        throw new DataReaderException("Found more than 1 member when building .Item");
      }
      return new GroupItem.Item((NextGroupsCollection)localObject1, (Description)localObject2, bool1, bool2);
    }
    
    public static GroupItem.Item readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building GroupItem.Item");
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
        throw new IOException("Invalid header prefix. Can't read cached data when building GroupItem.Item");
      }
      Object localObject2 = localObject1;
      if (((ByteBuffer)localObject1).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("Invalid header prefix. Can't read cached data when building GroupItem.Item");
      }
      if (((ByteBuffer)localObject2).getInt() != 1673522347)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
        throw new IOException("UID mismatch. Can't read cached data when building GroupItem.Item");
      }
      paramString = null;
      NextGroupsCollectionBuilder localNextGroupsCollectionBuilder = null;
      localObject1 = null;
      DescriptionBuilder localDescriptionBuilder = null;
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
          paramString = localNextGroupsCollectionBuilder;
          if (i == 0)
          {
            paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
            localNextGroupsCollectionBuilder = NextGroupsCollectionBuilder.INSTANCE;
            paramString = NextGroupsCollectionBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label455;
            }
            bool1 = true;
          }
          label277:
          if (i == 1)
          {
            paramString = NextGroupsCollectionBuilder.INSTANCE;
            paramString = NextGroupsCollectionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
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
          localObject1 = localDescriptionBuilder;
          if (i == 0)
          {
            localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
            localDescriptionBuilder = DescriptionBuilder.INSTANCE;
            localObject1 = DescriptionBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
            if (localObject1 == null) {
              break label473;
            }
            bool2 = true;
          }
          label373:
          bool3 = bool2;
          if (i == 1)
          {
            localObject1 = DescriptionBuilder.INSTANCE;
            localObject1 = DescriptionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
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
        throw new IOException("Found more than 1 member when reading .Item from fission.");
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
      return new GroupItem.Item(paramString, (Description)localObject1, bool1, bool3);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.group.GroupItemBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */