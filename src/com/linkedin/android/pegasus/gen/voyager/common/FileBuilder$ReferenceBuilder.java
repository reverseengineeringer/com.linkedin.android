package com.linkedin.android.pegasus.gen.voyager.common;

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

public final class FileBuilder$ReferenceBuilder
  implements FissileDataModelBuilder<File.Reference>, DataTemplateBuilder<File.Reference>
{
  public static final ReferenceBuilder INSTANCE = new ReferenceBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("com.linkedin.voyager.common.MediaProxyImage");
    JSON_KEY_STORE.put("string");
  }
  
  public static File.Reference build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject = null;
    String str = null;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.common.MediaProxyImage", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = MediaProxyImageBuilder.INSTANCE;
        localObject = MediaProxyImageBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("string", JSON_KEY_STORE))
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
    int i = 0;
    if (bool2) {
      i = 1;
    }
    if ((bool1) && (i != 0)) {
      throw new DataReaderException("Found more than 1 member when building .Reference");
    }
    return new File.Reference((MediaProxyImage)localObject, str, bool2, bool1);
  }
  
  public static File.Reference readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building File.Reference");
    }
    ByteBuffer localByteBuffer = paramByteBuffer;
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
          localObject = paramString;
          if (i != 0) {
            break;
          }
          localObject = paramFissionAdapter.readString(paramString);
          paramFissionAdapter.recycle(paramString);
          localObject = paramFissionAdapter.readFromCache((String)localObject, paramFissionTransaction);
          if (localObject == null) {
            return null;
          }
          j = ((ByteBuffer)localObject).get();
          paramString = (String)localObject;
          i = j;
        } while (j == 1);
        paramString = (String)localObject;
        i = j;
      } while (j == 0);
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("Invalid header prefix. Can't read cached data when building File.Reference");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building File.Reference");
    }
    if (((ByteBuffer)localObject).getInt() != 659354824)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building File.Reference");
    }
    paramString = null;
    MediaProxyImageBuilder localMediaProxyImageBuilder = null;
    localByteBuffer = null;
    boolean bool1;
    if (((ByteBuffer)localObject).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject).get();
        bool1 = bool2;
        paramString = localMediaProxyImageBuilder;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject);
          localMediaProxyImageBuilder = MediaProxyImageBuilder.INSTANCE;
          paramString = MediaProxyImageBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label378;
          }
          bool1 = true;
        }
        label274:
        if (i == 1)
        {
          paramString = MediaProxyImageBuilder.INSTANCE;
          paramString = MediaProxyImageBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject, null, paramFissionTransaction);
          if (paramString == null) {
            break label384;
          }
          bool1 = true;
        }
      }
      label300:
      if (((ByteBuffer)localObject).get() != 1) {
        break label390;
      }
    }
    label378:
    label384:
    label390:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramFissionTransaction = localByteBuffer;
      if (bool2) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      i = 0;
      if (bool1) {
        i = 1;
      }
      if ((!bool2) || (i == 0)) {
        break label396;
      }
      throw new IOException("Found more than 1 member when reading .Reference from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label274;
      bool1 = false;
      break label300;
    }
    label396:
    return new File.Reference(paramString, paramFissionTransaction, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.FileBuilder.ReferenceBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */