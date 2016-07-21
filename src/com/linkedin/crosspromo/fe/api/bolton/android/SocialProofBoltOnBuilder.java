package com.linkedin.crosspromo.fe.api.bolton.android;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.crosspromo.common.android.RichText;
import com.linkedin.crosspromo.common.android.RichTextBuilder;
import com.linkedin.crosspromo.fe.api.android.ImageBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class SocialProofBoltOnBuilder
  implements FissileDataModelBuilder<SocialProofBoltOn>, DataTemplateBuilder<SocialProofBoltOn>
{
  public static final SocialProofBoltOnBuilder INSTANCE = new SocialProofBoltOnBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("text");
    JSON_KEY_STORE.put("boltonText");
    JSON_KEY_STORE.put("headlineText");
    JSON_KEY_STORE.put("profileImages");
  }
  
  public static SocialProofBoltOn build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    ArrayList localArrayList = null;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("text", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = RichTextBuilder.INSTANCE;
        localObject3 = RichTextBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("boltonText", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = RichTextBuilder.INSTANCE;
        localObject2 = RichTextBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("headlineText", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = RichTextBuilder.INSTANCE;
        localObject1 = RichTextBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("profileImages", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            ImageBuilder localImageBuilder = ImageBuilder.INSTANCE;
            localArrayList.add(ImageBuilder.build(paramDataReader));
          }
        }
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: text when building com.linkedin.crosspromo.fe.api.bolton.android.SocialProofBoltOn");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: profileImages when building com.linkedin.crosspromo.fe.api.bolton.android.SocialProofBoltOn");
    }
    return new SocialProofBoltOn((RichText)localObject3, (RichText)localObject2, (RichText)localObject1, localArrayList, bool4, bool3, bool2, bool1);
  }
  
  public static SocialProofBoltOn readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building SocialProofBoltOn");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building SocialProofBoltOn");
    }
    Object localObject4 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building SocialProofBoltOn");
    }
    if (((ByteBuffer)localObject4).getInt() != -15902824)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject4);
      throw new IOException("UID mismatch. Can't read cached data when building SocialProofBoltOn");
    }
    paramString = null;
    RichTextBuilder localRichTextBuilder = null;
    localObject1 = null;
    Object localObject6 = null;
    Object localObject2 = null;
    Object localObject5 = null;
    Object localObject3 = null;
    boolean bool2;
    boolean bool1;
    label286:
    label312:
    boolean bool3;
    label324:
    label386:
    label415:
    boolean bool4;
    if (((ByteBuffer)localObject4).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject4).get();
        paramString = localRichTextBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localRichTextBuilder = RichTextBuilder.INSTANCE;
          paramString = RichTextBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label673;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = RichTextBuilder.INSTANCE;
          paramString = RichTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (paramString == null) {
            break label679;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label685;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject4).get();
        localObject1 = localObject6;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localObject6 = RichTextBuilder.INSTANCE;
          localObject1 = RichTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label691;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject1 = RichTextBuilder.INSTANCE;
          localObject1 = RichTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label697;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject4).get() != 1) {
        break label703;
      }
      bool4 = true;
      label427:
      bool3 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject4).get();
        localObject2 = localObject5;
        bool3 = bool4;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localObject5 = RichTextBuilder.INSTANCE;
          localObject2 = RichTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label709;
          }
          bool3 = true;
        }
        label489:
        if (i == 1)
        {
          localObject2 = RichTextBuilder.INSTANCE;
          localObject2 = RichTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label715;
          }
          bool3 = true;
        }
      }
      label518:
      if (((ByteBuffer)localObject4).get() != 1) {
        break label721;
      }
      bool4 = true;
      label530:
      if (!bool4) {
        break label739;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject4);
      localObject5 = new ArrayList();
      label554:
      localObject3 = localObject5;
      if (j <= 0) {
        break label739;
      }
      localObject3 = null;
      i = 1;
      int k = ((ByteBuffer)localObject4).get();
      if (k == 0)
      {
        localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject4);
        localObject6 = ImageBuilder.INSTANCE;
        localObject3 = ImageBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
        if (localObject3 == null) {
          break label727;
        }
        i = 1;
      }
      label614:
      if (k == 1)
      {
        localObject3 = ImageBuilder.INSTANCE;
        localObject3 = ImageBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
        if (localObject3 == null) {
          break label733;
        }
      }
    }
    label673:
    label679:
    label685:
    label691:
    label697:
    label703:
    label709:
    label715:
    label721:
    label727:
    label733:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject5).add(localObject3);
      }
      j -= 1;
      break label554;
      bool2 = false;
      break;
      bool1 = false;
      break label286;
      bool1 = false;
      break label312;
      bool3 = false;
      break label324;
      bool2 = false;
      break label386;
      bool2 = false;
      break label415;
      bool4 = false;
      break label427;
      bool3 = false;
      break label489;
      bool3 = false;
      break label518;
      bool4 = false;
      break label530;
      i = 0;
      break label614;
    }
    label739:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject4);
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: text when reading com.linkedin.crosspromo.fe.api.bolton.android.SocialProofBoltOn from fission.");
    }
    if (!bool4) {
      throw new IOException("Failed to find required field: profileImages when reading com.linkedin.crosspromo.fe.api.bolton.android.SocialProofBoltOn from fission.");
    }
    return new SocialProofBoltOn(paramString, (RichText)localObject1, (RichText)localObject2, (List)localObject3, bool1, bool2, bool3, bool4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.crosspromo.fe.api.bolton.android.SocialProofBoltOnBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */