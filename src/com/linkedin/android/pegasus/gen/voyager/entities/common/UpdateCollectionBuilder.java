package com.linkedin.android.pegasus.gen.voyager.entities.common;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.feed.Metadata;
import com.linkedin.android.pegasus.gen.voyager.feed.MetadataBuilder;
import com.linkedin.android.pegasus.gen.voyager.feed.UpdateBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class UpdateCollectionBuilder
  implements FissileDataModelBuilder<UpdateCollection>, DataTemplateBuilder<UpdateCollection>
{
  public static final UpdateCollectionBuilder INSTANCE = new UpdateCollectionBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("items");
    JSON_KEY_STORE.put("pagingInfo");
    JSON_KEY_STORE.put("metadata");
  }
  
  public static UpdateCollection build(DataReader paramDataReader)
    throws DataReaderException
  {
    ArrayList localArrayList = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("items", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            UpdateBuilder localUpdateBuilder = UpdateBuilder.INSTANCE;
            localArrayList.add(UpdateBuilder.build(paramDataReader));
          }
        }
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("pagingInfo", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = PagingInfoBuilder.INSTANCE;
        localObject2 = PagingInfoBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("metadata", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = MetadataBuilder.INSTANCE;
        localObject1 = MetadataBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: items when building com.linkedin.android.pegasus.gen.voyager.entities.common.UpdateCollection");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: pagingInfo when building com.linkedin.android.pegasus.gen.voyager.entities.common.UpdateCollection");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: metadata when building com.linkedin.android.pegasus.gen.voyager.entities.common.UpdateCollection");
    }
    return new UpdateCollection(localArrayList, (PagingInfo)localObject2, (Metadata)localObject1, bool3, bool2, bool1);
  }
  
  public static UpdateCollection readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building UpdateCollection");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building UpdateCollection");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building UpdateCollection");
    }
    if (((ByteBuffer)localObject2).getInt() != 1273179523)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building UpdateCollection");
    }
    Object localObject3 = null;
    Object localObject4 = null;
    PagingInfoBuilder localPagingInfoBuilder = null;
    localObject1 = null;
    MetadataBuilder localMetadataBuilder = null;
    boolean bool4;
    ArrayList localArrayList;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool4 = true;
      if (!bool4) {
        break label370;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2);
      localArrayList = new ArrayList();
      label248:
      localObject3 = localArrayList;
      if (j <= 0) {
        break label370;
      }
      paramString = null;
      i = 1;
      int k = ((ByteBuffer)localObject2).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
        localObject3 = UpdateBuilder.INSTANCE;
        paramString = UpdateBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label358;
        }
        i = 1;
      }
      label303:
      if (k == 1)
      {
        paramString = UpdateBuilder.INSTANCE;
        paramString = UpdateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
        if (paramString == null) {
          break label364;
        }
      }
    }
    label358:
    label364:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      j -= 1;
      break label248;
      bool4 = false;
      break;
      i = 0;
      break label303;
    }
    label370:
    boolean bool2;
    boolean bool1;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool2 = true;
      paramString = (String)localObject4;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = localPagingInfoBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localPagingInfoBuilder = PagingInfoBuilder.INSTANCE;
          paramString = PagingInfoBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label604;
          }
          bool1 = true;
        }
        label442:
        if (i == 1)
        {
          paramString = PagingInfoBuilder.INSTANCE;
          paramString = PagingInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label610;
          }
          bool1 = true;
        }
      }
      label468:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label616;
      }
      bool2 = true;
      label480:
      bool3 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        localObject1 = localMetadataBuilder;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localMetadataBuilder = MetadataBuilder.INSTANCE;
          localObject1 = MetadataBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label622;
          }
          bool2 = true;
        }
        label538:
        bool3 = bool2;
        if (i == 1)
        {
          localObject1 = MetadataBuilder.INSTANCE;
          localObject1 = MetadataBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label628;
          }
        }
      }
    }
    label604:
    label610:
    label616:
    label622:
    label628:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (bool4) {
        break label634;
      }
      throw new IOException("Failed to find required field: items when reading com.linkedin.android.pegasus.gen.voyager.entities.common.UpdateCollection from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label442;
      bool1 = false;
      break label468;
      bool2 = false;
      break label480;
      bool2 = false;
      break label538;
    }
    label634:
    if (!bool1) {
      throw new IOException("Failed to find required field: pagingInfo when reading com.linkedin.android.pegasus.gen.voyager.entities.common.UpdateCollection from fission.");
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: metadata when reading com.linkedin.android.pegasus.gen.voyager.entities.common.UpdateCollection from fission.");
    }
    return new UpdateCollection((List)localObject3, paramString, (Metadata)localObject1, bool4, bool1, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.common.UpdateCollectionBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */