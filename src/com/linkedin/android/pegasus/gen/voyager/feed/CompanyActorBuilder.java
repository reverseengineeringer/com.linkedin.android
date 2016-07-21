package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfoBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesFlavorBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompanyBuilder;
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

public final class CompanyActorBuilder
  implements FissileDataModelBuilder<CompanyActor>, DataTemplateBuilder<CompanyActor>
{
  public static final CompanyActorBuilder INSTANCE = new CompanyActorBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("urn");
    JSON_KEY_STORE.put("miniCompany");
    JSON_KEY_STORE.put("followingInfo");
    JSON_KEY_STORE.put("showFollowAction");
    JSON_KEY_STORE.put("flavors");
  }
  
  public static CompanyActor build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    boolean bool6 = false;
    Object localObject1 = null;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("urn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = UrnCoercer.INSTANCE;
        localObject4 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("miniCompany", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = MiniCompanyBuilder.INSTANCE;
        localObject3 = MiniCompanyBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("followingInfo", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = FollowingInfoBuilder.INSTANCE;
        localObject2 = FollowingInfoBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("showFollowAction", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool6 = paramDataReader.readBoolean();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("flavors", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            EntitiesFlavorBuilder localEntitiesFlavorBuilder = EntitiesFlavorBuilder.INSTANCE;
            ((List)localObject1).add(EntitiesFlavorBuilder.build(paramDataReader));
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
      throw new DataReaderException("Failed to find required field: miniCompany when building com.linkedin.android.pegasus.gen.voyager.feed.CompanyActor");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: followingInfo when building com.linkedin.android.pegasus.gen.voyager.feed.CompanyActor");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: showFollowAction when building com.linkedin.android.pegasus.gen.voyager.feed.CompanyActor");
    }
    return new CompanyActor((Urn)localObject4, (MiniCompany)localObject3, (FollowingInfo)localObject2, bool6, (List)localObject1, bool5, bool4, bool2, bool3, bool1);
  }
  
  public static CompanyActor readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building CompanyActor");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building CompanyActor");
    }
    Object localObject3 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building CompanyActor");
    }
    if (((ByteBuffer)localObject3).getInt() != 1214281986)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject3);
      throw new IOException("UID mismatch. Can't read cached data when building CompanyActor");
    }
    Object localObject4 = null;
    paramString = null;
    Object localObject6 = null;
    localObject1 = null;
    Object localObject5 = null;
    boolean bool6 = false;
    Object localObject2 = null;
    boolean bool4;
    boolean bool2;
    label264:
    boolean bool1;
    label321:
    label347:
    boolean bool3;
    label359:
    label421:
    label450:
    boolean bool5;
    if (((ByteBuffer)localObject3).get() == 1)
    {
      bool4 = true;
      if (bool4)
      {
        localObject4 = UrnCoercer.INSTANCE;
        localObject4 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject3));
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label638;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject3).get();
        paramString = (String)localObject6;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localObject6 = MiniCompanyBuilder.INSTANCE;
          paramString = MiniCompanyBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label644;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = MiniCompanyBuilder.INSTANCE;
          paramString = MiniCompanyBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (paramString == null) {
            break label650;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label656;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject3).get();
        localObject1 = localObject5;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localObject5 = FollowingInfoBuilder.INSTANCE;
          localObject1 = FollowingInfoBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label662;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject1 = FollowingInfoBuilder.INSTANCE;
          localObject1 = FollowingInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label668;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label674;
      }
      bool5 = true;
      label462:
      bool3 = bool6;
      if (bool5)
      {
        if (((ByteBuffer)localObject3).get() != 1) {
          break label680;
        }
        bool3 = true;
      }
      label483:
      if (((ByteBuffer)localObject3).get() != 1) {
        break label686;
      }
      bool6 = true;
      label495:
      if (!bool6) {
        break label704;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject3);
      localObject5 = new ArrayList();
      label519:
      localObject2 = localObject5;
      if (j <= 0) {
        break label704;
      }
      localObject2 = null;
      i = 1;
      int k = ((ByteBuffer)localObject3).get();
      if (k == 0)
      {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject3);
        localObject6 = EntitiesFlavorBuilder.INSTANCE;
        localObject2 = EntitiesFlavorBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
        if (localObject2 == null) {
          break label692;
        }
        i = 1;
      }
      label579:
      if (k == 1)
      {
        localObject2 = EntitiesFlavorBuilder.INSTANCE;
        localObject2 = EntitiesFlavorBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
        if (localObject2 == null) {
          break label698;
        }
      }
    }
    label638:
    label644:
    label650:
    label656:
    label662:
    label668:
    label674:
    label680:
    label686:
    label692:
    label698:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject5).add(localObject2);
      }
      j -= 1;
      break label519;
      bool4 = false;
      break;
      bool2 = false;
      break label264;
      bool1 = false;
      break label321;
      bool1 = false;
      break label347;
      bool3 = false;
      break label359;
      bool2 = false;
      break label421;
      bool2 = false;
      break label450;
      bool5 = false;
      break label462;
      bool3 = false;
      break label483;
      bool6 = false;
      break label495;
      i = 0;
      break label579;
    }
    label704:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject3);
    }
    if (!bool6) {
      localObject2 = Collections.emptyList();
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: miniCompany when reading com.linkedin.android.pegasus.gen.voyager.feed.CompanyActor from fission.");
    }
    if (!bool2) {
      throw new IOException("Failed to find required field: followingInfo when reading com.linkedin.android.pegasus.gen.voyager.feed.CompanyActor from fission.");
    }
    if (!bool5) {
      throw new IOException("Failed to find required field: showFollowAction when reading com.linkedin.android.pegasus.gen.voyager.feed.CompanyActor from fission.");
    }
    return new CompanyActor((Urn)localObject4, paramString, (FollowingInfo)localObject1, bool3, (List)localObject2, bool4, bool1, bool2, bool5, bool6);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.CompanyActorBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */