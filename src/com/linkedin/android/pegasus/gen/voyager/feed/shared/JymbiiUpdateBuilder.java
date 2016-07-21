package com.linkedin.android.pegasus.gen.voyager.feed.shared;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesFlavorBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJobBuilder;
import com.linkedin.android.pegasus.gen.voyager.feed.CompanyActor;
import com.linkedin.android.pegasus.gen.voyager.feed.CompanyActorBuilder;
import com.linkedin.android.pegasus.gen.voyager.feed.UpdateActionBuilder;
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

public final class JymbiiUpdateBuilder
  implements FissileDataModelBuilder<JymbiiUpdate>, DataTemplateBuilder<JymbiiUpdate>
{
  public static final JymbiiUpdateBuilder INSTANCE = new JymbiiUpdateBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("actions");
    JSON_KEY_STORE.put("urn");
    JSON_KEY_STORE.put("company");
    JSON_KEY_STORE.put("createdAt");
    JSON_KEY_STORE.put("miniJob");
    JSON_KEY_STORE.put("jobUrl");
    JSON_KEY_STORE.put("flavors");
  }
  
  public static JymbiiUpdate build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject2 = null;
    Object localObject5 = null;
    Object localObject4 = null;
    long l = 0L;
    Object localObject3 = null;
    String str = null;
    Object localObject1 = null;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299())
    {
      Object localObject6;
      if (paramDataReader.shouldReadField$11ca93e7("actions", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            localObject6 = UpdateActionBuilder.INSTANCE;
            ((List)localObject2).add(UpdateActionBuilder.build(paramDataReader));
          }
        }
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("urn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject5 = UrnCoercer.INSTANCE;
        localObject5 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("company", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = CompanyBuilder.INSTANCE;
        localObject4 = CompanyBuilder.build(paramDataReader);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("createdAt", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("miniJob", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = MiniJobBuilder.INSTANCE;
        localObject3 = MiniJobBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("jobUrl", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("flavors", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            localObject6 = EntitiesFlavorBuilder.INSTANCE;
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
    if (!bool7) {
      localObject2 = Collections.emptyList();
    }
    if (!bool1) {
      localObject1 = Collections.emptyList();
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: urn when building com.linkedin.android.pegasus.gen.voyager.feed.shared.JymbiiUpdate");
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: company when building com.linkedin.android.pegasus.gen.voyager.feed.shared.JymbiiUpdate");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: createdAt when building com.linkedin.android.pegasus.gen.voyager.feed.shared.JymbiiUpdate");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: miniJob when building com.linkedin.android.pegasus.gen.voyager.feed.shared.JymbiiUpdate");
    }
    return new JymbiiUpdate((List)localObject2, (Urn)localObject5, (JymbiiUpdate.Company)localObject4, l, (MiniJob)localObject3, str, (List)localObject1, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static JymbiiUpdate readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building JymbiiUpdate");
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
          localObject4 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building JymbiiUpdate");
    }
    Object localObject4 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building JymbiiUpdate");
    }
    if (((ByteBuffer)localObject4).getInt() != 691345961)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject4);
      throw new IOException("UID mismatch. Can't read cached data when building JymbiiUpdate");
    }
    paramString = null;
    Object localObject5 = null;
    localObject1 = null;
    Object localObject7 = null;
    long l = 0L;
    Object localObject2 = null;
    Object localObject6 = null;
    String str = null;
    Object localObject3 = null;
    boolean bool4;
    ArrayList localArrayList;
    label259:
    int k;
    if (((ByteBuffer)localObject4).get() == 1)
    {
      bool4 = true;
      if (!bool4) {
        break label380;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject4);
      localArrayList = new ArrayList();
      paramString = localArrayList;
      if (j <= 0) {
        break label380;
      }
      paramString = null;
      i = 1;
      k = ((ByteBuffer)localObject4).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject4);
        UpdateActionBuilder localUpdateActionBuilder = UpdateActionBuilder.INSTANCE;
        paramString = UpdateActionBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label368;
        }
        i = 1;
      }
      label313:
      if (k == 1)
      {
        paramString = UpdateActionBuilder.INSTANCE;
        paramString = UpdateActionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
        if (paramString == null) {
          break label374;
        }
      }
    }
    label368:
    label374:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      j -= 1;
      break label259;
      bool4 = false;
      break;
      i = 0;
      break label313;
    }
    label380:
    boolean bool5;
    boolean bool2;
    label427:
    boolean bool1;
    label489:
    label518:
    boolean bool6;
    label530:
    boolean bool3;
    label554:
    label616:
    label645:
    label657:
    boolean bool7;
    if (((ByteBuffer)localObject4).get() == 1)
    {
      bool5 = true;
      if (bool5)
      {
        localObject5 = UrnCoercer.INSTANCE;
        localObject5 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject4));
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label827;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject4).get();
        localObject1 = localObject7;
        bool1 = bool2;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localObject7 = CompanyBuilder.INSTANCE;
          localObject1 = CompanyBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label833;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          localObject1 = CompanyBuilder.INSTANCE;
          localObject1 = CompanyBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label839;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label845;
      }
      bool6 = true;
      if (bool6) {
        l = ((ByteBuffer)localObject4).getLong();
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label851;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject4).get();
        localObject2 = localObject6;
        bool2 = bool3;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localObject6 = MiniJobBuilder.INSTANCE;
          localObject2 = MiniJobBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label857;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject2 = MiniJobBuilder.INSTANCE;
          localObject2 = MiniJobBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label863;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label869;
      }
      bool3 = true;
      if (bool3) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject4);
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label875;
      }
      bool7 = true;
      label684:
      if (!bool7) {
        break label893;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject4);
      localObject6 = new ArrayList();
      label708:
      localObject3 = localObject6;
      if (j <= 0) {
        break label893;
      }
      localObject3 = null;
      i = 1;
      k = ((ByteBuffer)localObject4).get();
      if (k == 0)
      {
        localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject4);
        localObject7 = EntitiesFlavorBuilder.INSTANCE;
        localObject3 = EntitiesFlavorBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
        if (localObject3 == null) {
          break label881;
        }
        i = 1;
      }
      label768:
      if (k == 1)
      {
        localObject3 = EntitiesFlavorBuilder.INSTANCE;
        localObject3 = EntitiesFlavorBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
        if (localObject3 == null) {
          break label887;
        }
      }
    }
    label827:
    label833:
    label839:
    label845:
    label851:
    label857:
    label863:
    label869:
    label875:
    label881:
    label887:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject6).add(localObject3);
      }
      j -= 1;
      break label708;
      bool5 = false;
      break;
      bool2 = false;
      break label427;
      bool1 = false;
      break label489;
      bool1 = false;
      break label518;
      bool6 = false;
      break label530;
      bool3 = false;
      break label554;
      bool2 = false;
      break label616;
      bool2 = false;
      break label645;
      bool3 = false;
      break label657;
      bool7 = false;
      break label684;
      i = 0;
      break label768;
    }
    label893:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject4);
    }
    if (!bool4) {
      paramString = Collections.emptyList();
    }
    if (!bool7) {
      localObject3 = Collections.emptyList();
    }
    if (!bool5) {
      throw new IOException("Failed to find required field: urn when reading com.linkedin.android.pegasus.gen.voyager.feed.shared.JymbiiUpdate from fission.");
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: company when reading com.linkedin.android.pegasus.gen.voyager.feed.shared.JymbiiUpdate from fission.");
    }
    if (!bool6) {
      throw new IOException("Failed to find required field: createdAt when reading com.linkedin.android.pegasus.gen.voyager.feed.shared.JymbiiUpdate from fission.");
    }
    if (!bool2) {
      throw new IOException("Failed to find required field: miniJob when reading com.linkedin.android.pegasus.gen.voyager.feed.shared.JymbiiUpdate from fission.");
    }
    return new JymbiiUpdate(paramString, (Urn)localObject5, (JymbiiUpdate.Company)localObject1, l, (MiniJob)localObject2, str, (List)localObject3, bool4, bool5, bool1, bool6, bool2, bool3, bool7);
  }
  
  public static final class CompanyBuilder
    implements FissileDataModelBuilder<JymbiiUpdate.Company>, DataTemplateBuilder<JymbiiUpdate.Company>
  {
    public static final CompanyBuilder INSTANCE = new CompanyBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.voyager.feed.CompanyActor");
      JSON_KEY_STORE.put("com.linkedin.voyager.feed.shared.ExternalCompany");
    }
    
    public static JymbiiUpdate.Company build(DataReader paramDataReader)
      throws DataReaderException
    {
      Object localObject2 = null;
      Object localObject1 = null;
      boolean bool2 = false;
      boolean bool1 = false;
      paramDataReader.startRecord();
      while (paramDataReader.hasMoreFields$255f299()) {
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.CompanyActor", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = CompanyActorBuilder.INSTANCE;
          localObject2 = CompanyActorBuilder.build(paramDataReader);
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.shared.ExternalCompany", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = ExternalCompanyBuilder.INSTANCE;
          localObject1 = ExternalCompanyBuilder.build(paramDataReader);
          bool1 = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
      int i = 0;
      if (bool2) {
        i = 1;
      }
      if ((bool1) && (i != 0)) {
        throw new DataReaderException("Found more than 1 member when building .Company");
      }
      return new JymbiiUpdate.Company((CompanyActor)localObject2, (ExternalCompany)localObject1, bool2, bool1);
    }
    
    public static JymbiiUpdate.Company readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building JymbiiUpdate.Company");
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
        throw new IOException("Invalid header prefix. Can't read cached data when building JymbiiUpdate.Company");
      }
      Object localObject2 = localObject1;
      if (((ByteBuffer)localObject1).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("Invalid header prefix. Can't read cached data when building JymbiiUpdate.Company");
      }
      if (((ByteBuffer)localObject2).getInt() != -664617948)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
        throw new IOException("UID mismatch. Can't read cached data when building JymbiiUpdate.Company");
      }
      paramString = null;
      CompanyActorBuilder localCompanyActorBuilder = null;
      localObject1 = null;
      ExternalCompanyBuilder localExternalCompanyBuilder = null;
      boolean bool2;
      boolean bool1;
      if (((ByteBuffer)localObject2).get() == 1)
      {
        bool2 = true;
        bool1 = bool2;
        if (bool2)
        {
          i = ((ByteBuffer)localObject2).get();
          paramString = localCompanyActorBuilder;
          bool1 = bool2;
          if (i == 0)
          {
            paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
            localCompanyActorBuilder = CompanyActorBuilder.INSTANCE;
            paramString = CompanyActorBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label455;
            }
            bool1 = true;
          }
          label277:
          if (i == 1)
          {
            paramString = CompanyActorBuilder.INSTANCE;
            paramString = CompanyActorBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
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
          localObject1 = localExternalCompanyBuilder;
          if (i == 0)
          {
            localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
            localExternalCompanyBuilder = ExternalCompanyBuilder.INSTANCE;
            localObject1 = ExternalCompanyBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
            if (localObject1 == null) {
              break label473;
            }
            bool2 = true;
          }
          label373:
          bool3 = bool2;
          if (i == 1)
          {
            localObject1 = ExternalCompanyBuilder.INSTANCE;
            localObject1 = ExternalCompanyBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
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
        throw new IOException("Found more than 1 member when reading .Company from fission.");
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
      return new JymbiiUpdate.Company(paramString, (ExternalCompany)localObject1, bool1, bool3);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.shared.JymbiiUpdateBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */