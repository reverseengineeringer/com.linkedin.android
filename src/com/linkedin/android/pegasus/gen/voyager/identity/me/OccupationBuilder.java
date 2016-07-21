package com.linkedin.android.pegasus.gen.voyager.identity.me;

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

public final class OccupationBuilder
  implements FissileDataModelBuilder<Occupation>, DataTemplateBuilder<Occupation>
{
  public static final OccupationBuilder INSTANCE = new OccupationBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("type");
    JSON_KEY_STORE.put("entityName");
  }
  
  public static Occupation build(DataReader paramDataReader)
    throws DataReaderException
  {
    OccupationType localOccupationType = null;
    String str = null;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("type", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localOccupationType = (OccupationType)paramDataReader.readEnum(OccupationType.Builder.INSTANCE);
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("entityName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: type when building com.linkedin.android.pegasus.gen.voyager.identity.me.Occupation");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: entityName when building com.linkedin.android.pegasus.gen.voyager.identity.me.Occupation");
    }
    return new Occupation(localOccupationType, str, bool1, bool2);
  }
  
  public static Occupation readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    boolean bool2 = true;
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Occupation");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building Occupation");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building Occupation");
    }
    label170:
    if (((ByteBuffer)localObject).getInt() != -1696584047)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building Occupation");
    }
    paramString = null;
    paramFissionTransaction = null;
    boolean bool1;
    if (((ByteBuffer)localObject).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        paramString = OccupationType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject));
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label287;
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
        break label293;
      }
      throw new IOException("Failed to find required field: type when reading com.linkedin.android.pegasus.gen.voyager.identity.me.Occupation from fission.");
      bool1 = false;
      break;
      label287:
      bool2 = false;
    }
    label293:
    if (!bool2) {
      throw new IOException("Failed to find required field: entityName when reading com.linkedin.android.pegasus.gen.voyager.identity.me.Occupation from fission.");
    }
    return new Occupation(paramString, paramFissionTransaction, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.OccupationBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */