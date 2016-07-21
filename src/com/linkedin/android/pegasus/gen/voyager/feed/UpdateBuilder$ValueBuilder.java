package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.JymbiiUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.JymbiiUpdateBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class UpdateBuilder$ValueBuilder
  implements FissileDataModelBuilder<Update.Value>, DataTemplateBuilder<Update.Value>
{
  public static final ValueBuilder INSTANCE = new ValueBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("com.linkedin.voyager.feed.AggregatedFollowRecommendationUpdate");
    JSON_KEY_STORE.put("com.linkedin.voyager.feed.AggregatedConnectionUpdate");
    JSON_KEY_STORE.put("com.linkedin.voyager.feed.AggregatedJymbiiUpdate");
    JSON_KEY_STORE.put("com.linkedin.voyager.feed.AggregatedPymkUpdate");
    JSON_KEY_STORE.put("com.linkedin.voyager.feed.AggregatedShareContentUpdate");
    JSON_KEY_STORE.put("com.linkedin.voyager.feed.ArticleUpdate");
    JSON_KEY_STORE.put("com.linkedin.voyager.feed.ChannelUpdate");
    JSON_KEY_STORE.put("com.linkedin.voyager.feed.ConnectionUpdate");
    JSON_KEY_STORE.put("com.linkedin.voyager.feed.CrossPromoUpdate");
    JSON_KEY_STORE.put("com.linkedin.voyager.feed.DiscussionUpdate");
    JSON_KEY_STORE.put("com.linkedin.voyager.feed.FollowRecommendationUpdate");
    JSON_KEY_STORE.put("com.linkedin.voyager.feed.GenericPromoUpdate");
    JSON_KEY_STORE.put("com.linkedin.voyager.feed.shared.JymbiiUpdate");
    JSON_KEY_STORE.put("com.linkedin.voyager.feed.LyndaUpdate");
    JSON_KEY_STORE.put("com.linkedin.voyager.feed.MentionedInNewsUpdate");
    JSON_KEY_STORE.put("com.linkedin.voyager.feed.PromptResponseUpdate");
    JSON_KEY_STORE.put("com.linkedin.voyager.feed.PropUpdate");
    JSON_KEY_STORE.put("com.linkedin.voyager.feed.PymkUpdate");
    JSON_KEY_STORE.put("com.linkedin.voyager.feed.Reshare");
    JSON_KEY_STORE.put("com.linkedin.voyager.feed.ShareUpdate");
    JSON_KEY_STORE.put("com.linkedin.voyager.feed.ViralUpdate");
  }
  
  public static Update.Value build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject21 = null;
    Object localObject20 = null;
    Object localObject19 = null;
    Object localObject18 = null;
    Object localObject17 = null;
    Object localObject16 = null;
    Object localObject15 = null;
    Object localObject14 = null;
    Object localObject13 = null;
    Object localObject12 = null;
    Object localObject11 = null;
    Object localObject10 = null;
    Object localObject9 = null;
    Object localObject8 = null;
    Object localObject7 = null;
    Object localObject6 = null;
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool21 = false;
    boolean bool20 = false;
    boolean bool19 = false;
    boolean bool18 = false;
    boolean bool17 = false;
    boolean bool16 = false;
    boolean bool15 = false;
    boolean bool14 = false;
    boolean bool13 = false;
    boolean bool12 = false;
    boolean bool11 = false;
    boolean bool10 = false;
    boolean bool9 = false;
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
      if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.AggregatedFollowRecommendationUpdate", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject21 = AggregatedFollowRecommendationUpdateBuilder.INSTANCE;
        localObject21 = AggregatedFollowRecommendationUpdateBuilder.build(paramDataReader);
        bool21 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.AggregatedConnectionUpdate", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject20 = AggregatedConnectionUpdateBuilder.INSTANCE;
        localObject20 = AggregatedConnectionUpdateBuilder.build(paramDataReader);
        bool20 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.AggregatedJymbiiUpdate", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject19 = AggregatedJymbiiUpdateBuilder.INSTANCE;
        localObject19 = AggregatedJymbiiUpdateBuilder.build(paramDataReader);
        bool19 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.AggregatedPymkUpdate", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject18 = AggregatedPymkUpdateBuilder.INSTANCE;
        localObject18 = AggregatedPymkUpdateBuilder.build(paramDataReader);
        bool18 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.AggregatedShareContentUpdate", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject17 = AggregatedShareContentUpdateBuilder.INSTANCE;
        localObject17 = AggregatedShareContentUpdateBuilder.build(paramDataReader);
        bool17 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.ArticleUpdate", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject16 = ArticleUpdateBuilder.INSTANCE;
        localObject16 = ArticleUpdateBuilder.build(paramDataReader);
        bool16 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.ChannelUpdate", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject15 = ChannelUpdateBuilder.INSTANCE;
        localObject15 = ChannelUpdateBuilder.build(paramDataReader);
        bool15 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.ConnectionUpdate", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject14 = ConnectionUpdateBuilder.INSTANCE;
        localObject14 = ConnectionUpdateBuilder.build(paramDataReader);
        bool14 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.CrossPromoUpdate", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject13 = CrossPromoUpdateBuilder.INSTANCE;
        localObject13 = CrossPromoUpdateBuilder.build(paramDataReader);
        bool13 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.DiscussionUpdate", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject12 = DiscussionUpdateBuilder.INSTANCE;
        localObject12 = DiscussionUpdateBuilder.build(paramDataReader);
        bool12 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.FollowRecommendationUpdate", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject11 = FollowRecommendationUpdateBuilder.INSTANCE;
        localObject11 = FollowRecommendationUpdateBuilder.build(paramDataReader);
        bool11 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.GenericPromoUpdate", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject10 = GenericPromoUpdateBuilder.INSTANCE;
        localObject10 = GenericPromoUpdateBuilder.build(paramDataReader);
        bool10 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.shared.JymbiiUpdate", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject9 = JymbiiUpdateBuilder.INSTANCE;
        localObject9 = JymbiiUpdateBuilder.build(paramDataReader);
        bool9 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.LyndaUpdate", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject8 = LyndaUpdateBuilder.INSTANCE;
        localObject8 = LyndaUpdateBuilder.build(paramDataReader);
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.MentionedInNewsUpdate", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject7 = MentionedInNewsUpdateBuilder.INSTANCE;
        localObject7 = MentionedInNewsUpdateBuilder.build(paramDataReader);
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.PromptResponseUpdate", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject6 = PromptResponseUpdateBuilder.INSTANCE;
        localObject6 = PromptResponseUpdateBuilder.build(paramDataReader);
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.PropUpdate", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject5 = PropUpdateBuilder.INSTANCE;
        localObject5 = PropUpdateBuilder.build(paramDataReader);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.PymkUpdate", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = PymkUpdateBuilder.INSTANCE;
        localObject4 = PymkUpdateBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.Reshare", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = ReshareBuilder.INSTANCE;
        localObject3 = ReshareBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.ShareUpdate", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = ShareUpdateBuilder.INSTANCE;
        localObject2 = ShareUpdateBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.ViralUpdate", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = ViralUpdateBuilder.INSTANCE;
        localObject1 = ViralUpdateBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    int j = 0;
    if (bool21) {
      j = 1;
    }
    int i = j;
    if (bool20)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .Value");
      }
      i = 1;
    }
    j = i;
    if (bool19)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .Value");
      }
      j = 1;
    }
    i = j;
    if (bool18)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .Value");
      }
      i = 1;
    }
    j = i;
    if (bool17)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .Value");
      }
      j = 1;
    }
    i = j;
    if (bool16)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .Value");
      }
      i = 1;
    }
    j = i;
    if (bool15)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .Value");
      }
      j = 1;
    }
    i = j;
    if (bool14)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .Value");
      }
      i = 1;
    }
    j = i;
    if (bool13)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .Value");
      }
      j = 1;
    }
    i = j;
    if (bool12)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .Value");
      }
      i = 1;
    }
    j = i;
    if (bool11)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .Value");
      }
      j = 1;
    }
    i = j;
    if (bool10)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .Value");
      }
      i = 1;
    }
    j = i;
    if (bool9)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .Value");
      }
      j = 1;
    }
    i = j;
    if (bool8)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .Value");
      }
      i = 1;
    }
    j = i;
    if (bool7)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .Value");
      }
      j = 1;
    }
    i = j;
    if (bool6)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .Value");
      }
      i = 1;
    }
    j = i;
    if (bool5)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .Value");
      }
      j = 1;
    }
    i = j;
    if (bool4)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .Value");
      }
      i = 1;
    }
    j = i;
    if (bool3)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .Value");
      }
      j = 1;
    }
    i = j;
    if (bool2)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .Value");
      }
      i = 1;
    }
    if ((bool1) && (i != 0)) {
      throw new DataReaderException("Found more than 1 member when building .Value");
    }
    return new Update.Value((AggregatedFollowRecommendationUpdate)localObject21, (AggregatedConnectionUpdate)localObject20, (AggregatedJymbiiUpdate)localObject19, (AggregatedPymkUpdate)localObject18, (AggregatedShareContentUpdate)localObject17, (ArticleUpdate)localObject16, (ChannelUpdate)localObject15, (ConnectionUpdate)localObject14, (CrossPromoUpdate)localObject13, (DiscussionUpdate)localObject12, (FollowRecommendationUpdate)localObject11, (GenericPromoUpdate)localObject10, (JymbiiUpdate)localObject9, (LyndaUpdate)localObject8, (MentionedInNewsUpdate)localObject7, (PromptResponseUpdate)localObject6, (PropUpdate)localObject5, (PymkUpdate)localObject4, (Reshare)localObject3, (ShareUpdate)localObject2, (ViralUpdate)localObject1, bool21, bool20, bool19, bool18, bool17, bool16, bool15, bool14, bool13, bool12, bool11, bool10, bool9, bool8, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static Update.Value readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Update.Value");
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
          localObject21 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building Update.Value");
    }
    Object localObject21 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building Update.Value");
    }
    if (((ByteBuffer)localObject21).getInt() != -1527693339)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject21);
      throw new IOException("UID mismatch. Can't read cached data when building Update.Value");
    }
    paramString = null;
    AggregatedFollowRecommendationUpdateBuilder localAggregatedFollowRecommendationUpdateBuilder = null;
    localObject1 = null;
    AggregatedConnectionUpdateBuilder localAggregatedConnectionUpdateBuilder = null;
    Object localObject2 = null;
    AggregatedJymbiiUpdateBuilder localAggregatedJymbiiUpdateBuilder = null;
    Object localObject3 = null;
    AggregatedPymkUpdateBuilder localAggregatedPymkUpdateBuilder = null;
    Object localObject4 = null;
    AggregatedShareContentUpdateBuilder localAggregatedShareContentUpdateBuilder = null;
    Object localObject5 = null;
    ArticleUpdateBuilder localArticleUpdateBuilder = null;
    Object localObject6 = null;
    ChannelUpdateBuilder localChannelUpdateBuilder = null;
    Object localObject7 = null;
    ConnectionUpdateBuilder localConnectionUpdateBuilder = null;
    Object localObject8 = null;
    CrossPromoUpdateBuilder localCrossPromoUpdateBuilder = null;
    Object localObject9 = null;
    DiscussionUpdateBuilder localDiscussionUpdateBuilder = null;
    Object localObject10 = null;
    FollowRecommendationUpdateBuilder localFollowRecommendationUpdateBuilder = null;
    Object localObject11 = null;
    GenericPromoUpdateBuilder localGenericPromoUpdateBuilder = null;
    Object localObject12 = null;
    JymbiiUpdateBuilder localJymbiiUpdateBuilder = null;
    Object localObject13 = null;
    LyndaUpdateBuilder localLyndaUpdateBuilder = null;
    Object localObject14 = null;
    MentionedInNewsUpdateBuilder localMentionedInNewsUpdateBuilder = null;
    Object localObject15 = null;
    PromptResponseUpdateBuilder localPromptResponseUpdateBuilder = null;
    Object localObject16 = null;
    PropUpdateBuilder localPropUpdateBuilder = null;
    Object localObject17 = null;
    PymkUpdateBuilder localPymkUpdateBuilder = null;
    Object localObject18 = null;
    ReshareBuilder localReshareBuilder = null;
    Object localObject19 = null;
    ShareUpdateBuilder localShareUpdateBuilder = null;
    Object localObject20 = null;
    ViralUpdateBuilder localViralUpdateBuilder = null;
    boolean bool2;
    boolean bool1;
    label396:
    label422:
    boolean bool3;
    label434:
    label496:
    label525:
    boolean bool4;
    label537:
    label599:
    label628:
    boolean bool5;
    label640:
    label702:
    label731:
    boolean bool6;
    label743:
    label805:
    label834:
    boolean bool7;
    label846:
    label908:
    label937:
    boolean bool8;
    label949:
    label1011:
    label1040:
    boolean bool9;
    label1052:
    label1114:
    label1143:
    boolean bool10;
    label1155:
    label1217:
    label1246:
    boolean bool11;
    label1258:
    label1320:
    label1349:
    boolean bool12;
    label1361:
    label1423:
    label1452:
    boolean bool13;
    label1464:
    label1526:
    label1555:
    boolean bool14;
    label1567:
    label1629:
    label1658:
    boolean bool15;
    label1670:
    label1732:
    label1761:
    boolean bool16;
    label1773:
    label1835:
    label1864:
    boolean bool17;
    label1876:
    label1938:
    label1967:
    boolean bool18;
    label1979:
    label2041:
    label2070:
    boolean bool19;
    label2082:
    label2144:
    label2173:
    boolean bool20;
    label2185:
    label2247:
    label2276:
    boolean bool21;
    if (((ByteBuffer)localObject21).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject21).get();
        paramString = localAggregatedFollowRecommendationUpdateBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localAggregatedFollowRecommendationUpdateBuilder = AggregatedFollowRecommendationUpdateBuilder.INSTANCE;
          paramString = AggregatedFollowRecommendationUpdateBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label2536;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = AggregatedFollowRecommendationUpdateBuilder.INSTANCE;
          paramString = AggregatedFollowRecommendationUpdateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (paramString == null) {
            break label2542;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2548;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject1 = localAggregatedConnectionUpdateBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localAggregatedConnectionUpdateBuilder = AggregatedConnectionUpdateBuilder.INSTANCE;
          localObject1 = AggregatedConnectionUpdateBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label2554;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject1 = AggregatedConnectionUpdateBuilder.INSTANCE;
          localObject1 = AggregatedConnectionUpdateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label2560;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2566;
      }
      bool4 = true;
      bool3 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject2 = localAggregatedJymbiiUpdateBuilder;
        bool3 = bool4;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localAggregatedJymbiiUpdateBuilder = AggregatedJymbiiUpdateBuilder.INSTANCE;
          localObject2 = AggregatedJymbiiUpdateBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label2572;
          }
          bool3 = true;
        }
        if (i == 1)
        {
          localObject2 = AggregatedJymbiiUpdateBuilder.INSTANCE;
          localObject2 = AggregatedJymbiiUpdateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label2578;
          }
          bool3 = true;
        }
      }
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2584;
      }
      bool5 = true;
      bool4 = bool5;
      if (bool5)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject3 = localAggregatedPymkUpdateBuilder;
        bool4 = bool5;
        if (i == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localAggregatedPymkUpdateBuilder = AggregatedPymkUpdateBuilder.INSTANCE;
          localObject3 = AggregatedPymkUpdateBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label2590;
          }
          bool4 = true;
        }
        if (i == 1)
        {
          localObject3 = AggregatedPymkUpdateBuilder.INSTANCE;
          localObject3 = AggregatedPymkUpdateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label2596;
          }
          bool4 = true;
        }
      }
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2602;
      }
      bool6 = true;
      bool5 = bool6;
      if (bool6)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject4 = localAggregatedShareContentUpdateBuilder;
        bool5 = bool6;
        if (i == 0)
        {
          localObject4 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localAggregatedShareContentUpdateBuilder = AggregatedShareContentUpdateBuilder.INSTANCE;
          localObject4 = AggregatedShareContentUpdateBuilder.readFromFission(paramFissionAdapter, null, (String)localObject4, paramFissionTransaction);
          if (localObject4 == null) {
            break label2608;
          }
          bool5 = true;
        }
        if (i == 1)
        {
          localObject4 = AggregatedShareContentUpdateBuilder.INSTANCE;
          localObject4 = AggregatedShareContentUpdateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject4 == null) {
            break label2614;
          }
          bool5 = true;
        }
      }
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2620;
      }
      bool7 = true;
      bool6 = bool7;
      if (bool7)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject5 = localArticleUpdateBuilder;
        bool6 = bool7;
        if (i == 0)
        {
          localObject5 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localArticleUpdateBuilder = ArticleUpdateBuilder.INSTANCE;
          localObject5 = ArticleUpdateBuilder.readFromFission(paramFissionAdapter, null, (String)localObject5, paramFissionTransaction);
          if (localObject5 == null) {
            break label2626;
          }
          bool6 = true;
        }
        if (i == 1)
        {
          localObject5 = ArticleUpdateBuilder.INSTANCE;
          localObject5 = ArticleUpdateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject5 == null) {
            break label2632;
          }
          bool6 = true;
        }
      }
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2638;
      }
      bool8 = true;
      bool7 = bool8;
      if (bool8)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject6 = localChannelUpdateBuilder;
        bool7 = bool8;
        if (i == 0)
        {
          localObject6 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localChannelUpdateBuilder = ChannelUpdateBuilder.INSTANCE;
          localObject6 = ChannelUpdateBuilder.readFromFission(paramFissionAdapter, null, (String)localObject6, paramFissionTransaction);
          if (localObject6 == null) {
            break label2644;
          }
          bool7 = true;
        }
        if (i == 1)
        {
          localObject6 = ChannelUpdateBuilder.INSTANCE;
          localObject6 = ChannelUpdateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject6 == null) {
            break label2650;
          }
          bool7 = true;
        }
      }
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2656;
      }
      bool9 = true;
      bool8 = bool9;
      if (bool9)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject7 = localConnectionUpdateBuilder;
        bool8 = bool9;
        if (i == 0)
        {
          localObject7 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localConnectionUpdateBuilder = ConnectionUpdateBuilder.INSTANCE;
          localObject7 = ConnectionUpdateBuilder.readFromFission(paramFissionAdapter, null, (String)localObject7, paramFissionTransaction);
          if (localObject7 == null) {
            break label2662;
          }
          bool8 = true;
        }
        if (i == 1)
        {
          localObject7 = ConnectionUpdateBuilder.INSTANCE;
          localObject7 = ConnectionUpdateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject7 == null) {
            break label2668;
          }
          bool8 = true;
        }
      }
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2674;
      }
      bool10 = true;
      bool9 = bool10;
      if (bool10)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject8 = localCrossPromoUpdateBuilder;
        bool9 = bool10;
        if (i == 0)
        {
          localObject8 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localCrossPromoUpdateBuilder = CrossPromoUpdateBuilder.INSTANCE;
          localObject8 = CrossPromoUpdateBuilder.readFromFission(paramFissionAdapter, null, (String)localObject8, paramFissionTransaction);
          if (localObject8 == null) {
            break label2680;
          }
          bool9 = true;
        }
        if (i == 1)
        {
          localObject8 = CrossPromoUpdateBuilder.INSTANCE;
          localObject8 = CrossPromoUpdateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject8 == null) {
            break label2686;
          }
          bool9 = true;
        }
      }
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2692;
      }
      bool11 = true;
      bool10 = bool11;
      if (bool11)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject9 = localDiscussionUpdateBuilder;
        bool10 = bool11;
        if (i == 0)
        {
          localObject9 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localDiscussionUpdateBuilder = DiscussionUpdateBuilder.INSTANCE;
          localObject9 = DiscussionUpdateBuilder.readFromFission(paramFissionAdapter, null, (String)localObject9, paramFissionTransaction);
          if (localObject9 == null) {
            break label2698;
          }
          bool10 = true;
        }
        if (i == 1)
        {
          localObject9 = DiscussionUpdateBuilder.INSTANCE;
          localObject9 = DiscussionUpdateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject9 == null) {
            break label2704;
          }
          bool10 = true;
        }
      }
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2710;
      }
      bool12 = true;
      bool11 = bool12;
      if (bool12)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject10 = localFollowRecommendationUpdateBuilder;
        bool11 = bool12;
        if (i == 0)
        {
          localObject10 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localFollowRecommendationUpdateBuilder = FollowRecommendationUpdateBuilder.INSTANCE;
          localObject10 = FollowRecommendationUpdateBuilder.readFromFission(paramFissionAdapter, null, (String)localObject10, paramFissionTransaction);
          if (localObject10 == null) {
            break label2716;
          }
          bool11 = true;
        }
        if (i == 1)
        {
          localObject10 = FollowRecommendationUpdateBuilder.INSTANCE;
          localObject10 = FollowRecommendationUpdateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject10 == null) {
            break label2722;
          }
          bool11 = true;
        }
      }
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2728;
      }
      bool13 = true;
      bool12 = bool13;
      if (bool13)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject11 = localGenericPromoUpdateBuilder;
        bool12 = bool13;
        if (i == 0)
        {
          localObject11 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localGenericPromoUpdateBuilder = GenericPromoUpdateBuilder.INSTANCE;
          localObject11 = GenericPromoUpdateBuilder.readFromFission(paramFissionAdapter, null, (String)localObject11, paramFissionTransaction);
          if (localObject11 == null) {
            break label2734;
          }
          bool12 = true;
        }
        if (i == 1)
        {
          localObject11 = GenericPromoUpdateBuilder.INSTANCE;
          localObject11 = GenericPromoUpdateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject11 == null) {
            break label2740;
          }
          bool12 = true;
        }
      }
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2746;
      }
      bool14 = true;
      bool13 = bool14;
      if (bool14)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject12 = localJymbiiUpdateBuilder;
        bool13 = bool14;
        if (i == 0)
        {
          localObject12 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localJymbiiUpdateBuilder = JymbiiUpdateBuilder.INSTANCE;
          localObject12 = JymbiiUpdateBuilder.readFromFission(paramFissionAdapter, null, (String)localObject12, paramFissionTransaction);
          if (localObject12 == null) {
            break label2752;
          }
          bool13 = true;
        }
        if (i == 1)
        {
          localObject12 = JymbiiUpdateBuilder.INSTANCE;
          localObject12 = JymbiiUpdateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject12 == null) {
            break label2758;
          }
          bool13 = true;
        }
      }
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2764;
      }
      bool15 = true;
      bool14 = bool15;
      if (bool15)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject13 = localLyndaUpdateBuilder;
        bool14 = bool15;
        if (i == 0)
        {
          localObject13 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localLyndaUpdateBuilder = LyndaUpdateBuilder.INSTANCE;
          localObject13 = LyndaUpdateBuilder.readFromFission(paramFissionAdapter, null, (String)localObject13, paramFissionTransaction);
          if (localObject13 == null) {
            break label2770;
          }
          bool14 = true;
        }
        if (i == 1)
        {
          localObject13 = LyndaUpdateBuilder.INSTANCE;
          localObject13 = LyndaUpdateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject13 == null) {
            break label2776;
          }
          bool14 = true;
        }
      }
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2782;
      }
      bool16 = true;
      bool15 = bool16;
      if (bool16)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject14 = localMentionedInNewsUpdateBuilder;
        bool15 = bool16;
        if (i == 0)
        {
          localObject14 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localMentionedInNewsUpdateBuilder = MentionedInNewsUpdateBuilder.INSTANCE;
          localObject14 = MentionedInNewsUpdateBuilder.readFromFission(paramFissionAdapter, null, (String)localObject14, paramFissionTransaction);
          if (localObject14 == null) {
            break label2788;
          }
          bool15 = true;
        }
        if (i == 1)
        {
          localObject14 = MentionedInNewsUpdateBuilder.INSTANCE;
          localObject14 = MentionedInNewsUpdateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject14 == null) {
            break label2794;
          }
          bool15 = true;
        }
      }
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2800;
      }
      bool17 = true;
      bool16 = bool17;
      if (bool17)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject15 = localPromptResponseUpdateBuilder;
        bool16 = bool17;
        if (i == 0)
        {
          localObject15 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localPromptResponseUpdateBuilder = PromptResponseUpdateBuilder.INSTANCE;
          localObject15 = PromptResponseUpdateBuilder.readFromFission(paramFissionAdapter, null, (String)localObject15, paramFissionTransaction);
          if (localObject15 == null) {
            break label2806;
          }
          bool16 = true;
        }
        if (i == 1)
        {
          localObject15 = PromptResponseUpdateBuilder.INSTANCE;
          localObject15 = PromptResponseUpdateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject15 == null) {
            break label2812;
          }
          bool16 = true;
        }
      }
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2818;
      }
      bool18 = true;
      bool17 = bool18;
      if (bool18)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject16 = localPropUpdateBuilder;
        bool17 = bool18;
        if (i == 0)
        {
          localObject16 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localPropUpdateBuilder = PropUpdateBuilder.INSTANCE;
          localObject16 = PropUpdateBuilder.readFromFission(paramFissionAdapter, null, (String)localObject16, paramFissionTransaction);
          if (localObject16 == null) {
            break label2824;
          }
          bool17 = true;
        }
        if (i == 1)
        {
          localObject16 = PropUpdateBuilder.INSTANCE;
          localObject16 = PropUpdateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject16 == null) {
            break label2830;
          }
          bool17 = true;
        }
      }
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2836;
      }
      bool19 = true;
      bool18 = bool19;
      if (bool19)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject17 = localPymkUpdateBuilder;
        bool18 = bool19;
        if (i == 0)
        {
          localObject17 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localPymkUpdateBuilder = PymkUpdateBuilder.INSTANCE;
          localObject17 = PymkUpdateBuilder.readFromFission(paramFissionAdapter, null, (String)localObject17, paramFissionTransaction);
          if (localObject17 == null) {
            break label2842;
          }
          bool18 = true;
        }
        if (i == 1)
        {
          localObject17 = PymkUpdateBuilder.INSTANCE;
          localObject17 = PymkUpdateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject17 == null) {
            break label2848;
          }
          bool18 = true;
        }
      }
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2854;
      }
      bool20 = true;
      bool19 = bool20;
      if (bool20)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject18 = localReshareBuilder;
        bool19 = bool20;
        if (i == 0)
        {
          localObject18 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localReshareBuilder = ReshareBuilder.INSTANCE;
          localObject18 = ReshareBuilder.readFromFission(paramFissionAdapter, null, (String)localObject18, paramFissionTransaction);
          if (localObject18 == null) {
            break label2860;
          }
          bool19 = true;
        }
        if (i == 1)
        {
          localObject18 = ReshareBuilder.INSTANCE;
          localObject18 = ReshareBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject18 == null) {
            break label2866;
          }
          bool19 = true;
        }
      }
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2872;
      }
      bool21 = true;
      label2288:
      bool20 = bool21;
      if (bool21)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject19 = localShareUpdateBuilder;
        bool20 = bool21;
        if (i == 0)
        {
          localObject19 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localShareUpdateBuilder = ShareUpdateBuilder.INSTANCE;
          localObject19 = ShareUpdateBuilder.readFromFission(paramFissionAdapter, null, (String)localObject19, paramFissionTransaction);
          if (localObject19 == null) {
            break label2878;
          }
          bool20 = true;
        }
        label2350:
        if (i == 1)
        {
          localObject19 = ShareUpdateBuilder.INSTANCE;
          localObject19 = ShareUpdateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject19 == null) {
            break label2884;
          }
          bool20 = true;
        }
      }
      label2379:
      if (((ByteBuffer)localObject21).get() != 1) {
        break label2890;
      }
      bool21 = true;
      label2391:
      bool22 = bool21;
      if (bool21)
      {
        i = ((ByteBuffer)localObject21).get();
        localObject20 = localViralUpdateBuilder;
        if (i == 0)
        {
          localObject20 = paramFissionAdapter.readString((ByteBuffer)localObject21);
          localViralUpdateBuilder = ViralUpdateBuilder.INSTANCE;
          localObject20 = ViralUpdateBuilder.readFromFission(paramFissionAdapter, null, (String)localObject20, paramFissionTransaction);
          if (localObject20 == null) {
            break label2896;
          }
          bool21 = true;
        }
        label2449:
        bool22 = bool21;
        if (i == 1)
        {
          localObject20 = ViralUpdateBuilder.INSTANCE;
          localObject20 = ViralUpdateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
          if (localObject20 == null) {
            break label2902;
          }
        }
      }
    }
    label2536:
    label2542:
    label2548:
    label2554:
    label2560:
    label2566:
    label2572:
    label2578:
    label2584:
    label2590:
    label2596:
    label2602:
    label2608:
    label2614:
    label2620:
    label2626:
    label2632:
    label2638:
    label2644:
    label2650:
    label2656:
    label2662:
    label2668:
    label2674:
    label2680:
    label2686:
    label2692:
    label2698:
    label2704:
    label2710:
    label2716:
    label2722:
    label2728:
    label2734:
    label2740:
    label2746:
    label2752:
    label2758:
    label2764:
    label2770:
    label2776:
    label2782:
    label2788:
    label2794:
    label2800:
    label2806:
    label2812:
    label2818:
    label2824:
    label2830:
    label2836:
    label2842:
    label2848:
    label2854:
    label2860:
    label2866:
    label2872:
    label2878:
    label2884:
    label2890:
    label2896:
    label2902:
    for (boolean bool22 = true;; bool22 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject21);
      }
      j = 0;
      if (bool1) {
        j = 1;
      }
      i = j;
      if (!bool2) {
        break label2911;
      }
      if (j == 0) {
        break label2908;
      }
      throw new IOException("Found more than 1 member when reading .Value from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label396;
      bool1 = false;
      break label422;
      bool3 = false;
      break label434;
      bool2 = false;
      break label496;
      bool2 = false;
      break label525;
      bool4 = false;
      break label537;
      bool3 = false;
      break label599;
      bool3 = false;
      break label628;
      bool5 = false;
      break label640;
      bool4 = false;
      break label702;
      bool4 = false;
      break label731;
      bool6 = false;
      break label743;
      bool5 = false;
      break label805;
      bool5 = false;
      break label834;
      bool7 = false;
      break label846;
      bool6 = false;
      break label908;
      bool6 = false;
      break label937;
      bool8 = false;
      break label949;
      bool7 = false;
      break label1011;
      bool7 = false;
      break label1040;
      bool9 = false;
      break label1052;
      bool8 = false;
      break label1114;
      bool8 = false;
      break label1143;
      bool10 = false;
      break label1155;
      bool9 = false;
      break label1217;
      bool9 = false;
      break label1246;
      bool11 = false;
      break label1258;
      bool10 = false;
      break label1320;
      bool10 = false;
      break label1349;
      bool12 = false;
      break label1361;
      bool11 = false;
      break label1423;
      bool11 = false;
      break label1452;
      bool13 = false;
      break label1464;
      bool12 = false;
      break label1526;
      bool12 = false;
      break label1555;
      bool14 = false;
      break label1567;
      bool13 = false;
      break label1629;
      bool13 = false;
      break label1658;
      bool15 = false;
      break label1670;
      bool14 = false;
      break label1732;
      bool14 = false;
      break label1761;
      bool16 = false;
      break label1773;
      bool15 = false;
      break label1835;
      bool15 = false;
      break label1864;
      bool17 = false;
      break label1876;
      bool16 = false;
      break label1938;
      bool16 = false;
      break label1967;
      bool18 = false;
      break label1979;
      bool17 = false;
      break label2041;
      bool17 = false;
      break label2070;
      bool19 = false;
      break label2082;
      bool18 = false;
      break label2144;
      bool18 = false;
      break label2173;
      bool20 = false;
      break label2185;
      bool19 = false;
      break label2247;
      bool19 = false;
      break label2276;
      bool21 = false;
      break label2288;
      bool20 = false;
      break label2350;
      bool20 = false;
      break label2379;
      bool21 = false;
      break label2391;
      bool21 = false;
      break label2449;
    }
    label2908:
    int i = 1;
    label2911:
    int j = i;
    if (bool3)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading .Value from fission.");
      }
      j = 1;
    }
    i = j;
    if (bool4)
    {
      if (j != 0) {
        throw new IOException("Found more than 1 member when reading .Value from fission.");
      }
      i = 1;
    }
    j = i;
    if (bool5)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading .Value from fission.");
      }
      j = 1;
    }
    i = j;
    if (bool6)
    {
      if (j != 0) {
        throw new IOException("Found more than 1 member when reading .Value from fission.");
      }
      i = 1;
    }
    j = i;
    if (bool7)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading .Value from fission.");
      }
      j = 1;
    }
    i = j;
    if (bool8)
    {
      if (j != 0) {
        throw new IOException("Found more than 1 member when reading .Value from fission.");
      }
      i = 1;
    }
    j = i;
    if (bool9)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading .Value from fission.");
      }
      j = 1;
    }
    i = j;
    if (bool10)
    {
      if (j != 0) {
        throw new IOException("Found more than 1 member when reading .Value from fission.");
      }
      i = 1;
    }
    j = i;
    if (bool11)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading .Value from fission.");
      }
      j = 1;
    }
    i = j;
    if (bool12)
    {
      if (j != 0) {
        throw new IOException("Found more than 1 member when reading .Value from fission.");
      }
      i = 1;
    }
    j = i;
    if (bool13)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading .Value from fission.");
      }
      j = 1;
    }
    i = j;
    if (bool14)
    {
      if (j != 0) {
        throw new IOException("Found more than 1 member when reading .Value from fission.");
      }
      i = 1;
    }
    j = i;
    if (bool15)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading .Value from fission.");
      }
      j = 1;
    }
    i = j;
    if (bool16)
    {
      if (j != 0) {
        throw new IOException("Found more than 1 member when reading .Value from fission.");
      }
      i = 1;
    }
    j = i;
    if (bool17)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading .Value from fission.");
      }
      j = 1;
    }
    i = j;
    if (bool18)
    {
      if (j != 0) {
        throw new IOException("Found more than 1 member when reading .Value from fission.");
      }
      i = 1;
    }
    j = i;
    if (bool19)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading .Value from fission.");
      }
      j = 1;
    }
    i = j;
    if (bool20)
    {
      if (j != 0) {
        throw new IOException("Found more than 1 member when reading .Value from fission.");
      }
      i = 1;
    }
    if ((bool22) && (i != 0)) {
      throw new IOException("Found more than 1 member when reading .Value from fission.");
    }
    return new Update.Value(paramString, (AggregatedConnectionUpdate)localObject1, (AggregatedJymbiiUpdate)localObject2, (AggregatedPymkUpdate)localObject3, (AggregatedShareContentUpdate)localObject4, (ArticleUpdate)localObject5, (ChannelUpdate)localObject6, (ConnectionUpdate)localObject7, (CrossPromoUpdate)localObject8, (DiscussionUpdate)localObject9, (FollowRecommendationUpdate)localObject10, (GenericPromoUpdate)localObject11, (JymbiiUpdate)localObject12, (LyndaUpdate)localObject13, (MentionedInNewsUpdate)localObject14, (PromptResponseUpdate)localObject15, (PropUpdate)localObject16, (PymkUpdate)localObject17, (Reshare)localObject18, (ShareUpdate)localObject19, (ViralUpdate)localObject20, bool1, bool2, bool3, bool4, bool5, bool6, bool7, bool8, bool9, bool10, bool11, bool12, bool13, bool14, bool15, bool16, bool17, bool18, bool19, bool20, bool22);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.UpdateBuilder.ValueBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */