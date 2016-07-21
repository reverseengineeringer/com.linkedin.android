package com.linkedin.android.pegasus.gen.voyager.typeahead;

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

public final class TypeaheadFieldOfStudyBuilder
  implements FissileDataModelBuilder<TypeaheadFieldOfStudy>, DataTemplateBuilder<TypeaheadFieldOfStudy>
{
  public static final TypeaheadFieldOfStudyBuilder INSTANCE = new TypeaheadFieldOfStudyBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("id");
    JSON_KEY_STORE.put("backendUrn");
    JSON_KEY_STORE.put("fieldOfStudyUrn");
  }
  
  public static TypeaheadFieldOfStudy build(DataReader paramDataReader)
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
      else if (paramDataReader.shouldReadField$11ca93e7("fieldOfStudyUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = UrnCoercer.INSTANCE;
        localObject1 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: id when building com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadFieldOfStudy");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: backendUrn when building com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadFieldOfStudy");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: fieldOfStudyUrn when building com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadFieldOfStudy");
    }
    return new TypeaheadFieldOfStudy(str, (Urn)localObject2, (Urn)localObject1, bool3, bool2, bool1);
  }
  
  public static TypeaheadFieldOfStudy readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    boolean bool3 = true;
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building TypeaheadFieldOfStudy");
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
            break label170;
          }
          localObject1 = paramFissionAdapter.readString(paramString);
          paramFissionAdapter.recycle(paramString);
          localObject1 = paramFissionAdapter.readFromCache((String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break;
          }
          j = ((ByteBuffer)localObject1).get();
          paramString = (String)localObject1;
          i = j;
        } while (j == 1);
        paramString = (String)localObject1;
        i = j;
      } while (j == 0);
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building TypeaheadFieldOfStudy");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building TypeaheadFieldOfStudy");
    }
    label170:
    if (((ByteBuffer)localObject1).getInt() != -1229314091)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building TypeaheadFieldOfStudy");
    }
    paramString = null;
    paramFissionTransaction = null;
    localObject2 = null;
    boolean bool1;
    boolean bool2;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label329;
      }
      bool2 = true;
      label243:
      if (bool2)
      {
        paramFissionTransaction = UrnCoercer.INSTANCE;
        paramFissionTransaction = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject1));
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label335;
      }
    }
    for (;;)
    {
      if (bool3)
      {
        localObject2 = UrnCoercer.INSTANCE;
        localObject2 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject1));
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool1) {
        break label341;
      }
      throw new IOException("Failed to find required field: id when reading com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadFieldOfStudy from fission.");
      bool1 = false;
      break;
      label329:
      bool2 = false;
      break label243;
      label335:
      bool3 = false;
    }
    label341:
    if (!bool2) {
      throw new IOException("Failed to find required field: backendUrn when reading com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadFieldOfStudy from fission.");
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: fieldOfStudyUrn when reading com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadFieldOfStudy from fission.");
    }
    return new TypeaheadFieldOfStudy(paramString, paramFissionTransaction, (Urn)localObject2, bool1, bool2, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadFieldOfStudyBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */