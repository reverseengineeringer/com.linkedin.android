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

public final class MediaProcessorSizeBuilder
  implements FissileDataModelBuilder<MediaProcessorSize>, DataTemplateBuilder<MediaProcessorSize>
{
  public static final MediaProcessorSizeBuilder INSTANCE = new MediaProcessorSizeBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("width");
    JSON_KEY_STORE.put("height");
  }
  
  public static MediaProcessorSize build(DataReader paramDataReader)
    throws DataReaderException
  {
    int i = 0;
    int j = 0;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("width", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("height", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        j = paramDataReader.readInt();
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: width when building com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorSize");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: height when building com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorSize");
    }
    return new MediaProcessorSize(i, j, bool1, bool2);
  }
  
  public static MediaProcessorSize readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    boolean bool2 = true;
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building MediaProcessorSize");
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
          localObject2 = paramString;
          if (i != 0) {
            break label170;
          }
          localObject1 = paramFissionAdapter.readString(paramString);
          paramFissionAdapter.recycle(paramString);
          localObject1 = paramFissionAdapter.readFromCache((String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break;
          }
          j = ((ByteBuffer)localObject1).get();
          paramString = (String)localObject1;
          i = j;
        } while (j == 1);
        paramString = (String)localObject1;
        i = j;
      } while (j == 0);
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building MediaProcessorSize");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building MediaProcessorSize");
    }
    label170:
    if (((ByteBuffer)localObject2).getInt() != 1467209000)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building MediaProcessorSize");
    }
    int i = 0;
    int j = 0;
    boolean bool1;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        i = ((ByteBuffer)localObject2).getInt();
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label282;
      }
    }
    for (;;)
    {
      if (bool2) {
        j = ((ByteBuffer)localObject2).getInt();
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (bool1) {
        break label288;
      }
      throw new IOException("Failed to find required field: width when reading com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorSize from fission.");
      bool1 = false;
      break;
      label282:
      bool2 = false;
    }
    label288:
    if (!bool2) {
      throw new IOException("Failed to find required field: height when reading com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorSize from fission.");
    }
    return new MediaProcessorSize(i, j, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorSizeBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */