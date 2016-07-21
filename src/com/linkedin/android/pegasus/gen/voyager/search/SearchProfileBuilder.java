package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.MemberDistance;
import com.linkedin.android.pegasus.gen.voyager.common.MemberDistanceBuilder;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfileBuilder;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.SharedConnectionsInfo;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.SharedConnectionsInfoBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class SearchProfileBuilder
  implements FissileDataModelBuilder<SearchProfile>, DataTemplateBuilder<SearchProfile>
{
  public static final SearchProfileBuilder INSTANCE = new SearchProfileBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("miniProfile");
    JSON_KEY_STORE.put("id");
    JSON_KEY_STORE.put("backendUrn");
    JSON_KEY_STORE.put("distance");
    JSON_KEY_STORE.put("maidenName");
    JSON_KEY_STORE.put("industry");
    JSON_KEY_STORE.put("location");
    JSON_KEY_STORE.put("snippets");
    JSON_KEY_STORE.put("sharedConnectionCount");
    JSON_KEY_STORE.put("headless");
    JSON_KEY_STORE.put("sharedConnectionsInfo");
  }
  
  public static SearchProfile build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject4 = null;
    String str4 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    String str3 = null;
    String str2 = null;
    String str1 = null;
    ArrayList localArrayList = null;
    int i = 0;
    boolean bool12 = false;
    Object localObject1 = null;
    boolean bool11 = false;
    boolean bool10 = false;
    boolean bool9 = false;
    boolean bool8 = false;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("miniProfile", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = MiniProfileBuilder.INSTANCE;
        localObject4 = MiniProfileBuilder.build(paramDataReader);
        bool11 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("id", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str4 = paramDataReader.readString();
        bool10 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("backendUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool9 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("distance", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = MemberDistanceBuilder.INSTANCE;
        localObject2 = MemberDistanceBuilder.build(paramDataReader);
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("maidenName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("industry", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("location", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("snippets", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            SnippetBuilder localSnippetBuilder = SnippetBuilder.INSTANCE;
            localArrayList.add(SnippetBuilder.build(paramDataReader));
          }
        }
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("sharedConnectionCount", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("headless", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool12 = paramDataReader.readBoolean();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("sharedConnectionsInfo", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = SharedConnectionsInfoBuilder.INSTANCE;
        localObject1 = SharedConnectionsInfoBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool11) {
      throw new DataReaderException("Failed to find required field: miniProfile when building com.linkedin.android.pegasus.gen.voyager.search.SearchProfile");
    }
    if (!bool10) {
      throw new DataReaderException("Failed to find required field: id when building com.linkedin.android.pegasus.gen.voyager.search.SearchProfile");
    }
    if (!bool9) {
      throw new DataReaderException("Failed to find required field: backendUrn when building com.linkedin.android.pegasus.gen.voyager.search.SearchProfile");
    }
    if (!bool8) {
      throw new DataReaderException("Failed to find required field: distance when building com.linkedin.android.pegasus.gen.voyager.search.SearchProfile");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: headless when building com.linkedin.android.pegasus.gen.voyager.search.SearchProfile");
    }
    return new SearchProfile((MiniProfile)localObject4, str4, (Urn)localObject3, (MemberDistance)localObject2, str3, str2, str1, localArrayList, i, bool12, (SharedConnectionsInfo)localObject1, bool11, bool10, bool9, bool8, bool7, bool6, bool5, bool4, bool2, bool3, bool1);
  }
  
  public static SearchProfile readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SearchProfile");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SearchProfile");
    }
    Object localObject3 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building SearchProfile");
    }
    if (((ByteBuffer)localObject3).getInt() != -670248090)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject3);
      throw new IOException("UID mismatch. Can't read cached data when building SearchProfile");
    }
    paramString = null;
    Object localObject7 = null;
    String str1 = null;
    Object localObject4 = null;
    localObject1 = null;
    Object localObject2 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    Object localObject5 = null;
    int k = 0;
    boolean bool5 = false;
    Object localObject6 = null;
    SharedConnectionsInfoBuilder localSharedConnectionsInfoBuilder = null;
    boolean bool2;
    boolean bool1;
    label307:
    label333:
    boolean bool6;
    label345:
    boolean bool7;
    label372:
    boolean bool3;
    label407:
    label469:
    label498:
    boolean bool8;
    label510:
    boolean bool9;
    label537:
    boolean bool10;
    label564:
    boolean bool11;
    if (((ByteBuffer)localObject3).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject3).get();
        paramString = (String)localObject7;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localObject7 = MiniProfileBuilder.INSTANCE;
          paramString = MiniProfileBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label734;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = MiniProfileBuilder.INSTANCE;
          paramString = MiniProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (paramString == null) {
            break label740;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label746;
      }
      bool6 = true;
      if (bool6) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject3);
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label752;
      }
      bool7 = true;
      if (bool7)
      {
        localObject4 = UrnCoercer.INSTANCE;
        localObject4 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject3));
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label758;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject3).get();
        localObject1 = localObject2;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localObject2 = MemberDistanceBuilder.INSTANCE;
          localObject1 = MemberDistanceBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label764;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject1 = MemberDistanceBuilder.INSTANCE;
          localObject1 = MemberDistanceBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label770;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label776;
      }
      bool8 = true;
      if (bool8) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject3);
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label782;
      }
      bool9 = true;
      if (bool9) {
        str3 = paramFissionAdapter.readString((ByteBuffer)localObject3);
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label788;
      }
      bool10 = true;
      if (bool10) {
        str4 = paramFissionAdapter.readString((ByteBuffer)localObject3);
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label794;
      }
      bool11 = true;
      label591:
      if (!bool11) {
        break label812;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject3);
      localObject7 = new ArrayList();
      label615:
      localObject5 = localObject7;
      if (j <= 0) {
        break label812;
      }
      localObject2 = null;
      i = 1;
      int m = ((ByteBuffer)localObject3).get();
      if (m == 0)
      {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject3);
        localObject5 = SnippetBuilder.INSTANCE;
        localObject2 = SnippetBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
        if (localObject2 == null) {
          break label800;
        }
        i = 1;
      }
      label675:
      if (m == 1)
      {
        localObject2 = SnippetBuilder.INSTANCE;
        localObject2 = SnippetBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
        if (localObject2 == null) {
          break label806;
        }
      }
    }
    label734:
    label740:
    label746:
    label752:
    label758:
    label764:
    label770:
    label776:
    label782:
    label788:
    label794:
    label800:
    label806:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject7).add(localObject2);
      }
      j -= 1;
      break label615;
      bool2 = false;
      break;
      bool1 = false;
      break label307;
      bool1 = false;
      break label333;
      bool6 = false;
      break label345;
      bool7 = false;
      break label372;
      bool3 = false;
      break label407;
      bool2 = false;
      break label469;
      bool2 = false;
      break label498;
      bool8 = false;
      break label510;
      bool9 = false;
      break label537;
      bool10 = false;
      break label564;
      bool11 = false;
      break label591;
      i = 0;
      break label675;
    }
    label812:
    boolean bool12;
    boolean bool13;
    if (((ByteBuffer)localObject3).get() == 1)
    {
      bool12 = true;
      i = k;
      if (bool12) {
        i = ((ByteBuffer)localObject3).getInt();
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label1009;
      }
      bool13 = true;
      label852:
      if (bool13)
      {
        if (((ByteBuffer)localObject3).get() != 1) {
          break label1015;
        }
        bool5 = true;
      }
      label869:
      if (((ByteBuffer)localObject3).get() != 1) {
        break label1021;
      }
      bool3 = true;
      label881:
      localObject2 = localObject6;
      bool4 = bool3;
      if (bool3)
      {
        j = ((ByteBuffer)localObject3).get();
        localObject2 = localSharedConnectionsInfoBuilder;
        if (j == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localSharedConnectionsInfoBuilder = SharedConnectionsInfoBuilder.INSTANCE;
          localObject2 = SharedConnectionsInfoBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label1027;
          }
          bool3 = true;
        }
        label943:
        bool4 = bool3;
        if (j == 1)
        {
          localObject2 = SharedConnectionsInfoBuilder.INSTANCE;
          localObject2 = SharedConnectionsInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label1033;
          }
        }
      }
    }
    label1009:
    label1015:
    label1021:
    label1027:
    label1033:
    for (boolean bool4 = true;; bool4 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject3);
      }
      if (bool1) {
        break label1039;
      }
      throw new IOException("Failed to find required field: miniProfile when reading com.linkedin.android.pegasus.gen.voyager.search.SearchProfile from fission.");
      bool12 = false;
      break;
      bool13 = false;
      break label852;
      bool5 = false;
      break label869;
      bool3 = false;
      break label881;
      bool3 = false;
      break label943;
    }
    label1039:
    if (!bool6) {
      throw new IOException("Failed to find required field: id when reading com.linkedin.android.pegasus.gen.voyager.search.SearchProfile from fission.");
    }
    if (!bool7) {
      throw new IOException("Failed to find required field: backendUrn when reading com.linkedin.android.pegasus.gen.voyager.search.SearchProfile from fission.");
    }
    if (!bool2) {
      throw new IOException("Failed to find required field: distance when reading com.linkedin.android.pegasus.gen.voyager.search.SearchProfile from fission.");
    }
    if (!bool13) {
      throw new IOException("Failed to find required field: headless when reading com.linkedin.android.pegasus.gen.voyager.search.SearchProfile from fission.");
    }
    return new SearchProfile(paramString, str1, (Urn)localObject4, (MemberDistance)localObject1, str2, str3, str4, (List)localObject5, i, bool5, (SharedConnectionsInfo)localObject2, bool1, bool6, bool7, bool2, bool8, bool9, bool10, bool11, bool12, bool13, bool4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchProfileBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */