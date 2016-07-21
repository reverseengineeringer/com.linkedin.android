package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpJymbiiInsight;
import com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpJymbiiInsightBuilder;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.networkHighlights.NetworkHighlight;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.networkHighlights.NetworkHighlightBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class InsightBuilder
  implements FissileDataModelBuilder<Insight>, DataTemplateBuilder<Insight>
{
  public static final InsightBuilder INSTANCE = new InsightBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("value");
    JSON_KEY_STORE.put("objectUrn");
    JSON_KEY_STORE.put("trackingId");
  }
  
  public static Insight build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject2 = null;
    Object localObject1 = null;
    String str = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("value", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = ValueBuilder.INSTANCE;
        localObject2 = ValueBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("objectUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = UrnCoercer.INSTANCE;
        localObject1 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("trackingId", JSON_KEY_STORE))
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
      throw new DataReaderException("Failed to find required field: value when building com.linkedin.android.pegasus.gen.voyager.identity.me.Insight");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: objectUrn when building com.linkedin.android.pegasus.gen.voyager.identity.me.Insight");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: trackingId when building com.linkedin.android.pegasus.gen.voyager.identity.me.Insight");
    }
    return new Insight((Insight.Value)localObject2, (Urn)localObject1, str, bool3, bool2, bool1);
  }
  
  public static Insight readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Insight");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building Insight");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building Insight");
    }
    if (((ByteBuffer)localObject1).getInt() != 96661724)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building Insight");
    }
    paramString = null;
    ValueBuilder localValueBuilder = null;
    Object localObject3 = null;
    localObject2 = null;
    boolean bool2;
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = localValueBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localValueBuilder = ValueBuilder.INSTANCE;
          paramString = ValueBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label399;
          }
          bool1 = true;
        }
        label277:
        if (i == 1)
        {
          paramString = ValueBuilder.INSTANCE;
          paramString = ValueBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label405;
          }
          bool1 = true;
        }
      }
      label303:
      if (((ByteBuffer)localObject1).get() != 1) {
        break label411;
      }
      bool2 = true;
      label315:
      paramFissionTransaction = (FissionTransaction)localObject3;
      if (bool2)
      {
        paramFissionTransaction = UrnCoercer.INSTANCE;
        paramFissionTransaction = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject1));
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label417;
      }
    }
    label399:
    label405:
    label411:
    label417:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (bool3) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool1) {
        break label423;
      }
      throw new IOException("Failed to find required field: value when reading com.linkedin.android.pegasus.gen.voyager.identity.me.Insight from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label277;
      bool1 = false;
      break label303;
      bool2 = false;
      break label315;
    }
    label423:
    if (!bool2) {
      throw new IOException("Failed to find required field: objectUrn when reading com.linkedin.android.pegasus.gen.voyager.identity.me.Insight from fission.");
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: trackingId when reading com.linkedin.android.pegasus.gen.voyager.identity.me.Insight from fission.");
    }
    return new Insight(paramString, paramFissionTransaction, (String)localObject2, bool1, bool2, bool3);
  }
  
  public static final class ValueBuilder
    implements FissileDataModelBuilder<Insight.Value>, DataTemplateBuilder<Insight.Value>
  {
    public static final ValueBuilder INSTANCE = new ValueBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.voyager.identity.shared.networkHighlights.NetworkHighlight");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.me.wvmpOverview.WvmpJymbiiInsight");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.me.ConnectionsInCommonInsight");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.me.SocialUpdateAnalyticsInsight");
    }
    
    public static Insight.Value build(DataReader paramDataReader)
      throws DataReaderException
    {
      Object localObject4 = null;
      Object localObject3 = null;
      Object localObject2 = null;
      Object localObject1 = null;
      boolean bool4 = false;
      boolean bool3 = false;
      boolean bool2 = false;
      boolean bool1 = false;
      paramDataReader.startRecord();
      while (paramDataReader.hasMoreFields$255f299()) {
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.shared.networkHighlights.NetworkHighlight", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject4 = NetworkHighlightBuilder.INSTANCE;
          localObject4 = NetworkHighlightBuilder.build(paramDataReader);
          bool4 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.me.wvmpOverview.WvmpJymbiiInsight", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject3 = WvmpJymbiiInsightBuilder.INSTANCE;
          localObject3 = WvmpJymbiiInsightBuilder.build(paramDataReader);
          bool3 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.me.ConnectionsInCommonInsight", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = ConnectionsInCommonInsightBuilder.INSTANCE;
          localObject2 = ConnectionsInCommonInsightBuilder.build(paramDataReader);
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.me.SocialUpdateAnalyticsInsight", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = SocialUpdateAnalyticsInsightBuilder.INSTANCE;
          localObject1 = SocialUpdateAnalyticsInsightBuilder.build(paramDataReader);
          bool1 = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
      int j = 0;
      if (bool4) {
        j = 1;
      }
      int i = j;
      if (bool3)
      {
        if (j != 0) {
          throw new DataReaderException("Found more than 1 member when building .Value");
        }
        i = 1;
      }
      j = i;
      if (bool2)
      {
        if (i != 0) {
          throw new DataReaderException("Found more than 1 member when building .Value");
        }
        j = 1;
      }
      if ((bool1) && (j != 0)) {
        throw new DataReaderException("Found more than 1 member when building .Value");
      }
      return new Insight.Value((NetworkHighlight)localObject4, (WvmpJymbiiInsight)localObject3, (ConnectionsInCommonInsight)localObject2, (SocialUpdateAnalyticsInsight)localObject1, bool4, bool3, bool2, bool1);
    }
    
    public static Insight.Value readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building Insight.Value");
      }
      Object localObject1 = paramByteBuffer;
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
            localObject4 = paramString;
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
        throw new IOException("Invalid header prefix. Can't read cached data when building Insight.Value");
      }
      Object localObject4 = localObject1;
      if (((ByteBuffer)localObject1).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("Invalid header prefix. Can't read cached data when building Insight.Value");
      }
      if (((ByteBuffer)localObject4).getInt() != 51850799)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject4);
        throw new IOException("UID mismatch. Can't read cached data when building Insight.Value");
      }
      paramString = null;
      NetworkHighlightBuilder localNetworkHighlightBuilder = null;
      localObject1 = null;
      WvmpJymbiiInsightBuilder localWvmpJymbiiInsightBuilder = null;
      Object localObject2 = null;
      ConnectionsInCommonInsightBuilder localConnectionsInCommonInsightBuilder = null;
      Object localObject3 = null;
      SocialUpdateAnalyticsInsightBuilder localSocialUpdateAnalyticsInsightBuilder = null;
      boolean bool2;
      boolean bool1;
      label289:
      label315:
      boolean bool3;
      label327:
      label389:
      label418:
      boolean bool4;
      if (((ByteBuffer)localObject4).get() == 1)
      {
        bool2 = true;
        bool1 = bool2;
        if (bool2)
        {
          i = ((ByteBuffer)localObject4).get();
          paramString = localNetworkHighlightBuilder;
          bool1 = bool2;
          if (i == 0)
          {
            paramString = paramFissionAdapter.readString((ByteBuffer)localObject4);
            localNetworkHighlightBuilder = NetworkHighlightBuilder.INSTANCE;
            paramString = NetworkHighlightBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label677;
            }
            bool1 = true;
          }
          if (i == 1)
          {
            paramString = NetworkHighlightBuilder.INSTANCE;
            paramString = NetworkHighlightBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
            if (paramString == null) {
              break label683;
            }
            bool1 = true;
          }
        }
        if (((ByteBuffer)localObject4).get() != 1) {
          break label689;
        }
        bool3 = true;
        bool2 = bool3;
        if (bool3)
        {
          i = ((ByteBuffer)localObject4).get();
          localObject1 = localWvmpJymbiiInsightBuilder;
          bool2 = bool3;
          if (i == 0)
          {
            localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject4);
            localWvmpJymbiiInsightBuilder = WvmpJymbiiInsightBuilder.INSTANCE;
            localObject1 = WvmpJymbiiInsightBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
            if (localObject1 == null) {
              break label695;
            }
            bool2 = true;
          }
          if (i == 1)
          {
            localObject1 = WvmpJymbiiInsightBuilder.INSTANCE;
            localObject1 = WvmpJymbiiInsightBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
            if (localObject1 == null) {
              break label701;
            }
            bool2 = true;
          }
        }
        if (((ByteBuffer)localObject4).get() != 1) {
          break label707;
        }
        bool4 = true;
        label430:
        bool3 = bool4;
        if (bool4)
        {
          i = ((ByteBuffer)localObject4).get();
          localObject2 = localConnectionsInCommonInsightBuilder;
          bool3 = bool4;
          if (i == 0)
          {
            localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject4);
            localConnectionsInCommonInsightBuilder = ConnectionsInCommonInsightBuilder.INSTANCE;
            localObject2 = ConnectionsInCommonInsightBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
            if (localObject2 == null) {
              break label713;
            }
            bool3 = true;
          }
          label492:
          if (i == 1)
          {
            localObject2 = ConnectionsInCommonInsightBuilder.INSTANCE;
            localObject2 = ConnectionsInCommonInsightBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
            if (localObject2 == null) {
              break label719;
            }
            bool3 = true;
          }
        }
        label521:
        if (((ByteBuffer)localObject4).get() != 1) {
          break label725;
        }
        bool4 = true;
        label533:
        bool5 = bool4;
        if (bool4)
        {
          i = ((ByteBuffer)localObject4).get();
          localObject3 = localSocialUpdateAnalyticsInsightBuilder;
          if (i == 0)
          {
            localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject4);
            localSocialUpdateAnalyticsInsightBuilder = SocialUpdateAnalyticsInsightBuilder.INSTANCE;
            localObject3 = SocialUpdateAnalyticsInsightBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
            if (localObject3 == null) {
              break label731;
            }
            bool4 = true;
          }
          label591:
          bool5 = bool4;
          if (i == 1)
          {
            localObject3 = SocialUpdateAnalyticsInsightBuilder.INSTANCE;
            localObject3 = SocialUpdateAnalyticsInsightBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
            if (localObject3 == null) {
              break label737;
            }
          }
        }
      }
      label677:
      label683:
      label689:
      label695:
      label701:
      label707:
      label713:
      label719:
      label725:
      label731:
      label737:
      for (boolean bool5 = true;; bool5 = false)
      {
        if (paramByteBuffer == null) {
          paramFissionAdapter.recycle((ByteBuffer)localObject4);
        }
        j = 0;
        if (bool1) {
          j = 1;
        }
        i = j;
        if (!bool2) {
          break label746;
        }
        if (j == 0) {
          break label743;
        }
        throw new IOException("Found more than 1 member when reading .Value from fission.");
        bool2 = false;
        break;
        bool1 = false;
        break label289;
        bool1 = false;
        break label315;
        bool3 = false;
        break label327;
        bool2 = false;
        break label389;
        bool2 = false;
        break label418;
        bool4 = false;
        break label430;
        bool3 = false;
        break label492;
        bool3 = false;
        break label521;
        bool4 = false;
        break label533;
        bool4 = false;
        break label591;
      }
      label743:
      int i = 1;
      label746:
      int j = i;
      if (bool3)
      {
        if (i != 0) {
          throw new IOException("Found more than 1 member when reading .Value from fission.");
        }
        j = 1;
      }
      if ((bool5) && (j != 0)) {
        throw new IOException("Found more than 1 member when reading .Value from fission.");
      }
      return new Insight.Value(paramString, (WvmpJymbiiInsight)localObject1, (ConnectionsInCommonInsight)localObject2, (SocialUpdateAnalyticsInsight)localObject3, bool1, bool2, bool3, bool5);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.InsightBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */