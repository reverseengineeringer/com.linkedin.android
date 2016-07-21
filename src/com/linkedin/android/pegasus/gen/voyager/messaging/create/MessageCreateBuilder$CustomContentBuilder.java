package com.linkedin.android.pegasus.gen.voyager.messaging.create;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.messaging.create.message.InmailContentCreate;
import com.linkedin.android.pegasus.gen.voyager.messaging.create.message.InmailContentCreateBuilder;
import com.linkedin.android.pegasus.gen.voyager.messaging.create.message.ShareCreate;
import com.linkedin.android.pegasus.gen.voyager.messaging.create.message.ShareCreateBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class MessageCreateBuilder$CustomContentBuilder
  implements FissileDataModelBuilder<MessageCreate.CustomContent>, DataTemplateBuilder<MessageCreate.CustomContent>
{
  public static final CustomContentBuilder INSTANCE = new CustomContentBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("com.linkedin.voyager.messaging.create.message.InmailContentCreate");
    JSON_KEY_STORE.put("com.linkedin.voyager.messaging.create.message.ShareCreate");
    JSON_KEY_STORE.put("string");
  }
  
  public static MessageCreate.CustomContent build(DataReader paramDataReader)
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
      if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.messaging.create.message.InmailContentCreate", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = InmailContentCreateBuilder.INSTANCE;
        localObject3 = InmailContentCreateBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.messaging.create.message.ShareCreate", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = ShareCreateBuilder.INSTANCE;
        localObject2 = ShareCreateBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("string", JSON_KEY_STORE))
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
    int i = 0;
    if (bool3) {
      i = 1;
    }
    int j = i;
    if (bool2)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .CustomContent");
      }
      j = 1;
    }
    if ((bool1) && (j != 0)) {
      throw new DataReaderException("Found more than 1 member when building .CustomContent");
    }
    return new MessageCreate.CustomContent((InmailContentCreate)localObject3, (ShareCreate)localObject2, (Urn)localObject1, bool3, bool2, bool1);
  }
  
  public static MessageCreate.CustomContent readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building MessageCreate.CustomContent");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building MessageCreate.CustomContent");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building MessageCreate.CustomContent");
    }
    if (((ByteBuffer)localObject2).getInt() != -535643681)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building MessageCreate.CustomContent");
    }
    paramString = null;
    InmailContentCreateBuilder localInmailContentCreateBuilder = null;
    localObject1 = null;
    ShareCreateBuilder localShareCreateBuilder = null;
    Object localObject3 = null;
    boolean bool2;
    boolean bool1;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = localInmailContentCreateBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localInmailContentCreateBuilder = InmailContentCreateBuilder.INSTANCE;
          paramString = InmailContentCreateBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label498;
          }
          bool1 = true;
        }
        label280:
        if (i == 1)
        {
          paramString = InmailContentCreateBuilder.INSTANCE;
          paramString = InmailContentCreateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label504;
          }
          bool1 = true;
        }
      }
      label306:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label510;
      }
      bool3 = true;
      label318:
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject2).get();
        localObject1 = localShareCreateBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localShareCreateBuilder = ShareCreateBuilder.INSTANCE;
          localObject1 = ShareCreateBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label516;
          }
          bool2 = true;
        }
        label380:
        if (i == 1)
        {
          localObject1 = ShareCreateBuilder.INSTANCE;
          localObject1 = ShareCreateBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label522;
          }
          bool2 = true;
        }
      }
      label409:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label528;
      }
    }
    label498:
    label504:
    label510:
    label516:
    label522:
    label528:
    for (boolean bool3 = true;; bool3 = false)
    {
      paramFissionTransaction = (FissionTransaction)localObject3;
      if (bool3)
      {
        paramFissionTransaction = UrnCoercer.INSTANCE;
        paramFissionTransaction = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject2));
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      i = 0;
      if (bool1) {
        i = 1;
      }
      j = i;
      if (!bool2) {
        break label537;
      }
      if (i == 0) {
        break label534;
      }
      throw new IOException("Found more than 1 member when reading .CustomContent from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label280;
      bool1 = false;
      break label306;
      bool3 = false;
      break label318;
      bool2 = false;
      break label380;
      bool2 = false;
      break label409;
    }
    label534:
    int j = 1;
    label537:
    if ((bool3) && (j != 0)) {
      throw new IOException("Found more than 1 member when reading .CustomContent from fission.");
    }
    return new MessageCreate.CustomContent(paramString, (ShareCreate)localObject1, paramFissionTransaction, bool1, bool2, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.create.MessageCreateBuilder.CustomContentBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */