package com.linkedin.android.pegasus.gen.voyager.premium.onboarding;

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

public final class PremiumOnboardingCardBuilder$CardBuilder
  implements FissileDataModelBuilder<PremiumOnboardingCard.Card>, DataTemplateBuilder<PremiumOnboardingCard.Card>
{
  public static final CardBuilder INSTANCE = new CardBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("com.linkedin.voyager.premium.onboarding.WelcomeCard");
    JSON_KEY_STORE.put("com.linkedin.voyager.premium.onboarding.JobCard");
    JSON_KEY_STORE.put("com.linkedin.voyager.premium.onboarding.InMailCard");
    JSON_KEY_STORE.put("com.linkedin.voyager.premium.onboarding.FeaturedApplicantCard");
    JSON_KEY_STORE.put("com.linkedin.voyager.premium.onboarding.WvmpCard");
    JSON_KEY_STORE.put("com.linkedin.voyager.premium.onboarding.SearchCard");
    JSON_KEY_STORE.put("com.linkedin.voyager.premium.onboarding.LaunchCard");
  }
  
  public static PremiumOnboardingCard.Card build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject7 = null;
    Object localObject6 = null;
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.premium.onboarding.WelcomeCard", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject7 = WelcomeCardBuilder.INSTANCE;
        localObject7 = WelcomeCardBuilder.build(paramDataReader);
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.premium.onboarding.JobCard", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject6 = JobCardBuilder.INSTANCE;
        localObject6 = JobCardBuilder.build(paramDataReader);
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.premium.onboarding.InMailCard", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject5 = InMailCardBuilder.INSTANCE;
        localObject5 = InMailCardBuilder.build(paramDataReader);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.premium.onboarding.FeaturedApplicantCard", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = FeaturedApplicantCardBuilder.INSTANCE;
        localObject4 = FeaturedApplicantCardBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.premium.onboarding.WvmpCard", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = WvmpCardBuilder.INSTANCE;
        localObject3 = WvmpCardBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.premium.onboarding.SearchCard", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = SearchCardBuilder.INSTANCE;
        localObject2 = SearchCardBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.premium.onboarding.LaunchCard", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = LaunchCardBuilder.INSTANCE;
        localObject1 = LaunchCardBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    int j = 0;
    if (bool7) {
      j = 1;
    }
    int i = j;
    if (bool6)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .Card");
      }
      i = 1;
    }
    j = i;
    if (bool5)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .Card");
      }
      j = 1;
    }
    i = j;
    if (bool4)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .Card");
      }
      i = 1;
    }
    j = i;
    if (bool3)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .Card");
      }
      j = 1;
    }
    i = j;
    if (bool2)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .Card");
      }
      i = 1;
    }
    if ((bool1) && (i != 0)) {
      throw new DataReaderException("Found more than 1 member when building .Card");
    }
    return new PremiumOnboardingCard.Card((WelcomeCard)localObject7, (JobCard)localObject6, (InMailCard)localObject5, (FeaturedApplicantCard)localObject4, (WvmpCard)localObject3, (SearchCard)localObject2, (LaunchCard)localObject1, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static PremiumOnboardingCard.Card readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building PremiumOnboardingCard.Card");
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
          localObject7 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building PremiumOnboardingCard.Card");
    }
    Object localObject7 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building PremiumOnboardingCard.Card");
    }
    if (((ByteBuffer)localObject7).getInt() != 1015118541)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject7);
      throw new IOException("UID mismatch. Can't read cached data when building PremiumOnboardingCard.Card");
    }
    paramString = null;
    WelcomeCardBuilder localWelcomeCardBuilder = null;
    localObject1 = null;
    JobCardBuilder localJobCardBuilder = null;
    Object localObject2 = null;
    InMailCardBuilder localInMailCardBuilder = null;
    Object localObject3 = null;
    FeaturedApplicantCardBuilder localFeaturedApplicantCardBuilder = null;
    Object localObject4 = null;
    WvmpCardBuilder localWvmpCardBuilder = null;
    Object localObject5 = null;
    SearchCardBuilder localSearchCardBuilder = null;
    Object localObject6 = null;
    LaunchCardBuilder localLaunchCardBuilder = null;
    boolean bool2;
    boolean bool1;
    label307:
    label333:
    boolean bool3;
    label345:
    label407:
    label436:
    boolean bool4;
    label448:
    label510:
    label539:
    boolean bool5;
    label551:
    label613:
    label642:
    boolean bool6;
    label654:
    label716:
    label745:
    boolean bool7;
    if (((ByteBuffer)localObject7).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject7).get();
        paramString = localWelcomeCardBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject7);
          localWelcomeCardBuilder = WelcomeCardBuilder.INSTANCE;
          paramString = WelcomeCardBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label1004;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = WelcomeCardBuilder.INSTANCE;
          paramString = WelcomeCardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject7, null, paramFissionTransaction);
          if (paramString == null) {
            break label1010;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject7).get() != 1) {
        break label1016;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject7).get();
        localObject1 = localJobCardBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject7);
          localJobCardBuilder = JobCardBuilder.INSTANCE;
          localObject1 = JobCardBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label1022;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject1 = JobCardBuilder.INSTANCE;
          localObject1 = JobCardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject7, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label1028;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject7).get() != 1) {
        break label1034;
      }
      bool4 = true;
      bool3 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject7).get();
        localObject2 = localInMailCardBuilder;
        bool3 = bool4;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject7);
          localInMailCardBuilder = InMailCardBuilder.INSTANCE;
          localObject2 = InMailCardBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label1040;
          }
          bool3 = true;
        }
        if (i == 1)
        {
          localObject2 = InMailCardBuilder.INSTANCE;
          localObject2 = InMailCardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject7, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label1046;
          }
          bool3 = true;
        }
      }
      if (((ByteBuffer)localObject7).get() != 1) {
        break label1052;
      }
      bool5 = true;
      bool4 = bool5;
      if (bool5)
      {
        i = ((ByteBuffer)localObject7).get();
        localObject3 = localFeaturedApplicantCardBuilder;
        bool4 = bool5;
        if (i == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject7);
          localFeaturedApplicantCardBuilder = FeaturedApplicantCardBuilder.INSTANCE;
          localObject3 = FeaturedApplicantCardBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label1058;
          }
          bool4 = true;
        }
        if (i == 1)
        {
          localObject3 = FeaturedApplicantCardBuilder.INSTANCE;
          localObject3 = FeaturedApplicantCardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject7, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label1064;
          }
          bool4 = true;
        }
      }
      if (((ByteBuffer)localObject7).get() != 1) {
        break label1070;
      }
      bool6 = true;
      bool5 = bool6;
      if (bool6)
      {
        i = ((ByteBuffer)localObject7).get();
        localObject4 = localWvmpCardBuilder;
        bool5 = bool6;
        if (i == 0)
        {
          localObject4 = paramFissionAdapter.readString((ByteBuffer)localObject7);
          localWvmpCardBuilder = WvmpCardBuilder.INSTANCE;
          localObject4 = WvmpCardBuilder.readFromFission(paramFissionAdapter, null, (String)localObject4, paramFissionTransaction);
          if (localObject4 == null) {
            break label1076;
          }
          bool5 = true;
        }
        if (i == 1)
        {
          localObject4 = WvmpCardBuilder.INSTANCE;
          localObject4 = WvmpCardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject7, null, paramFissionTransaction);
          if (localObject4 == null) {
            break label1082;
          }
          bool5 = true;
        }
      }
      if (((ByteBuffer)localObject7).get() != 1) {
        break label1088;
      }
      bool7 = true;
      label757:
      bool6 = bool7;
      if (bool7)
      {
        i = ((ByteBuffer)localObject7).get();
        localObject5 = localSearchCardBuilder;
        bool6 = bool7;
        if (i == 0)
        {
          localObject5 = paramFissionAdapter.readString((ByteBuffer)localObject7);
          localSearchCardBuilder = SearchCardBuilder.INSTANCE;
          localObject5 = SearchCardBuilder.readFromFission(paramFissionAdapter, null, (String)localObject5, paramFissionTransaction);
          if (localObject5 == null) {
            break label1094;
          }
          bool6 = true;
        }
        label819:
        if (i == 1)
        {
          localObject5 = SearchCardBuilder.INSTANCE;
          localObject5 = SearchCardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject7, null, paramFissionTransaction);
          if (localObject5 == null) {
            break label1100;
          }
          bool6 = true;
        }
      }
      label848:
      if (((ByteBuffer)localObject7).get() != 1) {
        break label1106;
      }
      bool7 = true;
      label860:
      bool8 = bool7;
      if (bool7)
      {
        i = ((ByteBuffer)localObject7).get();
        localObject6 = localLaunchCardBuilder;
        if (i == 0)
        {
          localObject6 = paramFissionAdapter.readString((ByteBuffer)localObject7);
          localLaunchCardBuilder = LaunchCardBuilder.INSTANCE;
          localObject6 = LaunchCardBuilder.readFromFission(paramFissionAdapter, null, (String)localObject6, paramFissionTransaction);
          if (localObject6 == null) {
            break label1112;
          }
          bool7 = true;
        }
        label918:
        bool8 = bool7;
        if (i == 1)
        {
          localObject6 = LaunchCardBuilder.INSTANCE;
          localObject6 = LaunchCardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject7, null, paramFissionTransaction);
          if (localObject6 == null) {
            break label1118;
          }
        }
      }
    }
    label1004:
    label1010:
    label1016:
    label1022:
    label1028:
    label1034:
    label1040:
    label1046:
    label1052:
    label1058:
    label1064:
    label1070:
    label1076:
    label1082:
    label1088:
    label1094:
    label1100:
    label1106:
    label1112:
    label1118:
    for (boolean bool8 = true;; bool8 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject7);
      }
      j = 0;
      if (bool1) {
        j = 1;
      }
      i = j;
      if (!bool2) {
        break label1127;
      }
      if (j == 0) {
        break label1124;
      }
      throw new IOException("Found more than 1 member when reading .Card from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label307;
      bool1 = false;
      break label333;
      bool3 = false;
      break label345;
      bool2 = false;
      break label407;
      bool2 = false;
      break label436;
      bool4 = false;
      break label448;
      bool3 = false;
      break label510;
      bool3 = false;
      break label539;
      bool5 = false;
      break label551;
      bool4 = false;
      break label613;
      bool4 = false;
      break label642;
      bool6 = false;
      break label654;
      bool5 = false;
      break label716;
      bool5 = false;
      break label745;
      bool7 = false;
      break label757;
      bool6 = false;
      break label819;
      bool6 = false;
      break label848;
      bool7 = false;
      break label860;
      bool7 = false;
      break label918;
    }
    label1124:
    int i = 1;
    label1127:
    int j = i;
    if (bool3)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading .Card from fission.");
      }
      j = 1;
    }
    i = j;
    if (bool4)
    {
      if (j != 0) {
        throw new IOException("Found more than 1 member when reading .Card from fission.");
      }
      i = 1;
    }
    j = i;
    if (bool5)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading .Card from fission.");
      }
      j = 1;
    }
    i = j;
    if (bool6)
    {
      if (j != 0) {
        throw new IOException("Found more than 1 member when reading .Card from fission.");
      }
      i = 1;
    }
    if ((bool8) && (i != 0)) {
      throw new IOException("Found more than 1 member when reading .Card from fission.");
    }
    return new PremiumOnboardingCard.Card(paramString, (JobCard)localObject1, (InMailCard)localObject2, (FeaturedApplicantCard)localObject3, (WvmpCard)localObject4, (SearchCard)localObject5, (LaunchCard)localObject6, bool1, bool2, bool3, bool4, bool5, bool6, bool8);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.premium.onboarding.PremiumOnboardingCardBuilder.CardBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */