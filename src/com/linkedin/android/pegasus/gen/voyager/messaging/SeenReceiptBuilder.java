package com.linkedin.android.pegasus.gen.voyager.messaging;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SeenReceiptBuilder
  implements FissileDataModelBuilder<SeenReceipt>, DataTemplateBuilder<SeenReceipt>
{
  public static final SeenReceiptBuilder INSTANCE = new SeenReceiptBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("eventUrn");
    JSON_KEY_STORE.put("seenAt");
  }
  
  public static SeenReceipt build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject = null;
    long l = 0L;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("eventUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = UrnCoercer.INSTANCE;
        localObject = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("seenAt", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: eventUrn when building com.linkedin.android.pegasus.gen.voyager.messaging.SeenReceipt");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: seenAt when building com.linkedin.android.pegasus.gen.voyager.messaging.SeenReceipt");
    }
    return new SeenReceipt((Urn)localObject, l, bool2, bool1);
  }
  
  public static SeenReceipt readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    boolean bool2 = true;
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SeenReceipt");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SeenReceipt");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building SeenReceipt");
    }
    label170:
    if (((ByteBuffer)localObject).getInt() != 714444453)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building SeenReceipt");
    }
    paramString = null;
    long l = 0L;
    boolean bool1;
    if (((ByteBuffer)localObject).get() == 1)
    {
      bool1 = true;
      if (bool1)
      {
        paramString = UrnCoercer.INSTANCE;
        paramString = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject));
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label290;
      }
    }
    for (;;)
    {
      if (bool2) {
        l = ((ByteBuffer)localObject).getLong();
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      if (bool1) {
        break label296;
      }
      throw new IOException("Failed to find required field: eventUrn when reading com.linkedin.android.pegasus.gen.voyager.messaging.SeenReceipt from fission.");
      bool1 = false;
      break;
      label290:
      bool2 = false;
    }
    label296:
    if (!bool2) {
      throw new IOException("Failed to find required field: seenAt when reading com.linkedin.android.pegasus.gen.voyager.messaging.SeenReceipt from fission.");
    }
    return new SeenReceipt(paramString, l, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.SeenReceiptBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */