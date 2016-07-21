package com.linkedin.android.pegasus.gen.voyager.search;

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

public final class DiscussionActivityInfoBuilder
  implements FissileDataModelBuilder<DiscussionActivityInfo>, DataTemplateBuilder<DiscussionActivityInfo>
{
  public static final DiscussionActivityInfoBuilder INSTANCE = new DiscussionActivityInfoBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("numDiscussions");
    JSON_KEY_STORE.put("period");
    JSON_KEY_STORE.put("displayText");
  }
  
  public static DiscussionActivityInfo build(DataReader paramDataReader)
    throws DataReaderException
  {
    int i = 0;
    DiscussionActivityPeriod localDiscussionActivityPeriod = null;
    String str = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("numDiscussions", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("period", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localDiscussionActivityPeriod = (DiscussionActivityPeriod)paramDataReader.readEnum(DiscussionActivityPeriod.Builder.INSTANCE);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("displayText", JSON_KEY_STORE))
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
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: numDiscussions when building com.linkedin.android.pegasus.gen.voyager.search.DiscussionActivityInfo");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: period when building com.linkedin.android.pegasus.gen.voyager.search.DiscussionActivityInfo");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: displayText when building com.linkedin.android.pegasus.gen.voyager.search.DiscussionActivityInfo");
    }
    return new DiscussionActivityInfo(i, localDiscussionActivityPeriod, str, bool3, bool2, bool1);
  }
  
  public static DiscussionActivityInfo readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    boolean bool3 = true;
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building DiscussionActivityInfo");
    }
    ByteBuffer localByteBuffer = paramByteBuffer;
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
          localObject = paramString;
          if (i != 0) {
            break label170;
          }
          localObject = paramFissionAdapter.readString(paramString);
          paramFissionAdapter.recycle(paramString);
          localObject = paramFissionAdapter.readFromCache((String)localObject, paramFissionTransaction);
          if (localObject == null) {
            break;
          }
          j = ((ByteBuffer)localObject).get();
          paramString = (String)localObject;
          i = j;
        } while (j == 1);
        paramString = (String)localObject;
        i = j;
      } while (j == 0);
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("Invalid header prefix. Can't read cached data when building DiscussionActivityInfo");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building DiscussionActivityInfo");
    }
    label170:
    if (((ByteBuffer)localObject).getInt() != 1240283842)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building DiscussionActivityInfo");
    }
    int i = 0;
    paramString = null;
    paramFissionTransaction = null;
    boolean bool1;
    boolean bool2;
    if (((ByteBuffer)localObject).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        i = ((ByteBuffer)localObject).getInt();
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label314;
      }
      bool2 = true;
      label241:
      if (bool2) {
        paramString = DiscussionActivityPeriod.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject));
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label320;
      }
    }
    for (;;)
    {
      if (bool3) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      if (bool1) {
        break label326;
      }
      throw new IOException("Failed to find required field: numDiscussions when reading com.linkedin.android.pegasus.gen.voyager.search.DiscussionActivityInfo from fission.");
      bool1 = false;
      break;
      label314:
      bool2 = false;
      break label241;
      label320:
      bool3 = false;
    }
    label326:
    if (!bool2) {
      throw new IOException("Failed to find required field: period when reading com.linkedin.android.pegasus.gen.voyager.search.DiscussionActivityInfo from fission.");
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: displayText when reading com.linkedin.android.pegasus.gen.voyager.search.DiscussionActivityInfo from fission.");
    }
    return new DiscussionActivityInfo(i, paramString, paramFissionTransaction, bool1, bool2, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.DiscussionActivityInfoBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */