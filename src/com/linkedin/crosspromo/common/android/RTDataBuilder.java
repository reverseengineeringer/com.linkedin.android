package com.linkedin.crosspromo.common.android;

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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class RTDataBuilder
  implements FissileDataModelBuilder<RTData>, DataTemplateBuilder<RTData>
{
  public static final RTDataBuilder INSTANCE = new RTDataBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("type");
    JSON_KEY_STORE.put("startIdx");
    JSON_KEY_STORE.put("endIdx");
    JSON_KEY_STORE.put("attribute");
  }
  
  public static RTData build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str = null;
    int j = 0;
    int i = 0;
    Object localObject = null;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("type", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("startIdx", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        j = paramDataReader.readInt();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("endIdx", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("attribute", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            RTAttributeBuilder localRTAttributeBuilder = RTAttributeBuilder.INSTANCE;
            ((List)localObject).add(RTAttributeBuilder.build(paramDataReader));
          }
        }
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool1) {
      localObject = Collections.emptyList();
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: type when building com.linkedin.crosspromo.common.android.RTData");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: startIdx when building com.linkedin.crosspromo.common.android.RTData");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: endIdx when building com.linkedin.crosspromo.common.android.RTData");
    }
    return new RTData(str, j, i, (List)localObject, bool4, bool3, bool2, bool1);
  }
  
  public static RTData readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building RTData");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building RTData");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building RTData");
    }
    if (((ByteBuffer)localObject1).getInt() != -166200955)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building RTData");
    }
    localObject2 = null;
    int j = 0;
    int k = 0;
    paramString = null;
    boolean bool1;
    boolean bool2;
    label247:
    boolean bool3;
    label271:
    boolean bool4;
    label295:
    int m;
    ArrayList localArrayList;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label428;
      }
      bool2 = true;
      if (bool2) {
        j = ((ByteBuffer)localObject1).getInt();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label434;
      }
      bool3 = true;
      if (bool3) {
        k = ((ByteBuffer)localObject1).getInt();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label440;
      }
      bool4 = true;
      if (!bool4) {
        break label458;
      }
      m = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localArrayList = new ArrayList();
      label319:
      paramString = localArrayList;
      if (m <= 0) {
        break label458;
      }
      paramString = null;
      i = 1;
      int n = ((ByteBuffer)localObject1).get();
      if (n == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
        RTAttributeBuilder localRTAttributeBuilder = RTAttributeBuilder.INSTANCE;
        paramString = RTAttributeBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label446;
        }
        i = 1;
      }
      label373:
      if (n == 1)
      {
        paramString = RTAttributeBuilder.INSTANCE;
        paramString = RTAttributeBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
        if (paramString == null) {
          break label452;
        }
      }
    }
    label428:
    label434:
    label440:
    label446:
    label452:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      m -= 1;
      break label319;
      bool1 = false;
      break;
      bool2 = false;
      break label247;
      bool3 = false;
      break label271;
      bool4 = false;
      break label295;
      i = 0;
      break label373;
    }
    label458:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
    }
    if (!bool4) {
      paramString = Collections.emptyList();
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: type when reading com.linkedin.crosspromo.common.android.RTData from fission.");
    }
    if (!bool2) {
      throw new IOException("Failed to find required field: startIdx when reading com.linkedin.crosspromo.common.android.RTData from fission.");
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: endIdx when reading com.linkedin.crosspromo.common.android.RTData from fission.");
    }
    return new RTData((String)localObject2, j, k, paramString, bool1, bool2, bool3, bool4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.crosspromo.common.android.RTDataBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */