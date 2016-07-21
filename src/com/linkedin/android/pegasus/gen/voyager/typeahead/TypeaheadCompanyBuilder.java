package com.linkedin.android.pegasus.gen.voyager.typeahead;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfoBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompanyBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class TypeaheadCompanyBuilder
  implements FissileDataModelBuilder<TypeaheadCompany>, DataTemplateBuilder<TypeaheadCompany>
{
  public static final TypeaheadCompanyBuilder INSTANCE = new TypeaheadCompanyBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("id");
    JSON_KEY_STORE.put("backendUrn");
    JSON_KEY_STORE.put("company");
    JSON_KEY_STORE.put("following");
    JSON_KEY_STORE.put("industryId");
  }
  
  public static TypeaheadCompany build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    int i = 0;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("id", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("backendUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("company", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = MiniCompanyBuilder.INSTANCE;
        localObject2 = MiniCompanyBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("following", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = FollowingInfoBuilder.INSTANCE;
        localObject1 = FollowingInfoBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("industryId", JSON_KEY_STORE))
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
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: id when building com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadCompany");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: backendUrn when building com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadCompany");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: company when building com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadCompany");
    }
    return new TypeaheadCompany(str, (Urn)localObject3, (MiniCompany)localObject2, (FollowingInfo)localObject1, i, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static TypeaheadCompany readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building TypeaheadCompany");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building TypeaheadCompany");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building TypeaheadCompany");
    }
    if (((ByteBuffer)localObject2).getInt() != -212830758)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building TypeaheadCompany");
    }
    String str = null;
    Object localObject3 = null;
    paramString = null;
    MiniCompanyBuilder localMiniCompanyBuilder = null;
    localObject1 = null;
    FollowingInfoBuilder localFollowingInfoBuilder = null;
    int i = 0;
    boolean bool4;
    boolean bool5;
    label256:
    boolean bool2;
    label291:
    boolean bool1;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool4 = true;
      if (bool4) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label534;
      }
      bool5 = true;
      if (bool5)
      {
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject2));
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label540;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        j = ((ByteBuffer)localObject2).get();
        paramString = localMiniCompanyBuilder;
        bool1 = bool2;
        if (j == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localMiniCompanyBuilder = MiniCompanyBuilder.INSTANCE;
          paramString = MiniCompanyBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label546;
          }
          bool1 = true;
        }
        label348:
        if (j == 1)
        {
          paramString = MiniCompanyBuilder.INSTANCE;
          paramString = MiniCompanyBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label552;
          }
          bool1 = true;
        }
      }
      label374:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label558;
      }
      bool3 = true;
      label386:
      bool2 = bool3;
      if (bool3)
      {
        j = ((ByteBuffer)localObject2).get();
        localObject1 = localFollowingInfoBuilder;
        bool2 = bool3;
        if (j == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localFollowingInfoBuilder = FollowingInfoBuilder.INSTANCE;
          localObject1 = FollowingInfoBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label564;
          }
          bool2 = true;
        }
        label448:
        if (j == 1)
        {
          localObject1 = FollowingInfoBuilder.INSTANCE;
          localObject1 = FollowingInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label570;
          }
          bool2 = true;
        }
      }
      label477:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label576;
      }
    }
    label534:
    label540:
    label546:
    label552:
    label558:
    label564:
    label570:
    label576:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (bool3) {
        i = ((ByteBuffer)localObject2).getInt();
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (bool4) {
        break label582;
      }
      throw new IOException("Failed to find required field: id when reading com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadCompany from fission.");
      bool4 = false;
      break;
      bool5 = false;
      break label256;
      bool2 = false;
      break label291;
      bool1 = false;
      break label348;
      bool1 = false;
      break label374;
      bool3 = false;
      break label386;
      bool2 = false;
      break label448;
      bool2 = false;
      break label477;
    }
    label582:
    if (!bool5) {
      throw new IOException("Failed to find required field: backendUrn when reading com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadCompany from fission.");
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: company when reading com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadCompany from fission.");
    }
    return new TypeaheadCompany(str, (Urn)localObject3, paramString, (FollowingInfo)localObject1, i, bool4, bool5, bool1, bool2, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadCompanyBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */