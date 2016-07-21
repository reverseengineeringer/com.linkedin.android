package com.linkedin.android.pegasus.gen.voyager.identity.me;

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

public final class SuggestedActionCardBuilder
  implements FissileDataModelBuilder<SuggestedActionCard>, DataTemplateBuilder<SuggestedActionCard>
{
  public static final SuggestedActionCardBuilder INSTANCE = new SuggestedActionCardBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("icon");
    JSON_KEY_STORE.put("title");
    JSON_KEY_STORE.put("body");
    JSON_KEY_STORE.put("cta");
    JSON_KEY_STORE.put("action");
    JSON_KEY_STORE.put("legoTrackingToken");
  }
  
  public static SuggestedActionCard build(DataReader paramDataReader)
    throws DataReaderException
  {
    IconType localIconType = null;
    String str4 = null;
    String str3 = null;
    String str2 = null;
    Object localObject = null;
    String str1 = null;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("icon", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localIconType = (IconType)paramDataReader.readEnum(IconType.Builder.INSTANCE);
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("title", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str4 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("body", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("cta", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("action", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = SuggestedActionBuilder.INSTANCE;
        localObject = SuggestedActionBuilder.build(paramDataReader);
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
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: action when building com.linkedin.android.pegasus.gen.voyager.identity.me.SuggestedActionCard");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: legoTrackingToken when building com.linkedin.android.pegasus.gen.voyager.identity.me.SuggestedActionCard");
    }
    return new SuggestedActionCard(localIconType, str4, str3, str2, (SuggestedAction)localObject, str1, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static SuggestedActionCard readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SuggestedActionCard");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SuggestedActionCard");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building SuggestedActionCard");
    }
    if (((ByteBuffer)localObject1).getInt() != -2032998291)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building SuggestedActionCard");
    }
    localObject2 = null;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    paramString = null;
    SuggestedActionBuilder localSuggestedActionBuilder = null;
    Object localObject3 = null;
    boolean bool3;
    boolean bool4;
    label259:
    boolean bool5;
    label286:
    boolean bool6;
    label313:
    label340:
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool3 = true;
      if (bool3) {
        localObject2 = IconType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1));
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label485;
      }
      bool4 = true;
      if (bool4) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label491;
      }
      bool5 = true;
      if (bool5) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label497;
      }
      bool6 = true;
      if (bool6) {
        str3 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label503;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = localSuggestedActionBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localSuggestedActionBuilder = SuggestedActionBuilder.INSTANCE;
          paramString = SuggestedActionBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label509;
          }
          bool1 = true;
        }
        label397:
        if (i == 1)
        {
          paramString = SuggestedActionBuilder.INSTANCE;
          paramString = SuggestedActionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label515;
          }
          bool1 = true;
        }
      }
      label423:
      if (((ByteBuffer)localObject1).get() != 1) {
        break label521;
      }
    }
    label485:
    label491:
    label497:
    label503:
    label509:
    label515:
    label521:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramFissionTransaction = (FissionTransaction)localObject3;
      if (bool2) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool1) {
        break label527;
      }
      throw new IOException("Failed to find required field: action when reading com.linkedin.android.pegasus.gen.voyager.identity.me.SuggestedActionCard from fission.");
      bool3 = false;
      break;
      bool4 = false;
      break label259;
      bool5 = false;
      break label286;
      bool6 = false;
      break label313;
      bool2 = false;
      break label340;
      bool1 = false;
      break label397;
      bool1 = false;
      break label423;
    }
    label527:
    if (!bool2) {
      throw new IOException("Failed to find required field: legoTrackingToken when reading com.linkedin.android.pegasus.gen.voyager.identity.me.SuggestedActionCard from fission.");
    }
    return new SuggestedActionCard((IconType)localObject2, str1, str2, str3, paramString, paramFissionTransaction, bool3, bool4, bool5, bool6, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.SuggestedActionCardBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */