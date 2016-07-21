package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.common.ImageBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SearchFacetValueBuilder
  implements FissileDataModelBuilder<SearchFacetValue>, DataTemplateBuilder<SearchFacetValue>
{
  public static final SearchFacetValueBuilder INSTANCE = new SearchFacetValueBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("value");
    JSON_KEY_STORE.put("displayValue");
    JSON_KEY_STORE.put("image");
    JSON_KEY_STORE.put("count");
    JSON_KEY_STORE.put("selected");
  }
  
  public static SearchFacetValue build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str2 = null;
    String str1 = null;
    Object localObject = null;
    int i = 0;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("value", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("displayValue", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("image", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = ImageBuilder.INSTANCE;
        localObject = ImageBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("count", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("selected", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool6 = paramDataReader.readBoolean();
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: value when building com.linkedin.android.pegasus.gen.voyager.search.SearchFacetValue");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: displayValue when building com.linkedin.android.pegasus.gen.voyager.search.SearchFacetValue");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: count when building com.linkedin.android.pegasus.gen.voyager.search.SearchFacetValue");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: selected when building com.linkedin.android.pegasus.gen.voyager.search.SearchFacetValue");
    }
    return new SearchFacetValue(str2, str1, (Image)localObject, i, bool6, bool5, bool4, bool3, bool1, bool2);
  }
  
  public static SearchFacetValue readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SearchFacetValue");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SearchFacetValue");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building SearchFacetValue");
    }
    if (((ByteBuffer)localObject1).getInt() != -1170772204)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building SearchFacetValue");
    }
    localObject2 = null;
    String str = null;
    paramString = null;
    ImageBuilder localImageBuilder = null;
    int i = 0;
    boolean bool7 = false;
    boolean bool3;
    boolean bool4;
    label253:
    label280:
    boolean bool1;
    label337:
    label363:
    boolean bool5;
    label375:
    boolean bool6;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool3 = true;
      if (bool3) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label453;
      }
      bool4 = true;
      if (bool4) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label459;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        j = ((ByteBuffer)localObject1).get();
        paramString = localImageBuilder;
        bool1 = bool2;
        if (j == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localImageBuilder = ImageBuilder.INSTANCE;
          paramString = ImageBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label465;
          }
          bool1 = true;
        }
        if (j == 1)
        {
          paramString = ImageBuilder.INSTANCE;
          paramString = ImageBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label471;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label477;
      }
      bool5 = true;
      if (bool5) {
        i = ((ByteBuffer)localObject1).getInt();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label483;
      }
      bool6 = true;
      label399:
      bool2 = bool7;
      if (bool6) {
        if (((ByteBuffer)localObject1).get() != 1) {
          break label489;
        }
      }
    }
    label453:
    label459:
    label465:
    label471:
    label477:
    label483:
    label489:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool3) {
        break label495;
      }
      throw new IOException("Failed to find required field: value when reading com.linkedin.android.pegasus.gen.voyager.search.SearchFacetValue from fission.");
      bool3 = false;
      break;
      bool4 = false;
      break label253;
      bool2 = false;
      break label280;
      bool1 = false;
      break label337;
      bool1 = false;
      break label363;
      bool5 = false;
      break label375;
      bool6 = false;
      break label399;
    }
    label495:
    if (!bool4) {
      throw new IOException("Failed to find required field: displayValue when reading com.linkedin.android.pegasus.gen.voyager.search.SearchFacetValue from fission.");
    }
    if (!bool5) {
      throw new IOException("Failed to find required field: count when reading com.linkedin.android.pegasus.gen.voyager.search.SearchFacetValue from fission.");
    }
    if (!bool6) {
      throw new IOException("Failed to find required field: selected when reading com.linkedin.android.pegasus.gen.voyager.search.SearchFacetValue from fission.");
    }
    return new SearchFacetValue((String)localObject2, str, paramString, i, bool2, bool3, bool4, bool1, bool5, bool6);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchFacetValueBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */