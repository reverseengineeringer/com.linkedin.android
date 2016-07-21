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

public final class SpInmailContentBuilder
  implements FissileDataModelBuilder<SpInmailContent>, DataTemplateBuilder<SpInmailContent>
{
  public static final SpInmailContentBuilder INSTANCE = new SpInmailContentBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("spInmailType");
    JSON_KEY_STORE.put("status");
    JSON_KEY_STORE.put("body");
    JSON_KEY_STORE.put("bodyTracking");
    JSON_KEY_STORE.put("openTracking");
    JSON_KEY_STORE.put("legalText");
    JSON_KEY_STORE.put("subContent");
  }
  
  public static SpInmailContent build(DataReader paramDataReader)
    throws DataReaderException
  {
    SpInmailType localSpInmailType = null;
    SpInmailStatus localSpInmailStatus = null;
    String str3 = null;
    String str2 = null;
    String str1 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("spInmailType", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localSpInmailType = (SpInmailType)paramDataReader.readEnum(SpInmailType.Builder.INSTANCE);
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("status", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localSpInmailStatus = (SpInmailStatus)paramDataReader.readEnum(SpInmailStatus.Builder.INSTANCE);
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("body", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("bodyTracking", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("openTracking", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("legalText", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = SpInmailLegalTextBuilder.INSTANCE;
        localObject2 = SpInmailLegalTextBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("subContent", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = SubContentBuilder.INSTANCE;
        localObject1 = SubContentBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool7) {
      throw new DataReaderException("Failed to find required field: spInmailType when building com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailContent");
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: status when building com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailContent");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: subContent when building com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailContent");
    }
    return new SpInmailContent(localSpInmailType, localSpInmailStatus, str3, str2, str1, (SpInmailLegalText)localObject2, (SpInmailContent.SubContent)localObject1, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static SpInmailContent readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SpInmailContent");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SpInmailContent");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building SpInmailContent");
    }
    if (((ByteBuffer)localObject2).getInt() != 1315362582)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building SpInmailContent");
    }
    SpInmailType localSpInmailType = null;
    SpInmailStatus localSpInmailStatus = null;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    paramString = null;
    SpInmailLegalTextBuilder localSpInmailLegalTextBuilder = null;
    localObject1 = null;
    SubContentBuilder localSubContentBuilder = null;
    boolean bool4;
    boolean bool5;
    label265:
    boolean bool6;
    label295:
    boolean bool7;
    label322:
    boolean bool8;
    label349:
    boolean bool2;
    label376:
    boolean bool1;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool4 = true;
      if (bool4) {
        localSpInmailType = SpInmailType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2));
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label595;
      }
      bool5 = true;
      if (bool5) {
        localSpInmailStatus = SpInmailStatus.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2));
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label601;
      }
      bool6 = true;
      if (bool6) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label607;
      }
      bool7 = true;
      if (bool7) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label613;
      }
      bool8 = true;
      if (bool8) {
        str3 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label619;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = localSpInmailLegalTextBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localSpInmailLegalTextBuilder = SpInmailLegalTextBuilder.INSTANCE;
          paramString = SpInmailLegalTextBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label625;
          }
          bool1 = true;
        }
        label433:
        if (i == 1)
        {
          paramString = SpInmailLegalTextBuilder.INSTANCE;
          paramString = SpInmailLegalTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label631;
          }
          bool1 = true;
        }
      }
      label459:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label637;
      }
      bool2 = true;
      label471:
      bool3 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        localObject1 = localSubContentBuilder;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localSubContentBuilder = SubContentBuilder.INSTANCE;
          localObject1 = SubContentBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label643;
          }
          bool2 = true;
        }
        label529:
        bool3 = bool2;
        if (i == 1)
        {
          localObject1 = SubContentBuilder.INSTANCE;
          localObject1 = SubContentBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label649;
          }
        }
      }
    }
    label595:
    label601:
    label607:
    label613:
    label619:
    label625:
    label631:
    label637:
    label643:
    label649:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (bool4) {
        break label655;
      }
      throw new IOException("Failed to find required field: spInmailType when reading com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailContent from fission.");
      bool4 = false;
      break;
      bool5 = false;
      break label265;
      bool6 = false;
      break label295;
      bool7 = false;
      break label322;
      bool8 = false;
      break label349;
      bool2 = false;
      break label376;
      bool1 = false;
      break label433;
      bool1 = false;
      break label459;
      bool2 = false;
      break label471;
      bool2 = false;
      break label529;
    }
    label655:
    if (!bool5) {
      throw new IOException("Failed to find required field: status when reading com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailContent from fission.");
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: subContent when reading com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailContent from fission.");
    }
    return new SpInmailContent(localSpInmailType, localSpInmailStatus, str1, str2, str3, paramString, (SpInmailContent.SubContent)localObject1, bool4, bool5, bool6, bool7, bool8, bool1, bool3);
  }
  
  public static final class SubContentBuilder
    implements FissileDataModelBuilder<SpInmailContent.SubContent>, DataTemplateBuilder<SpInmailContent.SubContent>
  {
    public static final SubContentBuilder INSTANCE = new SubContentBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.voyager.messaging.event.message.spinmail.SpInmailStandardSubContent");
      JSON_KEY_STORE.put("com.linkedin.voyager.messaging.event.message.spinmail.SpInmailLeadGenSubContent");
    }
    
    public static SpInmailContent.SubContent build(DataReader paramDataReader)
      throws DataReaderException
    {
      Object localObject1 = null;
      Object localObject2 = null;
      boolean bool1 = false;
      boolean bool2 = false;
      paramDataReader.startRecord();
      while (paramDataReader.hasMoreFields$255f299()) {
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.messaging.event.message.spinmail.SpInmailStandardSubContent", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = SpInmailStandardSubContentBuilder.INSTANCE;
          localObject1 = SpInmailStandardSubContentBuilder.build(paramDataReader);
          bool1 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.messaging.event.message.spinmail.SpInmailLeadGenSubContent", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = SpInmailLeadGenSubContentBuilder.INSTANCE;
          localObject2 = SpInmailLeadGenSubContentBuilder.build(paramDataReader);
          bool2 = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
      int i = 0;
      if (bool1) {
        i = 1;
      }
      if ((bool2) && (i != 0)) {
        throw new DataReaderException("Found more than 1 member when building .SubContent");
      }
      return new SpInmailContent.SubContent((SpInmailStandardSubContent)localObject1, (SpInmailLeadGenSubContent)localObject2, bool1, bool2);
    }
    
    public static SpInmailContent.SubContent readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building SpInmailContent.SubContent");
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
        throw new IOException("Invalid header prefix. Can't read cached data when building SpInmailContent.SubContent");
      }
      Object localObject2 = localObject1;
      if (((ByteBuffer)localObject1).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("Invalid header prefix. Can't read cached data when building SpInmailContent.SubContent");
      }
      if (((ByteBuffer)localObject2).getInt() != -1762311460)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
        throw new IOException("UID mismatch. Can't read cached data when building SpInmailContent.SubContent");
      }
      paramString = null;
      SpInmailStandardSubContentBuilder localSpInmailStandardSubContentBuilder = null;
      localObject1 = null;
      SpInmailLeadGenSubContentBuilder localSpInmailLeadGenSubContentBuilder = null;
      boolean bool2;
      boolean bool1;
      if (((ByteBuffer)localObject2).get() == 1)
      {
        bool2 = true;
        bool1 = bool2;
        if (bool2)
        {
          i = ((ByteBuffer)localObject2).get();
          bool1 = bool2;
          paramString = localSpInmailStandardSubContentBuilder;
          if (i == 0)
          {
            paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
            localSpInmailStandardSubContentBuilder = SpInmailStandardSubContentBuilder.INSTANCE;
            paramString = SpInmailStandardSubContentBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label455;
            }
            bool1 = true;
          }
          label277:
          if (i == 1)
          {
            paramString = SpInmailStandardSubContentBuilder.INSTANCE;
            paramString = SpInmailStandardSubContentBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
            if (paramString == null) {
              break label461;
            }
            bool1 = true;
          }
        }
        label303:
        if (((ByteBuffer)localObject2).get() != 1) {
          break label467;
        }
        bool2 = true;
        label315:
        bool3 = bool2;
        if (bool2)
        {
          i = ((ByteBuffer)localObject2).get();
          localObject1 = localSpInmailLeadGenSubContentBuilder;
          if (i == 0)
          {
            localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
            localSpInmailLeadGenSubContentBuilder = SpInmailLeadGenSubContentBuilder.INSTANCE;
            localObject1 = SpInmailLeadGenSubContentBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
            if (localObject1 == null) {
              break label473;
            }
            bool2 = true;
          }
          label373:
          bool3 = bool2;
          if (i == 1)
          {
            localObject1 = SpInmailLeadGenSubContentBuilder.INSTANCE;
            localObject1 = SpInmailLeadGenSubContentBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
            if (localObject1 == null) {
              break label479;
            }
          }
        }
      }
      label455:
      label461:
      label467:
      label473:
      label479:
      for (boolean bool3 = true;; bool3 = false)
      {
        if (paramByteBuffer == null) {
          paramFissionAdapter.recycle((ByteBuffer)localObject2);
        }
        i = 0;
        if (bool1) {
          i = 1;
        }
        if ((!bool3) || (i == 0)) {
          break label485;
        }
        throw new IOException("Found more than 1 member when reading .SubContent from fission.");
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
      label485:
      return new SpInmailContent.SubContent(paramString, (SpInmailLeadGenSubContent)localObject1, bool1, bool3);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.event.message.spinmail.SpInmailContentBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */