package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedTextBuilder;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedTextBuilder;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.PropType;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.PropType.Builder;
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

public final class PropUpdateBuilder
  implements FissileDataModelBuilder<PropUpdate>, DataTemplateBuilder<PropUpdate>
{
  public static final PropUpdateBuilder INSTANCE = new PropUpdateBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("actions");
    JSON_KEY_STORE.put("header");
    JSON_KEY_STORE.put("actor");
    JSON_KEY_STORE.put("createdAt");
    JSON_KEY_STORE.put("text");
    JSON_KEY_STORE.put("subtext");
    JSON_KEY_STORE.put("type");
  }
  
  public static PropUpdate build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject1 = null;
    Object localObject5 = null;
    Object localObject4 = null;
    long l = 0L;
    Object localObject3 = null;
    Object localObject2 = null;
    PropType localPropType = null;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("actions", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            UpdateActionBuilder localUpdateActionBuilder = UpdateActionBuilder.INSTANCE;
            ((List)localObject1).add(UpdateActionBuilder.build(paramDataReader));
          }
        }
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("header", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject5 = AnnotatedTextBuilder.INSTANCE;
        localObject5 = AnnotatedTextBuilder.build(paramDataReader);
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("actor", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = SocialActorBuilder.INSTANCE;
        localObject4 = SocialActorBuilder.build(paramDataReader);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("createdAt", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        l = paramDataReader.readLong();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("text", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = AttributedTextBuilder.INSTANCE;
        localObject3 = AttributedTextBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("subtext", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = AttributedTextBuilder.INSTANCE;
        localObject2 = AttributedTextBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("type", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localPropType = (PropType)paramDataReader.readEnum(PropType.Builder.INSTANCE);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool7) {
      localObject1 = Collections.emptyList();
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: header when building com.linkedin.android.pegasus.gen.voyager.feed.PropUpdate");
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: actor when building com.linkedin.android.pegasus.gen.voyager.feed.PropUpdate");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: text when building com.linkedin.android.pegasus.gen.voyager.feed.PropUpdate");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: type when building com.linkedin.android.pegasus.gen.voyager.feed.PropUpdate");
    }
    return new PropUpdate((List)localObject1, (AnnotatedText)localObject5, (SocialActor)localObject4, l, (AttributedText)localObject3, (AttributedText)localObject2, localPropType, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static PropUpdate readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building PropUpdate");
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
          localObject5 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building PropUpdate");
    }
    Object localObject5 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building PropUpdate");
    }
    if (((ByteBuffer)localObject5).getInt() != 688823024)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject5);
      throw new IOException("UID mismatch. Can't read cached data when building PropUpdate");
    }
    paramString = null;
    localObject1 = null;
    AnnotatedTextBuilder localAnnotatedTextBuilder = null;
    Object localObject2 = null;
    SocialActorBuilder localSocialActorBuilder = null;
    long l = 0L;
    Object localObject3 = null;
    AttributedTextBuilder localAttributedTextBuilder2 = null;
    Object localObject4 = null;
    AttributedTextBuilder localAttributedTextBuilder1 = null;
    Object localObject6 = null;
    boolean bool6;
    ArrayList localArrayList;
    if (((ByteBuffer)localObject5).get() == 1)
    {
      bool6 = true;
      if (!bool6) {
        break label386;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject5);
      localArrayList = new ArrayList();
      label265:
      paramString = localArrayList;
      if (j <= 0) {
        break label386;
      }
      paramString = null;
      i = 1;
      int k = ((ByteBuffer)localObject5).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject5);
        UpdateActionBuilder localUpdateActionBuilder = UpdateActionBuilder.INSTANCE;
        paramString = UpdateActionBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label374;
        }
        i = 1;
      }
      label319:
      if (k == 1)
      {
        paramString = UpdateActionBuilder.INSTANCE;
        paramString = UpdateActionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
        if (paramString == null) {
          break label380;
        }
      }
    }
    label374:
    label380:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      j -= 1;
      break label265;
      bool6 = false;
      break;
      i = 0;
      break label319;
    }
    label386:
    boolean bool2;
    boolean bool1;
    label460:
    label489:
    boolean bool3;
    label501:
    label563:
    label592:
    boolean bool7;
    label604:
    boolean bool4;
    if (((ByteBuffer)localObject5).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject5).get();
        localObject1 = localAnnotatedTextBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localAnnotatedTextBuilder = AnnotatedTextBuilder.INSTANCE;
          localObject1 = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label896;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          localObject1 = AnnotatedTextBuilder.INSTANCE;
          localObject1 = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label902;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label908;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject5).get();
        localObject2 = localSocialActorBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localSocialActorBuilder = SocialActorBuilder.INSTANCE;
          localObject2 = SocialActorBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label914;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject2 = SocialActorBuilder.INSTANCE;
          localObject2 = SocialActorBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label920;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label926;
      }
      bool7 = true;
      if (bool7) {
        l = ((ByteBuffer)localObject5).getLong();
      }
      if (((ByteBuffer)localObject5).get() != 1) {
        break label932;
      }
      bool4 = true;
      label628:
      bool3 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject5).get();
        localObject3 = localAttributedTextBuilder2;
        bool3 = bool4;
        if (i == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localAttributedTextBuilder2 = AttributedTextBuilder.INSTANCE;
          localObject3 = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label938;
          }
          bool3 = true;
        }
        label690:
        if (i == 1)
        {
          localObject3 = AttributedTextBuilder.INSTANCE;
          localObject3 = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label944;
          }
          bool3 = true;
        }
      }
      label719:
      if (((ByteBuffer)localObject5).get() != 1) {
        break label950;
      }
      bool5 = true;
      label731:
      bool4 = bool5;
      if (bool5)
      {
        i = ((ByteBuffer)localObject5).get();
        localObject4 = localAttributedTextBuilder1;
        bool4 = bool5;
        if (i == 0)
        {
          localObject4 = paramFissionAdapter.readString((ByteBuffer)localObject5);
          localAttributedTextBuilder1 = AttributedTextBuilder.INSTANCE;
          localObject4 = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject4, paramFissionTransaction);
          if (localObject4 == null) {
            break label956;
          }
          bool4 = true;
        }
        label793:
        if (i == 1)
        {
          localObject4 = AttributedTextBuilder.INSTANCE;
          localObject4 = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
          if (localObject4 == null) {
            break label962;
          }
          bool4 = true;
        }
      }
      label822:
      if (((ByteBuffer)localObject5).get() != 1) {
        break label968;
      }
    }
    label896:
    label902:
    label908:
    label914:
    label920:
    label926:
    label932:
    label938:
    label944:
    label950:
    label956:
    label962:
    label968:
    for (boolean bool5 = true;; bool5 = false)
    {
      paramFissionTransaction = (FissionTransaction)localObject6;
      if (bool5) {
        paramFissionTransaction = PropType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject5));
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject5);
      }
      if (!bool6) {
        paramString = Collections.emptyList();
      }
      if (bool1) {
        break label974;
      }
      throw new IOException("Failed to find required field: header when reading com.linkedin.android.pegasus.gen.voyager.feed.PropUpdate from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label460;
      bool1 = false;
      break label489;
      bool3 = false;
      break label501;
      bool2 = false;
      break label563;
      bool2 = false;
      break label592;
      bool7 = false;
      break label604;
      bool4 = false;
      break label628;
      bool3 = false;
      break label690;
      bool3 = false;
      break label719;
      bool5 = false;
      break label731;
      bool4 = false;
      break label793;
      bool4 = false;
      break label822;
    }
    label974:
    if (!bool2) {
      throw new IOException("Failed to find required field: actor when reading com.linkedin.android.pegasus.gen.voyager.feed.PropUpdate from fission.");
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: text when reading com.linkedin.android.pegasus.gen.voyager.feed.PropUpdate from fission.");
    }
    if (!bool5) {
      throw new IOException("Failed to find required field: type when reading com.linkedin.android.pegasus.gen.voyager.feed.PropUpdate from fission.");
    }
    return new PropUpdate(paramString, (AnnotatedText)localObject1, (SocialActor)localObject2, l, (AttributedText)localObject3, (AttributedText)localObject4, paramFissionTransaction, bool6, bool1, bool2, bool7, bool3, bool4, bool5);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.PropUpdateBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */