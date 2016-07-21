package com.linkedin.android.pegasus.gen.voyager.relationships.shared.pymk;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.GuestContact;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.GuestContactBuilder;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfileBuilder;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.InsightBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class PeopleYouMayKnowBuilder
  implements FissileDataModelBuilder<PeopleYouMayKnow>, DataTemplateBuilder<PeopleYouMayKnow>
{
  public static final PeopleYouMayKnowBuilder INSTANCE = new PeopleYouMayKnowBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("trackingId");
    JSON_KEY_STORE.put("entityUrn");
    JSON_KEY_STORE.put("entity");
    JSON_KEY_STORE.put("insights");
  }
  
  public static PeopleYouMayKnow build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("trackingId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("entityUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("entity", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = EntityBuilder.INSTANCE;
        localObject2 = EntityBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("insights", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            InsightBuilder localInsightBuilder = InsightBuilder.INSTANCE;
            ((List)localObject1).add(InsightBuilder.build(paramDataReader));
          }
        }
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool1) {
      localObject1 = Collections.emptyList();
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: trackingId when building com.linkedin.android.pegasus.gen.voyager.relationships.shared.pymk.PeopleYouMayKnow");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: entityUrn when building com.linkedin.android.pegasus.gen.voyager.relationships.shared.pymk.PeopleYouMayKnow");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: entity when building com.linkedin.android.pegasus.gen.voyager.relationships.shared.pymk.PeopleYouMayKnow");
    }
    return new PeopleYouMayKnow(str, (Urn)localObject3, (PeopleYouMayKnow.Entity)localObject2, (List)localObject1, bool4, bool3, bool2, bool1);
  }
  
  public static PeopleYouMayKnow readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building PeopleYouMayKnow");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building PeopleYouMayKnow");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building PeopleYouMayKnow");
    }
    if (((ByteBuffer)localObject2).getInt() != -1374691118)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building PeopleYouMayKnow");
    }
    String str = null;
    Object localObject3 = null;
    paramString = null;
    Object localObject4 = null;
    localObject1 = null;
    boolean bool3;
    boolean bool4;
    label250:
    boolean bool2;
    label285:
    boolean bool1;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool3 = true;
      if (bool3) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label523;
      }
      bool4 = true;
      if (bool4)
      {
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject2));
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label529;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = (String)localObject4;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localObject4 = EntityBuilder.INSTANCE;
          paramString = EntityBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label535;
          }
          bool1 = true;
        }
        label342:
        if (i == 1)
        {
          paramString = EntityBuilder.INSTANCE;
          paramString = EntityBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label541;
          }
          bool1 = true;
        }
      }
      label368:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label547;
      }
      bool2 = true;
      label380:
      if (!bool2) {
        break label565;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2);
      localObject4 = new ArrayList();
      label404:
      localObject1 = localObject4;
      if (j <= 0) {
        break label565;
      }
      localObject1 = null;
      i = 1;
      int k = ((ByteBuffer)localObject2).get();
      if (k == 0)
      {
        localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
        InsightBuilder localInsightBuilder = InsightBuilder.INSTANCE;
        localObject1 = InsightBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
        if (localObject1 == null) {
          break label553;
        }
        i = 1;
      }
      label464:
      if (k == 1)
      {
        localObject1 = InsightBuilder.INSTANCE;
        localObject1 = InsightBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
        if (localObject1 == null) {
          break label559;
        }
      }
    }
    label523:
    label529:
    label535:
    label541:
    label547:
    label553:
    label559:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject4).add(localObject1);
      }
      j -= 1;
      break label404;
      bool3 = false;
      break;
      bool4 = false;
      break label250;
      bool2 = false;
      break label285;
      bool1 = false;
      break label342;
      bool1 = false;
      break label368;
      bool2 = false;
      break label380;
      i = 0;
      break label464;
    }
    label565:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
    }
    if (!bool2) {
      localObject1 = Collections.emptyList();
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: trackingId when reading com.linkedin.android.pegasus.gen.voyager.relationships.shared.pymk.PeopleYouMayKnow from fission.");
    }
    if (!bool4) {
      throw new IOException("Failed to find required field: entityUrn when reading com.linkedin.android.pegasus.gen.voyager.relationships.shared.pymk.PeopleYouMayKnow from fission.");
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: entity when reading com.linkedin.android.pegasus.gen.voyager.relationships.shared.pymk.PeopleYouMayKnow from fission.");
    }
    return new PeopleYouMayKnow(str, (Urn)localObject3, paramString, (List)localObject1, bool3, bool4, bool1, bool2);
  }
  
  public static final class EntityBuilder
    implements FissileDataModelBuilder<PeopleYouMayKnow.Entity>, DataTemplateBuilder<PeopleYouMayKnow.Entity>
  {
    public static final EntityBuilder INSTANCE = new EntityBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.voyager.identity.shared.MiniProfile");
      JSON_KEY_STORE.put("com.linkedin.voyager.growth.abi.GuestContact");
    }
    
    public static PeopleYouMayKnow.Entity build(DataReader paramDataReader)
      throws DataReaderException
    {
      Object localObject1 = null;
      Object localObject2 = null;
      boolean bool1 = false;
      boolean bool2 = false;
      paramDataReader.startRecord();
      while (paramDataReader.hasMoreFields$255f299()) {
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.shared.MiniProfile", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = MiniProfileBuilder.INSTANCE;
          localObject1 = MiniProfileBuilder.build(paramDataReader);
          bool1 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.growth.abi.GuestContact", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = GuestContactBuilder.INSTANCE;
          localObject2 = GuestContactBuilder.build(paramDataReader);
          bool2 = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
      int i = 0;
      if (bool1) {
        i = 1;
      }
      if ((bool2) && (i != 0)) {
        throw new DataReaderException("Found more than 1 member when building .Entity");
      }
      return new PeopleYouMayKnow.Entity((MiniProfile)localObject1, (GuestContact)localObject2, bool1, bool2);
    }
    
    public static PeopleYouMayKnow.Entity readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building PeopleYouMayKnow.Entity");
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
        throw new IOException("Invalid header prefix. Can't read cached data when building PeopleYouMayKnow.Entity");
      }
      Object localObject2 = localObject1;
      if (((ByteBuffer)localObject1).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("Invalid header prefix. Can't read cached data when building PeopleYouMayKnow.Entity");
      }
      if (((ByteBuffer)localObject2).getInt() != 161958986)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
        throw new IOException("UID mismatch. Can't read cached data when building PeopleYouMayKnow.Entity");
      }
      paramString = null;
      MiniProfileBuilder localMiniProfileBuilder = null;
      localObject1 = null;
      GuestContactBuilder localGuestContactBuilder = null;
      boolean bool2;
      boolean bool1;
      if (((ByteBuffer)localObject2).get() == 1)
      {
        bool2 = true;
        bool1 = bool2;
        if (bool2)
        {
          i = ((ByteBuffer)localObject2).get();
          bool1 = bool2;
          paramString = localMiniProfileBuilder;
          if (i == 0)
          {
            paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
            localMiniProfileBuilder = MiniProfileBuilder.INSTANCE;
            paramString = MiniProfileBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label455;
            }
            bool1 = true;
          }
          label277:
          if (i == 1)
          {
            paramString = MiniProfileBuilder.INSTANCE;
            paramString = MiniProfileBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
            if (paramString == null) {
              break label461;
            }
            bool1 = true;
          }
        }
        label303:
        if (((ByteBuffer)localObject2).get() != 1) {
          break label467;
        }
        bool2 = true;
        label315:
        bool3 = bool2;
        if (bool2)
        {
          i = ((ByteBuffer)localObject2).get();
          localObject1 = localGuestContactBuilder;
          if (i == 0)
          {
            localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
            localGuestContactBuilder = GuestContactBuilder.INSTANCE;
            localObject1 = GuestContactBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
            if (localObject1 == null) {
              break label473;
            }
            bool2 = true;
          }
          label373:
          bool3 = bool2;
          if (i == 1)
          {
            localObject1 = GuestContactBuilder.INSTANCE;
            localObject1 = GuestContactBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
            if (localObject1 == null) {
              break label479;
            }
          }
        }
      }
      label455:
      label461:
      label467:
      label473:
      label479:
      for (boolean bool3 = true;; bool3 = false)
      {
        if (paramByteBuffer == null) {
          paramFissionAdapter.recycle((ByteBuffer)localObject2);
        }
        i = 0;
        if (bool1) {
          i = 1;
        }
        if ((!bool3) || (i == 0)) {
          break label485;
        }
        throw new IOException("Found more than 1 member when reading .Entity from fission.");
        bool2 = false;
        break;
        bool1 = false;
        break label277;
        bool1 = false;
        break label303;
        bool2 = false;
        break label315;
        bool2 = false;
        break label373;
      }
      label485:
      return new PeopleYouMayKnow.Entity(paramString, (GuestContact)localObject1, bool1, bool3);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.relationships.shared.pymk.PeopleYouMayKnowBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */