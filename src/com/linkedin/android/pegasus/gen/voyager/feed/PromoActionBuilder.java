package com.linkedin.android.pegasus.gen.voyager.feed;

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

public final class PromoActionBuilder
  implements FissileDataModelBuilder<PromoAction>, DataTemplateBuilder<PromoAction>
{
  public static final PromoActionBuilder INSTANCE = new PromoActionBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("type");
    JSON_KEY_STORE.put("displayText");
    JSON_KEY_STORE.put("url");
  }
  
  public static PromoAction build(DataReader paramDataReader)
    throws DataReaderException
  {
    PromoActionType localPromoActionType = null;
    Object localObject = null;
    String str = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("type", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localPromoActionType = (PromoActionType)paramDataReader.readEnum(PromoActionType.Builder.INSTANCE);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("displayText", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = AttributedTextBuilder.INSTANCE;
        localObject = AttributedTextBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("url", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: type when building com.linkedin.android.pegasus.gen.voyager.feed.PromoAction");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: displayText when building com.linkedin.android.pegasus.gen.voyager.feed.PromoAction");
    }
    return new PromoAction(localPromoActionType, (AttributedText)localObject, str, bool3, bool2, bool1);
  }
  
  public static PromoAction readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building PromoAction");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building PromoAction");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building PromoAction");
    }
    if (((ByteBuffer)localObject1).getInt() != -559769219)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building PromoAction");
    }
    localObject2 = null;
    paramString = null;
    AttributedTextBuilder localAttributedTextBuilder = null;
    Object localObject3 = null;
    boolean bool3;
    label250:
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool3 = true;
      if (bool3) {
        localObject2 = PromoActionType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1));
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label395;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = localAttributedTextBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localAttributedTextBuilder = AttributedTextBuilder.INSTANCE;
          paramString = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label401;
          }
          bool1 = true;
        }
        label307:
        if (i == 1)
        {
          paramString = AttributedTextBuilder.INSTANCE;
          paramString = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label407;
          }
          bool1 = true;
        }
      }
      label333:
      if (((ByteBuffer)localObject1).get() != 1) {
        break label413;
      }
    }
    label395:
    label401:
    label407:
    label413:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramFissionTransaction = (FissionTransaction)localObject3;
      if (bool2) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool3) {
        break label419;
      }
      throw new IOException("Failed to find required field: type when reading com.linkedin.android.pegasus.gen.voyager.feed.PromoAction from fission.");
      bool3 = false;
      break;
      bool2 = false;
      break label250;
      bool1 = false;
      break label307;
      bool1 = false;
      break label333;
    }
    label419:
    if (!bool1) {
      throw new IOException("Failed to find required field: displayText when reading com.linkedin.android.pegasus.gen.voyager.feed.PromoAction from fission.");
    }
    return new PromoAction((PromoActionType)localObject2, paramString, paramFissionTransaction, bool3, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.PromoActionBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */