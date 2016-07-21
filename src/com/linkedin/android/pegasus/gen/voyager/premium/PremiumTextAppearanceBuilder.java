package com.linkedin.android.pegasus.gen.voyager.premium;

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

public final class PremiumTextAppearanceBuilder
  implements FissileDataModelBuilder<PremiumTextAppearance>, DataTemplateBuilder<PremiumTextAppearance>
{
  public static final PremiumTextAppearanceBuilder INSTANCE = new PremiumTextAppearanceBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("start");
    JSON_KEY_STORE.put("length");
    JSON_KEY_STORE.put("appearance");
  }
  
  public static PremiumTextAppearance build(DataReader paramDataReader)
    throws DataReaderException
  {
    int j = 0;
    int i = 0;
    String str = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("start", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        j = paramDataReader.readInt();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("length", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("appearance", JSON_KEY_STORE))
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
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: start when building com.linkedin.android.pegasus.gen.voyager.premium.PremiumTextAppearance");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: length when building com.linkedin.android.pegasus.gen.voyager.premium.PremiumTextAppearance");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: appearance when building com.linkedin.android.pegasus.gen.voyager.premium.PremiumTextAppearance");
    }
    return new PremiumTextAppearance(j, i, str, bool3, bool2, bool1);
  }
  
  public static PremiumTextAppearance readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    boolean bool3 = true;
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building PremiumTextAppearance");
    }
    ByteBuffer localByteBuffer = paramByteBuffer;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building PremiumTextAppearance");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building PremiumTextAppearance");
    }
    label170:
    if (((ByteBuffer)localObject).getInt() != 966483357)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building PremiumTextAppearance");
    }
    int i = 0;
    int j = 0;
    paramString = null;
    boolean bool1;
    boolean bool2;
    if (((ByteBuffer)localObject).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        i = ((ByteBuffer)localObject).getInt();
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label310;
      }
      bool2 = true;
      label242:
      if (bool2) {
        j = ((ByteBuffer)localObject).getInt();
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label316;
      }
    }
    for (;;)
    {
      if (bool3) {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      if (bool1) {
        break label322;
      }
      throw new IOException("Failed to find required field: start when reading com.linkedin.android.pegasus.gen.voyager.premium.PremiumTextAppearance from fission.");
      bool1 = false;
      break;
      label310:
      bool2 = false;
      break label242;
      label316:
      bool3 = false;
    }
    label322:
    if (!bool2) {
      throw new IOException("Failed to find required field: length when reading com.linkedin.android.pegasus.gen.voyager.premium.PremiumTextAppearance from fission.");
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: appearance when reading com.linkedin.android.pegasus.gen.voyager.premium.PremiumTextAppearance from fission.");
    }
    return new PremiumTextAppearance(i, j, paramString, bool1, bool2, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.premium.PremiumTextAppearanceBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */