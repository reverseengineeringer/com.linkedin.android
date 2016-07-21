package com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.common.MediaProxyImage;
import com.linkedin.android.pegasus.gen.voyager.common.MediaProxyImageBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class TreasuryMediaBuilder$DataBuilder
  implements FissileDataModelBuilder<TreasuryMedia.Data>, DataTemplateBuilder<TreasuryMedia.Data>
{
  public static final DataBuilder INSTANCE = new DataBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("com.linkedin.voyager.identity.profile.treasury.Video");
    JSON_KEY_STORE.put("com.linkedin.voyager.common.MediaProxyImage");
    JSON_KEY_STORE.put("com.linkedin.voyager.identity.profile.treasury.RichText");
    JSON_KEY_STORE.put("com.linkedin.voyager.identity.profile.treasury.Link");
  }
  
  public static TreasuryMedia.Data build(DataReader paramDataReader)
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
      if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.treasury.Video", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = VideoBuilder.INSTANCE;
        localObject4 = VideoBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.common.MediaProxyImage", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = MediaProxyImageBuilder.INSTANCE;
        localObject3 = MediaProxyImageBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.treasury.RichText", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = RichTextBuilder.INSTANCE;
        localObject2 = RichTextBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.profile.treasury.Link", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = LinkBuilder.INSTANCE;
        localObject1 = LinkBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    int j = 0;
    if (bool4) {
      j = 1;
    }
    int i = j;
    if (bool3)
    {
      if (j != 0) {
        throw new DataReaderException("Found more than 1 member when building .Data");
      }
      i = 1;
    }
    j = i;
    if (bool2)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .Data");
      }
      j = 1;
    }
    if ((bool1) && (j != 0)) {
      throw new DataReaderException("Found more than 1 member when building .Data");
    }
    return new TreasuryMedia.Data((Video)localObject4, (MediaProxyImage)localObject3, (RichText)localObject2, (Link)localObject1, bool4, bool3, bool2, bool1);
  }
  
  public static TreasuryMedia.Data readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building TreasuryMedia.Data");
    }
    Object localObject1 = paramByteBuffer;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building TreasuryMedia.Data");
    }
    Object localObject4 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building TreasuryMedia.Data");
    }
    if (((ByteBuffer)localObject4).getInt() != -1333573818)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject4);
      throw new IOException("UID mismatch. Can't read cached data when building TreasuryMedia.Data");
    }
    paramString = null;
    VideoBuilder localVideoBuilder = null;
    localObject1 = null;
    MediaProxyImageBuilder localMediaProxyImageBuilder = null;
    Object localObject2 = null;
    RichTextBuilder localRichTextBuilder = null;
    Object localObject3 = null;
    LinkBuilder localLinkBuilder = null;
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
        paramString = localVideoBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localVideoBuilder = VideoBuilder.INSTANCE;
          paramString = VideoBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label677;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = VideoBuilder.INSTANCE;
          paramString = VideoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (paramString == null) {
            break label683;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label689;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject4).get();
        localObject1 = localMediaProxyImageBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localMediaProxyImageBuilder = MediaProxyImageBuilder.INSTANCE;
          localObject1 = MediaProxyImageBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label695;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject1 = MediaProxyImageBuilder.INSTANCE;
          localObject1 = MediaProxyImageBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label701;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label707;
      }
      bool4 = true;
      label430:
      bool3 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject4).get();
        localObject2 = localRichTextBuilder;
        bool3 = bool4;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localRichTextBuilder = RichTextBuilder.INSTANCE;
          localObject2 = RichTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label713;
          }
          bool3 = true;
        }
        label492:
        if (i == 1)
        {
          localObject2 = RichTextBuilder.INSTANCE;
          localObject2 = RichTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label719;
          }
          bool3 = true;
        }
      }
      label521:
      if (((ByteBuffer)localObject4).get() != 1) {
        break label725;
      }
      bool4 = true;
      label533:
      bool5 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject4).get();
        localObject3 = localLinkBuilder;
        if (i == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localLinkBuilder = LinkBuilder.INSTANCE;
          localObject3 = LinkBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label731;
          }
          bool4 = true;
        }
        label591:
        bool5 = bool4;
        if (i == 1)
        {
          localObject3 = LinkBuilder.INSTANCE;
          localObject3 = LinkBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label737;
          }
        }
      }
    }
    label677:
    label683:
    label689:
    label695:
    label701:
    label707:
    label713:
    label719:
    label725:
    label731:
    label737:
    for (boolean bool5 = true;; bool5 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject4);
      }
      j = 0;
      if (bool1) {
        j = 1;
      }
      i = j;
      if (!bool2) {
        break label746;
      }
      if (j == 0) {
        break label743;
      }
      throw new IOException("Found more than 1 member when reading .Data from fission.");
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
    label743:
    int i = 1;
    label746:
    int j = i;
    if (bool3)
    {
      if (i != 0) {
        throw new IOException("Found more than 1 member when reading .Data from fission.");
      }
      j = 1;
    }
    if ((bool5) && (j != 0)) {
      throw new IOException("Found more than 1 member when reading .Data from fission.");
    }
    return new TreasuryMedia.Data(paramString, (MediaProxyImage)localObject1, (RichText)localObject2, (Link)localObject3, bool1, bool2, bool3, bool5);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.TreasuryMediaBuilder.DataBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */