package com.linkedin.android.pegasus.gen.voyager.messaging.create;

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

public final class StickerCreateBuilder
  implements FissileDataModelBuilder<StickerCreate>, DataTemplateBuilder<StickerCreate>
{
  public static final StickerCreateBuilder INSTANCE = new StickerCreateBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("stickerUrn");
    JSON_KEY_STORE.put("customContent");
  }
  
  public static StickerCreate build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("stickerUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = UrnCoercer.INSTANCE;
        localObject1 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("customContent", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = CustomContentBuilder.INSTANCE;
        localObject2 = CustomContentBuilder.build(paramDataReader);
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: stickerUrn when building com.linkedin.android.pegasus.gen.voyager.messaging.create.StickerCreate");
    }
    return new StickerCreate((Urn)localObject1, (StickerCreate.CustomContent)localObject2, bool1, bool2);
  }
  
  public static StickerCreate readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building StickerCreate");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building StickerCreate");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building StickerCreate");
    }
    if (((ByteBuffer)localObject1).getInt() != 1916907643)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building StickerCreate");
    }
    localObject2 = null;
    paramString = null;
    CustomContentBuilder localCustomContentBuilder = null;
    boolean bool3;
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool3 = true;
      if (bool3)
      {
        localObject2 = UrnCoercer.INSTANCE;
        localObject2 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject1));
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label368;
      }
      bool1 = true;
      label252:
      bool2 = bool1;
      if (bool1)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = localCustomContentBuilder;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localCustomContentBuilder = CustomContentBuilder.INSTANCE;
          paramString = CustomContentBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label374;
          }
          bool1 = true;
        }
        label305:
        bool2 = bool1;
        if (i == 1)
        {
          paramString = CustomContentBuilder.INSTANCE;
          paramString = CustomContentBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label380;
          }
        }
      }
    }
    label368:
    label374:
    label380:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool3) {
        break label386;
      }
      throw new IOException("Failed to find required field: stickerUrn when reading com.linkedin.android.pegasus.gen.voyager.messaging.create.StickerCreate from fission.");
      bool3 = false;
      break;
      bool1 = false;
      break label252;
      bool1 = false;
      break label305;
    }
    label386:
    return new StickerCreate((Urn)localObject2, paramString, bool3, bool2);
  }
  
  public static final class CustomContentBuilder
    implements FissileDataModelBuilder<StickerCreate.CustomContent>, DataTemplateBuilder<StickerCreate.CustomContent>
  {
    public static final CustomContentBuilder INSTANCE = new CustomContentBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("string");
    }
    
    public static StickerCreate.CustomContent build(DataReader paramDataReader)
      throws DataReaderException
    {
      Object localObject = null;
      boolean bool = false;
      paramDataReader.startRecord();
      while (paramDataReader.hasMoreFields$255f299()) {
        if (paramDataReader.shouldReadField$11ca93e7("string", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject = UrnCoercer.INSTANCE;
          localObject = UrnCoercer.coerceToCustomType(paramDataReader.readString());
          bool = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
      return new StickerCreate.CustomContent((Urn)localObject, bool);
    }
    
    public static StickerCreate.CustomContent readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      boolean bool = true;
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building StickerCreate.CustomContent");
      }
      ByteBuffer localByteBuffer = paramByteBuffer;
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
            localObject = paramString;
            if (i != 0) {
              break label170;
            }
            localObject = paramFissionAdapter.readString(paramString);
            paramFissionAdapter.recycle(paramString);
            localObject = paramFissionAdapter.readFromCache((String)localObject, paramFissionTransaction);
            if (localObject == null) {
              break;
            }
            j = ((ByteBuffer)localObject).get();
            paramString = (String)localObject;
            i = j;
          } while (j == 1);
          paramString = (String)localObject;
          i = j;
        } while (j == 0);
        paramFissionAdapter.recycle((ByteBuffer)localObject);
        throw new IOException("Invalid header prefix. Can't read cached data when building StickerCreate.CustomContent");
      }
      Object localObject = localByteBuffer;
      if (localByteBuffer.get() != 1)
      {
        paramFissionAdapter.recycle(localByteBuffer);
        throw new IOException("Invalid header prefix. Can't read cached data when building StickerCreate.CustomContent");
      }
      label170:
      if (((ByteBuffer)localObject).getInt() != 13180648)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
        throw new IOException("UID mismatch. Can't read cached data when building StickerCreate.CustomContent");
      }
      paramString = null;
      if (((ByteBuffer)localObject).get() == 1) {}
      for (;;)
      {
        if (bool)
        {
          paramString = UrnCoercer.INSTANCE;
          paramString = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject));
        }
        if (paramByteBuffer == null) {
          paramFissionAdapter.recycle((ByteBuffer)localObject);
        }
        return new StickerCreate.CustomContent(paramString, bool);
        bool = false;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.create.StickerCreateBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */