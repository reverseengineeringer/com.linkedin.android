package com.linkedin.android.pegasus.gen.voyager.entities.shared;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class EntitiesFlavorBuilder$ReasonBuilder
  implements FissileDataModelBuilder<EntitiesFlavor.Reason>, DataTemplateBuilder<EntitiesFlavor.Reason>
{
  public static final ReasonBuilder INSTANCE = new ReasonBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("com.linkedin.voyager.entities.shared.InNetworkReason");
    JSON_KEY_STORE.put("com.linkedin.voyager.entities.shared.CompanyRecruitReason");
    JSON_KEY_STORE.put("com.linkedin.voyager.entities.shared.SchoolRecruitReason");
  }
  
  public static EntitiesFlavor.Reason build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.shared.InNetworkReason", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = InNetworkReasonBuilder.INSTANCE;
        localObject3 = InNetworkReasonBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.shared.CompanyRecruitReason", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = CompanyRecruitReasonBuilder.INSTANCE;
        localObject2 = CompanyRecruitReasonBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.entities.shared.SchoolRecruitReason", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = SchoolRecruitReasonBuilder.INSTANCE;
        localObject1 = SchoolRecruitReasonBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    int i = 0;
    if (bool3) {
      i = 1;
    }
    int j = i;
    if (bool2)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .Reason");
      }
      j = 1;
    }
    if ((bool1) && (j != 0)) {
      throw new DataReaderException("Found more than 1 member when building .Reason");
    }
    return new EntitiesFlavor.Reason((InNetworkReason)localObject3, (CompanyRecruitReason)localObject2, (SchoolRecruitReason)localObject1, bool3, bool2, bool1);
  }
  
  public static EntitiesFlavor.Reason readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building EntitiesFlavor.Reason");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building EntitiesFlavor.Reason");
    }
    Object localObject3 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building EntitiesFlavor.Reason");
    }
    if (((ByteBuffer)localObject3).getInt() != -1658429585)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject3);
      throw new IOException("UID mismatch. Can't read cached data when building EntitiesFlavor.Reason");
    }
    paramString = null;
    InNetworkReasonBuilder localInNetworkReasonBuilder = null;
    localObject1 = null;
    CompanyRecruitReasonBuilder localCompanyRecruitReasonBuilder = null;
    Object localObject2 = null;
    SchoolRecruitReasonBuilder localSchoolRecruitReasonBuilder = null;
    boolean bool2;
    boolean bool1;
    label283:
    label309:
    boolean bool3;
    if (((ByteBuffer)localObject3).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject3).get();
        paramString = localInNetworkReasonBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localInNetworkReasonBuilder = InNetworkReasonBuilder.INSTANCE;
          paramString = InNetworkReasonBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label568;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = InNetworkReasonBuilder.INSTANCE;
          paramString = InNetworkReasonBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (paramString == null) {
            break label574;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label580;
      }
      bool3 = true;
      label321:
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject3).get();
        localObject1 = localCompanyRecruitReasonBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localCompanyRecruitReasonBuilder = CompanyRecruitReasonBuilder.INSTANCE;
          localObject1 = CompanyRecruitReasonBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label586;
          }
          bool2 = true;
        }
        label383:
        if (i == 1)
        {
          localObject1 = CompanyRecruitReasonBuilder.INSTANCE;
          localObject1 = CompanyRecruitReasonBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label592;
          }
          bool2 = true;
        }
      }
      label412:
      if (((ByteBuffer)localObject3).get() != 1) {
        break label598;
      }
      bool3 = true;
      label424:
      bool4 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject3).get();
        localObject2 = localSchoolRecruitReasonBuilder;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localSchoolRecruitReasonBuilder = SchoolRecruitReasonBuilder.INSTANCE;
          localObject2 = SchoolRecruitReasonBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label604;
          }
          bool3 = true;
        }
        label482:
        bool4 = bool3;
        if (i == 1)
        {
          localObject2 = SchoolRecruitReasonBuilder.INSTANCE;
          localObject2 = SchoolRecruitReasonBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label610;
          }
        }
      }
    }
    label568:
    label574:
    label580:
    label586:
    label592:
    label598:
    label604:
    label610:
    for (boolean bool4 = true;; bool4 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject3);
      }
      i = 0;
      if (bool1) {
        i = 1;
      }
      j = i;
      if (!bool2) {
        break label619;
      }
      if (i == 0) {
        break label616;
      }
      throw new IOException("Found more than 1 member when reading .Reason from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label283;
      bool1 = false;
      break label309;
      bool3 = false;
      break label321;
      bool2 = false;
      break label383;
      bool2 = false;
      break label412;
      bool3 = false;
      break label424;
      bool3 = false;
      break label482;
    }
    label616:
    int j = 1;
    label619:
    if ((bool4) && (j != 0)) {
      throw new IOException("Found more than 1 member when reading .Reason from fission.");
    }
    return new EntitiesFlavor.Reason(paramString, (CompanyRecruitReason)localObject1, (SchoolRecruitReason)localObject2, bool1, bool2, bool4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesFlavorBuilder.ReasonBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */