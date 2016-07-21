package com.linkedin.android.pegasus.gen.voyager.identity.ubiquitousedit;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.pymk.PeopleYouMayKnow;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.pymk.PeopleYouMayKnowBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class UbiquitousEditPymkItemBuilder
  implements FissileDataModelBuilder<UbiquitousEditPymkItem>, DataTemplateBuilder<UbiquitousEditPymkItem>
{
  public static final UbiquitousEditPymkItemBuilder INSTANCE = new UbiquitousEditPymkItemBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("pymk");
    JSON_KEY_STORE.put("boosted");
  }
  
  public static UbiquitousEditPymkItem build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject = null;
    boolean bool2 = false;
    boolean bool1 = false;
    boolean bool3 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("pymk", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = PeopleYouMayKnowBuilder.INSTANCE;
        localObject = PeopleYouMayKnowBuilder.build(paramDataReader);
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("boosted", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool2 = paramDataReader.readBoolean();
        bool3 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: pymk when building com.linkedin.android.pegasus.gen.voyager.identity.ubiquitousedit.UbiquitousEditPymkItem");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: boosted when building com.linkedin.android.pegasus.gen.voyager.identity.ubiquitousedit.UbiquitousEditPymkItem");
    }
    return new UbiquitousEditPymkItem((PeopleYouMayKnow)localObject, bool2, bool1, bool3);
  }
  
  public static UbiquitousEditPymkItem readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building UbiquitousEditPymkItem");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building UbiquitousEditPymkItem");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building UbiquitousEditPymkItem");
    }
    if (((ByteBuffer)localObject1).getInt() != -1598845678)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building UbiquitousEditPymkItem");
    }
    paramString = null;
    localObject2 = null;
    boolean bool4 = false;
    boolean bool1;
    label274:
    label300:
    boolean bool3;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject1).get();
        bool1 = bool2;
        paramString = (String)localObject2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localObject2 = PeopleYouMayKnowBuilder.INSTANCE;
          paramString = PeopleYouMayKnowBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label366;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = PeopleYouMayKnowBuilder.INSTANCE;
          paramString = PeopleYouMayKnowBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label372;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label378;
      }
      bool3 = true;
      label312:
      bool2 = bool4;
      if (bool3) {
        if (((ByteBuffer)localObject1).get() != 1) {
          break label384;
        }
      }
    }
    label366:
    label372:
    label378:
    label384:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool1) {
        break label390;
      }
      throw new IOException("Failed to find required field: pymk when reading com.linkedin.android.pegasus.gen.voyager.identity.ubiquitousedit.UbiquitousEditPymkItem from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label274;
      bool1 = false;
      break label300;
      bool3 = false;
      break label312;
    }
    label390:
    if (!bool3) {
      throw new IOException("Failed to find required field: boosted when reading com.linkedin.android.pegasus.gen.voyager.identity.ubiquitousedit.UbiquitousEditPymkItem from fission.");
    }
    return new UbiquitousEditPymkItem(paramString, bool2, bool1, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.ubiquitousedit.UbiquitousEditPymkItemBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */