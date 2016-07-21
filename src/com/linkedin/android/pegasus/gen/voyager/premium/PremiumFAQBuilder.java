package com.linkedin.android.pegasus.gen.voyager.premium;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedTextBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class PremiumFAQBuilder
  implements FissileDataModelBuilder<PremiumFAQ>, DataTemplateBuilder<PremiumFAQ>
{
  public static final PremiumFAQBuilder INSTANCE = new PremiumFAQBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("question");
    JSON_KEY_STORE.put("answer");
    JSON_KEY_STORE.put("attributedAnswer");
  }
  
  public static PremiumFAQ build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str2 = null;
    String str1 = null;
    Object localObject = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("question", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("answer", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("attributedAnswer", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = AttributedTextBuilder.INSTANCE;
        localObject = AttributedTextBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: question when building com.linkedin.android.pegasus.gen.voyager.premium.PremiumFAQ");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: answer when building com.linkedin.android.pegasus.gen.voyager.premium.PremiumFAQ");
    }
    return new PremiumFAQ(str2, str1, (AttributedText)localObject, bool3, bool2, bool1);
  }
  
  public static PremiumFAQ readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building PremiumFAQ");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building PremiumFAQ");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building PremiumFAQ");
    }
    if (((ByteBuffer)localObject1).getInt() != 1877079262)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building PremiumFAQ");
    }
    localObject2 = null;
    String str = null;
    paramString = null;
    AttributedTextBuilder localAttributedTextBuilder = null;
    boolean bool3;
    boolean bool4;
    label247:
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool3 = true;
      if (bool3) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label390;
      }
      bool4 = true;
      if (bool4) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label396;
      }
      bool1 = true;
      label274:
      bool2 = bool1;
      if (bool1)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = localAttributedTextBuilder;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localAttributedTextBuilder = AttributedTextBuilder.INSTANCE;
          paramString = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label402;
          }
          bool1 = true;
        }
        label327:
        bool2 = bool1;
        if (i == 1)
        {
          paramString = AttributedTextBuilder.INSTANCE;
          paramString = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label408;
          }
        }
      }
    }
    label390:
    label396:
    label402:
    label408:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool3) {
        break label414;
      }
      throw new IOException("Failed to find required field: question when reading com.linkedin.android.pegasus.gen.voyager.premium.PremiumFAQ from fission.");
      bool3 = false;
      break;
      bool4 = false;
      break label247;
      bool1 = false;
      break label274;
      bool1 = false;
      break label327;
    }
    label414:
    if (!bool4) {
      throw new IOException("Failed to find required field: answer when reading com.linkedin.android.pegasus.gen.voyager.premium.PremiumFAQ from fission.");
    }
    return new PremiumFAQ((String)localObject2, str, paramString, bool3, bool4, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.premium.PremiumFAQBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */