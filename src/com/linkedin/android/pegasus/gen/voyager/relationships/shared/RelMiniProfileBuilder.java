package com.linkedin.android.pegasus.gen.voyager.relationships.shared;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.common.MemberDistance;
import com.linkedin.android.pegasus.gen.voyager.common.MemberDistanceBuilder;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfileBuilder;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.ProfileHighlightBuilder;
import com.linkedin.android.pegasus.gen.voyager.relationships.invitation.Invitation;
import com.linkedin.android.pegasus.gen.voyager.relationships.invitation.InvitationBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class RelMiniProfileBuilder
  implements FissileDataModelBuilder<RelMiniProfile>, DataTemplateBuilder<RelMiniProfile>
{
  public static final RelMiniProfileBuilder INSTANCE = new RelMiniProfileBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("miniProfile");
    JSON_KEY_STORE.put("distance");
    JSON_KEY_STORE.put("highlights");
    JSON_KEY_STORE.put("pendingInvitation");
  }
  
  public static RelMiniProfile build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("miniProfile", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = MiniProfileBuilder.INSTANCE;
        localObject4 = MiniProfileBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("distance", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = MemberDistanceBuilder.INSTANCE;
        localObject3 = MemberDistanceBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("highlights", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            ProfileHighlightBuilder localProfileHighlightBuilder = ProfileHighlightBuilder.INSTANCE;
            ((List)localObject1).add(ProfileHighlightBuilder.build(paramDataReader));
          }
        }
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("pendingInvitation", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = InvitationBuilder.INSTANCE;
        localObject2 = InvitationBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool2) {
      localObject1 = Collections.emptyList();
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: miniProfile when building com.linkedin.android.pegasus.gen.voyager.relationships.shared.RelMiniProfile");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: distance when building com.linkedin.android.pegasus.gen.voyager.relationships.shared.RelMiniProfile");
    }
    return new RelMiniProfile((MiniProfile)localObject4, (MemberDistance)localObject3, (List)localObject1, (Invitation)localObject2, bool4, bool3, bool2, bool1);
  }
  
  public static RelMiniProfile readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building RelMiniProfile");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building RelMiniProfile");
    }
    Object localObject4 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building RelMiniProfile");
    }
    if (((ByteBuffer)localObject4).getInt() != -2136105727)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject4);
      throw new IOException("UID mismatch. Can't read cached data when building RelMiniProfile");
    }
    paramString = null;
    Object localObject6 = null;
    localObject1 = null;
    Object localObject5 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    InvitationBuilder localInvitationBuilder = null;
    boolean bool2;
    boolean bool1;
    label286:
    label312:
    boolean bool3;
    label324:
    label386:
    label415:
    boolean bool5;
    if (((ByteBuffer)localObject4).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject4).get();
        paramString = (String)localObject6;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localObject6 = MiniProfileBuilder.INSTANCE;
          paramString = MiniProfileBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label570;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = MiniProfileBuilder.INSTANCE;
          paramString = MiniProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (paramString == null) {
            break label576;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label582;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject4).get();
        localObject1 = localObject5;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localObject5 = MemberDistanceBuilder.INSTANCE;
          localObject1 = MemberDistanceBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label588;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject1 = MemberDistanceBuilder.INSTANCE;
          localObject1 = MemberDistanceBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label594;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label600;
      }
      bool5 = true;
      label427:
      if (!bool5) {
        break label618;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject4);
      localObject5 = new ArrayList();
      label451:
      localObject2 = localObject5;
      if (j <= 0) {
        break label618;
      }
      localObject2 = null;
      i = 1;
      int k = ((ByteBuffer)localObject4).get();
      if (k == 0)
      {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject4);
        localObject6 = ProfileHighlightBuilder.INSTANCE;
        localObject2 = ProfileHighlightBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
        if (localObject2 == null) {
          break label606;
        }
        i = 1;
      }
      label511:
      if (k == 1)
      {
        localObject2 = ProfileHighlightBuilder.INSTANCE;
        localObject2 = ProfileHighlightBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
        if (localObject2 == null) {
          break label612;
        }
      }
    }
    label570:
    label576:
    label582:
    label588:
    label594:
    label600:
    label606:
    label612:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject5).add(localObject2);
      }
      j -= 1;
      break label451;
      bool2 = false;
      break;
      bool1 = false;
      break label286;
      bool1 = false;
      break label312;
      bool3 = false;
      break label324;
      bool2 = false;
      break label386;
      bool2 = false;
      break label415;
      bool5 = false;
      break label427;
      i = 0;
      break label511;
    }
    label618:
    if (((ByteBuffer)localObject4).get() == 1)
    {
      bool3 = true;
      bool4 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject4).get();
        localObject3 = localInvitationBuilder;
        if (i == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localInvitationBuilder = InvitationBuilder.INSTANCE;
          localObject3 = InvitationBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label764;
          }
          bool3 = true;
        }
        label688:
        bool4 = bool3;
        if (i == 1)
        {
          localObject3 = InvitationBuilder.INSTANCE;
          localObject3 = InvitationBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label770;
          }
        }
      }
    }
    label764:
    label770:
    for (boolean bool4 = true;; bool4 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject4);
      }
      if (!bool5) {
        localObject2 = Collections.emptyList();
      }
      if (bool1) {
        break label776;
      }
      throw new IOException("Failed to find required field: miniProfile when reading com.linkedin.android.pegasus.gen.voyager.relationships.shared.RelMiniProfile from fission.");
      bool3 = false;
      break;
      bool3 = false;
      break label688;
    }
    label776:
    if (!bool2) {
      throw new IOException("Failed to find required field: distance when reading com.linkedin.android.pegasus.gen.voyager.relationships.shared.RelMiniProfile from fission.");
    }
    return new RelMiniProfile(paramString, (MemberDistance)localObject1, (List)localObject2, (Invitation)localObject3, bool1, bool2, bool5, bool4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.relationships.shared.RelMiniProfileBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */