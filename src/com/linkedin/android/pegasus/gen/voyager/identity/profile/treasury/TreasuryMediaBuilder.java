package com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.MediaProxyImage;
import com.linkedin.android.pegasus.gen.voyager.common.MediaProxyImageBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class TreasuryMediaBuilder
  implements FissileDataModelBuilder<TreasuryMedia>, DataTemplateBuilder<TreasuryMedia>
{
  public static final TreasuryMediaBuilder INSTANCE = new TreasuryMediaBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("customTitle");
    JSON_KEY_STORE.put("customDescription");
    JSON_KEY_STORE.put("title");
    JSON_KEY_STORE.put("description");
    JSON_KEY_STORE.put("data");
  }
  
  public static TreasuryMedia build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject2 = null;
    String str4 = null;
    String str3 = null;
    String str2 = null;
    String str1 = null;
    Object localObject1 = null;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("entityUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = UrnCoercer.INSTANCE;
        localObject2 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("customTitle", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str4 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("customDescription", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("title", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("description", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str1 = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("data", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = DataBuilder.INSTANCE;
        localObject1 = DataBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: entityUrn when building com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.TreasuryMedia");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: data when building com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.TreasuryMedia");
    }
    return new TreasuryMedia((Urn)localObject2, str4, str3, str2, str1, (TreasuryMedia.Data)localObject1, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static TreasuryMedia readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building TreasuryMedia");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building TreasuryMedia");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building TreasuryMedia");
    }
    if (((ByteBuffer)localObject1).getInt() != -2080712291)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building TreasuryMedia");
    }
    localObject2 = null;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    paramString = null;
    DataBuilder localDataBuilder = null;
    boolean bool3;
    boolean bool4;
    label264:
    boolean bool5;
    label291:
    boolean bool6;
    label318:
    boolean bool7;
    label345:
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool3 = true;
      if (bool3)
      {
        localObject2 = UrnCoercer.INSTANCE;
        localObject2 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject1));
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label488;
      }
      bool4 = true;
      if (bool4) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label494;
      }
      bool5 = true;
      if (bool5) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label500;
      }
      bool6 = true;
      if (bool6) {
        str3 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label506;
      }
      bool7 = true;
      if (bool7) {
        str4 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label512;
      }
      bool1 = true;
      label372:
      bool2 = bool1;
      if (bool1)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = localDataBuilder;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localDataBuilder = DataBuilder.INSTANCE;
          paramString = DataBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label518;
          }
          bool1 = true;
        }
        label425:
        bool2 = bool1;
        if (i == 1)
        {
          paramString = DataBuilder.INSTANCE;
          paramString = DataBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label524;
          }
        }
      }
    }
    label488:
    label494:
    label500:
    label506:
    label512:
    label518:
    label524:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool3) {
        break label530;
      }
      throw new IOException("Failed to find required field: entityUrn when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.TreasuryMedia from fission.");
      bool3 = false;
      break;
      bool4 = false;
      break label264;
      bool5 = false;
      break label291;
      bool6 = false;
      break label318;
      bool7 = false;
      break label345;
      bool1 = false;
      break label372;
      bool1 = false;
      break label425;
    }
    label530:
    if (!bool2) {
      throw new IOException("Failed to find required field: data when reading com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.TreasuryMedia from fission.");
    }
    return new TreasuryMedia((Urn)localObject2, str1, str2, str3, str4, paramString, bool3, bool4, bool5, bool6, bool7, bool2);
  }
  
  public static final class DataBuilder
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.TreasuryMediaBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */