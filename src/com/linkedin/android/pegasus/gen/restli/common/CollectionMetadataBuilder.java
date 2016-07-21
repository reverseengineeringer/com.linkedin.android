package com.linkedin.android.pegasus.gen.restli.common;

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

public final class CollectionMetadataBuilder
  implements FissileDataModelBuilder<CollectionMetadata>, DataTemplateBuilder<CollectionMetadata>
{
  public static final CollectionMetadataBuilder INSTANCE = new CollectionMetadataBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("start");
    JSON_KEY_STORE.put("count");
    JSON_KEY_STORE.put("total");
    JSON_KEY_STORE.put("links");
  }
  
  public static CollectionMetadata build(DataReader paramDataReader)
    throws DataReaderException
  {
    int k = 0;
    int j = 0;
    int i = 0;
    ArrayList localArrayList = null;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("start", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        k = paramDataReader.readInt();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("count", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        j = paramDataReader.readInt();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("total", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("links", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            LinkBuilder localLinkBuilder = LinkBuilder.INSTANCE;
            localArrayList.add(LinkBuilder.build(paramDataReader));
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
      i = 0;
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: start when building com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: count when building com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: links when building com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata");
    }
    return new CollectionMetadata(k, j, i, localArrayList, bool4, bool3, bool2, bool1);
  }
  
  public static CollectionMetadata readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building CollectionMetadata");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building CollectionMetadata");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building CollectionMetadata");
    }
    if (((ByteBuffer)localObject1).getInt() != 277983044)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building CollectionMetadata");
    }
    int k = 0;
    int m = 0;
    int j = 0;
    paramString = null;
    boolean bool1;
    boolean bool2;
    label244:
    boolean bool3;
    label268:
    boolean bool4;
    label292:
    int n;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        k = ((ByteBuffer)localObject1).getInt();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label425;
      }
      bool2 = true;
      if (bool2) {
        m = ((ByteBuffer)localObject1).getInt();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label431;
      }
      bool3 = true;
      if (bool3) {
        j = ((ByteBuffer)localObject1).getInt();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label437;
      }
      bool4 = true;
      if (!bool4) {
        break label455;
      }
      n = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localObject2 = new ArrayList();
      label316:
      paramString = (String)localObject2;
      if (n <= 0) {
        break label455;
      }
      paramString = null;
      i = 1;
      int i1 = ((ByteBuffer)localObject1).get();
      if (i1 == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
        LinkBuilder localLinkBuilder = LinkBuilder.INSTANCE;
        paramString = LinkBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label443;
        }
        i = 1;
      }
      label370:
      if (i1 == 1)
      {
        paramString = LinkBuilder.INSTANCE;
        paramString = LinkBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
        if (paramString == null) {
          break label449;
        }
      }
    }
    label425:
    label431:
    label437:
    label443:
    label449:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject2).add(paramString);
      }
      n -= 1;
      break label316;
      bool1 = false;
      break;
      bool2 = false;
      break label244;
      bool3 = false;
      break label268;
      bool4 = false;
      break label292;
      i = 0;
      break label370;
    }
    label455:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
    }
    if (!bool3) {
      j = 0;
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: start when reading com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata from fission.");
    }
    if (!bool2) {
      throw new IOException("Failed to find required field: count when reading com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata from fission.");
    }
    if (!bool4) {
      throw new IOException("Failed to find required field: links when reading com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata from fission.");
    }
    return new CollectionMetadata(k, m, j, paramString, bool1, bool2, bool3, bool4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.restli.common.CollectionMetadataBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */