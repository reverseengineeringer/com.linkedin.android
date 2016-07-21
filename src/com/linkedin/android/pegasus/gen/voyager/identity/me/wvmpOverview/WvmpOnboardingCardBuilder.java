package com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.identity.me.CardBuilder;
import com.linkedin.android.pegasus.gen.voyager.identity.me.WvmpMetadata;
import com.linkedin.android.pegasus.gen.voyager.identity.me.WvmpMetadataBuilder;
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

public final class WvmpOnboardingCardBuilder
  implements FissileDataModelBuilder<WvmpOnboardingCard>, DataTemplateBuilder<WvmpOnboardingCard>
{
  public static final WvmpOnboardingCardBuilder INSTANCE = new WvmpOnboardingCardBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("legoTrackingToken");
    JSON_KEY_STORE.put("cards");
    JSON_KEY_STORE.put("wvmpMetadata");
  }
  
  public static WvmpOnboardingCard build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str = null;
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("legoTrackingToken", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("cards", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            CardBuilder localCardBuilder = CardBuilder.INSTANCE;
            ((List)localObject1).add(CardBuilder.build(paramDataReader));
          }
        }
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("wvmpMetadata", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = WvmpMetadataBuilder.INSTANCE;
        localObject2 = WvmpMetadataBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool2) {
      localObject1 = Collections.emptyList();
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: legoTrackingToken when building com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpOnboardingCard");
    }
    return new WvmpOnboardingCard(str, (List)localObject1, (WvmpMetadata)localObject2, bool3, bool2, bool1);
  }
  
  public static WvmpOnboardingCard readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building WvmpOnboardingCard");
    }
    Object localObject1 = paramByteBuffer;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building WvmpOnboardingCard");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building WvmpOnboardingCard");
    }
    if (((ByteBuffer)localObject2).getInt() != 507372460)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building WvmpOnboardingCard");
    }
    String str = null;
    paramString = null;
    localObject1 = null;
    WvmpMetadataBuilder localWvmpMetadataBuilder = null;
    boolean bool3;
    boolean bool4;
    label247:
    ArrayList localArrayList;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool3 = true;
      if (bool3) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label380;
      }
      bool4 = true;
      if (!bool4) {
        break label398;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2);
      localArrayList = new ArrayList();
      label271:
      paramString = localArrayList;
      if (j <= 0) {
        break label398;
      }
      paramString = null;
      i = 1;
      int k = ((ByteBuffer)localObject2).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
        CardBuilder localCardBuilder = CardBuilder.INSTANCE;
        paramString = CardBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label386;
        }
        i = 1;
      }
      label325:
      if (k == 1)
      {
        paramString = CardBuilder.INSTANCE;
        paramString = CardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
        if (paramString == null) {
          break label392;
        }
      }
    }
    label380:
    label386:
    label392:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      j -= 1;
      break label271;
      bool3 = false;
      break;
      bool4 = false;
      break label247;
      i = 0;
      break label325;
    }
    label398:
    boolean bool1;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool1 = true;
      bool2 = bool1;
      if (bool1)
      {
        i = ((ByteBuffer)localObject2).get();
        localObject1 = localWvmpMetadataBuilder;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localWvmpMetadataBuilder = WvmpMetadataBuilder.INSTANCE;
          localObject1 = WvmpMetadataBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label543;
          }
          bool1 = true;
        }
        label468:
        bool2 = bool1;
        if (i == 1)
        {
          localObject1 = WvmpMetadataBuilder.INSTANCE;
          localObject1 = WvmpMetadataBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label549;
          }
        }
      }
    }
    label543:
    label549:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (!bool4) {
        paramString = Collections.emptyList();
      }
      if (bool3) {
        break label555;
      }
      throw new IOException("Failed to find required field: legoTrackingToken when reading com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpOnboardingCard from fission.");
      bool1 = false;
      break;
      bool1 = false;
      break label468;
    }
    label555:
    return new WvmpOnboardingCard(str, paramString, (WvmpMetadata)localObject1, bool3, bool4, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpOnboardingCardBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */