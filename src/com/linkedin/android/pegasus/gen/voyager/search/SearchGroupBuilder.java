package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.GroupMembershipInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.GroupMembershipInfoBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroupBuilder;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.annotation.AnnotatedText;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.annotation.AnnotatedTextBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SearchGroupBuilder
  implements FissileDataModelBuilder<SearchGroup>, DataTemplateBuilder<SearchGroup>
{
  public static final SearchGroupBuilder INSTANCE = new SearchGroupBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("id");
    JSON_KEY_STORE.put("backendUrn");
    JSON_KEY_STORE.put("group");
    JSON_KEY_STORE.put("open");
    JSON_KEY_STORE.put("summary");
    JSON_KEY_STORE.put("memberCount");
    JSON_KEY_STORE.put("discussionActivity");
    JSON_KEY_STORE.put("membershipInfo");
  }
  
  public static SearchGroup build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str = null;
    Object localObject5 = null;
    Object localObject4 = null;
    boolean bool9 = false;
    Object localObject3 = null;
    int i = 0;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool8 = false;
    boolean bool7 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("id", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("backendUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject5 = UrnCoercer.INSTANCE;
        localObject5 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("group", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = MiniGroupBuilder.INSTANCE;
        localObject4 = MiniGroupBuilder.build(paramDataReader);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("open", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool9 = paramDataReader.readBoolean();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("summary", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = AnnotatedTextBuilder.INSTANCE;
        localObject3 = AnnotatedTextBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("memberCount", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("discussionActivity", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = DiscussionActivityInfoBuilder.INSTANCE;
        localObject2 = DiscussionActivityInfoBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("membershipInfo", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = GroupMembershipInfoBuilder.INSTANCE;
        localObject1 = GroupMembershipInfoBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool8) {
      throw new DataReaderException("Failed to find required field: id when building com.linkedin.android.pegasus.gen.voyager.search.SearchGroup");
    }
    if (!bool7) {
      throw new DataReaderException("Failed to find required field: backendUrn when building com.linkedin.android.pegasus.gen.voyager.search.SearchGroup");
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: group when building com.linkedin.android.pegasus.gen.voyager.search.SearchGroup");
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: open when building com.linkedin.android.pegasus.gen.voyager.search.SearchGroup");
    }
    return new SearchGroup(str, (Urn)localObject5, (MiniGroup)localObject4, bool9, (AnnotatedText)localObject3, i, (DiscussionActivityInfo)localObject2, (GroupMembershipInfo)localObject1, bool8, bool7, bool5, bool6, bool4, bool3, bool2, bool1);
  }
  
  public static SearchGroup readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SearchGroup");
    }
    Object localObject1 = paramByteBuffer;
    int j;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SearchGroup");
    }
    Object localObject4 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building SearchGroup");
    }
    if (((ByteBuffer)localObject4).getInt() != -176530318)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject4);
      throw new IOException("UID mismatch. Can't read cached data when building SearchGroup");
    }
    String str = null;
    Object localObject5 = null;
    paramString = null;
    MiniGroupBuilder localMiniGroupBuilder = null;
    boolean bool6 = false;
    localObject1 = null;
    AnnotatedTextBuilder localAnnotatedTextBuilder = null;
    int i = 0;
    Object localObject2 = null;
    DiscussionActivityInfoBuilder localDiscussionActivityInfoBuilder = null;
    Object localObject3 = null;
    GroupMembershipInfoBuilder localGroupMembershipInfoBuilder = null;
    boolean bool7;
    boolean bool8;
    label271:
    boolean bool2;
    label306:
    boolean bool1;
    label363:
    label389:
    boolean bool9;
    label401:
    label418:
    boolean bool3;
    label430:
    label492:
    label521:
    boolean bool10;
    label533:
    boolean bool4;
    if (((ByteBuffer)localObject4).get() == 1)
    {
      bool7 = true;
      if (bool7) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject4);
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label784;
      }
      bool8 = true;
      if (bool8)
      {
        localObject5 = UrnCoercer.INSTANCE;
        localObject5 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject4));
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label790;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        j = ((ByteBuffer)localObject4).get();
        paramString = localMiniGroupBuilder;
        bool1 = bool2;
        if (j == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localMiniGroupBuilder = MiniGroupBuilder.INSTANCE;
          paramString = MiniGroupBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label796;
          }
          bool1 = true;
        }
        if (j == 1)
        {
          paramString = MiniGroupBuilder.INSTANCE;
          paramString = MiniGroupBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (paramString == null) {
            break label802;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label808;
      }
      bool9 = true;
      if (bool9)
      {
        if (((ByteBuffer)localObject4).get() != 1) {
          break label814;
        }
        bool6 = true;
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label820;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        j = ((ByteBuffer)localObject4).get();
        localObject1 = localAnnotatedTextBuilder;
        bool2 = bool3;
        if (j == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localAnnotatedTextBuilder = AnnotatedTextBuilder.INSTANCE;
          localObject1 = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label826;
          }
          bool2 = true;
        }
        if (j == 1)
        {
          localObject1 = AnnotatedTextBuilder.INSTANCE;
          localObject1 = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label832;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label838;
      }
      bool10 = true;
      if (bool10) {
        i = ((ByteBuffer)localObject4).getInt();
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label844;
      }
      bool4 = true;
      label557:
      bool3 = bool4;
      if (bool4)
      {
        j = ((ByteBuffer)localObject4).get();
        localObject2 = localDiscussionActivityInfoBuilder;
        bool3 = bool4;
        if (j == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localDiscussionActivityInfoBuilder = DiscussionActivityInfoBuilder.INSTANCE;
          localObject2 = DiscussionActivityInfoBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label850;
          }
          bool3 = true;
        }
        label619:
        if (j == 1)
        {
          localObject2 = DiscussionActivityInfoBuilder.INSTANCE;
          localObject2 = DiscussionActivityInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label856;
          }
          bool3 = true;
        }
      }
      label648:
      if (((ByteBuffer)localObject4).get() != 1) {
        break label862;
      }
      bool4 = true;
      label660:
      bool5 = bool4;
      if (bool4)
      {
        j = ((ByteBuffer)localObject4).get();
        localObject3 = localGroupMembershipInfoBuilder;
        if (j == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localGroupMembershipInfoBuilder = GroupMembershipInfoBuilder.INSTANCE;
          localObject3 = GroupMembershipInfoBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label868;
          }
          bool4 = true;
        }
        label718:
        bool5 = bool4;
        if (j == 1)
        {
          localObject3 = GroupMembershipInfoBuilder.INSTANCE;
          localObject3 = GroupMembershipInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label874;
          }
        }
      }
    }
    label784:
    label790:
    label796:
    label802:
    label808:
    label814:
    label820:
    label826:
    label832:
    label838:
    label844:
    label850:
    label856:
    label862:
    label868:
    label874:
    for (boolean bool5 = true;; bool5 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject4);
      }
      if (bool7) {
        break label880;
      }
      throw new IOException("Failed to find required field: id when reading com.linkedin.android.pegasus.gen.voyager.search.SearchGroup from fission.");
      bool7 = false;
      break;
      bool8 = false;
      break label271;
      bool2 = false;
      break label306;
      bool1 = false;
      break label363;
      bool1 = false;
      break label389;
      bool9 = false;
      break label401;
      bool6 = false;
      break label418;
      bool3 = false;
      break label430;
      bool2 = false;
      break label492;
      bool2 = false;
      break label521;
      bool10 = false;
      break label533;
      bool4 = false;
      break label557;
      bool3 = false;
      break label619;
      bool3 = false;
      break label648;
      bool4 = false;
      break label660;
      bool4 = false;
      break label718;
    }
    label880:
    if (!bool8) {
      throw new IOException("Failed to find required field: backendUrn when reading com.linkedin.android.pegasus.gen.voyager.search.SearchGroup from fission.");
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: group when reading com.linkedin.android.pegasus.gen.voyager.search.SearchGroup from fission.");
    }
    if (!bool9) {
      throw new IOException("Failed to find required field: open when reading com.linkedin.android.pegasus.gen.voyager.search.SearchGroup from fission.");
    }
    return new SearchGroup(str, (Urn)localObject5, paramString, bool6, (AnnotatedText)localObject1, i, (DiscussionActivityInfo)localObject2, (GroupMembershipInfo)localObject3, bool7, bool8, bool1, bool9, bool2, bool10, bool3, bool5);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchGroupBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */