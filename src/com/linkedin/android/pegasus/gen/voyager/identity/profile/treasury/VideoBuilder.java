package com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.common.MediaProxyImageBuilder;
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

public final class VideoBuilder
  implements FissileDataModelBuilder<Video>, DataTemplateBuilder<Video>
{
  public static final VideoBuilder INSTANCE = new VideoBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("html");
    JSON_KEY_STORE.put("width");
    JSON_KEY_STORE.put("height");
    JSON_KEY_STORE.put("duration");
    JSON_KEY_STORE.put("url");
    JSON_KEY_STORE.put("previewImages");
  }
  
  public static Video build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str3 = null;
    int j = 0;
    int i = 0;
    String str2 = null;
    String str1 = null;
    Object localObject = null;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("html", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("width", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        j = paramDataReader.readInt();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("height", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("duration", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("url", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("previewImages", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            MediaProxyImageBuilder localMediaProxyImageBuilder = MediaProxyImageBuilder.INSTANCE;
            ((List)localObject).add(MediaProxyImageBuilder.build(paramDataReader));
          }
        }
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool1) {
      localObject = Collections.emptyList();
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: html when building com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.Video");
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: width when building com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.Video");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: height when building com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.Video");
    }
    return new Video(str3, j, i, str2, str1, (List)localObject, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static Video readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Video");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building Video");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building Video");
    }
    if (((ByteBuffer)localObject1).getInt() != 1530302730)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building Video");
    }
    localObject2 = null;
    int j = 0;
    int k = 0;
    String str1 = null;
    String str2 = null;
    paramString = null;
    boolean bool1;
    boolean bool2;
    label253:
    boolean bool3;
    label277:
    boolean bool4;
    label301:
    boolean bool5;
    label328:
    boolean bool6;
    label355:
    int m;
    ArrayList localArrayList;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label488;
      }
      bool2 = true;
      if (bool2) {
        j = ((ByteBuffer)localObject1).getInt();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label494;
      }
      bool3 = true;
      if (bool3) {
        k = ((ByteBuffer)localObject1).getInt();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label500;
      }
      bool4 = true;
      if (bool4) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label506;
      }
      bool5 = true;
      if (bool5) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label512;
      }
      bool6 = true;
      if (!bool6) {
        break label530;
      }
      m = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localArrayList = new ArrayList();
      label379:
      paramString = localArrayList;
      if (m <= 0) {
        break label530;
      }
      paramString = null;
      i = 1;
      int n = ((ByteBuffer)localObject1).get();
      if (n == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
        MediaProxyImageBuilder localMediaProxyImageBuilder = MediaProxyImageBuilder.INSTANCE;
        paramString = MediaProxyImageBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label518;
        }
        i = 1;
      }
      label433:
      if (n == 1)
      {
        paramString = MediaProxyImageBuilder.INSTANCE;
        paramString = MediaProxyImageBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
        if (paramString == null) {
          break label524;
        }
      }
    }
    label488:
    label494:
    label500:
    label506:
    label512:
    label518:
    label524:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      m -= 1;
      break label379;
      bool1 = false;
      break;
      bool2 = false;
      break label253;
      bool3 = false;
      break label277;
      bool4 = false;
      break label301;
      bool5 = false;
      break label328;
      bool6 = false;
      break label355;
      i = 0;
      break label433;
    }
    label530:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
    }
    if (!bool6) {
      paramString = Collections.emptyList();
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: html when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.Video from fission.");
    }
    if (!bool2) {
      throw new IOException("Failed to find required field: width when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.Video from fission.");
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: height when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.Video from fission.");
    }
    return new Video((String)localObject2, j, k, str1, str2, paramString, bool1, bool2, bool3, bool4, bool5, bool6);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.VideoBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */