package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.TimeRange;
import com.linkedin.android.pegasus.gen.common.TimeRangeBuilder;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedTextBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class AggregateProfileViewCardBuilder
  implements FissileDataModelBuilder<AggregateProfileViewCard>, DataTemplateBuilder<AggregateProfileViewCard>
{
  public static final AggregateProfileViewCardBuilder INSTANCE = new AggregateProfileViewCardBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("publishedAt");
    JSON_KEY_STORE.put("someViewers");
    JSON_KEY_STORE.put("viewsTimeRange");
    JSON_KEY_STORE.put("numViewers");
    JSON_KEY_STORE.put("read");
    JSON_KEY_STORE.put("profileViewCta");
  }
  
  public static AggregateProfileViewCard build(DataReader paramDataReader)
    throws DataReaderException
  {
    long l2 = 0L;
    ArrayList localArrayList = null;
    Object localObject2 = null;
    long l1 = 0L;
    boolean bool7 = false;
    Object localObject1 = null;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("publishedAt", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l2 = paramDataReader.readLong();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("someViewers", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            ProfileViewerBuilder localProfileViewerBuilder = ProfileViewerBuilder.INSTANCE;
            localArrayList.add(ProfileViewerBuilder.build(paramDataReader));
          }
        }
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("viewsTimeRange", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = TimeRangeBuilder.INSTANCE;
        localObject2 = TimeRangeBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("numViewers", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l1 = paramDataReader.readLong();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("read", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool7 = paramDataReader.readBoolean();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("profileViewCta", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = AttributedTextBuilder.INSTANCE;
        localObject1 = AttributedTextBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: publishedAt when building com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateProfileViewCard");
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: someViewers when building com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateProfileViewCard");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: numViewers when building com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateProfileViewCard");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: read when building com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateProfileViewCard");
    }
    return new AggregateProfileViewCard(l2, localArrayList, (TimeRange)localObject2, l1, bool7, (AttributedText)localObject1, bool6, bool5, bool4, bool2, bool3, bool1);
  }
  
  public static AggregateProfileViewCard readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building AggregateProfileViewCard");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building AggregateProfileViewCard");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building AggregateProfileViewCard");
    }
    if (((ByteBuffer)localObject2).getInt() != 283458368)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building AggregateProfileViewCard");
    }
    long l1 = 0L;
    Object localObject3 = null;
    Object localObject4 = null;
    TimeRangeBuilder localTimeRangeBuilder = null;
    long l2 = 0L;
    boolean bool4 = false;
    localObject1 = null;
    AttributedTextBuilder localAttributedTextBuilder = null;
    boolean bool5;
    boolean bool6;
    label257:
    ArrayList localArrayList;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool5 = true;
      if (bool5) {
        l1 = ((ByteBuffer)localObject2).getLong();
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label391;
      }
      bool6 = true;
      if (!bool6) {
        break label409;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2);
      localArrayList = new ArrayList();
      label281:
      localObject3 = localArrayList;
      if (j <= 0) {
        break label409;
      }
      paramString = null;
      i = 1;
      int k = ((ByteBuffer)localObject2).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
        localObject3 = ProfileViewerBuilder.INSTANCE;
        paramString = ProfileViewerBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label397;
        }
        i = 1;
      }
      label336:
      if (k == 1)
      {
        paramString = ProfileViewerBuilder.INSTANCE;
        paramString = ProfileViewerBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
        if (paramString == null) {
          break label403;
        }
      }
    }
    label391:
    label397:
    label403:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      j -= 1;
      break label281;
      bool5 = false;
      break;
      bool6 = false;
      break label257;
      i = 0;
      break label336;
    }
    label409:
    boolean bool2;
    boolean bool1;
    label481:
    label507:
    boolean bool7;
    label519:
    boolean bool8;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool2 = true;
      paramString = (String)localObject4;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = localTimeRangeBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localTimeRangeBuilder = TimeRangeBuilder.INSTANCE;
          paramString = TimeRangeBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label696;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = TimeRangeBuilder.INSTANCE;
          paramString = TimeRangeBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label702;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label708;
      }
      bool7 = true;
      if (bool7) {
        l2 = ((ByteBuffer)localObject2).getLong();
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label714;
      }
      bool8 = true;
      label543:
      if (bool8)
      {
        if (((ByteBuffer)localObject2).get() != 1) {
          break label720;
        }
        bool4 = true;
      }
      label560:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label726;
      }
      bool2 = true;
      label572:
      bool3 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        localObject1 = localAttributedTextBuilder;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localAttributedTextBuilder = AttributedTextBuilder.INSTANCE;
          localObject1 = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label732;
          }
          bool2 = true;
        }
        label630:
        bool3 = bool2;
        if (i == 1)
        {
          localObject1 = AttributedTextBuilder.INSTANCE;
          localObject1 = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label738;
          }
        }
      }
    }
    label696:
    label702:
    label708:
    label714:
    label720:
    label726:
    label732:
    label738:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (bool5) {
        break label744;
      }
      throw new IOException("Failed to find required field: publishedAt when reading com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateProfileViewCard from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label481;
      bool1 = false;
      break label507;
      bool7 = false;
      break label519;
      bool8 = false;
      break label543;
      bool4 = false;
      break label560;
      bool2 = false;
      break label572;
      bool2 = false;
      break label630;
    }
    label744:
    if (!bool6) {
      throw new IOException("Failed to find required field: someViewers when reading com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateProfileViewCard from fission.");
    }
    if (!bool7) {
      throw new IOException("Failed to find required field: numViewers when reading com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateProfileViewCard from fission.");
    }
    if (!bool8) {
      throw new IOException("Failed to find required field: read when reading com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateProfileViewCard from fission.");
    }
    return new AggregateProfileViewCard(l1, (List)localObject3, paramString, l2, bool4, (AttributedText)localObject1, bool5, bool6, bool1, bool7, bool8, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateProfileViewCardBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */