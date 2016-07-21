package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.search.SearchQuery;
import com.linkedin.android.pegasus.gen.voyager.search.SearchQueryBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ObfuscatedProfileViewerBuilder
  implements FissileDataModelBuilder<ObfuscatedProfileViewer>, DataTemplateBuilder<ObfuscatedProfileViewer>
{
  public static final ObfuscatedProfileViewerBuilder INSTANCE = new ObfuscatedProfileViewerBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("obfuscationString");
    JSON_KEY_STORE.put("searchQuery");
    JSON_KEY_STORE.put("occupation");
  }
  
  public static ObfuscatedProfileViewer build(DataReader paramDataReader)
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
      if (paramDataReader.shouldReadField$11ca93e7("obfuscationString", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("searchQuery", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = SearchQueryBuilder.INSTANCE;
        localObject2 = SearchQueryBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("occupation", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = OccupationBuilder.INSTANCE;
        localObject1 = OccupationBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: obfuscationString when building com.linkedin.android.pegasus.gen.voyager.identity.me.ObfuscatedProfileViewer");
    }
    return new ObfuscatedProfileViewer(str, (SearchQuery)localObject2, (Occupation)localObject1, bool3, bool2, bool1);
  }
  
  public static ObfuscatedProfileViewer readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building ObfuscatedProfileViewer");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building ObfuscatedProfileViewer");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building ObfuscatedProfileViewer");
    }
    if (((ByteBuffer)localObject2).getInt() != 682102249)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building ObfuscatedProfileViewer");
    }
    String str = null;
    paramString = null;
    SearchQueryBuilder localSearchQueryBuilder = null;
    localObject1 = null;
    OccupationBuilder localOccupationBuilder = null;
    boolean bool4;
    boolean bool2;
    label250:
    boolean bool1;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool4 = true;
      if (bool4) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label469;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = localSearchQueryBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localSearchQueryBuilder = SearchQueryBuilder.INSTANCE;
          paramString = SearchQueryBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label475;
          }
          bool1 = true;
        }
        label307:
        if (i == 1)
        {
          paramString = SearchQueryBuilder.INSTANCE;
          paramString = SearchQueryBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label481;
          }
          bool1 = true;
        }
      }
      label333:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label487;
      }
      bool2 = true;
      label345:
      bool3 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        localObject1 = localOccupationBuilder;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localOccupationBuilder = OccupationBuilder.INSTANCE;
          localObject1 = OccupationBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label493;
          }
          bool2 = true;
        }
        label403:
        bool3 = bool2;
        if (i == 1)
        {
          localObject1 = OccupationBuilder.INSTANCE;
          localObject1 = OccupationBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label499;
          }
        }
      }
    }
    label469:
    label475:
    label481:
    label487:
    label493:
    label499:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (bool4) {
        break label505;
      }
      throw new IOException("Failed to find required field: obfuscationString when reading com.linkedin.android.pegasus.gen.voyager.identity.me.ObfuscatedProfileViewer from fission.");
      bool4 = false;
      break;
      bool2 = false;
      break label250;
      bool1 = false;
      break label307;
      bool1 = false;
      break label333;
      bool2 = false;
      break label345;
      bool2 = false;
      break label403;
    }
    label505:
    return new ObfuscatedProfileViewer(str, paramString, (Occupation)localObject1, bool4, bool1, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.ObfuscatedProfileViewerBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */