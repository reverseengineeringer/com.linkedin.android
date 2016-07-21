package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.annotation.AnnotatedText;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.annotation.AnnotatedTextBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SnippetBuilder
  implements FissileDataModelBuilder<Snippet>, DataTemplateBuilder<Snippet>
{
  public static final SnippetBuilder INSTANCE = new SnippetBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("fieldType");
    JSON_KEY_STORE.put("heading");
    JSON_KEY_STORE.put("body");
  }
  
  public static Snippet build(DataReader paramDataReader)
    throws DataReaderException
  {
    SnippetField localSnippetField = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("fieldType", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localSnippetField = (SnippetField)paramDataReader.readEnum(SnippetField.Builder.INSTANCE);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("heading", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = AnnotatedTextBuilder.INSTANCE;
        localObject2 = AnnotatedTextBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("body", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = AnnotatedTextBuilder.INSTANCE;
        localObject1 = AnnotatedTextBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: fieldType when building com.linkedin.android.pegasus.gen.voyager.search.Snippet");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: body when building com.linkedin.android.pegasus.gen.voyager.search.Snippet");
    }
    return new Snippet(localSnippetField, (AnnotatedText)localObject2, (AnnotatedText)localObject1, bool3, bool2, bool1);
  }
  
  public static Snippet readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Snippet");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building Snippet");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building Snippet");
    }
    if (((ByteBuffer)localObject2).getInt() != 627946130)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building Snippet");
    }
    SnippetField localSnippetField = null;
    paramString = null;
    AnnotatedTextBuilder localAnnotatedTextBuilder2 = null;
    localObject1 = null;
    AnnotatedTextBuilder localAnnotatedTextBuilder1 = null;
    boolean bool4;
    boolean bool2;
    label253:
    boolean bool1;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool4 = true;
      if (bool4) {
        localSnippetField = SnippetField.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2));
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label472;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = localAnnotatedTextBuilder2;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localAnnotatedTextBuilder2 = AnnotatedTextBuilder.INSTANCE;
          paramString = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label478;
          }
          bool1 = true;
        }
        label310:
        if (i == 1)
        {
          paramString = AnnotatedTextBuilder.INSTANCE;
          paramString = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label484;
          }
          bool1 = true;
        }
      }
      label336:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label490;
      }
      bool2 = true;
      label348:
      bool3 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        localObject1 = localAnnotatedTextBuilder1;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localAnnotatedTextBuilder1 = AnnotatedTextBuilder.INSTANCE;
          localObject1 = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label496;
          }
          bool2 = true;
        }
        label406:
        bool3 = bool2;
        if (i == 1)
        {
          localObject1 = AnnotatedTextBuilder.INSTANCE;
          localObject1 = AnnotatedTextBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label502;
          }
        }
      }
    }
    label472:
    label478:
    label484:
    label490:
    label496:
    label502:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (bool4) {
        break label508;
      }
      throw new IOException("Failed to find required field: fieldType when reading com.linkedin.android.pegasus.gen.voyager.search.Snippet from fission.");
      bool4 = false;
      break;
      bool2 = false;
      break label253;
      bool1 = false;
      break label310;
      bool1 = false;
      break label336;
      bool2 = false;
      break label348;
      bool2 = false;
      break label406;
    }
    label508:
    if (!bool3) {
      throw new IOException("Failed to find required field: body when reading com.linkedin.android.pegasus.gen.voyager.search.Snippet from fission.");
    }
    return new Snippet(localSnippetField, paramString, (AnnotatedText)localObject1, bool4, bool1, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SnippetBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */