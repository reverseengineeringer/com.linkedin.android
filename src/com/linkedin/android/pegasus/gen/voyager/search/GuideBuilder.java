package com.linkedin.android.pegasus.gen.voyager.search;

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

public final class GuideBuilder
  implements FissileDataModelBuilder<Guide>, DataTemplateBuilder<Guide>
{
  public static final GuideBuilder INSTANCE = new GuideBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("urlParameter");
    JSON_KEY_STORE.put("displayText");
    JSON_KEY_STORE.put("selected");
    JSON_KEY_STORE.put("type");
    JSON_KEY_STORE.put("guideInfo");
  }
  
  public static Guide build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str2 = null;
    String str1 = null;
    boolean bool6 = false;
    GuideType localGuideType = null;
    Object localObject = null;
    boolean bool5 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("urlParameter", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("displayText", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("selected", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        bool6 = paramDataReader.readBoolean();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("type", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localGuideType = (GuideType)paramDataReader.readEnum(GuideType.Builder.INSTANCE);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("guideInfo", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = GuideInfoBuilder.INSTANCE;
        localObject = GuideInfoBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool5) {
      throw new DataReaderException("Failed to find required field: urlParameter when building com.linkedin.android.pegasus.gen.voyager.search.Guide");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: displayText when building com.linkedin.android.pegasus.gen.voyager.search.Guide");
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: selected when building com.linkedin.android.pegasus.gen.voyager.search.Guide");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: type when building com.linkedin.android.pegasus.gen.voyager.search.Guide");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: guideInfo when building com.linkedin.android.pegasus.gen.voyager.search.Guide");
    }
    return new Guide(str2, str1, bool6, localGuideType, (Guide.GuideInfo)localObject, bool5, bool3, bool4, bool2, bool1);
  }
  
  public static Guide readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Guide");
    }
    Object localObject2 = paramByteBuffer;
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
          localObject1 = paramString;
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
      throw new IOException("Invalid header prefix. Can't read cached data when building Guide");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building Guide");
    }
    if (((ByteBuffer)localObject1).getInt() != -65969463)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building Guide");
    }
    localObject2 = null;
    String str = null;
    boolean bool3 = false;
    GuideType localGuideType = null;
    paramString = null;
    GuideInfoBuilder localGuideInfoBuilder = null;
    boolean bool4;
    boolean bool5;
    label253:
    boolean bool6;
    label280:
    label297:
    boolean bool7;
    label309:
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool4 = true;
      if (bool4) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label455;
      }
      bool5 = true;
      if (bool5) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label461;
      }
      bool6 = true;
      if (bool6)
      {
        if (((ByteBuffer)localObject1).get() != 1) {
          break label467;
        }
        bool3 = true;
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label473;
      }
      bool7 = true;
      if (bool7) {
        localGuideType = GuideType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject1));
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label479;
      }
      bool1 = true;
      label339:
      bool2 = bool1;
      if (bool1)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = localGuideInfoBuilder;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localGuideInfoBuilder = GuideInfoBuilder.INSTANCE;
          paramString = GuideInfoBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label485;
          }
          bool1 = true;
        }
        label392:
        bool2 = bool1;
        if (i == 1)
        {
          paramString = GuideInfoBuilder.INSTANCE;
          paramString = GuideInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label491;
          }
        }
      }
    }
    label455:
    label461:
    label467:
    label473:
    label479:
    label485:
    label491:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool4) {
        break label497;
      }
      throw new IOException("Failed to find required field: urlParameter when reading com.linkedin.android.pegasus.gen.voyager.search.Guide from fission.");
      bool4 = false;
      break;
      bool5 = false;
      break label253;
      bool6 = false;
      break label280;
      bool3 = false;
      break label297;
      bool7 = false;
      break label309;
      bool1 = false;
      break label339;
      bool1 = false;
      break label392;
    }
    label497:
    if (!bool5) {
      throw new IOException("Failed to find required field: displayText when reading com.linkedin.android.pegasus.gen.voyager.search.Guide from fission.");
    }
    if (!bool6) {
      throw new IOException("Failed to find required field: selected when reading com.linkedin.android.pegasus.gen.voyager.search.Guide from fission.");
    }
    if (!bool7) {
      throw new IOException("Failed to find required field: type when reading com.linkedin.android.pegasus.gen.voyager.search.Guide from fission.");
    }
    if (!bool2) {
      throw new IOException("Failed to find required field: guideInfo when reading com.linkedin.android.pegasus.gen.voyager.search.Guide from fission.");
    }
    return new Guide((String)localObject2, str, bool3, localGuideType, paramString, bool4, bool5, bool6, bool7, bool2);
  }
  
  public static final class GuideInfoBuilder
    implements FissileDataModelBuilder<Guide.GuideInfo>, DataTemplateBuilder<Guide.GuideInfo>
  {
    public static final GuideInfoBuilder INSTANCE = new GuideInfoBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.voyager.search.FacetGuide");
      JSON_KEY_STORE.put("com.linkedin.voyager.search.VerticalGuide");
    }
    
    public static Guide.GuideInfo build(DataReader paramDataReader)
      throws DataReaderException
    {
      Object localObject2 = null;
      Object localObject1 = null;
      boolean bool2 = false;
      boolean bool1 = false;
      paramDataReader.startRecord();
      while (paramDataReader.hasMoreFields$255f299()) {
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.search.FacetGuide", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = FacetGuideBuilder.INSTANCE;
          localObject2 = FacetGuideBuilder.build(paramDataReader);
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.search.VerticalGuide", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = VerticalGuideBuilder.INSTANCE;
          localObject1 = VerticalGuideBuilder.build(paramDataReader);
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
        throw new DataReaderException("Found more than 1 member when building .GuideInfo");
      }
      return new Guide.GuideInfo((FacetGuide)localObject2, (VerticalGuide)localObject1, bool2, bool1);
    }
    
    public static Guide.GuideInfo readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building Guide.GuideInfo");
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
        throw new IOException("Invalid header prefix. Can't read cached data when building Guide.GuideInfo");
      }
      Object localObject2 = localObject1;
      if (((ByteBuffer)localObject1).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("Invalid header prefix. Can't read cached data when building Guide.GuideInfo");
      }
      if (((ByteBuffer)localObject2).getInt() != -1449374883)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
        throw new IOException("UID mismatch. Can't read cached data when building Guide.GuideInfo");
      }
      paramString = null;
      FacetGuideBuilder localFacetGuideBuilder = null;
      localObject1 = null;
      VerticalGuideBuilder localVerticalGuideBuilder = null;
      boolean bool2;
      boolean bool1;
      if (((ByteBuffer)localObject2).get() == 1)
      {
        bool2 = true;
        bool1 = bool2;
        if (bool2)
        {
          i = ((ByteBuffer)localObject2).get();
          paramString = localFacetGuideBuilder;
          bool1 = bool2;
          if (i == 0)
          {
            paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
            localFacetGuideBuilder = FacetGuideBuilder.INSTANCE;
            paramString = FacetGuideBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label455;
            }
            bool1 = true;
          }
          label277:
          if (i == 1)
          {
            paramString = FacetGuideBuilder.INSTANCE;
            paramString = FacetGuideBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
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
          localObject1 = localVerticalGuideBuilder;
          if (i == 0)
          {
            localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
            localVerticalGuideBuilder = VerticalGuideBuilder.INSTANCE;
            localObject1 = VerticalGuideBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
            if (localObject1 == null) {
              break label473;
            }
            bool2 = true;
          }
          label373:
          bool3 = bool2;
          if (i == 1)
          {
            localObject1 = VerticalGuideBuilder.INSTANCE;
            localObject1 = VerticalGuideBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
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
        throw new IOException("Found more than 1 member when reading .GuideInfo from fission.");
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
      return new Guide.GuideInfo(paramString, (VerticalGuide)localObject1, bool1, bool3);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.GuideBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */