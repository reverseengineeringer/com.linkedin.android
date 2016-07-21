package com.linkedin.android.pegasus.gen.voyager.identity.guidededit;

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

public final class GuidedEditCategoryBuilder
  implements FissileDataModelBuilder<GuidedEditCategory>, DataTemplateBuilder<GuidedEditCategory>
{
  public static final GuidedEditCategoryBuilder INSTANCE = new GuidedEditCategoryBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("id");
    JSON_KEY_STORE.put("categoryType");
    JSON_KEY_STORE.put("tasks");
    JSON_KEY_STORE.put("flowTrackingId");
  }
  
  public static final class CategoryTypeBuilder
    implements FissileDataModelBuilder<GuidedEditCategory.CategoryType>, DataTemplateBuilder<GuidedEditCategory.CategoryType>
  {
    public static final CategoryTypeBuilder INSTANCE = new CategoryTypeBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.voyager.identity.guidededit.CategoryTypeProfileEdit");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.guidededit.CategoryTypeCustom");
    }
    
    public static GuidedEditCategory.CategoryType build(DataReader paramDataReader)
      throws DataReaderException
    {
      Object localObject1 = null;
      Object localObject2 = null;
      boolean bool1 = false;
      boolean bool2 = false;
      paramDataReader.startRecord();
      while (paramDataReader.hasMoreFields$255f299()) {
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.guidededit.CategoryTypeProfileEdit", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = CategoryTypeProfileEditBuilder.INSTANCE;
          localObject1 = CategoryTypeProfileEditBuilder.build(paramDataReader);
          bool1 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.guidededit.CategoryTypeCustom", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = CategoryTypeCustomBuilder.INSTANCE;
          localObject2 = CategoryTypeCustomBuilder.build(paramDataReader);
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
        throw new DataReaderException("Found more than 1 member when building .CategoryType");
      }
      return new GuidedEditCategory.CategoryType((CategoryTypeProfileEdit)localObject1, (CategoryTypeCustom)localObject2, bool1, bool2);
    }
    
    public static GuidedEditCategory.CategoryType readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building GuidedEditCategory.CategoryType");
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
        throw new IOException("Invalid header prefix. Can't read cached data when building GuidedEditCategory.CategoryType");
      }
      Object localObject2 = localObject1;
      if (((ByteBuffer)localObject1).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("Invalid header prefix. Can't read cached data when building GuidedEditCategory.CategoryType");
      }
      if (((ByteBuffer)localObject2).getInt() != 219265078)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
        throw new IOException("UID mismatch. Can't read cached data when building GuidedEditCategory.CategoryType");
      }
      paramString = null;
      CategoryTypeProfileEditBuilder localCategoryTypeProfileEditBuilder = null;
      localObject1 = null;
      CategoryTypeCustomBuilder localCategoryTypeCustomBuilder = null;
      boolean bool2;
      boolean bool1;
      if (((ByteBuffer)localObject2).get() == 1)
      {
        bool2 = true;
        bool1 = bool2;
        if (bool2)
        {
          i = ((ByteBuffer)localObject2).get();
          paramString = localCategoryTypeProfileEditBuilder;
          bool1 = bool2;
          if (i == 0)
          {
            paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
            localCategoryTypeProfileEditBuilder = CategoryTypeProfileEditBuilder.INSTANCE;
            paramString = CategoryTypeProfileEditBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label455;
            }
            bool1 = true;
          }
          label277:
          if (i == 1)
          {
            paramString = CategoryTypeProfileEditBuilder.INSTANCE;
            paramString = CategoryTypeProfileEditBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
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
          localObject1 = localCategoryTypeCustomBuilder;
          if (i == 0)
          {
            localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
            localCategoryTypeCustomBuilder = CategoryTypeCustomBuilder.INSTANCE;
            localObject1 = CategoryTypeCustomBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
            if (localObject1 == null) {
              break label473;
            }
            bool2 = true;
          }
          label373:
          bool3 = bool2;
          if (i == 1)
          {
            localObject1 = CategoryTypeCustomBuilder.INSTANCE;
            localObject1 = CategoryTypeCustomBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
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
        throw new IOException("Found more than 1 member when reading .CategoryType from fission.");
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
      return new GuidedEditCategory.CategoryType(paramString, (CategoryTypeCustom)localObject1, bool1, bool3);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditCategoryBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */