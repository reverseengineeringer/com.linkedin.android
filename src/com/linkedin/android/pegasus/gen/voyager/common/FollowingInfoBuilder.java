package com.linkedin.android.pegasus.gen.voyager.common;

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

public final class FollowingInfoBuilder
  implements FissileDataModelBuilder<FollowingInfo>, DataTemplateBuilder<FollowingInfo>
{
  public static final FollowingInfoBuilder INSTANCE = new FollowingInfoBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("following");
    JSON_KEY_STORE.put("followerCount");
  }
  
  public static FollowingInfo build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject = null;
    boolean bool4 = false;
    int i = 0;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("entityUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = UrnCoercer.INSTANCE;
        localObject = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("following", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool4 = paramDataReader.readBoolean();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("followerCount", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: entityUrn when building com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: following when building com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo");
    }
    return new FollowingInfo((Urn)localObject, bool4, i, bool2, bool3, bool1);
  }
  
  public static FollowingInfo readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building FollowingInfo");
    }
    ByteBuffer localByteBuffer = paramByteBuffer;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building FollowingInfo");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building FollowingInfo");
    }
    if (((ByteBuffer)localObject).getInt() != 1816936490)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building FollowingInfo");
    }
    paramString = null;
    boolean bool1 = false;
    int i = 0;
    boolean bool2;
    boolean bool3;
    if (((ByteBuffer)localObject).get() == 1)
    {
      bool2 = true;
      if (bool2)
      {
        paramString = UrnCoercer.INSTANCE;
        paramString = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject));
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label324;
      }
      bool3 = true;
      label250:
      if (bool3)
      {
        if (((ByteBuffer)localObject).get() != 1) {
          break label330;
        }
        bool1 = true;
      }
      label267:
      if (((ByteBuffer)localObject).get() != 1) {
        break label336;
      }
    }
    label324:
    label330:
    label336:
    for (boolean bool4 = true;; bool4 = false)
    {
      if (bool4) {
        i = ((ByteBuffer)localObject).getInt();
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      if (bool2) {
        break label342;
      }
      throw new IOException("Failed to find required field: entityUrn when reading com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo from fission.");
      bool2 = false;
      break;
      bool3 = false;
      break label250;
      bool1 = false;
      break label267;
    }
    label342:
    if (!bool3) {
      throw new IOException("Failed to find required field: following when reading com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo from fission.");
    }
    return new FollowingInfo(paramString, bool1, i, bool2, bool3, bool4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.FollowingInfoBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */