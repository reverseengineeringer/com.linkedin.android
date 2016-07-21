package com.linkedin.android.pegasus.gen.voyager.messaging;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ParticipantReceiptsBuilder
  implements FissileDataModelBuilder<ParticipantReceipts>, DataTemplateBuilder<ParticipantReceipts>
{
  public static final ParticipantReceiptsBuilder INSTANCE = new ParticipantReceiptsBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("fromParticipant");
    JSON_KEY_STORE.put("seenReceipt");
  }
  
  public static ParticipantReceipts build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("fromParticipant", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = MessagingProfileEntityBuilder.INSTANCE;
        localObject2 = MessagingProfileEntityBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("seenReceipt", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = SeenReceiptBuilder.INSTANCE;
        localObject1 = SeenReceiptBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: fromParticipant when building com.linkedin.android.pegasus.gen.voyager.messaging.ParticipantReceipts");
    }
    return new ParticipantReceipts((MessagingProfileEntity)localObject2, (SeenReceipt)localObject1, bool2, bool1);
  }
  
  public static ParticipantReceipts readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building ParticipantReceipts");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building ParticipantReceipts");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building ParticipantReceipts");
    }
    if (((ByteBuffer)localObject2).getInt() != 757997545)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building ParticipantReceipts");
    }
    paramString = null;
    MessagingProfileEntityBuilder localMessagingProfileEntityBuilder = null;
    localObject1 = null;
    SeenReceiptBuilder localSeenReceiptBuilder = null;
    boolean bool2;
    boolean bool1;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = localMessagingProfileEntityBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localMessagingProfileEntityBuilder = MessagingProfileEntityBuilder.INSTANCE;
          paramString = MessagingProfileEntityBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label439;
          }
          bool1 = true;
        }
        label277:
        if (i == 1)
        {
          paramString = MessagingProfileEntityBuilder.INSTANCE;
          paramString = MessagingProfileEntityBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label445;
          }
          bool1 = true;
        }
      }
      label303:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label451;
      }
      bool2 = true;
      label315:
      bool3 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        localObject1 = localSeenReceiptBuilder;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localSeenReceiptBuilder = SeenReceiptBuilder.INSTANCE;
          localObject1 = SeenReceiptBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label457;
          }
          bool2 = true;
        }
        label373:
        bool3 = bool2;
        if (i == 1)
        {
          localObject1 = SeenReceiptBuilder.INSTANCE;
          localObject1 = SeenReceiptBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label463;
          }
        }
      }
    }
    label439:
    label445:
    label451:
    label457:
    label463:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (bool1) {
        break label469;
      }
      throw new IOException("Failed to find required field: fromParticipant when reading com.linkedin.android.pegasus.gen.voyager.messaging.ParticipantReceipts from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label277;
      bool1 = false;
      break label303;
      bool2 = false;
      break label315;
      bool2 = false;
      break label373;
    }
    label469:
    return new ParticipantReceipts(paramString, (SeenReceipt)localObject1, bool1, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.ParticipantReceiptsBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */