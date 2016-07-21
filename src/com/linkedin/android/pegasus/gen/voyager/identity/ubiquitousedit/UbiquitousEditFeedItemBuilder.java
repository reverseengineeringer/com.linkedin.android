package com.linkedin.android.pegasus.gen.voyager.identity.ubiquitousedit;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.feed.HighlightedUpdateType;
import com.linkedin.android.pegasus.gen.voyager.feed.HighlightedUpdateType.Builder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class UbiquitousEditFeedItemBuilder
  implements FissileDataModelBuilder<UbiquitousEditFeedItem>, DataTemplateBuilder<UbiquitousEditFeedItem>
{
  public static final UbiquitousEditFeedItemBuilder INSTANCE = new UbiquitousEditFeedItemBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("highlightedContentUrn");
    JSON_KEY_STORE.put("cause");
  }
  
  public static UbiquitousEditFeedItem build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject = null;
    HighlightedUpdateType localHighlightedUpdateType = null;
    boolean bool1 = false;
    boolean bool2 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("highlightedContentUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = UrnCoercer.INSTANCE;
        localObject = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool1 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("cause", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localHighlightedUpdateType = (HighlightedUpdateType)paramDataReader.readEnum(HighlightedUpdateType.Builder.INSTANCE);
        bool2 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: highlightedContentUrn when building com.linkedin.android.pegasus.gen.voyager.identity.ubiquitousedit.UbiquitousEditFeedItem");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: cause when building com.linkedin.android.pegasus.gen.voyager.identity.ubiquitousedit.UbiquitousEditFeedItem");
    }
    return new UbiquitousEditFeedItem((Urn)localObject, localHighlightedUpdateType, bool1, bool2);
  }
  
  public static UbiquitousEditFeedItem readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    boolean bool2 = true;
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building UbiquitousEditFeedItem");
    }
    ByteBuffer localByteBuffer = paramByteBuffer;
    if (paramString != null)
    {
      paramString = paramFissionAdapter.readFromCache(paramString, paramFissionTransaction);
      if (paramString == null) {
        return null;
      }
      int i = paramString.get();
      int j;
      do
      {
        do
        {
          localObject = paramString;
          if (i != 0) {
            break label170;
          }
          localObject = paramFissionAdapter.readString(paramString);
          paramFissionAdapter.recycle(paramString);
          localObject = paramFissionAdapter.readFromCache((String)localObject, paramFissionTransaction);
          if (localObject == null) {
            break;
          }
          j = ((ByteBuffer)localObject).get();
          paramString = (String)localObject;
          i = j;
        } while (j == 1);
        paramString = (String)localObject;
        i = j;
      } while (j == 0);
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("Invalid header prefix. Can't read cached data when building UbiquitousEditFeedItem");
    }
    Object localObject = localByteBuffer;
    if (localByteBuffer.get() != 1)
    {
      paramFissionAdapter.recycle(localByteBuffer);
      throw new IOException("Invalid header prefix. Can't read cached data when building UbiquitousEditFeedItem");
    }
    label170:
    if (((ByteBuffer)localObject).getInt() != -1686635843)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject);
      throw new IOException("UID mismatch. Can't read cached data when building UbiquitousEditFeedItem");
    }
    paramString = null;
    paramFissionTransaction = null;
    boolean bool1;
    if (((ByteBuffer)localObject).get() == 1)
    {
      bool1 = true;
      if (bool1)
      {
        paramString = UrnCoercer.INSTANCE;
        paramString = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject));
      }
      if (((ByteBuffer)localObject).get() != 1) {
        break label294;
      }
    }
    for (;;)
    {
      if (bool2) {
        paramFissionTransaction = HighlightedUpdateType.of(paramFissionAdapter.readUnsignedShort((ByteBuffer)localObject));
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject);
      }
      if (bool1) {
        break label300;
      }
      throw new IOException("Failed to find required field: highlightedContentUrn when reading com.linkedin.android.pegasus.gen.voyager.identity.ubiquitousedit.UbiquitousEditFeedItem from fission.");
      bool1 = false;
      break;
      label294:
      bool2 = false;
    }
    label300:
    if (!bool2) {
      throw new IOException("Failed to find required field: cause when reading com.linkedin.android.pegasus.gen.voyager.identity.ubiquitousedit.UbiquitousEditFeedItem from fission.");
    }
    return new UbiquitousEditFeedItem(paramString, paramFissionTransaction, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.ubiquitousedit.UbiquitousEditFeedItemBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */