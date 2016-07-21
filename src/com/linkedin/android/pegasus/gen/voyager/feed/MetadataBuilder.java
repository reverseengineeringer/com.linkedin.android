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

public final class MetadataBuilder
  implements FissileDataModelBuilder<Metadata>, DataTemplateBuilder<Metadata>
{
  public static final MetadataBuilder INSTANCE = new MetadataBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("id");
    JSON_KEY_STORE.put("type");
    JSON_KEY_STORE.put("queryAfterTime");
    JSON_KEY_STORE.put("paginationToken");
    JSON_KEY_STORE.put("sort");
    JSON_KEY_STORE.put("newRelevanceFeed");
  }
  
  public static Metadata build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str3 = null;
    String str2 = null;
    long l = 0L;
    String str1 = null;
    SortOrder localSortOrder = null;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("id", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("type", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("queryAfterTime", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("paginationToken", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("sort", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localSortOrder = (SortOrder)paramDataReader.readEnum(SortOrder.Builder.INSTANCE);
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("newRelevanceFeed", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool7 = paramDataReader.readBoolean();
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    return new Metadata(str3, str2, l, str1, localSortOrder, bool7, bool6, bool5, bool4, bool3, bool1, bool2);
  }
  
  public static Metadata readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Metadata");
    }
    Object localObject2 = paramByteBuffer;
    if (paramString != null)
    {
      paramString = paramFissionAdapter.readFromCache(paramString, paramFissionTransaction);
      if (paramString == null) {
        return null;
      }
      int i = paramString.get();
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
      throw new IOException("Invalid header prefix. Can't read cached data when building Metadata");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building Metadata");
    }
    if (((ByteBuffer)localObject1).getInt() != -653134427)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building Metadata");
    }
    paramString = null;
    paramFissionTransaction = null;
    long l = 0L;
    localObject2 = null;
    SortOrder localSortOrder = null;
    boolean bool1 = false;
    boolean bool2;
    boolean bool3;
    label251:
    boolean bool4;
    label277:
    boolean bool5;
    label301:
    boolean bool6;
    label328:
    boolean bool7;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool2 = true;
      if (bool2) {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label423;
      }
      bool3 = true;
      if (bool3) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label429;
      }
      bool4 = true;
      if (bool4) {
        l = ((ByteBuffer)localObject1).getLong();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label435;
      }
      bool5 = true;
      if (bool5) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label441;
      }
      bool6 = true;
      if (bool6) {
        localSortOrder = SortOrder.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1));
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label447;
      }
      bool7 = true;
      label358:
      if (bool7) {
        if (((ByteBuffer)localObject1).get() != 1) {
          break label453;
        }
      }
    }
    label423:
    label429:
    label435:
    label441:
    label447:
    label453:
    for (bool1 = true;; bool1 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      return new Metadata(paramString, paramFissionTransaction, l, (String)localObject2, localSortOrder, bool1, bool2, bool3, bool4, bool5, bool6, bool7);
      bool2 = false;
      break;
      bool3 = false;
      break label251;
      bool4 = false;
      break label277;
      bool5 = false;
      break label301;
      bool6 = false;
      break label328;
      bool7 = false;
      break label358;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.MetadataBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */