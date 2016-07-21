package com.linkedin.android.pegasus.gen.voyager.typeahead;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.GroupMembershipInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.GroupMembershipInfoBuilder;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroupBuilder;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class TypeaheadGroupBuilder
  implements FissileDataModelBuilder<TypeaheadGroup>, DataTemplateBuilder<TypeaheadGroup>
{
  public static final TypeaheadGroupBuilder INSTANCE = new TypeaheadGroupBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("id");
    JSON_KEY_STORE.put("backendUrn");
    JSON_KEY_STORE.put("group");
    JSON_KEY_STORE.put("membershipInfo");
  }
  
  public static TypeaheadGroup build(DataReader paramDataReader)
    throws DataReaderException
  {
    String str = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("id", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("backendUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("group", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = MiniGroupBuilder.INSTANCE;
        localObject2 = MiniGroupBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("membershipInfo", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = GroupMembershipInfoBuilder.INSTANCE;
        localObject1 = GroupMembershipInfoBuilder.build(paramDataReader);
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool4) {
      throw new DataReaderException("Failed to find required field: id when building com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadGroup");
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: backendUrn when building com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadGroup");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: group when building com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadGroup");
    }
    return new TypeaheadGroup(str, (Urn)localObject3, (MiniGroup)localObject2, (GroupMembershipInfo)localObject1, bool4, bool3, bool2, bool1);
  }
  
  public static TypeaheadGroup readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building TypeaheadGroup");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building TypeaheadGroup");
    }
    Object localObject2 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building TypeaheadGroup");
    }
    if (((ByteBuffer)localObject2).getInt() != -273836478)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("UID mismatch. Can't read cached data when building TypeaheadGroup");
    }
    String str = null;
    Object localObject3 = null;
    paramString = null;
    MiniGroupBuilder localMiniGroupBuilder = null;
    localObject1 = null;
    GroupMembershipInfoBuilder localGroupMembershipInfoBuilder = null;
    boolean bool4;
    boolean bool5;
    label253:
    boolean bool2;
    label288:
    boolean bool1;
    if (((ByteBuffer)localObject2).get() == 1)
    {
      bool4 = true;
      if (bool4) {
        str = paramFissionAdapter.readString((ByteBuffer)localObject2);
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label507;
      }
      bool5 = true;
      if (bool5)
      {
        localObject3 = UrnCoercer.INSTANCE;
        localObject3 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject2));
      }
      if (((ByteBuffer)localObject2).get() != 1) {
        break label513;
      }
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        paramString = localMiniGroupBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localMiniGroupBuilder = MiniGroupBuilder.INSTANCE;
          paramString = MiniGroupBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label519;
          }
          bool1 = true;
        }
        label345:
        if (i == 1)
        {
          paramString = MiniGroupBuilder.INSTANCE;
          paramString = MiniGroupBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (paramString == null) {
            break label525;
          }
          bool1 = true;
        }
      }
      label371:
      if (((ByteBuffer)localObject2).get() != 1) {
        break label531;
      }
      bool2 = true;
      label383:
      bool3 = bool2;
      if (bool2)
      {
        i = ((ByteBuffer)localObject2).get();
        localObject1 = localGroupMembershipInfoBuilder;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject2);
          localGroupMembershipInfoBuilder = GroupMembershipInfoBuilder.INSTANCE;
          localObject1 = GroupMembershipInfoBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label537;
          }
          bool2 = true;
        }
        label441:
        bool3 = bool2;
        if (i == 1)
        {
          localObject1 = GroupMembershipInfoBuilder.INSTANCE;
          localObject1 = GroupMembershipInfoBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject2, null, paramFissionTransaction);
          if (localObject1 == null) {
            break label543;
          }
        }
      }
    }
    label507:
    label513:
    label519:
    label525:
    label531:
    label537:
    label543:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject2);
      }
      if (bool4) {
        break label549;
      }
      throw new IOException("Failed to find required field: id when reading com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadGroup from fission.");
      bool4 = false;
      break;
      bool5 = false;
      break label253;
      bool2 = false;
      break label288;
      bool1 = false;
      break label345;
      bool1 = false;
      break label371;
      bool2 = false;
      break label383;
      bool2 = false;
      break label441;
    }
    label549:
    if (!bool5) {
      throw new IOException("Failed to find required field: backendUrn when reading com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadGroup from fission.");
    }
    if (!bool1) {
      throw new IOException("Failed to find required field: group when reading com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadGroup from fission.");
    }
    return new TypeaheadGroup(str, (Urn)localObject3, paramString, (GroupMembershipInfo)localObject1, bool4, bool5, bool1, bool3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadGroupBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */