package com.linkedin.android.pegasus.gen.voyager.identity.profile.actions;

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

public final class ProfileActionBuilder
  implements FissileDataModelBuilder<ProfileAction>, DataTemplateBuilder<ProfileAction>
{
  public static final ProfileActionBuilder INSTANCE = new ProfileActionBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("action");
    JSON_KEY_STORE.put("type");
  }
  
  public static ProfileAction build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject = null;
    ActionType localActionType = null;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("action", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = ActionBuilder.INSTANCE;
        localObject = ActionBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("type", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localActionType = (ActionType)paramDataReader.readEnum(ActionType.Builder.INSTANCE);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: action when building com.linkedin.android.pegasus.gen.voyager.identity.profile.actions.ProfileAction");
    }
    return new ProfileAction((ProfileAction.Action)localObject, localActionType, bool2, bool1);
  }
  
  public static ProfileAction readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building ProfileAction");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building ProfileAction");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building ProfileAction");
    }
    if (((ByteBuffer)localObject).getInt() != -1092607694)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building ProfileAction");
    }
    paramString = null;
    ActionBuilder localActionBuilder = null;
    localByteBuffer = null;
    boolean bool1;
    if (((ByteBuffer)localObject).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject).get();
        paramString = localActionBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject);
          localActionBuilder = ActionBuilder.INSTANCE;
          paramString = ActionBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label365;
          }
          bool1 = true;
        }
        label274:
        if (i == 1)
        {
          paramString = ActionBuilder.INSTANCE;
          paramString = ActionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject, null, paramFissionTransaction);
          if (paramString == null) {
            break label371;
          }
          bool1 = true;
        }
      }
      label300:
      if (((ByteBuffer)localObject).get() != 1) {
        break label377;
      }
    }
    label365:
    label371:
    label377:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramFissionTransaction = localByteBuffer;
      if (bool2) {
        paramFissionTransaction = ActionType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject));
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      if (bool1) {
        break label383;
      }
      throw new IOException("Failed to find required field: action when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.actions.ProfileAction from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label274;
      bool1 = false;
      break label300;
    }
    label383:
    return new ProfileAction(paramString, paramFissionTransaction, bool1, bool2);
  }
  
  public static final class ActionBuilder
    implements FissileDataModelBuilder<ProfileAction.Action>, DataTemplateBuilder<ProfileAction.Action>
  {
    public static final ActionBuilder INSTANCE = new ActionBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.voyager.identity.profile.actions.Connect");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.profile.actions.PersonalizedConnect");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.profile.actions.InvitationPending");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.profile.actions.Accept");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.profile.actions.Message");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.profile.actions.Follow");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.profile.actions.SendInMail");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.profile.actions.Disconnect");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.profile.actions.Unfollow");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.profile.actions.Block");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.profile.actions.Report");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.profile.actions.Signup");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.profile.actions.RequestRecommendation");
    }
    
    public static ProfileAction.Action build(DataReader paramDataReader)
      throws DataReaderException
    {
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
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.actions.Connect", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject13 = ConnectBuilder.INSTANCE;
          localObject13 = ConnectBuilder.build(paramDataReader);
          bool13 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.actions.PersonalizedConnect", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject12 = PersonalizedConnectBuilder.INSTANCE;
          localObject12 = PersonalizedConnectBuilder.build(paramDataReader);
          bool12 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.actions.InvitationPending", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject11 = InvitationPendingBuilder.INSTANCE;
          localObject11 = InvitationPendingBuilder.build(paramDataReader);
          bool11 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.actions.Accept", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject10 = AcceptBuilder.INSTANCE;
          localObject10 = AcceptBuilder.build(paramDataReader);
          bool10 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.actions.Message", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject9 = MessageBuilder.INSTANCE;
          localObject9 = MessageBuilder.build(paramDataReader);
          bool9 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.actions.Follow", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject8 = FollowBuilder.INSTANCE;
          localObject8 = FollowBuilder.build(paramDataReader);
          bool8 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.actions.SendInMail", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject7 = SendInMailBuilder.INSTANCE;
          localObject7 = SendInMailBuilder.build(paramDataReader);
          bool7 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.actions.Disconnect", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject6 = DisconnectBuilder.INSTANCE;
          localObject6 = DisconnectBuilder.build(paramDataReader);
          bool6 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.actions.Unfollow", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject5 = UnfollowBuilder.INSTANCE;
          localObject5 = UnfollowBuilder.build(paramDataReader);
          bool5 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.actions.Block", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject4 = BlockBuilder.INSTANCE;
          localObject4 = BlockBuilder.build(paramDataReader);
          bool4 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.actions.Report", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject3 = ReportBuilder.INSTANCE;
          localObject3 = ReportBuilder.build(paramDataReader);
          bool3 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.actions.Signup", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = SignupBuilder.INSTANCE;
          localObject2 = SignupBuilder.build(paramDataReader);
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.actions.RequestRecommendation", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = RequestRecommendationBuilder.INSTANCE;
          localObject1 = RequestRecommendationBuilder.build(paramDataReader);
          bool1 = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
      int j = 0;
      if (bool13) {
        j = 1;
      }
      int i = j;
      if (bool12)
      {
        if (j != 0) {
          throw new DataReaderException("Found more than 1 member when building .Action");
        }
        i = 1;
      }
      j = i;
      if (bool11)
      {
        if (i != 0) {
          throw new DataReaderException("Found more than 1 member when building .Action");
        }
        j = 1;
      }
      i = j;
      if (bool10)
      {
        if (j != 0) {
          throw new DataReaderException("Found more than 1 member when building .Action");
        }
        i = 1;
      }
      j = i;
      if (bool9)
      {
        if (i != 0) {
          throw new DataReaderException("Found more than 1 member when building .Action");
        }
        j = 1;
      }
      i = j;
      if (bool8)
      {
        if (j != 0) {
          throw new DataReaderException("Found more than 1 member when building .Action");
        }
        i = 1;
      }
      j = i;
      if (bool7)
      {
        if (i != 0) {
          throw new DataReaderException("Found more than 1 member when building .Action");
        }
        j = 1;
      }
      i = j;
      if (bool6)
      {
        if (j != 0) {
          throw new DataReaderException("Found more than 1 member when building .Action");
        }
        i = 1;
      }
      j = i;
      if (bool5)
      {
        if (i != 0) {
          throw new DataReaderException("Found more than 1 member when building .Action");
        }
        j = 1;
      }
      i = j;
      if (bool4)
      {
        if (j != 0) {
          throw new DataReaderException("Found more than 1 member when building .Action");
        }
        i = 1;
      }
      j = i;
      if (bool3)
      {
        if (i != 0) {
          throw new DataReaderException("Found more than 1 member when building .Action");
        }
        j = 1;
      }
      i = j;
      if (bool2)
      {
        if (j != 0) {
          throw new DataReaderException("Found more than 1 member when building .Action");
        }
        i = 1;
      }
      if ((bool1) && (i != 0)) {
        throw new DataReaderException("Found more than 1 member when building .Action");
      }
      return new ProfileAction.Action((Connect)localObject13, (PersonalizedConnect)localObject12, (InvitationPending)localObject11, (Accept)localObject10, (Message)localObject9, (Follow)localObject8, (SendInMail)localObject7, (Disconnect)localObject6, (Unfollow)localObject5, (Block)localObject4, (Report)localObject3, (Signup)localObject2, (RequestRecommendation)localObject1, bool13, bool12, bool11, bool10, bool9, bool8, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
    }
    
    public static ProfileAction.Action readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building ProfileAction.Action");
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
            localObject13 = paramString;
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
        throw new IOException("Invalid header prefix. Can't read cached data when building ProfileAction.Action");
      }
      Object localObject13 = localObject1;
      if (((ByteBuffer)localObject1).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("Invalid header prefix. Can't read cached data when building ProfileAction.Action");
      }
      if (((ByteBuffer)localObject13).getInt() != 1578514363)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject13);
        throw new IOException("UID mismatch. Can't read cached data when building ProfileAction.Action");
      }
      paramString = null;
      ConnectBuilder localConnectBuilder = null;
      localObject1 = null;
      PersonalizedConnectBuilder localPersonalizedConnectBuilder = null;
      Object localObject2 = null;
      InvitationPendingBuilder localInvitationPendingBuilder = null;
      Object localObject3 = null;
      AcceptBuilder localAcceptBuilder = null;
      Object localObject4 = null;
      MessageBuilder localMessageBuilder = null;
      Object localObject5 = null;
      FollowBuilder localFollowBuilder = null;
      Object localObject6 = null;
      SendInMailBuilder localSendInMailBuilder = null;
      Object localObject7 = null;
      DisconnectBuilder localDisconnectBuilder = null;
      Object localObject8 = null;
      UnfollowBuilder localUnfollowBuilder = null;
      Object localObject9 = null;
      BlockBuilder localBlockBuilder = null;
      Object localObject10 = null;
      ReportBuilder localReportBuilder = null;
      Object localObject11 = null;
      SignupBuilder localSignupBuilder = null;
      Object localObject12 = null;
      RequestRecommendationBuilder localRequestRecommendationBuilder = null;
      boolean bool2;
      boolean bool1;
      label343:
      label369:
      boolean bool3;
      label381:
      label443:
      label472:
      boolean bool4;
      label484:
      label546:
      label575:
      boolean bool5;
      label587:
      label649:
      label678:
      boolean bool6;
      label690:
      label752:
      label781:
      boolean bool7;
      label793:
      label855:
      label884:
      boolean bool8;
      label896:
      label958:
      label987:
      boolean bool9;
      label999:
      label1061:
      label1090:
      boolean bool10;
      label1102:
      label1164:
      label1193:
      boolean bool11;
      label1205:
      label1267:
      label1296:
      boolean bool12;
      label1308:
      label1370:
      label1399:
      boolean bool13;
      if (((ByteBuffer)localObject13).get() == 1)
      {
        bool2 = true;
        bool1 = bool2;
        if (bool2)
        {
          i = ((ByteBuffer)localObject13).get();
          paramString = localConnectBuilder;
          bool1 = bool2;
          if (i == 0)
          {
            paramString = paramFissionAdapter.readString((ByteBuffer)localObject13);
            localConnectBuilder = ConnectBuilder.INSTANCE;
            paramString = ConnectBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label1659;
            }
            bool1 = true;
          }
          if (i == 1)
          {
            paramString = ConnectBuilder.INSTANCE;
            paramString = ConnectBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject13, null, paramFissionTransaction);
            if (paramString == null) {
              break label1665;
            }
            bool1 = true;
          }
        }
        if (((ByteBuffer)localObject13).get() != 1) {
          break label1671;
        }
        bool3 = true;
        bool2 = bool3;
        if (bool3)
        {
          i = ((ByteBuffer)localObject13).get();
          localObject1 = localPersonalizedConnectBuilder;
          bool2 = bool3;
          if (i == 0)
          {
            localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject13);
            localPersonalizedConnectBuilder = PersonalizedConnectBuilder.INSTANCE;
            localObject1 = PersonalizedConnectBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
            if (localObject1 == null) {
              break label1677;
            }
            bool2 = true;
          }
          if (i == 1)
          {
            localObject1 = PersonalizedConnectBuilder.INSTANCE;
            localObject1 = PersonalizedConnectBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject13, null, paramFissionTransaction);
            if (localObject1 == null) {
              break label1683;
            }
            bool2 = true;
          }
        }
        if (((ByteBuffer)localObject13).get() != 1) {
          break label1689;
        }
        bool4 = true;
        bool3 = bool4;
        if (bool4)
        {
          i = ((ByteBuffer)localObject13).get();
          localObject2 = localInvitationPendingBuilder;
          bool3 = bool4;
          if (i == 0)
          {
            localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject13);
            localInvitationPendingBuilder = InvitationPendingBuilder.INSTANCE;
            localObject2 = InvitationPendingBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
            if (localObject2 == null) {
              break label1695;
            }
            bool3 = true;
          }
          if (i == 1)
          {
            localObject2 = InvitationPendingBuilder.INSTANCE;
            localObject2 = InvitationPendingBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject13, null, paramFissionTransaction);
            if (localObject2 == null) {
              break label1701;
            }
            bool3 = true;
          }
        }
        if (((ByteBuffer)localObject13).get() != 1) {
          break label1707;
        }
        bool5 = true;
        bool4 = bool5;
        if (bool5)
        {
          i = ((ByteBuffer)localObject13).get();
          localObject3 = localAcceptBuilder;
          bool4 = bool5;
          if (i == 0)
          {
            localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject13);
            localAcceptBuilder = AcceptBuilder.INSTANCE;
            localObject3 = AcceptBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
            if (localObject3 == null) {
              break label1713;
            }
            bool4 = true;
          }
          if (i == 1)
          {
            localObject3 = AcceptBuilder.INSTANCE;
            localObject3 = AcceptBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject13, null, paramFissionTransaction);
            if (localObject3 == null) {
              break label1719;
            }
            bool4 = true;
          }
        }
        if (((ByteBuffer)localObject13).get() != 1) {
          break label1725;
        }
        bool6 = true;
        bool5 = bool6;
        if (bool6)
        {
          i = ((ByteBuffer)localObject13).get();
          localObject4 = localMessageBuilder;
          bool5 = bool6;
          if (i == 0)
          {
            localObject4 = paramFissionAdapter.readString((ByteBuffer)localObject13);
            localMessageBuilder = MessageBuilder.INSTANCE;
            localObject4 = MessageBuilder.readFromFission(paramFissionAdapter, null, (String)localObject4, paramFissionTransaction);
            if (localObject4 == null) {
              break label1731;
            }
            bool5 = true;
          }
          if (i == 1)
          {
            localObject4 = MessageBuilder.INSTANCE;
            localObject4 = MessageBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject13, null, paramFissionTransaction);
            if (localObject4 == null) {
              break label1737;
            }
            bool5 = true;
          }
        }
        if (((ByteBuffer)localObject13).get() != 1) {
          break label1743;
        }
        bool7 = true;
        bool6 = bool7;
        if (bool7)
        {
          i = ((ByteBuffer)localObject13).get();
          localObject5 = localFollowBuilder;
          bool6 = bool7;
          if (i == 0)
          {
            localObject5 = paramFissionAdapter.readString((ByteBuffer)localObject13);
            localFollowBuilder = FollowBuilder.INSTANCE;
            localObject5 = FollowBuilder.readFromFission(paramFissionAdapter, null, (String)localObject5, paramFissionTransaction);
            if (localObject5 == null) {
              break label1749;
            }
            bool6 = true;
          }
          if (i == 1)
          {
            localObject5 = FollowBuilder.INSTANCE;
            localObject5 = FollowBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject13, null, paramFissionTransaction);
            if (localObject5 == null) {
              break label1755;
            }
            bool6 = true;
          }
        }
        if (((ByteBuffer)localObject13).get() != 1) {
          break label1761;
        }
        bool8 = true;
        bool7 = bool8;
        if (bool8)
        {
          i = ((ByteBuffer)localObject13).get();
          localObject6 = localSendInMailBuilder;
          bool7 = bool8;
          if (i == 0)
          {
            localObject6 = paramFissionAdapter.readString((ByteBuffer)localObject13);
            localSendInMailBuilder = SendInMailBuilder.INSTANCE;
            localObject6 = SendInMailBuilder.readFromFission(paramFissionAdapter, null, (String)localObject6, paramFissionTransaction);
            if (localObject6 == null) {
              break label1767;
            }
            bool7 = true;
          }
          if (i == 1)
          {
            localObject6 = SendInMailBuilder.INSTANCE;
            localObject6 = SendInMailBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject13, null, paramFissionTransaction);
            if (localObject6 == null) {
              break label1773;
            }
            bool7 = true;
          }
        }
        if (((ByteBuffer)localObject13).get() != 1) {
          break label1779;
        }
        bool9 = true;
        bool8 = bool9;
        if (bool9)
        {
          i = ((ByteBuffer)localObject13).get();
          localObject7 = localDisconnectBuilder;
          bool8 = bool9;
          if (i == 0)
          {
            localObject7 = paramFissionAdapter.readString((ByteBuffer)localObject13);
            localDisconnectBuilder = DisconnectBuilder.INSTANCE;
            localObject7 = DisconnectBuilder.readFromFission(paramFissionAdapter, null, (String)localObject7, paramFissionTransaction);
            if (localObject7 == null) {
              break label1785;
            }
            bool8 = true;
          }
          if (i == 1)
          {
            localObject7 = DisconnectBuilder.INSTANCE;
            localObject7 = DisconnectBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject13, null, paramFissionTransaction);
            if (localObject7 == null) {
              break label1791;
            }
            bool8 = true;
          }
        }
        if (((ByteBuffer)localObject13).get() != 1) {
          break label1797;
        }
        bool10 = true;
        bool9 = bool10;
        if (bool10)
        {
          i = ((ByteBuffer)localObject13).get();
          localObject8 = localUnfollowBuilder;
          bool9 = bool10;
          if (i == 0)
          {
            localObject8 = paramFissionAdapter.readString((ByteBuffer)localObject13);
            localUnfollowBuilder = UnfollowBuilder.INSTANCE;
            localObject8 = UnfollowBuilder.readFromFission(paramFissionAdapter, null, (String)localObject8, paramFissionTransaction);
            if (localObject8 == null) {
              break label1803;
            }
            bool9 = true;
          }
          if (i == 1)
          {
            localObject8 = UnfollowBuilder.INSTANCE;
            localObject8 = UnfollowBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject13, null, paramFissionTransaction);
            if (localObject8 == null) {
              break label1809;
            }
            bool9 = true;
          }
        }
        if (((ByteBuffer)localObject13).get() != 1) {
          break label1815;
        }
        bool11 = true;
        bool10 = bool11;
        if (bool11)
        {
          i = ((ByteBuffer)localObject13).get();
          localObject9 = localBlockBuilder;
          bool10 = bool11;
          if (i == 0)
          {
            localObject9 = paramFissionAdapter.readString((ByteBuffer)localObject13);
            localBlockBuilder = BlockBuilder.INSTANCE;
            localObject9 = BlockBuilder.readFromFission(paramFissionAdapter, null, (String)localObject9, paramFissionTransaction);
            if (localObject9 == null) {
              break label1821;
            }
            bool10 = true;
          }
          if (i == 1)
          {
            localObject9 = BlockBuilder.INSTANCE;
            localObject9 = BlockBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject13, null, paramFissionTransaction);
            if (localObject9 == null) {
              break label1827;
            }
            bool10 = true;
          }
        }
        if (((ByteBuffer)localObject13).get() != 1) {
          break label1833;
        }
        bool12 = true;
        bool11 = bool12;
        if (bool12)
        {
          i = ((ByteBuffer)localObject13).get();
          localObject10 = localReportBuilder;
          bool11 = bool12;
          if (i == 0)
          {
            localObject10 = paramFissionAdapter.readString((ByteBuffer)localObject13);
            localReportBuilder = ReportBuilder.INSTANCE;
            localObject10 = ReportBuilder.readFromFission(paramFissionAdapter, null, (String)localObject10, paramFissionTransaction);
            if (localObject10 == null) {
              break label1839;
            }
            bool11 = true;
          }
          if (i == 1)
          {
            localObject10 = ReportBuilder.INSTANCE;
            localObject10 = ReportBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject13, null, paramFissionTransaction);
            if (localObject10 == null) {
              break label1845;
            }
            bool11 = true;
          }
        }
        if (((ByteBuffer)localObject13).get() != 1) {
          break label1851;
        }
        bool13 = true;
        label1411:
        bool12 = bool13;
        if (bool13)
        {
          i = ((ByteBuffer)localObject13).get();
          localObject11 = localSignupBuilder;
          bool12 = bool13;
          if (i == 0)
          {
            localObject11 = paramFissionAdapter.readString((ByteBuffer)localObject13);
            localSignupBuilder = SignupBuilder.INSTANCE;
            localObject11 = SignupBuilder.readFromFission(paramFissionAdapter, null, (String)localObject11, paramFissionTransaction);
            if (localObject11 == null) {
              break label1857;
            }
            bool12 = true;
          }
          label1473:
          if (i == 1)
          {
            localObject11 = SignupBuilder.INSTANCE;
            localObject11 = SignupBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject13, null, paramFissionTransaction);
            if (localObject11 == null) {
              break label1863;
            }
            bool12 = true;
          }
        }
        label1502:
        if (((ByteBuffer)localObject13).get() != 1) {
          break label1869;
        }
        bool13 = true;
        label1514:
        bool14 = bool13;
        if (bool13)
        {
          i = ((ByteBuffer)localObject13).get();
          localObject12 = localRequestRecommendationBuilder;
          if (i == 0)
          {
            localObject12 = paramFissionAdapter.readString((ByteBuffer)localObject13);
            localRequestRecommendationBuilder = RequestRecommendationBuilder.INSTANCE;
            localObject12 = RequestRecommendationBuilder.readFromFission(paramFissionAdapter, null, (String)localObject12, paramFissionTransaction);
            if (localObject12 == null) {
              break label1875;
            }
            bool13 = true;
          }
          label1572:
          bool14 = bool13;
          if (i == 1)
          {
            localObject12 = RequestRecommendationBuilder.INSTANCE;
            localObject12 = RequestRecommendationBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject13, null, paramFissionTransaction);
            if (localObject12 == null) {
              break label1881;
            }
          }
        }
      }
      label1659:
      label1665:
      label1671:
      label1677:
      label1683:
      label1689:
      label1695:
      label1701:
      label1707:
      label1713:
      label1719:
      label1725:
      label1731:
      label1737:
      label1743:
      label1749:
      label1755:
      label1761:
      label1767:
      label1773:
      label1779:
      label1785:
      label1791:
      label1797:
      label1803:
      label1809:
      label1815:
      label1821:
      label1827:
      label1833:
      label1839:
      label1845:
      label1851:
      label1857:
      label1863:
      label1869:
      label1875:
      label1881:
      for (boolean bool14 = true;; bool14 = false)
      {
        if (paramByteBuffer == null) {
          paramFissionAdapter.recycle((ByteBuffer)localObject13);
        }
        j = 0;
        if (bool1) {
          j = 1;
        }
        i = j;
        if (!bool2) {
          break label1890;
        }
        if (j == 0) {
          break label1887;
        }
        throw new IOException("Found more than 1 member when reading .Action from fission.");
        bool2 = false;
        break;
        bool1 = false;
        break label343;
        bool1 = false;
        break label369;
        bool3 = false;
        break label381;
        bool2 = false;
        break label443;
        bool2 = false;
        break label472;
        bool4 = false;
        break label484;
        bool3 = false;
        break label546;
        bool3 = false;
        break label575;
        bool5 = false;
        break label587;
        bool4 = false;
        break label649;
        bool4 = false;
        break label678;
        bool6 = false;
        break label690;
        bool5 = false;
        break label752;
        bool5 = false;
        break label781;
        bool7 = false;
        break label793;
        bool6 = false;
        break label855;
        bool6 = false;
        break label884;
        bool8 = false;
        break label896;
        bool7 = false;
        break label958;
        bool7 = false;
        break label987;
        bool9 = false;
        break label999;
        bool8 = false;
        break label1061;
        bool8 = false;
        break label1090;
        bool10 = false;
        break label1102;
        bool9 = false;
        break label1164;
        bool9 = false;
        break label1193;
        bool11 = false;
        break label1205;
        bool10 = false;
        break label1267;
        bool10 = false;
        break label1296;
        bool12 = false;
        break label1308;
        bool11 = false;
        break label1370;
        bool11 = false;
        break label1399;
        bool13 = false;
        break label1411;
        bool12 = false;
        break label1473;
        bool12 = false;
        break label1502;
        bool13 = false;
        break label1514;
        bool13 = false;
        break label1572;
      }
      label1887:
      int i = 1;
      label1890:
      int j = i;
      if (bool3)
      {
        if (i != 0) {
          throw new IOException("Found more than 1 member when reading .Action from fission.");
        }
        j = 1;
      }
      i = j;
      if (bool4)
      {
        if (j != 0) {
          throw new IOException("Found more than 1 member when reading .Action from fission.");
        }
        i = 1;
      }
      j = i;
      if (bool5)
      {
        if (i != 0) {
          throw new IOException("Found more than 1 member when reading .Action from fission.");
        }
        j = 1;
      }
      i = j;
      if (bool6)
      {
        if (j != 0) {
          throw new IOException("Found more than 1 member when reading .Action from fission.");
        }
        i = 1;
      }
      j = i;
      if (bool7)
      {
        if (i != 0) {
          throw new IOException("Found more than 1 member when reading .Action from fission.");
        }
        j = 1;
      }
      i = j;
      if (bool8)
      {
        if (j != 0) {
          throw new IOException("Found more than 1 member when reading .Action from fission.");
        }
        i = 1;
      }
      j = i;
      if (bool9)
      {
        if (i != 0) {
          throw new IOException("Found more than 1 member when reading .Action from fission.");
        }
        j = 1;
      }
      i = j;
      if (bool10)
      {
        if (j != 0) {
          throw new IOException("Found more than 1 member when reading .Action from fission.");
        }
        i = 1;
      }
      j = i;
      if (bool11)
      {
        if (i != 0) {
          throw new IOException("Found more than 1 member when reading .Action from fission.");
        }
        j = 1;
      }
      i = j;
      if (bool12)
      {
        if (j != 0) {
          throw new IOException("Found more than 1 member when reading .Action from fission.");
        }
        i = 1;
      }
      if ((bool14) && (i != 0)) {
        throw new IOException("Found more than 1 member when reading .Action from fission.");
      }
      return new ProfileAction.Action(paramString, (PersonalizedConnect)localObject1, (InvitationPending)localObject2, (Accept)localObject3, (Message)localObject4, (Follow)localObject5, (SendInMail)localObject6, (Disconnect)localObject7, (Unfollow)localObject8, (Block)localObject9, (Report)localObject10, (Signup)localObject11, (RequestRecommendation)localObject12, bool1, bool2, bool3, bool4, bool5, bool6, bool7, bool8, bool9, bool10, bool11, bool12, bool14);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.actions.ProfileActionBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */