package com.linkedin.android.pegasus.gen.voyager.identity.guidededit;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.common.Industry;
import com.linkedin.android.pegasus.gen.voyager.common.IndustryBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class FormFieldBuilder
  implements FissileDataModelBuilder<FormField>, DataTemplateBuilder<FormField>
{
  public static final FormFieldBuilder INSTANCE = new FormFieldBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("fieldName");
    JSON_KEY_STORE.put("prefillValues");
  }
  
  public static FormField build(DataReader paramDataReader)
    throws DataReaderException
  {
    FieldNames localFieldNames = null;
    ArrayList localArrayList = null;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("fieldName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localFieldNames = (FieldNames)paramDataReader.readEnum(FieldNames.Builder.INSTANCE);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("prefillValues", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            PrefillValuesBuilder localPrefillValuesBuilder = PrefillValuesBuilder.INSTANCE;
            localArrayList.add(PrefillValuesBuilder.build(paramDataReader));
          }
        }
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: fieldName when building com.linkedin.android.pegasus.gen.voyager.identity.guidededit.FormField");
    }
    return new FormField(localFieldNames, localArrayList, bool2, bool1);
  }
  
  public static FormField readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building FormField");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building FormField");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building FormField");
    }
    if (((ByteBuffer)localObject1).getInt() != 1590366252)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building FormField");
    }
    localObject2 = null;
    paramString = null;
    boolean bool1;
    boolean bool2;
    label244:
    ArrayList localArrayList;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        localObject2 = FieldNames.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1));
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label377;
      }
      bool2 = true;
      if (!bool2) {
        break label395;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localArrayList = new ArrayList();
      label268:
      paramString = localArrayList;
      if (j <= 0) {
        break label395;
      }
      paramString = null;
      i = 1;
      int k = ((ByteBuffer)localObject1).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
        PrefillValuesBuilder localPrefillValuesBuilder = PrefillValuesBuilder.INSTANCE;
        paramString = PrefillValuesBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label383;
        }
        i = 1;
      }
      label322:
      if (k == 1)
      {
        paramString = PrefillValuesBuilder.INSTANCE;
        paramString = PrefillValuesBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
        if (paramString == null) {
          break label389;
        }
      }
    }
    label377:
    label383:
    label389:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      j -= 1;
      break label268;
      bool1 = false;
      break;
      bool2 = false;
      break label244;
      i = 0;
      break label322;
    }
    label395:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: fieldName when reading com.linkedin.android.pegasus.gen.voyager.identity.guidededit.FormField from fission.");
    }
    return new FormField((FieldNames)localObject2, paramString, bool1, bool2);
  }
  
  public static final class PrefillValuesBuilder
    implements FissileDataModelBuilder<FormField.PrefillValues>, DataTemplateBuilder<FormField.PrefillValues>
  {
    public static final PrefillValuesBuilder INSTANCE = new PrefillValuesBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.voyager.common.Industry");
    }
    
    public static FormField.PrefillValues build(DataReader paramDataReader)
      throws DataReaderException
    {
      Object localObject = null;
      boolean bool = false;
      paramDataReader.startRecord();
      while (paramDataReader.hasMoreFields$255f299()) {
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.common.Industry", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject = IndustryBuilder.INSTANCE;
          localObject = IndustryBuilder.build(paramDataReader);
          bool = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
      return new FormField.PrefillValues((Industry)localObject, bool);
    }
    
    public static FormField.PrefillValues readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building FormField.PrefillValues");
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
        throw new IOException("Invalid header prefix. Can't read cached data when building FormField.PrefillValues");
      }
      Object localObject1 = localObject2;
      if (((ByteBuffer)localObject2).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
        throw new IOException("Invalid header prefix. Can't read cached data when building FormField.PrefillValues");
      }
      if (((ByteBuffer)localObject1).getInt() != 244442555)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("UID mismatch. Can't read cached data when building FormField.PrefillValues");
      }
      paramString = null;
      localObject2 = null;
      boolean bool1;
      if (((ByteBuffer)localObject1).get() == 1)
      {
        bool1 = true;
        bool2 = bool1;
        if (bool1)
        {
          i = ((ByteBuffer)localObject1).get();
          paramString = (String)localObject2;
          if (i == 0)
          {
            paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
            localObject2 = IndustryBuilder.INSTANCE;
            paramString = IndustryBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label326;
            }
            bool1 = true;
          }
          label267:
          bool2 = bool1;
          if (i == 1)
          {
            paramString = IndustryBuilder.INSTANCE;
            paramString = IndustryBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
            if (paramString == null) {
              break label332;
            }
          }
        }
      }
      label326:
      label332:
      for (boolean bool2 = true;; bool2 = false)
      {
        if (paramByteBuffer == null) {
          paramFissionAdapter.recycle((ByteBuffer)localObject1);
        }
        return new FormField.PrefillValues(paramString, bool2);
        bool1 = false;
        break;
        bool1 = false;
        break label267;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.guidededit.FormFieldBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */