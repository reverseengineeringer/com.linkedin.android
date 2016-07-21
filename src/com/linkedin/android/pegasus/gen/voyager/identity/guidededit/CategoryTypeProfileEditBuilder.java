package com.linkedin.android.pegasus.gen.voyager.identity.guidededit;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class CategoryTypeProfileEditBuilder
  implements FissileDataModelBuilder<CategoryTypeProfileEdit>, DataTemplateBuilder<CategoryTypeProfileEdit>
{
  public static final CategoryTypeProfileEditBuilder INSTANCE = new CategoryTypeProfileEditBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("profileCategory");
    JSON_KEY_STORE.put("updateCategory");
    JSON_KEY_STORE.put("updateEntityUrn");
    JSON_KEY_STORE.put("oneClick");
  }
  
  public static CategoryTypeProfileEdit build(DataReader paramDataReader)
    throws DataReaderException
  {
    ProfileCategories localProfileCategories = null;
    boolean bool6 = false;
    Object localObject = null;
    boolean bool1 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("profileCategory", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localProfileCategories = (ProfileCategories)paramDataReader.readEnum(ProfileCategories.Builder.INSTANCE);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("updateCategory", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool6 = paramDataReader.readBoolean();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("updateEntityUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = UrnCoercer.INSTANCE;
        localObject = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("oneClick", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool1 = paramDataReader.readBoolean();
        bool3 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      bool1 = false;
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: profileCategory when building com.linkedin.android.pegasus.gen.voyager.identity.guidededit.CategoryTypeProfileEdit");
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: updateCategory when building com.linkedin.android.pegasus.gen.voyager.identity.guidededit.CategoryTypeProfileEdit");
    }
    return new CategoryTypeProfileEdit(localProfileCategories, bool6, (Urn)localObject, bool1, bool4, bool5, bool2, bool3);
  }
  
  public static CategoryTypeProfileEdit readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building CategoryTypeProfileEdit");
    }
    ByteBuffer localByteBuffer = paramByteBuffer;
    if (paramString != null)
    {
      paramString = paramFissionAdapter.readFromCache(paramString, paramFissionTransaction);
      if (paramString == null) {
        return null;
      }
      int i = paramString.get();
      int j;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building CategoryTypeProfileEdit");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building CategoryTypeProfileEdit");
    }
    if (((ByteBuffer)localObject).getInt() != 310554764)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building CategoryTypeProfileEdit");
    }
    paramString = null;
    boolean bool2 = false;
    paramFissionTransaction = null;
    boolean bool1 = false;
    boolean bool3;
    boolean bool4;
    label248:
    label265:
    boolean bool5;
    label277:
    boolean bool6;
    if (((ByteBuffer)localObject).get() == 1)
    {
      bool3 = true;
      if (bool3) {
        paramString = ProfileCategories.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject));
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label368;
      }
      bool4 = true;
      if (bool4)
      {
        if (((ByteBuffer)localObject).get() != 1) {
          break label374;
        }
        bool2 = true;
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label380;
      }
      bool5 = true;
      if (bool5)
      {
        paramFissionTransaction = UrnCoercer.INSTANCE;
        paramFissionTransaction = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject));
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label386;
      }
      bool6 = true;
      label310:
      if (bool6) {
        if (((ByteBuffer)localObject).get() != 1) {
          break label392;
        }
      }
    }
    label368:
    label374:
    label380:
    label386:
    label392:
    for (bool1 = true;; bool1 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      if (!bool6) {
        bool1 = false;
      }
      if (bool3) {
        break label398;
      }
      throw new IOException("Failed to find required field: profileCategory when reading com.linkedin.android.pegasus.gen.voyager.identity.guidededit.CategoryTypeProfileEdit from fission.");
      bool3 = false;
      break;
      bool4 = false;
      break label248;
      bool2 = false;
      break label265;
      bool5 = false;
      break label277;
      bool6 = false;
      break label310;
    }
    label398:
    if (!bool4) {
      throw new IOException("Failed to find required field: updateCategory when reading com.linkedin.android.pegasus.gen.voyager.identity.guidededit.CategoryTypeProfileEdit from fission.");
    }
    return new CategoryTypeProfileEdit(paramString, bool2, paramFissionTransaction, bool1, bool3, bool4, bool5, bool6);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.guidededit.CategoryTypeProfileEditBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */