package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedTextBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SocialUpdateAnalyticsInsightBuilder
  implements FissileDataModelBuilder<SocialUpdateAnalyticsInsight>, DataTemplateBuilder<SocialUpdateAnalyticsInsight>
{
  public static final SocialUpdateAnalyticsInsightBuilder INSTANCE = new SocialUpdateAnalyticsInsightBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("text");
    JSON_KEY_STORE.put("entity");
  }
  
  public static SocialUpdateAnalyticsInsight build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("text", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = AttributedTextBuilder.INSTANCE;
        localObject1 = AttributedTextBuilder.build(paramDataReader);
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("entity", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = UrnCoercer.INSTANCE;
        localObject2 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: text when building com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateAnalyticsInsight");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: entity when building com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateAnalyticsInsight");
    }
    return new SocialUpdateAnalyticsInsight((AttributedText)localObject1, (Urn)localObject2, bool1, bool2);
  }
  
  public static SocialUpdateAnalyticsInsight readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SocialUpdateAnalyticsInsight");
    }
    ByteBuffer localByteBuffer = paramByteBuffer;
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
          localObject = paramString;
          if (i != 0) {
            break;
          }
          localObject = paramFissionAdapter.readString(paramString);
          paramFissionAdapter.recycle(paramString);
          localObject = paramFissionAdapter.readFromCache((String)localObject, paramFissionTransaction);
          if (localObject == null) {
            return null;
          }
          j = ((ByteBuffer)localObject).get();
          paramString = (String)localObject;
          i = j;
        } while (j == 1);
        paramString = (String)localObject;
        i = j;
      } while (j == 0);
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("Invalid header prefix. Can't read cached data when building SocialUpdateAnalyticsInsight");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building SocialUpdateAnalyticsInsight");
    }
    if (((ByteBuffer)localObject).getInt() != -488478446)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building SocialUpdateAnalyticsInsight");
    }
    paramString = null;
    AttributedTextBuilder localAttributedTextBuilder = null;
    localByteBuffer = null;
    boolean bool1;
    if (((ByteBuffer)localObject).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject).get();
        bool1 = bool2;
        paramString = localAttributedTextBuilder;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject);
          localAttributedTextBuilder = AttributedTextBuilder.INSTANCE;
          paramString = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label369;
          }
          bool1 = true;
        }
        label274:
        if (i == 1)
        {
          paramString = AttributedTextBuilder.INSTANCE;
          paramString = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject, null, paramFissionTransaction);
          if (paramString == null) {
            break label375;
          }
          bool1 = true;
        }
      }
      label300:
      if (((ByteBuffer)localObject).get() != 1) {
        break label381;
      }
    }
    label369:
    label375:
    label381:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramFissionTransaction = localByteBuffer;
      if (bool2)
      {
        paramFissionTransaction = UrnCoercer.INSTANCE;
        paramFissionTransaction = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject));
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      if (bool1) {
        break label387;
      }
      throw new IOException("Failed to find required field: text when reading com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateAnalyticsInsight from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label274;
      bool1 = false;
      break label300;
    }
    label387:
    if (!bool2) {
      throw new IOException("Failed to find required field: entity when reading com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateAnalyticsInsight from fission.");
    }
    return new SocialUpdateAnalyticsInsight(paramString, paramFissionTransaction, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateAnalyticsInsightBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */