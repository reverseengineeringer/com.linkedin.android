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

public final class MiniSkillBuilder
  implements FissileDataModelBuilder<MiniSkill>, DataTemplateBuilder<MiniSkill>
{
  public static final MiniSkillBuilder INSTANCE = new MiniSkillBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("trackingId");
    JSON_KEY_STORE.put("objectUrn");
    JSON_KEY_STORE.put("entityUrn");
    JSON_KEY_STORE.put("name");
  }
  
  public static MiniSkill build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str2 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    String str1 = null;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("trackingId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("objectUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = UrnCoercer.INSTANCE;
        localObject2 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("entityUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = UrnCoercer.INSTANCE;
        localObject1 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("name", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: entityUrn when building com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSkill");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: name when building com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSkill");
    }
    return new MiniSkill(str2, (Urn)localObject2, (Urn)localObject1, str1, bool4, bool3, bool2, bool1);
  }
  
  public static MiniSkill readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building MiniSkill");
    }
    Object localObject2 = paramByteBuffer;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building MiniSkill");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building MiniSkill");
    }
    if (((ByteBuffer)localObject1).getInt() != -497626770)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building MiniSkill");
    }
    paramString = null;
    paramFissionTransaction = null;
    localObject2 = null;
    String str = null;
    boolean bool1;
    boolean bool2;
    label245:
    boolean bool3;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label361;
      }
      bool2 = true;
      if (bool2)
      {
        paramFissionTransaction = UrnCoercer.INSTANCE;
        paramFissionTransaction = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject1));
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label367;
      }
      bool3 = true;
      label278:
      if (bool3)
      {
        localObject2 = UrnCoercer.INSTANCE;
        localObject2 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject1));
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label373;
      }
    }
    label361:
    label367:
    label373:
    for (boolean bool4 = true;; bool4 = false)
    {
      if (bool4) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool3) {
        break label379;
      }
      throw new IOException("Failed to find required field: entityUrn when reading com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSkill from fission.");
      bool1 = false;
      break;
      bool2 = false;
      break label245;
      bool3 = false;
      break label278;
    }
    label379:
    if (!bool4) {
      throw new IOException("Failed to find required field: name when reading com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSkill from fission.");
    }
    return new MiniSkill(paramString, paramFissionTransaction, (Urn)localObject2, str, bool1, bool2, bool3, bool4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSkillBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */