package com.linkedin.android.pegasus.gen.voyager.premium.boost;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.common.Duration;
import com.linkedin.android.pegasus.gen.voyager.common.DurationBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class BoostPromotionalDataBuilder
  implements FissileDataModelBuilder<BoostPromotionalData>, DataTemplateBuilder<BoostPromotionalData>
{
  public static final BoostPromotionalDataBuilder INSTANCE = new BoostPromotionalDataBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("carrierName");
    JSON_KEY_STORE.put("formattedSubscriptionPrice");
    JSON_KEY_STORE.put("subscriptionName");
    JSON_KEY_STORE.put("productId");
    JSON_KEY_STORE.put("duration");
  }
  
  public static BoostPromotionalData build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str3 = null;
    String str2 = null;
    String str1 = null;
    int i = 0;
    Object localObject = null;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("carrierName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("formattedSubscriptionPrice", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("subscriptionName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("productId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("duration", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = DurationBuilder.INSTANCE;
        localObject = DurationBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: carrierName when building com.linkedin.android.pegasus.gen.voyager.premium.boost.BoostPromotionalData");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: formattedSubscriptionPrice when building com.linkedin.android.pegasus.gen.voyager.premium.boost.BoostPromotionalData");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: subscriptionName when building com.linkedin.android.pegasus.gen.voyager.premium.boost.BoostPromotionalData");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: productId when building com.linkedin.android.pegasus.gen.voyager.premium.boost.BoostPromotionalData");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: duration when building com.linkedin.android.pegasus.gen.voyager.premium.boost.BoostPromotionalData");
    }
    return new BoostPromotionalData(str3, str2, str1, i, (Duration)localObject, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static BoostPromotionalData readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building BoostPromotionalData");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building BoostPromotionalData");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building BoostPromotionalData");
    }
    if (((ByteBuffer)localObject1).getInt() != 478053976)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building BoostPromotionalData");
    }
    localObject2 = null;
    String str1 = null;
    String str2 = null;
    int i = 0;
    paramString = null;
    DurationBuilder localDurationBuilder = null;
    boolean bool3;
    boolean bool4;
    label253:
    boolean bool5;
    label280:
    boolean bool6;
    label307:
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool3 = true;
      if (bool3) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label447;
      }
      bool4 = true;
      if (bool4) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label453;
      }
      bool5 = true;
      if (bool5) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label459;
      }
      bool6 = true;
      if (bool6) {
        i = ((ByteBuffer)localObject1).getInt();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label465;
      }
      bool1 = true;
      label331:
      bool2 = bool1;
      if (bool1)
      {
        j = ((ByteBuffer)localObject1).get();
        paramString = localDurationBuilder;
        if (j == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localDurationBuilder = DurationBuilder.INSTANCE;
          paramString = DurationBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label471;
          }
          bool1 = true;
        }
        label384:
        bool2 = bool1;
        if (j == 1)
        {
          paramString = DurationBuilder.INSTANCE;
          paramString = DurationBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label477;
          }
        }
      }
    }
    label447:
    label453:
    label459:
    label465:
    label471:
    label477:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool3) {
        break label483;
      }
      throw new IOException("Failed to find required field: carrierName when reading com.linkedin.android.pegasus.gen.voyager.premium.boost.BoostPromotionalData from fission.");
      bool3 = false;
      break;
      bool4 = false;
      break label253;
      bool5 = false;
      break label280;
      bool6 = false;
      break label307;
      bool1 = false;
      break label331;
      bool1 = false;
      break label384;
    }
    label483:
    if (!bool4) {
      throw new IOException("Failed to find required field: formattedSubscriptionPrice when reading com.linkedin.android.pegasus.gen.voyager.premium.boost.BoostPromotionalData from fission.");
    }
    if (!bool5) {
      throw new IOException("Failed to find required field: subscriptionName when reading com.linkedin.android.pegasus.gen.voyager.premium.boost.BoostPromotionalData from fission.");
    }
    if (!bool6) {
      throw new IOException("Failed to find required field: productId when reading com.linkedin.android.pegasus.gen.voyager.premium.boost.BoostPromotionalData from fission.");
    }
    if (!bool2) {
      throw new IOException("Failed to find required field: duration when reading com.linkedin.android.pegasus.gen.voyager.premium.boost.BoostPromotionalData from fission.");
    }
    return new BoostPromotionalData((String)localObject2, str1, str2, i, paramString, bool3, bool4, bool5, bool6, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.premium.boost.BoostPromotionalDataBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */