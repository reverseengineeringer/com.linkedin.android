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
import java.util.ArrayList;
import java.util.List;

public final class MediaProcessorConfigBuilder
  implements FissileDataModelBuilder<MediaProcessorConfig>, DataTemplateBuilder<MediaProcessorConfig>
{
  public static final MediaProcessorConfigBuilder INSTANCE = new MediaProcessorConfigBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("filters");
    JSON_KEY_STORE.put("sizes");
  }
  
  public static MediaProcessorConfig build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject = null;
    ArrayList localArrayList = null;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("filters", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = MediaProcessorFiltersBuilder.INSTANCE;
        localObject = MediaProcessorFiltersBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("sizes", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            MediaProcessorSizeBuilder localMediaProcessorSizeBuilder = MediaProcessorSizeBuilder.INSTANCE;
            localArrayList.add(MediaProcessorSizeBuilder.build(paramDataReader));
          }
        }
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: filters when building com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorConfig");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: sizes when building com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorConfig");
    }
    return new MediaProcessorConfig((MediaProcessorFilters)localObject, localArrayList, bool2, bool1);
  }
  
  public static MediaProcessorConfig readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building MediaProcessorConfig");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building MediaProcessorConfig");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building MediaProcessorConfig");
    }
    if (((ByteBuffer)localObject2).getInt() != 328909338)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building MediaProcessorConfig");
    }
    paramString = null;
    Object localObject3 = null;
    localObject1 = null;
    boolean bool2;
    boolean bool1;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = (String)localObject3;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localObject3 = MediaProcessorFiltersBuilder.INSTANCE;
          paramString = MediaProcessorFiltersBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label455;
          }
          bool1 = true;
        }
        label274:
        if (i == 1)
        {
          paramString = MediaProcessorFiltersBuilder.INSTANCE;
          paramString = MediaProcessorFiltersBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label461;
          }
          bool1 = true;
        }
      }
      label300:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label467;
      }
      bool2 = true;
      label312:
      if (!bool2) {
        break label485;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2);
      localObject3 = new ArrayList();
      label336:
      localObject1 = localObject3;
      if (j <= 0) {
        break label485;
      }
      localObject1 = null;
      i = 1;
      int k = ((ByteBuffer)localObject2).get();
      if (k == 0)
      {
        localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
        MediaProcessorSizeBuilder localMediaProcessorSizeBuilder = MediaProcessorSizeBuilder.INSTANCE;
        localObject1 = MediaProcessorSizeBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
        if (localObject1 == null) {
          break label473;
        }
        i = 1;
      }
      label396:
      if (k == 1)
      {
        localObject1 = MediaProcessorSizeBuilder.INSTANCE;
        localObject1 = MediaProcessorSizeBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
        if (localObject1 == null) {
          break label479;
        }
      }
    }
    label455:
    label461:
    label467:
    label473:
    label479:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject3).add(localObject1);
      }
      j -= 1;
      break label336;
      bool2 = false;
      break;
      bool1 = false;
      break label274;
      bool1 = false;
      break label300;
      bool2 = false;
      break label312;
      i = 0;
      break label396;
    }
    label485:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: filters when reading com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorConfig from fission.");
    }
    if (!bool2) {
      throw new IOException("Failed to find required field: sizes when reading com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorConfig from fission.");
    }
    return new MediaProcessorConfig(paramString, (List)localObject1, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorConfigBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */