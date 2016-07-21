package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedTextBuilder;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.common.ImageBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MemberFollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MemberFollowingInfoBuilder;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCountsBuilder;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfileBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SearchArticleBuilder
  implements FissileDataModelBuilder<SearchArticle>, DataTemplateBuilder<SearchArticle>
{
  public static final SearchArticleBuilder INSTANCE = new SearchArticleBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("backendUrn");
    JSON_KEY_STORE.put("title");
    JSON_KEY_STORE.put("url");
    JSON_KEY_STORE.put("authorName");
    JSON_KEY_STORE.put("authorFollowersCount");
    JSON_KEY_STORE.put("authorProfile");
    JSON_KEY_STORE.put("authorFollowing");
    JSON_KEY_STORE.put("image");
    JSON_KEY_STORE.put("snippet");
    JSON_KEY_STORE.put("contentSnippet");
    JSON_KEY_STORE.put("postedAt");
    JSON_KEY_STORE.put("parentUrl");
    JSON_KEY_STORE.put("socialActivityInfo");
  }
  
  public static SearchArticle build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject6 = null;
    String str5 = null;
    String str4 = null;
    String str3 = null;
    long l2 = 0L;
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    String str2 = null;
    Object localObject2 = null;
    long l1 = 0L;
    String str1 = null;
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
      if (paramDataReader.shouldReadField$11ca93e7("backendUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject6 = UrnCoercer.INSTANCE;
        localObject6 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool13 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("title", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str5 = paramDataReader.readString();
        bool12 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("url", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str4 = paramDataReader.readString();
        bool11 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("authorName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool10 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("authorFollowersCount", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l2 = paramDataReader.readLong();
        bool9 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("authorProfile", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject5 = MiniProfileBuilder.INSTANCE;
        localObject5 = MiniProfileBuilder.build(paramDataReader);
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("authorFollowing", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = MemberFollowingInfoBuilder.INSTANCE;
        localObject4 = MemberFollowingInfoBuilder.build(paramDataReader);
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("image", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = ImageBuilder.INSTANCE;
        localObject3 = ImageBuilder.build(paramDataReader);
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("snippet", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("contentSnippet", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = AttributedTextBuilder.INSTANCE;
        localObject2 = AttributedTextBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("postedAt", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l1 = paramDataReader.readLong();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("parentUrl", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("socialActivityInfo", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = SocialActivityCountsBuilder.INSTANCE;
        localObject1 = SocialActivityCountsBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool13) {
      throw new DataReaderException("Failed to find required field: backendUrn when building com.linkedin.android.pegasus.gen.voyager.search.SearchArticle");
    }
    return new SearchArticle((Urn)localObject6, str5, str4, str3, l2, (MiniProfile)localObject5, (MemberFollowingInfo)localObject4, (Image)localObject3, str2, (AttributedText)localObject2, l1, str1, (SocialActivityCounts)localObject1, bool13, bool12, bool11, bool10, bool9, bool8, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static SearchArticle readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SearchArticle");
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
      int j;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SearchArticle");
    }
    Object localObject5 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building SearchArticle");
    }
    if (((ByteBuffer)localObject5).getInt() != -746223894)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject5);
      throw new IOException("UID mismatch. Can't read cached data when building SearchArticle");
    }
    Object localObject6 = null;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    long l1 = 0L;
    paramString = null;
    MiniProfileBuilder localMiniProfileBuilder = null;
    localObject1 = null;
    MemberFollowingInfoBuilder localMemberFollowingInfoBuilder = null;
    Object localObject2 = null;
    ImageBuilder localImageBuilder = null;
    String str4 = null;
    Object localObject3 = null;
    AttributedTextBuilder localAttributedTextBuilder = null;
    long l2 = 0L;
    String str5 = null;
    Object localObject4 = null;
    SocialActivityCountsBuilder localSocialActivityCountsBuilder = null;
    boolean bool7;
    boolean bool8;
    label297:
    boolean bool9;
    label324:
    boolean bool10;
    label351:
    boolean bool11;
    label378:
    boolean bool2;
    label402:
    boolean bool1;
    label459:
    label485:
    boolean bool3;
    label497:
    label559:
    label588:
    boolean bool4;
    label600:
    label662:
    label691:
    boolean bool12;
    label703:
    boolean bool5;
    label730:
    label792:
    label821:
    boolean bool13;
    label833:
    boolean bool14;
    if (((ByteBuffer)localObject5).get() == 1)
    {
      bool7 = true;
      if (bool7)
      {
        localObject6 = UrnCoercer.INSTANCE;
        localObject6 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject5));
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label1008;
      }
      bool8 = true;
      if (bool8) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject5);
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label1014;
      }
      bool9 = true;
      if (bool9) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject5);
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label1020;
      }
      bool10 = true;
      if (bool10) {
        str3 = paramFissionAdapter.readString((ByteBuffer)localObject5);
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label1026;
      }
      bool11 = true;
      if (bool11) {
        l1 = ((ByteBuffer)localObject5).getLong();
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label1032;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject5).get();
        paramString = localMiniProfileBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localMiniProfileBuilder = MiniProfileBuilder.INSTANCE;
          paramString = MiniProfileBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label1038;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = MiniProfileBuilder.INSTANCE;
          paramString = MiniProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (paramString == null) {
            break label1044;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label1050;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject5).get();
        localObject1 = localMemberFollowingInfoBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localMemberFollowingInfoBuilder = MemberFollowingInfoBuilder.INSTANCE;
          localObject1 = MemberFollowingInfoBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label1056;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject1 = MemberFollowingInfoBuilder.INSTANCE;
          localObject1 = MemberFollowingInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label1062;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label1068;
      }
      bool4 = true;
      bool3 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject5).get();
        localObject2 = localImageBuilder;
        bool3 = bool4;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localImageBuilder = ImageBuilder.INSTANCE;
          localObject2 = ImageBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label1074;
          }
          bool3 = true;
        }
        if (i == 1)
        {
          localObject2 = ImageBuilder.INSTANCE;
          localObject2 = ImageBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label1080;
          }
          bool3 = true;
        }
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label1086;
      }
      bool12 = true;
      if (bool12) {
        str4 = paramFissionAdapter.readString((ByteBuffer)localObject5);
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label1092;
      }
      bool5 = true;
      bool4 = bool5;
      if (bool5)
      {
        i = ((ByteBuffer)localObject5).get();
        localObject3 = localAttributedTextBuilder;
        bool4 = bool5;
        if (i == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localAttributedTextBuilder = AttributedTextBuilder.INSTANCE;
          localObject3 = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label1098;
          }
          bool4 = true;
        }
        if (i == 1)
        {
          localObject3 = AttributedTextBuilder.INSTANCE;
          localObject3 = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label1104;
          }
          bool4 = true;
        }
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label1110;
      }
      bool13 = true;
      if (bool13) {
        l2 = ((ByteBuffer)localObject5).getLong();
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label1116;
      }
      bool14 = true;
      label857:
      if (bool14) {
        str5 = paramFissionAdapter.readString((ByteBuffer)localObject5);
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label1122;
      }
      bool5 = true;
      label884:
      bool6 = bool5;
      if (bool5)
      {
        i = ((ByteBuffer)localObject5).get();
        localObject4 = localSocialActivityCountsBuilder;
        if (i == 0)
        {
          localObject4 = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localSocialActivityCountsBuilder = SocialActivityCountsBuilder.INSTANCE;
          localObject4 = SocialActivityCountsBuilder.readFromFission(paramFissionAdapter, null, (String)localObject4, paramFissionTransaction);
          if (localObject4 == null) {
            break label1128;
          }
          bool5 = true;
        }
        label942:
        bool6 = bool5;
        if (i == 1)
        {
          localObject4 = SocialActivityCountsBuilder.INSTANCE;
          localObject4 = SocialActivityCountsBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (localObject4 == null) {
            break label1134;
          }
        }
      }
    }
    label1008:
    label1014:
    label1020:
    label1026:
    label1032:
    label1038:
    label1044:
    label1050:
    label1056:
    label1062:
    label1068:
    label1074:
    label1080:
    label1086:
    label1092:
    label1098:
    label1104:
    label1110:
    label1116:
    label1122:
    label1128:
    label1134:
    for (boolean bool6 = true;; bool6 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject5);
      }
      if (bool7) {
        break label1140;
      }
      throw new IOException("Failed to find required field: backendUrn when reading com.linkedin.android.pegasus.gen.voyager.search.SearchArticle from fission.");
      bool7 = false;
      break;
      bool8 = false;
      break label297;
      bool9 = false;
      break label324;
      bool10 = false;
      break label351;
      bool11 = false;
      break label378;
      bool2 = false;
      break label402;
      bool1 = false;
      break label459;
      bool1 = false;
      break label485;
      bool3 = false;
      break label497;
      bool2 = false;
      break label559;
      bool2 = false;
      break label588;
      bool4 = false;
      break label600;
      bool3 = false;
      break label662;
      bool3 = false;
      break label691;
      bool12 = false;
      break label703;
      bool5 = false;
      break label730;
      bool4 = false;
      break label792;
      bool4 = false;
      break label821;
      bool13 = false;
      break label833;
      bool14 = false;
      break label857;
      bool5 = false;
      break label884;
      bool5 = false;
      break label942;
    }
    label1140:
    return new SearchArticle((Urn)localObject6, str1, str2, str3, l1, paramString, (MemberFollowingInfo)localObject1, (Image)localObject2, str4, (AttributedText)localObject3, l2, str5, (SocialActivityCounts)localObject4, bool7, bool8, bool9, bool10, bool11, bool1, bool2, bool3, bool12, bool4, bool13, bool14, bool6);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchArticleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */