package com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
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

public final class LinkBuilder
  implements FissileDataModelBuilder<Link>, DataTemplateBuilder<Link>
{
  public static final LinkBuilder INSTANCE = new LinkBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("url");
    JSON_KEY_STORE.put("html");
    JSON_KEY_STORE.put("width");
    JSON_KEY_STORE.put("height");
    JSON_KEY_STORE.put("previewImages");
  }
  
  public static Link build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str2 = null;
    String str1 = null;
    int j = 0;
    int i = 0;
    Object localObject = null;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("url", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("html", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("width", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        j = paramDataReader.readInt();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("height", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("previewImages", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            MediaProxyImageBuilder localMediaProxyImageBuilder = MediaProxyImageBuilder.INSTANCE;
            ((List)localObject).add(MediaProxyImageBuilder.build(paramDataReader));
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
      localObject = Collections.emptyList();
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: url when building com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.Link");
    }
    return new Link(str2, str1, j, i, (List)localObject, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static Link readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Link");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building Link");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building Link");
    }
    if (((ByteBuffer)localObject1).getInt() != 983498920)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building Link");
    }
    localObject2 = null;
    String str = null;
    int j = 0;
    int k = 0;
    paramString = null;
    boolean bool1;
    boolean bool2;
    label250:
    boolean bool3;
    label277:
    boolean bool4;
    label301:
    boolean bool5;
    label325:
    int m;
    ArrayList localArrayList;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label458;
      }
      bool2 = true;
      if (bool2) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label464;
      }
      bool3 = true;
      if (bool3) {
        j = ((ByteBuffer)localObject1).getInt();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label470;
      }
      bool4 = true;
      if (bool4) {
        k = ((ByteBuffer)localObject1).getInt();
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label476;
      }
      bool5 = true;
      if (!bool5) {
        break label494;
      }
      m = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localArrayList = new ArrayList();
      label349:
      paramString = localArrayList;
      if (m <= 0) {
        break label494;
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
          break label482;
        }
        i = 1;
      }
      label403:
      if (n == 1)
      {
        paramString = MediaProxyImageBuilder.INSTANCE;
        paramString = MediaProxyImageBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
        if (paramString == null) {
          break label488;
        }
      }
    }
    label458:
    label464:
    label470:
    label476:
    label482:
    label488:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      m -= 1;
      break label349;
      bool1 = false;
      break;
      bool2 = false;
      break label250;
      bool3 = false;
      break label277;
      bool4 = false;
      break label301;
      bool5 = false;
      break label325;
      i = 0;
      break label403;
    }
    label494:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
    }
    if (!bool5) {
      paramString = Collections.emptyList();
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: url when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.Link from fission.");
    }
    return new Link((String)localObject2, str, j, k, paramString, bool1, bool2, bool3, bool4, bool5);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.LinkBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */