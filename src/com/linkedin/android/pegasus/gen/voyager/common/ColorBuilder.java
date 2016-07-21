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

public final class ColorBuilder
  implements FissileDataModelBuilder<Color>, DataTemplateBuilder<Color>
{
  public static final ColorBuilder INSTANCE = new ColorBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("red");
    JSON_KEY_STORE.put("green");
    JSON_KEY_STORE.put("blue");
    JSON_KEY_STORE.put("alpha");
  }
  
  public static Color build(DataReader paramDataReader)
    throws DataReaderException
  {
    int m = 0;
    int k = 0;
    int j = 0;
    int i = 0;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("red", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        m = paramDataReader.readInt();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("green", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        k = paramDataReader.readInt();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("blue", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        j = paramDataReader.readInt();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("alpha", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: red when building com.linkedin.android.pegasus.gen.voyager.common.Color");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: green when building com.linkedin.android.pegasus.gen.voyager.common.Color");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: blue when building com.linkedin.android.pegasus.gen.voyager.common.Color");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: alpha when building com.linkedin.android.pegasus.gen.voyager.common.Color");
    }
    return new Color(m, k, j, i, bool4, bool3, bool2, bool1);
  }
  
  public static Color readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Color");
    }
    Object localObject1 = paramByteBuffer;
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
          localObject2 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building Color");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building Color");
    }
    if (((ByteBuffer)localObject2).getInt() != 1809173179)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building Color");
    }
    int i = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    boolean bool1;
    boolean bool2;
    label245:
    boolean bool3;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        i = ((ByteBuffer)localObject2).getInt();
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label338;
      }
      bool2 = true;
      if (bool2) {
        j = ((ByteBuffer)localObject2).getInt();
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label344;
      }
      bool3 = true;
      label269:
      if (bool3) {
        k = ((ByteBuffer)localObject2).getInt();
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label350;
      }
    }
    label338:
    label344:
    label350:
    for (boolean bool4 = true;; bool4 = false)
    {
      if (bool4) {
        m = ((ByteBuffer)localObject2).getInt();
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (bool1) {
        break label356;
      }
      throw new IOException("Failed to find required field: red when reading com.linkedin.android.pegasus.gen.voyager.common.Color from fission.");
      bool1 = false;
      break;
      bool2 = false;
      break label245;
      bool3 = false;
      break label269;
    }
    label356:
    if (!bool2) {
      throw new IOException("Failed to find required field: green when reading com.linkedin.android.pegasus.gen.voyager.common.Color from fission.");
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: blue when reading com.linkedin.android.pegasus.gen.voyager.common.Color from fission.");
    }
    if (!bool4) {
      throw new IOException("Failed to find required field: alpha when reading com.linkedin.android.pegasus.gen.voyager.common.Color from fission.");
    }
    return new Color(i, j, k, m, bool1, bool2, bool3, bool4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.ColorBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */