package com.linkedin.android.pegasus.gen.voyager.identity.profile;

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

public final class StandardWebsiteBuilder
  implements FissileDataModelBuilder<StandardWebsite>, DataTemplateBuilder<StandardWebsite>
{
  public static final StandardWebsiteBuilder INSTANCE = new StandardWebsiteBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("category");
  }
  
  public static StandardWebsite build(DataReader paramDataReader)
    throws DataReaderException
  {
    WebsiteCategory localWebsiteCategory = null;
    boolean bool = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("category", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localWebsiteCategory = (WebsiteCategory)paramDataReader.readEnum(WebsiteCategory.Builder.INSTANCE);
        bool = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool) {
      throw new DataReaderException("Failed to find required field: category when building com.linkedin.android.pegasus.gen.voyager.identity.profile.StandardWebsite");
    }
    return new StandardWebsite(localWebsiteCategory, bool);
  }
  
  public static StandardWebsite readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    boolean bool = true;
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building StandardWebsite");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building StandardWebsite");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building StandardWebsite");
    }
    label170:
    if (((ByteBuffer)localObject).getInt() != -261553075)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building StandardWebsite");
    }
    paramString = null;
    if (((ByteBuffer)localObject).get() == 1) {}
    for (;;)
    {
      if (bool) {
        paramString = WebsiteCategory.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject));
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      if (bool) {
        break;
      }
      throw new IOException("Failed to find required field: category when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.StandardWebsite from fission.");
      bool = false;
    }
    return new StandardWebsite(paramString, bool);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.StandardWebsiteBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */