package com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfoBuilder;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedTextBuilder;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfileBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class RecommendedMemberBuilder
  implements FissileDataModelBuilder<RecommendedMember>, DataTemplateBuilder<RecommendedMember>
{
  public static final RecommendedMemberBuilder INSTANCE = new RecommendedMemberBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("miniProfile");
    JSON_KEY_STORE.put("influencer");
    JSON_KEY_STORE.put("followingInfo");
    JSON_KEY_STORE.put("reason");
  }
  
  public static RecommendedMember build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject3 = null;
    boolean bool5 = false;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("miniProfile", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = MiniProfileBuilder.INSTANCE;
        localObject3 = MiniProfileBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("influencer", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool5 = paramDataReader.readBoolean();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("followingInfo", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = FollowingInfoBuilder.INSTANCE;
        localObject2 = FollowingInfoBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("reason", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = AnnotatedTextBuilder.INSTANCE;
        localObject1 = AnnotatedTextBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: miniProfile when building com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedMember");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: influencer when building com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedMember");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: followingInfo when building com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedMember");
    }
    return new RecommendedMember((MiniProfile)localObject3, bool5, (FollowingInfo)localObject2, (AnnotatedText)localObject1, bool3, bool4, bool2, bool1);
  }
  
  public static RecommendedMember readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building RecommendedMember");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building RecommendedMember");
    }
    Object localObject3 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building RecommendedMember");
    }
    if (((ByteBuffer)localObject3).getInt() != -763935343)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject3);
      throw new IOException("UID mismatch. Can't read cached data when building RecommendedMember");
    }
    paramString = null;
    MiniProfileBuilder localMiniProfileBuilder = null;
    boolean bool5 = false;
    localObject1 = null;
    FollowingInfoBuilder localFollowingInfoBuilder = null;
    Object localObject2 = null;
    AnnotatedTextBuilder localAnnotatedTextBuilder = null;
    boolean bool2;
    boolean bool1;
    label286:
    label312:
    boolean bool6;
    label324:
    label341:
    boolean bool3;
    if (((ByteBuffer)localObject3).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject3).get();
        paramString = localMiniProfileBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localMiniProfileBuilder = MiniProfileBuilder.INSTANCE;
          paramString = MiniProfileBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label580;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = MiniProfileBuilder.INSTANCE;
          paramString = MiniProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (paramString == null) {
            break label586;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label592;
      }
      bool6 = true;
      if (bool6)
      {
        if (((ByteBuffer)localObject3).get() != 1) {
          break label598;
        }
        bool5 = true;
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label604;
      }
      bool3 = true;
      label353:
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject3).get();
        localObject1 = localFollowingInfoBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localFollowingInfoBuilder = FollowingInfoBuilder.INSTANCE;
          localObject1 = FollowingInfoBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label610;
          }
          bool2 = true;
        }
        label415:
        if (i == 1)
        {
          localObject1 = FollowingInfoBuilder.INSTANCE;
          localObject1 = FollowingInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label616;
          }
          bool2 = true;
        }
      }
      label444:
      if (((ByteBuffer)localObject3).get() != 1) {
        break label622;
      }
      bool3 = true;
      label456:
      bool4 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject3).get();
        localObject2 = localAnnotatedTextBuilder;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localAnnotatedTextBuilder = AnnotatedTextBuilder.INSTANCE;
          localObject2 = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label628;
          }
          bool3 = true;
        }
        label514:
        bool4 = bool3;
        if (i == 1)
        {
          localObject2 = AnnotatedTextBuilder.INSTANCE;
          localObject2 = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label634;
          }
        }
      }
    }
    label580:
    label586:
    label592:
    label598:
    label604:
    label610:
    label616:
    label622:
    label628:
    label634:
    for (boolean bool4 = true;; bool4 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject3);
      }
      if (bool1) {
        break label640;
      }
      throw new IOException("Failed to find required field: miniProfile when reading com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedMember from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label286;
      bool1 = false;
      break label312;
      bool6 = false;
      break label324;
      bool5 = false;
      break label341;
      bool3 = false;
      break label353;
      bool2 = false;
      break label415;
      bool2 = false;
      break label444;
      bool3 = false;
      break label456;
      bool3 = false;
      break label514;
    }
    label640:
    if (!bool6) {
      throw new IOException("Failed to find required field: influencer when reading com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedMember from fission.");
    }
    if (!bool2) {
      throw new IOException("Failed to find required field: followingInfo when reading com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedMember from fission.");
    }
    return new RecommendedMember(paramString, bool5, (FollowingInfo)localObject1, (AnnotatedText)localObject2, bool1, bool6, bool2, bool4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedMemberBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */