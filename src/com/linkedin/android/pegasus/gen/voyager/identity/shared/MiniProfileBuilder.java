package com.linkedin.android.pegasus.gen.voyager.identity.shared;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.common.ImageBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class MiniProfileBuilder
  implements FissileDataModelBuilder<MiniProfile>, DataTemplateBuilder<MiniProfile>
{
  public static final MiniProfileBuilder INSTANCE = new MiniProfileBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("trackingId");
    JSON_KEY_STORE.put("objectUrn");
    JSON_KEY_STORE.put("entityUrn");
    JSON_KEY_STORE.put("firstName");
    JSON_KEY_STORE.put("lastName");
    JSON_KEY_STORE.put("occupation");
    JSON_KEY_STORE.put("backgroundImage");
    JSON_KEY_STORE.put("picture");
    JSON_KEY_STORE.put("publicIdentifier");
  }
  
  public static MiniProfile build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str5 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    String str4 = null;
    String str3 = null;
    String str2 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    String str1 = null;
    boolean bool9 = false;
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
      if (paramDataReader.shouldReadField$11ca93e7("trackingId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str5 = paramDataReader.readString();
        bool9 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("objectUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = UrnCoercer.INSTANCE;
        localObject4 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool8 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("entityUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool7 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("firstName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str4 = paramDataReader.readString();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("lastName", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str3 = paramDataReader.readString();
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("occupation", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str2 = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("backgroundImage", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = ImageBuilder.INSTANCE;
        localObject2 = ImageBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("picture", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = ImageBuilder.INSTANCE;
        localObject1 = ImageBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("publicIdentifier", JSON_KEY_STORE))
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
    if (!bool7) {
      throw new DataReaderException("Failed to find required field: entityUrn when building com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile");
    }
    if (!bool6) {
      throw new DataReaderException("Failed to find required field: firstName when building com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: publicIdentifier when building com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile");
    }
    return new MiniProfile(str5, (Urn)localObject4, (Urn)localObject3, str4, str3, str2, (Image)localObject2, (Image)localObject1, str1, bool9, bool8, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public static MiniProfile readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building MiniProfile");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building MiniProfile");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building MiniProfile");
    }
    if (((ByteBuffer)localObject2).getInt() != -700805101)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building MiniProfile");
    }
    String str1 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    paramString = null;
    ImageBuilder localImageBuilder2 = null;
    localObject1 = null;
    ImageBuilder localImageBuilder1 = null;
    Object localObject5 = null;
    boolean bool4;
    boolean bool5;
    label268:
    boolean bool6;
    label303:
    boolean bool7;
    label338:
    boolean bool8;
    label365:
    boolean bool9;
    label392:
    boolean bool2;
    label419:
    boolean bool1;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool4 = true;
      if (bool4) {
        str1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label667;
      }
      bool5 = true;
      if (bool5)
      {
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject2));
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label673;
      }
      bool6 = true;
      if (bool6)
      {
        localObject4 = UrnCoercer.INSTANCE;
        localObject4 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject2));
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label679;
      }
      bool7 = true;
      if (bool7) {
        str2 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label685;
      }
      bool8 = true;
      if (bool8) {
        str3 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label691;
      }
      bool9 = true;
      if (bool9) {
        str4 = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label697;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = localImageBuilder2;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localImageBuilder2 = ImageBuilder.INSTANCE;
          paramString = ImageBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label703;
          }
          bool1 = true;
        }
        label476:
        if (i == 1)
        {
          paramString = ImageBuilder.INSTANCE;
          paramString = ImageBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label709;
          }
          bool1 = true;
        }
      }
      label502:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label715;
      }
      bool3 = true;
      label514:
      bool2 = bool3;
      if (bool3)
      {
        i = ((ByteBuffer)localObject2).get();
        localObject1 = localImageBuilder1;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localImageBuilder1 = ImageBuilder.INSTANCE;
          localObject1 = ImageBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label721;
          }
          bool2 = true;
        }
        label576:
        if (i == 1)
        {
          localObject1 = ImageBuilder.INSTANCE;
          localObject1 = ImageBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label727;
          }
          bool2 = true;
        }
      }
      label605:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label733;
      }
    }
    label667:
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
    for (boolean bool3 = true;; bool3 = false)
    {
      paramFissionTransaction = (FissionTransaction)localObject5;
      if (bool3) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (bool6) {
        break label739;
      }
      throw new IOException("Failed to find required field: entityUrn when reading com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile from fission.");
      bool4 = false;
      break;
      bool5 = false;
      break label268;
      bool6 = false;
      break label303;
      bool7 = false;
      break label338;
      bool8 = false;
      break label365;
      bool9 = false;
      break label392;
      bool2 = false;
      break label419;
      bool1 = false;
      break label476;
      bool1 = false;
      break label502;
      bool3 = false;
      break label514;
      bool2 = false;
      break label576;
      bool2 = false;
      break label605;
    }
    label739:
    if (!bool7) {
      throw new IOException("Failed to find required field: firstName when reading com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile from fission.");
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: publicIdentifier when reading com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile from fission.");
    }
    return new MiniProfile(str1, (Urn)localObject3, (Urn)localObject4, str2, str3, str4, paramString, (Image)localObject1, paramFissionTransaction, bool4, bool5, bool6, bool7, bool8, bool9, bool1, bool2, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfileBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */