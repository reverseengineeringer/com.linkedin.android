package com.linkedin.android.pegasus.gen.videocontent;

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

public final class ProgressiveDownloadMetadataBuilder
  implements FissileDataModelBuilder<ProgressiveDownloadMetadata>, DataTemplateBuilder<ProgressiveDownloadMetadata>
{
  public static final ProgressiveDownloadMetadataBuilder INSTANCE = new ProgressiveDownloadMetadataBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("width");
    JSON_KEY_STORE.put("height");
    JSON_KEY_STORE.put("streamingLocations");
    JSON_KEY_STORE.put("size");
    JSON_KEY_STORE.put("bitRate");
    JSON_KEY_STORE.put("thumbnail");
  }
  
  public static ProgressiveDownloadMetadata build(DataReader paramDataReader)
    throws DataReaderException
  {
    int k = 0;
    int j = 0;
    ArrayList localArrayList = null;
    long l = 0L;
    int i = 0;
    Object localObject = null;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("width", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        k = paramDataReader.readInt();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("height", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        j = paramDataReader.readInt();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("streamingLocations", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            StreamingLocationBuilder localStreamingLocationBuilder = StreamingLocationBuilder.INSTANCE;
            localArrayList.add(StreamingLocationBuilder.build(paramDataReader));
          }
        }
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("size", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("bitRate", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("thumbnail", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = ThumbnailBuilder.INSTANCE;
        localObject = ThumbnailBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: width when building com.linkedin.android.pegasus.gen.videocontent.ProgressiveDownloadMetadata");
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: height when building com.linkedin.android.pegasus.gen.videocontent.ProgressiveDownloadMetadata");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: streamingLocations when building com.linkedin.android.pegasus.gen.videocontent.ProgressiveDownloadMetadata");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: size when building com.linkedin.android.pegasus.gen.videocontent.ProgressiveDownloadMetadata");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: bitRate when building com.linkedin.android.pegasus.gen.videocontent.ProgressiveDownloadMetadata");
    }
    return new ProgressiveDownloadMetadata(k, j, localArrayList, l, i, (Thumbnail)localObject, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static ProgressiveDownloadMetadata readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building ProgressiveDownloadMetadata");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building ProgressiveDownloadMetadata");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building ProgressiveDownloadMetadata");
    }
    if (((ByteBuffer)localObject1).getInt() != 1078079280)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building ProgressiveDownloadMetadata");
    }
    int j = 0;
    int k = 0;
    localObject2 = null;
    long l = 0L;
    int n = 0;
    Object localObject3 = null;
    ThumbnailBuilder localThumbnailBuilder = null;
    boolean bool3;
    boolean bool4;
    label254:
    boolean bool5;
    label278:
    int m;
    ArrayList localArrayList;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool3 = true;
      if (bool3) {
        j = ((ByteBuffer)localObject1).getInt();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label412;
      }
      bool4 = true;
      if (bool4) {
        k = ((ByteBuffer)localObject1).getInt();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label418;
      }
      bool5 = true;
      if (!bool5) {
        break label436;
      }
      m = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localArrayList = new ArrayList();
      label302:
      localObject2 = localArrayList;
      if (m <= 0) {
        break label436;
      }
      paramString = null;
      i = 1;
      int i1 = ((ByteBuffer)localObject1).get();
      if (i1 == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
        localObject2 = StreamingLocationBuilder.INSTANCE;
        paramString = StreamingLocationBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label424;
        }
        i = 1;
      }
      label357:
      if (i1 == 1)
      {
        paramString = StreamingLocationBuilder.INSTANCE;
        paramString = StreamingLocationBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
        if (paramString == null) {
          break label430;
        }
      }
    }
    label412:
    label418:
    label424:
    label430:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      m -= 1;
      break label302;
      bool3 = false;
      break;
      bool4 = false;
      break label254;
      bool5 = false;
      break label278;
      i = 0;
      break label357;
    }
    label436:
    boolean bool6;
    boolean bool7;
    label472:
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool6 = true;
      if (bool6) {
        l = ((ByteBuffer)localObject1).getLong();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label619;
      }
      bool7 = true;
      i = n;
      if (bool7) {
        i = ((ByteBuffer)localObject1).getInt();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label625;
      }
      bool1 = true;
      label500:
      paramString = (String)localObject3;
      bool2 = bool1;
      if (bool1)
      {
        m = ((ByteBuffer)localObject1).get();
        paramString = localThumbnailBuilder;
        if (m == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localThumbnailBuilder = ThumbnailBuilder.INSTANCE;
          paramString = ThumbnailBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label631;
          }
          bool1 = true;
        }
        label556:
        bool2 = bool1;
        if (m == 1)
        {
          paramString = ThumbnailBuilder.INSTANCE;
          paramString = ThumbnailBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label637;
          }
        }
      }
    }
    label619:
    label625:
    label631:
    label637:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool3) {
        break label643;
      }
      throw new IOException("Failed to find required field: width when reading com.linkedin.android.pegasus.gen.videocontent.ProgressiveDownloadMetadata from fission.");
      bool6 = false;
      break;
      bool7 = false;
      break label472;
      bool1 = false;
      break label500;
      bool1 = false;
      break label556;
    }
    label643:
    if (!bool4) {
      throw new IOException("Failed to find required field: height when reading com.linkedin.android.pegasus.gen.videocontent.ProgressiveDownloadMetadata from fission.");
    }
    if (!bool5) {
      throw new IOException("Failed to find required field: streamingLocations when reading com.linkedin.android.pegasus.gen.videocontent.ProgressiveDownloadMetadata from fission.");
    }
    if (!bool6) {
      throw new IOException("Failed to find required field: size when reading com.linkedin.android.pegasus.gen.videocontent.ProgressiveDownloadMetadata from fission.");
    }
    if (!bool7) {
      throw new IOException("Failed to find required field: bitRate when reading com.linkedin.android.pegasus.gen.videocontent.ProgressiveDownloadMetadata from fission.");
    }
    return new ProgressiveDownloadMetadata(j, k, (List)localObject2, l, i, paramString, bool3, bool4, bool5, bool6, bool7, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.videocontent.ProgressiveDownloadMetadataBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */