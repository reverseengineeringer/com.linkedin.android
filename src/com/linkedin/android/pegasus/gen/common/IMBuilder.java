package com.linkedin.android.pegasus.gen.common;

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

public final class IMBuilder
  implements FissileDataModelBuilder<IM>, DataTemplateBuilder<IM>
{
  public static final IMBuilder INSTANCE = new IMBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("id");
    JSON_KEY_STORE.put("provider");
  }
  
  public static IM build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str2 = null;
    String str1 = null;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("id", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("provider", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: id when building com.linkedin.android.pegasus.gen.common.IM");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: provider when building com.linkedin.android.pegasus.gen.common.IM");
    }
    return new IM(str2, str1, bool2, bool1);
  }
  
  public static IM readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    boolean bool2 = true;
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building IM");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building IM");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building IM");
    }
    label170:
    if (((ByteBuffer)localObject).getInt() != 1416130809)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building IM");
    }
    paramString = null;
    paramFissionTransaction = null;
    boolean bool1;
    if (((ByteBuffer)localObject).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject);
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label284;
      }
    }
    for (;;)
    {
      if (bool2) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      if (bool1) {
        break label290;
      }
      throw new IOException("Failed to find required field: id when reading com.linkedin.android.pegasus.gen.common.IM from fission.");
      bool1 = false;
      break;
      label284:
      bool2 = false;
    }
    label290:
    if (!bool2) {
      throw new IOException("Failed to find required field: provider when reading com.linkedin.android.pegasus.gen.common.IM from fission.");
    }
    return new IM(paramString, paramFissionTransaction, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.common.IMBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */