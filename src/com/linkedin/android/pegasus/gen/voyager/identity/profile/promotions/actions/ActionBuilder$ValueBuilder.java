package com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.actions;

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

public final class ActionBuilder$ValueBuilder
  implements FissileDataModelBuilder<Action.Value>, DataTemplateBuilder<Action.Value>
{
  public static final ValueBuilder INSTANCE = new ValueBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("com.linkedin.voyager.identity.profile.promotions.actions.Dismiss");
    JSON_KEY_STORE.put("com.linkedin.voyager.identity.profile.promotions.actions.Message");
    JSON_KEY_STORE.put("com.linkedin.voyager.identity.profile.promotions.actions.AcceptSuggestedEndorsements");
    JSON_KEY_STORE.put("com.linkedin.voyager.identity.profile.promotions.actions.RejectSuggestedEndorsements");
    JSON_KEY_STORE.put("com.linkedin.voyager.identity.profile.promotions.actions.UpgradeToPremium");
  }
  
  public static Action.Value build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.promotions.actions.Dismiss", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject5 = DismissBuilder.INSTANCE;
        localObject5 = DismissBuilder.build(paramDataReader);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.promotions.actions.Message", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = MessageBuilder.INSTANCE;
        localObject4 = MessageBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.promotions.actions.AcceptSuggestedEndorsements", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = AcceptSuggestedEndorsementsBuilder.INSTANCE;
        localObject3 = AcceptSuggestedEndorsementsBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.promotions.actions.RejectSuggestedEndorsements", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = RejectSuggestedEndorsementsBuilder.INSTANCE;
        localObject2 = RejectSuggestedEndorsementsBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.promotions.actions.UpgradeToPremium", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = UpgradeToPremiumBuilder.INSTANCE;
        localObject1 = UpgradeToPremiumBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    int j = 0;
    if (bool5) {
      j = 1;
    }
    int i = j;
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
    return new Action.Value((Dismiss)localObject5, (Message)localObject4, (AcceptSuggestedEndorsements)localObject3, (RejectSuggestedEndorsements)localObject2, (UpgradeToPremium)localObject1, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static Action.Value readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Action.Value");
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
          localObject5 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building Action.Value");
    }
    Object localObject5 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building Action.Value");
    }
    if (((ByteBuffer)localObject5).getInt() != 780843706)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject5);
      throw new IOException("UID mismatch. Can't read cached data when building Action.Value");
    }
    paramString = null;
    DismissBuilder localDismissBuilder = null;
    localObject1 = null;
    MessageBuilder localMessageBuilder = null;
    Object localObject2 = null;
    AcceptSuggestedEndorsementsBuilder localAcceptSuggestedEndorsementsBuilder = null;
    Object localObject3 = null;
    RejectSuggestedEndorsementsBuilder localRejectSuggestedEndorsementsBuilder = null;
    Object localObject4 = null;
    UpgradeToPremiumBuilder localUpgradeToPremiumBuilder = null;
    boolean bool2;
    boolean bool1;
    label295:
    label321:
    boolean bool3;
    label333:
    label395:
    label424:
    boolean bool4;
    label436:
    label498:
    label527:
    boolean bool5;
    if (((ByteBuffer)localObject5).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject5).get();
        paramString = localDismissBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localDismissBuilder = DismissBuilder.INSTANCE;
          paramString = DismissBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label786;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = DismissBuilder.INSTANCE;
          paramString = DismissBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (paramString == null) {
            break label792;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label798;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject5).get();
        localObject1 = localMessageBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localMessageBuilder = MessageBuilder.INSTANCE;
          localObject1 = MessageBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label804;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject1 = MessageBuilder.INSTANCE;
          localObject1 = MessageBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label810;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label816;
      }
      bool4 = true;
      bool3 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject5).get();
        localObject2 = localAcceptSuggestedEndorsementsBuilder;
        bool3 = bool4;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localAcceptSuggestedEndorsementsBuilder = AcceptSuggestedEndorsementsBuilder.INSTANCE;
          localObject2 = AcceptSuggestedEndorsementsBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label822;
          }
          bool3 = true;
        }
        if (i == 1)
        {
          localObject2 = AcceptSuggestedEndorsementsBuilder.INSTANCE;
          localObject2 = AcceptSuggestedEndorsementsBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label828;
          }
          bool3 = true;
        }
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label834;
      }
      bool5 = true;
      label539:
      bool4 = bool5;
      if (bool5)
      {
        i = ((ByteBuffer)localObject5).get();
        localObject3 = localRejectSuggestedEndorsementsBuilder;
        bool4 = bool5;
        if (i == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localRejectSuggestedEndorsementsBuilder = RejectSuggestedEndorsementsBuilder.INSTANCE;
          localObject3 = RejectSuggestedEndorsementsBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label840;
          }
          bool4 = true;
        }
        label601:
        if (i == 1)
        {
          localObject3 = RejectSuggestedEndorsementsBuilder.INSTANCE;
          localObject3 = RejectSuggestedEndorsementsBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label846;
          }
          bool4 = true;
        }
      }
      label630:
      if (((ByteBuffer)localObject5).get() != 1) {
        break label852;
      }
      bool5 = true;
      label642:
      bool6 = bool5;
      if (bool5)
      {
        i = ((ByteBuffer)localObject5).get();
        localObject4 = localUpgradeToPremiumBuilder;
        if (i == 0)
        {
          localObject4 = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localUpgradeToPremiumBuilder = UpgradeToPremiumBuilder.INSTANCE;
          localObject4 = UpgradeToPremiumBuilder.readFromFission(paramFissionAdapter, null, (String)localObject4, paramFissionTransaction);
          if (localObject4 == null) {
            break label858;
          }
          bool5 = true;
        }
        label700:
        bool6 = bool5;
        if (i == 1)
        {
          localObject4 = UpgradeToPremiumBuilder.INSTANCE;
          localObject4 = UpgradeToPremiumBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (localObject4 == null) {
            break label864;
          }
        }
      }
    }
    label786:
    label792:
    label798:
    label804:
    label810:
    label816:
    label822:
    label828:
    label834:
    label840:
    label846:
    label852:
    label858:
    label864:
    for (boolean bool6 = true;; bool6 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject5);
      }
      j = 0;
      if (bool1) {
        j = 1;
      }
      i = j;
      if (!bool2) {
        break label873;
      }
      if (j == 0) {
        break label870;
      }
      throw new IOException("Found more than 1 member when reading .Value from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label295;
      bool1 = false;
      break label321;
      bool3 = false;
      break label333;
      bool2 = false;
      break label395;
      bool2 = false;
      break label424;
      bool4 = false;
      break label436;
      bool3 = false;
      break label498;
      bool3 = false;
      break label527;
      bool5 = false;
      break label539;
      bool4 = false;
      break label601;
      bool4 = false;
      break label630;
      bool5 = false;
      break label642;
      bool5 = false;
      break label700;
    }
    label870:
    int i = 1;
    label873:
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
    if ((bool6) && (i != 0)) {
      throw new IOException("Found more than 1 member when reading .Value from fission.");
    }
    return new Action.Value(paramString, (Message)localObject1, (AcceptSuggestedEndorsements)localObject2, (RejectSuggestedEndorsements)localObject3, (UpgradeToPremium)localObject4, bool1, bool2, bool3, bool4, bool6);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.actions.ActionBuilder.ValueBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */