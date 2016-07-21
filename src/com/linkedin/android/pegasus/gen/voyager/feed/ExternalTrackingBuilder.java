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
import java.util.List;

public final class ExternalTrackingBuilder
  implements FissileDataModelBuilder<ExternalTracking>, DataTemplateBuilder<ExternalTracking>
{
  public static final ExternalTrackingBuilder INSTANCE = new ExternalTrackingBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("impressionUrls");
    JSON_KEY_STORE.put("clickUrls");
  }
  
  public static ExternalTracking build(DataReader paramDataReader)
    throws DataReaderException
  {
    ArrayList localArrayList1 = null;
    ArrayList localArrayList2 = null;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299())
    {
      String str;
      if (paramDataReader.shouldReadField$11ca93e7("impressionUrls", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList1 = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            str = paramDataReader.readString();
            if (str != null) {
              localArrayList1.add(str);
            }
          }
        }
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("clickUrls", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList2 = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            str = paramDataReader.readString();
            if (str != null) {
              localArrayList2.add(str);
            }
          }
        }
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: impressionUrls when building com.linkedin.android.pegasus.gen.voyager.feed.ExternalTracking");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: clickUrls when building com.linkedin.android.pegasus.gen.voyager.feed.ExternalTracking");
    }
    return new ExternalTracking(localArrayList1, localArrayList2, bool1, bool2);
  }
  
  public static ExternalTracking readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building ExternalTracking");
    }
    Object localObject2 = paramByteBuffer;
    int i;
    if (paramString != null)
    {
      paramString = paramFissionAdapter.readFromCache(paramString, paramFissionTransaction);
      if (paramString == null) {
        return null;
      }
      i = paramString.get();
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
      throw new IOException("Invalid header prefix. Can't read cached data when building ExternalTracking");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building ExternalTracking");
    }
    if (((ByteBuffer)localObject1).getInt() != 659231976)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building ExternalTracking");
    }
    paramString = null;
    paramFissionTransaction = null;
    if (((ByteBuffer)localObject1).get() == 1) {}
    for (boolean bool1 = true; bool1; bool1 = false)
    {
      i = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localObject2 = new ArrayList();
      for (;;)
      {
        paramString = (String)localObject2;
        if (i <= 0) {
          break;
        }
        ((List)localObject2).add(paramFissionAdapter.readString((ByteBuffer)localObject1));
        i -= 1;
      }
    }
    if (((ByteBuffer)localObject1).get() == 1) {}
    for (boolean bool2 = true; bool2; bool2 = false)
    {
      i = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localObject2 = new ArrayList();
      for (;;)
      {
        paramFissionTransaction = (FissionTransaction)localObject2;
        if (i <= 0) {
          break;
        }
        ((List)localObject2).add(paramFissionAdapter.readString((ByteBuffer)localObject1));
        i -= 1;
      }
    }
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: impressionUrls when reading com.linkedin.android.pegasus.gen.voyager.feed.ExternalTracking from fission.");
    }
    if (!bool2) {
      throw new IOException("Failed to find required field: clickUrls when reading com.linkedin.android.pegasus.gen.voyager.feed.ExternalTracking from fission.");
    }
    return new ExternalTracking(paramString, paramFissionTransaction, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.ExternalTrackingBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */