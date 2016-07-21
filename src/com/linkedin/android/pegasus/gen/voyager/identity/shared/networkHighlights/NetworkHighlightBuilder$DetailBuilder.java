package com.linkedin.android.pegasus.gen.voyager.identity.shared.networkHighlights;

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

public final class NetworkHighlightBuilder$DetailBuilder
  implements FissileDataModelBuilder<NetworkHighlight.Detail>, DataTemplateBuilder<NetworkHighlight.Detail>
{
  public static final DetailBuilder INSTANCE = new DetailBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("com.linkedin.voyager.identity.shared.networkHighlights.DescriptiveCompany");
    JSON_KEY_STORE.put("com.linkedin.voyager.identity.shared.networkHighlights.DescriptiveSchool");
    JSON_KEY_STORE.put("com.linkedin.voyager.identity.shared.networkHighlights.DescriptiveRegion");
    JSON_KEY_STORE.put("com.linkedin.voyager.identity.shared.networkHighlights.DescriptiveSeniorCompany");
  }
  
  public static NetworkHighlight.Detail build(DataReader paramDataReader)
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
      if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.shared.networkHighlights.DescriptiveCompany", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject4 = DescriptiveCompanyBuilder.INSTANCE;
        localObject4 = DescriptiveCompanyBuilder.build(paramDataReader);
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.shared.networkHighlights.DescriptiveSchool", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject3 = DescriptiveSchoolBuilder.INSTANCE;
        localObject3 = DescriptiveSchoolBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.shared.networkHighlights.DescriptiveRegion", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = DescriptiveRegionBuilder.INSTANCE;
        localObject2 = DescriptiveRegionBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.shared.networkHighlights.DescriptiveSeniorCompany", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = DescriptiveSeniorCompanyBuilder.INSTANCE;
        localObject1 = DescriptiveSeniorCompanyBuilder.build(paramDataReader);
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
        throw new DataReaderException("Found more than 1 member when building .Detail");
      }
      i = 1;
    }
    j = i;
    if (bool2)
    {
      if (i != 0) {
        throw new DataReaderException("Found more than 1 member when building .Detail");
      }
      j = 1;
    }
    if ((bool1) && (j != 0)) {
      throw new DataReaderException("Found more than 1 member when building .Detail");
    }
    return new NetworkHighlight.Detail((DescriptiveCompany)localObject4, (DescriptiveSchool)localObject3, (DescriptiveRegion)localObject2, (DescriptiveSeniorCompany)localObject1, bool4, bool3, bool2, bool1);
  }
  
  public static NetworkHighlight.Detail readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building NetworkHighlight.Detail");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building NetworkHighlight.Detail");
    }
    Object localObject4 = localObject1;
    if (((ByteBuffer)localObject1).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("Invalid header prefix. Can't read cached data when building NetworkHighlight.Detail");
    }
    if (((ByteBuffer)localObject4).getInt() != 1727971851)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject4);
      throw new IOException("UID mismatch. Can't read cached data when building NetworkHighlight.Detail");
    }
    paramString = null;
    DescriptiveCompanyBuilder localDescriptiveCompanyBuilder = null;
    localObject1 = null;
    DescriptiveSchoolBuilder localDescriptiveSchoolBuilder = null;
    Object localObject2 = null;
    DescriptiveRegionBuilder localDescriptiveRegionBuilder = null;
    Object localObject3 = null;
    DescriptiveSeniorCompanyBuilder localDescriptiveSeniorCompanyBuilder = null;
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
        paramString = localDescriptiveCompanyBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localDescriptiveCompanyBuilder = DescriptiveCompanyBuilder.INSTANCE;
          paramString = DescriptiveCompanyBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label677;
          }
          bool1 = true;
        }
        if (i == 1)
        {
          paramString = DescriptiveCompanyBuilder.INSTANCE;
          paramString = DescriptiveCompanyBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
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
        localObject1 = localDescriptiveSchoolBuilder;
        bool2 = bool3;
        if (i == 0)
        {
          localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localDescriptiveSchoolBuilder = DescriptiveSchoolBuilder.INSTANCE;
          localObject1 = DescriptiveSchoolBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
          if (localObject1 == null) {
            break label695;
          }
          bool2 = true;
        }
        if (i == 1)
        {
          localObject1 = DescriptiveSchoolBuilder.INSTANCE;
          localObject1 = DescriptiveSchoolBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
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
        localObject2 = localDescriptiveRegionBuilder;
        bool3 = bool4;
        if (i == 0)
        {
          localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localDescriptiveRegionBuilder = DescriptiveRegionBuilder.INSTANCE;
          localObject2 = DescriptiveRegionBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
          if (localObject2 == null) {
            break label713;
          }
          bool3 = true;
        }
        label492:
        if (i == 1)
        {
          localObject2 = DescriptiveRegionBuilder.INSTANCE;
          localObject2 = DescriptiveRegionBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
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
        localObject3 = localDescriptiveSeniorCompanyBuilder;
        if (i == 0)
        {
          localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject4);
          localDescriptiveSeniorCompanyBuilder = DescriptiveSeniorCompanyBuilder.INSTANCE;
          localObject3 = DescriptiveSeniorCompanyBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
          if (localObject3 == null) {
            break label731;
          }
          bool4 = true;
        }
        label591:
        bool5 = bool4;
        if (i == 1)
        {
          localObject3 = DescriptiveSeniorCompanyBuilder.INSTANCE;
          localObject3 = DescriptiveSeniorCompanyBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
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
      throw new IOException("Found more than 1 member when reading .Detail from fission.");
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
        throw new IOException("Found more than 1 member when reading .Detail from fission.");
      }
      j = 1;
    }
    if ((bool5) && (j != 0)) {
      throw new IOException("Found more than 1 member when reading .Detail from fission.");
    }
    return new NetworkHighlight.Detail(paramString, (DescriptiveSchool)localObject1, (DescriptiveRegion)localObject2, (DescriptiveSeniorCompany)localObject3, bool1, bool2, bool3, bool5);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.shared.networkHighlights.NetworkHighlightBuilder.DetailBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */