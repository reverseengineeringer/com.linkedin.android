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

public final class FileBuilder
  implements FissileDataModelBuilder<File>, DataTemplateBuilder<File>
{
  public static final FileBuilder INSTANCE = new FileBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("id");
    JSON_KEY_STORE.put("name");
    JSON_KEY_STORE.put("byteSize");
    JSON_KEY_STORE.put("mediaType");
    JSON_KEY_STORE.put("reference");
  }
  
  public static File build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str3 = null;
    String str2 = null;
    long l = 0L;
    String str1 = null;
    Object localObject = null;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("id", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("name", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("byteSize", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("mediaType", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("reference", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = ReferenceBuilder.INSTANCE;
        localObject = ReferenceBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: id when building com.linkedin.android.pegasus.gen.voyager.common.File");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: name when building com.linkedin.android.pegasus.gen.voyager.common.File");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: mediaType when building com.linkedin.android.pegasus.gen.voyager.common.File");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: reference when building com.linkedin.android.pegasus.gen.voyager.common.File");
    }
    return new File(str3, str2, l, str1, (File.Reference)localObject, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static File readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building File");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building File");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building File");
    }
    if (((ByteBuffer)localObject1).getInt() != 846054384)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building File");
    }
    localObject2 = null;
    String str1 = null;
    long l = 0L;
    String str2 = null;
    paramString = null;
    ReferenceBuilder localReferenceBuilder = null;
    boolean bool3;
    boolean bool4;
    label253:
    boolean bool5;
    label280:
    boolean bool6;
    label304:
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool3 = true;
      if (bool3) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label447;
      }
      bool4 = true;
      if (bool4) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label453;
      }
      bool5 = true;
      if (bool5) {
        l = ((ByteBuffer)localObject1).getLong();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label459;
      }
      bool6 = true;
      if (bool6) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label465;
      }
      bool1 = true;
      label331:
      bool2 = bool1;
      if (bool1)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = localReferenceBuilder;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localReferenceBuilder = ReferenceBuilder.INSTANCE;
          paramString = ReferenceBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label471;
          }
          bool1 = true;
        }
        label384:
        bool2 = bool1;
        if (i == 1)
        {
          paramString = ReferenceBuilder.INSTANCE;
          paramString = ReferenceBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label477;
          }
        }
      }
    }
    label447:
    label453:
    label459:
    label465:
    label471:
    label477:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool3) {
        break label483;
      }
      throw new IOException("Failed to find required field: id when reading com.linkedin.android.pegasus.gen.voyager.common.File from fission.");
      bool3 = false;
      break;
      bool4 = false;
      break label253;
      bool5 = false;
      break label280;
      bool6 = false;
      break label304;
      bool1 = false;
      break label331;
      bool1 = false;
      break label384;
    }
    label483:
    if (!bool4) {
      throw new IOException("Failed to find required field: name when reading com.linkedin.android.pegasus.gen.voyager.common.File from fission.");
    }
    if (!bool6) {
      throw new IOException("Failed to find required field: mediaType when reading com.linkedin.android.pegasus.gen.voyager.common.File from fission.");
    }
    if (!bool2) {
      throw new IOException("Failed to find required field: reference when reading com.linkedin.android.pegasus.gen.voyager.common.File from fission.");
    }
    return new File((String)localObject2, str1, l, str2, paramString, bool3, bool4, bool5, bool6, bool2);
  }
  
  public static final class ReferenceBuilder
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.FileBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */