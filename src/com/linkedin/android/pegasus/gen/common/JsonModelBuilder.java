package com.linkedin.android.pegasus.gen.common;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonDataReader;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsonModelBuilder
  implements FissileDataModelBuilder<JsonModel>, DataTemplateBuilder<JsonModel>
{
  public static final JsonModelBuilder INSTANCE = new JsonModelBuilder();
  private static final JsonKeyStore JSON_KEY_STORE = new HashStringKeyStore();
  
  private static JsonModel build(DataReader paramDataReader)
    throws DataReaderException
  {
    paramDataReader.startRecord();
    if ((paramDataReader instanceof JsonDataReader))
    {
      paramDataReader = ((JsonDataReader)paramDataReader).readJsonString();
      try
      {
        paramDataReader = new JsonModel(new JSONObject(paramDataReader));
        return paramDataReader;
      }
      catch (JSONException paramDataReader)
      {
        throw new DataReaderException(paramDataReader);
      }
    }
    throw new DataReaderException("JsonModel can only be built from JsonDataReader.");
  }
  
  private static JsonModel readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    Object localObject2 = null;
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building JsonModel");
    }
    ByteBuffer localByteBuffer = paramByteBuffer;
    if (paramString != null)
    {
      paramString = paramFissionAdapter.readFromCache(paramString, paramFissionTransaction);
      if (paramString == null) {
        paramString = (String)localObject2;
      }
    }
    for (;;)
    {
      return paramString;
      int i = paramString.get();
      int j;
      do
      {
        do
        {
          localObject1 = paramString;
          if (i != 0) {
            break label176;
          }
          localObject1 = paramFissionAdapter.readString(paramString);
          paramFissionAdapter.recycle(paramString);
          localObject1 = paramFissionAdapter.readFromCache((String)localObject1, paramFissionTransaction);
          paramString = (String)localObject2;
          if (localObject1 == null) {
            break;
          }
          j = ((ByteBuffer)localObject1).get();
          paramString = (String)localObject1;
          i = j;
        } while (j == 1);
        paramString = (String)localObject1;
        i = j;
      } while (j == 0);
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building JsonModel");
      Object localObject1 = localByteBuffer;
      if (localByteBuffer.get() != 1)
      {
        paramFissionAdapter.recycle(localByteBuffer);
        throw new IOException("Invalid header prefix. Can't read cached data when building JsonModel");
      }
      label176:
      if (((ByteBuffer)localObject1).getInt() != 1496800382)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("UID mismatch. Can't read cached data when building JsonModel");
      }
      try
      {
        paramFissionTransaction = new JsonModel(new JSONObject(paramFissionAdapter.readString((ByteBuffer)localObject1)));
        paramString = paramFissionTransaction;
        return paramFissionTransaction;
      }
      catch (JSONException paramString)
      {
        throw new IOException(paramString);
      }
      finally
      {
        if (paramByteBuffer == null) {
          paramFissionAdapter.recycle((ByteBuffer)localObject1);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.common.JsonModelBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */