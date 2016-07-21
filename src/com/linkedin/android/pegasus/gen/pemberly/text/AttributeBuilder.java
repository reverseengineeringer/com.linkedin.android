package com.linkedin.android.pegasus.gen.pemberly.text;

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

public final class AttributeBuilder
  implements FissileDataModelBuilder<Attribute>, DataTemplateBuilder<Attribute>
{
  public static final AttributeBuilder INSTANCE = new AttributeBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("start");
    JSON_KEY_STORE.put("length");
    JSON_KEY_STORE.put("type");
  }
  
  public static Attribute build(DataReader paramDataReader)
    throws DataReaderException
  {
    int j = 0;
    int i = 0;
    Object localObject = null;
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
      else if (paramDataReader.shouldReadField$11ca93e7("type", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = AttributeTypeBuilder.INSTANCE;
        localObject = AttributeTypeBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: start when building com.linkedin.android.pegasus.gen.pemberly.text.Attribute");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: length when building com.linkedin.android.pegasus.gen.pemberly.text.Attribute");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: type when building com.linkedin.android.pegasus.gen.pemberly.text.Attribute");
    }
    return new Attribute(j, i, (AttributeType)localObject, bool3, bool2, bool1);
  }
  
  public static Attribute readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Attribute");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building Attribute");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building Attribute");
    }
    if (((ByteBuffer)localObject1).getInt() != 508115185)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building Attribute");
    }
    int i = 0;
    int j = 0;
    paramString = null;
    localObject2 = null;
    boolean bool3;
    boolean bool4;
    label244:
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool3 = true;
      if (bool3) {
        i = ((ByteBuffer)localObject1).getInt();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label384;
      }
      bool4 = true;
      if (bool4) {
        j = ((ByteBuffer)localObject1).getInt();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label390;
      }
      bool1 = true;
      label268:
      bool2 = bool1;
      if (bool1)
      {
        int k = ((ByteBuffer)localObject1).get();
        paramString = (String)localObject2;
        if (k == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localObject2 = AttributeTypeBuilder.INSTANCE;
          paramString = AttributeTypeBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label396;
          }
          bool1 = true;
        }
        label321:
        bool2 = bool1;
        if (k == 1)
        {
          paramString = AttributeTypeBuilder.INSTANCE;
          paramString = AttributeTypeBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label402;
          }
        }
      }
    }
    label384:
    label390:
    label396:
    label402:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool3) {
        break label408;
      }
      throw new IOException("Failed to find required field: start when reading com.linkedin.android.pegasus.gen.pemberly.text.Attribute from fission.");
      bool3 = false;
      break;
      bool4 = false;
      break label244;
      bool1 = false;
      break label268;
      bool1 = false;
      break label321;
    }
    label408:
    if (!bool4) {
      throw new IOException("Failed to find required field: length when reading com.linkedin.android.pegasus.gen.pemberly.text.Attribute from fission.");
    }
    if (!bool2) {
      throw new IOException("Failed to find required field: type when reading com.linkedin.android.pegasus.gen.pemberly.text.Attribute from fission.");
    }
    return new Attribute(i, j, paramString, bool3, bool4, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.pemberly.text.AttributeBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */