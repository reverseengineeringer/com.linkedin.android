package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedTextBuilder;
import com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpPremiumUpsellType;
import com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpPremiumUpsellType.Builder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class WvmpPremiumUpsellCardBuilder
  implements FissileDataModelBuilder<WvmpPremiumUpsellCard>, DataTemplateBuilder<WvmpPremiumUpsellCard>
{
  public static final WvmpPremiumUpsellCardBuilder INSTANCE = new WvmpPremiumUpsellCardBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("extraProfileViewers");
    JSON_KEY_STORE.put("title");
    JSON_KEY_STORE.put("body");
    JSON_KEY_STORE.put("cta");
    JSON_KEY_STORE.put("premiumUpsellType");
  }
  
  public static WvmpPremiumUpsellCard build(DataReader paramDataReader)
    throws DataReaderException
  {
    long l = 0L;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    WvmpPremiumUpsellType localWvmpPremiumUpsellType = null;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("extraProfileViewers", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("title", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = AttributedTextBuilder.INSTANCE;
        localObject3 = AttributedTextBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("body", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = AttributedTextBuilder.INSTANCE;
        localObject2 = AttributedTextBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("cta", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = AttributedTextBuilder.INSTANCE;
        localObject1 = AttributedTextBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("premiumUpsellType", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localWvmpPremiumUpsellType = (WvmpPremiumUpsellType)paramDataReader.readEnum(WvmpPremiumUpsellType.Builder.INSTANCE);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: extraProfileViewers when building com.linkedin.android.pegasus.gen.voyager.identity.me.WvmpPremiumUpsellCard");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: title when building com.linkedin.android.pegasus.gen.voyager.identity.me.WvmpPremiumUpsellCard");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: body when building com.linkedin.android.pegasus.gen.voyager.identity.me.WvmpPremiumUpsellCard");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: cta when building com.linkedin.android.pegasus.gen.voyager.identity.me.WvmpPremiumUpsellCard");
    }
    return new WvmpPremiumUpsellCard(l, (AttributedText)localObject3, (AttributedText)localObject2, (AttributedText)localObject1, localWvmpPremiumUpsellType, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static WvmpPremiumUpsellCard readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building WvmpPremiumUpsellCard");
    }
    Object localObject1 = paramByteBuffer;
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
          localObject3 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building WvmpPremiumUpsellCard");
    }
    Object localObject3 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building WvmpPremiumUpsellCard");
    }
    if (((ByteBuffer)localObject3).getInt() != -265822634)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject3);
      throw new IOException("UID mismatch. Can't read cached data when building WvmpPremiumUpsellCard");
    }
    long l = 0L;
    paramString = null;
    AttributedTextBuilder localAttributedTextBuilder3 = null;
    localObject1 = null;
    AttributedTextBuilder localAttributedTextBuilder2 = null;
    Object localObject2 = null;
    AttributedTextBuilder localAttributedTextBuilder1 = null;
    Object localObject4 = null;
    boolean bool5;
    boolean bool2;
    label256:
    boolean bool1;
    label313:
    label339:
    boolean bool3;
    if (((ByteBuffer)localObject3).get() == 1)
    {
      bool5 = true;
      if (bool5) {
        l = ((ByteBuffer)localObject3).getLong();
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label610;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject3).get();
        paramString = localAttributedTextBuilder3;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localAttributedTextBuilder3 = AttributedTextBuilder.INSTANCE;
          paramString = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label616;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = AttributedTextBuilder.INSTANCE;
          paramString = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (paramString == null) {
            break label622;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label628;
      }
      bool3 = true;
      label351:
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject3).get();
        localObject1 = localAttributedTextBuilder2;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localAttributedTextBuilder2 = AttributedTextBuilder.INSTANCE;
          localObject1 = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label634;
          }
          bool2 = true;
        }
        label413:
        if (i == 1)
        {
          localObject1 = AttributedTextBuilder.INSTANCE;
          localObject1 = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label640;
          }
          bool2 = true;
        }
      }
      label442:
      if (((ByteBuffer)localObject3).get() != 1) {
        break label646;
      }
      bool4 = true;
      label454:
      bool3 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject3).get();
        localObject2 = localAttributedTextBuilder1;
        bool3 = bool4;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localAttributedTextBuilder1 = AttributedTextBuilder.INSTANCE;
          localObject2 = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label652;
          }
          bool3 = true;
        }
        label516:
        if (i == 1)
        {
          localObject2 = AttributedTextBuilder.INSTANCE;
          localObject2 = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label658;
          }
          bool3 = true;
        }
      }
      label545:
      if (((ByteBuffer)localObject3).get() != 1) {
        break label664;
      }
    }
    label610:
    label616:
    label622:
    label628:
    label634:
    label640:
    label646:
    label652:
    label658:
    label664:
    for (boolean bool4 = true;; bool4 = false)
    {
      paramFissionTransaction = (FissionTransaction)localObject4;
      if (bool4) {
        paramFissionTransaction = WvmpPremiumUpsellType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject3));
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject3);
      }
      if (bool5) {
        break label670;
      }
      throw new IOException("Failed to find required field: extraProfileViewers when reading com.linkedin.android.pegasus.gen.voyager.identity.me.WvmpPremiumUpsellCard from fission.");
      bool5 = false;
      break;
      bool2 = false;
      break label256;
      bool1 = false;
      break label313;
      bool1 = false;
      break label339;
      bool3 = false;
      break label351;
      bool2 = false;
      break label413;
      bool2 = false;
      break label442;
      bool4 = false;
      break label454;
      bool3 = false;
      break label516;
      bool3 = false;
      break label545;
    }
    label670:
    if (!bool1) {
      throw new IOException("Failed to find required field: title when reading com.linkedin.android.pegasus.gen.voyager.identity.me.WvmpPremiumUpsellCard from fission.");
    }
    if (!bool2) {
      throw new IOException("Failed to find required field: body when reading com.linkedin.android.pegasus.gen.voyager.identity.me.WvmpPremiumUpsellCard from fission.");
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: cta when reading com.linkedin.android.pegasus.gen.voyager.identity.me.WvmpPremiumUpsellCard from fission.");
    }
    return new WvmpPremiumUpsellCard(l, paramString, (AttributedText)localObject1, (AttributedText)localObject2, paramFissionTransaction, bool5, bool1, bool2, bool3, bool4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.WvmpPremiumUpsellCardBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */