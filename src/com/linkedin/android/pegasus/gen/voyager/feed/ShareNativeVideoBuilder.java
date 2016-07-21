package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedTextBuilder;
import com.linkedin.android.pegasus.gen.videocontent.VideoPlayMetadata;
import com.linkedin.android.pegasus.gen.videocontent.VideoPlayMetadataBuilder;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedTextBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ShareNativeVideoBuilder
  implements FissileDataModelBuilder<ShareNativeVideo>, DataTemplateBuilder<ShareNativeVideo>
{
  public static final ShareNativeVideoBuilder INSTANCE = new ShareNativeVideoBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("urn");
    JSON_KEY_STORE.put("title");
    JSON_KEY_STORE.put("subtitle");
    JSON_KEY_STORE.put("description");
    JSON_KEY_STORE.put("videoPlayMetadata");
    JSON_KEY_STORE.put("text");
    JSON_KEY_STORE.put("attributedText");
    JSON_KEY_STORE.put("url");
  }
  
  public static ShareNativeVideo build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject4 = null;
    String str4 = null;
    String str3 = null;
    String str2 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    String str1 = null;
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
      if (paramDataReader.shouldReadField$11ca93e7("urn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = UrnCoercer.INSTANCE;
        localObject4 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("title", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str4 = paramDataReader.readString();
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("subtitle", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("description", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("videoPlayMetadata", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = VideoPlayMetadataBuilder.INSTANCE;
        localObject3 = VideoPlayMetadataBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("text", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = AnnotatedTextBuilder.INSTANCE;
        localObject2 = AnnotatedTextBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("attributedText", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = AttributedTextBuilder.INSTANCE;
        localObject1 = AttributedTextBuilder.build(paramDataReader);
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
    if (!bool8) {
      throw new DataReaderException("Failed to find required field: urn when building com.linkedin.android.pegasus.gen.voyager.feed.ShareNativeVideo");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: videoPlayMetadata when building com.linkedin.android.pegasus.gen.voyager.feed.ShareNativeVideo");
    }
    return new ShareNativeVideo((Urn)localObject4, str4, str3, str2, (VideoPlayMetadata)localObject3, (AnnotatedText)localObject2, (AttributedText)localObject1, str1, bool8, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static ShareNativeVideo readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building ShareNativeVideo");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building ShareNativeVideo");
    }
    Object localObject3 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building ShareNativeVideo");
    }
    if (((ByteBuffer)localObject3).getInt() != 1118259436)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject3);
      throw new IOException("UID mismatch. Can't read cached data when building ShareNativeVideo");
    }
    Object localObject4 = null;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    paramString = null;
    VideoPlayMetadataBuilder localVideoPlayMetadataBuilder = null;
    localObject1 = null;
    AnnotatedTextBuilder localAnnotatedTextBuilder = null;
    Object localObject2 = null;
    AttributedTextBuilder localAttributedTextBuilder = null;
    Object localObject5 = null;
    boolean bool5;
    boolean bool6;
    label276:
    boolean bool7;
    label303:
    boolean bool8;
    label330:
    boolean bool2;
    label357:
    boolean bool1;
    label414:
    label440:
    boolean bool3;
    if (((ByteBuffer)localObject3).get() == 1)
    {
      bool5 = true;
      if (bool5)
      {
        localObject4 = UrnCoercer.INSTANCE;
        localObject4 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject3));
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label708;
      }
      bool6 = true;
      if (bool6) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject3);
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label714;
      }
      bool7 = true;
      if (bool7) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject3);
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label720;
      }
      bool8 = true;
      if (bool8) {
        str3 = paramFissionAdapter.readString((ByteBuffer)localObject3);
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label726;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject3).get();
        paramString = localVideoPlayMetadataBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localVideoPlayMetadataBuilder = VideoPlayMetadataBuilder.INSTANCE;
          paramString = VideoPlayMetadataBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label732;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = VideoPlayMetadataBuilder.INSTANCE;
          paramString = VideoPlayMetadataBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (paramString == null) {
            break label738;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject3).get() != 1) {
        break label744;
      }
      bool3 = true;
      label452:
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject3).get();
        localObject1 = localAnnotatedTextBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localAnnotatedTextBuilder = AnnotatedTextBuilder.INSTANCE;
          localObject1 = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label750;
          }
          bool2 = true;
        }
        label514:
        if (i == 1)
        {
          localObject1 = AnnotatedTextBuilder.INSTANCE;
          localObject1 = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label756;
          }
          bool2 = true;
        }
      }
      label543:
      if (((ByteBuffer)localObject3).get() != 1) {
        break label762;
      }
      bool4 = true;
      label555:
      bool3 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject3).get();
        localObject2 = localAttributedTextBuilder;
        bool3 = bool4;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject3);
          localAttributedTextBuilder = AttributedTextBuilder.INSTANCE;
          localObject2 = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label768;
          }
          bool3 = true;
        }
        label617:
        if (i == 1)
        {
          localObject2 = AttributedTextBuilder.INSTANCE;
          localObject2 = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject3, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label774;
          }
          bool3 = true;
        }
      }
      label646:
      if (((ByteBuffer)localObject3).get() != 1) {
        break label780;
      }
    }
    label708:
    label714:
    label720:
    label726:
    label732:
    label738:
    label744:
    label750:
    label756:
    label762:
    label768:
    label774:
    label780:
    for (boolean bool4 = true;; bool4 = false)
    {
      paramFissionTransaction = (FissionTransaction)localObject5;
      if (bool4) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject3);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject3);
      }
      if (bool5) {
        break label786;
      }
      throw new IOException("Failed to find required field: urn when reading com.linkedin.android.pegasus.gen.voyager.feed.ShareNativeVideo from fission.");
      bool5 = false;
      break;
      bool6 = false;
      break label276;
      bool7 = false;
      break label303;
      bool8 = false;
      break label330;
      bool2 = false;
      break label357;
      bool1 = false;
      break label414;
      bool1 = false;
      break label440;
      bool3 = false;
      break label452;
      bool2 = false;
      break label514;
      bool2 = false;
      break label543;
      bool4 = false;
      break label555;
      bool3 = false;
      break label617;
      bool3 = false;
      break label646;
    }
    label786:
    if (!bool1) {
      throw new IOException("Failed to find required field: videoPlayMetadata when reading com.linkedin.android.pegasus.gen.voyager.feed.ShareNativeVideo from fission.");
    }
    return new ShareNativeVideo((Urn)localObject4, str1, str2, str3, paramString, (AnnotatedText)localObject1, (AttributedText)localObject2, paramFissionTransaction, bool5, bool6, bool7, bool8, bool1, bool2, bool3, bool4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.ShareNativeVideoBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */