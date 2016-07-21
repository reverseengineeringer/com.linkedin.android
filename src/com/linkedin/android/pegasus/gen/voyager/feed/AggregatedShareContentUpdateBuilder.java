package com.linkedin.android.pegasus.gen.voyager.feed;

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
import java.util.Collections;
import java.util.List;

public final class AggregatedShareContentUpdateBuilder
  implements FissileDataModelBuilder<AggregatedShareContentUpdate>, DataTemplateBuilder<AggregatedShareContentUpdate>
{
  public static final AggregatedShareContentUpdateBuilder INSTANCE = new AggregatedShareContentUpdateBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("content");
    JSON_KEY_STORE.put("actions");
    JSON_KEY_STORE.put("rollup");
  }
  
  public static AggregatedShareContentUpdate build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject2 = null;
    Object localObject1 = null;
    ArrayList localArrayList = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("content", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = ShareUpdateContentBuilder.ContentBuilder.INSTANCE;
        localObject2 = ShareUpdateContentBuilder.ContentBuilder.build(paramDataReader);
        bool3 = true;
      }
      else
      {
        Object localObject3;
        if (paramDataReader.shouldReadField$11ca93e7("actions", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              localObject3 = UpdateActionBuilder.INSTANCE;
              ((List)localObject1).add(UpdateActionBuilder.build(paramDataReader));
            }
          }
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("rollup", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localArrayList = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              localObject3 = UpdateBuilder.INSTANCE;
              localArrayList.add(UpdateBuilder.build(paramDataReader));
            }
          }
          bool1 = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
    }
    if (!bool2) {
      localObject1 = Collections.emptyList();
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: content when building com.linkedin.android.pegasus.gen.voyager.feed.AggregatedShareContentUpdate");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: rollup when building com.linkedin.android.pegasus.gen.voyager.feed.AggregatedShareContentUpdate");
    }
    return new AggregatedShareContentUpdate((ShareUpdateContent.Content)localObject2, (List)localObject1, localArrayList, bool3, bool2, bool1);
  }
  
  public static AggregatedShareContentUpdate readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building AggregatedShareContentUpdate");
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
          localObject3 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building AggregatedShareContentUpdate");
    }
    Object localObject3 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building AggregatedShareContentUpdate");
    }
    if (((ByteBuffer)localObject3).getInt() != 718253746)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject3);
      throw new IOException("UID mismatch. Can't read cached data when building AggregatedShareContentUpdate");
    }
    paramString = null;
    Object localObject4 = null;
    localObject1 = null;
    Object localObject2 = null;
    boolean bool2;
    boolean bool1;
    label277:
    label303:
    label315:
    label339:
    int k;
    Object localObject5;
    if (((ByteBuffer)localObject3).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject3).get();
        paramString = (String)localObject4;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localObject4 = ShareUpdateContentBuilder.ContentBuilder.INSTANCE;
          paramString = ShareUpdateContentBuilder.ContentBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label458;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = ShareUpdateContentBuilder.ContentBuilder.INSTANCE;
          paramString = ShareUpdateContentBuilder.ContentBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (paramString == null) {
            break label464;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label470;
      }
      bool2 = true;
      if (!bool2) {
        break label488;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject3);
      localObject4 = new ArrayList();
      localObject1 = localObject4;
      if (j <= 0) {
        break label488;
      }
      localObject1 = null;
      i = 1;
      k = ((ByteBuffer)localObject3).get();
      if (k == 0)
      {
        localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject3);
        localObject5 = UpdateActionBuilder.INSTANCE;
        localObject1 = UpdateActionBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
        if (localObject1 == null) {
          break label476;
        }
        i = 1;
      }
      label399:
      if (k == 1)
      {
        localObject1 = UpdateActionBuilder.INSTANCE;
        localObject1 = UpdateActionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
        if (localObject1 == null) {
          break label482;
        }
      }
    }
    label458:
    label464:
    label470:
    label476:
    label482:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject4).add(localObject1);
      }
      j -= 1;
      break label339;
      bool2 = false;
      break;
      bool1 = false;
      break label277;
      bool1 = false;
      break label303;
      bool2 = false;
      break label315;
      i = 0;
      break label399;
    }
    label488:
    boolean bool3;
    if (((ByteBuffer)localObject3).get() == 1)
    {
      bool3 = true;
      if (!bool3) {
        break label655;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject3);
      localObject4 = new ArrayList();
      label524:
      localObject2 = localObject4;
      if (j <= 0) {
        break label655;
      }
      localObject2 = null;
      i = 1;
      k = ((ByteBuffer)localObject3).get();
      if (k == 0)
      {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject3);
        localObject5 = UpdateBuilder.INSTANCE;
        localObject2 = UpdateBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
        if (localObject2 == null) {
          break label643;
        }
        i = 1;
      }
      label584:
      if (k == 1)
      {
        localObject2 = UpdateBuilder.INSTANCE;
        localObject2 = UpdateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
        if (localObject2 == null) {
          break label649;
        }
      }
    }
    label643:
    label649:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject4).add(localObject2);
      }
      j -= 1;
      break label524;
      bool3 = false;
      break;
      i = 0;
      break label584;
    }
    label655:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject3);
    }
    if (!bool2) {
      localObject1 = Collections.emptyList();
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: content when reading com.linkedin.android.pegasus.gen.voyager.feed.AggregatedShareContentUpdate from fission.");
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: rollup when reading com.linkedin.android.pegasus.gen.voyager.feed.AggregatedShareContentUpdate from fission.");
    }
    return new AggregatedShareContentUpdate(paramString, (List)localObject1, (List)localObject2, bool1, bool2, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.AggregatedShareContentUpdateBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */