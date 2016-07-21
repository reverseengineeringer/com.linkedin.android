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

public final class ImageBuilder
  implements FissileDataModelBuilder<Image>, DataTemplateBuilder<Image>
{
  public static final ImageBuilder INSTANCE = new ImageBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("com.linkedin.voyager.common.MediaProcessorImage");
    JSON_KEY_STORE.put("com.linkedin.voyager.common.MediaProxyImage");
    JSON_KEY_STORE.put("string");
  }
  
  public static Image build(DataReader paramDataReader)
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
      if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.common.MediaProcessorImage", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = MediaProcessorImageBuilder.INSTANCE;
        localObject2 = MediaProcessorImageBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.common.MediaProxyImage", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = MediaProxyImageBuilder.INSTANCE;
        localObject1 = MediaProxyImageBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("string", JSON_KEY_STORE))
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
    int i = 0;
    if (bool3) {
      i = 1;
    }
    int j = i;
    if (bool2)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building com.linkedin.android.pegasus.gen.voyager.common.Image");
      }
      j = 1;
    }
    if ((bool1) && (j != 0)) {
      throw new DataReaderException("Found more than 1 member when building com.linkedin.android.pegasus.gen.voyager.common.Image");
    }
    return new Image((MediaProcessorImage)localObject2, (MediaProxyImage)localObject1, str, bool3, bool2, bool1);
  }
  
  public static Image readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Image");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building Image");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building Image");
    }
    if (((ByteBuffer)localObject2).getInt() != -227258689)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building Image");
    }
    paramString = null;
    MediaProcessorImageBuilder localMediaProcessorImageBuilder = null;
    localObject1 = null;
    MediaProxyImageBuilder localMediaProxyImageBuilder = null;
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
        paramString = localMediaProcessorImageBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localMediaProcessorImageBuilder = MediaProcessorImageBuilder.INSTANCE;
          paramString = MediaProcessorImageBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label491;
          }
          bool1 = true;
        }
        label280:
        if (i == 1)
        {
          paramString = MediaProcessorImageBuilder.INSTANCE;
          paramString = MediaProcessorImageBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label497;
          }
          bool1 = true;
        }
      }
      label306:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label503;
      }
      bool3 = true;
      label318:
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject2).get();
        localObject1 = localMediaProxyImageBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localMediaProxyImageBuilder = MediaProxyImageBuilder.INSTANCE;
          localObject1 = MediaProxyImageBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label509;
          }
          bool2 = true;
        }
        label380:
        if (i == 1)
        {
          localObject1 = MediaProxyImageBuilder.INSTANCE;
          localObject1 = MediaProxyImageBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label515;
          }
          bool2 = true;
        }
      }
      label409:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label521;
      }
    }
    label491:
    label497:
    label503:
    label509:
    label515:
    label521:
    for (boolean bool3 = true;; bool3 = false)
    {
      paramFissionTransaction = (FissionTransaction)localObject3;
      if (bool3) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      i = 0;
      if (bool1) {
        i = 1;
      }
      j = i;
      if (!bool2) {
        break label530;
      }
      if (i == 0) {
        break label527;
      }
      throw new IOException("Found more than 1 member when reading com.linkedin.android.pegasus.gen.voyager.common.Image from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label280;
      bool1 = false;
      break label306;
      bool3 = false;
      break label318;
      bool2 = false;
      break label380;
      bool2 = false;
      break label409;
    }
    label527:
    int j = 1;
    label530:
    if ((bool3) && (j != 0)) {
      throw new IOException("Found more than 1 member when reading com.linkedin.android.pegasus.gen.voyager.common.Image from fission.");
    }
    return new Image(paramString, (MediaProxyImage)localObject1, paramFissionTransaction, bool1, bool2, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.ImageBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */