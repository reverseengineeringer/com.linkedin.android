package com.linkedin.android.pegasus.gen.voyager.entities.shared;

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

public final class MemberFollowingInfoBuilder
  implements FissileDataModelBuilder<MemberFollowingInfo>, DataTemplateBuilder<MemberFollowingInfo>
{
  public static final MemberFollowingInfoBuilder INSTANCE = new MemberFollowingInfoBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("following");
  }
  
  public static MemberFollowingInfo build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject = null;
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
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("following", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool3 = paramDataReader.readBoolean();
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: following when building com.linkedin.android.pegasus.gen.voyager.entities.shared.MemberFollowingInfo");
    }
    return new MemberFollowingInfo((Urn)localObject, bool3, bool1, bool2);
  }
  
  public static MemberFollowingInfo readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building MemberFollowingInfo");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building MemberFollowingInfo");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building MemberFollowingInfo");
    }
    if (((ByteBuffer)localObject).getInt() != 541675165)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building MemberFollowingInfo");
    }
    paramString = null;
    boolean bool1 = false;
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
        break label297;
      }
      bool3 = true;
      label247:
      if (bool3) {
        if (((ByteBuffer)localObject).get() != 1) {
          break label303;
        }
      }
    }
    label297:
    label303:
    for (bool1 = true;; bool1 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      if (bool3) {
        break label309;
      }
      throw new IOException("Failed to find required field: following when reading com.linkedin.android.pegasus.gen.voyager.entities.shared.MemberFollowingInfo from fission.");
      bool2 = false;
      break;
      bool3 = false;
      break label247;
    }
    label309:
    return new MemberFollowingInfo(paramString, bool1, bool2, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.shared.MemberFollowingInfoBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */