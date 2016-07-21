package com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.prompts.PremiumUpsellPrompt;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.prompts.PremiumUpsellPromptBuilder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.prompts.SingleTextPrompt;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.prompts.SingleTextPromptBuilder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.prompts.SuggestedEndorsementPrompt;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.prompts.SuggestedEndorsementPromptBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ProfilePromotionBuilder$PromptBuilder
  implements FissileDataModelBuilder<ProfilePromotion.Prompt>, DataTemplateBuilder<ProfilePromotion.Prompt>
{
  public static final PromptBuilder INSTANCE = new PromptBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("com.linkedin.voyager.identity.profile.promotions.prompts.SuggestedEndorsementPrompt");
    JSON_KEY_STORE.put("com.linkedin.voyager.identity.profile.promotions.prompts.SingleTextPrompt");
    JSON_KEY_STORE.put("com.linkedin.voyager.identity.profile.promotions.prompts.PremiumUpsellPrompt");
  }
  
  public static ProfilePromotion.Prompt build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.promotions.prompts.SuggestedEndorsementPrompt", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = SuggestedEndorsementPromptBuilder.INSTANCE;
        localObject3 = SuggestedEndorsementPromptBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.promotions.prompts.SingleTextPrompt", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = SingleTextPromptBuilder.INSTANCE;
        localObject2 = SingleTextPromptBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.promotions.prompts.PremiumUpsellPrompt", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = PremiumUpsellPromptBuilder.INSTANCE;
        localObject1 = PremiumUpsellPromptBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    int i = 0;
    if (bool3) {
      i = 1;
    }
    int j = i;
    if (bool2)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .Prompt");
      }
      j = 1;
    }
    if ((bool1) && (j != 0)) {
      throw new DataReaderException("Found more than 1 member when building .Prompt");
    }
    return new ProfilePromotion.Prompt((SuggestedEndorsementPrompt)localObject3, (SingleTextPrompt)localObject2, (PremiumUpsellPrompt)localObject1, bool3, bool2, bool1);
  }
  
  public static ProfilePromotion.Prompt readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building ProfilePromotion.Prompt");
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
      do
      {
        do
        {
          localObject3 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building ProfilePromotion.Prompt");
    }
    Object localObject3 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building ProfilePromotion.Prompt");
    }
    if (((ByteBuffer)localObject3).getInt() != -2122678209)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject3);
      throw new IOException("UID mismatch. Can't read cached data when building ProfilePromotion.Prompt");
    }
    paramString = null;
    SuggestedEndorsementPromptBuilder localSuggestedEndorsementPromptBuilder = null;
    localObject1 = null;
    SingleTextPromptBuilder localSingleTextPromptBuilder = null;
    Object localObject2 = null;
    PremiumUpsellPromptBuilder localPremiumUpsellPromptBuilder = null;
    boolean bool2;
    boolean bool1;
    label283:
    label309:
    boolean bool3;
    if (((ByteBuffer)localObject3).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject3).get();
        paramString = localSuggestedEndorsementPromptBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localSuggestedEndorsementPromptBuilder = SuggestedEndorsementPromptBuilder.INSTANCE;
          paramString = SuggestedEndorsementPromptBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label568;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = SuggestedEndorsementPromptBuilder.INSTANCE;
          paramString = SuggestedEndorsementPromptBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (paramString == null) {
            break label574;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label580;
      }
      bool3 = true;
      label321:
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject3).get();
        localObject1 = localSingleTextPromptBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localSingleTextPromptBuilder = SingleTextPromptBuilder.INSTANCE;
          localObject1 = SingleTextPromptBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label586;
          }
          bool2 = true;
        }
        label383:
        if (i == 1)
        {
          localObject1 = SingleTextPromptBuilder.INSTANCE;
          localObject1 = SingleTextPromptBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label592;
          }
          bool2 = true;
        }
      }
      label412:
      if (((ByteBuffer)localObject3).get() != 1) {
        break label598;
      }
      bool3 = true;
      label424:
      bool4 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject3).get();
        localObject2 = localPremiumUpsellPromptBuilder;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localPremiumUpsellPromptBuilder = PremiumUpsellPromptBuilder.INSTANCE;
          localObject2 = PremiumUpsellPromptBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label604;
          }
          bool3 = true;
        }
        label482:
        bool4 = bool3;
        if (i == 1)
        {
          localObject2 = PremiumUpsellPromptBuilder.INSTANCE;
          localObject2 = PremiumUpsellPromptBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label610;
          }
        }
      }
    }
    label568:
    label574:
    label580:
    label586:
    label592:
    label598:
    label604:
    label610:
    for (boolean bool4 = true;; bool4 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject3);
      }
      i = 0;
      if (bool1) {
        i = 1;
      }
      j = i;
      if (!bool2) {
        break label619;
      }
      if (i == 0) {
        break label616;
      }
      throw new IOException("Found more than 1 member when reading .Prompt from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label283;
      bool1 = false;
      break label309;
      bool3 = false;
      break label321;
      bool2 = false;
      break label383;
      bool2 = false;
      break label412;
      bool3 = false;
      break label424;
      bool3 = false;
      break label482;
    }
    label616:
    int j = 1;
    label619:
    if ((bool4) && (j != 0)) {
      throw new IOException("Found more than 1 member when reading .Prompt from fission.");
    }
    return new ProfilePromotion.Prompt(paramString, (SingleTextPrompt)localObject1, (PremiumUpsellPrompt)localObject2, bool1, bool2, bool4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.ProfilePromotionBuilder.PromptBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */