package com.linkedin.android.pegasus.gen.voyager.entities.shared;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
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

public final class EntityInsightsBuilder
  implements FissileDataModelBuilder<EntityInsights>, DataTemplateBuilder<EntityInsights>
{
  public static final EntityInsightsBuilder INSTANCE = new EntityInsightsBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entity");
    JSON_KEY_STORE.put("insights");
    JSON_KEY_STORE.put("entityInfo");
  }
  
  public static EntityInsights build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject2 = null;
    Object localObject1 = null;
    String str = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("entity", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = EntityBuilder.INSTANCE;
        localObject2 = EntityBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("insights", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            EntitiesFlavorBuilder localEntitiesFlavorBuilder = EntitiesFlavorBuilder.INSTANCE;
            ((List)localObject1).add(EntitiesFlavorBuilder.build(paramDataReader));
          }
        }
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("entityInfo", JSON_KEY_STORE))
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
    if (!bool2) {
      localObject1 = Collections.emptyList();
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: entity when building com.linkedin.android.pegasus.gen.voyager.entities.shared.EntityInsights");
    }
    return new EntityInsights((EntityInsights.Entity)localObject2, (List)localObject1, str, bool3, bool2, bool1);
  }
  
  public static EntityInsights readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building EntityInsights");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building EntityInsights");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building EntityInsights");
    }
    if (((ByteBuffer)localObject2).getInt() != -900565388)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building EntityInsights");
    }
    paramString = null;
    Object localObject4 = null;
    localObject1 = null;
    Object localObject3 = null;
    boolean bool2;
    boolean bool1;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = (String)localObject4;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localObject4 = EntityBuilder.INSTANCE;
          paramString = EntityBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label458;
          }
          bool1 = true;
        }
        label277:
        if (i == 1)
        {
          paramString = EntityBuilder.INSTANCE;
          paramString = EntityBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label464;
          }
          bool1 = true;
        }
      }
      label303:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label470;
      }
      bool2 = true;
      label315:
      if (!bool2) {
        break label488;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2);
      localObject4 = new ArrayList();
      label339:
      localObject1 = localObject4;
      if (j <= 0) {
        break label488;
      }
      localObject1 = null;
      i = 1;
      int k = ((ByteBuffer)localObject2).get();
      if (k == 0)
      {
        localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
        EntitiesFlavorBuilder localEntitiesFlavorBuilder = EntitiesFlavorBuilder.INSTANCE;
        localObject1 = EntitiesFlavorBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
        if (localObject1 == null) {
          break label476;
        }
        i = 1;
      }
      label399:
      if (k == 1)
      {
        localObject1 = EntitiesFlavorBuilder.INSTANCE;
        localObject1 = EntitiesFlavorBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
        if (localObject1 == null) {
          break label482;
        }
      }
    }
    label458:
    label464:
    label470:
    label476:
    label482:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject4).add(localObject1);
      }
      j -= 1;
      break label339;
      bool2 = false;
      break;
      bool1 = false;
      break label277;
      bool1 = false;
      break label303;
      bool2 = false;
      break label315;
      i = 0;
      break label399;
    }
    label488:
    if (((ByteBuffer)localObject2).get() == 1) {}
    for (boolean bool3 = true;; bool3 = false)
    {
      paramFissionTransaction = (FissionTransaction)localObject3;
      if (bool3) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (!bool2) {
        localObject1 = Collections.emptyList();
      }
      if (bool1) {
        break;
      }
      throw new IOException("Failed to find required field: entity when reading com.linkedin.android.pegasus.gen.voyager.entities.shared.EntityInsights from fission.");
    }
    return new EntityInsights(paramString, (List)localObject1, paramFissionTransaction, bool1, bool2, bool3);
  }
  
  public static final class EntityBuilder
    implements FissileDataModelBuilder<EntityInsights.Entity>, DataTemplateBuilder<EntityInsights.Entity>
  {
    public static final EntityBuilder INSTANCE = new EntityBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.voyager.entities.shared.MiniCompany");
    }
    
    public static EntityInsights.Entity build(DataReader paramDataReader)
      throws DataReaderException
    {
      Object localObject = null;
      boolean bool = false;
      paramDataReader.startRecord();
      while (paramDataReader.hasMoreFields$255f299()) {
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.shared.MiniCompany", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject = MiniCompanyBuilder.INSTANCE;
          localObject = MiniCompanyBuilder.build(paramDataReader);
          bool = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
      return new EntityInsights.Entity((MiniCompany)localObject, bool);
    }
    
    public static EntityInsights.Entity readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building EntityInsights.Entity");
      }
      Object localObject2 = paramByteBuffer;
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
        throw new IOException("Invalid header prefix. Can't read cached data when building EntityInsights.Entity");
      }
      Object localObject1 = localObject2;
      if (((ByteBuffer)localObject2).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
        throw new IOException("Invalid header prefix. Can't read cached data when building EntityInsights.Entity");
      }
      if (((ByteBuffer)localObject1).getInt() != -1245610594)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("UID mismatch. Can't read cached data when building EntityInsights.Entity");
      }
      paramString = null;
      localObject2 = null;
      boolean bool1;
      if (((ByteBuffer)localObject1).get() == 1)
      {
        bool1 = true;
        bool2 = bool1;
        if (bool1)
        {
          i = ((ByteBuffer)localObject1).get();
          paramString = (String)localObject2;
          if (i == 0)
          {
            paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
            localObject2 = MiniCompanyBuilder.INSTANCE;
            paramString = MiniCompanyBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label326;
            }
            bool1 = true;
          }
          label267:
          bool2 = bool1;
          if (i == 1)
          {
            paramString = MiniCompanyBuilder.INSTANCE;
            paramString = MiniCompanyBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
            if (paramString == null) {
              break label332;
            }
          }
        }
      }
      label326:
      label332:
      for (boolean bool2 = true;; bool2 = false)
      {
        if (paramByteBuffer == null) {
          paramFissionAdapter.recycle((ByteBuffer)localObject1);
        }
        return new EntityInsights.Entity(paramString, bool2);
        bool1 = false;
        break;
        bool1 = false;
        break label267;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.shared.EntityInsightsBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */