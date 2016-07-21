package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedTextBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class AggregatePropCardBuilder
  implements FissileDataModelBuilder<AggregatePropCard>, DataTemplateBuilder<AggregatePropCard>
{
  public static final AggregatePropCardBuilder INSTANCE = new AggregatePropCardBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("propType");
    JSON_KEY_STORE.put("headline");
    JSON_KEY_STORE.put("someProps");
    JSON_KEY_STORE.put("publishedAt");
    JSON_KEY_STORE.put("read");
  }
  
  public static AggregatePropCard build(DataReader paramDataReader)
    throws DataReaderException
  {
    PropType localPropType = null;
    Object localObject = null;
    ArrayList localArrayList = null;
    long l = 0L;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("propType", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localPropType = (PropType)paramDataReader.readEnum(PropType.Builder.INSTANCE);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("headline", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = AttributedTextBuilder.INSTANCE;
        localObject = AttributedTextBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("someProps", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            PropCardBuilder localPropCardBuilder = PropCardBuilder.INSTANCE;
            localArrayList.add(PropCardBuilder.build(paramDataReader));
          }
        }
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("publishedAt", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("read", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool6 = paramDataReader.readBoolean();
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: propType when building com.linkedin.android.pegasus.gen.voyager.identity.me.AggregatePropCard");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: headline when building com.linkedin.android.pegasus.gen.voyager.identity.me.AggregatePropCard");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: someProps when building com.linkedin.android.pegasus.gen.voyager.identity.me.AggregatePropCard");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: publishedAt when building com.linkedin.android.pegasus.gen.voyager.identity.me.AggregatePropCard");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: read when building com.linkedin.android.pegasus.gen.voyager.identity.me.AggregatePropCard");
    }
    return new AggregatePropCard(localPropType, (AttributedText)localObject, localArrayList, l, bool6, bool5, bool4, bool3, bool1, bool2);
  }
  
  public static AggregatePropCard readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building AggregatePropCard");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building AggregatePropCard");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building AggregatePropCard");
    }
    if (((ByteBuffer)localObject2).getInt() != -695078840)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building AggregatePropCard");
    }
    PropType localPropType = null;
    paramString = null;
    Object localObject3 = null;
    localObject1 = null;
    long l = 0L;
    boolean bool7 = false;
    boolean bool3;
    label256:
    boolean bool1;
    label313:
    label339:
    boolean bool4;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool3 = true;
      if (bool3) {
        localPropType = PropType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2));
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label494;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = (String)localObject3;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localObject3 = AttributedTextBuilder.INSTANCE;
          paramString = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label500;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = AttributedTextBuilder.INSTANCE;
          paramString = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label506;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label512;
      }
      bool4 = true;
      label351:
      if (!bool4) {
        break label530;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2);
      localObject3 = new ArrayList();
      label375:
      localObject1 = localObject3;
      if (j <= 0) {
        break label530;
      }
      localObject1 = null;
      i = 1;
      int k = ((ByteBuffer)localObject2).get();
      if (k == 0)
      {
        localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
        PropCardBuilder localPropCardBuilder = PropCardBuilder.INSTANCE;
        localObject1 = PropCardBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
        if (localObject1 == null) {
          break label518;
        }
        i = 1;
      }
      label435:
      if (k == 1)
      {
        localObject1 = PropCardBuilder.INSTANCE;
        localObject1 = PropCardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
        if (localObject1 == null) {
          break label524;
        }
      }
    }
    label494:
    label500:
    label506:
    label512:
    label518:
    label524:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject3).add(localObject1);
      }
      j -= 1;
      break label375;
      bool3 = false;
      break;
      bool2 = false;
      break label256;
      bool1 = false;
      break label313;
      bool1 = false;
      break label339;
      bool4 = false;
      break label351;
      i = 0;
      break label435;
    }
    label530:
    boolean bool5;
    boolean bool6;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool5 = true;
      if (bool5) {
        l = ((ByteBuffer)localObject2).getLong();
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label620;
      }
      bool6 = true;
      label566:
      bool2 = bool7;
      if (bool6) {
        if (((ByteBuffer)localObject2).get() != 1) {
          break label626;
        }
      }
    }
    label620:
    label626:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (bool3) {
        break label632;
      }
      throw new IOException("Failed to find required field: propType when reading com.linkedin.android.pegasus.gen.voyager.identity.me.AggregatePropCard from fission.");
      bool5 = false;
      break;
      bool6 = false;
      break label566;
    }
    label632:
    if (!bool1) {
      throw new IOException("Failed to find required field: headline when reading com.linkedin.android.pegasus.gen.voyager.identity.me.AggregatePropCard from fission.");
    }
    if (!bool4) {
      throw new IOException("Failed to find required field: someProps when reading com.linkedin.android.pegasus.gen.voyager.identity.me.AggregatePropCard from fission.");
    }
    if (!bool5) {
      throw new IOException("Failed to find required field: publishedAt when reading com.linkedin.android.pegasus.gen.voyager.identity.me.AggregatePropCard from fission.");
    }
    if (!bool6) {
      throw new IOException("Failed to find required field: read when reading com.linkedin.android.pegasus.gen.voyager.identity.me.AggregatePropCard from fission.");
    }
    return new AggregatePropCard(localPropType, paramString, (List)localObject1, l, bool2, bool3, bool1, bool4, bool5, bool6);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.AggregatePropCardBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */