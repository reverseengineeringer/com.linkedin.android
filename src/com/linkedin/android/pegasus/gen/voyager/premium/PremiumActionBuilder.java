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

public final class PremiumActionBuilder
  implements FissileDataModelBuilder<PremiumAction>, DataTemplateBuilder<PremiumAction>
{
  public static final PremiumActionBuilder INSTANCE = new PremiumActionBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("text");
    JSON_KEY_STORE.put("subText");
    JSON_KEY_STORE.put("iOSProductIdentifier");
    JSON_KEY_STORE.put("priceId");
    JSON_KEY_STORE.put("promotionId");
    JSON_KEY_STORE.put("quote");
    JSON_KEY_STORE.put("iOSQuote");
    JSON_KEY_STORE.put("attributedText");
  }
  
  public static PremiumAction build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str7 = null;
    String str6 = null;
    String str5 = null;
    String str4 = null;
    String str3 = null;
    String str2 = null;
    String str1 = null;
    Object localObject = null;
    boolean bool8 = false;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("text", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str7 = paramDataReader.readString();
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("subText", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str6 = paramDataReader.readString();
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("iOSProductIdentifier", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str5 = paramDataReader.readString();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("priceId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str4 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("promotionId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("quote", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("iOSQuote", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("attributedText", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = PremiumAttributedTextBuilder.INSTANCE;
        localObject = PremiumAttributedTextBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool8) {
      throw new DataReaderException("Failed to find required field: text when building com.linkedin.android.pegasus.gen.voyager.premium.PremiumAction");
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: priceId when building com.linkedin.android.pegasus.gen.voyager.premium.PremiumAction");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: quote when building com.linkedin.android.pegasus.gen.voyager.premium.PremiumAction");
    }
    return new PremiumAction(str7, str6, str5, str4, str3, str2, str1, (PremiumAttributedText)localObject, bool8, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static PremiumAction readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building PremiumAction");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building PremiumAction");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building PremiumAction");
    }
    if (((ByteBuffer)localObject1).getInt() != -195727702)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building PremiumAction");
    }
    localObject2 = null;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    String str6 = null;
    paramString = null;
    PremiumAttributedTextBuilder localPremiumAttributedTextBuilder = null;
    boolean bool3;
    boolean bool4;
    label262:
    boolean bool5;
    label289:
    boolean bool6;
    label316:
    boolean bool7;
    label343:
    boolean bool8;
    label370:
    boolean bool9;
    label397:
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool3 = true;
      if (bool3) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label540;
      }
      bool4 = true;
      if (bool4) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label546;
      }
      bool5 = true;
      if (bool5) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label552;
      }
      bool6 = true;
      if (bool6) {
        str3 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label558;
      }
      bool7 = true;
      if (bool7) {
        str4 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label564;
      }
      bool8 = true;
      if (bool8) {
        str5 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label570;
      }
      bool9 = true;
      if (bool9) {
        str6 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label576;
      }
      bool1 = true;
      label424:
      bool2 = bool1;
      if (bool1)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = localPremiumAttributedTextBuilder;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localPremiumAttributedTextBuilder = PremiumAttributedTextBuilder.INSTANCE;
          paramString = PremiumAttributedTextBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label582;
          }
          bool1 = true;
        }
        label477:
        bool2 = bool1;
        if (i == 1)
        {
          paramString = PremiumAttributedTextBuilder.INSTANCE;
          paramString = PremiumAttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label588;
          }
        }
      }
    }
    label540:
    label546:
    label552:
    label558:
    label564:
    label570:
    label576:
    label582:
    label588:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool3) {
        break label594;
      }
      throw new IOException("Failed to find required field: text when reading com.linkedin.android.pegasus.gen.voyager.premium.PremiumAction from fission.");
      bool3 = false;
      break;
      bool4 = false;
      break label262;
      bool5 = false;
      break label289;
      bool6 = false;
      break label316;
      bool7 = false;
      break label343;
      bool8 = false;
      break label370;
      bool9 = false;
      break label397;
      bool1 = false;
      break label424;
      bool1 = false;
      break label477;
    }
    label594:
    if (!bool6) {
      throw new IOException("Failed to find required field: priceId when reading com.linkedin.android.pegasus.gen.voyager.premium.PremiumAction from fission.");
    }
    if (!bool8) {
      throw new IOException("Failed to find required field: quote when reading com.linkedin.android.pegasus.gen.voyager.premium.PremiumAction from fission.");
    }
    return new PremiumAction((String)localObject2, str1, str2, str3, str4, str5, str6, paramString, bool3, bool4, bool5, bool6, bool7, bool8, bool9, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.premium.PremiumActionBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */