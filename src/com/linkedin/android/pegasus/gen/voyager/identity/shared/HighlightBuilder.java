package com.linkedin.android.pegasus.gen.voyager.identity.shared;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.networkHighlights.NetworkHighlight;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.networkHighlights.NetworkHighlightBuilder;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.ProfileHighlight;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.ProfileHighlightBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class HighlightBuilder
  implements FissileDataModelBuilder<Highlight>, DataTemplateBuilder<Highlight>
{
  public static final HighlightBuilder INSTANCE = new HighlightBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("detail");
    JSON_KEY_STORE.put("highlightUrn");
    JSON_KEY_STORE.put("trackingId");
  }
  
  public static Highlight build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject2 = null;
    Object localObject1 = null;
    String str = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("detail", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = DetailBuilder.INSTANCE;
        localObject2 = DetailBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("highlightUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = UrnCoercer.INSTANCE;
        localObject1 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("trackingId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: detail when building com.linkedin.android.pegasus.gen.voyager.identity.shared.Highlight");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: highlightUrn when building com.linkedin.android.pegasus.gen.voyager.identity.shared.Highlight");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: trackingId when building com.linkedin.android.pegasus.gen.voyager.identity.shared.Highlight");
    }
    return new Highlight((Highlight.Detail)localObject2, (Urn)localObject1, str, bool3, bool2, bool1);
  }
  
  public static Highlight readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building Highlight");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building Highlight");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building Highlight");
    }
    if (((ByteBuffer)localObject1).getInt() != -849332407)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building Highlight");
    }
    paramString = null;
    DetailBuilder localDetailBuilder = null;
    Object localObject3 = null;
    localObject2 = null;
    boolean bool2;
    boolean bool1;
    if (((ByteBuffer)localObject1).get() == 1)
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject1).get();
        paramString = localDetailBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localDetailBuilder = DetailBuilder.INSTANCE;
          paramString = DetailBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label399;
          }
          bool1 = true;
        }
        label277:
        if (i == 1)
        {
          paramString = DetailBuilder.INSTANCE;
          paramString = DetailBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label405;
          }
          bool1 = true;
        }
      }
      label303:
      if (((ByteBuffer)localObject1).get() != 1) {
        break label411;
      }
      bool2 = true;
      label315:
      paramFissionTransaction = (FissionTransaction)localObject3;
      if (bool2)
      {
        paramFissionTransaction = UrnCoercer.INSTANCE;
        paramFissionTransaction = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject1));
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label417;
      }
    }
    label399:
    label405:
    label411:
    label417:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (bool3) {
        localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool1) {
        break label423;
      }
      throw new IOException("Failed to find required field: detail when reading com.linkedin.android.pegasus.gen.voyager.identity.shared.Highlight from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label277;
      bool1 = false;
      break label303;
      bool2 = false;
      break label315;
    }
    label423:
    if (!bool2) {
      throw new IOException("Failed to find required field: highlightUrn when reading com.linkedin.android.pegasus.gen.voyager.identity.shared.Highlight from fission.");
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: trackingId when reading com.linkedin.android.pegasus.gen.voyager.identity.shared.Highlight from fission.");
    }
    return new Highlight(paramString, paramFissionTransaction, (String)localObject2, bool1, bool2, bool3);
  }
  
  public static final class DetailBuilder
    implements FissileDataModelBuilder<Highlight.Detail>, DataTemplateBuilder<Highlight.Detail>
  {
    public static final DetailBuilder INSTANCE = new DetailBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.voyager.identity.shared.profileHighlights.ProfileHighlight");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.shared.networkHighlights.NetworkHighlight");
    }
    
    public static Highlight.Detail build(DataReader paramDataReader)
      throws DataReaderException
    {
      Object localObject1 = null;
      Object localObject2 = null;
      boolean bool1 = false;
      boolean bool2 = false;
      paramDataReader.startRecord();
      while (paramDataReader.hasMoreFields$255f299()) {
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.shared.profileHighlights.ProfileHighlight", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = ProfileHighlightBuilder.INSTANCE;
          localObject1 = ProfileHighlightBuilder.build(paramDataReader);
          bool1 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.shared.networkHighlights.NetworkHighlight", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = NetworkHighlightBuilder.INSTANCE;
          localObject2 = NetworkHighlightBuilder.build(paramDataReader);
          bool2 = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
      int i = 0;
      if (bool1) {
        i = 1;
      }
      if ((bool2) && (i != 0)) {
        throw new DataReaderException("Found more than 1 member when building .Detail");
      }
      return new Highlight.Detail((ProfileHighlight)localObject1, (NetworkHighlight)localObject2, bool1, bool2);
    }
    
    public static Highlight.Detail readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building Highlight.Detail");
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
        throw new IOException("Invalid header prefix. Can't read cached data when building Highlight.Detail");
      }
      Object localObject2 = localObject1;
      if (((ByteBuffer)localObject1).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("Invalid header prefix. Can't read cached data when building Highlight.Detail");
      }
      if (((ByteBuffer)localObject2).getInt() != -1140694555)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
        throw new IOException("UID mismatch. Can't read cached data when building Highlight.Detail");
      }
      paramString = null;
      ProfileHighlightBuilder localProfileHighlightBuilder = null;
      localObject1 = null;
      NetworkHighlightBuilder localNetworkHighlightBuilder = null;
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
          paramString = localProfileHighlightBuilder;
          if (i == 0)
          {
            paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
            localProfileHighlightBuilder = ProfileHighlightBuilder.INSTANCE;
            paramString = ProfileHighlightBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label455;
            }
            bool1 = true;
          }
          label277:
          if (i == 1)
          {
            paramString = ProfileHighlightBuilder.INSTANCE;
            paramString = ProfileHighlightBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
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
          localObject1 = localNetworkHighlightBuilder;
          if (i == 0)
          {
            localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
            localNetworkHighlightBuilder = NetworkHighlightBuilder.INSTANCE;
            localObject1 = NetworkHighlightBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
            if (localObject1 == null) {
              break label473;
            }
            bool2 = true;
          }
          label373:
          bool3 = bool2;
          if (i == 1)
          {
            localObject1 = NetworkHighlightBuilder.INSTANCE;
            localObject1 = NetworkHighlightBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
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
        throw new IOException("Found more than 1 member when reading .Detail from fission.");
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
      return new Highlight.Detail(paramString, (NetworkHighlight)localObject1, bool1, bool3);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.shared.HighlightBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */