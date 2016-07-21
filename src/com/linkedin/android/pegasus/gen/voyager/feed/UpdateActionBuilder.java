package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.Delete;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.DeleteBuilder;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.EditShare;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.EditShareBuilder;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.Feedback;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.FeedbackBuilder;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.FollowChannel;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.FollowChannelBuilder;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.FollowCompany;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.FollowCompanyBuilder;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.FollowGroup;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.FollowGroupBuilder;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.FollowMember;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.FollowMemberBuilder;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.FollowSchool;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.FollowSchoolBuilder;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.IncorrectlyMentionedCompany;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.IncorrectlyMentionedCompanyBuilder;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.IncorrectlyMentionedMember;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.IncorrectlyMentionedMemberBuilder;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.LeaveGroup;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.LeaveGroupBuilder;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.Reasoning;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.ReasoningBuilder;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.Report;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.ReportBuilder;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.ShareVia;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.ShareViaBuilder;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.Survey;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.SurveyBuilder;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.UnfollowActions;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.UnfollowActionsBuilder;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.UnfollowChannel;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.UnfollowChannelBuilder;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.UnfollowCompany;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.UnfollowCompanyBuilder;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.UnfollowGroup;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.UnfollowGroupBuilder;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.UnfollowMember;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.UnfollowMemberBuilder;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.UnfollowSchool;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.UnfollowSchoolBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class UpdateActionBuilder
  implements FissileDataModelBuilder<UpdateAction>, DataTemplateBuilder<UpdateAction>
{
  public static final UpdateActionBuilder INSTANCE = new UpdateActionBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("value");
  }
  
  public static UpdateAction build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject = null;
    boolean bool = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("value", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = ValueBuilder.INSTANCE;
        localObject = ValueBuilder.build(paramDataReader);
        bool = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool) {
      throw new DataReaderException("Failed to find required field: value when building com.linkedin.android.pegasus.gen.voyager.feed.UpdateAction");
    }
    return new UpdateAction((UpdateAction.Value)localObject, bool);
  }
  
  public static UpdateAction readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building UpdateAction");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building UpdateAction");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building UpdateAction");
    }
    if (((ByteBuffer)localObject1).getInt() != 1398081755)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building UpdateAction");
    }
    paramString = null;
    localObject2 = null;
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool1 = true;
      bool2 = bool1;
      if (bool1)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = (String)localObject2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localObject2 = ValueBuilder.INSTANCE;
          paramString = ValueBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label330;
          }
          bool1 = true;
        }
        label267:
        bool2 = bool1;
        if (i == 1)
        {
          paramString = ValueBuilder.INSTANCE;
          paramString = ValueBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label336;
          }
        }
      }
    }
    label330:
    label336:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool2) {
        break label342;
      }
      throw new IOException("Failed to find required field: value when reading com.linkedin.android.pegasus.gen.voyager.feed.UpdateAction from fission.");
      bool1 = false;
      break;
      bool1 = false;
      break label267;
    }
    label342:
    return new UpdateAction(paramString, bool2);
  }
  
  public static final class ValueBuilder
    implements FissileDataModelBuilder<UpdateAction.Value>, DataTemplateBuilder<UpdateAction.Value>
  {
    public static final ValueBuilder INSTANCE = new ValueBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.voyager.feed.actions.Delete");
      JSON_KEY_STORE.put("com.linkedin.voyager.feed.actions.Reasoning");
      JSON_KEY_STORE.put("com.linkedin.voyager.feed.actions.Feedback");
      JSON_KEY_STORE.put("com.linkedin.voyager.feed.actions.UnfollowActions");
      JSON_KEY_STORE.put("com.linkedin.voyager.feed.actions.UnfollowMember");
      JSON_KEY_STORE.put("com.linkedin.voyager.feed.actions.UnfollowCompany");
      JSON_KEY_STORE.put("com.linkedin.voyager.feed.actions.UnfollowChannel");
      JSON_KEY_STORE.put("com.linkedin.voyager.feed.actions.UnfollowSchool");
      JSON_KEY_STORE.put("com.linkedin.voyager.feed.actions.UnfollowGroup");
      JSON_KEY_STORE.put("com.linkedin.voyager.feed.actions.FollowMember");
      JSON_KEY_STORE.put("com.linkedin.voyager.feed.actions.FollowCompany");
      JSON_KEY_STORE.put("com.linkedin.voyager.feed.actions.FollowChannel");
      JSON_KEY_STORE.put("com.linkedin.voyager.feed.actions.FollowSchool");
      JSON_KEY_STORE.put("com.linkedin.voyager.feed.actions.FollowGroup");
      JSON_KEY_STORE.put("com.linkedin.voyager.feed.actions.LeaveGroup");
      JSON_KEY_STORE.put("com.linkedin.voyager.feed.actions.Report");
      JSON_KEY_STORE.put("com.linkedin.voyager.feed.actions.Survey");
      JSON_KEY_STORE.put("com.linkedin.voyager.feed.actions.IncorrectlyMentionedMember");
      JSON_KEY_STORE.put("com.linkedin.voyager.feed.actions.IncorrectlyMentionedCompany");
      JSON_KEY_STORE.put("com.linkedin.voyager.feed.actions.ShareVia");
      JSON_KEY_STORE.put("com.linkedin.voyager.feed.actions.EditShare");
    }
    
    public static UpdateAction.Value build(DataReader paramDataReader)
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
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.actions.Delete", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject21 = DeleteBuilder.INSTANCE;
          localObject21 = DeleteBuilder.build(paramDataReader);
          bool21 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.actions.Reasoning", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject20 = ReasoningBuilder.INSTANCE;
          localObject20 = ReasoningBuilder.build(paramDataReader);
          bool20 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.actions.Feedback", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject19 = FeedbackBuilder.INSTANCE;
          localObject19 = FeedbackBuilder.build(paramDataReader);
          bool19 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.actions.UnfollowActions", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject18 = UnfollowActionsBuilder.INSTANCE;
          localObject18 = UnfollowActionsBuilder.build(paramDataReader);
          bool18 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.actions.UnfollowMember", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject17 = UnfollowMemberBuilder.INSTANCE;
          localObject17 = UnfollowMemberBuilder.build(paramDataReader);
          bool17 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.actions.UnfollowCompany", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject16 = UnfollowCompanyBuilder.INSTANCE;
          localObject16 = UnfollowCompanyBuilder.build(paramDataReader);
          bool16 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.actions.UnfollowChannel", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject15 = UnfollowChannelBuilder.INSTANCE;
          localObject15 = UnfollowChannelBuilder.build(paramDataReader);
          bool15 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.actions.UnfollowSchool", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject14 = UnfollowSchoolBuilder.INSTANCE;
          localObject14 = UnfollowSchoolBuilder.build(paramDataReader);
          bool14 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.actions.UnfollowGroup", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject13 = UnfollowGroupBuilder.INSTANCE;
          localObject13 = UnfollowGroupBuilder.build(paramDataReader);
          bool13 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.actions.FollowMember", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject12 = FollowMemberBuilder.INSTANCE;
          localObject12 = FollowMemberBuilder.build(paramDataReader);
          bool12 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.actions.FollowCompany", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject11 = FollowCompanyBuilder.INSTANCE;
          localObject11 = FollowCompanyBuilder.build(paramDataReader);
          bool11 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.actions.FollowChannel", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject10 = FollowChannelBuilder.INSTANCE;
          localObject10 = FollowChannelBuilder.build(paramDataReader);
          bool10 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.actions.FollowSchool", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject9 = FollowSchoolBuilder.INSTANCE;
          localObject9 = FollowSchoolBuilder.build(paramDataReader);
          bool9 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.actions.FollowGroup", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject8 = FollowGroupBuilder.INSTANCE;
          localObject8 = FollowGroupBuilder.build(paramDataReader);
          bool8 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.actions.LeaveGroup", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject7 = LeaveGroupBuilder.INSTANCE;
          localObject7 = LeaveGroupBuilder.build(paramDataReader);
          bool7 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.actions.Report", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject6 = ReportBuilder.INSTANCE;
          localObject6 = ReportBuilder.build(paramDataReader);
          bool6 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.actions.Survey", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject5 = SurveyBuilder.INSTANCE;
          localObject5 = SurveyBuilder.build(paramDataReader);
          bool5 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.actions.IncorrectlyMentionedMember", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject4 = IncorrectlyMentionedMemberBuilder.INSTANCE;
          localObject4 = IncorrectlyMentionedMemberBuilder.build(paramDataReader);
          bool4 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.actions.IncorrectlyMentionedCompany", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject3 = IncorrectlyMentionedCompanyBuilder.INSTANCE;
          localObject3 = IncorrectlyMentionedCompanyBuilder.build(paramDataReader);
          bool3 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.actions.ShareVia", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = ShareViaBuilder.INSTANCE;
          localObject2 = ShareViaBuilder.build(paramDataReader);
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.actions.EditShare", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = EditShareBuilder.INSTANCE;
          localObject1 = EditShareBuilder.build(paramDataReader);
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
      return new UpdateAction.Value((Delete)localObject21, (Reasoning)localObject20, (Feedback)localObject19, (UnfollowActions)localObject18, (UnfollowMember)localObject17, (UnfollowCompany)localObject16, (UnfollowChannel)localObject15, (UnfollowSchool)localObject14, (UnfollowGroup)localObject13, (FollowMember)localObject12, (FollowCompany)localObject11, (FollowChannel)localObject10, (FollowSchool)localObject9, (FollowGroup)localObject8, (LeaveGroup)localObject7, (Report)localObject6, (Survey)localObject5, (IncorrectlyMentionedMember)localObject4, (IncorrectlyMentionedCompany)localObject3, (ShareVia)localObject2, (EditShare)localObject1, bool21, bool20, bool19, bool18, bool17, bool16, bool15, bool14, bool13, bool12, bool11, bool10, bool9, bool8, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
    }
    
    public static UpdateAction.Value readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building UpdateAction.Value");
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
        throw new IOException("Invalid header prefix. Can't read cached data when building UpdateAction.Value");
      }
      Object localObject21 = localObject1;
      if (((ByteBuffer)localObject1).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("Invalid header prefix. Can't read cached data when building UpdateAction.Value");
      }
      if (((ByteBuffer)localObject21).getInt() != -1963863441)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject21);
        throw new IOException("UID mismatch. Can't read cached data when building UpdateAction.Value");
      }
      paramString = null;
      DeleteBuilder localDeleteBuilder = null;
      localObject1 = null;
      ReasoningBuilder localReasoningBuilder = null;
      Object localObject2 = null;
      FeedbackBuilder localFeedbackBuilder = null;
      Object localObject3 = null;
      UnfollowActionsBuilder localUnfollowActionsBuilder = null;
      Object localObject4 = null;
      UnfollowMemberBuilder localUnfollowMemberBuilder = null;
      Object localObject5 = null;
      UnfollowCompanyBuilder localUnfollowCompanyBuilder = null;
      Object localObject6 = null;
      UnfollowChannelBuilder localUnfollowChannelBuilder = null;
      Object localObject7 = null;
      UnfollowSchoolBuilder localUnfollowSchoolBuilder = null;
      Object localObject8 = null;
      UnfollowGroupBuilder localUnfollowGroupBuilder = null;
      Object localObject9 = null;
      FollowMemberBuilder localFollowMemberBuilder = null;
      Object localObject10 = null;
      FollowCompanyBuilder localFollowCompanyBuilder = null;
      Object localObject11 = null;
      FollowChannelBuilder localFollowChannelBuilder = null;
      Object localObject12 = null;
      FollowSchoolBuilder localFollowSchoolBuilder = null;
      Object localObject13 = null;
      FollowGroupBuilder localFollowGroupBuilder = null;
      Object localObject14 = null;
      LeaveGroupBuilder localLeaveGroupBuilder = null;
      Object localObject15 = null;
      ReportBuilder localReportBuilder = null;
      Object localObject16 = null;
      SurveyBuilder localSurveyBuilder = null;
      Object localObject17 = null;
      IncorrectlyMentionedMemberBuilder localIncorrectlyMentionedMemberBuilder = null;
      Object localObject18 = null;
      IncorrectlyMentionedCompanyBuilder localIncorrectlyMentionedCompanyBuilder = null;
      Object localObject19 = null;
      ShareViaBuilder localShareViaBuilder = null;
      Object localObject20 = null;
      EditShareBuilder localEditShareBuilder = null;
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
          paramString = localDeleteBuilder;
          bool1 = bool2;
          if (i == 0)
          {
            paramString = paramFissionAdapter.readString((ByteBuffer)localObject21);
            localDeleteBuilder = DeleteBuilder.INSTANCE;
            paramString = DeleteBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label2536;
            }
            bool1 = true;
          }
          if (i == 1)
          {
            paramString = DeleteBuilder.INSTANCE;
            paramString = DeleteBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
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
          localObject1 = localReasoningBuilder;
          bool2 = bool3;
          if (i == 0)
          {
            localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject21);
            localReasoningBuilder = ReasoningBuilder.INSTANCE;
            localObject1 = ReasoningBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
            if (localObject1 == null) {
              break label2554;
            }
            bool2 = true;
          }
          if (i == 1)
          {
            localObject1 = ReasoningBuilder.INSTANCE;
            localObject1 = ReasoningBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
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
          localObject2 = localFeedbackBuilder;
          bool3 = bool4;
          if (i == 0)
          {
            localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject21);
            localFeedbackBuilder = FeedbackBuilder.INSTANCE;
            localObject2 = FeedbackBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
            if (localObject2 == null) {
              break label2572;
            }
            bool3 = true;
          }
          if (i == 1)
          {
            localObject2 = FeedbackBuilder.INSTANCE;
            localObject2 = FeedbackBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
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
          localObject3 = localUnfollowActionsBuilder;
          bool4 = bool5;
          if (i == 0)
          {
            localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject21);
            localUnfollowActionsBuilder = UnfollowActionsBuilder.INSTANCE;
            localObject3 = UnfollowActionsBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
            if (localObject3 == null) {
              break label2590;
            }
            bool4 = true;
          }
          if (i == 1)
          {
            localObject3 = UnfollowActionsBuilder.INSTANCE;
            localObject3 = UnfollowActionsBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
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
          localObject4 = localUnfollowMemberBuilder;
          bool5 = bool6;
          if (i == 0)
          {
            localObject4 = paramFissionAdapter.readString((ByteBuffer)localObject21);
            localUnfollowMemberBuilder = UnfollowMemberBuilder.INSTANCE;
            localObject4 = UnfollowMemberBuilder.readFromFission(paramFissionAdapter, null, (String)localObject4, paramFissionTransaction);
            if (localObject4 == null) {
              break label2608;
            }
            bool5 = true;
          }
          if (i == 1)
          {
            localObject4 = UnfollowMemberBuilder.INSTANCE;
            localObject4 = UnfollowMemberBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
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
          localObject5 = localUnfollowCompanyBuilder;
          bool6 = bool7;
          if (i == 0)
          {
            localObject5 = paramFissionAdapter.readString((ByteBuffer)localObject21);
            localUnfollowCompanyBuilder = UnfollowCompanyBuilder.INSTANCE;
            localObject5 = UnfollowCompanyBuilder.readFromFission(paramFissionAdapter, null, (String)localObject5, paramFissionTransaction);
            if (localObject5 == null) {
              break label2626;
            }
            bool6 = true;
          }
          if (i == 1)
          {
            localObject5 = UnfollowCompanyBuilder.INSTANCE;
            localObject5 = UnfollowCompanyBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
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
          localObject6 = localUnfollowChannelBuilder;
          bool7 = bool8;
          if (i == 0)
          {
            localObject6 = paramFissionAdapter.readString((ByteBuffer)localObject21);
            localUnfollowChannelBuilder = UnfollowChannelBuilder.INSTANCE;
            localObject6 = UnfollowChannelBuilder.readFromFission(paramFissionAdapter, null, (String)localObject6, paramFissionTransaction);
            if (localObject6 == null) {
              break label2644;
            }
            bool7 = true;
          }
          if (i == 1)
          {
            localObject6 = UnfollowChannelBuilder.INSTANCE;
            localObject6 = UnfollowChannelBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
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
          localObject7 = localUnfollowSchoolBuilder;
          bool8 = bool9;
          if (i == 0)
          {
            localObject7 = paramFissionAdapter.readString((ByteBuffer)localObject21);
            localUnfollowSchoolBuilder = UnfollowSchoolBuilder.INSTANCE;
            localObject7 = UnfollowSchoolBuilder.readFromFission(paramFissionAdapter, null, (String)localObject7, paramFissionTransaction);
            if (localObject7 == null) {
              break label2662;
            }
            bool8 = true;
          }
          if (i == 1)
          {
            localObject7 = UnfollowSchoolBuilder.INSTANCE;
            localObject7 = UnfollowSchoolBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
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
          localObject8 = localUnfollowGroupBuilder;
          bool9 = bool10;
          if (i == 0)
          {
            localObject8 = paramFissionAdapter.readString((ByteBuffer)localObject21);
            localUnfollowGroupBuilder = UnfollowGroupBuilder.INSTANCE;
            localObject8 = UnfollowGroupBuilder.readFromFission(paramFissionAdapter, null, (String)localObject8, paramFissionTransaction);
            if (localObject8 == null) {
              break label2680;
            }
            bool9 = true;
          }
          if (i == 1)
          {
            localObject8 = UnfollowGroupBuilder.INSTANCE;
            localObject8 = UnfollowGroupBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
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
          localObject9 = localFollowMemberBuilder;
          bool10 = bool11;
          if (i == 0)
          {
            localObject9 = paramFissionAdapter.readString((ByteBuffer)localObject21);
            localFollowMemberBuilder = FollowMemberBuilder.INSTANCE;
            localObject9 = FollowMemberBuilder.readFromFission(paramFissionAdapter, null, (String)localObject9, paramFissionTransaction);
            if (localObject9 == null) {
              break label2698;
            }
            bool10 = true;
          }
          if (i == 1)
          {
            localObject9 = FollowMemberBuilder.INSTANCE;
            localObject9 = FollowMemberBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
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
          localObject10 = localFollowCompanyBuilder;
          bool11 = bool12;
          if (i == 0)
          {
            localObject10 = paramFissionAdapter.readString((ByteBuffer)localObject21);
            localFollowCompanyBuilder = FollowCompanyBuilder.INSTANCE;
            localObject10 = FollowCompanyBuilder.readFromFission(paramFissionAdapter, null, (String)localObject10, paramFissionTransaction);
            if (localObject10 == null) {
              break label2716;
            }
            bool11 = true;
          }
          if (i == 1)
          {
            localObject10 = FollowCompanyBuilder.INSTANCE;
            localObject10 = FollowCompanyBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
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
          localObject11 = localFollowChannelBuilder;
          bool12 = bool13;
          if (i == 0)
          {
            localObject11 = paramFissionAdapter.readString((ByteBuffer)localObject21);
            localFollowChannelBuilder = FollowChannelBuilder.INSTANCE;
            localObject11 = FollowChannelBuilder.readFromFission(paramFissionAdapter, null, (String)localObject11, paramFissionTransaction);
            if (localObject11 == null) {
              break label2734;
            }
            bool12 = true;
          }
          if (i == 1)
          {
            localObject11 = FollowChannelBuilder.INSTANCE;
            localObject11 = FollowChannelBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
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
          localObject12 = localFollowSchoolBuilder;
          bool13 = bool14;
          if (i == 0)
          {
            localObject12 = paramFissionAdapter.readString((ByteBuffer)localObject21);
            localFollowSchoolBuilder = FollowSchoolBuilder.INSTANCE;
            localObject12 = FollowSchoolBuilder.readFromFission(paramFissionAdapter, null, (String)localObject12, paramFissionTransaction);
            if (localObject12 == null) {
              break label2752;
            }
            bool13 = true;
          }
          if (i == 1)
          {
            localObject12 = FollowSchoolBuilder.INSTANCE;
            localObject12 = FollowSchoolBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
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
          localObject13 = localFollowGroupBuilder;
          bool14 = bool15;
          if (i == 0)
          {
            localObject13 = paramFissionAdapter.readString((ByteBuffer)localObject21);
            localFollowGroupBuilder = FollowGroupBuilder.INSTANCE;
            localObject13 = FollowGroupBuilder.readFromFission(paramFissionAdapter, null, (String)localObject13, paramFissionTransaction);
            if (localObject13 == null) {
              break label2770;
            }
            bool14 = true;
          }
          if (i == 1)
          {
            localObject13 = FollowGroupBuilder.INSTANCE;
            localObject13 = FollowGroupBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
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
          localObject14 = localLeaveGroupBuilder;
          bool15 = bool16;
          if (i == 0)
          {
            localObject14 = paramFissionAdapter.readString((ByteBuffer)localObject21);
            localLeaveGroupBuilder = LeaveGroupBuilder.INSTANCE;
            localObject14 = LeaveGroupBuilder.readFromFission(paramFissionAdapter, null, (String)localObject14, paramFissionTransaction);
            if (localObject14 == null) {
              break label2788;
            }
            bool15 = true;
          }
          if (i == 1)
          {
            localObject14 = LeaveGroupBuilder.INSTANCE;
            localObject14 = LeaveGroupBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
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
          localObject15 = localReportBuilder;
          bool16 = bool17;
          if (i == 0)
          {
            localObject15 = paramFissionAdapter.readString((ByteBuffer)localObject21);
            localReportBuilder = ReportBuilder.INSTANCE;
            localObject15 = ReportBuilder.readFromFission(paramFissionAdapter, null, (String)localObject15, paramFissionTransaction);
            if (localObject15 == null) {
              break label2806;
            }
            bool16 = true;
          }
          if (i == 1)
          {
            localObject15 = ReportBuilder.INSTANCE;
            localObject15 = ReportBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
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
          localObject16 = localSurveyBuilder;
          bool17 = bool18;
          if (i == 0)
          {
            localObject16 = paramFissionAdapter.readString((ByteBuffer)localObject21);
            localSurveyBuilder = SurveyBuilder.INSTANCE;
            localObject16 = SurveyBuilder.readFromFission(paramFissionAdapter, null, (String)localObject16, paramFissionTransaction);
            if (localObject16 == null) {
              break label2824;
            }
            bool17 = true;
          }
          if (i == 1)
          {
            localObject16 = SurveyBuilder.INSTANCE;
            localObject16 = SurveyBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
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
          localObject17 = localIncorrectlyMentionedMemberBuilder;
          bool18 = bool19;
          if (i == 0)
          {
            localObject17 = paramFissionAdapter.readString((ByteBuffer)localObject21);
            localIncorrectlyMentionedMemberBuilder = IncorrectlyMentionedMemberBuilder.INSTANCE;
            localObject17 = IncorrectlyMentionedMemberBuilder.readFromFission(paramFissionAdapter, null, (String)localObject17, paramFissionTransaction);
            if (localObject17 == null) {
              break label2842;
            }
            bool18 = true;
          }
          if (i == 1)
          {
            localObject17 = IncorrectlyMentionedMemberBuilder.INSTANCE;
            localObject17 = IncorrectlyMentionedMemberBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
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
          localObject18 = localIncorrectlyMentionedCompanyBuilder;
          bool19 = bool20;
          if (i == 0)
          {
            localObject18 = paramFissionAdapter.readString((ByteBuffer)localObject21);
            localIncorrectlyMentionedCompanyBuilder = IncorrectlyMentionedCompanyBuilder.INSTANCE;
            localObject18 = IncorrectlyMentionedCompanyBuilder.readFromFission(paramFissionAdapter, null, (String)localObject18, paramFissionTransaction);
            if (localObject18 == null) {
              break label2860;
            }
            bool19 = true;
          }
          if (i == 1)
          {
            localObject18 = IncorrectlyMentionedCompanyBuilder.INSTANCE;
            localObject18 = IncorrectlyMentionedCompanyBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
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
          localObject19 = localShareViaBuilder;
          bool20 = bool21;
          if (i == 0)
          {
            localObject19 = paramFissionAdapter.readString((ByteBuffer)localObject21);
            localShareViaBuilder = ShareViaBuilder.INSTANCE;
            localObject19 = ShareViaBuilder.readFromFission(paramFissionAdapter, null, (String)localObject19, paramFissionTransaction);
            if (localObject19 == null) {
              break label2878;
            }
            bool20 = true;
          }
          label2350:
          if (i == 1)
          {
            localObject19 = ShareViaBuilder.INSTANCE;
            localObject19 = ShareViaBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
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
          localObject20 = localEditShareBuilder;
          if (i == 0)
          {
            localObject20 = paramFissionAdapter.readString((ByteBuffer)localObject21);
            localEditShareBuilder = EditShareBuilder.INSTANCE;
            localObject20 = EditShareBuilder.readFromFission(paramFissionAdapter, null, (String)localObject20, paramFissionTransaction);
            if (localObject20 == null) {
              break label2896;
            }
            bool21 = true;
          }
          label2449:
          bool22 = bool21;
          if (i == 1)
          {
            localObject20 = EditShareBuilder.INSTANCE;
            localObject20 = EditShareBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject21, null, paramFissionTransaction);
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
      return new UpdateAction.Value(paramString, (Reasoning)localObject1, (Feedback)localObject2, (UnfollowActions)localObject3, (UnfollowMember)localObject4, (UnfollowCompany)localObject5, (UnfollowChannel)localObject6, (UnfollowSchool)localObject7, (UnfollowGroup)localObject8, (FollowMember)localObject9, (FollowCompany)localObject10, (FollowChannel)localObject11, (FollowSchool)localObject12, (FollowGroup)localObject13, (LeaveGroup)localObject14, (Report)localObject15, (Survey)localObject16, (IncorrectlyMentionedMember)localObject17, (IncorrectlyMentionedCompany)localObject18, (ShareVia)localObject19, (EditShare)localObject20, bool1, bool2, bool3, bool4, bool5, bool6, bool7, bool8, bool9, bool10, bool11, bool12, bool13, bool14, bool15, bool16, bool17, bool18, bool19, bool20, bool22);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.UpdateActionBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */