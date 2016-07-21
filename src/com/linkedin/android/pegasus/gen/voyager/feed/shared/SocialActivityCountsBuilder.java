package com.linkedin.android.pegasus.gen.voyager.feed.shared;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SocialActivityCountsBuilder
  implements FissileDataModelBuilder<SocialActivityCounts>, DataTemplateBuilder<SocialActivityCounts>
{
  public static final SocialActivityCountsBuilder INSTANCE = new SocialActivityCountsBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("numComments");
    JSON_KEY_STORE.put("numLikes");
    JSON_KEY_STORE.put("numViews");
    JSON_KEY_STORE.put("liked");
  }
  
  public static SocialActivityCounts build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject = null;
    long l3 = 0L;
    long l2 = 0L;
    long l1 = 0L;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("entityUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = UrnCoercer.INSTANCE;
        localObject = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("numComments", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l3 = paramDataReader.readLong();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("numLikes", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l2 = paramDataReader.readLong();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("numViews", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l1 = paramDataReader.readLong();
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("liked", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool6 = paramDataReader.readBoolean();
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: entityUrn when building com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: numComments when building com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: numLikes when building com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: liked when building com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts");
    }
    return new SocialActivityCounts((Urn)localObject, l3, l2, l1, bool6, bool5, bool4, bool3, bool1, bool2);
  }
  
  public static SocialActivityCounts readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SocialActivityCounts");
    }
    ByteBuffer localByteBuffer = paramByteBuffer;
    if (paramString != null)
    {
      paramString = paramFissionAdapter.readFromCache(paramString, paramFissionTransaction);
      if (paramString == null) {
        return null;
      }
      int i = paramString.get();
      int j;
      do
      {
        do
        {
          localObject = paramString;
          if (i != 0) {
            break;
          }
          localObject = paramFissionAdapter.readString(paramString);
          paramFissionAdapter.recycle(paramString);
          localObject = paramFissionAdapter.readFromCache((String)localObject, paramFissionTransaction);
          if (localObject == null) {
            return null;
          }
          j = ((ByteBuffer)localObject).get();
          paramString = (String)localObject;
          i = j;
        } while (j == 1);
        paramString = (String)localObject;
        i = j;
      } while (j == 0);
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("Invalid header prefix. Can't read cached data when building SocialActivityCounts");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building SocialActivityCounts");
    }
    if (((ByteBuffer)localObject).getInt() != -288734264)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building SocialActivityCounts");
    }
    paramString = null;
    long l1 = 0L;
    long l2 = 0L;
    long l3 = 0L;
    boolean bool1 = false;
    boolean bool2;
    boolean bool3;
    label256:
    boolean bool4;
    label280:
    boolean bool5;
    label304:
    boolean bool6;
    if (((ByteBuffer)localObject).get() == 1)
    {
      bool2 = true;
      if (bool2)
      {
        paramString = UrnCoercer.INSTANCE;
        paramString = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject));
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label378;
      }
      bool3 = true;
      if (bool3) {
        l1 = ((ByteBuffer)localObject).getLong();
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label384;
      }
      bool4 = true;
      if (bool4) {
        l2 = ((ByteBuffer)localObject).getLong();
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label390;
      }
      bool5 = true;
      if (bool5) {
        l3 = ((ByteBuffer)localObject).getLong();
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label396;
      }
      bool6 = true;
      label328:
      if (bool6) {
        if (((ByteBuffer)localObject).get() != 1) {
          break label402;
        }
      }
    }
    label378:
    label384:
    label390:
    label396:
    label402:
    for (bool1 = true;; bool1 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      if (bool2) {
        break label408;
      }
      throw new IOException("Failed to find required field: entityUrn when reading com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts from fission.");
      bool2 = false;
      break;
      bool3 = false;
      break label256;
      bool4 = false;
      break label280;
      bool5 = false;
      break label304;
      bool6 = false;
      break label328;
    }
    label408:
    if (!bool3) {
      throw new IOException("Failed to find required field: numComments when reading com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts from fission.");
    }
    if (!bool4) {
      throw new IOException("Failed to find required field: numLikes when reading com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts from fission.");
    }
    if (!bool6) {
      throw new IOException("Failed to find required field: liked when reading com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts from fission.");
    }
    return new SocialActivityCounts(paramString, l1, l2, l3, bool1, bool2, bool3, bool4, bool5, bool6);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCountsBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */