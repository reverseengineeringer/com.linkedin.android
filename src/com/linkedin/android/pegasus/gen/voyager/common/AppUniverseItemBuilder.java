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

public final class AppUniverseItemBuilder
  implements FissileDataModelBuilder<AppUniverseItem>, DataTemplateBuilder<AppUniverseItem>
{
  public static final AppUniverseItemBuilder INSTANCE = new AppUniverseItemBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("appName");
    JSON_KEY_STORE.put("tagline");
    JSON_KEY_STORE.put("storeUrl");
    JSON_KEY_STORE.put("appUrl");
    JSON_KEY_STORE.put("iconUrl");
    JSON_KEY_STORE.put("trackingCode");
    JSON_KEY_STORE.put("legoTrackingToken");
  }
  
  public static AppUniverseItem build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str7 = null;
    String str6 = null;
    String str5 = null;
    String str4 = null;
    String str3 = null;
    String str2 = null;
    String str1 = null;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("appName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str7 = paramDataReader.readString();
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("tagline", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str6 = paramDataReader.readString();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("storeUrl", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str5 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("appUrl", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str4 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("iconUrl", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("trackingCode", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("legoTrackingToken", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool7) {
      throw new DataReaderException("Failed to find required field: appName when building com.linkedin.android.pegasus.gen.voyager.common.AppUniverseItem");
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: tagline when building com.linkedin.android.pegasus.gen.voyager.common.AppUniverseItem");
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: storeUrl when building com.linkedin.android.pegasus.gen.voyager.common.AppUniverseItem");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: appUrl when building com.linkedin.android.pegasus.gen.voyager.common.AppUniverseItem");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: iconUrl when building com.linkedin.android.pegasus.gen.voyager.common.AppUniverseItem");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: trackingCode when building com.linkedin.android.pegasus.gen.voyager.common.AppUniverseItem");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: legoTrackingToken when building com.linkedin.android.pegasus.gen.voyager.common.AppUniverseItem");
    }
    return new AppUniverseItem(str7, str6, str5, str4, str3, str2, str1, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static AppUniverseItem readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building AppUniverseItem");
    }
    Object localObject2 = paramByteBuffer;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building AppUniverseItem");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building AppUniverseItem");
    }
    if (((ByteBuffer)localObject1).getInt() != 1215427962)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building AppUniverseItem");
    }
    paramString = null;
    paramFissionTransaction = null;
    localObject2 = null;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    boolean bool1;
    boolean bool2;
    label254:
    boolean bool3;
    label280:
    boolean bool4;
    label307:
    boolean bool5;
    label334:
    boolean bool6;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label436;
      }
      bool2 = true;
      if (bool2) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label442;
      }
      bool3 = true;
      if (bool3) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label448;
      }
      bool4 = true;
      if (bool4) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label454;
      }
      bool5 = true;
      if (bool5) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label460;
      }
      bool6 = true;
      label361:
      if (bool6) {
        str3 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label466;
      }
    }
    label436:
    label442:
    label448:
    label454:
    label460:
    label466:
    for (boolean bool7 = true;; bool7 = false)
    {
      if (bool7) {
        str4 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool1) {
        break label472;
      }
      throw new IOException("Failed to find required field: appName when reading com.linkedin.android.pegasus.gen.voyager.common.AppUniverseItem from fission.");
      bool1 = false;
      break;
      bool2 = false;
      break label254;
      bool3 = false;
      break label280;
      bool4 = false;
      break label307;
      bool5 = false;
      break label334;
      bool6 = false;
      break label361;
    }
    label472:
    if (!bool2) {
      throw new IOException("Failed to find required field: tagline when reading com.linkedin.android.pegasus.gen.voyager.common.AppUniverseItem from fission.");
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: storeUrl when reading com.linkedin.android.pegasus.gen.voyager.common.AppUniverseItem from fission.");
    }
    if (!bool4) {
      throw new IOException("Failed to find required field: appUrl when reading com.linkedin.android.pegasus.gen.voyager.common.AppUniverseItem from fission.");
    }
    if (!bool5) {
      throw new IOException("Failed to find required field: iconUrl when reading com.linkedin.android.pegasus.gen.voyager.common.AppUniverseItem from fission.");
    }
    if (!bool6) {
      throw new IOException("Failed to find required field: trackingCode when reading com.linkedin.android.pegasus.gen.voyager.common.AppUniverseItem from fission.");
    }
    if (!bool7) {
      throw new IOException("Failed to find required field: legoTrackingToken when reading com.linkedin.android.pegasus.gen.voyager.common.AppUniverseItem from fission.");
    }
    return new AppUniverseItem(paramString, paramFissionTransaction, (String)localObject2, str1, str2, str3, str4, bool1, bool2, bool3, bool4, bool5, bool6, bool7);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.AppUniverseItemBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */