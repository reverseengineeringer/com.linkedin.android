package com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.actions;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
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

public final class MessageBuilder
  implements FissileDataModelBuilder<Message>, DataTemplateBuilder<Message>
{
  public static final MessageBuilder INSTANCE = new MessageBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("recipients");
    JSON_KEY_STORE.put("suggestedMessage");
  }
  
  public static Message build(DataReader paramDataReader)
    throws DataReaderException
  {
    ArrayList localArrayList = null;
    String str = null;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("recipients", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            Object localObject = UrnCoercer.INSTANCE;
            localObject = UrnCoercer.coerceToCustomType(paramDataReader.readString());
            if (localObject != null) {
              localArrayList.add(localObject);
            }
          }
        }
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("suggestedMessage", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: recipients when building com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.actions.Message");
    }
    return new Message(localArrayList, str, bool2, bool1);
  }
  
  public static Message readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    boolean bool2 = true;
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Message");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building Message");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building Message");
    }
    label170:
    if (((ByteBuffer)localObject1).getInt() != -1416978342)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building Message");
    }
    paramString = null;
    paramFissionTransaction = null;
    if (((ByteBuffer)localObject1).get() == 1) {}
    for (boolean bool1 = true; bool1; bool1 = false)
    {
      i = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localObject2 = new ArrayList();
      for (;;)
      {
        paramString = (String)localObject2;
        if (i <= 0) {
          break;
        }
        paramString = UrnCoercer.INSTANCE;
        ((List)localObject2).add(UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject1)));
        i -= 1;
      }
    }
    if (((ByteBuffer)localObject1).get() == 1) {}
    for (;;)
    {
      if (bool2) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool1) {
        break;
      }
      throw new IOException("Failed to find required field: recipients when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.actions.Message from fission.");
      bool2 = false;
    }
    return new Message(paramString, paramFissionTransaction, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.actions.MessageBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */