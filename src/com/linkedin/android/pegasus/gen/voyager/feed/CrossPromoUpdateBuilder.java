package com.linkedin.android.pegasus.gen.voyager.feed;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedTextBuilder;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedTextBuilder;
import com.linkedin.data.lite.BytesCoercer;
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

public final class CrossPromoUpdateBuilder
  implements FissileDataModelBuilder<CrossPromoUpdate>, DataTemplateBuilder<CrossPromoUpdate>
{
  public static final CrossPromoUpdateBuilder INSTANCE = new CrossPromoUpdateBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("actions");
    JSON_KEY_STORE.put("legoTrackingToken");
    JSON_KEY_STORE.put("legoTrackingId");
    JSON_KEY_STORE.put("header");
    JSON_KEY_STORE.put("actor");
    JSON_KEY_STORE.put("text");
    JSON_KEY_STORE.put("attributedText");
    JSON_KEY_STORE.put("content");
  }
  
  public static CrossPromoUpdate build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject1 = null;
    String str = null;
    Object localObject7 = null;
    Object localObject6 = null;
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject2 = null;
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
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("legoTrackingToken", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("legoTrackingId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject7 = BytesCoercer.INSTANCE;
        localObject7 = BytesCoercer.coerceToCustomType(paramDataReader.readBytes());
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("header", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject6 = AnnotatedTextBuilder.INSTANCE;
        localObject6 = AnnotatedTextBuilder.build(paramDataReader);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("actor", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject5 = AppActorBuilder.INSTANCE;
        localObject5 = AppActorBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("text", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = AnnotatedTextBuilder.INSTANCE;
        localObject4 = AnnotatedTextBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("attributedText", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = AttributedTextBuilder.INSTANCE;
        localObject3 = AttributedTextBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("content", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = ContentBuilder.INSTANCE;
        localObject2 = ContentBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool8) {
      localObject1 = Collections.emptyList();
    }
    if (!bool7) {
      throw new DataReaderException("Failed to find required field: legoTrackingToken when building com.linkedin.android.pegasus.gen.voyager.feed.CrossPromoUpdate");
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: legoTrackingId when building com.linkedin.android.pegasus.gen.voyager.feed.CrossPromoUpdate");
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: header when building com.linkedin.android.pegasus.gen.voyager.feed.CrossPromoUpdate");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: actor when building com.linkedin.android.pegasus.gen.voyager.feed.CrossPromoUpdate");
    }
    return new CrossPromoUpdate((List)localObject1, str, (String)localObject7, (AnnotatedText)localObject6, (AppActor)localObject5, (AnnotatedText)localObject4, (AttributedText)localObject3, (CrossPromoUpdate.Content)localObject2, bool8, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static CrossPromoUpdate readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building CrossPromoUpdate");
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
          localObject6 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building CrossPromoUpdate");
    }
    Object localObject6 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building CrossPromoUpdate");
    }
    if (((ByteBuffer)localObject6).getInt() != 1542441299)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject6);
      throw new IOException("UID mismatch. Can't read cached data when building CrossPromoUpdate");
    }
    paramString = null;
    String str = null;
    Object localObject7 = null;
    localObject1 = null;
    AnnotatedTextBuilder localAnnotatedTextBuilder2 = null;
    Object localObject2 = null;
    AppActorBuilder localAppActorBuilder = null;
    Object localObject3 = null;
    AnnotatedTextBuilder localAnnotatedTextBuilder1 = null;
    Object localObject4 = null;
    AttributedTextBuilder localAttributedTextBuilder = null;
    Object localObject5 = null;
    ContentBuilder localContentBuilder = null;
    boolean bool7;
    ArrayList localArrayList;
    if (((ByteBuffer)localObject6).get() == 1)
    {
      bool7 = true;
      if (!bool7) {
        break label392;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject6);
      localArrayList = new ArrayList();
      label271:
      paramString = localArrayList;
      if (j <= 0) {
        break label392;
      }
      paramString = null;
      i = 1;
      int k = ((ByteBuffer)localObject6).get();
      if (k == 0)
      {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject6);
        UpdateActionBuilder localUpdateActionBuilder = UpdateActionBuilder.INSTANCE;
        paramString = UpdateActionBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
        if (paramString == null) {
          break label380;
        }
        i = 1;
      }
      label325:
      if (k == 1)
      {
        paramString = UpdateActionBuilder.INSTANCE;
        paramString = UpdateActionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
        if (paramString == null) {
          break label386;
        }
      }
    }
    label380:
    label386:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(paramString);
      }
      j -= 1;
      break label271;
      bool7 = false;
      break;
      i = 0;
      break label325;
    }
    label392:
    boolean bool8;
    boolean bool9;
    label431:
    boolean bool2;
    label476:
    boolean bool1;
    label538:
    label567:
    boolean bool3;
    label579:
    label641:
    label670:
    boolean bool4;
    label682:
    label744:
    label773:
    boolean bool5;
    if (((ByteBuffer)localObject6).get() == 1)
    {
      bool8 = true;
      if (bool8) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject6);
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1021;
      }
      bool9 = true;
      if (bool9)
      {
        localObject7 = new byte[((ByteBuffer)localObject6).getInt()];
        ((ByteBuffer)localObject6).get((byte[])localObject7);
        localObject7 = new String((byte[])localObject7);
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1027;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject6).get();
        localObject1 = localAnnotatedTextBuilder2;
        bool1 = bool2;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localAnnotatedTextBuilder2 = AnnotatedTextBuilder.INSTANCE;
          localObject1 = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label1033;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          localObject1 = AnnotatedTextBuilder.INSTANCE;
          localObject1 = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label1039;
          }
          bool1 = true;
        }
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1045;
      }
      bool3 = true;
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject6).get();
        localObject2 = localAppActorBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localAppActorBuilder = AppActorBuilder.INSTANCE;
          localObject2 = AppActorBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label1051;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject2 = AppActorBuilder.INSTANCE;
          localObject2 = AppActorBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (localObject2 == null) {
            break label1057;
          }
          bool2 = true;
        }
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1063;
      }
      bool4 = true;
      bool3 = bool4;
      if (bool4)
      {
        i = ((ByteBuffer)localObject6).get();
        localObject3 = localAnnotatedTextBuilder1;
        bool3 = bool4;
        if (i == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localAnnotatedTextBuilder1 = AnnotatedTextBuilder.INSTANCE;
          localObject3 = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label1069;
          }
          bool3 = true;
        }
        if (i == 1)
        {
          localObject3 = AnnotatedTextBuilder.INSTANCE;
          localObject3 = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (localObject3 == null) {
            break label1075;
          }
          bool3 = true;
        }
      }
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1081;
      }
      bool5 = true;
      label785:
      bool4 = bool5;
      if (bool5)
      {
        i = ((ByteBuffer)localObject6).get();
        localObject4 = localAttributedTextBuilder;
        bool4 = bool5;
        if (i == 0)
        {
          localObject4 = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localAttributedTextBuilder = AttributedTextBuilder.INSTANCE;
          localObject4 = AttributedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject4, paramFissionTransaction);
          if (localObject4 == null) {
            break label1087;
          }
          bool4 = true;
        }
        label847:
        if (i == 1)
        {
          localObject4 = AttributedTextBuilder.INSTANCE;
          localObject4 = AttributedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (localObject4 == null) {
            break label1093;
          }
          bool4 = true;
        }
      }
      label876:
      if (((ByteBuffer)localObject6).get() != 1) {
        break label1099;
      }
      bool5 = true;
      label888:
      bool6 = bool5;
      if (bool5)
      {
        i = ((ByteBuffer)localObject6).get();
        localObject5 = localContentBuilder;
        if (i == 0)
        {
          localObject5 = paramFissionAdapter.readString((ByteBuffer)localObject6);
          localContentBuilder = ContentBuilder.INSTANCE;
          localObject5 = ContentBuilder.readFromFission(paramFissionAdapter, null, (String)localObject5, paramFissionTransaction);
          if (localObject5 == null) {
            break label1105;
          }
          bool5 = true;
        }
        label946:
        bool6 = bool5;
        if (i == 1)
        {
          localObject5 = ContentBuilder.INSTANCE;
          localObject5 = ContentBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject6, null, paramFissionTransaction);
          if (localObject5 == null) {
            break label1111;
          }
        }
      }
    }
    label1021:
    label1027:
    label1033:
    label1039:
    label1045:
    label1051:
    label1057:
    label1063:
    label1069:
    label1075:
    label1081:
    label1087:
    label1093:
    label1099:
    label1105:
    label1111:
    for (boolean bool6 = true;; bool6 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject6);
      }
      if (!bool7) {
        paramString = Collections.emptyList();
      }
      if (bool8) {
        break label1117;
      }
      throw new IOException("Failed to find required field: legoTrackingToken when reading com.linkedin.android.pegasus.gen.voyager.feed.CrossPromoUpdate from fission.");
      bool8 = false;
      break;
      bool9 = false;
      break label431;
      bool2 = false;
      break label476;
      bool1 = false;
      break label538;
      bool1 = false;
      break label567;
      bool3 = false;
      break label579;
      bool2 = false;
      break label641;
      bool2 = false;
      break label670;
      bool4 = false;
      break label682;
      bool3 = false;
      break label744;
      bool3 = false;
      break label773;
      bool5 = false;
      break label785;
      bool4 = false;
      break label847;
      bool4 = false;
      break label876;
      bool5 = false;
      break label888;
      bool5 = false;
      break label946;
    }
    label1117:
    if (!bool9) {
      throw new IOException("Failed to find required field: legoTrackingId when reading com.linkedin.android.pegasus.gen.voyager.feed.CrossPromoUpdate from fission.");
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: header when reading com.linkedin.android.pegasus.gen.voyager.feed.CrossPromoUpdate from fission.");
    }
    if (!bool2) {
      throw new IOException("Failed to find required field: actor when reading com.linkedin.android.pegasus.gen.voyager.feed.CrossPromoUpdate from fission.");
    }
    return new CrossPromoUpdate(paramString, str, (String)localObject7, (AnnotatedText)localObject1, (AppActor)localObject2, (AnnotatedText)localObject3, (AttributedText)localObject4, (CrossPromoUpdate.Content)localObject5, bool7, bool8, bool9, bool1, bool2, bool3, bool4, bool6);
  }
  
  public static final class ContentBuilder
    implements FissileDataModelBuilder<CrossPromoUpdate.Content>, DataTemplateBuilder<CrossPromoUpdate.Content>
  {
    public static final ContentBuilder INSTANCE = new ContentBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.voyager.feed.ShareArticle");
      JSON_KEY_STORE.put("com.linkedin.voyager.feed.ShareJob");
    }
    
    public static CrossPromoUpdate.Content build(DataReader paramDataReader)
      throws DataReaderException
    {
      Object localObject2 = null;
      Object localObject1 = null;
      boolean bool2 = false;
      boolean bool1 = false;
      paramDataReader.startRecord();
      while (paramDataReader.hasMoreFields$255f299()) {
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.ShareArticle", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = ShareArticleBuilder.INSTANCE;
          localObject2 = ShareArticleBuilder.build(paramDataReader);
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.feed.ShareJob", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = ShareJobBuilder.INSTANCE;
          localObject1 = ShareJobBuilder.build(paramDataReader);
          bool1 = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
      int i = 0;
      if (bool2) {
        i = 1;
      }
      if ((bool1) && (i != 0)) {
        throw new DataReaderException("Found more than 1 member when building .Content");
      }
      return new CrossPromoUpdate.Content((ShareArticle)localObject2, (ShareJob)localObject1, bool2, bool1);
    }
    
    public static CrossPromoUpdate.Content readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building CrossPromoUpdate.Content");
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
        throw new IOException("Invalid header prefix. Can't read cached data when building CrossPromoUpdate.Content");
      }
      Object localObject2 = localObject1;
      if (((ByteBuffer)localObject1).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("Invalid header prefix. Can't read cached data when building CrossPromoUpdate.Content");
      }
      if (((ByteBuffer)localObject2).getInt() != -1942903389)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
        throw new IOException("UID mismatch. Can't read cached data when building CrossPromoUpdate.Content");
      }
      paramString = null;
      ShareArticleBuilder localShareArticleBuilder = null;
      localObject1 = null;
      ShareJobBuilder localShareJobBuilder = null;
      boolean bool2;
      boolean bool1;
      if (((ByteBuffer)localObject2).get() == 1)
      {
        bool2 = true;
        bool1 = bool2;
        if (bool2)
        {
          i = ((ByteBuffer)localObject2).get();
          bool1 = bool2;
          paramString = localShareArticleBuilder;
          if (i == 0)
          {
            paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
            localShareArticleBuilder = ShareArticleBuilder.INSTANCE;
            paramString = ShareArticleBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label455;
            }
            bool1 = true;
          }
          label277:
          if (i == 1)
          {
            paramString = ShareArticleBuilder.INSTANCE;
            paramString = ShareArticleBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
            if (paramString == null) {
              break label461;
            }
            bool1 = true;
          }
        }
        label303:
        if (((ByteBuffer)localObject2).get() != 1) {
          break label467;
        }
        bool2 = true;
        label315:
        bool3 = bool2;
        if (bool2)
        {
          i = ((ByteBuffer)localObject2).get();
          localObject1 = localShareJobBuilder;
          if (i == 0)
          {
            localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
            localShareJobBuilder = ShareJobBuilder.INSTANCE;
            localObject1 = ShareJobBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
            if (localObject1 == null) {
              break label473;
            }
            bool2 = true;
          }
          label373:
          bool3 = bool2;
          if (i == 1)
          {
            localObject1 = ShareJobBuilder.INSTANCE;
            localObject1 = ShareJobBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
            if (localObject1 == null) {
              break label479;
            }
          }
        }
      }
      label455:
      label461:
      label467:
      label473:
      label479:
      for (boolean bool3 = true;; bool3 = false)
      {
        if (paramByteBuffer == null) {
          paramFissionAdapter.recycle((ByteBuffer)localObject2);
        }
        i = 0;
        if (bool1) {
          i = 1;
        }
        if ((!bool3) || (i == 0)) {
          break label485;
        }
        throw new IOException("Found more than 1 member when reading .Content from fission.");
        bool2 = false;
        break;
        bool1 = false;
        break label277;
        bool1 = false;
        break label303;
        bool2 = false;
        break label315;
        bool2 = false;
        break label373;
      }
      label485:
      return new CrossPromoUpdate.Content(paramString, (ShareJob)localObject1, bool1, bool3);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.CrossPromoUpdateBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */