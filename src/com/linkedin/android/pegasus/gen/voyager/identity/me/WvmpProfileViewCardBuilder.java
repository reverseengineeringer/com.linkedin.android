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

public final class WvmpProfileViewCardBuilder
  implements FissileDataModelBuilder<WvmpProfileViewCard>, DataTemplateBuilder<WvmpProfileViewCard>
{
  public static final WvmpProfileViewCardBuilder INSTANCE = new WvmpProfileViewCardBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("viewedAt");
    JSON_KEY_STORE.put("viewer");
    JSON_KEY_STORE.put("insight");
    JSON_KEY_STORE.put("referrer");
    JSON_KEY_STORE.put("pendingInvitee");
  }
  
  public static WvmpProfileViewCard build(DataReader paramDataReader)
    throws DataReaderException
  {
    long l = 0L;
    Object localObject2 = null;
    Object localObject1 = null;
    String str = null;
    boolean bool1 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("viewedAt", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("viewer", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = ProfileViewerBuilder.INSTANCE;
        localObject2 = ProfileViewerBuilder.build(paramDataReader);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("insight", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = InsightBuilder.INSTANCE;
        localObject1 = InsightBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("referrer", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("pendingInvitee", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool1 = paramDataReader.readBoolean();
        bool3 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      bool1 = false;
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: viewedAt when building com.linkedin.android.pegasus.gen.voyager.identity.me.WvmpProfileViewCard");
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: viewer when building com.linkedin.android.pegasus.gen.voyager.identity.me.WvmpProfileViewCard");
    }
    return new WvmpProfileViewCard(l, (ProfileViewer)localObject2, (Insight)localObject1, str, bool1, bool6, bool5, bool4, bool2, bool3);
  }
  
  public static WvmpProfileViewCard readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building WvmpProfileViewCard");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building WvmpProfileViewCard");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building WvmpProfileViewCard");
    }
    if (((ByteBuffer)localObject2).getInt() != 1712841196)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building WvmpProfileViewCard");
    }
    long l = 0L;
    paramString = null;
    ProfileViewerBuilder localProfileViewerBuilder = null;
    localObject1 = null;
    InsightBuilder localInsightBuilder = null;
    Object localObject3 = null;
    boolean bool7 = false;
    boolean bool4;
    boolean bool2;
    label253:
    boolean bool1;
    label310:
    label336:
    label348:
    label410:
    label439:
    boolean bool5;
    label451:
    boolean bool6;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool4 = true;
      if (bool4) {
        l = ((ByteBuffer)localObject2).getLong();
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label542;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = localProfileViewerBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localProfileViewerBuilder = ProfileViewerBuilder.INSTANCE;
          paramString = ProfileViewerBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label548;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = ProfileViewerBuilder.INSTANCE;
          paramString = ProfileViewerBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label554;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label560;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject2).get();
        localObject1 = localInsightBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localInsightBuilder = InsightBuilder.INSTANCE;
          localObject1 = InsightBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label566;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject1 = InsightBuilder.INSTANCE;
          localObject1 = InsightBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label572;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label578;
      }
      bool5 = true;
      paramFissionTransaction = (FissionTransaction)localObject3;
      if (bool5) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label584;
      }
      bool6 = true;
      label480:
      bool3 = bool7;
      if (bool6) {
        if (((ByteBuffer)localObject2).get() != 1) {
          break label590;
        }
      }
    }
    label542:
    label548:
    label554:
    label560:
    label566:
    label572:
    label578:
    label584:
    label590:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (!bool6) {
        bool3 = false;
      }
      if (bool4) {
        break label596;
      }
      throw new IOException("Failed to find required field: viewedAt when reading com.linkedin.android.pegasus.gen.voyager.identity.me.WvmpProfileViewCard from fission.");
      bool4 = false;
      break;
      bool2 = false;
      break label253;
      bool1 = false;
      break label310;
      bool1 = false;
      break label336;
      bool3 = false;
      break label348;
      bool2 = false;
      break label410;
      bool2 = false;
      break label439;
      bool5 = false;
      break label451;
      bool6 = false;
      break label480;
    }
    label596:
    if (!bool1) {
      throw new IOException("Failed to find required field: viewer when reading com.linkedin.android.pegasus.gen.voyager.identity.me.WvmpProfileViewCard from fission.");
    }
    return new WvmpProfileViewCard(l, paramString, (Insight)localObject1, paramFissionTransaction, bool3, bool4, bool1, bool2, bool5, bool6);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.WvmpProfileViewCardBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */