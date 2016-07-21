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

public final class WvmpCardBuilder
  implements FissileDataModelBuilder<WvmpCard>, DataTemplateBuilder<WvmpCard>
{
  public static final WvmpCardBuilder INSTANCE = new WvmpCardBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("value");
    JSON_KEY_STORE.put("trackingId");
    JSON_KEY_STORE.put("entityUrn");
  }
  
  public static final class ValueBuilder
    implements FissileDataModelBuilder<WvmpCard.Value>, DataTemplateBuilder<WvmpCard.Value>
  {
    public static final ValueBuilder INSTANCE = new ValueBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.voyager.identity.me.wvmpOverview.WvmpViewersCard");
    }
    
    public static WvmpCard.Value build(DataReader paramDataReader)
      throws DataReaderException
    {
      Object localObject = null;
      boolean bool = false;
      paramDataReader.startRecord();
      while (paramDataReader.hasMoreFields$255f299()) {
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.me.wvmpOverview.WvmpViewersCard", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject = WvmpViewersCardBuilder.INSTANCE;
          localObject = WvmpViewersCardBuilder.build(paramDataReader);
          bool = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
      return new WvmpCard.Value((WvmpViewersCard)localObject, bool);
    }
    
    public static WvmpCard.Value readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building WvmpCard.Value");
      }
      Object localObject2 = paramByteBuffer;
      int i;
      if (paramString != null)
      {
        paramString = paramFissionAdapter.readFromCache(paramString, paramFissionTransaction);
        if (paramString == null) {
          return null;
        }
        i = paramString.get();
        int j;
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
        throw new IOException("Invalid header prefix. Can't read cached data when building WvmpCard.Value");
      }
      Object localObject1 = localObject2;
      if (((ByteBuffer)localObject2).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
        throw new IOException("Invalid header prefix. Can't read cached data when building WvmpCard.Value");
      }
      if (((ByteBuffer)localObject1).getInt() != 118827950)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("UID mismatch. Can't read cached data when building WvmpCard.Value");
      }
      paramString = null;
      localObject2 = null;
      boolean bool1;
      if (((ByteBuffer)localObject1).get() == 1)
      {
        bool1 = true;
        bool2 = bool1;
        if (bool1)
        {
          i = ((ByteBuffer)localObject1).get();
          paramString = (String)localObject2;
          if (i == 0)
          {
            paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
            localObject2 = WvmpViewersCardBuilder.INSTANCE;
            paramString = WvmpViewersCardBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label326;
            }
            bool1 = true;
          }
          label267:
          bool2 = bool1;
          if (i == 1)
          {
            paramString = WvmpViewersCardBuilder.INSTANCE;
            paramString = WvmpViewersCardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
            if (paramString == null) {
              break label332;
            }
          }
        }
      }
      label326:
      label332:
      for (boolean bool2 = true;; bool2 = false)
      {
        if (paramByteBuffer == null) {
          paramFissionAdapter.recycle((ByteBuffer)localObject1);
        }
        return new WvmpCard.Value(paramString, bool2);
        bool1 = false;
        break;
        bool1 = false;
        break label267;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpCardBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */