package com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics;

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

public final class ViewReferrerSourceInfoBuilder
  implements FissileDataModelBuilder<ViewReferrerSourceInfo>, DataTemplateBuilder<ViewReferrerSourceInfo>
{
  public static final ViewReferrerSourceInfoBuilder INSTANCE = new ViewReferrerSourceInfoBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("numViews");
    JSON_KEY_STORE.put("referrer");
  }
  
  public static ViewReferrerSourceInfo build(DataReader paramDataReader)
    throws DataReaderException
  {
    long l = 0L;
    Object localObject = null;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("numViews", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("referrer", JSON_KEY_STORE))
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
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: numViews when building com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.ViewReferrerSourceInfo");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: referrer when building com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.ViewReferrerSourceInfo");
    }
    return new ViewReferrerSourceInfo(l, (AttributedText)localObject, bool2, bool1);
  }
  
  public static ViewReferrerSourceInfo readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building ViewReferrerSourceInfo");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building ViewReferrerSourceInfo");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building ViewReferrerSourceInfo");
    }
    if (((ByteBuffer)localObject1).getInt() != 1565866934)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building ViewReferrerSourceInfo");
    }
    long l = 0L;
    paramString = null;
    localObject2 = null;
    boolean bool3;
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool3 = true;
      if (bool3) {
        l = ((ByteBuffer)localObject1).getLong();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label357;
      }
      bool1 = true;
      label241:
      bool2 = bool1;
      if (bool1)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = (String)localObject2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localObject2 = AttributedTextBuilder.INSTANCE;
          paramString = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label363;
          }
          bool1 = true;
        }
        label294:
        bool2 = bool1;
        if (i == 1)
        {
          paramString = AttributedTextBuilder.INSTANCE;
          paramString = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label369;
          }
        }
      }
    }
    label357:
    label363:
    label369:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool3) {
        break label375;
      }
      throw new IOException("Failed to find required field: numViews when reading com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.ViewReferrerSourceInfo from fission.");
      bool3 = false;
      break;
      bool1 = false;
      break label241;
      bool1 = false;
      break label294;
    }
    label375:
    if (!bool2) {
      throw new IOException("Failed to find required field: referrer when reading com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.ViewReferrerSourceInfo from fission.");
    }
    return new ViewReferrerSourceInfo(l, paramString, bool3, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.ViewReferrerSourceInfoBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */