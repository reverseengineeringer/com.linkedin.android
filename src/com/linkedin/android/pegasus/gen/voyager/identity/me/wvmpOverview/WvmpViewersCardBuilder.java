package com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview;

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

public final class WvmpViewersCardBuilder
  implements FissileDataModelBuilder<WvmpViewersCard>, DataTemplateBuilder<WvmpViewersCard>
{
  public static final WvmpViewersCardBuilder INSTANCE = new WvmpViewersCardBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("insightCards");
  }
  
  public static WvmpViewersCard build(DataReader paramDataReader)
    throws DataReaderException
  {
    ArrayList localArrayList = null;
    boolean bool = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("insightCards", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            WvmpInsightCardBuilder localWvmpInsightCardBuilder = WvmpInsightCardBuilder.INSTANCE;
            localArrayList.add(WvmpInsightCardBuilder.build(paramDataReader));
          }
        }
        bool = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool) {
      throw new DataReaderException("Failed to find required field: insightCards when building com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpViewersCard");
    }
    return new WvmpViewersCard(localArrayList, bool);
  }
  
  public static WvmpViewersCard readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building WvmpViewersCard");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building WvmpViewersCard");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building WvmpViewersCard");
    }
    if (((ByteBuffer)localObject1).getInt() != 164428667)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building WvmpViewersCard");
    }
    paramString = null;
    boolean bool;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool = true;
      if (!bool) {
        break label356;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localObject2 = new ArrayList();
      label235:
      paramString = (String)localObject2;
      if (j <= 0) {
        break label356;
      }
      paramString = null;
      i = 1;
      int k = ((ByteBuffer)localObject1).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
        WvmpInsightCardBuilder localWvmpInsightCardBuilder = WvmpInsightCardBuilder.INSTANCE;
        paramString = WvmpInsightCardBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label344;
        }
        i = 1;
      }
      label289:
      if (k == 1)
      {
        paramString = WvmpInsightCardBuilder.INSTANCE;
        paramString = WvmpInsightCardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
        if (paramString == null) {
          break label350;
        }
      }
    }
    label344:
    label350:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject2).add(paramString);
      }
      j -= 1;
      break label235;
      bool = false;
      break;
      i = 0;
      break label289;
    }
    label356:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
    }
    if (!bool) {
      throw new IOException("Failed to find required field: insightCards when reading com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpViewersCard from fission.");
    }
    return new WvmpViewersCard(paramString, bool);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpViewersCardBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */