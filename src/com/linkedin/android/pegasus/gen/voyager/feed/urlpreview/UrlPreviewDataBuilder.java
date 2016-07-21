package com.linkedin.android.pegasus.gen.voyager.feed.urlpreview;

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
import java.util.Collections;
import java.util.List;

public final class UrlPreviewDataBuilder
  implements FissileDataModelBuilder<UrlPreviewData>, DataTemplateBuilder<UrlPreviewData>
{
  public static final UrlPreviewDataBuilder INSTANCE = new UrlPreviewDataBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("id");
    JSON_KEY_STORE.put("type");
    JSON_KEY_STORE.put("urn");
    JSON_KEY_STORE.put("previewImages");
    JSON_KEY_STORE.put("url");
    JSON_KEY_STORE.put("resolvedUrl");
    JSON_KEY_STORE.put("title");
    JSON_KEY_STORE.put("description");
    JSON_KEY_STORE.put("source");
  }
  
  public static UrlPreviewData build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str7 = null;
    String str6 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    String str5 = null;
    String str4 = null;
    String str3 = null;
    String str2 = null;
    String str1 = null;
    boolean bool9 = false;
    boolean bool8 = false;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("id", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str7 = paramDataReader.readString();
        bool9 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("type", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str6 = paramDataReader.readString();
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("urn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = UrnCoercer.INSTANCE;
        localObject2 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("previewImages", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            PreviewImageBuilder localPreviewImageBuilder = PreviewImageBuilder.INSTANCE;
            ((List)localObject1).add(PreviewImageBuilder.build(paramDataReader));
          }
        }
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("url", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str5 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("resolvedUrl", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str4 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("title", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("description", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("source", JSON_KEY_STORE))
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
    if (!bool6) {
      localObject1 = Collections.emptyList();
    }
    if (!bool7) {
      throw new DataReaderException("Failed to find required field: urn when building com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.UrlPreviewData");
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: url when building com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.UrlPreviewData");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: resolvedUrl when building com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.UrlPreviewData");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: source when building com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.UrlPreviewData");
    }
    return new UrlPreviewData(str7, str6, (Urn)localObject2, (List)localObject1, str5, str4, str3, str2, str1, bool9, bool8, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static UrlPreviewData readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building UrlPreviewData");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building UrlPreviewData");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building UrlPreviewData");
    }
    if (((ByteBuffer)localObject1).getInt() != -1606867065)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building UrlPreviewData");
    }
    localObject2 = null;
    String str1 = null;
    Object localObject3 = null;
    paramString = null;
    Object localObject4 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    boolean bool1;
    boolean bool2;
    label262:
    boolean bool3;
    label289:
    boolean bool4;
    label324:
    ArrayList localArrayList;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label457;
      }
      bool2 = true;
      if (bool2) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label463;
      }
      bool3 = true;
      if (bool3)
      {
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject1));
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label469;
      }
      bool4 = true;
      if (!bool4) {
        break label487;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1);
      localArrayList = new ArrayList();
      label348:
      paramString = localArrayList;
      if (j <= 0) {
        break label487;
      }
      paramString = null;
      i = 1;
      int k = ((ByteBuffer)localObject1).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
        PreviewImageBuilder localPreviewImageBuilder = PreviewImageBuilder.INSTANCE;
        paramString = PreviewImageBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label475;
        }
        i = 1;
      }
      label402:
      if (k == 1)
      {
        paramString = PreviewImageBuilder.INSTANCE;
        paramString = PreviewImageBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
        if (paramString == null) {
          break label481;
        }
      }
    }
    label457:
    label463:
    label469:
    label475:
    label481:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      j -= 1;
      break label348;
      bool1 = false;
      break;
      bool2 = false;
      break label262;
      bool3 = false;
      break label289;
      bool4 = false;
      break label324;
      i = 0;
      break label402;
    }
    label487:
    boolean bool5;
    boolean bool6;
    label528:
    boolean bool7;
    label555:
    boolean bool8;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool5 = true;
      paramFissionTransaction = (FissionTransaction)localObject4;
      if (bool5) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label666;
      }
      bool6 = true;
      if (bool6) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label672;
      }
      bool7 = true;
      if (bool7) {
        str3 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label678;
      }
      bool8 = true;
      label582:
      if (bool8) {
        str4 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label684;
      }
    }
    label666:
    label672:
    label678:
    label684:
    for (boolean bool9 = true;; bool9 = false)
    {
      if (bool9) {
        str5 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (!bool4) {
        paramString = Collections.emptyList();
      }
      if (bool3) {
        break label690;
      }
      throw new IOException("Failed to find required field: urn when reading com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.UrlPreviewData from fission.");
      bool5 = false;
      break;
      bool6 = false;
      break label528;
      bool7 = false;
      break label555;
      bool8 = false;
      break label582;
    }
    label690:
    if (!bool5) {
      throw new IOException("Failed to find required field: url when reading com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.UrlPreviewData from fission.");
    }
    if (!bool6) {
      throw new IOException("Failed to find required field: resolvedUrl when reading com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.UrlPreviewData from fission.");
    }
    if (!bool9) {
      throw new IOException("Failed to find required field: source when reading com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.UrlPreviewData from fission.");
    }
    return new UrlPreviewData((String)localObject2, str1, (Urn)localObject3, paramString, paramFissionTransaction, str2, str3, str4, str5, bool1, bool2, bool3, bool4, bool5, bool6, bool7, bool8, bool9);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.UrlPreviewDataBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */