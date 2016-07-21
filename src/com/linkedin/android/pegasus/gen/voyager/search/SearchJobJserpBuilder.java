package com.linkedin.android.pegasus.gen.voyager.search;

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

public final class SearchJobJserpBuilder
  implements FissileDataModelBuilder<SearchJobJserp>, DataTemplateBuilder<SearchJobJserp>
{
  public static final SearchJobJserpBuilder INSTANCE = new SearchJobJserpBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("jobPosting");
    JSON_KEY_STORE.put("descriptionSnippet");
    JSON_KEY_STORE.put("explanation");
    JSON_KEY_STORE.put("score");
  }
  
  public static SearchJobJserp build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject = null;
    String str2 = null;
    String str1 = null;
    float f = 0.0F;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("jobPosting", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = UrnCoercer.INSTANCE;
        localObject = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("descriptionSnippet", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("explanation", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("score", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        f = paramDataReader.readFloat();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: jobPosting when building com.linkedin.android.pegasus.gen.voyager.search.SearchJobJserp");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: descriptionSnippet when building com.linkedin.android.pegasus.gen.voyager.search.SearchJobJserp");
    }
    return new SearchJobJserp((Urn)localObject, str2, str1, f, bool4, bool3, bool2, bool1);
  }
  
  public static SearchJobJserp readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SearchJobJserp");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SearchJobJserp");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building SearchJobJserp");
    }
    if (((ByteBuffer)localObject1).getInt() != 1802708830)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building SearchJobJserp");
    }
    paramString = null;
    paramFissionTransaction = null;
    localObject2 = null;
    float f = 0.0F;
    boolean bool1;
    boolean bool2;
    label252:
    boolean bool3;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool1 = true;
      if (bool1)
      {
        paramString = UrnCoercer.INSTANCE;
        paramString = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject1));
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label350;
      }
      bool2 = true;
      if (bool2) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label356;
      }
      bool3 = true;
      label278:
      if (bool3) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label362;
      }
    }
    label350:
    label356:
    label362:
    for (boolean bool4 = true;; bool4 = false)
    {
      if (bool4) {
        f = ((ByteBuffer)localObject1).getFloat();
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool1) {
        break label368;
      }
      throw new IOException("Failed to find required field: jobPosting when reading com.linkedin.android.pegasus.gen.voyager.search.SearchJobJserp from fission.");
      bool1 = false;
      break;
      bool2 = false;
      break label252;
      bool3 = false;
      break label278;
    }
    label368:
    if (!bool2) {
      throw new IOException("Failed to find required field: descriptionSnippet when reading com.linkedin.android.pegasus.gen.voyager.search.SearchJobJserp from fission.");
    }
    return new SearchJobJserp(paramString, paramFissionTransaction, (String)localObject2, f, bool1, bool2, bool3, bool4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchJobJserpBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */