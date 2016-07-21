package com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill;

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

public final class EndorsedSkillHighlightBuilder
  implements FissileDataModelBuilder<EndorsedSkillHighlight>, DataTemplateBuilder<EndorsedSkillHighlight>
{
  public static final EndorsedSkillHighlightBuilder INSTANCE = new EndorsedSkillHighlightBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("signature");
    JSON_KEY_STORE.put("detail");
  }
  
  public static EndorsedSkillHighlight build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str = null;
    Object localObject = null;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("signature", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("detail", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = DetailBuilder.INSTANCE;
        localObject = DetailBuilder.build(paramDataReader);
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: signature when building com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill.EndorsedSkillHighlight");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: detail when building com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill.EndorsedSkillHighlight");
    }
    return new EndorsedSkillHighlight(str, (EndorsedSkillHighlight.Detail)localObject, bool1, bool2);
  }
  
  public static EndorsedSkillHighlight readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building EndorsedSkillHighlight");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building EndorsedSkillHighlight");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building EndorsedSkillHighlight");
    }
    if (((ByteBuffer)localObject1).getInt() != -1053018383)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building EndorsedSkillHighlight");
    }
    localObject2 = null;
    paramString = null;
    DetailBuilder localDetailBuilder = null;
    boolean bool3;
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool3 = true;
      if (bool3) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label360;
      }
      bool1 = true;
      label244:
      bool2 = bool1;
      if (bool1)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = localDetailBuilder;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localDetailBuilder = DetailBuilder.INSTANCE;
          paramString = DetailBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label366;
          }
          bool1 = true;
        }
        label297:
        bool2 = bool1;
        if (i == 1)
        {
          paramString = DetailBuilder.INSTANCE;
          paramString = DetailBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label372;
          }
        }
      }
    }
    label360:
    label366:
    label372:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool3) {
        break label378;
      }
      throw new IOException("Failed to find required field: signature when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill.EndorsedSkillHighlight from fission.");
      bool3 = false;
      break;
      bool1 = false;
      break label244;
      bool1 = false;
      break label297;
    }
    label378:
    if (!bool2) {
      throw new IOException("Failed to find required field: detail when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill.EndorsedSkillHighlight from fission.");
    }
    return new EndorsedSkillHighlight((String)localObject2, paramString, bool3, bool2);
  }
  
  public static final class DetailBuilder
    implements FissileDataModelBuilder<EndorsedSkillHighlight.Detail>, DataTemplateBuilder<EndorsedSkillHighlight.Detail>
  {
    public static final DetailBuilder INSTANCE = new DetailBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.voyager.identity.profile.endorsedSkill.SharedConnectionsInfo");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.profile.endorsedSkill.ElitesInfo");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.profile.endorsedSkill.InfluencersInfo");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.profile.endorsedSkill.RecentlyEndorsedInfo");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.profile.endorsedSkill.SameSkillInfo");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.profile.endorsedSkill.SameTitleInfo");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.profile.endorsedSkill.SeniorLeadersInfo");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.profile.endorsedSkill.SharedEntityInfo");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.profile.endorsedSkill.ViewerSharedEntityInfo");
    }
    
    public static EndorsedSkillHighlight.Detail build(DataReader paramDataReader)
      throws DataReaderException
    {
      Object localObject9 = null;
      Object localObject8 = null;
      Object localObject7 = null;
      Object localObject6 = null;
      Object localObject5 = null;
      Object localObject4 = null;
      Object localObject3 = null;
      Object localObject2 = null;
      Object localObject1 = null;
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
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.endorsedSkill.SharedConnectionsInfo", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject9 = SharedConnectionsInfoBuilder.INSTANCE;
          localObject9 = SharedConnectionsInfoBuilder.build(paramDataReader);
          bool9 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.endorsedSkill.ElitesInfo", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject8 = ElitesInfoBuilder.INSTANCE;
          localObject8 = ElitesInfoBuilder.build(paramDataReader);
          bool8 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.endorsedSkill.InfluencersInfo", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject7 = InfluencersInfoBuilder.INSTANCE;
          localObject7 = InfluencersInfoBuilder.build(paramDataReader);
          bool7 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.endorsedSkill.RecentlyEndorsedInfo", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject6 = RecentlyEndorsedInfoBuilder.INSTANCE;
          localObject6 = RecentlyEndorsedInfoBuilder.build(paramDataReader);
          bool6 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.endorsedSkill.SameSkillInfo", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject5 = SameSkillInfoBuilder.INSTANCE;
          localObject5 = SameSkillInfoBuilder.build(paramDataReader);
          bool5 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.endorsedSkill.SameTitleInfo", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject4 = SameTitleInfoBuilder.INSTANCE;
          localObject4 = SameTitleInfoBuilder.build(paramDataReader);
          bool4 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.endorsedSkill.SeniorLeadersInfo", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject3 = SeniorLeadersInfoBuilder.INSTANCE;
          localObject3 = SeniorLeadersInfoBuilder.build(paramDataReader);
          bool3 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.endorsedSkill.SharedEntityInfo", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = SharedEntityInfoBuilder.INSTANCE;
          localObject2 = SharedEntityInfoBuilder.build(paramDataReader);
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.endorsedSkill.ViewerSharedEntityInfo", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = ViewerSharedEntityInfoBuilder.INSTANCE;
          localObject1 = ViewerSharedEntityInfoBuilder.build(paramDataReader);
          bool1 = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
      int j = 0;
      if (bool9) {
        j = 1;
      }
      int i = j;
      if (bool8)
      {
        if (j != 0) {
          throw new DataReaderException("Found more than 1 member when building .Detail");
        }
        i = 1;
      }
      j = i;
      if (bool7)
      {
        if (i != 0) {
          throw new DataReaderException("Found more than 1 member when building .Detail");
        }
        j = 1;
      }
      i = j;
      if (bool6)
      {
        if (j != 0) {
          throw new DataReaderException("Found more than 1 member when building .Detail");
        }
        i = 1;
      }
      j = i;
      if (bool5)
      {
        if (i != 0) {
          throw new DataReaderException("Found more than 1 member when building .Detail");
        }
        j = 1;
      }
      i = j;
      if (bool4)
      {
        if (j != 0) {
          throw new DataReaderException("Found more than 1 member when building .Detail");
        }
        i = 1;
      }
      j = i;
      if (bool3)
      {
        if (i != 0) {
          throw new DataReaderException("Found more than 1 member when building .Detail");
        }
        j = 1;
      }
      i = j;
      if (bool2)
      {
        if (j != 0) {
          throw new DataReaderException("Found more than 1 member when building .Detail");
        }
        i = 1;
      }
      if ((bool1) && (i != 0)) {
        throw new DataReaderException("Found more than 1 member when building .Detail");
      }
      return new EndorsedSkillHighlight.Detail((SharedConnectionsInfo)localObject9, (ElitesInfo)localObject8, (InfluencersInfo)localObject7, (RecentlyEndorsedInfo)localObject6, (SameSkillInfo)localObject5, (SameTitleInfo)localObject4, (SeniorLeadersInfo)localObject3, (SharedEntityInfo)localObject2, (ViewerSharedEntityInfo)localObject1, bool9, bool8, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
    }
    
    public static EndorsedSkillHighlight.Detail readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building EndorsedSkillHighlight.Detail");
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
            localObject9 = paramString;
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
        throw new IOException("Invalid header prefix. Can't read cached data when building EndorsedSkillHighlight.Detail");
      }
      Object localObject9 = localObject1;
      if (((ByteBuffer)localObject1).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("Invalid header prefix. Can't read cached data when building EndorsedSkillHighlight.Detail");
      }
      if (((ByteBuffer)localObject9).getInt() != 2095983786)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject9);
        throw new IOException("UID mismatch. Can't read cached data when building EndorsedSkillHighlight.Detail");
      }
      paramString = null;
      SharedConnectionsInfoBuilder localSharedConnectionsInfoBuilder = null;
      localObject1 = null;
      ElitesInfoBuilder localElitesInfoBuilder = null;
      Object localObject2 = null;
      InfluencersInfoBuilder localInfluencersInfoBuilder = null;
      Object localObject3 = null;
      RecentlyEndorsedInfoBuilder localRecentlyEndorsedInfoBuilder = null;
      Object localObject4 = null;
      SameSkillInfoBuilder localSameSkillInfoBuilder = null;
      Object localObject5 = null;
      SameTitleInfoBuilder localSameTitleInfoBuilder = null;
      Object localObject6 = null;
      SeniorLeadersInfoBuilder localSeniorLeadersInfoBuilder = null;
      Object localObject7 = null;
      SharedEntityInfoBuilder localSharedEntityInfoBuilder = null;
      Object localObject8 = null;
      ViewerSharedEntityInfoBuilder localViewerSharedEntityInfoBuilder = null;
      boolean bool2;
      boolean bool1;
      label319:
      label345:
      boolean bool3;
      label357:
      label419:
      label448:
      boolean bool4;
      label460:
      label522:
      label551:
      boolean bool5;
      label563:
      label625:
      label654:
      boolean bool6;
      label666:
      label728:
      label757:
      boolean bool7;
      label769:
      label831:
      label860:
      boolean bool8;
      label872:
      label934:
      label963:
      boolean bool9;
      if (((ByteBuffer)localObject9).get() == 1)
      {
        bool2 = true;
        bool1 = bool2;
        if (bool2)
        {
          i = ((ByteBuffer)localObject9).get();
          paramString = localSharedConnectionsInfoBuilder;
          bool1 = bool2;
          if (i == 0)
          {
            paramString = paramFissionAdapter.readString((ByteBuffer)localObject9);
            localSharedConnectionsInfoBuilder = SharedConnectionsInfoBuilder.INSTANCE;
            paramString = SharedConnectionsInfoBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label1222;
            }
            bool1 = true;
          }
          if (i == 1)
          {
            paramString = SharedConnectionsInfoBuilder.INSTANCE;
            paramString = SharedConnectionsInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject9, null, paramFissionTransaction);
            if (paramString == null) {
              break label1228;
            }
            bool1 = true;
          }
        }
        if (((ByteBuffer)localObject9).get() != 1) {
          break label1234;
        }
        bool3 = true;
        bool2 = bool3;
        if (bool3)
        {
          i = ((ByteBuffer)localObject9).get();
          localObject1 = localElitesInfoBuilder;
          bool2 = bool3;
          if (i == 0)
          {
            localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject9);
            localElitesInfoBuilder = ElitesInfoBuilder.INSTANCE;
            localObject1 = ElitesInfoBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
            if (localObject1 == null) {
              break label1240;
            }
            bool2 = true;
          }
          if (i == 1)
          {
            localObject1 = ElitesInfoBuilder.INSTANCE;
            localObject1 = ElitesInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject9, null, paramFissionTransaction);
            if (localObject1 == null) {
              break label1246;
            }
            bool2 = true;
          }
        }
        if (((ByteBuffer)localObject9).get() != 1) {
          break label1252;
        }
        bool4 = true;
        bool3 = bool4;
        if (bool4)
        {
          i = ((ByteBuffer)localObject9).get();
          localObject2 = localInfluencersInfoBuilder;
          bool3 = bool4;
          if (i == 0)
          {
            localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject9);
            localInfluencersInfoBuilder = InfluencersInfoBuilder.INSTANCE;
            localObject2 = InfluencersInfoBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
            if (localObject2 == null) {
              break label1258;
            }
            bool3 = true;
          }
          if (i == 1)
          {
            localObject2 = InfluencersInfoBuilder.INSTANCE;
            localObject2 = InfluencersInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject9, null, paramFissionTransaction);
            if (localObject2 == null) {
              break label1264;
            }
            bool3 = true;
          }
        }
        if (((ByteBuffer)localObject9).get() != 1) {
          break label1270;
        }
        bool5 = true;
        bool4 = bool5;
        if (bool5)
        {
          i = ((ByteBuffer)localObject9).get();
          localObject3 = localRecentlyEndorsedInfoBuilder;
          bool4 = bool5;
          if (i == 0)
          {
            localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject9);
            localRecentlyEndorsedInfoBuilder = RecentlyEndorsedInfoBuilder.INSTANCE;
            localObject3 = RecentlyEndorsedInfoBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
            if (localObject3 == null) {
              break label1276;
            }
            bool4 = true;
          }
          if (i == 1)
          {
            localObject3 = RecentlyEndorsedInfoBuilder.INSTANCE;
            localObject3 = RecentlyEndorsedInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject9, null, paramFissionTransaction);
            if (localObject3 == null) {
              break label1282;
            }
            bool4 = true;
          }
        }
        if (((ByteBuffer)localObject9).get() != 1) {
          break label1288;
        }
        bool6 = true;
        bool5 = bool6;
        if (bool6)
        {
          i = ((ByteBuffer)localObject9).get();
          localObject4 = localSameSkillInfoBuilder;
          bool5 = bool6;
          if (i == 0)
          {
            localObject4 = paramFissionAdapter.readString((ByteBuffer)localObject9);
            localSameSkillInfoBuilder = SameSkillInfoBuilder.INSTANCE;
            localObject4 = SameSkillInfoBuilder.readFromFission(paramFissionAdapter, null, (String)localObject4, paramFissionTransaction);
            if (localObject4 == null) {
              break label1294;
            }
            bool5 = true;
          }
          if (i == 1)
          {
            localObject4 = SameSkillInfoBuilder.INSTANCE;
            localObject4 = SameSkillInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject9, null, paramFissionTransaction);
            if (localObject4 == null) {
              break label1300;
            }
            bool5 = true;
          }
        }
        if (((ByteBuffer)localObject9).get() != 1) {
          break label1306;
        }
        bool7 = true;
        bool6 = bool7;
        if (bool7)
        {
          i = ((ByteBuffer)localObject9).get();
          localObject5 = localSameTitleInfoBuilder;
          bool6 = bool7;
          if (i == 0)
          {
            localObject5 = paramFissionAdapter.readString((ByteBuffer)localObject9);
            localSameTitleInfoBuilder = SameTitleInfoBuilder.INSTANCE;
            localObject5 = SameTitleInfoBuilder.readFromFission(paramFissionAdapter, null, (String)localObject5, paramFissionTransaction);
            if (localObject5 == null) {
              break label1312;
            }
            bool6 = true;
          }
          if (i == 1)
          {
            localObject5 = SameTitleInfoBuilder.INSTANCE;
            localObject5 = SameTitleInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject9, null, paramFissionTransaction);
            if (localObject5 == null) {
              break label1318;
            }
            bool6 = true;
          }
        }
        if (((ByteBuffer)localObject9).get() != 1) {
          break label1324;
        }
        bool8 = true;
        bool7 = bool8;
        if (bool8)
        {
          i = ((ByteBuffer)localObject9).get();
          localObject6 = localSeniorLeadersInfoBuilder;
          bool7 = bool8;
          if (i == 0)
          {
            localObject6 = paramFissionAdapter.readString((ByteBuffer)localObject9);
            localSeniorLeadersInfoBuilder = SeniorLeadersInfoBuilder.INSTANCE;
            localObject6 = SeniorLeadersInfoBuilder.readFromFission(paramFissionAdapter, null, (String)localObject6, paramFissionTransaction);
            if (localObject6 == null) {
              break label1330;
            }
            bool7 = true;
          }
          if (i == 1)
          {
            localObject6 = SeniorLeadersInfoBuilder.INSTANCE;
            localObject6 = SeniorLeadersInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject9, null, paramFissionTransaction);
            if (localObject6 == null) {
              break label1336;
            }
            bool7 = true;
          }
        }
        if (((ByteBuffer)localObject9).get() != 1) {
          break label1342;
        }
        bool9 = true;
        label975:
        bool8 = bool9;
        if (bool9)
        {
          i = ((ByteBuffer)localObject9).get();
          localObject7 = localSharedEntityInfoBuilder;
          bool8 = bool9;
          if (i == 0)
          {
            localObject7 = paramFissionAdapter.readString((ByteBuffer)localObject9);
            localSharedEntityInfoBuilder = SharedEntityInfoBuilder.INSTANCE;
            localObject7 = SharedEntityInfoBuilder.readFromFission(paramFissionAdapter, null, (String)localObject7, paramFissionTransaction);
            if (localObject7 == null) {
              break label1348;
            }
            bool8 = true;
          }
          label1037:
          if (i == 1)
          {
            localObject7 = SharedEntityInfoBuilder.INSTANCE;
            localObject7 = SharedEntityInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject9, null, paramFissionTransaction);
            if (localObject7 == null) {
              break label1354;
            }
            bool8 = true;
          }
        }
        label1066:
        if (((ByteBuffer)localObject9).get() != 1) {
          break label1360;
        }
        bool9 = true;
        label1078:
        bool10 = bool9;
        if (bool9)
        {
          i = ((ByteBuffer)localObject9).get();
          localObject8 = localViewerSharedEntityInfoBuilder;
          if (i == 0)
          {
            localObject8 = paramFissionAdapter.readString((ByteBuffer)localObject9);
            localViewerSharedEntityInfoBuilder = ViewerSharedEntityInfoBuilder.INSTANCE;
            localObject8 = ViewerSharedEntityInfoBuilder.readFromFission(paramFissionAdapter, null, (String)localObject8, paramFissionTransaction);
            if (localObject8 == null) {
              break label1366;
            }
            bool9 = true;
          }
          label1136:
          bool10 = bool9;
          if (i == 1)
          {
            localObject8 = ViewerSharedEntityInfoBuilder.INSTANCE;
            localObject8 = ViewerSharedEntityInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject9, null, paramFissionTransaction);
            if (localObject8 == null) {
              break label1372;
            }
          }
        }
      }
      label1222:
      label1228:
      label1234:
      label1240:
      label1246:
      label1252:
      label1258:
      label1264:
      label1270:
      label1276:
      label1282:
      label1288:
      label1294:
      label1300:
      label1306:
      label1312:
      label1318:
      label1324:
      label1330:
      label1336:
      label1342:
      label1348:
      label1354:
      label1360:
      label1366:
      label1372:
      for (boolean bool10 = true;; bool10 = false)
      {
        if (paramByteBuffer == null) {
          paramFissionAdapter.recycle((ByteBuffer)localObject9);
        }
        j = 0;
        if (bool1) {
          j = 1;
        }
        i = j;
        if (!bool2) {
          break label1381;
        }
        if (j == 0) {
          break label1378;
        }
        throw new IOException("Found more than 1 member when reading .Detail from fission.");
        bool2 = false;
        break;
        bool1 = false;
        break label319;
        bool1 = false;
        break label345;
        bool3 = false;
        break label357;
        bool2 = false;
        break label419;
        bool2 = false;
        break label448;
        bool4 = false;
        break label460;
        bool3 = false;
        break label522;
        bool3 = false;
        break label551;
        bool5 = false;
        break label563;
        bool4 = false;
        break label625;
        bool4 = false;
        break label654;
        bool6 = false;
        break label666;
        bool5 = false;
        break label728;
        bool5 = false;
        break label757;
        bool7 = false;
        break label769;
        bool6 = false;
        break label831;
        bool6 = false;
        break label860;
        bool8 = false;
        break label872;
        bool7 = false;
        break label934;
        bool7 = false;
        break label963;
        bool9 = false;
        break label975;
        bool8 = false;
        break label1037;
        bool8 = false;
        break label1066;
        bool9 = false;
        break label1078;
        bool9 = false;
        break label1136;
      }
      label1378:
      int i = 1;
      label1381:
      int j = i;
      if (bool3)
      {
        if (i != 0) {
          throw new IOException("Found more than 1 member when reading .Detail from fission.");
        }
        j = 1;
      }
      i = j;
      if (bool4)
      {
        if (j != 0) {
          throw new IOException("Found more than 1 member when reading .Detail from fission.");
        }
        i = 1;
      }
      j = i;
      if (bool5)
      {
        if (i != 0) {
          throw new IOException("Found more than 1 member when reading .Detail from fission.");
        }
        j = 1;
      }
      i = j;
      if (bool6)
      {
        if (j != 0) {
          throw new IOException("Found more than 1 member when reading .Detail from fission.");
        }
        i = 1;
      }
      j = i;
      if (bool7)
      {
        if (i != 0) {
          throw new IOException("Found more than 1 member when reading .Detail from fission.");
        }
        j = 1;
      }
      i = j;
      if (bool8)
      {
        if (j != 0) {
          throw new IOException("Found more than 1 member when reading .Detail from fission.");
        }
        i = 1;
      }
      if ((bool10) && (i != 0)) {
        throw new IOException("Found more than 1 member when reading .Detail from fission.");
      }
      return new EndorsedSkillHighlight.Detail(paramString, (ElitesInfo)localObject1, (InfluencersInfo)localObject2, (RecentlyEndorsedInfo)localObject3, (SameSkillInfo)localObject4, (SameTitleInfo)localObject5, (SeniorLeadersInfo)localObject6, (SharedEntityInfo)localObject7, (ViewerSharedEntityInfo)localObject8, bool1, bool2, bool3, bool4, bool5, bool6, bool7, bool8, bool10);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.endorsedSkill.EndorsedSkillHighlightBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */