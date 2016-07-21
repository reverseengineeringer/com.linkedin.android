package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedTextBuilder;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.common.ImageBuilder;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedTextBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ShareDocumentBuilder
  implements FissileDataModelBuilder<ShareDocument>, DataTemplateBuilder<ShareDocument>
{
  public static final ShareDocumentBuilder INSTANCE = new ShareDocumentBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("text");
    JSON_KEY_STORE.put("attributedText");
    JSON_KEY_STORE.put("image");
    JSON_KEY_STORE.put("type");
    JSON_KEY_STORE.put("fileName");
    JSON_KEY_STORE.put("url");
  }
  
  public static ShareDocument build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    FileType localFileType = null;
    String str2 = null;
    String str1 = null;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("text", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = AnnotatedTextBuilder.INSTANCE;
        localObject3 = AnnotatedTextBuilder.build(paramDataReader);
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("attributedText", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = AttributedTextBuilder.INSTANCE;
        localObject2 = AttributedTextBuilder.build(paramDataReader);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("image", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = ImageBuilder.INSTANCE;
        localObject1 = ImageBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("type", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localFileType = (FileType)paramDataReader.readEnum(FileType.Builder.INSTANCE);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("fileName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("url", JSON_KEY_STORE))
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
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: image when building com.linkedin.android.pegasus.gen.voyager.feed.ShareDocument");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: type when building com.linkedin.android.pegasus.gen.voyager.feed.ShareDocument");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: fileName when building com.linkedin.android.pegasus.gen.voyager.feed.ShareDocument");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: url when building com.linkedin.android.pegasus.gen.voyager.feed.ShareDocument");
    }
    return new ShareDocument((AnnotatedText)localObject3, (AttributedText)localObject2, (Image)localObject1, localFileType, str2, str1, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static ShareDocument readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building ShareDocument");
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
          localObject3 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building ShareDocument");
    }
    Object localObject3 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building ShareDocument");
    }
    if (((ByteBuffer)localObject3).getInt() != 200738313)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject3);
      throw new IOException("UID mismatch. Can't read cached data when building ShareDocument");
    }
    paramString = null;
    AnnotatedTextBuilder localAnnotatedTextBuilder = null;
    localObject1 = null;
    AttributedTextBuilder localAttributedTextBuilder = null;
    Object localObject2 = null;
    ImageBuilder localImageBuilder = null;
    Object localObject4 = null;
    String str1 = null;
    String str2 = null;
    boolean bool2;
    boolean bool1;
    label292:
    label318:
    boolean bool3;
    label330:
    label392:
    label421:
    boolean bool4;
    label433:
    label495:
    label524:
    label536:
    boolean bool5;
    if (((ByteBuffer)localObject3).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject3).get();
        paramString = localAnnotatedTextBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localAnnotatedTextBuilder = AnnotatedTextBuilder.INSTANCE;
          paramString = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label643;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = AnnotatedTextBuilder.INSTANCE;
          paramString = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (paramString == null) {
            break label649;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label655;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject3).get();
        localObject1 = localAttributedTextBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localAttributedTextBuilder = AttributedTextBuilder.INSTANCE;
          localObject1 = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label661;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject1 = AttributedTextBuilder.INSTANCE;
          localObject1 = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label667;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label673;
      }
      bool4 = true;
      bool3 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject3).get();
        localObject2 = localImageBuilder;
        bool3 = bool4;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localImageBuilder = ImageBuilder.INSTANCE;
          localObject2 = ImageBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label679;
          }
          bool3 = true;
        }
        if (i == 1)
        {
          localObject2 = ImageBuilder.INSTANCE;
          localObject2 = ImageBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label685;
          }
          bool3 = true;
        }
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label691;
      }
      bool4 = true;
      paramFissionTransaction = (FissionTransaction)localObject4;
      if (bool4) {
        paramFissionTransaction = FileType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject3));
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label697;
      }
      bool5 = true;
      label568:
      if (bool5) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject3);
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label703;
      }
    }
    label643:
    label649:
    label655:
    label661:
    label667:
    label673:
    label679:
    label685:
    label691:
    label697:
    label703:
    for (boolean bool6 = true;; bool6 = false)
    {
      if (bool6) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject3);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject3);
      }
      if (bool3) {
        break label709;
      }
      throw new IOException("Failed to find required field: image when reading com.linkedin.android.pegasus.gen.voyager.feed.ShareDocument from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label292;
      bool1 = false;
      break label318;
      bool3 = false;
      break label330;
      bool2 = false;
      break label392;
      bool2 = false;
      break label421;
      bool4 = false;
      break label433;
      bool3 = false;
      break label495;
      bool3 = false;
      break label524;
      bool4 = false;
      break label536;
      bool5 = false;
      break label568;
    }
    label709:
    if (!bool4) {
      throw new IOException("Failed to find required field: type when reading com.linkedin.android.pegasus.gen.voyager.feed.ShareDocument from fission.");
    }
    if (!bool5) {
      throw new IOException("Failed to find required field: fileName when reading com.linkedin.android.pegasus.gen.voyager.feed.ShareDocument from fission.");
    }
    if (!bool6) {
      throw new IOException("Failed to find required field: url when reading com.linkedin.android.pegasus.gen.voyager.feed.ShareDocument from fission.");
    }
    return new ShareDocument(paramString, (AttributedText)localObject1, (Image)localObject2, paramFissionTransaction, str1, str2, bool1, bool2, bool3, bool4, bool5, bool6);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.ShareDocumentBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */