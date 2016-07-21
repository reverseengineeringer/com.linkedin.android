package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Date;
import com.linkedin.android.pegasus.gen.common.DateBuilder;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.State;
import com.linkedin.android.pegasus.gen.voyager.common.StateBuilder;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfileBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ProfileBuilder
  implements FissileDataModelBuilder<Profile>, DataTemplateBuilder<Profile>
{
  public static final ProfileBuilder INSTANCE = new ProfileBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("firstName");
    JSON_KEY_STORE.put("lastName");
    JSON_KEY_STORE.put("maidenName");
    JSON_KEY_STORE.put("headline");
    JSON_KEY_STORE.put("industryName");
    JSON_KEY_STORE.put("industryUrn");
    JSON_KEY_STORE.put("location");
    JSON_KEY_STORE.put("backgroundImage");
    JSON_KEY_STORE.put("pictureInfo");
    JSON_KEY_STORE.put("phoneticFirstName");
    JSON_KEY_STORE.put("phoneticLastName");
    JSON_KEY_STORE.put("contactInstructions");
    JSON_KEY_STORE.put("interests");
    JSON_KEY_STORE.put("address");
    JSON_KEY_STORE.put("birthDate");
    JSON_KEY_STORE.put("summary");
    JSON_KEY_STORE.put("versionTag");
    JSON_KEY_STORE.put("state");
    JSON_KEY_STORE.put("locationName");
    JSON_KEY_STORE.put("miniProfile");
  }
  
  public static Profile build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject8 = null;
    String str13 = null;
    String str12 = null;
    String str11 = null;
    String str10 = null;
    String str9 = null;
    Object localObject7 = null;
    Object localObject6 = null;
    Object localObject5 = null;
    Object localObject4 = null;
    String str8 = null;
    String str7 = null;
    String str6 = null;
    String str5 = null;
    String str4 = null;
    Object localObject3 = null;
    String str3 = null;
    String str2 = null;
    Object localObject2 = null;
    String str1 = null;
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
      if (paramDataReader.shouldReadField$11ca93e7("entityUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject8 = UrnCoercer.INSTANCE;
        localObject8 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool21 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("firstName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str13 = paramDataReader.readString();
        bool20 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("lastName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str12 = paramDataReader.readString();
        bool19 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("maidenName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str11 = paramDataReader.readString();
        bool18 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("headline", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str10 = paramDataReader.readString();
        bool17 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("industryName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str9 = paramDataReader.readString();
        bool16 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("industryUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject7 = UrnCoercer.INSTANCE;
        localObject7 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool15 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("location", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject6 = ProfileLocationBuilder.INSTANCE;
        localObject6 = ProfileLocationBuilder.build(paramDataReader);
        bool14 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("backgroundImage", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject5 = BackgroundImageBuilder.INSTANCE;
        localObject5 = BackgroundImageBuilder.build(paramDataReader);
        bool13 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("pictureInfo", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = PictureBuilder.INSTANCE;
        localObject4 = PictureBuilder.build(paramDataReader);
        bool12 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("phoneticFirstName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str8 = paramDataReader.readString();
        bool11 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("phoneticLastName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str7 = paramDataReader.readString();
        bool10 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("contactInstructions", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str6 = paramDataReader.readString();
        bool9 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("interests", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str5 = paramDataReader.readString();
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("address", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str4 = paramDataReader.readString();
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("birthDate", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = DateBuilder.INSTANCE;
        localObject3 = DateBuilder.build(paramDataReader);
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("summary", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("versionTag", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("state", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = StateBuilder.INSTANCE;
        localObject2 = StateBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("locationName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("miniProfile", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = MiniProfileBuilder.INSTANCE;
        localObject1 = MiniProfileBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool20) {
      throw new DataReaderException("Failed to find required field: firstName when building com.linkedin.android.pegasus.gen.voyager.identity.profile.Profile");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: versionTag when building com.linkedin.android.pegasus.gen.voyager.identity.profile.Profile");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: miniProfile when building com.linkedin.android.pegasus.gen.voyager.identity.profile.Profile");
    }
    return new Profile((Urn)localObject8, str13, str12, str11, str10, str9, (Urn)localObject7, (ProfileLocation)localObject6, (BackgroundImage)localObject5, (Picture)localObject4, str8, str7, str6, str5, str4, (Date)localObject3, str3, str2, (State)localObject2, str1, (MiniProfile)localObject1, bool21, bool20, bool19, bool18, bool17, bool16, bool15, bool14, bool13, bool12, bool11, bool10, bool9, bool8, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static Profile readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Profile");
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
          localObject6 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building Profile");
    }
    Object localObject6 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building Profile");
    }
    if (((ByteBuffer)localObject6).getInt() != -548248113)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject6);
      throw new IOException("UID mismatch. Can't read cached data when building Profile");
    }
    Object localObject7 = null;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    Object localObject8 = null;
    paramString = null;
    ProfileLocationBuilder localProfileLocationBuilder = null;
    localObject1 = null;
    BackgroundImageBuilder localBackgroundImageBuilder = null;
    Object localObject2 = null;
    PictureBuilder localPictureBuilder = null;
    String str6 = null;
    String str7 = null;
    String str8 = null;
    String str9 = null;
    String str10 = null;
    Object localObject3 = null;
    DateBuilder localDateBuilder = null;
    String str11 = null;
    String str12 = null;
    Object localObject4 = null;
    StateBuilder localStateBuilder = null;
    String str13 = null;
    Object localObject5 = null;
    MiniProfileBuilder localMiniProfileBuilder = null;
    boolean bool8;
    boolean bool9;
    label324:
    boolean bool10;
    label351:
    boolean bool11;
    label378:
    boolean bool12;
    label405:
    boolean bool13;
    label432:
    boolean bool14;
    label459:
    boolean bool2;
    label494:
    boolean bool1;
    label551:
    label577:
    boolean bool3;
    label589:
    label651:
    label680:
    boolean bool4;
    label692:
    label754:
    label783:
    boolean bool15;
    label795:
    boolean bool16;
    label822:
    boolean bool17;
    label849:
    boolean bool18;
    label876:
    boolean bool19;
    label903:
    boolean bool5;
    label930:
    label992:
    label1021:
    boolean bool20;
    label1033:
    boolean bool21;
    label1060:
    boolean bool6;
    label1087:
    label1149:
    label1178:
    boolean bool22;
    if (((ByteBuffer)localObject6).get() == 1)
    {
      bool8 = true;
      if (bool8)
      {
        localObject7 = UrnCoercer.INSTANCE;
        localObject7 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject6));
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1341;
      }
      bool9 = true;
      if (bool9) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject6);
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1347;
      }
      bool10 = true;
      if (bool10) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject6);
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1353;
      }
      bool11 = true;
      if (bool11) {
        str3 = paramFissionAdapter.readString((ByteBuffer)localObject6);
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1359;
      }
      bool12 = true;
      if (bool12) {
        str4 = paramFissionAdapter.readString((ByteBuffer)localObject6);
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1365;
      }
      bool13 = true;
      if (bool13) {
        str5 = paramFissionAdapter.readString((ByteBuffer)localObject6);
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1371;
      }
      bool14 = true;
      if (bool14)
      {
        localObject8 = UrnCoercer.INSTANCE;
        localObject8 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject6));
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1377;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject6).get();
        paramString = localProfileLocationBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localProfileLocationBuilder = ProfileLocationBuilder.INSTANCE;
          paramString = ProfileLocationBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label1383;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = ProfileLocationBuilder.INSTANCE;
          paramString = ProfileLocationBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (paramString == null) {
            break label1389;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1395;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject6).get();
        localObject1 = localBackgroundImageBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localBackgroundImageBuilder = BackgroundImageBuilder.INSTANCE;
          localObject1 = BackgroundImageBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label1401;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject1 = BackgroundImageBuilder.INSTANCE;
          localObject1 = BackgroundImageBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label1407;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1413;
      }
      bool4 = true;
      bool3 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject6).get();
        localObject2 = localPictureBuilder;
        bool3 = bool4;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localPictureBuilder = PictureBuilder.INSTANCE;
          localObject2 = PictureBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label1419;
          }
          bool3 = true;
        }
        if (i == 1)
        {
          localObject2 = PictureBuilder.INSTANCE;
          localObject2 = PictureBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label1425;
          }
          bool3 = true;
        }
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1431;
      }
      bool15 = true;
      if (bool15) {
        str6 = paramFissionAdapter.readString((ByteBuffer)localObject6);
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1437;
      }
      bool16 = true;
      if (bool16) {
        str7 = paramFissionAdapter.readString((ByteBuffer)localObject6);
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1443;
      }
      bool17 = true;
      if (bool17) {
        str8 = paramFissionAdapter.readString((ByteBuffer)localObject6);
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1449;
      }
      bool18 = true;
      if (bool18) {
        str9 = paramFissionAdapter.readString((ByteBuffer)localObject6);
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1455;
      }
      bool19 = true;
      if (bool19) {
        str10 = paramFissionAdapter.readString((ByteBuffer)localObject6);
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1461;
      }
      bool5 = true;
      bool4 = bool5;
      if (bool5)
      {
        i = ((ByteBuffer)localObject6).get();
        localObject3 = localDateBuilder;
        bool4 = bool5;
        if (i == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localDateBuilder = DateBuilder.INSTANCE;
          localObject3 = DateBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label1467;
          }
          bool4 = true;
        }
        if (i == 1)
        {
          localObject3 = DateBuilder.INSTANCE;
          localObject3 = DateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label1473;
          }
          bool4 = true;
        }
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1479;
      }
      bool20 = true;
      if (bool20) {
        str11 = paramFissionAdapter.readString((ByteBuffer)localObject6);
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1485;
      }
      bool21 = true;
      if (bool21) {
        str12 = paramFissionAdapter.readString((ByteBuffer)localObject6);
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1491;
      }
      bool6 = true;
      bool5 = bool6;
      if (bool6)
      {
        i = ((ByteBuffer)localObject6).get();
        localObject4 = localStateBuilder;
        bool5 = bool6;
        if (i == 0)
        {
          localObject4 = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localStateBuilder = StateBuilder.INSTANCE;
          localObject4 = StateBuilder.readFromFission(paramFissionAdapter, null, (String)localObject4, paramFissionTransaction);
          if (localObject4 == null) {
            break label1497;
          }
          bool5 = true;
        }
        if (i == 1)
        {
          localObject4 = StateBuilder.INSTANCE;
          localObject4 = StateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (localObject4 == null) {
            break label1503;
          }
          bool5 = true;
        }
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1509;
      }
      bool22 = true;
      label1190:
      if (bool22) {
        str13 = paramFissionAdapter.readString((ByteBuffer)localObject6);
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1515;
      }
      bool6 = true;
      label1217:
      bool7 = bool6;
      if (bool6)
      {
        i = ((ByteBuffer)localObject6).get();
        localObject5 = localMiniProfileBuilder;
        if (i == 0)
        {
          localObject5 = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localMiniProfileBuilder = MiniProfileBuilder.INSTANCE;
          localObject5 = MiniProfileBuilder.readFromFission(paramFissionAdapter, null, (String)localObject5, paramFissionTransaction);
          if (localObject5 == null) {
            break label1521;
          }
          bool6 = true;
        }
        label1275:
        bool7 = bool6;
        if (i == 1)
        {
          localObject5 = MiniProfileBuilder.INSTANCE;
          localObject5 = MiniProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (localObject5 == null) {
            break label1527;
          }
        }
      }
    }
    label1341:
    label1347:
    label1353:
    label1359:
    label1365:
    label1371:
    label1377:
    label1383:
    label1389:
    label1395:
    label1401:
    label1407:
    label1413:
    label1419:
    label1425:
    label1431:
    label1437:
    label1443:
    label1449:
    label1455:
    label1461:
    label1467:
    label1473:
    label1479:
    label1485:
    label1491:
    label1497:
    label1503:
    label1509:
    label1515:
    label1521:
    label1527:
    for (boolean bool7 = true;; bool7 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject6);
      }
      if (bool9) {
        break label1533;
      }
      throw new IOException("Failed to find required field: firstName when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.Profile from fission.");
      bool8 = false;
      break;
      bool9 = false;
      break label324;
      bool10 = false;
      break label351;
      bool11 = false;
      break label378;
      bool12 = false;
      break label405;
      bool13 = false;
      break label432;
      bool14 = false;
      break label459;
      bool2 = false;
      break label494;
      bool1 = false;
      break label551;
      bool1 = false;
      break label577;
      bool3 = false;
      break label589;
      bool2 = false;
      break label651;
      bool2 = false;
      break label680;
      bool4 = false;
      break label692;
      bool3 = false;
      break label754;
      bool3 = false;
      break label783;
      bool15 = false;
      break label795;
      bool16 = false;
      break label822;
      bool17 = false;
      break label849;
      bool18 = false;
      break label876;
      bool19 = false;
      break label903;
      bool5 = false;
      break label930;
      bool4 = false;
      break label992;
      bool4 = false;
      break label1021;
      bool20 = false;
      break label1033;
      bool21 = false;
      break label1060;
      bool6 = false;
      break label1087;
      bool5 = false;
      break label1149;
      bool5 = false;
      break label1178;
      bool22 = false;
      break label1190;
      bool6 = false;
      break label1217;
      bool6 = false;
      break label1275;
    }
    label1533:
    if (!bool21) {
      throw new IOException("Failed to find required field: versionTag when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.Profile from fission.");
    }
    if (!bool7) {
      throw new IOException("Failed to find required field: miniProfile when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.Profile from fission.");
    }
    return new Profile((Urn)localObject7, str1, str2, str3, str4, str5, (Urn)localObject8, paramString, (BackgroundImage)localObject1, (Picture)localObject2, str6, str7, str8, str9, str10, (Date)localObject3, str11, str12, (State)localObject4, str13, (MiniProfile)localObject5, bool8, bool9, bool10, bool11, bool12, bool13, bool14, bool1, bool2, bool3, bool15, bool16, bool17, bool18, bool19, bool4, bool20, bool21, bool5, bool22, bool7);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */