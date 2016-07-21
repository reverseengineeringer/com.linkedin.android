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

public final class ErrorResponseBuilder
  implements FissileDataModelBuilder<ErrorResponse>, DataTemplateBuilder<ErrorResponse>
{
  public static final ErrorResponseBuilder INSTANCE = new ErrorResponseBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("status");
    JSON_KEY_STORE.put("serviceErrorCode");
    JSON_KEY_STORE.put("message");
    JSON_KEY_STORE.put("exceptionClass");
    JSON_KEY_STORE.put("stackTrace");
  }
  
  public static ErrorResponse build(DataReader paramDataReader)
    throws DataReaderException
  {
    int j = 0;
    int i = 0;
    String str3 = null;
    String str2 = null;
    String str1 = null;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("status", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        j = paramDataReader.readInt();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("serviceErrorCode", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("message", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("exceptionClass", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("stackTrace", JSON_KEY_STORE))
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
    return new ErrorResponse(j, i, str3, str2, str1, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static ErrorResponse readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building ErrorResponse");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building ErrorResponse");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building ErrorResponse");
    }
    if (((ByteBuffer)localObject1).getInt() != -1197169867)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building ErrorResponse");
    }
    int i = 0;
    int j = 0;
    paramString = null;
    paramFissionTransaction = null;
    localObject2 = null;
    boolean bool1;
    boolean bool2;
    label246:
    boolean bool3;
    label270:
    boolean bool4;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        i = ((ByteBuffer)localObject1).getInt();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label381;
      }
      bool2 = true;
      if (bool2) {
        j = ((ByteBuffer)localObject1).getInt();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label387;
      }
      bool3 = true;
      if (bool3) {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label393;
      }
      bool4 = true;
      label296:
      if (bool4) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label399;
      }
    }
    label381:
    label387:
    label393:
    label399:
    for (boolean bool5 = true;; bool5 = false)
    {
      if (bool5) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      return new ErrorResponse(i, j, paramString, paramFissionTransaction, (String)localObject2, bool1, bool2, bool3, bool4, bool5);
      bool1 = false;
      break;
      bool2 = false;
      break label246;
      bool3 = false;
      break label270;
      bool4 = false;
      break label296;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.restli.common.ErrorResponseBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */