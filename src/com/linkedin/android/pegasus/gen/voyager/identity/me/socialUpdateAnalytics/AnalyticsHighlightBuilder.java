package com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class AnalyticsHighlightBuilder
  implements FissileDataModelBuilder<AnalyticsHighlight>, DataTemplateBuilder<AnalyticsHighlight>
{
  public static final AnalyticsHighlightBuilder INSTANCE = new AnalyticsHighlightBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("value");
    JSON_KEY_STORE.put("trackingId");
    JSON_KEY_STORE.put("objectUrn");
  }
  
  public static AnalyticsHighlight build(DataReader paramDataReader)
    throws DataReaderException
  {
    Object localObject2 = null;
    String str = null;
    Object localObject1 = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("value", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject2 = ValueBuilder.INSTANCE;
        localObject2 = ValueBuilder.build(paramDataReader);
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("trackingId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        str = paramDataReader.readString();
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("objectUrn", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject1 = UrnCoercer.INSTANCE;
        localObject1 = UrnCoercer.coerceToCustomType(paramDataReader.readString());
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: value when building com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.AnalyticsHighlight");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: trackingId when building com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.AnalyticsHighlight");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: objectUrn when building com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.AnalyticsHighlight");
    }
    return new AnalyticsHighlight((AnalyticsHighlight.Value)localObject2, str, (Urn)localObject1, bool3, bool2, bool1);
  }
  
  public static AnalyticsHighlight readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building AnalyticsHighlight");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building AnalyticsHighlight");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building AnalyticsHighlight");
    }
    if (((ByteBuffer)localObject1).getInt() != 979540423)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building AnalyticsHighlight");
    }
    paramString = null;
    ValueBuilder localValueBuilder = null;
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
        paramString = localValueBuilder;
        bool1 = bool2;
        if (i == 0)
        {
          paramString = paramFissionAdapter.readString((ByteBuffer)localObject1);
          localValueBuilder = ValueBuilder.INSTANCE;
          paramString = ValueBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
          if (paramString == null) {
            break label400;
          }
          bool1 = true;
        }
        label277:
        if (i == 1)
        {
          paramString = ValueBuilder.INSTANCE;
          paramString = ValueBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject1, null, paramFissionTransaction);
          if (paramString == null) {
            break label406;
          }
          bool1 = true;
        }
      }
      label303:
      if (((ByteBuffer)localObject1).get() != 1) {
        break label412;
      }
      bool2 = true;
      label315:
      paramFissionTransaction = (FissionTransaction)localObject3;
      if (bool2) {
        paramFissionTransaction = paramFissionAdapter.readString((ByteBuffer)localObject1);
      }
      if (((ByteBuffer)localObject1).get() != 1) {
        break label418;
      }
    }
    label400:
    label406:
    label412:
    label418:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (bool3)
      {
        localObject2 = UrnCoercer.INSTANCE;
        localObject2 = UrnCoercer.coerceToCustomType(paramFissionAdapter.readString((ByteBuffer)localObject1));
      }
      if (paramByteBuffer == null) {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
      }
      if (bool1) {
        break label424;
      }
      throw new IOException("Failed to find required field: value when reading com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.AnalyticsHighlight from fission.");
      bool2 = false;
      break;
      bool1 = false;
      break label277;
      bool1 = false;
      break label303;
      bool2 = false;
      break label315;
    }
    label424:
    if (!bool2) {
      throw new IOException("Failed to find required field: trackingId when reading com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.AnalyticsHighlight from fission.");
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: objectUrn when reading com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.AnalyticsHighlight from fission.");
    }
    return new AnalyticsHighlight(paramString, paramFissionTransaction, (Urn)localObject2, bool1, bool2, bool3);
  }
  
  public static final class ValueBuilder
    implements FissileDataModelBuilder<AnalyticsHighlight.Value>, DataTemplateBuilder<AnalyticsHighlight.Value>
  {
    public static final ValueBuilder INSTANCE = new ValueBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.voyager.identity.me.socialUpdateAnalytics.CompanyHighlight");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.me.socialUpdateAnalytics.OccupationHighlight");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.me.socialUpdateAnalytics.RegionHighlight");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.me.socialUpdateAnalytics.ViewReferrerSourceHighlight");
    }
    
    public static AnalyticsHighlight.Value build(DataReader paramDataReader)
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
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.me.socialUpdateAnalytics.CompanyHighlight", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject4 = CompanyHighlightBuilder.INSTANCE;
          localObject4 = CompanyHighlightBuilder.build(paramDataReader);
          bool4 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.me.socialUpdateAnalytics.OccupationHighlight", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject3 = OccupationHighlightBuilder.INSTANCE;
          localObject3 = OccupationHighlightBuilder.build(paramDataReader);
          bool3 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.me.socialUpdateAnalytics.RegionHighlight", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = RegionHighlightBuilder.INSTANCE;
          localObject2 = RegionHighlightBuilder.build(paramDataReader);
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.me.socialUpdateAnalytics.ViewReferrerSourceHighlight", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = ViewReferrerSourceHighlightBuilder.INSTANCE;
          localObject1 = ViewReferrerSourceHighlightBuilder.build(paramDataReader);
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
          throw new DataReaderException("Found more than 1 member when building .Value");
        }
        i = 1;
      }
      j = i;
      if (bool2)
      {
        if (i != 0) {
          throw new DataReaderException("Found more than 1 member when building .Value");
        }
        j = 1;
      }
      if ((bool1) && (j != 0)) {
        throw new DataReaderException("Found more than 1 member when building .Value");
      }
      return new AnalyticsHighlight.Value((CompanyHighlight)localObject4, (OccupationHighlight)localObject3, (RegionHighlight)localObject2, (ViewReferrerSourceHighlight)localObject1, bool4, bool3, bool2, bool1);
    }
    
    public static AnalyticsHighlight.Value readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building AnalyticsHighlight.Value");
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
        throw new IOException("Invalid header prefix. Can't read cached data when building AnalyticsHighlight.Value");
      }
      Object localObject4 = localObject1;
      if (((ByteBuffer)localObject1).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("Invalid header prefix. Can't read cached data when building AnalyticsHighlight.Value");
      }
      if (((ByteBuffer)localObject4).getInt() != 1124942328)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject4);
        throw new IOException("UID mismatch. Can't read cached data when building AnalyticsHighlight.Value");
      }
      paramString = null;
      CompanyHighlightBuilder localCompanyHighlightBuilder = null;
      localObject1 = null;
      OccupationHighlightBuilder localOccupationHighlightBuilder = null;
      Object localObject2 = null;
      RegionHighlightBuilder localRegionHighlightBuilder = null;
      Object localObject3 = null;
      ViewReferrerSourceHighlightBuilder localViewReferrerSourceHighlightBuilder = null;
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
          paramString = localCompanyHighlightBuilder;
          bool1 = bool2;
          if (i == 0)
          {
            paramString = paramFissionAdapter.readString((ByteBuffer)localObject4);
            localCompanyHighlightBuilder = CompanyHighlightBuilder.INSTANCE;
            paramString = CompanyHighlightBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label677;
            }
            bool1 = true;
          }
          if (i == 1)
          {
            paramString = CompanyHighlightBuilder.INSTANCE;
            paramString = CompanyHighlightBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
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
          localObject1 = localOccupationHighlightBuilder;
          bool2 = bool3;
          if (i == 0)
          {
            localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject4);
            localOccupationHighlightBuilder = OccupationHighlightBuilder.INSTANCE;
            localObject1 = OccupationHighlightBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
            if (localObject1 == null) {
              break label695;
            }
            bool2 = true;
          }
          if (i == 1)
          {
            localObject1 = OccupationHighlightBuilder.INSTANCE;
            localObject1 = OccupationHighlightBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
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
          localObject2 = localRegionHighlightBuilder;
          bool3 = bool4;
          if (i == 0)
          {
            localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject4);
            localRegionHighlightBuilder = RegionHighlightBuilder.INSTANCE;
            localObject2 = RegionHighlightBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
            if (localObject2 == null) {
              break label713;
            }
            bool3 = true;
          }
          label492:
          if (i == 1)
          {
            localObject2 = RegionHighlightBuilder.INSTANCE;
            localObject2 = RegionHighlightBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
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
          localObject3 = localViewReferrerSourceHighlightBuilder;
          if (i == 0)
          {
            localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject4);
            localViewReferrerSourceHighlightBuilder = ViewReferrerSourceHighlightBuilder.INSTANCE;
            localObject3 = ViewReferrerSourceHighlightBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
            if (localObject3 == null) {
              break label731;
            }
            bool4 = true;
          }
          label591:
          bool5 = bool4;
          if (i == 1)
          {
            localObject3 = ViewReferrerSourceHighlightBuilder.INSTANCE;
            localObject3 = ViewReferrerSourceHighlightBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject4, null, paramFissionTransaction);
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
        throw new IOException("Found more than 1 member when reading .Value from fission.");
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
          throw new IOException("Found more than 1 member when reading .Value from fission.");
        }
        j = 1;
      }
      if ((bool5) && (j != 0)) {
        throw new IOException("Found more than 1 member when reading .Value from fission.");
      }
      return new AnalyticsHighlight.Value(paramString, (OccupationHighlight)localObject1, (RegionHighlight)localObject2, (ViewReferrerSourceHighlight)localObject3, bool1, bool2, bool3, bool5);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.socialUpdateAnalytics.AnalyticsHighlightBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */