package com.linkedin.android.pegasus.gen.voyager.messaging.create.message;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.messaging.shared.ContactInfo;
import com.linkedin.android.pegasus.gen.voyager.messaging.shared.ContactInfoBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class InmailContentCreateBuilder
  implements FissileDataModelBuilder<InmailContentCreate>, DataTemplateBuilder<InmailContentCreate>
{
  public static final InmailContentCreateBuilder INSTANCE = new InmailContentCreateBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("contactInfo");
    JSON_KEY_STORE.put("action");
  }
  
  public static InmailContentCreate build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject = null;
    InmailAction localInmailAction = null;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("contactInfo", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = ContactInfoBuilder.INSTANCE;
        localObject = ContactInfoBuilder.build(paramDataReader);
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("action", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localInmailAction = (InmailAction)paramDataReader.readEnum(InmailAction.Builder.INSTANCE);
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    return new InmailContentCreate((ContactInfo)localObject, localInmailAction, bool1, bool2);
  }
  
  public static InmailContentCreate readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building InmailContentCreate");
    }
    ByteBuffer localByteBuffer = paramByteBuffer;
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
          localObject = paramString;
          if (i != 0) {
            break;
          }
          localObject = paramFissionAdapter.readString(paramString);
          paramFissionAdapter.recycle(paramString);
          localObject = paramFissionAdapter.readFromCache((String)localObject, paramFissionTransaction);
          if (localObject == null) {
            return null;
          }
          j = ((ByteBuffer)localObject).get();
          paramString = (String)localObject;
          i = j;
        } while (j == 1);
        paramString = (String)localObject;
        i = j;
      } while (j == 0);
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("Invalid header prefix. Can't read cached data when building InmailContentCreate");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building InmailContentCreate");
    }
    if (((ByteBuffer)localObject).getInt() != 695026699)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building InmailContentCreate");
    }
    paramString = null;
    ContactInfoBuilder localContactInfoBuilder = null;
    localByteBuffer = null;
    boolean bool1;
    if (((ByteBuffer)localObject).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject).get();
        paramString = localContactInfoBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject);
          localContactInfoBuilder = ContactInfoBuilder.INSTANCE;
          paramString = ContactInfoBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label364;
          }
          bool1 = true;
        }
        label274:
        if (i == 1)
        {
          paramString = ContactInfoBuilder.INSTANCE;
          paramString = ContactInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject, null, paramFissionTransaction);
          if (paramString == null) {
            break label370;
          }
          bool1 = true;
        }
      }
      label300:
      if (((ByteBuffer)localObject).get() != 1) {
        break label376;
      }
    }
    label364:
    label370:
    label376:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramFissionTransaction = localByteBuffer;
      if (bool2) {
        paramFissionTransaction = InmailAction.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject));
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      return new InmailContentCreate(paramString, paramFissionTransaction, bool1, bool2);
      bool2 = false;
      break;
      bool1 = false;
      break label274;
      bool1 = false;
      break label300;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.create.message.InmailContentCreateBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */