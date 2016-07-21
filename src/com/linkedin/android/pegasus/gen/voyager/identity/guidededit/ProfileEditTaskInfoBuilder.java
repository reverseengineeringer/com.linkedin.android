package com.linkedin.android.pegasus.gen.voyager.identity.guidededit;

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
import java.util.ArrayList;
import java.util.List;

public final class ProfileEditTaskInfoBuilder
  implements FissileDataModelBuilder<ProfileEditTaskInfo>, DataTemplateBuilder<ProfileEditTaskInfo>
{
  public static final ProfileEditTaskInfoBuilder INSTANCE = new ProfileEditTaskInfoBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("updateEntity");
    JSON_KEY_STORE.put("updateEntityUrn");
    JSON_KEY_STORE.put("formFields");
  }
  
  public static ProfileEditTaskInfo build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject2 = null;
    Object localObject1 = null;
    ArrayList localArrayList = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("updateEntity", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = UrnCoercer.INSTANCE;
        localObject2 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("updateEntityUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = UrnCoercer.INSTANCE;
        localObject1 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("formFields", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            FormFieldBuilder localFormFieldBuilder = FormFieldBuilder.INSTANCE;
            localArrayList.add(FormFieldBuilder.build(paramDataReader));
          }
        }
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: formFields when building com.linkedin.android.pegasus.gen.voyager.identity.guidededit.ProfileEditTaskInfo");
    }
    return new ProfileEditTaskInfo((Urn)localObject2, (Urn)localObject1, localArrayList, bool3, bool2, bool1);
  }
  
  public static ProfileEditTaskInfo readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building ProfileEditTaskInfo");
    }
    Object localObject2 = paramByteBuffer;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building ProfileEditTaskInfo");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building ProfileEditTaskInfo");
    }
    if (((ByteBuffer)localObject1).getInt() != 427964704)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building ProfileEditTaskInfo");
    }
    localObject2 = null;
    Object localObject3 = null;
    paramString = null;
    boolean bool1;
    boolean bool2;
    label252:
    boolean bool3;
    label287:
    ArrayList localArrayList;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool1 = true;
      if (bool1)
      {
        localObject2 = UrnCoercer.INSTANCE;
        localObject2 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject1));
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label420;
      }
      bool2 = true;
      if (bool2)
      {
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject1));
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label426;
      }
      bool3 = true;
      if (!bool3) {
        break label444;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localArrayList = new ArrayList();
      label311:
      paramString = localArrayList;
      if (j <= 0) {
        break label444;
      }
      paramString = null;
      i = 1;
      int k = ((ByteBuffer)localObject1).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
        FormFieldBuilder localFormFieldBuilder = FormFieldBuilder.INSTANCE;
        paramString = FormFieldBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label432;
        }
        i = 1;
      }
      label365:
      if (k == 1)
      {
        paramString = FormFieldBuilder.INSTANCE;
        paramString = FormFieldBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
        if (paramString == null) {
          break label438;
        }
      }
    }
    label420:
    label426:
    label432:
    label438:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      j -= 1;
      break label311;
      bool1 = false;
      break;
      bool2 = false;
      break label252;
      bool3 = false;
      break label287;
      i = 0;
      break label365;
    }
    label444:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: formFields when reading com.linkedin.android.pegasus.gen.voyager.identity.guidededit.ProfileEditTaskInfo from fission.");
    }
    return new ProfileEditTaskInfo((Urn)localObject2, (Urn)localObject3, paramString, bool1, bool2, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.guidededit.ProfileEditTaskInfoBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */