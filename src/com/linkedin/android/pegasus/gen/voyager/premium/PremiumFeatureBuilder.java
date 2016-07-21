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

public final class PremiumFeatureBuilder
  implements FissileDataModelBuilder<PremiumFeature>, DataTemplateBuilder<PremiumFeature>
{
  public static final PremiumFeatureBuilder INSTANCE = new PremiumFeatureBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("title");
    JSON_KEY_STORE.put("desc");
    JSON_KEY_STORE.put("summarized");
    JSON_KEY_STORE.put("type");
  }
  
  public static PremiumFeature build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str2 = null;
    String str1 = null;
    boolean bool5 = false;
    PremiumFeatureType localPremiumFeatureType = null;
    boolean bool4 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("title", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("desc", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("summarized", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool5 = paramDataReader.readBoolean();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("type", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localPremiumFeatureType = (PremiumFeatureType)paramDataReader.readEnum(PremiumFeatureType.Builder.INSTANCE);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: summarized when building com.linkedin.android.pegasus.gen.voyager.premium.PremiumFeature");
    }
    return new PremiumFeature(str2, str1, bool5, localPremiumFeatureType, bool4, bool2, bool3, bool1);
  }
  
  public static PremiumFeature readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building PremiumFeature");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building PremiumFeature");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building PremiumFeature");
    }
    if (((ByteBuffer)localObject1).getInt() != 1407406593)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building PremiumFeature");
    }
    paramString = null;
    paramFissionTransaction = null;
    boolean bool1 = false;
    localObject2 = null;
    boolean bool2;
    boolean bool3;
    label245:
    boolean bool4;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool2 = true;
      if (bool2) {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label351;
      }
      bool3 = true;
      if (bool3) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label357;
      }
      bool4 = true;
      label271:
      if (bool4)
      {
        if (((ByteBuffer)localObject1).get() != 1) {
          break label363;
        }
        bool1 = true;
      }
      label288:
      if (((ByteBuffer)localObject1).get() != 1) {
        break label369;
      }
    }
    label351:
    label357:
    label363:
    label369:
    for (boolean bool5 = true;; bool5 = false)
    {
      if (bool5) {
        localObject2 = PremiumFeatureType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1));
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool4) {
        break label375;
      }
      throw new IOException("Failed to find required field: summarized when reading com.linkedin.android.pegasus.gen.voyager.premium.PremiumFeature from fission.");
      bool2 = false;
      break;
      bool3 = false;
      break label245;
      bool4 = false;
      break label271;
      bool1 = false;
      break label288;
    }
    label375:
    return new PremiumFeature(paramString, paramFissionTransaction, bool1, (PremiumFeatureType)localObject2, bool2, bool3, bool4, bool5);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.premium.PremiumFeatureBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */