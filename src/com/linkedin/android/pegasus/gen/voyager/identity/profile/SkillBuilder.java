package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSkill;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSkillBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SkillBuilder
  implements FissileDataModelBuilder<Skill>, DataTemplateBuilder<Skill>
{
  public static final SkillBuilder INSTANCE = new SkillBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("standardizedSkillUrn");
    JSON_KEY_STORE.put("name");
    JSON_KEY_STORE.put("entityUrn");
    JSON_KEY_STORE.put("standardizedSkill");
  }
  
  public static Skill build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject3 = null;
    String str = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("standardizedSkillUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("name", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("entityUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = UrnCoercer.INSTANCE;
        localObject2 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("standardizedSkill", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = MiniSkillBuilder.INSTANCE;
        localObject1 = MiniSkillBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: name when building com.linkedin.android.pegasus.gen.voyager.identity.profile.Skill");
    }
    return new Skill((Urn)localObject3, str, (Urn)localObject2, (MiniSkill)localObject1, bool4, bool3, bool2, bool1);
  }
  
  public static Skill readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Skill");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building Skill");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building Skill");
    }
    if (((ByteBuffer)localObject1).getInt() != -1336031963)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building Skill");
    }
    localObject2 = null;
    String str = null;
    Object localObject3 = null;
    paramString = null;
    MiniSkillBuilder localMiniSkillBuilder = null;
    boolean bool3;
    boolean bool4;
    label258:
    boolean bool5;
    label285:
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool3 = true;
      if (bool3)
      {
        localObject2 = UrnCoercer.INSTANCE;
        localObject2 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject1));
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label436;
      }
      bool4 = true;
      if (bool4) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label442;
      }
      bool5 = true;
      if (bool5)
      {
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject1));
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label448;
      }
      bool1 = true;
      label320:
      bool2 = bool1;
      if (bool1)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = localMiniSkillBuilder;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localMiniSkillBuilder = MiniSkillBuilder.INSTANCE;
          paramString = MiniSkillBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label454;
          }
          bool1 = true;
        }
        label373:
        bool2 = bool1;
        if (i == 1)
        {
          paramString = MiniSkillBuilder.INSTANCE;
          paramString = MiniSkillBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label460;
          }
        }
      }
    }
    label436:
    label442:
    label448:
    label454:
    label460:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool4) {
        break label466;
      }
      throw new IOException("Failed to find required field: name when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.Skill from fission.");
      bool3 = false;
      break;
      bool4 = false;
      break label258;
      bool5 = false;
      break label285;
      bool1 = false;
      break label320;
      bool1 = false;
      break label373;
    }
    label466:
    return new Skill((Urn)localObject2, str, (Urn)localObject3, paramString, bool3, bool4, bool5, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.SkillBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */