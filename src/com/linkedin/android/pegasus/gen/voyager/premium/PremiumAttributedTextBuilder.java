package com.linkedin.android.pegasus.gen.voyager.premium;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributeBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class PremiumAttributedTextBuilder
  implements FissileDataModelBuilder<PremiumAttributedText>, DataTemplateBuilder<PremiumAttributedText>
{
  public static final PremiumAttributedTextBuilder INSTANCE = new PremiumAttributedTextBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("text");
    JSON_KEY_STORE.put("attributes");
    JSON_KEY_STORE.put("appearances");
  }
  
  public static PremiumAttributedText build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str = null;
    Object localObject1 = null;
    ArrayList localArrayList = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("text", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool3 = true;
      }
      else
      {
        Object localObject2;
        if (paramDataReader.shouldReadField$11ca93e7("attributes", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              localObject2 = AttributeBuilder.INSTANCE;
              ((List)localObject1).add(AttributeBuilder.build(paramDataReader));
            }
          }
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("appearances", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localArrayList = new ArrayList();
          if (paramDataReader.isStartOfArray()) {
            while (paramDataReader.hasMoreArrayElements$255f299())
            {
              localObject2 = PremiumTextAppearanceBuilder.INSTANCE;
              localArrayList.add(PremiumTextAppearanceBuilder.build(paramDataReader));
            }
          }
          bool1 = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
    }
    if (!bool2) {
      localObject1 = Collections.emptyList();
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: text when building com.linkedin.android.pegasus.gen.voyager.premium.PremiumAttributedText");
    }
    return new PremiumAttributedText(str, (List)localObject1, localArrayList, bool3, bool2, bool1);
  }
  
  public static PremiumAttributedText readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building PremiumAttributedText");
    }
    Object localObject1 = paramByteBuffer;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building PremiumAttributedText");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building PremiumAttributedText");
    }
    if (((ByteBuffer)localObject2).getInt() != -437008408)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building PremiumAttributedText");
    }
    String str = null;
    paramString = null;
    localObject1 = null;
    boolean bool1;
    boolean bool2;
    label244:
    ArrayList localArrayList;
    label268:
    int k;
    Object localObject3;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label377;
      }
      bool2 = true;
      if (!bool2) {
        break label395;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2);
      localArrayList = new ArrayList();
      paramString = localArrayList;
      if (j <= 0) {
        break label395;
      }
      paramString = null;
      i = 1;
      k = ((ByteBuffer)localObject2).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
        localObject3 = AttributeBuilder.INSTANCE;
        paramString = AttributeBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label383;
        }
        i = 1;
      }
      label322:
      if (k == 1)
      {
        paramString = AttributeBuilder.INSTANCE;
        paramString = AttributeBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
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
    boolean bool3;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool3 = true;
      if (!bool3) {
        break label562;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2);
      localArrayList = new ArrayList();
      label431:
      localObject1 = localArrayList;
      if (j <= 0) {
        break label562;
      }
      localObject1 = null;
      i = 1;
      k = ((ByteBuffer)localObject2).get();
      if (k == 0)
      {
        localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
        localObject3 = PremiumTextAppearanceBuilder.INSTANCE;
        localObject1 = PremiumTextAppearanceBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
        if (localObject1 == null) {
          break label550;
        }
        i = 1;
      }
      label491:
      if (k == 1)
      {
        localObject1 = PremiumTextAppearanceBuilder.INSTANCE;
        localObject1 = PremiumTextAppearanceBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
        if (localObject1 == null) {
          break label556;
        }
      }
    }
    label550:
    label556:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(localObject1);
      }
      j -= 1;
      break label431;
      bool3 = false;
      break;
      i = 0;
      break label491;
    }
    label562:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
    }
    if (!bool2) {
      paramString = Collections.emptyList();
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: text when reading com.linkedin.android.pegasus.gen.voyager.premium.PremiumAttributedText from fission.");
    }
    return new PremiumAttributedText(str, paramString, (List)localObject1, bool1, bool2, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.premium.PremiumAttributedTextBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */