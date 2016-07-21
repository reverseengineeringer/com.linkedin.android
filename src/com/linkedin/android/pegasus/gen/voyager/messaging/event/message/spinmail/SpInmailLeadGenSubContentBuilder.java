package com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail;

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

public final class SpInmailLeadGenSubContentBuilder
  implements FissileDataModelBuilder<SpInmailLeadGenSubContent>, DataTemplateBuilder<SpInmailLeadGenSubContent>
{
  public static final SpInmailLeadGenSubContentBuilder INSTANCE = new SpInmailLeadGenSubContentBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("actionText");
    JSON_KEY_STORE.put("afterActionText");
    JSON_KEY_STORE.put("adUnit");
    JSON_KEY_STORE.put("leadGenInterestedTracking");
    JSON_KEY_STORE.put("leadGenSharedEmailTracking");
  }
  
  public static SpInmailLeadGenSubContent build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str4 = null;
    String str3 = null;
    Object localObject = null;
    String str2 = null;
    String str1 = null;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("actionText", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str4 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("afterActionText", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("adUnit", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = SpInmailAdUnitBuilder.INSTANCE;
        localObject = SpInmailAdUnitBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("leadGenInterestedTracking", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("leadGenSharedEmailTracking", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: actionText when building com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailLeadGenSubContent");
    }
    return new SpInmailLeadGenSubContent(str4, str3, (SpInmailAdUnit)localObject, str2, str1, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static SpInmailLeadGenSubContent readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SpInmailLeadGenSubContent");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SpInmailLeadGenSubContent");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building SpInmailLeadGenSubContent");
    }
    if (((ByteBuffer)localObject1).getInt() != 1795947826)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building SpInmailLeadGenSubContent");
    }
    localObject2 = null;
    String str1 = null;
    paramString = null;
    SpInmailAdUnitBuilder localSpInmailAdUnitBuilder = null;
    Object localObject3 = null;
    String str2 = null;
    boolean bool3;
    boolean bool4;
    label253:
    boolean bool2;
    label280:
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool3 = true;
      if (bool3) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label452;
      }
      bool4 = true;
      if (bool4) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label458;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = localSpInmailAdUnitBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localSpInmailAdUnitBuilder = SpInmailAdUnitBuilder.INSTANCE;
          paramString = SpInmailAdUnitBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label464;
          }
          bool1 = true;
        }
        label337:
        if (i == 1)
        {
          paramString = SpInmailAdUnitBuilder.INSTANCE;
          paramString = SpInmailAdUnitBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label470;
          }
          bool1 = true;
        }
      }
      label363:
      if (((ByteBuffer)localObject1).get() != 1) {
        break label476;
      }
      bool2 = true;
      label375:
      paramFissionTransaction = (FissionTransaction)localObject3;
      if (bool2) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label482;
      }
    }
    label452:
    label458:
    label464:
    label470:
    label476:
    label482:
    for (boolean bool5 = true;; bool5 = false)
    {
      if (bool5) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool3) {
        break label488;
      }
      throw new IOException("Failed to find required field: actionText when reading com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailLeadGenSubContent from fission.");
      bool3 = false;
      break;
      bool4 = false;
      break label253;
      bool2 = false;
      break label280;
      bool1 = false;
      break label337;
      bool1 = false;
      break label363;
      bool2 = false;
      break label375;
    }
    label488:
    return new SpInmailLeadGenSubContent((String)localObject2, str1, paramString, paramFissionTransaction, str2, bool3, bool4, bool1, bool2, bool5);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailLeadGenSubContentBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */