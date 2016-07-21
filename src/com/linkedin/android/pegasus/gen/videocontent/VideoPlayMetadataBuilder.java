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

public final class VideoPlayMetadataBuilder
  implements FissileDataModelBuilder<VideoPlayMetadata>, DataTemplateBuilder<VideoPlayMetadata>
{
  public static final VideoPlayMetadataBuilder INSTANCE = new VideoPlayMetadataBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("media");
    JSON_KEY_STORE.put("trackingId");
    JSON_KEY_STORE.put("duration");
    JSON_KEY_STORE.put("progressiveStreams");
  }
  
  public static VideoPlayMetadata build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str2 = null;
    String str1 = null;
    long l = 0L;
    ArrayList localArrayList = null;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("media", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("trackingId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("duration", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("progressiveStreams", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            ProgressiveDownloadMetadataBuilder localProgressiveDownloadMetadataBuilder = ProgressiveDownloadMetadataBuilder.INSTANCE;
            localArrayList.add(ProgressiveDownloadMetadataBuilder.build(paramDataReader));
          }
        }
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: media when building com.linkedin.android.pegasus.gen.videocontent.VideoPlayMetadata");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: trackingId when building com.linkedin.android.pegasus.gen.videocontent.VideoPlayMetadata");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: progressiveStreams when building com.linkedin.android.pegasus.gen.videocontent.VideoPlayMetadata");
    }
    return new VideoPlayMetadata(str2, str1, l, localArrayList, bool4, bool3, bool2, bool1);
  }
  
  public static VideoPlayMetadata readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building VideoPlayMetadata");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building VideoPlayMetadata");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building VideoPlayMetadata");
    }
    if (((ByteBuffer)localObject1).getInt() != 52369227)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building VideoPlayMetadata");
    }
    localObject2 = null;
    String str = null;
    long l = 0L;
    paramString = null;
    boolean bool1;
    boolean bool2;
    label247:
    boolean bool3;
    label274:
    boolean bool4;
    label298:
    ArrayList localArrayList;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label431;
      }
      bool2 = true;
      if (bool2) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label437;
      }
      bool3 = true;
      if (bool3) {
        l = ((ByteBuffer)localObject1).getLong();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label443;
      }
      bool4 = true;
      if (!bool4) {
        break label461;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localArrayList = new ArrayList();
      label322:
      paramString = localArrayList;
      if (j <= 0) {
        break label461;
      }
      paramString = null;
      i = 1;
      int k = ((ByteBuffer)localObject1).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
        ProgressiveDownloadMetadataBuilder localProgressiveDownloadMetadataBuilder = ProgressiveDownloadMetadataBuilder.INSTANCE;
        paramString = ProgressiveDownloadMetadataBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label449;
        }
        i = 1;
      }
      label376:
      if (k == 1)
      {
        paramString = ProgressiveDownloadMetadataBuilder.INSTANCE;
        paramString = ProgressiveDownloadMetadataBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
        if (paramString == null) {
          break label455;
        }
      }
    }
    label431:
    label437:
    label443:
    label449:
    label455:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      j -= 1;
      break label322;
      bool1 = false;
      break;
      bool2 = false;
      break label247;
      bool3 = false;
      break label274;
      bool4 = false;
      break label298;
      i = 0;
      break label376;
    }
    label461:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: media when reading com.linkedin.android.pegasus.gen.videocontent.VideoPlayMetadata from fission.");
    }
    if (!bool2) {
      throw new IOException("Failed to find required field: trackingId when reading com.linkedin.android.pegasus.gen.videocontent.VideoPlayMetadata from fission.");
    }
    if (!bool4) {
      throw new IOException("Failed to find required field: progressiveStreams when reading com.linkedin.android.pegasus.gen.videocontent.VideoPlayMetadata from fission.");
    }
    return new VideoPlayMetadata((String)localObject2, str, l, paramString, bool1, bool2, bool3, bool4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.videocontent.VideoPlayMetadataBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */