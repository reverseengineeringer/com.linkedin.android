package com.linkedin.android.pegasus.gen.voyager.typeahead;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompanyBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class TypeaheadShowcaseBuilder
  implements FissileDataModelBuilder<TypeaheadShowcase>, DataTemplateBuilder<TypeaheadShowcase>
{
  public static final TypeaheadShowcaseBuilder INSTANCE = new TypeaheadShowcaseBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("id");
    JSON_KEY_STORE.put("backendUrn");
    JSON_KEY_STORE.put("company");
  }
  
  public static TypeaheadShowcase build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("id", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("backendUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = UrnCoercer.INSTANCE;
        localObject2 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("company", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = MiniCompanyBuilder.INSTANCE;
        localObject1 = MiniCompanyBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: id when building com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadShowcase");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: backendUrn when building com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadShowcase");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: company when building com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadShowcase");
    }
    return new TypeaheadShowcase(str, (Urn)localObject2, (MiniCompany)localObject1, bool3, bool2, bool1);
  }
  
  public static TypeaheadShowcase readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building TypeaheadShowcase");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building TypeaheadShowcase");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building TypeaheadShowcase");
    }
    if (((ByteBuffer)localObject1).getInt() != -1622352112)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building TypeaheadShowcase");
    }
    localObject2 = null;
    Object localObject3 = null;
    paramString = null;
    MiniCompanyBuilder localMiniCompanyBuilder = null;
    boolean bool3;
    boolean bool4;
    label247:
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool3 = true;
      if (bool3) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label398;
      }
      bool4 = true;
      if (bool4)
      {
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject1));
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label404;
      }
      bool1 = true;
      label282:
      bool2 = bool1;
      if (bool1)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = localMiniCompanyBuilder;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localMiniCompanyBuilder = MiniCompanyBuilder.INSTANCE;
          paramString = MiniCompanyBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label410;
          }
          bool1 = true;
        }
        label335:
        bool2 = bool1;
        if (i == 1)
        {
          paramString = MiniCompanyBuilder.INSTANCE;
          paramString = MiniCompanyBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label416;
          }
        }
      }
    }
    label398:
    label404:
    label410:
    label416:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool3) {
        break label422;
      }
      throw new IOException("Failed to find required field: id when reading com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadShowcase from fission.");
      bool3 = false;
      break;
      bool4 = false;
      break label247;
      bool1 = false;
      break label282;
      bool1 = false;
      break label335;
    }
    label422:
    if (!bool4) {
      throw new IOException("Failed to find required field: backendUrn when reading com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadShowcase from fission.");
    }
    if (!bool2) {
      throw new IOException("Failed to find required field: company when reading com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadShowcase from fission.");
    }
    return new TypeaheadShowcase((String)localObject2, (Urn)localObject3, paramString, bool3, bool4, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadShowcaseBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */