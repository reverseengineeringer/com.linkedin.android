package com.linkedin.crosspromo.fe.api.bolton.android;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.crosspromo.common.android.RichText;
import com.linkedin.crosspromo.common.android.RichTextBuilder;
import com.linkedin.crosspromo.fe.api.android.Image;
import com.linkedin.crosspromo.fe.api.android.ImageBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class PulseTrendingArticleBoltOnBuilder
  implements FissileDataModelBuilder<PulseTrendingArticleBoltOn>, DataTemplateBuilder<PulseTrendingArticleBoltOn>
{
  public static final PulseTrendingArticleBoltOnBuilder INSTANCE = new PulseTrendingArticleBoltOnBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("text");
    JSON_KEY_STORE.put("icon");
    JSON_KEY_STORE.put("boltonText");
    JSON_KEY_STORE.put("headlineText");
  }
  
  public static PulseTrendingArticleBoltOn build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("text", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = RichTextBuilder.INSTANCE;
        localObject4 = RichTextBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("icon", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = ImageBuilder.INSTANCE;
        localObject3 = ImageBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("boltonText", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = RichTextBuilder.INSTANCE;
        localObject2 = RichTextBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("headlineText", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = RichTextBuilder.INSTANCE;
        localObject1 = RichTextBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: text when building com.linkedin.crosspromo.fe.api.bolton.android.PulseTrendingArticleBoltOn");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: icon when building com.linkedin.crosspromo.fe.api.bolton.android.PulseTrendingArticleBoltOn");
    }
    return new PulseTrendingArticleBoltOn((RichText)localObject4, (Image)localObject3, (RichText)localObject2, (RichText)localObject1, bool4, bool3, bool2, bool1);
  }
  
  public static PulseTrendingArticleBoltOn readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building PulseTrendingArticleBoltOn");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building PulseTrendingArticleBoltOn");
    }
    Object localObject4 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building PulseTrendingArticleBoltOn");
    }
    if (((ByteBuffer)localObject4).getInt() != 557770338)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject4);
      throw new IOException("UID mismatch. Can't read cached data when building PulseTrendingArticleBoltOn");
    }
    paramString = null;
    RichTextBuilder localRichTextBuilder3 = null;
    localObject1 = null;
    ImageBuilder localImageBuilder = null;
    Object localObject2 = null;
    RichTextBuilder localRichTextBuilder2 = null;
    Object localObject3 = null;
    RichTextBuilder localRichTextBuilder1 = null;
    boolean bool2;
    boolean bool1;
    label289:
    label315:
    boolean bool3;
    label327:
    label389:
    label418:
    boolean bool4;
    if (((ByteBuffer)localObject4).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject4).get();
        paramString = localRichTextBuilder3;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localRichTextBuilder3 = RichTextBuilder.INSTANCE;
          paramString = RichTextBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label657;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = RichTextBuilder.INSTANCE;
          paramString = RichTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (paramString == null) {
            break label663;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label669;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject4).get();
        localObject1 = localImageBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localImageBuilder = ImageBuilder.INSTANCE;
          localObject1 = ImageBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label675;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject1 = ImageBuilder.INSTANCE;
          localObject1 = ImageBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label681;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label687;
      }
      bool4 = true;
      label430:
      bool3 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject4).get();
        localObject2 = localRichTextBuilder2;
        bool3 = bool4;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localRichTextBuilder2 = RichTextBuilder.INSTANCE;
          localObject2 = RichTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label693;
          }
          bool3 = true;
        }
        label492:
        if (i == 1)
        {
          localObject2 = RichTextBuilder.INSTANCE;
          localObject2 = RichTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label699;
          }
          bool3 = true;
        }
      }
      label521:
      if (((ByteBuffer)localObject4).get() != 1) {
        break label705;
      }
      bool4 = true;
      label533:
      bool5 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject4).get();
        localObject3 = localRichTextBuilder1;
        if (i == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localRichTextBuilder1 = RichTextBuilder.INSTANCE;
          localObject3 = RichTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label711;
          }
          bool4 = true;
        }
        label591:
        bool5 = bool4;
        if (i == 1)
        {
          localObject3 = RichTextBuilder.INSTANCE;
          localObject3 = RichTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label717;
          }
        }
      }
    }
    label657:
    label663:
    label669:
    label675:
    label681:
    label687:
    label693:
    label699:
    label705:
    label711:
    label717:
    for (boolean bool5 = true;; bool5 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject4);
      }
      if (bool1) {
        break label723;
      }
      throw new IOException("Failed to find required field: text when reading com.linkedin.crosspromo.fe.api.bolton.android.PulseTrendingArticleBoltOn from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label289;
      bool1 = false;
      break label315;
      bool3 = false;
      break label327;
      bool2 = false;
      break label389;
      bool2 = false;
      break label418;
      bool4 = false;
      break label430;
      bool3 = false;
      break label492;
      bool3 = false;
      break label521;
      bool4 = false;
      break label533;
      bool4 = false;
      break label591;
    }
    label723:
    if (!bool2) {
      throw new IOException("Failed to find required field: icon when reading com.linkedin.crosspromo.fe.api.bolton.android.PulseTrendingArticleBoltOn from fission.");
    }
    return new PulseTrendingArticleBoltOn(paramString, (Image)localObject1, (RichText)localObject2, (RichText)localObject3, bool1, bool2, bool3, bool5);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.crosspromo.fe.api.bolton.android.PulseTrendingArticleBoltOnBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */