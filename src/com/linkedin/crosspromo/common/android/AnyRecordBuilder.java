package com.linkedin.crosspromo.common.android;

import com.linkedin.android.fission.interfaces.FissileModelBuilder;
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

public final class AnyRecordBuilder
  implements FissileModelBuilder<AnyRecord>, DataTemplateBuilder<AnyRecord>
{
  public static final AnyRecordBuilder INSTANCE = new AnyRecordBuilder();
  private static final JsonKeyStore JSON_KEY_STORE = new HashStringKeyStore();
  
  public static AnyRecord build(DataReader paramDataReader)
    throws DataReaderException
  {
    paramDataReader.startRecord();
    if ((paramDataReader instanceof JsonDataReader)) {
      return new AnyRecord(((JsonDataReader)paramDataReader).readJsonString());
    }
    throw new DataReaderException("AnyRecord can only build from JsonDataReader.");
  }
  
  public static AnyRecord readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building AnyRecord");
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
            break label167;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building AnyRecord");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building AnyRecord");
    }
    label167:
    if (((ByteBuffer)localObject).getInt() != 2010813710)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building AnyRecord");
    }
    paramString = paramFissionAdapter.readString((ByteBuffer)localObject);
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
    }
    return new AnyRecord(paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.crosspromo.common.android.AnyRecordBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */