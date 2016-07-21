package com.linkedin.android.pegasus.gen.voyager.relationships.shared.annotation;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
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

public final class AnnotatedTextBuilder
  implements FissileDataModelBuilder<AnnotatedText>, DataTemplateBuilder<AnnotatedText>
{
  public static final AnnotatedTextBuilder INSTANCE = new AnnotatedTextBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("text");
    JSON_KEY_STORE.put("annotations");
  }
  
  public static AnnotatedText build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str = null;
    Object localObject = null;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("text", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("annotations", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            AnnotationBuilder localAnnotationBuilder = AnnotationBuilder.INSTANCE;
            ((List)localObject).add(AnnotationBuilder.build(paramDataReader));
          }
        }
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool1) {
      str = "";
    }
    if (!bool2) {
      localObject = Collections.emptyList();
    }
    return new AnnotatedText(str, (List)localObject, bool1, bool2);
  }
  
  public static AnnotatedText readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building AnnotatedText");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building AnnotatedText");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building AnnotatedText");
    }
    if (((ByteBuffer)localObject2).getInt() != 854774837)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building AnnotatedText");
    }
    paramString = null;
    localObject1 = null;
    boolean bool1;
    boolean bool2;
    label240:
    ArrayList localArrayList;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool1 = true;
      if (bool1) {
        paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label383;
      }
      bool2 = true;
      if (!bool2) {
        break label401;
      }
      j = paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject2);
      localArrayList = new ArrayList();
      label264:
      localObject1 = localArrayList;
      if (j <= 0) {
        break label401;
      }
      localObject1 = null;
      i = 1;
      int k = ((ByteBuffer)localObject2).get();
      if (k == 0)
      {
        localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
        AnnotationBuilder localAnnotationBuilder = AnnotationBuilder.INSTANCE;
        localObject1 = AnnotationBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
        if (localObject1 == null) {
          break label389;
        }
        i = 1;
      }
      label324:
      if (k == 1)
      {
        localObject1 = AnnotationBuilder.INSTANCE;
        localObject1 = AnnotationBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
        if (localObject1 == null) {
          break label395;
        }
      }
    }
    label383:
    label389:
    label395:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localArrayList.add(localObject1);
      }
      j -= 1;
      break label264;
      bool1 = false;
      break;
      bool2 = false;
      break label240;
      i = 0;
      break label324;
    }
    label401:
    if (paramByteBuffer == null) {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
    }
    if (!bool1) {
      paramString = "";
    }
    if (!bool2) {
      localObject1 = Collections.emptyList();
    }
    return new AnnotatedText(paramString, (List)localObject1, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.relationships.shared.annotation.AnnotatedTextBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */