package com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.MediaProxyImageBuilder;
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

public final class RichTextBuilder
  implements FissileDataModelBuilder<RichText>, DataTemplateBuilder<RichText>
{
  public static final RichTextBuilder INSTANCE = new RichTextBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("embedHtml");
    JSON_KEY_STORE.put("url");
    JSON_KEY_STORE.put("width");
    JSON_KEY_STORE.put("height");
    JSON_KEY_STORE.put("externalUrl");
    JSON_KEY_STORE.put("externalId");
    JSON_KEY_STORE.put("previewImages");
  }
  
  public static RichText build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str3 = null;
    String str2 = null;
    int j = 0;
    int i = 0;
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
      if (paramDataReader.shouldReadField$11ca93e7("embedHtml", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("url", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("width", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        j = paramDataReader.readInt();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("height", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("externalUrl", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("externalId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = UrnCoercer.INSTANCE;
        localObject2 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("previewImages", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            MediaProxyImageBuilder localMediaProxyImageBuilder = MediaProxyImageBuilder.INSTANCE;
            ((List)localObject1).add(MediaProxyImageBuilder.build(paramDataReader));
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
      localObject1 = Collections.emptyList();
    }
    return new RichText(str3, str2, j, i, str1, (Urn)localObject2, (List)localObject1, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static RichText readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building RichText");
    }
    Object localObject2 = paramByteBuffer;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building RichText");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building RichText");
    }
    if (((ByteBuffer)localObject1).getInt() != -1477196542)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building RichText");
    }
    localObject2 = null;
    String str1 = null;
    int j = 0;
    int k = 0;
    String str2 = null;
    Object localObject3 = null;
    paramString = null;
    boolean bool1;
    boolean bool2;
    label256:
    boolean bool3;
    label283:
    boolean bool4;
    label307:
    boolean bool5;
    label331:
    boolean bool6;
    label358:
    boolean bool7;
    label393:
    int m;
    ArrayList localArrayList;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label526;
      }
      bool2 = true;
      if (bool2) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label532;
      }
      bool3 = true;
      if (bool3) {
        j = ((ByteBuffer)localObject1).getInt();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label538;
      }
      bool4 = true;
      if (bool4) {
        k = ((ByteBuffer)localObject1).getInt();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label544;
      }
      bool5 = true;
      if (bool5) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label550;
      }
      bool6 = true;
      if (bool6)
      {
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject1));
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label556;
      }
      bool7 = true;
      if (!bool7) {
        break label574;
      }
      m = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localArrayList = new ArrayList();
      label417:
      paramString = localArrayList;
      if (m <= 0) {
        break label574;
      }
      paramString = null;
      i = 1;
      int n = ((ByteBuffer)localObject1).get();
      if (n == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
        MediaProxyImageBuilder localMediaProxyImageBuilder = MediaProxyImageBuilder.INSTANCE;
        paramString = MediaProxyImageBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label562;
        }
        i = 1;
      }
      label471:
      if (n == 1)
      {
        paramString = MediaProxyImageBuilder.INSTANCE;
        paramString = MediaProxyImageBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
        if (paramString == null) {
          break label568;
        }
      }
    }
    label526:
    label532:
    label538:
    label544:
    label550:
    label556:
    label562:
    label568:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      m -= 1;
      break label417;
      bool1 = false;
      break;
      bool2 = false;
      break label256;
      bool3 = false;
      break label283;
      bool4 = false;
      break label307;
      bool5 = false;
      break label331;
      bool6 = false;
      break label358;
      bool7 = false;
      break label393;
      i = 0;
      break label471;
    }
    label574:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
    }
    if (!bool7) {
      paramString = Collections.emptyList();
    }
    return new RichText((String)localObject2, str1, j, k, str2, (Urn)localObject3, paramString, bool1, bool2, bool3, bool4, bool5, bool6, bool7);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.RichTextBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */