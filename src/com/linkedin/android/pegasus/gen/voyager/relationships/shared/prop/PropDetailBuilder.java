package com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop;

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

public final class PropDetailBuilder
  implements FissileDataModelBuilder<PropDetail>, DataTemplateBuilder<PropDetail>
{
  public static final PropDetailBuilder INSTANCE = new PropDetailBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("detail");
  }
  
  public static PropDetail build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject = null;
    boolean bool = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("detail", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = DetailBuilder.INSTANCE;
        localObject = DetailBuilder.build(paramDataReader);
        bool = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool) {
      throw new DataReaderException("Failed to find required field: detail when building com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.PropDetail");
    }
    return new PropDetail((PropDetail.Detail)localObject, bool);
  }
  
  public static PropDetail readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building PropDetail");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building PropDetail");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building PropDetail");
    }
    if (((ByteBuffer)localObject1).getInt() != -450255470)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building PropDetail");
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
          localObject2 = DetailBuilder.INSTANCE;
          paramString = DetailBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label330;
          }
          bool1 = true;
        }
        label267:
        bool2 = bool1;
        if (i == 1)
        {
          paramString = DetailBuilder.INSTANCE;
          paramString = DetailBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
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
      throw new IOException("Failed to find required field: detail when reading com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.PropDetail from fission.");
      bool1 = false;
      break;
      bool1 = false;
      break label267;
    }
    label342:
    return new PropDetail(paramString, bool2);
  }
  
  public static final class DetailBuilder
    implements FissileDataModelBuilder<PropDetail.Detail>, DataTemplateBuilder<PropDetail.Detail>
  {
    public static final DetailBuilder INSTANCE = new DetailBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.voyager.relationships.shared.prop.InvitationInfo");
      JSON_KEY_STORE.put("com.linkedin.voyager.relationships.shared.prop.LegoTrackingInfo");
      JSON_KEY_STORE.put("com.linkedin.voyager.relationships.shared.prop.MeetingInfo");
      JSON_KEY_STORE.put("com.linkedin.voyager.relationships.shared.prop.SocialDetailInfo");
    }
    
    public static PropDetail.Detail build(DataReader paramDataReader)
      throws DataReaderException
    {
      Object localObject4 = null;
      Object localObject3 = null;
      Object localObject2 = null;
      Object localObject1 = null;
      boolean bool4 = false;
      boolean bool3 = false;
      boolean bool2 = false;
      boolean bool1 = false;
      paramDataReader.startRecord();
      while (paramDataReader.hasMoreFields$255f299()) {
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.relationships.shared.prop.InvitationInfo", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject4 = InvitationInfoBuilder.INSTANCE;
          localObject4 = InvitationInfoBuilder.build(paramDataReader);
          bool4 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.relationships.shared.prop.LegoTrackingInfo", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject3 = LegoTrackingInfoBuilder.INSTANCE;
          localObject3 = LegoTrackingInfoBuilder.build(paramDataReader);
          bool3 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.relationships.shared.prop.MeetingInfo", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = MeetingInfoBuilder.INSTANCE;
          localObject2 = MeetingInfoBuilder.build(paramDataReader);
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.relationships.shared.prop.SocialDetailInfo", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = SocialDetailInfoBuilder.INSTANCE;
          localObject1 = SocialDetailInfoBuilder.build(paramDataReader);
          bool1 = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
      int j = 0;
      if (bool4) {
        j = 1;
      }
      int i = j;
      if (bool3)
      {
        if (j != 0) {
          throw new DataReaderException("Found more than 1 member when building .Detail");
        }
        i = 1;
      }
      j = i;
      if (bool2)
      {
        if (i != 0) {
          throw new DataReaderException("Found more than 1 member when building .Detail");
        }
        j = 1;
      }
      if ((bool1) && (j != 0)) {
        throw new DataReaderException("Found more than 1 member when building .Detail");
      }
      return new PropDetail.Detail((InvitationInfo)localObject4, (LegoTrackingInfo)localObject3, (MeetingInfo)localObject2, (SocialDetailInfo)localObject1, bool4, bool3, bool2, bool1);
    }
    
    public static PropDetail.Detail readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building PropDetail.Detail");
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
        throw new IOException("Invalid header prefix. Can't read cached data when building PropDetail.Detail");
      }
      Object localObject4 = localObject1;
      if (((ByteBuffer)localObject1).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("Invalid header prefix. Can't read cached data when building PropDetail.Detail");
      }
      if (((ByteBuffer)localObject4).getInt() != 254642335)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject4);
        throw new IOException("UID mismatch. Can't read cached data when building PropDetail.Detail");
      }
      paramString = null;
      InvitationInfoBuilder localInvitationInfoBuilder = null;
      localObject1 = null;
      LegoTrackingInfoBuilder localLegoTrackingInfoBuilder = null;
      Object localObject2 = null;
      MeetingInfoBuilder localMeetingInfoBuilder = null;
      Object localObject3 = null;
      SocialDetailInfoBuilder localSocialDetailInfoBuilder = null;
      boolean bool2;
      boolean bool1;
      label289:
      label315:
      boolean bool3;
      label327:
      label389:
      label418:
      boolean bool4;
      if (((ByteBuffer)localObject4).get() == 1)
      {
        bool2 = true;
        bool1 = bool2;
        if (bool2)
        {
          i = ((ByteBuffer)localObject4).get();
          paramString = localInvitationInfoBuilder;
          bool1 = bool2;
          if (i == 0)
          {
            paramString = paramFissionAdapter.readString((ByteBuffer)localObject4);
            localInvitationInfoBuilder = InvitationInfoBuilder.INSTANCE;
            paramString = InvitationInfoBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label677;
            }
            bool1 = true;
          }
          if (i == 1)
          {
            paramString = InvitationInfoBuilder.INSTANCE;
            paramString = InvitationInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
            if (paramString == null) {
              break label683;
            }
            bool1 = true;
          }
        }
        if (((ByteBuffer)localObject4).get() != 1) {
          break label689;
        }
        bool3 = true;
        bool2 = bool3;
        if (bool3)
        {
          i = ((ByteBuffer)localObject4).get();
          localObject1 = localLegoTrackingInfoBuilder;
          bool2 = bool3;
          if (i == 0)
          {
            localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject4);
            localLegoTrackingInfoBuilder = LegoTrackingInfoBuilder.INSTANCE;
            localObject1 = LegoTrackingInfoBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
            if (localObject1 == null) {
              break label695;
            }
            bool2 = true;
          }
          if (i == 1)
          {
            localObject1 = LegoTrackingInfoBuilder.INSTANCE;
            localObject1 = LegoTrackingInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
            if (localObject1 == null) {
              break label701;
            }
            bool2 = true;
          }
        }
        if (((ByteBuffer)localObject4).get() != 1) {
          break label707;
        }
        bool4 = true;
        label430:
        bool3 = bool4;
        if (bool4)
        {
          i = ((ByteBuffer)localObject4).get();
          localObject2 = localMeetingInfoBuilder;
          bool3 = bool4;
          if (i == 0)
          {
            localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject4);
            localMeetingInfoBuilder = MeetingInfoBuilder.INSTANCE;
            localObject2 = MeetingInfoBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
            if (localObject2 == null) {
              break label713;
            }
            bool3 = true;
          }
          label492:
          if (i == 1)
          {
            localObject2 = MeetingInfoBuilder.INSTANCE;
            localObject2 = MeetingInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
            if (localObject2 == null) {
              break label719;
            }
            bool3 = true;
          }
        }
        label521:
        if (((ByteBuffer)localObject4).get() != 1) {
          break label725;
        }
        bool4 = true;
        label533:
        bool5 = bool4;
        if (bool4)
        {
          i = ((ByteBuffer)localObject4).get();
          localObject3 = localSocialDetailInfoBuilder;
          if (i == 0)
          {
            localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject4);
            localSocialDetailInfoBuilder = SocialDetailInfoBuilder.INSTANCE;
            localObject3 = SocialDetailInfoBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
            if (localObject3 == null) {
              break label731;
            }
            bool4 = true;
          }
          label591:
          bool5 = bool4;
          if (i == 1)
          {
            localObject3 = SocialDetailInfoBuilder.INSTANCE;
            localObject3 = SocialDetailInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
            if (localObject3 == null) {
              break label737;
            }
          }
        }
      }
      label677:
      label683:
      label689:
      label695:
      label701:
      label707:
      label713:
      label719:
      label725:
      label731:
      label737:
      for (boolean bool5 = true;; bool5 = false)
      {
        if (paramByteBuffer == null) {
          paramFissionAdapter.recycle((ByteBuffer)localObject4);
        }
        j = 0;
        if (bool1) {
          j = 1;
        }
        i = j;
        if (!bool2) {
          break label746;
        }
        if (j == 0) {
          break label743;
        }
        throw new IOException("Found more than 1 member when reading .Detail from fission.");
        bool2 = false;
        break;
        bool1 = false;
        break label289;
        bool1 = false;
        break label315;
        bool3 = false;
        break label327;
        bool2 = false;
        break label389;
        bool2 = false;
        break label418;
        bool4 = false;
        break label430;
        bool3 = false;
        break label492;
        bool3 = false;
        break label521;
        bool4 = false;
        break label533;
        bool4 = false;
        break label591;
      }
      label743:
      int i = 1;
      label746:
      int j = i;
      if (bool3)
      {
        if (i != 0) {
          throw new IOException("Found more than 1 member when reading .Detail from fission.");
        }
        j = 1;
      }
      if ((bool5) && (j != 0)) {
        throw new IOException("Found more than 1 member when reading .Detail from fission.");
      }
      return new PropDetail.Detail(paramString, (LegoTrackingInfo)localObject1, (MeetingInfo)localObject2, (SocialDetailInfo)localObject3, bool1, bool2, bool3, bool5);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.PropDetailBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */