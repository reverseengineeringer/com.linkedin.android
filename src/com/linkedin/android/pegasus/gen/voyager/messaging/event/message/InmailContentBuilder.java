package com.linkedin.android.pegasus.gen.voyager.messaging.event.message;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntityInsights;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntityInsightsBuilder;
import com.linkedin.android.pegasus.gen.voyager.messaging.shared.ContactInfo;
import com.linkedin.android.pegasus.gen.voyager.messaging.shared.ContactInfoBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class InmailContentBuilder
  implements FissileDataModelBuilder<InmailContent>, DataTemplateBuilder<InmailContent>
{
  public static final InmailContentBuilder INSTANCE = new InmailContentBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("inmailType");
    JSON_KEY_STORE.put("status");
    JSON_KEY_STORE.put("actionType");
    JSON_KEY_STORE.put("requestContactInfo");
    JSON_KEY_STORE.put("senderContactInfo");
    JSON_KEY_STORE.put("recruiterInmail");
    JSON_KEY_STORE.put("senderCompanyInsights");
  }
  
  public static InmailContent build(DataReader paramDataReader)
    throws DataReaderException
  {
    InmailType localInmailType = null;
    InmailStatus localInmailStatus = null;
    InmailActionType localInmailActionType = null;
    boolean bool2 = false;
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1 = null;
    boolean bool9 = false;
    boolean bool8 = false;
    boolean bool6 = false;
    boolean bool7 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool3 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("inmailType", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localInmailType = (InmailType)paramDataReader.readEnum(InmailType.Builder.INSTANCE);
        bool9 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("status", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localInmailStatus = (InmailStatus)paramDataReader.readEnum(InmailStatus.Builder.INSTANCE);
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("actionType", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localInmailActionType = (InmailActionType)paramDataReader.readEnum(InmailActionType.Builder.INSTANCE);
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("requestContactInfo", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool2 = paramDataReader.readBoolean();
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("senderContactInfo", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = ContactInfoBuilder.INSTANCE;
        localObject2 = ContactInfoBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("recruiterInmail", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool1 = paramDataReader.readBoolean();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("senderCompanyInsights", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = EntityInsightsBuilder.INSTANCE;
        localObject1 = EntityInsightsBuilder.build(paramDataReader);
        bool3 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool8) {
      localInmailStatus = InmailStatus.PENDING;
    }
    if (!bool6) {
      localInmailActionType = InmailActionType.RECEIVED;
    }
    if (!bool7) {
      bool2 = false;
    }
    if (!bool5) {
      bool1 = false;
    }
    if (!bool9) {
      throw new DataReaderException("Failed to find required field: inmailType when building com.linkedin.android.pegasus.gen.voyager.messaging.event.message.InmailContent");
    }
    return new InmailContent(localInmailType, localInmailStatus, localInmailActionType, bool2, (ContactInfo)localObject2, bool1, (EntityInsights)localObject1, bool9, bool8, bool6, bool7, bool4, bool5, bool3);
  }
  
  public static InmailContent readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building InmailContent");
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
          localObject4 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building InmailContent");
    }
    Object localObject4 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building InmailContent");
    }
    if (((ByteBuffer)localObject4).getInt() != -1567132740)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject4);
      throw new IOException("UID mismatch. Can't read cached data when building InmailContent");
    }
    InmailType localInmailType = null;
    paramString = null;
    localObject1 = null;
    boolean bool1 = false;
    Object localObject2 = null;
    ContactInfoBuilder localContactInfoBuilder = null;
    boolean bool4 = false;
    Object localObject3 = null;
    EntityInsightsBuilder localEntityInsightsBuilder = null;
    boolean bool6;
    boolean bool7;
    label265:
    boolean bool8;
    label294:
    boolean bool9;
    label324:
    label341:
    boolean bool3;
    label353:
    boolean bool2;
    label415:
    label444:
    boolean bool10;
    label456:
    label477:
    boolean bool5;
    if (((ByteBuffer)localObject4).get() == 1)
    {
      bool6 = true;
      if (bool6) {
        localInmailType = InmailType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject4));
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label648;
      }
      bool7 = true;
      if (bool7) {
        paramString = InmailStatus.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject4));
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label654;
      }
      bool8 = true;
      if (bool8) {
        localObject1 = InmailActionType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject4));
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label660;
      }
      bool9 = true;
      if (bool9)
      {
        if (((ByteBuffer)localObject4).get() != 1) {
          break label666;
        }
        bool1 = true;
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label672;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject4).get();
        localObject2 = localContactInfoBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localContactInfoBuilder = ContactInfoBuilder.INSTANCE;
          localObject2 = ContactInfoBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label678;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject2 = ContactInfoBuilder.INSTANCE;
          localObject2 = ContactInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label684;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label690;
      }
      bool10 = true;
      bool3 = bool4;
      if (bool10)
      {
        if (((ByteBuffer)localObject4).get() != 1) {
          break label696;
        }
        bool3 = true;
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label702;
      }
      bool5 = true;
      label489:
      bool4 = bool5;
      if (bool5)
      {
        i = ((ByteBuffer)localObject4).get();
        localObject3 = localEntityInsightsBuilder;
        bool4 = bool5;
        if (i == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localEntityInsightsBuilder = EntityInsightsBuilder.INSTANCE;
          localObject3 = EntityInsightsBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label708;
          }
          bool4 = true;
        }
        label551:
        if (i == 1)
        {
          localObject3 = EntityInsightsBuilder.INSTANCE;
          localObject3 = EntityInsightsBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label714;
          }
        }
      }
    }
    label648:
    label654:
    label660:
    label666:
    label672:
    label678:
    label684:
    label690:
    label696:
    label702:
    label708:
    label714:
    for (bool4 = true;; bool4 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject4);
      }
      if (!bool7) {
        paramString = InmailStatus.PENDING;
      }
      if (!bool8) {
        localObject1 = InmailActionType.RECEIVED;
      }
      if (!bool9) {
        bool1 = false;
      }
      if (!bool10) {
        bool3 = false;
      }
      if (bool6) {
        break label720;
      }
      throw new IOException("Failed to find required field: inmailType when reading com.linkedin.android.pegasus.gen.voyager.messaging.event.message.InmailContent from fission.");
      bool6 = false;
      break;
      bool7 = false;
      break label265;
      bool8 = false;
      break label294;
      bool9 = false;
      break label324;
      bool1 = false;
      break label341;
      bool3 = false;
      break label353;
      bool2 = false;
      break label415;
      bool2 = false;
      break label444;
      bool10 = false;
      break label456;
      bool3 = false;
      break label477;
      bool5 = false;
      break label489;
      bool4 = false;
      break label551;
    }
    label720:
    return new InmailContent(localInmailType, paramString, (InmailActionType)localObject1, bool1, (ContactInfo)localObject2, bool3, (EntityInsights)localObject3, bool6, bool7, bool8, bool9, bool2, bool10, bool4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.event.message.InmailContentBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */