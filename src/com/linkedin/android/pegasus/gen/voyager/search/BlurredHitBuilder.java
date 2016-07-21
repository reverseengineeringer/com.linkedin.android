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

public final class BlurredHitBuilder
  implements FissileDataModelBuilder<BlurredHit>, DataTemplateBuilder<BlurredHit>
{
  public static final BlurredHitBuilder INSTANCE = new BlurredHitBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("searchVertical");
  }
  
  public static BlurredHit build(DataReader paramDataReader)
    throws DataReaderException
  {
    SearchType localSearchType = null;
    boolean bool = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("searchVertical", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localSearchType = (SearchType)paramDataReader.readEnum(SearchType.Builder.INSTANCE);
        bool = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool) {
      throw new DataReaderException("Failed to find required field: searchVertical when building com.linkedin.android.pegasus.gen.voyager.search.BlurredHit");
    }
    return new BlurredHit(localSearchType, bool);
  }
  
  public static BlurredHit readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    boolean bool = true;
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building BlurredHit");
    }
    ByteBuffer localByteBuffer = paramByteBuffer;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building BlurredHit");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building BlurredHit");
    }
    label170:
    if (((ByteBuffer)localObject).getInt() != -1872600816)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building BlurredHit");
    }
    paramString = null;
    if (((ByteBuffer)localObject).get() == 1) {}
    for (;;)
    {
      if (bool) {
        paramString = SearchType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject));
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      if (bool) {
        break;
      }
      throw new IOException("Failed to find required field: searchVertical when reading com.linkedin.android.pegasus.gen.voyager.search.BlurredHit from fission.");
      bool = false;
    }
    return new BlurredHit(paramString, bool);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.BlurredHitBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */