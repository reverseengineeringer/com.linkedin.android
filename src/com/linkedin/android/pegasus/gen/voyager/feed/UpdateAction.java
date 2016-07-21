package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.Delete;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.EditShare;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.Feedback;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.FollowChannel;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.FollowCompany;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.FollowGroup;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.FollowMember;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.FollowSchool;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.IncorrectlyMentionedCompany;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.IncorrectlyMentionedMember;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.LeaveGroup;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.Reasoning;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.Report;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.ShareVia;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.Survey;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.UnfollowActions;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.UnfollowChannel;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.UnfollowCompany;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.UnfollowGroup;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.UnfollowMember;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.UnfollowSchool;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class UpdateAction
  implements FissileDataModel<UpdateAction>, RecordTemplate<UpdateAction>
{
  public static final UpdateActionBuilder BUILDER = UpdateActionBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final boolean hasValue;
  public final Value value;
  
  UpdateAction(Value paramValue, boolean paramBoolean)
  {
    value = paramValue;
    hasValue = paramBoolean;
    _cachedId = null;
  }
  
  public final UpdateAction accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Value localValue = null;
    boolean bool = false;
    if (hasValue)
    {
      paramDataProcessor.startRecordField$505cff1c("value");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label93;
      }
      localValue = value.accept(paramDataProcessor);
      if (localValue == null) {
        break label110;
      }
    }
    label93:
    label110:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label125;
      }
      try
      {
        if (hasValue) {
          break label115;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.UpdateAction", "value");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localValue = (Value)paramDataProcessor.processDataTemplate(value);
      break;
    }
    label115:
    return new UpdateAction(localValue, bool);
    label125:
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
      paramObject = (UpdateAction)paramObject;
      if (value == null) {
        break;
      }
    } while (value.equals(value));
    for (;;)
    {
      return false;
      if (value == null) {
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
    if (hasValue) {
      if (value._cachedId == null) {
        break label58;
      }
    }
    label58:
    for (i = PegasusBinaryUtils.getEncodedLength(value._cachedId) + 9;; i = value.getSerializedSize() + 7)
    {
      __sizeOfObject = i;
      return i;
    }
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (value != null) {}
    for (int i = value.hashCode();; i = 0)
    {
      i += 527;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building UpdateAction");
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
    label238:
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
        localByteBuffer.putInt(1398081755);
        if (hasValue)
        {
          localByteBuffer.put((byte)1);
          if (value._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, value._cachedId);
            value.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label238;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          value.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
  
  public static final class Value
    implements FissileDataModel<Value>, UnionTemplate<Value>
  {
    public static final UpdateActionBuilder.ValueBuilder BUILDER = UpdateActionBuilder.ValueBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final Delete deleteValue;
    public final EditShare editShareValue;
    public final Feedback feedbackValue;
    public final FollowChannel followChannelValue;
    public final FollowCompany followCompanyValue;
    public final FollowGroup followGroupValue;
    public final FollowMember followMemberValue;
    public final FollowSchool followSchoolValue;
    public final boolean hasDeleteValue;
    public final boolean hasEditShareValue;
    public final boolean hasFeedbackValue;
    public final boolean hasFollowChannelValue;
    public final boolean hasFollowCompanyValue;
    public final boolean hasFollowGroupValue;
    public final boolean hasFollowMemberValue;
    public final boolean hasFollowSchoolValue;
    public final boolean hasIncorrectlyMentionedCompanyValue;
    public final boolean hasIncorrectlyMentionedMemberValue;
    public final boolean hasLeaveGroupValue;
    public final boolean hasReasoningValue;
    public final boolean hasReportValue;
    public final boolean hasShareViaValue;
    public final boolean hasSurveyValue;
    public final boolean hasUnfollowActionsValue;
    public final boolean hasUnfollowChannelValue;
    public final boolean hasUnfollowCompanyValue;
    public final boolean hasUnfollowGroupValue;
    public final boolean hasUnfollowMemberValue;
    public final boolean hasUnfollowSchoolValue;
    public final IncorrectlyMentionedCompany incorrectlyMentionedCompanyValue;
    public final IncorrectlyMentionedMember incorrectlyMentionedMemberValue;
    public final LeaveGroup leaveGroupValue;
    public final Reasoning reasoningValue;
    public final Report reportValue;
    public final ShareVia shareViaValue;
    public final Survey surveyValue;
    public final UnfollowActions unfollowActionsValue;
    public final UnfollowChannel unfollowChannelValue;
    public final UnfollowCompany unfollowCompanyValue;
    public final UnfollowGroup unfollowGroupValue;
    public final UnfollowMember unfollowMemberValue;
    public final UnfollowSchool unfollowSchoolValue;
    
    Value(Delete paramDelete, Reasoning paramReasoning, Feedback paramFeedback, UnfollowActions paramUnfollowActions, UnfollowMember paramUnfollowMember, UnfollowCompany paramUnfollowCompany, UnfollowChannel paramUnfollowChannel, UnfollowSchool paramUnfollowSchool, UnfollowGroup paramUnfollowGroup, FollowMember paramFollowMember, FollowCompany paramFollowCompany, FollowChannel paramFollowChannel, FollowSchool paramFollowSchool, FollowGroup paramFollowGroup, LeaveGroup paramLeaveGroup, Report paramReport, Survey paramSurvey, IncorrectlyMentionedMember paramIncorrectlyMentionedMember, IncorrectlyMentionedCompany paramIncorrectlyMentionedCompany, ShareVia paramShareVia, EditShare paramEditShare, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13, boolean paramBoolean14, boolean paramBoolean15, boolean paramBoolean16, boolean paramBoolean17, boolean paramBoolean18, boolean paramBoolean19, boolean paramBoolean20, boolean paramBoolean21)
    {
      deleteValue = paramDelete;
      reasoningValue = paramReasoning;
      feedbackValue = paramFeedback;
      unfollowActionsValue = paramUnfollowActions;
      unfollowMemberValue = paramUnfollowMember;
      unfollowCompanyValue = paramUnfollowCompany;
      unfollowChannelValue = paramUnfollowChannel;
      unfollowSchoolValue = paramUnfollowSchool;
      unfollowGroupValue = paramUnfollowGroup;
      followMemberValue = paramFollowMember;
      followCompanyValue = paramFollowCompany;
      followChannelValue = paramFollowChannel;
      followSchoolValue = paramFollowSchool;
      followGroupValue = paramFollowGroup;
      leaveGroupValue = paramLeaveGroup;
      reportValue = paramReport;
      surveyValue = paramSurvey;
      incorrectlyMentionedMemberValue = paramIncorrectlyMentionedMember;
      incorrectlyMentionedCompanyValue = paramIncorrectlyMentionedCompany;
      shareViaValue = paramShareVia;
      editShareValue = paramEditShare;
      hasDeleteValue = paramBoolean1;
      hasReasoningValue = paramBoolean2;
      hasFeedbackValue = paramBoolean3;
      hasUnfollowActionsValue = paramBoolean4;
      hasUnfollowMemberValue = paramBoolean5;
      hasUnfollowCompanyValue = paramBoolean6;
      hasUnfollowChannelValue = paramBoolean7;
      hasUnfollowSchoolValue = paramBoolean8;
      hasUnfollowGroupValue = paramBoolean9;
      hasFollowMemberValue = paramBoolean10;
      hasFollowCompanyValue = paramBoolean11;
      hasFollowChannelValue = paramBoolean12;
      hasFollowSchoolValue = paramBoolean13;
      hasFollowGroupValue = paramBoolean14;
      hasLeaveGroupValue = paramBoolean15;
      hasReportValue = paramBoolean16;
      hasSurveyValue = paramBoolean17;
      hasIncorrectlyMentionedMemberValue = paramBoolean18;
      hasIncorrectlyMentionedCompanyValue = paramBoolean19;
      hasShareViaValue = paramBoolean20;
      hasEditShareValue = paramBoolean21;
      _cachedId = null;
    }
    
    public final Value accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      Object localObject2 = null;
      boolean bool1 = false;
      Object localObject1;
      label52:
      Object localObject3;
      boolean bool2;
      label91:
      label102:
      Object localObject4;
      boolean bool3;
      label138:
      label150:
      Object localObject5;
      boolean bool4;
      label190:
      label202:
      Object localObject6;
      boolean bool5;
      label242:
      label254:
      Object localObject7;
      boolean bool6;
      label294:
      label306:
      Object localObject8;
      boolean bool7;
      label346:
      label358:
      Object localObject9;
      boolean bool8;
      label398:
      label410:
      Object localObject10;
      boolean bool9;
      label451:
      label463:
      Object localObject11;
      boolean bool10;
      label500:
      label512:
      Object localObject12;
      boolean bool11;
      label549:
      label561:
      Object localObject13;
      boolean bool12;
      label598:
      label610:
      Object localObject14;
      boolean bool13;
      label647:
      label659:
      Object localObject15;
      boolean bool14;
      label696:
      label708:
      Object localObject16;
      boolean bool15;
      label749:
      label761:
      Object localObject17;
      boolean bool16;
      label798:
      label810:
      Object localObject18;
      boolean bool17;
      label847:
      label859:
      Object localObject19;
      boolean bool18;
      label900:
      label912:
      Object localObject20;
      boolean bool19;
      label953:
      label965:
      Object localObject21;
      boolean bool20;
      if (hasDeleteValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.actions.Delete");
        if (paramDataProcessor.shouldAcceptTransitively())
        {
          localObject1 = Delete.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label1186;
          }
          bool1 = true;
          localObject2 = localObject1;
        }
      }
      else
      {
        localObject3 = null;
        bool2 = false;
        if (hasReasoningValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.actions.Reasoning");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label1195;
          }
          localObject1 = reasoningValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label1213;
          }
          bool2 = true;
          localObject3 = localObject1;
        }
        localObject4 = null;
        bool3 = false;
        if (hasFeedbackValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.actions.Feedback");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label1222;
          }
          localObject1 = Feedback.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label1240;
          }
          bool3 = true;
          localObject4 = localObject1;
        }
        localObject5 = null;
        bool4 = false;
        if (hasUnfollowActionsValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.actions.UnfollowActions");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label1250;
          }
          localObject1 = unfollowActionsValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label1268;
          }
          bool4 = true;
          localObject5 = localObject1;
        }
        localObject6 = null;
        bool5 = false;
        if (hasUnfollowMemberValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.actions.UnfollowMember");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label1278;
          }
          localObject1 = unfollowMemberValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label1296;
          }
          bool5 = true;
          localObject6 = localObject1;
        }
        localObject7 = null;
        bool6 = false;
        if (hasUnfollowCompanyValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.actions.UnfollowCompany");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label1306;
          }
          localObject1 = unfollowCompanyValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label1324;
          }
          bool6 = true;
          localObject7 = localObject1;
        }
        localObject8 = null;
        bool7 = false;
        if (hasUnfollowChannelValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.actions.UnfollowChannel");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label1334;
          }
          localObject1 = unfollowChannelValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label1352;
          }
          bool7 = true;
          localObject8 = localObject1;
        }
        localObject9 = null;
        bool8 = false;
        if (hasUnfollowSchoolValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.actions.UnfollowSchool");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label1362;
          }
          localObject1 = unfollowSchoolValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label1380;
          }
          bool8 = true;
          localObject9 = localObject1;
        }
        localObject10 = null;
        bool9 = false;
        if (hasUnfollowGroupValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.actions.UnfollowGroup");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label1390;
          }
          localObject1 = unfollowGroupValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label1408;
          }
          bool9 = true;
          localObject10 = localObject1;
        }
        localObject11 = null;
        bool10 = false;
        if (hasFollowMemberValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.actions.FollowMember");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label1418;
          }
          localObject1 = FollowMember.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label1436;
          }
          bool10 = true;
          localObject11 = localObject1;
        }
        localObject12 = null;
        bool11 = false;
        if (hasFollowCompanyValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.actions.FollowCompany");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label1446;
          }
          localObject1 = FollowCompany.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label1464;
          }
          bool11 = true;
          localObject12 = localObject1;
        }
        localObject13 = null;
        bool12 = false;
        if (hasFollowChannelValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.actions.FollowChannel");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label1474;
          }
          localObject1 = FollowChannel.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label1492;
          }
          bool12 = true;
          localObject13 = localObject1;
        }
        localObject14 = null;
        bool13 = false;
        if (hasFollowSchoolValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.actions.FollowSchool");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label1502;
          }
          localObject1 = FollowSchool.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label1520;
          }
          bool13 = true;
          localObject14 = localObject1;
        }
        localObject15 = null;
        bool14 = false;
        if (hasFollowGroupValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.actions.FollowGroup");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label1530;
          }
          localObject1 = FollowGroup.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label1548;
          }
          bool14 = true;
          localObject15 = localObject1;
        }
        localObject16 = null;
        bool15 = false;
        if (hasLeaveGroupValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.actions.LeaveGroup");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label1558;
          }
          localObject1 = leaveGroupValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label1576;
          }
          bool15 = true;
          localObject16 = localObject1;
        }
        localObject17 = null;
        bool16 = false;
        if (hasReportValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.actions.Report");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label1586;
          }
          localObject1 = Report.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label1604;
          }
          bool16 = true;
          localObject17 = localObject1;
        }
        localObject18 = null;
        bool17 = false;
        if (hasSurveyValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.actions.Survey");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label1614;
          }
          localObject1 = Survey.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label1632;
          }
          bool17 = true;
          localObject18 = localObject1;
        }
        localObject19 = null;
        bool18 = false;
        if (hasIncorrectlyMentionedMemberValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.actions.IncorrectlyMentionedMember");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label1642;
          }
          localObject1 = incorrectlyMentionedMemberValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label1660;
          }
          bool18 = true;
          localObject19 = localObject1;
        }
        localObject20 = null;
        bool19 = false;
        if (hasIncorrectlyMentionedCompanyValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.actions.IncorrectlyMentionedCompany");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label1670;
          }
          localObject1 = incorrectlyMentionedCompanyValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label1688;
          }
          bool19 = true;
          localObject20 = localObject1;
        }
        localObject21 = null;
        bool20 = false;
        if (hasShareViaValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.actions.ShareVia");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label1698;
          }
          localObject1 = shareViaValue.accept(paramDataProcessor);
          label1006:
          if (localObject1 == null) {
            break label1716;
          }
          bool20 = true;
          localObject21 = localObject1;
        }
        label1018:
        localObject1 = null;
        bool21 = false;
        if (hasEditShareValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.feed.actions.EditShare");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label1726;
          }
          localObject1 = EditShare.accept(paramDataProcessor);
          label1055:
          if (localObject1 == null) {
            break label1744;
          }
        }
      }
      label1186:
      label1195:
      label1213:
      label1222:
      label1240:
      label1250:
      label1268:
      label1278:
      label1296:
      label1306:
      label1324:
      label1334:
      label1352:
      label1362:
      label1380:
      label1390:
      label1408:
      label1418:
      label1436:
      label1446:
      label1464:
      label1474:
      label1492:
      label1502:
      label1520:
      label1530:
      label1548:
      label1558:
      label1576:
      label1586:
      label1604:
      label1614:
      label1632:
      label1642:
      label1660:
      label1670:
      label1688:
      label1698:
      label1716:
      label1726:
      label1744:
      for (boolean bool21 = true;; bool21 = false)
      {
        paramDataProcessor.endUnion();
        if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
          break label1750;
        }
        return new Value((Delete)localObject2, (Reasoning)localObject3, (Feedback)localObject4, (UnfollowActions)localObject5, (UnfollowMember)localObject6, (UnfollowCompany)localObject7, (UnfollowChannel)localObject8, (UnfollowSchool)localObject9, (UnfollowGroup)localObject10, (FollowMember)localObject11, (FollowCompany)localObject12, (FollowChannel)localObject13, (FollowSchool)localObject14, (FollowGroup)localObject15, (LeaveGroup)localObject16, (Report)localObject17, (Survey)localObject18, (IncorrectlyMentionedMember)localObject19, (IncorrectlyMentionedCompany)localObject20, (ShareVia)localObject21, (EditShare)localObject1, bool1, bool2, bool3, bool4, bool5, bool6, bool7, bool8, bool9, bool10, bool11, bool12, bool13, bool14, bool15, bool16, bool17, bool18, bool19, bool20, bool21);
        localObject1 = (Delete)paramDataProcessor.processDataTemplate(deleteValue);
        break;
        bool1 = false;
        localObject2 = localObject1;
        break label52;
        localObject1 = (Reasoning)paramDataProcessor.processDataTemplate(reasoningValue);
        break label91;
        bool2 = false;
        localObject3 = localObject1;
        break label102;
        localObject1 = (Feedback)paramDataProcessor.processDataTemplate(feedbackValue);
        break label138;
        bool3 = false;
        localObject4 = localObject1;
        break label150;
        localObject1 = (UnfollowActions)paramDataProcessor.processDataTemplate(unfollowActionsValue);
        break label190;
        bool4 = false;
        localObject5 = localObject1;
        break label202;
        localObject1 = (UnfollowMember)paramDataProcessor.processDataTemplate(unfollowMemberValue);
        break label242;
        bool5 = false;
        localObject6 = localObject1;
        break label254;
        localObject1 = (UnfollowCompany)paramDataProcessor.processDataTemplate(unfollowCompanyValue);
        break label294;
        bool6 = false;
        localObject7 = localObject1;
        break label306;
        localObject1 = (UnfollowChannel)paramDataProcessor.processDataTemplate(unfollowChannelValue);
        break label346;
        bool7 = false;
        localObject8 = localObject1;
        break label358;
        localObject1 = (UnfollowSchool)paramDataProcessor.processDataTemplate(unfollowSchoolValue);
        break label398;
        bool8 = false;
        localObject9 = localObject1;
        break label410;
        localObject1 = (UnfollowGroup)paramDataProcessor.processDataTemplate(unfollowGroupValue);
        break label451;
        bool9 = false;
        localObject10 = localObject1;
        break label463;
        localObject1 = (FollowMember)paramDataProcessor.processDataTemplate(followMemberValue);
        break label500;
        bool10 = false;
        localObject11 = localObject1;
        break label512;
        localObject1 = (FollowCompany)paramDataProcessor.processDataTemplate(followCompanyValue);
        break label549;
        bool11 = false;
        localObject12 = localObject1;
        break label561;
        localObject1 = (FollowChannel)paramDataProcessor.processDataTemplate(followChannelValue);
        break label598;
        bool12 = false;
        localObject13 = localObject1;
        break label610;
        localObject1 = (FollowSchool)paramDataProcessor.processDataTemplate(followSchoolValue);
        break label647;
        bool13 = false;
        localObject14 = localObject1;
        break label659;
        localObject1 = (FollowGroup)paramDataProcessor.processDataTemplate(followGroupValue);
        break label696;
        bool14 = false;
        localObject15 = localObject1;
        break label708;
        localObject1 = (LeaveGroup)paramDataProcessor.processDataTemplate(leaveGroupValue);
        break label749;
        bool15 = false;
        localObject16 = localObject1;
        break label761;
        localObject1 = (Report)paramDataProcessor.processDataTemplate(reportValue);
        break label798;
        bool16 = false;
        localObject17 = localObject1;
        break label810;
        localObject1 = (Survey)paramDataProcessor.processDataTemplate(surveyValue);
        break label847;
        bool17 = false;
        localObject18 = localObject1;
        break label859;
        localObject1 = (IncorrectlyMentionedMember)paramDataProcessor.processDataTemplate(incorrectlyMentionedMemberValue);
        break label900;
        bool18 = false;
        localObject19 = localObject1;
        break label912;
        localObject1 = (IncorrectlyMentionedCompany)paramDataProcessor.processDataTemplate(incorrectlyMentionedCompanyValue);
        break label953;
        bool19 = false;
        localObject20 = localObject1;
        break label965;
        localObject1 = (ShareVia)paramDataProcessor.processDataTemplate(shareViaValue);
        break label1006;
        bool20 = false;
        localObject21 = localObject1;
        break label1018;
        localObject1 = (EditShare)paramDataProcessor.processDataTemplate(editShareValue);
        break label1055;
      }
      label1750:
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
        paramObject = (Value)paramObject;
        if (deleteValue != null)
        {
          if (deleteValue.equals(deleteValue)) {}
        }
        else {
          while (deleteValue != null) {
            return false;
          }
        }
        if (reasoningValue != null)
        {
          if (reasoningValue.equals(reasoningValue)) {}
        }
        else {
          while (reasoningValue != null) {
            return false;
          }
        }
        if (feedbackValue != null)
        {
          if (feedbackValue.equals(feedbackValue)) {}
        }
        else {
          while (feedbackValue != null) {
            return false;
          }
        }
        if (unfollowActionsValue != null)
        {
          if (unfollowActionsValue.equals(unfollowActionsValue)) {}
        }
        else {
          while (unfollowActionsValue != null) {
            return false;
          }
        }
        if (unfollowMemberValue != null)
        {
          if (unfollowMemberValue.equals(unfollowMemberValue)) {}
        }
        else {
          while (unfollowMemberValue != null) {
            return false;
          }
        }
        if (unfollowCompanyValue != null)
        {
          if (unfollowCompanyValue.equals(unfollowCompanyValue)) {}
        }
        else {
          while (unfollowCompanyValue != null) {
            return false;
          }
        }
        if (unfollowChannelValue != null)
        {
          if (unfollowChannelValue.equals(unfollowChannelValue)) {}
        }
        else {
          while (unfollowChannelValue != null) {
            return false;
          }
        }
        if (unfollowSchoolValue != null)
        {
          if (unfollowSchoolValue.equals(unfollowSchoolValue)) {}
        }
        else {
          while (unfollowSchoolValue != null) {
            return false;
          }
        }
        if (unfollowGroupValue != null)
        {
          if (unfollowGroupValue.equals(unfollowGroupValue)) {}
        }
        else {
          while (unfollowGroupValue != null) {
            return false;
          }
        }
        if (followMemberValue != null)
        {
          if (followMemberValue.equals(followMemberValue)) {}
        }
        else {
          while (followMemberValue != null) {
            return false;
          }
        }
        if (followCompanyValue != null)
        {
          if (followCompanyValue.equals(followCompanyValue)) {}
        }
        else {
          while (followCompanyValue != null) {
            return false;
          }
        }
        if (followChannelValue != null)
        {
          if (followChannelValue.equals(followChannelValue)) {}
        }
        else {
          while (followChannelValue != null) {
            return false;
          }
        }
        if (followSchoolValue != null)
        {
          if (followSchoolValue.equals(followSchoolValue)) {}
        }
        else {
          while (followSchoolValue != null) {
            return false;
          }
        }
        if (followGroupValue != null)
        {
          if (followGroupValue.equals(followGroupValue)) {}
        }
        else {
          while (followGroupValue != null) {
            return false;
          }
        }
        if (leaveGroupValue != null)
        {
          if (leaveGroupValue.equals(leaveGroupValue)) {}
        }
        else {
          while (leaveGroupValue != null) {
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
        if (surveyValue != null)
        {
          if (surveyValue.equals(surveyValue)) {}
        }
        else {
          while (surveyValue != null) {
            return false;
          }
        }
        if (incorrectlyMentionedMemberValue != null)
        {
          if (incorrectlyMentionedMemberValue.equals(incorrectlyMentionedMemberValue)) {}
        }
        else {
          while (incorrectlyMentionedMemberValue != null) {
            return false;
          }
        }
        if (incorrectlyMentionedCompanyValue != null)
        {
          if (incorrectlyMentionedCompanyValue.equals(incorrectlyMentionedCompanyValue)) {}
        }
        else {
          while (incorrectlyMentionedCompanyValue != null) {
            return false;
          }
        }
        if (shareViaValue != null)
        {
          if (shareViaValue.equals(shareViaValue)) {}
        }
        else {
          while (shareViaValue != null) {
            return false;
          }
        }
        if (editShareValue == null) {
          break;
        }
      } while (editShareValue.equals(editShareValue));
      for (;;)
      {
        return false;
        if (editShareValue == null) {
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
      if (hasDeleteValue)
      {
        if (deleteValue._cachedId != null) {
          i = PegasusBinaryUtils.getEncodedLength(deleteValue._cachedId) + 9;
        }
      }
      else
      {
        int j = i + 1;
        i = j;
        if (hasReasoningValue)
        {
          i = j + 1;
          if (reasoningValue._cachedId == null) {
            break label912;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(reasoningValue._cachedId);
        }
        label93:
        j = i + 1;
        i = j;
        if (hasFeedbackValue)
        {
          i = j + 1;
          if (feedbackValue._cachedId == null) {
            break label925;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(feedbackValue._cachedId);
        }
        label135:
        j = i + 1;
        i = j;
        if (hasUnfollowActionsValue)
        {
          i = j + 1;
          if (unfollowActionsValue._cachedId == null) {
            break label938;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(unfollowActionsValue._cachedId);
        }
        label177:
        j = i + 1;
        i = j;
        if (hasUnfollowMemberValue)
        {
          i = j + 1;
          if (unfollowMemberValue._cachedId == null) {
            break label951;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(unfollowMemberValue._cachedId);
        }
        label219:
        j = i + 1;
        i = j;
        if (hasUnfollowCompanyValue)
        {
          i = j + 1;
          if (unfollowCompanyValue._cachedId == null) {
            break label964;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(unfollowCompanyValue._cachedId);
        }
        label261:
        j = i + 1;
        i = j;
        if (hasUnfollowChannelValue)
        {
          i = j + 1;
          if (unfollowChannelValue._cachedId == null) {
            break label977;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(unfollowChannelValue._cachedId);
        }
        label303:
        j = i + 1;
        i = j;
        if (hasUnfollowSchoolValue)
        {
          i = j + 1;
          if (unfollowSchoolValue._cachedId == null) {
            break label990;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(unfollowSchoolValue._cachedId);
        }
        label345:
        j = i + 1;
        i = j;
        if (hasUnfollowGroupValue)
        {
          i = j + 1;
          if (unfollowGroupValue._cachedId == null) {
            break label1003;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(unfollowGroupValue._cachedId);
        }
        label387:
        j = i + 1;
        i = j;
        if (hasFollowMemberValue)
        {
          i = j + 1;
          if (followMemberValue._cachedId == null) {
            break label1016;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(followMemberValue._cachedId);
        }
        label429:
        j = i + 1;
        i = j;
        if (hasFollowCompanyValue)
        {
          i = j + 1;
          if (followCompanyValue._cachedId == null) {
            break label1029;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(followCompanyValue._cachedId);
        }
        label471:
        j = i + 1;
        i = j;
        if (hasFollowChannelValue)
        {
          i = j + 1;
          if (followChannelValue._cachedId == null) {
            break label1042;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(followChannelValue._cachedId);
        }
        label513:
        j = i + 1;
        i = j;
        if (hasFollowSchoolValue)
        {
          i = j + 1;
          if (followSchoolValue._cachedId == null) {
            break label1055;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(followSchoolValue._cachedId);
        }
        label555:
        j = i + 1;
        i = j;
        if (hasFollowGroupValue)
        {
          i = j + 1;
          if (followGroupValue._cachedId == null) {
            break label1068;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(followGroupValue._cachedId);
        }
        label597:
        j = i + 1;
        i = j;
        if (hasLeaveGroupValue)
        {
          i = j + 1;
          if (leaveGroupValue._cachedId == null) {
            break label1081;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(leaveGroupValue._cachedId);
        }
        label639:
        j = i + 1;
        i = j;
        if (hasReportValue)
        {
          i = j + 1;
          if (reportValue._cachedId == null) {
            break label1094;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(reportValue._cachedId);
        }
        label681:
        j = i + 1;
        i = j;
        if (hasSurveyValue)
        {
          i = j + 1;
          if (surveyValue._cachedId == null) {
            break label1107;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(surveyValue._cachedId);
        }
        label723:
        j = i + 1;
        i = j;
        if (hasIncorrectlyMentionedMemberValue)
        {
          i = j + 1;
          if (incorrectlyMentionedMemberValue._cachedId == null) {
            break label1120;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(incorrectlyMentionedMemberValue._cachedId);
        }
        label765:
        j = i + 1;
        i = j;
        if (hasIncorrectlyMentionedCompanyValue)
        {
          i = j + 1;
          if (incorrectlyMentionedCompanyValue._cachedId == null) {
            break label1133;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(incorrectlyMentionedCompanyValue._cachedId);
        }
        label807:
        j = i + 1;
        i = j;
        if (hasShareViaValue)
        {
          i = j + 1;
          if (shareViaValue._cachedId == null) {
            break label1146;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(shareViaValue._cachedId);
        }
        label849:
        j = i + 1;
        i = j;
        if (hasEditShareValue)
        {
          i = j + 1;
          if (editShareValue._cachedId == null) {
            break label1159;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(editShareValue._cachedId);
        }
      }
      for (;;)
      {
        __sizeOfObject = i;
        return i;
        i = deleteValue.getSerializedSize() + 7;
        break;
        label912:
        i += reasoningValue.getSerializedSize();
        break label93;
        label925:
        i += feedbackValue.getSerializedSize();
        break label135;
        label938:
        i += unfollowActionsValue.getSerializedSize();
        break label177;
        label951:
        i += unfollowMemberValue.getSerializedSize();
        break label219;
        label964:
        i += unfollowCompanyValue.getSerializedSize();
        break label261;
        label977:
        i += unfollowChannelValue.getSerializedSize();
        break label303;
        label990:
        i += unfollowSchoolValue.getSerializedSize();
        break label345;
        label1003:
        i += unfollowGroupValue.getSerializedSize();
        break label387;
        label1016:
        i += followMemberValue.getSerializedSize();
        break label429;
        label1029:
        i += followCompanyValue.getSerializedSize();
        break label471;
        label1042:
        i += followChannelValue.getSerializedSize();
        break label513;
        label1055:
        i += followSchoolValue.getSerializedSize();
        break label555;
        label1068:
        i += followGroupValue.getSerializedSize();
        break label597;
        label1081:
        i += leaveGroupValue.getSerializedSize();
        break label639;
        label1094:
        i += reportValue.getSerializedSize();
        break label681;
        label1107:
        i += surveyValue.getSerializedSize();
        break label723;
        label1120:
        i += incorrectlyMentionedMemberValue.getSerializedSize();
        break label765;
        label1133:
        i += incorrectlyMentionedCompanyValue.getSerializedSize();
        break label807;
        label1146:
        i += shareViaValue.getSerializedSize();
        break label849;
        label1159:
        i += editShareValue.getSerializedSize();
      }
    }
    
    public final int hashCode()
    {
      int i16 = 0;
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
      label188:
      int i7;
      label204:
      int i8;
      label220:
      int i9;
      label236:
      int i10;
      label252:
      int i11;
      label268:
      int i12;
      label284:
      int i13;
      label300:
      int i14;
      if (deleteValue != null)
      {
        i = deleteValue.hashCode();
        if (reasoningValue == null) {
          break label484;
        }
        j = reasoningValue.hashCode();
        if (feedbackValue == null) {
          break label489;
        }
        k = feedbackValue.hashCode();
        if (unfollowActionsValue == null) {
          break label494;
        }
        m = unfollowActionsValue.hashCode();
        if (unfollowMemberValue == null) {
          break label500;
        }
        n = unfollowMemberValue.hashCode();
        if (unfollowCompanyValue == null) {
          break label506;
        }
        i1 = unfollowCompanyValue.hashCode();
        if (unfollowChannelValue == null) {
          break label512;
        }
        i2 = unfollowChannelValue.hashCode();
        if (unfollowSchoolValue == null) {
          break label518;
        }
        i3 = unfollowSchoolValue.hashCode();
        if (unfollowGroupValue == null) {
          break label524;
        }
        i4 = unfollowGroupValue.hashCode();
        if (followMemberValue == null) {
          break label530;
        }
        i5 = followMemberValue.hashCode();
        if (followCompanyValue == null) {
          break label536;
        }
        i6 = followCompanyValue.hashCode();
        if (followChannelValue == null) {
          break label542;
        }
        i7 = followChannelValue.hashCode();
        if (followSchoolValue == null) {
          break label548;
        }
        i8 = followSchoolValue.hashCode();
        if (followGroupValue == null) {
          break label554;
        }
        i9 = followGroupValue.hashCode();
        if (leaveGroupValue == null) {
          break label560;
        }
        i10 = leaveGroupValue.hashCode();
        if (reportValue == null) {
          break label566;
        }
        i11 = reportValue.hashCode();
        if (surveyValue == null) {
          break label572;
        }
        i12 = surveyValue.hashCode();
        if (incorrectlyMentionedMemberValue == null) {
          break label578;
        }
        i13 = incorrectlyMentionedMemberValue.hashCode();
        if (incorrectlyMentionedCompanyValue == null) {
          break label584;
        }
        i14 = incorrectlyMentionedCompanyValue.hashCode();
        label316:
        if (shareViaValue == null) {
          break label590;
        }
      }
      label484:
      label489:
      label494:
      label500:
      label506:
      label512:
      label518:
      label524:
      label530:
      label536:
      label542:
      label548:
      label554:
      label560:
      label566:
      label572:
      label578:
      label584:
      label590:
      for (int i15 = shareViaValue.hashCode();; i15 = 0)
      {
        if (editShareValue != null) {
          i16 = editShareValue.hashCode();
        }
        i = (i15 + (i14 + (i13 + (i12 + (i11 + (i10 + (i9 + (i8 + (i7 + (i6 + (i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i16;
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
        i7 = 0;
        break label204;
        i8 = 0;
        break label220;
        i9 = 0;
        break label236;
        i10 = 0;
        break label252;
        i11 = 0;
        break label268;
        i12 = 0;
        break label284;
        i13 = 0;
        break label300;
        i14 = 0;
        break label316;
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
        throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Value");
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
      label892:
      label952:
      label1012:
      label1072:
      label1132:
      label1192:
      label1252:
      label1312:
      label1440:
      label1465:
      label1475:
      label1500:
      label1510:
      label1535:
      label1545:
      label1570:
      label1580:
      label1605:
      label1615:
      label1640:
      label1650:
      label1675:
      label1685:
      label1710:
      label1720:
      label1745:
      label1755:
      label1780:
      label1790:
      label1815:
      label1825:
      label1850:
      label1860:
      label1885:
      label1895:
      label1920:
      label1930:
      label1955:
      label1965:
      label1990:
      label2000:
      label2025:
      label2035:
      label2060:
      label2070:
      label2095:
      label2105:
      label2130:
      label2138:
      label2140:
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
          localByteBuffer.putInt(-1963863441);
          if (hasDeleteValue)
          {
            localByteBuffer.put((byte)1);
            if (deleteValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, deleteValue._cachedId);
              deleteValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasReasoningValue) {
                break label1465;
              }
              localByteBuffer.put((byte)1);
              if (reasoningValue._cachedId == null) {
                break label1440;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, reasoningValue._cachedId);
              reasoningValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasFeedbackValue) {
                break label1500;
              }
              localByteBuffer.put((byte)1);
              if (feedbackValue._cachedId == null) {
                break label1475;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, feedbackValue._cachedId);
              feedbackValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasUnfollowActionsValue) {
                break label1535;
              }
              localByteBuffer.put((byte)1);
              if (unfollowActionsValue._cachedId == null) {
                break label1510;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, unfollowActionsValue._cachedId);
              unfollowActionsValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasUnfollowMemberValue) {
                break label1570;
              }
              localByteBuffer.put((byte)1);
              if (unfollowMemberValue._cachedId == null) {
                break label1545;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, unfollowMemberValue._cachedId);
              unfollowMemberValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasUnfollowCompanyValue) {
                break label1605;
              }
              localByteBuffer.put((byte)1);
              if (unfollowCompanyValue._cachedId == null) {
                break label1580;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, unfollowCompanyValue._cachedId);
              unfollowCompanyValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasUnfollowChannelValue) {
                break label1640;
              }
              localByteBuffer.put((byte)1);
              if (unfollowChannelValue._cachedId == null) {
                break label1615;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, unfollowChannelValue._cachedId);
              unfollowChannelValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasUnfollowSchoolValue) {
                break label1675;
              }
              localByteBuffer.put((byte)1);
              if (unfollowSchoolValue._cachedId == null) {
                break label1650;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, unfollowSchoolValue._cachedId);
              unfollowSchoolValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasUnfollowGroupValue) {
                break label1710;
              }
              localByteBuffer.put((byte)1);
              if (unfollowGroupValue._cachedId == null) {
                break label1685;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, unfollowGroupValue._cachedId);
              unfollowGroupValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasFollowMemberValue) {
                break label1745;
              }
              localByteBuffer.put((byte)1);
              if (followMemberValue._cachedId == null) {
                break label1720;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, followMemberValue._cachedId);
              followMemberValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasFollowCompanyValue) {
                break label1780;
              }
              localByteBuffer.put((byte)1);
              if (followCompanyValue._cachedId == null) {
                break label1755;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, followCompanyValue._cachedId);
              followCompanyValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasFollowChannelValue) {
                break label1815;
              }
              localByteBuffer.put((byte)1);
              if (followChannelValue._cachedId == null) {
                break label1790;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, followChannelValue._cachedId);
              followChannelValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasFollowSchoolValue) {
                break label1850;
              }
              localByteBuffer.put((byte)1);
              if (followSchoolValue._cachedId == null) {
                break label1825;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, followSchoolValue._cachedId);
              followSchoolValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasFollowGroupValue) {
                break label1885;
              }
              localByteBuffer.put((byte)1);
              if (followGroupValue._cachedId == null) {
                break label1860;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, followGroupValue._cachedId);
              followGroupValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasLeaveGroupValue) {
                break label1920;
              }
              localByteBuffer.put((byte)1);
              if (leaveGroupValue._cachedId == null) {
                break label1895;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, leaveGroupValue._cachedId);
              leaveGroupValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasReportValue) {
                break label1955;
              }
              localByteBuffer.put((byte)1);
              if (reportValue._cachedId == null) {
                break label1930;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, reportValue._cachedId);
              reportValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasSurveyValue) {
                break label1990;
              }
              localByteBuffer.put((byte)1);
              if (surveyValue._cachedId == null) {
                break label1965;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, surveyValue._cachedId);
              surveyValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasIncorrectlyMentionedMemberValue) {
                break label2025;
              }
              localByteBuffer.put((byte)1);
              if (incorrectlyMentionedMemberValue._cachedId == null) {
                break label2000;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, incorrectlyMentionedMemberValue._cachedId);
              incorrectlyMentionedMemberValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasIncorrectlyMentionedCompanyValue) {
                break label2060;
              }
              localByteBuffer.put((byte)1);
              if (incorrectlyMentionedCompanyValue._cachedId == null) {
                break label2035;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, incorrectlyMentionedCompanyValue._cachedId);
              incorrectlyMentionedCompanyValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasShareViaValue) {
                break label2095;
              }
              localByteBuffer.put((byte)1);
              if (shareViaValue._cachedId == null) {
                break label2070;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, shareViaValue._cachedId);
              shareViaValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasEditShareValue) {
                break label2130;
              }
              localByteBuffer.put((byte)1);
              if (editShareValue._cachedId == null) {
                break label2105;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, editShareValue._cachedId);
              editShareValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
          }
          for (;;)
          {
            if (paramByteBuffer != null) {
              break label2138;
            }
            if (str != null) {
              break label2140;
            }
            paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
            paramFissionAdapter.recycle(localByteBuffer);
            return;
            localByteBuffer.put((byte)1);
            deleteValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            reasoningValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label232;
            localByteBuffer.put((byte)0);
            break label232;
            localByteBuffer.put((byte)1);
            feedbackValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label292;
            localByteBuffer.put((byte)0);
            break label292;
            localByteBuffer.put((byte)1);
            unfollowActionsValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label352;
            localByteBuffer.put((byte)0);
            break label352;
            localByteBuffer.put((byte)1);
            unfollowMemberValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label412;
            localByteBuffer.put((byte)0);
            break label412;
            localByteBuffer.put((byte)1);
            unfollowCompanyValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label472;
            localByteBuffer.put((byte)0);
            break label472;
            localByteBuffer.put((byte)1);
            unfollowChannelValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label532;
            localByteBuffer.put((byte)0);
            break label532;
            localByteBuffer.put((byte)1);
            unfollowSchoolValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label592;
            localByteBuffer.put((byte)0);
            break label592;
            localByteBuffer.put((byte)1);
            unfollowGroupValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label652;
            localByteBuffer.put((byte)0);
            break label652;
            localByteBuffer.put((byte)1);
            followMemberValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label712;
            localByteBuffer.put((byte)0);
            break label712;
            localByteBuffer.put((byte)1);
            followCompanyValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label772;
            localByteBuffer.put((byte)0);
            break label772;
            localByteBuffer.put((byte)1);
            followChannelValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label832;
            localByteBuffer.put((byte)0);
            break label832;
            localByteBuffer.put((byte)1);
            followSchoolValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label892;
            localByteBuffer.put((byte)0);
            break label892;
            localByteBuffer.put((byte)1);
            followGroupValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label952;
            localByteBuffer.put((byte)0);
            break label952;
            localByteBuffer.put((byte)1);
            leaveGroupValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label1012;
            localByteBuffer.put((byte)0);
            break label1012;
            localByteBuffer.put((byte)1);
            reportValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label1072;
            localByteBuffer.put((byte)0);
            break label1072;
            localByteBuffer.put((byte)1);
            surveyValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label1132;
            localByteBuffer.put((byte)0);
            break label1132;
            localByteBuffer.put((byte)1);
            incorrectlyMentionedMemberValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label1192;
            localByteBuffer.put((byte)0);
            break label1192;
            localByteBuffer.put((byte)1);
            incorrectlyMentionedCompanyValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label1252;
            localByteBuffer.put((byte)0);
            break label1252;
            localByteBuffer.put((byte)1);
            shareViaValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break label1312;
            localByteBuffer.put((byte)0);
            break label1312;
            localByteBuffer.put((byte)1);
            editShareValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.UpdateAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */