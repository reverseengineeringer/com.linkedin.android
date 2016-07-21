package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Date;
import com.linkedin.android.pegasus.gen.common.DateBuilder;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class PublicationBuilder
  implements FissileDataModelBuilder<Publication>, DataTemplateBuilder<Publication>
{
  public static final PublicationBuilder INSTANCE = new PublicationBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("name");
    JSON_KEY_STORE.put("publisher");
    JSON_KEY_STORE.put("date");
    JSON_KEY_STORE.put("url");
    JSON_KEY_STORE.put("description");
    JSON_KEY_STORE.put("authors");
  }
  
  public static Publication build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject2 = null;
    String str4 = null;
    String str3 = null;
    Object localObject1 = null;
    String str2 = null;
    String str1 = null;
    ArrayList localArrayList = null;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("entityUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = UrnCoercer.INSTANCE;
        localObject2 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("name", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str4 = paramDataReader.readString();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("publisher", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("date", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = DateBuilder.INSTANCE;
        localObject1 = DateBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("url", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("description", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("authors", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            ContributorBuilder localContributorBuilder = ContributorBuilder.INSTANCE;
            localArrayList.add(ContributorBuilder.build(paramDataReader));
          }
        }
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: name when building com.linkedin.android.pegasus.gen.voyager.identity.profile.Publication");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: authors when building com.linkedin.android.pegasus.gen.voyager.identity.profile.Publication");
    }
    return new Publication((Urn)localObject2, str4, str3, (Date)localObject1, str2, str1, localArrayList, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static Publication readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Publication");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building Publication");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building Publication");
    }
    if (((ByteBuffer)localObject2).getInt() != -1389658647)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building Publication");
    }
    Object localObject3 = null;
    String str1 = null;
    String str2 = null;
    paramString = null;
    Object localObject4 = null;
    String str3 = null;
    String str4 = null;
    localObject1 = null;
    boolean bool3;
    boolean bool4;
    label267:
    boolean bool5;
    label294:
    boolean bool2;
    label321:
    boolean bool1;
    label378:
    label404:
    label416:
    boolean bool6;
    label443:
    boolean bool7;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool3 = true;
      if (bool3)
      {
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject2));
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label613;
      }
      bool4 = true;
      if (bool4) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label619;
      }
      bool5 = true;
      if (bool5) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label625;
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
          localObject4 = DateBuilder.INSTANCE;
          paramString = DateBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label631;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = DateBuilder.INSTANCE;
          paramString = DateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label637;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label643;
      }
      bool2 = true;
      if (bool2) {
        str3 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label649;
      }
      bool6 = true;
      if (bool6) {
        str4 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label655;
      }
      bool7 = true;
      label470:
      if (!bool7) {
        break label673;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2);
      localObject4 = new ArrayList();
      label494:
      localObject1 = localObject4;
      if (j <= 0) {
        break label673;
      }
      localObject1 = null;
      i = 1;
      int k = ((ByteBuffer)localObject2).get();
      if (k == 0)
      {
        localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
        ContributorBuilder localContributorBuilder = ContributorBuilder.INSTANCE;
        localObject1 = ContributorBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
        if (localObject1 == null) {
          break label661;
        }
        i = 1;
      }
      label554:
      if (k == 1)
      {
        localObject1 = ContributorBuilder.INSTANCE;
        localObject1 = ContributorBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
        if (localObject1 == null) {
          break label667;
        }
      }
    }
    label613:
    label619:
    label625:
    label631:
    label637:
    label643:
    label649:
    label655:
    label661:
    label667:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject4).add(localObject1);
      }
      j -= 1;
      break label494;
      bool3 = false;
      break;
      bool4 = false;
      break label267;
      bool5 = false;
      break label294;
      bool2 = false;
      break label321;
      bool1 = false;
      break label378;
      bool1 = false;
      break label404;
      bool2 = false;
      break label416;
      bool6 = false;
      break label443;
      bool7 = false;
      break label470;
      i = 0;
      break label554;
    }
    label673:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
    }
    if (!bool4) {
      throw new IOException("Failed to find required field: name when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.Publication from fission.");
    }
    if (!bool7) {
      throw new IOException("Failed to find required field: authors when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.Publication from fission.");
    }
    return new Publication((Urn)localObject3, str1, str2, paramString, str3, str4, (List)localObject1, bool3, bool4, bool5, bool1, bool2, bool6, bool7);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.PublicationBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */