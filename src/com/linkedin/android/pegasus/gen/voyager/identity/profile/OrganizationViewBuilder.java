package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.restli.common.CollectionMetadataBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class OrganizationViewBuilder
  implements FissileDataModelBuilder<OrganizationView>, DataTemplateBuilder<OrganizationView>
{
  public static final OrganizationViewBuilder INSTANCE = new OrganizationViewBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("profileId");
    JSON_KEY_STORE.put("paging");
    JSON_KEY_STORE.put("elements");
  }
  
  public static OrganizationView build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str = null;
    Object localObject = null;
    ArrayList localArrayList = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("profileId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("paging", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = CollectionMetadataBuilder.INSTANCE;
        localObject = CollectionMetadataBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("elements", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            OrganizationBuilder localOrganizationBuilder = OrganizationBuilder.INSTANCE;
            localArrayList.add(OrganizationBuilder.build(paramDataReader));
          }
        }
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: paging when building com.linkedin.android.pegasus.gen.voyager.identity.profile.OrganizationView");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: elements when building com.linkedin.android.pegasus.gen.voyager.identity.profile.OrganizationView");
    }
    return new OrganizationView(str, (CollectionMetadata)localObject, localArrayList, bool3, bool2, bool1);
  }
  
  public static OrganizationView readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building OrganizationView");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building OrganizationView");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building OrganizationView");
    }
    if (((ByteBuffer)localObject2).getInt() != 1746363146)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building OrganizationView");
    }
    String str = null;
    paramString = null;
    Object localObject3 = null;
    localObject1 = null;
    boolean bool3;
    boolean bool2;
    label247:
    boolean bool1;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool3 = true;
      if (bool3) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label485;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = (String)localObject3;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localObject3 = CollectionMetadataBuilder.INSTANCE;
          paramString = CollectionMetadataBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label491;
          }
          bool1 = true;
        }
        label304:
        if (i == 1)
        {
          paramString = CollectionMetadataBuilder.INSTANCE;
          paramString = CollectionMetadataBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label497;
          }
          bool1 = true;
        }
      }
      label330:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label503;
      }
      bool2 = true;
      label342:
      if (!bool2) {
        break label521;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2);
      localObject3 = new ArrayList();
      label366:
      localObject1 = localObject3;
      if (j <= 0) {
        break label521;
      }
      localObject1 = null;
      i = 1;
      int k = ((ByteBuffer)localObject2).get();
      if (k == 0)
      {
        localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
        OrganizationBuilder localOrganizationBuilder = OrganizationBuilder.INSTANCE;
        localObject1 = OrganizationBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
        if (localObject1 == null) {
          break label509;
        }
        i = 1;
      }
      label426:
      if (k == 1)
      {
        localObject1 = OrganizationBuilder.INSTANCE;
        localObject1 = OrganizationBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
        if (localObject1 == null) {
          break label515;
        }
      }
    }
    label485:
    label491:
    label497:
    label503:
    label509:
    label515:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject3).add(localObject1);
      }
      j -= 1;
      break label366;
      bool3 = false;
      break;
      bool2 = false;
      break label247;
      bool1 = false;
      break label304;
      bool1 = false;
      break label330;
      bool2 = false;
      break label342;
      i = 0;
      break label426;
    }
    label521:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: paging when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.OrganizationView from fission.");
    }
    if (!bool2) {
      throw new IOException("Failed to find required field: elements when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.OrganizationView from fission.");
    }
    return new OrganizationView(str, paramString, (List)localObject1, bool3, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.OrganizationViewBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */