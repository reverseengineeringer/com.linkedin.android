package com.linkedin.android.pegasus.gen.voyager.growth.lego;

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
import java.util.List;

public final class GroupContentBuilder
  implements FissileDataModelBuilder<GroupContent>, DataTemplateBuilder<GroupContent>
{
  public static final GroupContentBuilder INSTANCE = new GroupContentBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("groupId");
    JSON_KEY_STORE.put("widgets");
  }
  
  public static GroupContent build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str = null;
    ArrayList localArrayList = null;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("groupId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("widgets", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            WidgetContentBuilder localWidgetContentBuilder = WidgetContentBuilder.INSTANCE;
            localArrayList.add(WidgetContentBuilder.build(paramDataReader));
          }
        }
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: groupId when building com.linkedin.android.pegasus.gen.voyager.growth.lego.GroupContent");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: widgets when building com.linkedin.android.pegasus.gen.voyager.growth.lego.GroupContent");
    }
    return new GroupContent(str, localArrayList, bool2, bool1);
  }
  
  public static GroupContent readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building GroupContent");
    }
    Object localObject2 = paramByteBuffer;
    int j;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building GroupContent");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building GroupContent");
    }
    if (((ByteBuffer)localObject1).getInt() != 1131509377)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building GroupContent");
    }
    localObject2 = null;
    paramString = null;
    boolean bool1;
    boolean bool2;
    label241:
    ArrayList localArrayList;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label374;
      }
      bool2 = true;
      if (!bool2) {
        break label392;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localArrayList = new ArrayList();
      label265:
      paramString = localArrayList;
      if (j <= 0) {
        break label392;
      }
      paramString = null;
      i = 1;
      int k = ((ByteBuffer)localObject1).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
        WidgetContentBuilder localWidgetContentBuilder = WidgetContentBuilder.INSTANCE;
        paramString = WidgetContentBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label380;
        }
        i = 1;
      }
      label319:
      if (k == 1)
      {
        paramString = WidgetContentBuilder.INSTANCE;
        paramString = WidgetContentBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
        if (paramString == null) {
          break label386;
        }
      }
    }
    label374:
    label380:
    label386:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      j -= 1;
      break label265;
      bool1 = false;
      break;
      bool2 = false;
      break label241;
      i = 0;
      break label319;
    }
    label392:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: groupId when reading com.linkedin.android.pegasus.gen.voyager.growth.lego.GroupContent from fission.");
    }
    if (!bool2) {
      throw new IOException("Failed to find required field: widgets when reading com.linkedin.android.pegasus.gen.voyager.growth.lego.GroupContent from fission.");
    }
    return new GroupContent((String)localObject2, paramString, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.lego.GroupContentBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */