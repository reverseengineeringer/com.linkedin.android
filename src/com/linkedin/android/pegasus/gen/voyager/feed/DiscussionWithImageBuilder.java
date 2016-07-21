package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
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

public final class DiscussionWithImageBuilder
  implements FissileDataModelBuilder<DiscussionWithImage>, DataTemplateBuilder<DiscussionWithImage>
{
  public static final DiscussionWithImageBuilder INSTANCE = new DiscussionWithImageBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("title");
    JSON_KEY_STORE.put("body");
    JSON_KEY_STORE.put("contentId");
    JSON_KEY_STORE.put("contentUrl");
    JSON_KEY_STORE.put("contentImage");
  }
  
  public static DiscussionWithImage build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str3 = null;
    Object localObject2 = null;
    String str2 = null;
    String str1 = null;
    Object localObject1 = null;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("title", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("body", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = AnnotatedTextBuilder.INSTANCE;
        localObject2 = AnnotatedTextBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("contentId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("contentUrl", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("contentImage", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = ImageBuilder.INSTANCE;
        localObject1 = ImageBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: title when building com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithImage");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: contentId when building com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithImage");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: contentUrl when building com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithImage");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: contentImage when building com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithImage");
    }
    return new DiscussionWithImage(str3, (AnnotatedText)localObject2, str2, str1, (Image)localObject1, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static DiscussionWithImage readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building DiscussionWithImage");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building DiscussionWithImage");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building DiscussionWithImage");
    }
    if (((ByteBuffer)localObject2).getInt() != -1481923370)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building DiscussionWithImage");
    }
    String str1 = null;
    paramString = null;
    AnnotatedTextBuilder localAnnotatedTextBuilder = null;
    String str2 = null;
    String str3 = null;
    localObject1 = null;
    ImageBuilder localImageBuilder = null;
    boolean bool4;
    boolean bool2;
    label256:
    boolean bool1;
    label313:
    label339:
    boolean bool5;
    label351:
    boolean bool6;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool4 = true;
      if (bool4) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label529;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = localAnnotatedTextBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localAnnotatedTextBuilder = AnnotatedTextBuilder.INSTANCE;
          paramString = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label535;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = AnnotatedTextBuilder.INSTANCE;
          paramString = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label541;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label547;
      }
      bool5 = true;
      if (bool5) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label553;
      }
      bool6 = true;
      label378:
      if (bool6) {
        str3 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label559;
      }
      bool2 = true;
      label405:
      bool3 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        localObject1 = localImageBuilder;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localImageBuilder = ImageBuilder.INSTANCE;
          localObject1 = ImageBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label565;
          }
          bool2 = true;
        }
        label463:
        bool3 = bool2;
        if (i == 1)
        {
          localObject1 = ImageBuilder.INSTANCE;
          localObject1 = ImageBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label571;
          }
        }
      }
    }
    label529:
    label535:
    label541:
    label547:
    label553:
    label559:
    label565:
    label571:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (bool4) {
        break label577;
      }
      throw new IOException("Failed to find required field: title when reading com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithImage from fission.");
      bool4 = false;
      break;
      bool2 = false;
      break label256;
      bool1 = false;
      break label313;
      bool1 = false;
      break label339;
      bool5 = false;
      break label351;
      bool6 = false;
      break label378;
      bool2 = false;
      break label405;
      bool2 = false;
      break label463;
    }
    label577:
    if (!bool5) {
      throw new IOException("Failed to find required field: contentId when reading com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithImage from fission.");
    }
    if (!bool6) {
      throw new IOException("Failed to find required field: contentUrl when reading com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithImage from fission.");
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: contentImage when reading com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithImage from fission.");
    }
    return new DiscussionWithImage(str1, paramString, str2, str3, (Image)localObject1, bool4, bool1, bool5, bool6, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithImageBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */