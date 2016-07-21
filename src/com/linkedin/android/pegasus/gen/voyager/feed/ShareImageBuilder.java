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

public final class ShareImageBuilder
  implements FissileDataModelBuilder<ShareImage>, DataTemplateBuilder<ShareImage>
{
  public static final ShareImageBuilder INSTANCE = new ShareImageBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("text");
    JSON_KEY_STORE.put("attributedText");
    JSON_KEY_STORE.put("image");
    JSON_KEY_STORE.put("originalImage");
    JSON_KEY_STORE.put("contentType");
    JSON_KEY_STORE.put("fileId");
  }
  
  public static ShareImage build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
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
        localObject4 = AnnotatedTextBuilder.INSTANCE;
        localObject4 = AnnotatedTextBuilder.build(paramDataReader);
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("attributedText", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = AttributedTextBuilder.INSTANCE;
        localObject3 = AttributedTextBuilder.build(paramDataReader);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("image", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = ImageBuilder.INSTANCE;
        localObject2 = ImageBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("originalImage", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = ImageBuilder.INSTANCE;
        localObject1 = ImageBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("contentType", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("fileId", JSON_KEY_STORE))
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
      throw new DataReaderException("Failed to find required field: image when building com.linkedin.android.pegasus.gen.voyager.feed.ShareImage");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: fileId when building com.linkedin.android.pegasus.gen.voyager.feed.ShareImage");
    }
    return new ShareImage((AnnotatedText)localObject4, (AttributedText)localObject3, (Image)localObject2, (Image)localObject1, str2, str1, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static ShareImage readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building ShareImage");
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
          localObject4 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building ShareImage");
    }
    Object localObject4 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building ShareImage");
    }
    if (((ByteBuffer)localObject4).getInt() != 847668003)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject4);
      throw new IOException("UID mismatch. Can't read cached data when building ShareImage");
    }
    paramString = null;
    AnnotatedTextBuilder localAnnotatedTextBuilder = null;
    localObject1 = null;
    AttributedTextBuilder localAttributedTextBuilder = null;
    Object localObject2 = null;
    ImageBuilder localImageBuilder2 = null;
    Object localObject3 = null;
    ImageBuilder localImageBuilder1 = null;
    Object localObject5 = null;
    String str = null;
    boolean bool2;
    boolean bool1;
    label295:
    label321:
    boolean bool3;
    label333:
    label395:
    label424:
    boolean bool4;
    label436:
    label498:
    label527:
    boolean bool5;
    if (((ByteBuffer)localObject4).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject4).get();
        paramString = localAnnotatedTextBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localAnnotatedTextBuilder = AnnotatedTextBuilder.INSTANCE;
          paramString = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label719;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = AnnotatedTextBuilder.INSTANCE;
          paramString = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (paramString == null) {
            break label725;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label731;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject4).get();
        localObject1 = localAttributedTextBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localAttributedTextBuilder = AttributedTextBuilder.INSTANCE;
          localObject1 = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label737;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject1 = AttributedTextBuilder.INSTANCE;
          localObject1 = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label743;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label749;
      }
      bool4 = true;
      bool3 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject4).get();
        localObject2 = localImageBuilder2;
        bool3 = bool4;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localImageBuilder2 = ImageBuilder.INSTANCE;
          localObject2 = ImageBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label755;
          }
          bool3 = true;
        }
        if (i == 1)
        {
          localObject2 = ImageBuilder.INSTANCE;
          localObject2 = ImageBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label761;
          }
          bool3 = true;
        }
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label767;
      }
      bool5 = true;
      label539:
      bool4 = bool5;
      if (bool5)
      {
        i = ((ByteBuffer)localObject4).get();
        localObject3 = localImageBuilder1;
        bool4 = bool5;
        if (i == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localImageBuilder1 = ImageBuilder.INSTANCE;
          localObject3 = ImageBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label773;
          }
          bool4 = true;
        }
        label601:
        if (i == 1)
        {
          localObject3 = ImageBuilder.INSTANCE;
          localObject3 = ImageBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label779;
          }
          bool4 = true;
        }
      }
      label630:
      if (((ByteBuffer)localObject4).get() != 1) {
        break label785;
      }
      bool5 = true;
      label642:
      paramFissionTransaction = (FissionTransaction)localObject5;
      if (bool5) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject4);
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label791;
      }
    }
    label719:
    label725:
    label731:
    label737:
    label743:
    label749:
    label755:
    label761:
    label767:
    label773:
    label779:
    label785:
    label791:
    for (boolean bool6 = true;; bool6 = false)
    {
      if (bool6) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject4);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject4);
      }
      if (bool3) {
        break label797;
      }
      throw new IOException("Failed to find required field: image when reading com.linkedin.android.pegasus.gen.voyager.feed.ShareImage from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label295;
      bool1 = false;
      break label321;
      bool3 = false;
      break label333;
      bool2 = false;
      break label395;
      bool2 = false;
      break label424;
      bool4 = false;
      break label436;
      bool3 = false;
      break label498;
      bool3 = false;
      break label527;
      bool5 = false;
      break label539;
      bool4 = false;
      break label601;
      bool4 = false;
      break label630;
      bool5 = false;
      break label642;
    }
    label797:
    if (!bool6) {
      throw new IOException("Failed to find required field: fileId when reading com.linkedin.android.pegasus.gen.voyager.feed.ShareImage from fission.");
    }
    return new ShareImage(paramString, (AttributedText)localObject1, (Image)localObject2, (Image)localObject3, paramFissionTransaction, str, bool1, bool2, bool3, bool4, bool5, bool6);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.ShareImageBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */