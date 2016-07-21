package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfoBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchoolBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SearchSchoolBuilder
  implements FissileDataModelBuilder<SearchSchool>, DataTemplateBuilder<SearchSchool>
{
  public static final SearchSchoolBuilder INSTANCE = new SearchSchoolBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("id");
    JSON_KEY_STORE.put("backendUrn");
    JSON_KEY_STORE.put("school");
    JSON_KEY_STORE.put("location");
    JSON_KEY_STORE.put("studentAndAlumniCount");
    JSON_KEY_STORE.put("following");
  }
  
  public static SearchSchool build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str2 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    String str1 = null;
    int i = 0;
    Object localObject1 = null;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("id", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("backendUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("school", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = MiniSchoolBuilder.INSTANCE;
        localObject2 = MiniSchoolBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("location", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("studentAndAlumniCount", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("following", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = FollowingInfoBuilder.INSTANCE;
        localObject1 = FollowingInfoBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: id when building com.linkedin.android.pegasus.gen.voyager.search.SearchSchool");
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: backendUrn when building com.linkedin.android.pegasus.gen.voyager.search.SearchSchool");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: school when building com.linkedin.android.pegasus.gen.voyager.search.SearchSchool");
    }
    return new SearchSchool(str2, (Urn)localObject3, (MiniSchool)localObject2, str1, i, (FollowingInfo)localObject1, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static SearchSchool readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SearchSchool");
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
          localObject2 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SearchSchool");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building SearchSchool");
    }
    if (((ByteBuffer)localObject2).getInt() != -1245649969)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building SearchSchool");
    }
    String str1 = null;
    Object localObject3 = null;
    paramString = null;
    MiniSchoolBuilder localMiniSchoolBuilder = null;
    String str2 = null;
    int i = 0;
    localObject1 = null;
    FollowingInfoBuilder localFollowingInfoBuilder = null;
    boolean bool4;
    boolean bool5;
    label259:
    boolean bool2;
    label294:
    boolean bool1;
    label351:
    label377:
    boolean bool6;
    label389:
    boolean bool7;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool4 = true;
      if (bool4) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label564;
      }
      bool5 = true;
      if (bool5)
      {
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject2));
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label570;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        j = ((ByteBuffer)localObject2).get();
        paramString = localMiniSchoolBuilder;
        bool1 = bool2;
        if (j == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localMiniSchoolBuilder = MiniSchoolBuilder.INSTANCE;
          paramString = MiniSchoolBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label576;
          }
          bool1 = true;
        }
        if (j == 1)
        {
          paramString = MiniSchoolBuilder.INSTANCE;
          paramString = MiniSchoolBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label582;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label588;
      }
      bool6 = true;
      if (bool6) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label594;
      }
      bool7 = true;
      label416:
      if (bool7) {
        i = ((ByteBuffer)localObject2).getInt();
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label600;
      }
      bool2 = true;
      label440:
      bool3 = bool2;
      if (bool2)
      {
        j = ((ByteBuffer)localObject2).get();
        localObject1 = localFollowingInfoBuilder;
        if (j == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localFollowingInfoBuilder = FollowingInfoBuilder.INSTANCE;
          localObject1 = FollowingInfoBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label606;
          }
          bool2 = true;
        }
        label498:
        bool3 = bool2;
        if (j == 1)
        {
          localObject1 = FollowingInfoBuilder.INSTANCE;
          localObject1 = FollowingInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label612;
          }
        }
      }
    }
    label564:
    label570:
    label576:
    label582:
    label588:
    label594:
    label600:
    label606:
    label612:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (bool4) {
        break label618;
      }
      throw new IOException("Failed to find required field: id when reading com.linkedin.android.pegasus.gen.voyager.search.SearchSchool from fission.");
      bool4 = false;
      break;
      bool5 = false;
      break label259;
      bool2 = false;
      break label294;
      bool1 = false;
      break label351;
      bool1 = false;
      break label377;
      bool6 = false;
      break label389;
      bool7 = false;
      break label416;
      bool2 = false;
      break label440;
      bool2 = false;
      break label498;
    }
    label618:
    if (!bool5) {
      throw new IOException("Failed to find required field: backendUrn when reading com.linkedin.android.pegasus.gen.voyager.search.SearchSchool from fission.");
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: school when reading com.linkedin.android.pegasus.gen.voyager.search.SearchSchool from fission.");
    }
    return new SearchSchool(str1, (Urn)localObject3, paramString, str2, i, (FollowingInfo)localObject1, bool4, bool5, bool1, bool6, bool7, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchSchoolBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */