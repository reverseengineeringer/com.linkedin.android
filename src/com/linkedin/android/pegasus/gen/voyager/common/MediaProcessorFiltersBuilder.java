package com.linkedin.android.pegasus.gen.voyager.common;

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

public final class MediaProcessorFiltersBuilder
  implements FissileDataModelBuilder<MediaProcessorFilters>, DataTemplateBuilder<MediaProcessorFilters>
{
  public static final MediaProcessorFiltersBuilder INSTANCE = new MediaProcessorFiltersBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("contain");
    JSON_KEY_STORE.put("cover");
    JSON_KEY_STORE.put("fill");
    JSON_KEY_STORE.put("original");
  }
  
  public static MediaProcessorFilters build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str4 = null;
    String str3 = null;
    String str2 = null;
    String str1 = null;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("contain", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str4 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("cover", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("fill", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("original", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: contain when building com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorFilters");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: cover when building com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorFilters");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: fill when building com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorFilters");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: original when building com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorFilters");
    }
    return new MediaProcessorFilters(str4, str3, str2, str1, bool4, bool3, bool2, bool1);
  }
  
  public static MediaProcessorFilters readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building MediaProcessorFilters");
    }
    Object localObject2 = paramByteBuffer;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building MediaProcessorFilters");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building MediaProcessorFilters");
    }
    if (((ByteBuffer)localObject1).getInt() != -881796484)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building MediaProcessorFilters");
    }
    paramString = null;
    paramFissionTransaction = null;
    localObject2 = null;
    String str = null;
    boolean bool1;
    boolean bool2;
    label245:
    boolean bool3;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label346;
      }
      bool2 = true;
      if (bool2) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label352;
      }
      bool3 = true;
      label271:
      if (bool3) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label358;
      }
    }
    label346:
    label352:
    label358:
    for (boolean bool4 = true;; bool4 = false)
    {
      if (bool4) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool1) {
        break label364;
      }
      throw new IOException("Failed to find required field: contain when reading com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorFilters from fission.");
      bool1 = false;
      break;
      bool2 = false;
      break label245;
      bool3 = false;
      break label271;
    }
    label364:
    if (!bool2) {
      throw new IOException("Failed to find required field: cover when reading com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorFilters from fission.");
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: fill when reading com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorFilters from fission.");
    }
    if (!bool4) {
      throw new IOException("Failed to find required field: original when reading com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorFilters from fission.");
    }
    return new MediaProcessorFilters(paramString, paramFissionTransaction, (String)localObject2, str, bool1, bool2, bool3, bool4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorFiltersBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */