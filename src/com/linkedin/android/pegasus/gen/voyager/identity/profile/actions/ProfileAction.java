package com.linkedin.android.pegasus.gen.voyager.identity.profile.actions;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.data.lite.UnionMemberCountException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ProfileAction
  implements FissileDataModel<ProfileAction>, RecordTemplate<ProfileAction>
{
  public static final ProfileActionBuilder BUILDER = ProfileActionBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final Action action;
  public final boolean hasAction;
  public final boolean hasType;
  public final ActionType type;
  
  ProfileAction(Action paramAction, ActionType paramActionType, boolean paramBoolean1, boolean paramBoolean2)
  {
    action = paramAction;
    type = paramActionType;
    hasAction = paramBoolean1;
    hasType = paramBoolean2;
    _cachedId = null;
  }
  
  public final ProfileAction accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Action localAction = null;
    boolean bool = false;
    if (hasAction)
    {
      paramDataProcessor.startRecordField$505cff1c("action");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label118;
      }
      localAction = action.accept(paramDataProcessor);
      if (localAction == null) {
        break label135;
      }
    }
    label118:
    label135:
    for (bool = true;; bool = false)
    {
      if (hasType)
      {
        paramDataProcessor.startRecordField$505cff1c("type");
        paramDataProcessor.processEnum(type);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label158;
      }
      try
      {
        if (hasAction) {
          break label140;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.actions.ProfileAction", "action");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localAction = (Action)paramDataProcessor.processDataTemplate(action);
      break;
    }
    label140:
    return new ProfileAction(localAction, type, bool, hasType);
    label158:
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (ProfileAction)paramObject;
      if (action != null)
      {
        if (action.equals(action)) {}
      }
      else {
        while (action != null) {
          return false;
        }
      }
      if (type == null) {
        break;
      }
    } while (type.equals(type));
    for (;;)
    {
      return false;
      if (type == null) {
        break;
      }
    }
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasAction) {
      if (action._cachedId == null) {
        break label75;
      }
    }
    label75:
    for (i = PegasusBinaryUtils.getEncodedLength(action._cachedId) + 9;; i = action.getSerializedSize() + 7)
    {
      int j = i + 1;
      i = j;
      if (hasType) {
        i = j + 2;
      }
      __sizeOfObject = i;
      return i;
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (action != null) {}
    for (int i = action.hashCode();; i = 0)
    {
      if (type != null) {
        j = type.hashCode();
      }
      i = (i + 527) * 31 + j;
      _cachedHashCode = i;
      return i;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public final void writeToFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, boolean paramBoolean, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    paramFissionAdapter.willWriteModel$30d0b508(this, paramBoolean);
    String str = _cachedId;
    if ((str == null) && (paramString == null) && (paramByteBuffer == null)) {
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building ProfileAction");
    }
    if (paramBoolean)
    {
      if (paramString != null) {
        paramFissionAdapter.writeToCache(paramString, null, 0, paramFissionTransaction);
      }
      if (str != null) {
        paramFissionAdapter.writeToCache(str, null, 0, paramFissionTransaction);
      }
    }
    label267:
    label275:
    label277:
    do
    {
      ByteBuffer localByteBuffer;
      for (;;)
      {
        return;
        localByteBuffer = paramByteBuffer;
        if (paramByteBuffer == null) {
          localByteBuffer = paramFissionAdapter.getBuffer(getSerializedSize());
        }
        localByteBuffer.put((byte)1);
        localByteBuffer.putInt(-1092607694);
        if (hasAction)
        {
          localByteBuffer.put((byte)1);
          if (action._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, action._cachedId);
            action.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasType) {
              break label267;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, type.ordinal());
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label275;
          }
          if (str != null) {
            break label277;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          action.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
        }
      }
      paramFissionAdapter.writeToCache(str, localByteBuffer, getSerializedSize(), paramFissionTransaction);
      paramFissionAdapter.recycle(localByteBuffer);
    } while ((paramString == null) || (str.equals(paramString)));
    int i = PegasusBinaryUtils.getEncodedLength(str) + 3;
    paramByteBuffer = paramFissionAdapter.getBuffer(i);
    paramByteBuffer.put((byte)0);
    paramFissionAdapter.writeString(paramByteBuffer, str);
    paramFissionAdapter.writeToCache(paramString, paramByteBuffer, i, paramFissionTransaction);
    paramFissionAdapter.recycle(paramByteBuffer);
  }
  
  public static final class Action
    implements FissileDataModel<Action>, UnionTemplate<Action>
  {
    public static final ProfileActionBuilder.ActionBuilder BUILDER = ProfileActionBuilder.ActionBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final Accept acceptValue;
    public final Block blockValue;
    public final Connect connectValue;
    public final Disconnect disconnectValue;
    public final Follow followValue;
    public final boolean hasAcceptValue;
    public final boolean hasBlockValue;
    public final boolean hasConnectValue;
    public final boolean hasDisconnectValue;
    public final boolean hasFollowValue;
    public final boolean hasInvitationPendingValue;
    public final boolean hasMessageValue;
    public final boolean hasPersonalizedConnectValue;
    public final boolean hasReportValue;
    public final boolean hasRequestRecommendationValue;
    public final boolean hasSendInMailValue;
    public final boolean hasSignupValue;
    public final boolean hasUnfollowValue;
    public final InvitationPending invitationPendingValue;
    public final Message messageValue;
    public final PersonalizedConnect personalizedConnectValue;
    public final Report reportValue;
    public final RequestRecommendation requestRecommendationValue;
    public final SendInMail sendInMailValue;
    public final Signup signupValue;
    public final Unfollow unfollowValue;
    
    Action(Connect paramConnect, PersonalizedConnect paramPersonalizedConnect, InvitationPending paramInvitationPending, Accept paramAccept, Message paramMessage, Follow paramFollow, SendInMail paramSendInMail, Disconnect paramDisconnect, Unfollow paramUnfollow, Block paramBlock, Report paramReport, Signup paramSignup, RequestRecommendation paramRequestRecommendation, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13)
    {
      connectValue = paramConnect;
      personalizedConnectValue = paramPersonalizedConnect;
      invitationPendingValue = paramInvitationPending;
      acceptValue = paramAccept;
      messageValue = paramMessage;
      followValue = paramFollow;
      sendInMailValue = paramSendInMail;
      disconnectValue = paramDisconnect;
      unfollowValue = paramUnfollow;
      blockValue = paramBlock;
      reportValue = paramReport;
      signupValue = paramSignup;
      requestRecommendationValue = paramRequestRecommendation;
      hasConnectValue = paramBoolean1;
      hasPersonalizedConnectValue = paramBoolean2;
      hasInvitationPendingValue = paramBoolean3;
      hasAcceptValue = paramBoolean4;
      hasMessageValue = paramBoolean5;
      hasFollowValue = paramBoolean6;
      hasSendInMailValue = paramBoolean7;
      hasDisconnectValue = paramBoolean8;
      hasUnfollowValue = paramBoolean9;
      hasBlockValue = paramBoolean10;
      hasReportValue = paramBoolean11;
      hasSignupValue = paramBoolean12;
      hasRequestRecommendationValue = paramBoolean13;
      _cachedId = null;
    }
    
    public final Action accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      Object localObject2 = null;
      boolean bool1 = false;
      Object localObject1;
      label56:
      Object localObject3;
      boolean bool2;
      label95:
      label106:
      Object localObject4;
      boolean bool3;
      label142:
      label154:
      Object localObject5;
      boolean bool4;
      label190:
      label202:
      Object localObject6;
      boolean bool5;
      label238:
      label250:
      Object localObject7;
      boolean bool6;
      label286:
      label298:
      Object localObject8;
      boolean bool7;
      label338:
      label350:
      Object localObject9;
      boolean bool8;
      label386:
      label398:
      Object localObject10;
      boolean bool9;
      label434:
      label446:
      Object localObject11;
      boolean bool10;
      label482:
      label494:
      Object localObject12;
      boolean bool11;
      label530:
      label542:
      Object localObject13;
      boolean bool12;
      if (hasConnectValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.actions.Connect");
        if (paramDataProcessor.shouldAcceptTransitively())
        {
          localObject1 = connectValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label725;
          }
          bool1 = true;
          localObject2 = localObject1;
        }
      }
      else
      {
        localObject3 = null;
        bool2 = false;
        if (hasPersonalizedConnectValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.actions.PersonalizedConnect");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label734;
          }
          localObject1 = personalizedConnectValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label752;
          }
          bool2 = true;
          localObject3 = localObject1;
        }
        localObject4 = null;
        bool3 = false;
        if (hasInvitationPendingValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.actions.InvitationPending");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label761;
          }
          localObject1 = InvitationPending.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label779;
          }
          bool3 = true;
          localObject4 = localObject1;
        }
        localObject5 = null;
        bool4 = false;
        if (hasAcceptValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.actions.Accept");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label789;
          }
          localObject1 = Accept.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label807;
          }
          bool4 = true;
          localObject5 = localObject1;
        }
        localObject6 = null;
        bool5 = false;
        if (hasMessageValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.actions.Message");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label817;
          }
          localObject1 = Message.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label835;
          }
          bool5 = true;
          localObject6 = localObject1;
        }
        localObject7 = null;
        bool6 = false;
        if (hasFollowValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.actions.Follow");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label845;
          }
          localObject1 = Follow.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label863;
          }
          bool6 = true;
          localObject7 = localObject1;
        }
        localObject8 = null;
        bool7 = false;
        if (hasSendInMailValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.actions.SendInMail");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label873;
          }
          localObject1 = sendInMailValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label891;
          }
          bool7 = true;
          localObject8 = localObject1;
        }
        localObject9 = null;
        bool8 = false;
        if (hasDisconnectValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.actions.Disconnect");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label901;
          }
          localObject1 = Disconnect.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label919;
          }
          bool8 = true;
          localObject9 = localObject1;
        }
        localObject10 = null;
        bool9 = false;
        if (hasUnfollowValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.actions.Unfollow");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label929;
          }
          localObject1 = Unfollow.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label947;
          }
          bool9 = true;
          localObject10 = localObject1;
        }
        localObject11 = null;
        bool10 = false;
        if (hasBlockValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.actions.Block");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label957;
          }
          localObject1 = Block.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label975;
          }
          bool10 = true;
          localObject11 = localObject1;
        }
        localObject12 = null;
        bool11 = false;
        if (hasReportValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.actions.Report");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label985;
          }
          localObject1 = Report.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label1003;
          }
          bool11 = true;
          localObject12 = localObject1;
        }
        localObject13 = null;
        bool12 = false;
        if (hasSignupValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.actions.Signup");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label1013;
          }
          localObject1 = Signup.accept(paramDataProcessor);
          label578:
          if (localObject1 == null) {
            break label1031;
          }
          bool12 = true;
          localObject13 = localObject1;
        }
        label590:
        localObject1 = null;
        bool13 = false;
        if (hasRequestRecommendationValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.identity.profile.actions.RequestRecommendation");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label1041;
          }
          localObject1 = RequestRecommendation.accept(paramDataProcessor);
          label626:
          if (localObject1 == null) {
            break label1059;
          }
        }
      }
      label725:
      label734:
      label752:
      label761:
      label779:
      label789:
      label807:
      label817:
      label835:
      label845:
      label863:
      label873:
      label891:
      label901:
      label919:
      label929:
      label947:
      label957:
      label975:
      label985:
      label1003:
      label1013:
      label1031:
      label1041:
      label1059:
      for (boolean bool13 = true;; bool13 = false)
      {
        paramDataProcessor.endUnion();
        if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
          break label1065;
        }
        return new Action((Connect)localObject2, (PersonalizedConnect)localObject3, (InvitationPending)localObject4, (Accept)localObject5, (Message)localObject6, (Follow)localObject7, (SendInMail)localObject8, (Disconnect)localObject9, (Unfollow)localObject10, (Block)localObject11, (Report)localObject12, (Signup)localObject13, (RequestRecommendation)localObject1, bool1, bool2, bool3, bool4, bool5, bool6, bool7, bool8, bool9, bool10, bool11, bool12, bool13);
        localObject1 = (Connect)paramDataProcessor.processDataTemplate(connectValue);
        break;
        bool1 = false;
        localObject2 = localObject1;
        break label56;
        localObject1 = (PersonalizedConnect)paramDataProcessor.processDataTemplate(personalizedConnectValue);
        break label95;
        bool2 = false;
        localObject3 = localObject1;
        break label106;
        localObject1 = (InvitationPending)paramDataProcessor.processDataTemplate(invitationPendingValue);
        break label142;
        bool3 = false;
        localObject4 = localObject1;
        break label154;
        localObject1 = (Accept)paramDataProcessor.processDataTemplate(acceptValue);
        break label190;
        bool4 = false;
        localObject5 = localObject1;
        break label202;
        localObject1 = (Message)paramDataProcessor.processDataTemplate(messageValue);
        break label238;
        bool5 = false;
        localObject6 = localObject1;
        break label250;
        localObject1 = (Follow)paramDataProcessor.processDataTemplate(followValue);
        break label286;
        bool6 = false;
        localObject7 = localObject1;
        break label298;
        localObject1 = (SendInMail)paramDataProcessor.processDataTemplate(sendInMailValue);
        break label338;
        bool7 = false;
        localObject8 = localObject1;
        break label350;
        localObject1 = (Disconnect)paramDataProcessor.processDataTemplate(disconnectValue);
        break label386;
        bool8 = false;
        localObject9 = localObject1;
        break label398;
        localObject1 = (Unfollow)paramDataProcessor.processDataTemplate(unfollowValue);
        break label434;
        bool9 = false;
        localObject10 = localObject1;
        break label446;
        localObject1 = (Block)paramDataProcessor.processDataTemplate(blockValue);
        break label482;
        bool10 = false;
        localObject11 = localObject1;
        break label494;
        localObject1 = (Report)paramDataProcessor.processDataTemplate(reportValue);
        break label530;
        bool11 = false;
        localObject12 = localObject1;
        break label542;
        localObject1 = (Signup)paramDataProcessor.processDataTemplate(signupValue);
        break label578;
        bool12 = false;
        localObject13 = localObject1;
        break label590;
        localObject1 = (RequestRecommendation)paramDataProcessor.processDataTemplate(requestRecommendationValue);
        break label626;
      }
      label1065:
      return null;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (Action)paramObject;
        if (connectValue != null)
        {
          if (connectValue.equals(connectValue)) {}
        }
        else {
          while (connectValue != null) {
            return false;
          }
        }
        if (personalizedConnectValue != null)
        {
          if (personalizedConnectValue.equals(personalizedConnectValue)) {}
        }
        else {
          while (personalizedConnectValue != null) {
            return false;
          }
        }
        if (invitationPendingValue != null)
        {
          if (invitationPendingValue.equals(invitationPendingValue)) {}
        }
        else {
          while (invitationPendingValue != null) {
            return false;
          }
        }
        if (acceptValue != null)
        {
          if (acceptValue.equals(acceptValue)) {}
        }
        else {
          while (acceptValue != null) {
            return false;
          }
        }
        if (messageValue != null)
        {
          if (messageValue.equals(messageValue)) {}
        }
        else {
          while (messageValue != null) {
            return false;
          }
        }
        if (followValue != null)
        {
          if (followValue.equals(followValue)) {}
        }
        else {
          while (followValue != null) {
            return false;
          }
        }
        if (sendInMailValue != null)
        {
          if (sendInMailValue.equals(sendInMailValue)) {}
        }
        else {
          while (sendInMailValue != null) {
            return false;
          }
        }
        if (disconnectValue != null)
        {
          if (disconnectValue.equals(disconnectValue)) {}
        }
        else {
          while (disconnectValue != null) {
            return false;
          }
        }
        if (unfollowValue != null)
        {
          if (unfollowValue.equals(unfollowValue)) {}
        }
        else {
          while (unfollowValue != null) {
            return false;
          }
        }
        if (blockValue != null)
        {
          if (blockValue.equals(blockValue)) {}
        }
        else {
          while (blockValue != null) {
            return false;
          }
        }
        if (reportValue != null)
        {
          if (reportValue.equals(reportValue)) {}
        }
        else {
          while (reportValue != null) {
            return false;
          }
        }
        if (signupValue != null)
        {
          if (signupValue.equals(signupValue)) {}
        }
        else {
          while (signupValue != null) {
            return false;
          }
        }
        if (requestRecommendationValue == null) {
          break;
        }
      } while (requestRecommendationValue.equals(requestRecommendationValue));
      for (;;)
      {
        return false;
        if (requestRecommendationValue == null) {
          break;
        }
      }
    }
    
    public final int getSerializedSize()
    {
      if (__sizeOfObject > 0) {
        return __sizeOfObject;
      }
      int i = 0 + 1 + 4 + 1;
      if (hasConnectValue)
      {
        if (connectValue._cachedId != null) {
          i = PegasusBinaryUtils.getEncodedLength(connectValue._cachedId) + 9;
        }
      }
      else
      {
        int j = i + 1;
        i = j;
        if (hasPersonalizedConnectValue)
        {
          i = j + 1;
          if (personalizedConnectValue._cachedId == null) {
            break label576;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(personalizedConnectValue._cachedId);
        }
        label93:
        j = i + 1;
        i = j;
        if (hasInvitationPendingValue)
        {
          i = j + 1;
          if (invitationPendingValue._cachedId == null) {
            break label589;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(invitationPendingValue._cachedId);
        }
        label135:
        j = i + 1;
        i = j;
        if (hasAcceptValue)
        {
          i = j + 1;
          if (acceptValue._cachedId == null) {
            break label602;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(acceptValue._cachedId);
        }
        label177:
        j = i + 1;
        i = j;
        if (hasMessageValue)
        {
          i = j + 1;
          if (messageValue._cachedId == null) {
            break label615;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(messageValue._cachedId);
        }
        label219:
        j = i + 1;
        i = j;
        if (hasFollowValue)
        {
          i = j + 1;
          if (followValue._cachedId == null) {
            break label628;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(followValue._cachedId);
        }
        label261:
        j = i + 1;
        i = j;
        if (hasSendInMailValue)
        {
          i = j + 1;
          if (sendInMailValue._cachedId == null) {
            break label641;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(sendInMailValue._cachedId);
        }
        label303:
        j = i + 1;
        i = j;
        if (hasDisconnectValue)
        {
          i = j + 1;
          if (disconnectValue._cachedId == null) {
            break label654;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(disconnectValue._cachedId);
        }
        label345:
        j = i + 1;
        i = j;
        if (hasUnfollowValue)
        {
          i = j + 1;
          if (unfollowValue._cachedId == null) {
            break label667;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(unfollowValue._cachedId);
        }
        label387:
        j = i + 1;
        i = j;
        if (hasBlockValue)
        {
          i = j + 1;
          if (blockValue._cachedId == null) {
            break label680;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(blockValue._cachedId);
        }
        label429:
        j = i + 1;
        i = j;
        if (hasReportValue)
        {
          i = j + 1;
          if (reportValue._cachedId == null) {
            break label693;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(reportValue._cachedId);
        }
        label471:
        j = i + 1;
        i = j;
        if (hasSignupValue)
        {
          i = j + 1;
          if (signupValue._cachedId == null) {
            break label706;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(signupValue._cachedId);
        }
        label513:
        j = i + 1;
        i = j;
        if (hasRequestRecommendationValue)
        {
          i = j + 1;
          if (requestRecommendationValue._cachedId == null) {
            break label719;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(requestRecommendationValue._cachedId);
        }
      }
      for (;;)
      {
        __sizeOfObject = i;
        return i;
        i = connectValue.getSerializedSize() + 7;
        break;
        label576:
        i += personalizedConnectValue.getSerializedSize();
        break label93;
        label589:
        i += invitationPendingValue.getSerializedSize();
        break label135;
        label602:
        i += acceptValue.getSerializedSize();
        break label177;
        label615:
        i += messageValue.getSerializedSize();
        break label219;
        label628:
        i += followValue.getSerializedSize();
        break label261;
        label641:
        i += sendInMailValue.getSerializedSize();
        break label303;
        label654:
        i += disconnectValue.getSerializedSize();
        break label345;
        label667:
        i += unfollowValue.getSerializedSize();
        break label387;
        label680:
        i += blockValue.getSerializedSize();
        break label429;
        label693:
        i += reportValue.getSerializedSize();
        break label471;
        label706:
        i += signupValue.getSerializedSize();
        break label513;
        label719:
        i += requestRecommendationValue.getSerializedSize();
      }
    }
    
    public final int hashCode()
    {
      int i8 = 0;
      if (_cachedHashCode > 0) {
        return _cachedHashCode;
      }
      int i;
      int j;
      label45:
      int k;
      label60:
      int m;
      label76:
      int n;
      label92:
      int i1;
      label108:
      int i2;
      label124:
      int i3;
      label140:
      int i4;
      label156:
      int i5;
      label172:
      int i6;
      if (connectValue != null)
      {
        i = connectValue.hashCode();
        if (personalizedConnectValue == null) {
          break label308;
        }
        j = personalizedConnectValue.hashCode();
        if (invitationPendingValue == null) {
          break label313;
        }
        k = invitationPendingValue.hashCode();
        if (acceptValue == null) {
          break label318;
        }
        m = acceptValue.hashCode();
        if (messageValue == null) {
          break label324;
        }
        n = messageValue.hashCode();
        if (followValue == null) {
          break label330;
        }
        i1 = followValue.hashCode();
        if (sendInMailValue == null) {
          break label336;
        }
        i2 = sendInMailValue.hashCode();
        if (disconnectValue == null) {
          break label342;
        }
        i3 = disconnectValue.hashCode();
        if (unfollowValue == null) {
          break label348;
        }
        i4 = unfollowValue.hashCode();
        if (blockValue == null) {
          break label354;
        }
        i5 = blockValue.hashCode();
        if (reportValue == null) {
          break label360;
        }
        i6 = reportValue.hashCode();
        label188:
        if (signupValue == null) {
          break label366;
        }
      }
      label308:
      label313:
      label318:
      label324:
      label330:
      label336:
      label342:
      label348:
      label354:
      label360:
      label366:
      for (int i7 = signupValue.hashCode();; i7 = 0)
      {
        if (requestRecommendationValue != null) {
          i8 = requestRecommendationValue.hashCode();
        }
        i = (i7 + (i6 + (i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i8;
        _cachedHashCode = i;
        return i;
        i = 0;
        break;
        j = 0;
        break label45;
        k = 0;
        break label60;
        m = 0;
        break label76;
        n = 0;
        break label92;
        i1 = 0;
        break label108;
        i2 = 0;
        break label124;
        i3 = 0;
        break label140;
        i4 = 0;
        break label156;
        i5 = 0;
        break label172;
        i6 = 0;
        break label188;
      }
    }
    
    public final String id()
    {
      return _cachedId;
    }
    
    public final void writeToFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, boolean paramBoolean, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      paramFissionAdapter.willWriteModel$30d0b508(this, paramBoolean);
      String str = _cachedId;
      if ((str == null) && (paramString == null) && (paramByteBuffer == null)) {
        throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Action");
      }
      if (paramBoolean)
      {
        if (paramString != null) {
          paramFissionAdapter.writeToCache(paramString, null, 0, paramFissionTransaction);
        }
        if (str != null) {
          paramFissionAdapter.writeToCache(str, null, 0, paramFissionTransaction);
        }
      }
      label232:
      label292:
      label352:
      label412:
      label472:
      label532:
      label592:
      label652:
      label712:
      label772:
      label832:
      label960:
      label985:
      label995:
      label1020:
      label1030:
      label1055:
      label1065:
      label1090:
      label1100:
      label1125:
      label1135:
      label1160:
      label1170:
      label1195:
      label1205:
      label1230:
      label1240:
      label1265:
      label1275:
      label1300:
      label1310:
      label1335:
      label1345:
      label1370:
      label1378:
      label1380:
      do
      {
        ByteBuffer localByteBuffer;
        for (;;)
        {
          return;
          localByteBuffer = paramByteBuffer;
          if (paramByteBuffer == null) {
            localByteBuffer = paramFissionAdapter.getBuffer(getSerializedSize());
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(1578514363);
          if (hasConnectValue)
          {
            localByteBuffer.put((byte)1);
            if (connectValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, connectValue._cachedId);
              connectValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasPersonalizedConnectValue) {
                break label985;
              }
              localByteBuffer.put((byte)1);
              if (personalizedConnectValue._cachedId == null) {
                break label960;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, personalizedConnectValue._cachedId);
              personalizedConnectValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasInvitationPendingValue) {
                break label1020;
              }
              localByteBuffer.put((byte)1);
              if (invitationPendingValue._cachedId == null) {
                break label995;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, invitationPendingValue._cachedId);
              invitationPendingValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasAcceptValue) {
                break label1055;
              }
              localByteBuffer.put((byte)1);
              if (acceptValue._cachedId == null) {
                break label1030;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, acceptValue._cachedId);
              acceptValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasMessageValue) {
                break label1090;
              }
              localByteBuffer.put((byte)1);
              if (messageValue._cachedId == null) {
                break label1065;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, messageValue._cachedId);
              messageValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasFollowValue) {
                break label1125;
              }
              localByteBuffer.put((byte)1);
              if (followValue._cachedId == null) {
                break label1100;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, followValue._cachedId);
              followValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasSendInMailValue) {
                break label1160;
              }
              localByteBuffer.put((byte)1);
              if (sendInMailValue._cachedId == null) {
                break label1135;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, sendInMailValue._cachedId);
              sendInMailValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasDisconnectValue) {
                break label1195;
              }
              localByteBuffer.put((byte)1);
              if (disconnectValue._cachedId == null) {
                break label1170;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, disconnectValue._cachedId);
              disconnectValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasUnfollowValue) {
                break label1230;
              }
              localByteBuffer.put((byte)1);
              if (unfollowValue._cachedId == null) {
                break label1205;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, unfollowValue._cachedId);
              unfollowValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasBlockValue) {
                break label1265;
              }
              localByteBuffer.put((byte)1);
              if (blockValue._cachedId == null) {
                break label1240;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, blockValue._cachedId);
              blockValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasReportValue) {
                break label1300;
              }
              localByteBuffer.put((byte)1);
              if (reportValue._cachedId == null) {
                break label1275;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, reportValue._cachedId);
              reportValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasSignupValue) {
                break label1335;
              }
              localByteBuffer.put((byte)1);
              if (signupValue._cachedId == null) {
                break label1310;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, signupValue._cachedId);
              signupValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasRequestRecommendationValue) {
                break label1370;
              }
              localByteBuffer.put((byte)1);
              if (requestRecommendationValue._cachedId == null) {
                break label1345;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, requestRecommendationValue._cachedId);
              requestRecommendationValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
          }
          for (;;)
          {
            if (paramByteBuffer != null) {
              break label1378;
            }
            if (str != null) {
              break label1380;
            }
            paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
            paramFissionAdapter.recycle(localByteBuffer);
            return;
            localByteBuffer.put((byte)1);
            connectValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            personalizedConnectValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label232;
            localByteBuffer.put((byte)0);
            break label232;
            localByteBuffer.put((byte)1);
            invitationPendingValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label292;
            localByteBuffer.put((byte)0);
            break label292;
            localByteBuffer.put((byte)1);
            acceptValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label352;
            localByteBuffer.put((byte)0);
            break label352;
            localByteBuffer.put((byte)1);
            messageValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label412;
            localByteBuffer.put((byte)0);
            break label412;
            localByteBuffer.put((byte)1);
            followValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label472;
            localByteBuffer.put((byte)0);
            break label472;
            localByteBuffer.put((byte)1);
            sendInMailValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label532;
            localByteBuffer.put((byte)0);
            break label532;
            localByteBuffer.put((byte)1);
            disconnectValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label592;
            localByteBuffer.put((byte)0);
            break label592;
            localByteBuffer.put((byte)1);
            unfollowValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label652;
            localByteBuffer.put((byte)0);
            break label652;
            localByteBuffer.put((byte)1);
            blockValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label712;
            localByteBuffer.put((byte)0);
            break label712;
            localByteBuffer.put((byte)1);
            reportValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label772;
            localByteBuffer.put((byte)0);
            break label772;
            localByteBuffer.put((byte)1);
            signupValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label832;
            localByteBuffer.put((byte)0);
            break label832;
            localByteBuffer.put((byte)1);
            requestRecommendationValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
          }
        }
        paramFissionAdapter.writeToCache(str, localByteBuffer, getSerializedSize(), paramFissionTransaction);
        paramFissionAdapter.recycle(localByteBuffer);
      } while ((paramString == null) || (str.equals(paramString)));
      int i = PegasusBinaryUtils.getEncodedLength(str) + 3;
      paramByteBuffer = paramFissionAdapter.getBuffer(i);
      paramByteBuffer.put((byte)0);
      paramFissionAdapter.writeString(paramByteBuffer, str);
      paramFissionAdapter.writeToCache(paramString, paramByteBuffer, i, paramFissionTransaction);
      paramFissionAdapter.recycle(paramByteBuffer);
    }
    
    public static final class Builder
    {
      private Accept acceptValue = null;
      private Block blockValue = null;
      private Connect connectValue = null;
      private Disconnect disconnectValue = null;
      private Follow followValue = null;
      private boolean hasAcceptValue = false;
      private boolean hasBlockValue = false;
      private boolean hasConnectValue = false;
      private boolean hasDisconnectValue = false;
      private boolean hasFollowValue = false;
      private boolean hasInvitationPendingValue = false;
      private boolean hasMessageValue = false;
      private boolean hasPersonalizedConnectValue = false;
      private boolean hasReportValue = false;
      private boolean hasRequestRecommendationValue = false;
      private boolean hasSendInMailValue = false;
      private boolean hasSignupValue = false;
      private boolean hasUnfollowValue = false;
      private InvitationPending invitationPendingValue = null;
      private Message messageValue = null;
      private PersonalizedConnect personalizedConnectValue = null;
      private Report reportValue = null;
      private RequestRecommendation requestRecommendationValue = null;
      private SendInMail sendInMailValue = null;
      private Signup signupValue = null;
      private Unfollow unfollowValue = null;
      
      public Builder() {}
      
      public Builder(ProfileAction.Action paramAction)
      {
        connectValue = connectValue;
        personalizedConnectValue = personalizedConnectValue;
        invitationPendingValue = invitationPendingValue;
        acceptValue = acceptValue;
        messageValue = messageValue;
        followValue = followValue;
        sendInMailValue = sendInMailValue;
        disconnectValue = disconnectValue;
        unfollowValue = unfollowValue;
        blockValue = blockValue;
        reportValue = reportValue;
        signupValue = signupValue;
        requestRecommendationValue = requestRecommendationValue;
        hasConnectValue = hasConnectValue;
        hasPersonalizedConnectValue = hasPersonalizedConnectValue;
        hasInvitationPendingValue = hasInvitationPendingValue;
        hasAcceptValue = hasAcceptValue;
        hasMessageValue = hasMessageValue;
        hasFollowValue = hasFollowValue;
        hasSendInMailValue = hasSendInMailValue;
        hasDisconnectValue = hasDisconnectValue;
        hasUnfollowValue = hasUnfollowValue;
        hasBlockValue = hasBlockValue;
        hasReportValue = hasReportValue;
        hasSignupValue = hasSignupValue;
        hasRequestRecommendationValue = hasRequestRecommendationValue;
      }
      
      public final ProfileAction.Action build()
        throws BuilderException
      {
        int j = 0;
        if (hasConnectValue) {
          j = 0 + 1;
        }
        int i = j;
        if (hasPersonalizedConnectValue) {
          i = j + 1;
        }
        j = i;
        if (hasInvitationPendingValue) {
          j = i + 1;
        }
        i = j;
        if (hasAcceptValue) {
          i = j + 1;
        }
        j = i;
        if (hasMessageValue) {
          j = i + 1;
        }
        i = j;
        if (hasFollowValue) {
          i = j + 1;
        }
        j = i;
        if (hasSendInMailValue) {
          j = i + 1;
        }
        i = j;
        if (hasDisconnectValue) {
          i = j + 1;
        }
        j = i;
        if (hasUnfollowValue) {
          j = i + 1;
        }
        i = j;
        if (hasBlockValue) {
          i = j + 1;
        }
        j = i;
        if (hasReportValue) {
          j = i + 1;
        }
        i = j;
        if (hasSignupValue) {
          i = j + 1;
        }
        j = i;
        if (hasRequestRecommendationValue) {
          j = i + 1;
        }
        if (j > 1) {
          throw new UnionMemberCountException("Action", j);
        }
        return new ProfileAction.Action(connectValue, personalizedConnectValue, invitationPendingValue, acceptValue, messageValue, followValue, sendInMailValue, disconnectValue, unfollowValue, blockValue, reportValue, signupValue, requestRecommendationValue, hasConnectValue, hasPersonalizedConnectValue, hasInvitationPendingValue, hasAcceptValue, hasMessageValue, hasFollowValue, hasSendInMailValue, hasDisconnectValue, hasUnfollowValue, hasBlockValue, hasReportValue, hasSignupValue, hasRequestRecommendationValue);
      }
      
      public final Builder setAcceptValue$76e4df49()
      {
        hasAcceptValue = false;
        acceptValue = null;
        return this;
      }
      
      public final Builder setConnectValue$e34ab()
      {
        hasConnectValue = false;
        connectValue = null;
        return this;
      }
      
      public final Builder setInvitationPendingValue(InvitationPending paramInvitationPending)
      {
        if (paramInvitationPending == null)
        {
          hasInvitationPendingValue = false;
          invitationPendingValue = null;
          return this;
        }
        hasInvitationPendingValue = true;
        invitationPendingValue = paramInvitationPending;
        return this;
      }
    }
  }
  
  public static final class Builder
    implements RecordTemplateBuilder<ProfileAction>
  {
    private ProfileAction.Action action = null;
    private boolean hasAction = false;
    private boolean hasType = false;
    private ActionType type = null;
    
    public Builder() {}
    
    public Builder(ProfileAction paramProfileAction)
    {
      action = action;
      type = type;
      hasAction = hasAction;
      hasType = hasType;
    }
    
    public final ProfileAction build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (ProfileAction.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new ProfileAction(action, type, hasAction, hasType);
      } while (hasAction);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.actions.ProfileAction", "action");
    }
    
    public final Builder setAction(ProfileAction.Action paramAction)
    {
      if (paramAction == null)
      {
        hasAction = false;
        action = null;
        return this;
      }
      hasAction = true;
      action = paramAction;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.actions.ProfileAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */