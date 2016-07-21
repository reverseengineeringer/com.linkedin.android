package com.linkedin.android.pegasus.gen.voyager.premium.onboarding;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfileBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class WvmpCardBuilder
  implements FissileDataModelBuilder<WvmpCard>, DataTemplateBuilder<WvmpCard>
{
  public static final WvmpCardBuilder INSTANCE = new WvmpCardBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("profiles");
    JSON_KEY_STORE.put("wvmpTotal");
    JSON_KEY_STORE.put("wvmpDurationInDays");
  }
  
  public static WvmpCard build(DataReader paramDataReader)
    throws DataReaderException
  {
    ArrayList localArrayList = null;
    long l = 0L;
    int i = 0;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("profiles", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            MiniProfileBuilder localMiniProfileBuilder = MiniProfileBuilder.INSTANCE;
            localArrayList.add(MiniProfileBuilder.build(paramDataReader));
          }
        }
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("wvmpTotal", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("wvmpDurationInDays", JSON_KEY_STORE))
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
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: profiles when building com.linkedin.android.pegasus.gen.voyager.premium.onboarding.WvmpCard");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: wvmpTotal when building com.linkedin.android.pegasus.gen.voyager.premium.onboarding.WvmpCard");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: wvmpDurationInDays when building com.linkedin.android.pegasus.gen.voyager.premium.onboarding.WvmpCard");
    }
    return new WvmpCard(localArrayList, l, i, bool3, bool2, bool1);
  }
  
  public static WvmpCard readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building WvmpCard");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building WvmpCard");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building WvmpCard");
    }
    if (((ByteBuffer)localObject1).getInt() != 647108450)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building WvmpCard");
    }
    paramString = null;
    long l = 0L;
    int k = 0;
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool1 = true;
      if (!bool1) {
        break label362;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localObject2 = new ArrayList();
      label241:
      paramString = (String)localObject2;
      if (j <= 0) {
        break label362;
      }
      paramString = null;
      i = 1;
      int m = ((ByteBuffer)localObject1).get();
      if (m == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
        MiniProfileBuilder localMiniProfileBuilder = MiniProfileBuilder.INSTANCE;
        paramString = MiniProfileBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label350;
        }
        i = 1;
      }
      label295:
      if (m == 1)
      {
        paramString = MiniProfileBuilder.INSTANCE;
        paramString = MiniProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
        if (paramString == null) {
          break label356;
        }
      }
    }
    label350:
    label356:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject2).add(paramString);
      }
      j -= 1;
      break label241;
      bool1 = false;
      break;
      i = 0;
      break label295;
    }
    label362:
    boolean bool2;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool2 = true;
      if (bool2) {
        l = ((ByteBuffer)localObject1).getLong();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label447;
      }
    }
    label447:
    for (boolean bool3 = true;; bool3 = false)
    {
      i = k;
      if (bool3) {
        i = ((ByteBuffer)localObject1).getInt();
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool1) {
        break label453;
      }
      throw new IOException("Failed to find required field: profiles when reading com.linkedin.android.pegasus.gen.voyager.premium.onboarding.WvmpCard from fission.");
      bool2 = false;
      break;
    }
    label453:
    if (!bool2) {
      throw new IOException("Failed to find required field: wvmpTotal when reading com.linkedin.android.pegasus.gen.voyager.premium.onboarding.WvmpCard from fission.");
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: wvmpDurationInDays when reading com.linkedin.android.pegasus.gen.voyager.premium.onboarding.WvmpCard from fission.");
    }
    return new WvmpCard(paramString, l, i, bool1, bool2, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.premium.onboarding.WvmpCardBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */