package com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateType;
import com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateType.Builder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class SocialGestureHighlightsBuilder
  implements FissileDataModelBuilder<SocialGestureHighlights>, DataTemplateBuilder<SocialGestureHighlights>
{
  public static final SocialGestureHighlightsBuilder INSTANCE = new SocialGestureHighlightsBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("highlights");
    JSON_KEY_STORE.put("socialUpdateType");
  }
  
  public static SocialGestureHighlights build(DataReader paramDataReader)
    throws DataReaderException
  {
    ArrayList localArrayList = null;
    SocialUpdateType localSocialUpdateType = null;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("highlights", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            AnalyticsHighlightBuilder localAnalyticsHighlightBuilder = AnalyticsHighlightBuilder.INSTANCE;
            localArrayList.add(AnalyticsHighlightBuilder.build(paramDataReader));
          }
        }
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("socialUpdateType", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localSocialUpdateType = (SocialUpdateType)paramDataReader.readEnum(SocialUpdateType.Builder.INSTANCE);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: highlights when building com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.SocialGestureHighlights");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: socialUpdateType when building com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.SocialGestureHighlights");
    }
    return new SocialGestureHighlights(localArrayList, localSocialUpdateType, bool2, bool1);
  }
  
  public static SocialGestureHighlights readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SocialGestureHighlights");
    }
    ByteBuffer localByteBuffer = paramByteBuffer;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SocialGestureHighlights");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building SocialGestureHighlights");
    }
    if (((ByteBuffer)localObject).getInt() != 1297589845)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building SocialGestureHighlights");
    }
    paramString = null;
    localByteBuffer = null;
    boolean bool1;
    ArrayList localArrayList;
    if (((ByteBuffer)localObject).get() == 1)
    {
      bool1 = true;
      if (!bool1) {
        break label359;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject);
      localArrayList = new ArrayList();
      label238:
      paramString = localArrayList;
      if (j <= 0) {
        break label359;
      }
      paramString = null;
      i = 1;
      int k = ((ByteBuffer)localObject).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject);
        AnalyticsHighlightBuilder localAnalyticsHighlightBuilder = AnalyticsHighlightBuilder.INSTANCE;
        paramString = AnalyticsHighlightBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label347;
        }
        i = 1;
      }
      label292:
      if (k == 1)
      {
        paramString = AnalyticsHighlightBuilder.INSTANCE;
        paramString = AnalyticsHighlightBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject, null, paramFissionTransaction);
        if (paramString == null) {
          break label353;
        }
      }
    }
    label347:
    label353:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      j -= 1;
      break label238;
      bool1 = false;
      break;
      i = 0;
      break label292;
    }
    label359:
    if (((ByteBuffer)localObject).get() == 1) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      paramFissionTransaction = localByteBuffer;
      if (bool2) {
        paramFissionTransaction = SocialUpdateType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject));
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      if (bool1) {
        break;
      }
      throw new IOException("Failed to find required field: highlights when reading com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.SocialGestureHighlights from fission.");
    }
    if (!bool2) {
      throw new IOException("Failed to find required field: socialUpdateType when reading com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.SocialGestureHighlights from fission.");
    }
    return new SocialGestureHighlights(paramString, paramFissionTransaction, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.SocialGestureHighlightsBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */