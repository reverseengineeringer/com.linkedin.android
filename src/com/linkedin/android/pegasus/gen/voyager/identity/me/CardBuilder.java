package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class CardBuilder
  implements FissileDataModelBuilder<Card>, DataTemplateBuilder<Card>
{
  public static final CardBuilder INSTANCE = new CardBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("value");
    JSON_KEY_STORE.put("objectUrn");
    JSON_KEY_STORE.put("trackingId");
    JSON_KEY_STORE.put("entityUrn");
  }
  
  public static Card build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject3 = null;
    Object localObject2 = null;
    String str = null;
    Object localObject1 = null;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("value", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = ValueBuilder.INSTANCE;
        localObject3 = ValueBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("objectUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = UrnCoercer.INSTANCE;
        localObject2 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("trackingId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("entityUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = UrnCoercer.INSTANCE;
        localObject1 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: value when building com.linkedin.android.pegasus.gen.voyager.identity.me.Card");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: objectUrn when building com.linkedin.android.pegasus.gen.voyager.identity.me.Card");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: trackingId when building com.linkedin.android.pegasus.gen.voyager.identity.me.Card");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: entityUrn when building com.linkedin.android.pegasus.gen.voyager.identity.me.Card");
    }
    return new Card((Card.Value)localObject3, (Urn)localObject2, str, (Urn)localObject1, bool4, bool3, bool2, bool1);
  }
  
  public static Card readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Card");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building Card");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building Card");
    }
    if (((ByteBuffer)localObject1).getInt() != -1077250362)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building Card");
    }
    paramString = null;
    ValueBuilder localValueBuilder = null;
    Object localObject4 = null;
    localObject2 = null;
    Object localObject3 = null;
    boolean bool2;
    boolean bool1;
    label280:
    label306:
    label318:
    boolean bool3;
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
            break label437;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = ValueBuilder.INSTANCE;
          paramString = ValueBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label443;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label449;
      }
      bool2 = true;
      paramFissionTransaction = (FissionTransaction)localObject4;
      if (bool2)
      {
        paramFissionTransaction = UrnCoercer.INSTANCE;
        paramFissionTransaction = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject1));
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label455;
      }
      bool3 = true;
      label354:
      if (bool3) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label461;
      }
    }
    label437:
    label443:
    label449:
    label455:
    label461:
    for (boolean bool4 = true;; bool4 = false)
    {
      if (bool4)
      {
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject1));
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool1) {
        break label467;
      }
      throw new IOException("Failed to find required field: value when reading com.linkedin.android.pegasus.gen.voyager.identity.me.Card from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label280;
      bool1 = false;
      break label306;
      bool2 = false;
      break label318;
      bool3 = false;
      break label354;
    }
    label467:
    if (!bool2) {
      throw new IOException("Failed to find required field: objectUrn when reading com.linkedin.android.pegasus.gen.voyager.identity.me.Card from fission.");
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: trackingId when reading com.linkedin.android.pegasus.gen.voyager.identity.me.Card from fission.");
    }
    if (!bool4) {
      throw new IOException("Failed to find required field: entityUrn when reading com.linkedin.android.pegasus.gen.voyager.identity.me.Card from fission.");
    }
    return new Card(paramString, paramFissionTransaction, (String)localObject2, (Urn)localObject3, bool1, bool2, bool3, bool4);
  }
  
  public static final class ValueBuilder
    implements FissileDataModelBuilder<Card.Value>, DataTemplateBuilder<Card.Value>
  {
    public static final ValueBuilder INSTANCE = new ValueBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.voyager.identity.me.ProfileViewCard");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.me.AggregateProfileViewCard");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.me.EndorsementCard");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.me.FollowCard");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.me.AggregateFollowCard");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.me.SuggestedActionCard");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.me.SocialActivityCard");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.me.WvmpProfileViewCard");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.me.WvmpAnonymousProfileViewCard");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.me.WvmpPremiumUpsellCard");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.me.NewToVoyagerCard");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.me.JobUpdateActivityCard");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.me.SuggestedEditCard");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.me.JymbiiNotificationCard");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.me.ProfinderServiceProposalNotificationCard");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.me.PropCard");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.me.AggregatePropCard");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.me.SocialUpdateAnalyticsCard");
    }
    
    public static Card.Value build(DataReader paramDataReader)
      throws DataReaderException
    {
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
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.me.ProfileViewCard", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject18 = ProfileViewCardBuilder.INSTANCE;
          localObject18 = ProfileViewCardBuilder.build(paramDataReader);
          bool18 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.me.AggregateProfileViewCard", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject17 = AggregateProfileViewCardBuilder.INSTANCE;
          localObject17 = AggregateProfileViewCardBuilder.build(paramDataReader);
          bool17 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.me.EndorsementCard", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject16 = EndorsementCardBuilder.INSTANCE;
          localObject16 = EndorsementCardBuilder.build(paramDataReader);
          bool16 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.me.FollowCard", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject15 = FollowCardBuilder.INSTANCE;
          localObject15 = FollowCardBuilder.build(paramDataReader);
          bool15 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.me.AggregateFollowCard", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject14 = AggregateFollowCardBuilder.INSTANCE;
          localObject14 = AggregateFollowCardBuilder.build(paramDataReader);
          bool14 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.me.SuggestedActionCard", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject13 = SuggestedActionCardBuilder.INSTANCE;
          localObject13 = SuggestedActionCardBuilder.build(paramDataReader);
          bool13 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.me.SocialActivityCard", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject12 = SocialActivityCardBuilder.INSTANCE;
          localObject12 = SocialActivityCardBuilder.build(paramDataReader);
          bool12 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.me.WvmpProfileViewCard", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject11 = WvmpProfileViewCardBuilder.INSTANCE;
          localObject11 = WvmpProfileViewCardBuilder.build(paramDataReader);
          bool11 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.me.WvmpAnonymousProfileViewCard", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject10 = WvmpAnonymousProfileViewCardBuilder.INSTANCE;
          localObject10 = WvmpAnonymousProfileViewCardBuilder.build(paramDataReader);
          bool10 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.me.WvmpPremiumUpsellCard", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject9 = WvmpPremiumUpsellCardBuilder.INSTANCE;
          localObject9 = WvmpPremiumUpsellCardBuilder.build(paramDataReader);
          bool9 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.me.NewToVoyagerCard", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject8 = NewToVoyagerCardBuilder.INSTANCE;
          localObject8 = NewToVoyagerCardBuilder.build(paramDataReader);
          bool8 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.me.JobUpdateActivityCard", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject7 = JobUpdateActivityCardBuilder.INSTANCE;
          localObject7 = JobUpdateActivityCardBuilder.build(paramDataReader);
          bool7 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.me.SuggestedEditCard", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject6 = SuggestedEditCardBuilder.INSTANCE;
          localObject6 = SuggestedEditCardBuilder.build(paramDataReader);
          bool6 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.me.JymbiiNotificationCard", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject5 = JymbiiNotificationCardBuilder.INSTANCE;
          localObject5 = JymbiiNotificationCardBuilder.build(paramDataReader);
          bool5 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.me.ProfinderServiceProposalNotificationCard", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject4 = ProfinderServiceProposalNotificationCardBuilder.INSTANCE;
          localObject4 = ProfinderServiceProposalNotificationCardBuilder.build(paramDataReader);
          bool4 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.me.PropCard", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject3 = PropCardBuilder.INSTANCE;
          localObject3 = PropCardBuilder.build(paramDataReader);
          bool3 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.me.AggregatePropCard", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = AggregatePropCardBuilder.INSTANCE;
          localObject2 = AggregatePropCardBuilder.build(paramDataReader);
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.me.SocialUpdateAnalyticsCard", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = SocialUpdateAnalyticsCardBuilder.INSTANCE;
          localObject1 = SocialUpdateAnalyticsCardBuilder.build(paramDataReader);
          bool1 = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
      int j = 0;
      if (bool18) {
        j = 1;
      }
      int i = j;
      if (bool17)
      {
        if (j != 0) {
          throw new DataReaderException("Found more than 1 member when building .Value");
        }
        i = 1;
      }
      j = i;
      if (bool16)
      {
        if (i != 0) {
          throw new DataReaderException("Found more than 1 member when building .Value");
        }
        j = 1;
      }
      i = j;
      if (bool15)
      {
        if (j != 0) {
          throw new DataReaderException("Found more than 1 member when building .Value");
        }
        i = 1;
      }
      j = i;
      if (bool14)
      {
        if (i != 0) {
          throw new DataReaderException("Found more than 1 member when building .Value");
        }
        j = 1;
      }
      i = j;
      if (bool13)
      {
        if (j != 0) {
          throw new DataReaderException("Found more than 1 member when building .Value");
        }
        i = 1;
      }
      j = i;
      if (bool12)
      {
        if (i != 0) {
          throw new DataReaderException("Found more than 1 member when building .Value");
        }
        j = 1;
      }
      i = j;
      if (bool11)
      {
        if (j != 0) {
          throw new DataReaderException("Found more than 1 member when building .Value");
        }
        i = 1;
      }
      j = i;
      if (bool10)
      {
        if (i != 0) {
          throw new DataReaderException("Found more than 1 member when building .Value");
        }
        j = 1;
      }
      i = j;
      if (bool9)
      {
        if (j != 0) {
          throw new DataReaderException("Found more than 1 member when building .Value");
        }
        i = 1;
      }
      j = i;
      if (bool8)
      {
        if (i != 0) {
          throw new DataReaderException("Found more than 1 member when building .Value");
        }
        j = 1;
      }
      i = j;
      if (bool7)
      {
        if (j != 0) {
          throw new DataReaderException("Found more than 1 member when building .Value");
        }
        i = 1;
      }
      j = i;
      if (bool6)
      {
        if (i != 0) {
          throw new DataReaderException("Found more than 1 member when building .Value");
        }
        j = 1;
      }
      i = j;
      if (bool5)
      {
        if (j != 0) {
          throw new DataReaderException("Found more than 1 member when building .Value");
        }
        i = 1;
      }
      j = i;
      if (bool4)
      {
        if (i != 0) {
          throw new DataReaderException("Found more than 1 member when building .Value");
        }
        j = 1;
      }
      i = j;
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
      return new Card.Value((ProfileViewCard)localObject18, (AggregateProfileViewCard)localObject17, (EndorsementCard)localObject16, (FollowCard)localObject15, (AggregateFollowCard)localObject14, (SuggestedActionCard)localObject13, (SocialActivityCard)localObject12, (WvmpProfileViewCard)localObject11, (WvmpAnonymousProfileViewCard)localObject10, (WvmpPremiumUpsellCard)localObject9, (NewToVoyagerCard)localObject8, (JobUpdateActivityCard)localObject7, (SuggestedEditCard)localObject6, (JymbiiNotificationCard)localObject5, (ProfinderServiceProposalNotificationCard)localObject4, (PropCard)localObject3, (AggregatePropCard)localObject2, (SocialUpdateAnalyticsCard)localObject1, bool18, bool17, bool16, bool15, bool14, bool13, bool12, bool11, bool10, bool9, bool8, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
    }
    
    public static Card.Value readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building Card.Value");
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
            localObject18 = paramString;
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
        throw new IOException("Invalid header prefix. Can't read cached data when building Card.Value");
      }
      Object localObject18 = localObject1;
      if (((ByteBuffer)localObject1).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("Invalid header prefix. Can't read cached data when building Card.Value");
      }
      if (((ByteBuffer)localObject18).getInt() != -1165812572)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject18);
        throw new IOException("UID mismatch. Can't read cached data when building Card.Value");
      }
      paramString = null;
      ProfileViewCardBuilder localProfileViewCardBuilder = null;
      localObject1 = null;
      AggregateProfileViewCardBuilder localAggregateProfileViewCardBuilder = null;
      Object localObject2 = null;
      EndorsementCardBuilder localEndorsementCardBuilder = null;
      Object localObject3 = null;
      FollowCardBuilder localFollowCardBuilder = null;
      Object localObject4 = null;
      AggregateFollowCardBuilder localAggregateFollowCardBuilder = null;
      Object localObject5 = null;
      SuggestedActionCardBuilder localSuggestedActionCardBuilder = null;
      Object localObject6 = null;
      SocialActivityCardBuilder localSocialActivityCardBuilder = null;
      Object localObject7 = null;
      WvmpProfileViewCardBuilder localWvmpProfileViewCardBuilder = null;
      Object localObject8 = null;
      WvmpAnonymousProfileViewCardBuilder localWvmpAnonymousProfileViewCardBuilder = null;
      Object localObject9 = null;
      WvmpPremiumUpsellCardBuilder localWvmpPremiumUpsellCardBuilder = null;
      Object localObject10 = null;
      NewToVoyagerCardBuilder localNewToVoyagerCardBuilder = null;
      Object localObject11 = null;
      JobUpdateActivityCardBuilder localJobUpdateActivityCardBuilder = null;
      Object localObject12 = null;
      SuggestedEditCardBuilder localSuggestedEditCardBuilder = null;
      Object localObject13 = null;
      JymbiiNotificationCardBuilder localJymbiiNotificationCardBuilder = null;
      Object localObject14 = null;
      ProfinderServiceProposalNotificationCardBuilder localProfinderServiceProposalNotificationCardBuilder = null;
      Object localObject15 = null;
      PropCardBuilder localPropCardBuilder = null;
      Object localObject16 = null;
      AggregatePropCardBuilder localAggregatePropCardBuilder = null;
      Object localObject17 = null;
      SocialUpdateAnalyticsCardBuilder localSocialUpdateAnalyticsCardBuilder = null;
      boolean bool2;
      boolean bool1;
      label377:
      label403:
      boolean bool3;
      label415:
      label477:
      label506:
      boolean bool4;
      label518:
      label580:
      label609:
      boolean bool5;
      label621:
      label683:
      label712:
      boolean bool6;
      label724:
      label786:
      label815:
      boolean bool7;
      label827:
      label889:
      label918:
      boolean bool8;
      label930:
      label992:
      label1021:
      boolean bool9;
      label1033:
      label1095:
      label1124:
      boolean bool10;
      label1136:
      label1198:
      label1227:
      boolean bool11;
      label1239:
      label1301:
      label1330:
      boolean bool12;
      label1342:
      label1404:
      label1433:
      boolean bool13;
      label1445:
      label1507:
      label1536:
      boolean bool14;
      label1548:
      label1610:
      label1639:
      boolean bool15;
      label1651:
      label1713:
      label1742:
      boolean bool16;
      label1754:
      label1816:
      label1845:
      boolean bool17;
      label1857:
      label1919:
      label1948:
      boolean bool18;
      if (((ByteBuffer)localObject18).get() == 1)
      {
        bool2 = true;
        bool1 = bool2;
        if (bool2)
        {
          i = ((ByteBuffer)localObject18).get();
          paramString = localProfileViewCardBuilder;
          bool1 = bool2;
          if (i == 0)
          {
            paramString = paramFissionAdapter.readString((ByteBuffer)localObject18);
            localProfileViewCardBuilder = ProfileViewCardBuilder.INSTANCE;
            paramString = ProfileViewCardBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label2208;
            }
            bool1 = true;
          }
          if (i == 1)
          {
            paramString = ProfileViewCardBuilder.INSTANCE;
            paramString = ProfileViewCardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject18, null, paramFissionTransaction);
            if (paramString == null) {
              break label2214;
            }
            bool1 = true;
          }
        }
        if (((ByteBuffer)localObject18).get() != 1) {
          break label2220;
        }
        bool3 = true;
        bool2 = bool3;
        if (bool3)
        {
          i = ((ByteBuffer)localObject18).get();
          localObject1 = localAggregateProfileViewCardBuilder;
          bool2 = bool3;
          if (i == 0)
          {
            localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject18);
            localAggregateProfileViewCardBuilder = AggregateProfileViewCardBuilder.INSTANCE;
            localObject1 = AggregateProfileViewCardBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
            if (localObject1 == null) {
              break label2226;
            }
            bool2 = true;
          }
          if (i == 1)
          {
            localObject1 = AggregateProfileViewCardBuilder.INSTANCE;
            localObject1 = AggregateProfileViewCardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject18, null, paramFissionTransaction);
            if (localObject1 == null) {
              break label2232;
            }
            bool2 = true;
          }
        }
        if (((ByteBuffer)localObject18).get() != 1) {
          break label2238;
        }
        bool4 = true;
        bool3 = bool4;
        if (bool4)
        {
          i = ((ByteBuffer)localObject18).get();
          localObject2 = localEndorsementCardBuilder;
          bool3 = bool4;
          if (i == 0)
          {
            localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject18);
            localEndorsementCardBuilder = EndorsementCardBuilder.INSTANCE;
            localObject2 = EndorsementCardBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
            if (localObject2 == null) {
              break label2244;
            }
            bool3 = true;
          }
          if (i == 1)
          {
            localObject2 = EndorsementCardBuilder.INSTANCE;
            localObject2 = EndorsementCardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject18, null, paramFissionTransaction);
            if (localObject2 == null) {
              break label2250;
            }
            bool3 = true;
          }
        }
        if (((ByteBuffer)localObject18).get() != 1) {
          break label2256;
        }
        bool5 = true;
        bool4 = bool5;
        if (bool5)
        {
          i = ((ByteBuffer)localObject18).get();
          localObject3 = localFollowCardBuilder;
          bool4 = bool5;
          if (i == 0)
          {
            localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject18);
            localFollowCardBuilder = FollowCardBuilder.INSTANCE;
            localObject3 = FollowCardBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
            if (localObject3 == null) {
              break label2262;
            }
            bool4 = true;
          }
          if (i == 1)
          {
            localObject3 = FollowCardBuilder.INSTANCE;
            localObject3 = FollowCardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject18, null, paramFissionTransaction);
            if (localObject3 == null) {
              break label2268;
            }
            bool4 = true;
          }
        }
        if (((ByteBuffer)localObject18).get() != 1) {
          break label2274;
        }
        bool6 = true;
        bool5 = bool6;
        if (bool6)
        {
          i = ((ByteBuffer)localObject18).get();
          localObject4 = localAggregateFollowCardBuilder;
          bool5 = bool6;
          if (i == 0)
          {
            localObject4 = paramFissionAdapter.readString((ByteBuffer)localObject18);
            localAggregateFollowCardBuilder = AggregateFollowCardBuilder.INSTANCE;
            localObject4 = AggregateFollowCardBuilder.readFromFission(paramFissionAdapter, null, (String)localObject4, paramFissionTransaction);
            if (localObject4 == null) {
              break label2280;
            }
            bool5 = true;
          }
          if (i == 1)
          {
            localObject4 = AggregateFollowCardBuilder.INSTANCE;
            localObject4 = AggregateFollowCardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject18, null, paramFissionTransaction);
            if (localObject4 == null) {
              break label2286;
            }
            bool5 = true;
          }
        }
        if (((ByteBuffer)localObject18).get() != 1) {
          break label2292;
        }
        bool7 = true;
        bool6 = bool7;
        if (bool7)
        {
          i = ((ByteBuffer)localObject18).get();
          localObject5 = localSuggestedActionCardBuilder;
          bool6 = bool7;
          if (i == 0)
          {
            localObject5 = paramFissionAdapter.readString((ByteBuffer)localObject18);
            localSuggestedActionCardBuilder = SuggestedActionCardBuilder.INSTANCE;
            localObject5 = SuggestedActionCardBuilder.readFromFission(paramFissionAdapter, null, (String)localObject5, paramFissionTransaction);
            if (localObject5 == null) {
              break label2298;
            }
            bool6 = true;
          }
          if (i == 1)
          {
            localObject5 = SuggestedActionCardBuilder.INSTANCE;
            localObject5 = SuggestedActionCardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject18, null, paramFissionTransaction);
            if (localObject5 == null) {
              break label2304;
            }
            bool6 = true;
          }
        }
        if (((ByteBuffer)localObject18).get() != 1) {
          break label2310;
        }
        bool8 = true;
        bool7 = bool8;
        if (bool8)
        {
          i = ((ByteBuffer)localObject18).get();
          localObject6 = localSocialActivityCardBuilder;
          bool7 = bool8;
          if (i == 0)
          {
            localObject6 = paramFissionAdapter.readString((ByteBuffer)localObject18);
            localSocialActivityCardBuilder = SocialActivityCardBuilder.INSTANCE;
            localObject6 = SocialActivityCardBuilder.readFromFission(paramFissionAdapter, null, (String)localObject6, paramFissionTransaction);
            if (localObject6 == null) {
              break label2316;
            }
            bool7 = true;
          }
          if (i == 1)
          {
            localObject6 = SocialActivityCardBuilder.INSTANCE;
            localObject6 = SocialActivityCardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject18, null, paramFissionTransaction);
            if (localObject6 == null) {
              break label2322;
            }
            bool7 = true;
          }
        }
        if (((ByteBuffer)localObject18).get() != 1) {
          break label2328;
        }
        bool9 = true;
        bool8 = bool9;
        if (bool9)
        {
          i = ((ByteBuffer)localObject18).get();
          localObject7 = localWvmpProfileViewCardBuilder;
          bool8 = bool9;
          if (i == 0)
          {
            localObject7 = paramFissionAdapter.readString((ByteBuffer)localObject18);
            localWvmpProfileViewCardBuilder = WvmpProfileViewCardBuilder.INSTANCE;
            localObject7 = WvmpProfileViewCardBuilder.readFromFission(paramFissionAdapter, null, (String)localObject7, paramFissionTransaction);
            if (localObject7 == null) {
              break label2334;
            }
            bool8 = true;
          }
          if (i == 1)
          {
            localObject7 = WvmpProfileViewCardBuilder.INSTANCE;
            localObject7 = WvmpProfileViewCardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject18, null, paramFissionTransaction);
            if (localObject7 == null) {
              break label2340;
            }
            bool8 = true;
          }
        }
        if (((ByteBuffer)localObject18).get() != 1) {
          break label2346;
        }
        bool10 = true;
        bool9 = bool10;
        if (bool10)
        {
          i = ((ByteBuffer)localObject18).get();
          localObject8 = localWvmpAnonymousProfileViewCardBuilder;
          bool9 = bool10;
          if (i == 0)
          {
            localObject8 = paramFissionAdapter.readString((ByteBuffer)localObject18);
            localWvmpAnonymousProfileViewCardBuilder = WvmpAnonymousProfileViewCardBuilder.INSTANCE;
            localObject8 = WvmpAnonymousProfileViewCardBuilder.readFromFission(paramFissionAdapter, null, (String)localObject8, paramFissionTransaction);
            if (localObject8 == null) {
              break label2352;
            }
            bool9 = true;
          }
          if (i == 1)
          {
            localObject8 = WvmpAnonymousProfileViewCardBuilder.INSTANCE;
            localObject8 = WvmpAnonymousProfileViewCardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject18, null, paramFissionTransaction);
            if (localObject8 == null) {
              break label2358;
            }
            bool9 = true;
          }
        }
        if (((ByteBuffer)localObject18).get() != 1) {
          break label2364;
        }
        bool11 = true;
        bool10 = bool11;
        if (bool11)
        {
          i = ((ByteBuffer)localObject18).get();
          localObject9 = localWvmpPremiumUpsellCardBuilder;
          bool10 = bool11;
          if (i == 0)
          {
            localObject9 = paramFissionAdapter.readString((ByteBuffer)localObject18);
            localWvmpPremiumUpsellCardBuilder = WvmpPremiumUpsellCardBuilder.INSTANCE;
            localObject9 = WvmpPremiumUpsellCardBuilder.readFromFission(paramFissionAdapter, null, (String)localObject9, paramFissionTransaction);
            if (localObject9 == null) {
              break label2370;
            }
            bool10 = true;
          }
          if (i == 1)
          {
            localObject9 = WvmpPremiumUpsellCardBuilder.INSTANCE;
            localObject9 = WvmpPremiumUpsellCardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject18, null, paramFissionTransaction);
            if (localObject9 == null) {
              break label2376;
            }
            bool10 = true;
          }
        }
        if (((ByteBuffer)localObject18).get() != 1) {
          break label2382;
        }
        bool12 = true;
        bool11 = bool12;
        if (bool12)
        {
          i = ((ByteBuffer)localObject18).get();
          localObject10 = localNewToVoyagerCardBuilder;
          bool11 = bool12;
          if (i == 0)
          {
            localObject10 = paramFissionAdapter.readString((ByteBuffer)localObject18);
            localNewToVoyagerCardBuilder = NewToVoyagerCardBuilder.INSTANCE;
            localObject10 = NewToVoyagerCardBuilder.readFromFission(paramFissionAdapter, null, (String)localObject10, paramFissionTransaction);
            if (localObject10 == null) {
              break label2388;
            }
            bool11 = true;
          }
          if (i == 1)
          {
            localObject10 = NewToVoyagerCardBuilder.INSTANCE;
            localObject10 = NewToVoyagerCardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject18, null, paramFissionTransaction);
            if (localObject10 == null) {
              break label2394;
            }
            bool11 = true;
          }
        }
        if (((ByteBuffer)localObject18).get() != 1) {
          break label2400;
        }
        bool13 = true;
        bool12 = bool13;
        if (bool13)
        {
          i = ((ByteBuffer)localObject18).get();
          localObject11 = localJobUpdateActivityCardBuilder;
          bool12 = bool13;
          if (i == 0)
          {
            localObject11 = paramFissionAdapter.readString((ByteBuffer)localObject18);
            localJobUpdateActivityCardBuilder = JobUpdateActivityCardBuilder.INSTANCE;
            localObject11 = JobUpdateActivityCardBuilder.readFromFission(paramFissionAdapter, null, (String)localObject11, paramFissionTransaction);
            if (localObject11 == null) {
              break label2406;
            }
            bool12 = true;
          }
          if (i == 1)
          {
            localObject11 = JobUpdateActivityCardBuilder.INSTANCE;
            localObject11 = JobUpdateActivityCardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject18, null, paramFissionTransaction);
            if (localObject11 == null) {
              break label2412;
            }
            bool12 = true;
          }
        }
        if (((ByteBuffer)localObject18).get() != 1) {
          break label2418;
        }
        bool14 = true;
        bool13 = bool14;
        if (bool14)
        {
          i = ((ByteBuffer)localObject18).get();
          localObject12 = localSuggestedEditCardBuilder;
          bool13 = bool14;
          if (i == 0)
          {
            localObject12 = paramFissionAdapter.readString((ByteBuffer)localObject18);
            localSuggestedEditCardBuilder = SuggestedEditCardBuilder.INSTANCE;
            localObject12 = SuggestedEditCardBuilder.readFromFission(paramFissionAdapter, null, (String)localObject12, paramFissionTransaction);
            if (localObject12 == null) {
              break label2424;
            }
            bool13 = true;
          }
          if (i == 1)
          {
            localObject12 = SuggestedEditCardBuilder.INSTANCE;
            localObject12 = SuggestedEditCardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject18, null, paramFissionTransaction);
            if (localObject12 == null) {
              break label2430;
            }
            bool13 = true;
          }
        }
        if (((ByteBuffer)localObject18).get() != 1) {
          break label2436;
        }
        bool15 = true;
        bool14 = bool15;
        if (bool15)
        {
          i = ((ByteBuffer)localObject18).get();
          localObject13 = localJymbiiNotificationCardBuilder;
          bool14 = bool15;
          if (i == 0)
          {
            localObject13 = paramFissionAdapter.readString((ByteBuffer)localObject18);
            localJymbiiNotificationCardBuilder = JymbiiNotificationCardBuilder.INSTANCE;
            localObject13 = JymbiiNotificationCardBuilder.readFromFission(paramFissionAdapter, null, (String)localObject13, paramFissionTransaction);
            if (localObject13 == null) {
              break label2442;
            }
            bool14 = true;
          }
          if (i == 1)
          {
            localObject13 = JymbiiNotificationCardBuilder.INSTANCE;
            localObject13 = JymbiiNotificationCardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject18, null, paramFissionTransaction);
            if (localObject13 == null) {
              break label2448;
            }
            bool14 = true;
          }
        }
        if (((ByteBuffer)localObject18).get() != 1) {
          break label2454;
        }
        bool16 = true;
        bool15 = bool16;
        if (bool16)
        {
          i = ((ByteBuffer)localObject18).get();
          localObject14 = localProfinderServiceProposalNotificationCardBuilder;
          bool15 = bool16;
          if (i == 0)
          {
            localObject14 = paramFissionAdapter.readString((ByteBuffer)localObject18);
            localProfinderServiceProposalNotificationCardBuilder = ProfinderServiceProposalNotificationCardBuilder.INSTANCE;
            localObject14 = ProfinderServiceProposalNotificationCardBuilder.readFromFission(paramFissionAdapter, null, (String)localObject14, paramFissionTransaction);
            if (localObject14 == null) {
              break label2460;
            }
            bool15 = true;
          }
          if (i == 1)
          {
            localObject14 = ProfinderServiceProposalNotificationCardBuilder.INSTANCE;
            localObject14 = ProfinderServiceProposalNotificationCardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject18, null, paramFissionTransaction);
            if (localObject14 == null) {
              break label2466;
            }
            bool15 = true;
          }
        }
        if (((ByteBuffer)localObject18).get() != 1) {
          break label2472;
        }
        bool17 = true;
        bool16 = bool17;
        if (bool17)
        {
          i = ((ByteBuffer)localObject18).get();
          localObject15 = localPropCardBuilder;
          bool16 = bool17;
          if (i == 0)
          {
            localObject15 = paramFissionAdapter.readString((ByteBuffer)localObject18);
            localPropCardBuilder = PropCardBuilder.INSTANCE;
            localObject15 = PropCardBuilder.readFromFission(paramFissionAdapter, null, (String)localObject15, paramFissionTransaction);
            if (localObject15 == null) {
              break label2478;
            }
            bool16 = true;
          }
          if (i == 1)
          {
            localObject15 = PropCardBuilder.INSTANCE;
            localObject15 = PropCardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject18, null, paramFissionTransaction);
            if (localObject15 == null) {
              break label2484;
            }
            bool16 = true;
          }
        }
        if (((ByteBuffer)localObject18).get() != 1) {
          break label2490;
        }
        bool18 = true;
        label1960:
        bool17 = bool18;
        if (bool18)
        {
          i = ((ByteBuffer)localObject18).get();
          localObject16 = localAggregatePropCardBuilder;
          bool17 = bool18;
          if (i == 0)
          {
            localObject16 = paramFissionAdapter.readString((ByteBuffer)localObject18);
            localAggregatePropCardBuilder = AggregatePropCardBuilder.INSTANCE;
            localObject16 = AggregatePropCardBuilder.readFromFission(paramFissionAdapter, null, (String)localObject16, paramFissionTransaction);
            if (localObject16 == null) {
              break label2496;
            }
            bool17 = true;
          }
          label2022:
          if (i == 1)
          {
            localObject16 = AggregatePropCardBuilder.INSTANCE;
            localObject16 = AggregatePropCardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject18, null, paramFissionTransaction);
            if (localObject16 == null) {
              break label2502;
            }
            bool17 = true;
          }
        }
        label2051:
        if (((ByteBuffer)localObject18).get() != 1) {
          break label2508;
        }
        bool18 = true;
        label2063:
        bool19 = bool18;
        if (bool18)
        {
          i = ((ByteBuffer)localObject18).get();
          localObject17 = localSocialUpdateAnalyticsCardBuilder;
          if (i == 0)
          {
            localObject17 = paramFissionAdapter.readString((ByteBuffer)localObject18);
            localSocialUpdateAnalyticsCardBuilder = SocialUpdateAnalyticsCardBuilder.INSTANCE;
            localObject17 = SocialUpdateAnalyticsCardBuilder.readFromFission(paramFissionAdapter, null, (String)localObject17, paramFissionTransaction);
            if (localObject17 == null) {
              break label2514;
            }
            bool18 = true;
          }
          label2121:
          bool19 = bool18;
          if (i == 1)
          {
            localObject17 = SocialUpdateAnalyticsCardBuilder.INSTANCE;
            localObject17 = SocialUpdateAnalyticsCardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject18, null, paramFissionTransaction);
            if (localObject17 == null) {
              break label2520;
            }
          }
        }
      }
      label2208:
      label2214:
      label2220:
      label2226:
      label2232:
      label2238:
      label2244:
      label2250:
      label2256:
      label2262:
      label2268:
      label2274:
      label2280:
      label2286:
      label2292:
      label2298:
      label2304:
      label2310:
      label2316:
      label2322:
      label2328:
      label2334:
      label2340:
      label2346:
      label2352:
      label2358:
      label2364:
      label2370:
      label2376:
      label2382:
      label2388:
      label2394:
      label2400:
      label2406:
      label2412:
      label2418:
      label2424:
      label2430:
      label2436:
      label2442:
      label2448:
      label2454:
      label2460:
      label2466:
      label2472:
      label2478:
      label2484:
      label2490:
      label2496:
      label2502:
      label2508:
      label2514:
      label2520:
      for (boolean bool19 = true;; bool19 = false)
      {
        if (paramByteBuffer == null) {
          paramFissionAdapter.recycle((ByteBuffer)localObject18);
        }
        j = 0;
        if (bool1) {
          j = 1;
        }
        i = j;
        if (!bool2) {
          break label2529;
        }
        if (j == 0) {
          break label2526;
        }
        throw new IOException("Found more than 1 member when reading .Value from fission.");
        bool2 = false;
        break;
        bool1 = false;
        break label377;
        bool1 = false;
        break label403;
        bool3 = false;
        break label415;
        bool2 = false;
        break label477;
        bool2 = false;
        break label506;
        bool4 = false;
        break label518;
        bool3 = false;
        break label580;
        bool3 = false;
        break label609;
        bool5 = false;
        break label621;
        bool4 = false;
        break label683;
        bool4 = false;
        break label712;
        bool6 = false;
        break label724;
        bool5 = false;
        break label786;
        bool5 = false;
        break label815;
        bool7 = false;
        break label827;
        bool6 = false;
        break label889;
        bool6 = false;
        break label918;
        bool8 = false;
        break label930;
        bool7 = false;
        break label992;
        bool7 = false;
        break label1021;
        bool9 = false;
        break label1033;
        bool8 = false;
        break label1095;
        bool8 = false;
        break label1124;
        bool10 = false;
        break label1136;
        bool9 = false;
        break label1198;
        bool9 = false;
        break label1227;
        bool11 = false;
        break label1239;
        bool10 = false;
        break label1301;
        bool10 = false;
        break label1330;
        bool12 = false;
        break label1342;
        bool11 = false;
        break label1404;
        bool11 = false;
        break label1433;
        bool13 = false;
        break label1445;
        bool12 = false;
        break label1507;
        bool12 = false;
        break label1536;
        bool14 = false;
        break label1548;
        bool13 = false;
        break label1610;
        bool13 = false;
        break label1639;
        bool15 = false;
        break label1651;
        bool14 = false;
        break label1713;
        bool14 = false;
        break label1742;
        bool16 = false;
        break label1754;
        bool15 = false;
        break label1816;
        bool15 = false;
        break label1845;
        bool17 = false;
        break label1857;
        bool16 = false;
        break label1919;
        bool16 = false;
        break label1948;
        bool18 = false;
        break label1960;
        bool17 = false;
        break label2022;
        bool17 = false;
        break label2051;
        bool18 = false;
        break label2063;
        bool18 = false;
        break label2121;
      }
      label2526:
      int i = 1;
      label2529:
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
      if ((bool19) && (j != 0)) {
        throw new IOException("Found more than 1 member when reading .Value from fission.");
      }
      return new Card.Value(paramString, (AggregateProfileViewCard)localObject1, (EndorsementCard)localObject2, (FollowCard)localObject3, (AggregateFollowCard)localObject4, (SuggestedActionCard)localObject5, (SocialActivityCard)localObject6, (WvmpProfileViewCard)localObject7, (WvmpAnonymousProfileViewCard)localObject8, (WvmpPremiumUpsellCard)localObject9, (NewToVoyagerCard)localObject10, (JobUpdateActivityCard)localObject11, (SuggestedEditCard)localObject12, (JymbiiNotificationCard)localObject13, (ProfinderServiceProposalNotificationCard)localObject14, (PropCard)localObject15, (AggregatePropCard)localObject16, (SocialUpdateAnalyticsCard)localObject17, bool1, bool2, bool3, bool4, bool5, bool6, bool7, bool8, bool9, bool10, bool11, bool12, bool13, bool14, bool15, bool16, bool17, bool19);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.CardBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */