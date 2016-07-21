package com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview;

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

public final class WvmpInsightCardBuilder
  implements FissileDataModelBuilder<WvmpInsightCard>, DataTemplateBuilder<WvmpInsightCard>
{
  public static final WvmpInsightCardBuilder INSTANCE = new WvmpInsightCardBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("value");
    JSON_KEY_STORE.put("trackingId");
    JSON_KEY_STORE.put("objectUrn");
  }
  
  public static WvmpInsightCard build(DataReader paramDataReader)
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
      throw new DataReaderException("Failed to find required field: value when building com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpInsightCard");
    }
    if (!bool2) {
      throw new DataReaderException("Failed to find required field: trackingId when building com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpInsightCard");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: objectUrn when building com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpInsightCard");
    }
    return new WvmpInsightCard((WvmpInsightCard.Value)localObject2, str, (Urn)localObject1, bool3, bool2, bool1);
  }
  
  public static WvmpInsightCard readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    if ((paramByteBuffer == null) && (paramString == null)) {
      throw new IOException("Cannot read without at least one of key or input byteBuffer when building WvmpInsightCard");
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
      throw new IOException("Invalid header prefix. Can't read cached data when building WvmpInsightCard");
    }
    Object localObject1 = localObject2;
    if (((ByteBuffer)localObject2).get() != 1)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject2);
      throw new IOException("Invalid header prefix. Can't read cached data when building WvmpInsightCard");
    }
    if (((ByteBuffer)localObject1).getInt() != -1949925093)
    {
      paramFissionAdapter.recycle((ByteBuffer)localObject1);
      throw new IOException("UID mismatch. Can't read cached data when building WvmpInsightCard");
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
      throw new IOException("Failed to find required field: value when reading com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpInsightCard from fission.");
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
      throw new IOException("Failed to find required field: trackingId when reading com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpInsightCard from fission.");
    }
    if (!bool3) {
      throw new IOException("Failed to find required field: objectUrn when reading com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpInsightCard from fission.");
    }
    return new WvmpInsightCard(paramString, paramFissionTransaction, (Urn)localObject2, bool1, bool2, bool3);
  }
  
  public static final class ValueBuilder
    implements FissileDataModelBuilder<WvmpInsightCard.Value>, DataTemplateBuilder<WvmpInsightCard.Value>
  {
    public static final ValueBuilder INSTANCE = new ValueBuilder();
    private static final JsonKeyStore JSON_KEY_STORE;
    
    static
    {
      HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
      JSON_KEY_STORE = localHashStringKeyStore;
      localHashStringKeyStore.put("com.linkedin.voyager.identity.me.wvmpOverview.WvmpSummaryInsightCard");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.me.wvmpOverview.WvmpCompanyInsightCard");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.me.wvmpOverview.WvmpJobTitleInsightCard");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.me.wvmpOverview.WvmpSourceInsightCard");
      JSON_KEY_STORE.put("com.linkedin.voyager.identity.me.wvmpOverview.WvmpOnboardingCard");
    }
    
    public static WvmpInsightCard.Value build(DataReader paramDataReader)
      throws DataReaderException
    {
      Object localObject5 = null;
      Object localObject4 = null;
      Object localObject3 = null;
      Object localObject2 = null;
      Object localObject1 = null;
      boolean bool5 = false;
      boolean bool4 = false;
      boolean bool3 = false;
      boolean bool2 = false;
      boolean bool1 = false;
      paramDataReader.startRecord();
      while (paramDataReader.hasMoreFields$255f299()) {
        if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.me.wvmpOverview.WvmpSummaryInsightCard", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject5 = WvmpSummaryInsightCardBuilder.INSTANCE;
          localObject5 = WvmpSummaryInsightCardBuilder.build(paramDataReader);
          bool5 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.me.wvmpOverview.WvmpCompanyInsightCard", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject4 = WvmpCompanyInsightCardBuilder.INSTANCE;
          localObject4 = WvmpCompanyInsightCardBuilder.build(paramDataReader);
          bool4 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.me.wvmpOverview.WvmpJobTitleInsightCard", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject3 = WvmpJobTitleInsightCardBuilder.INSTANCE;
          localObject3 = WvmpJobTitleInsightCardBuilder.build(paramDataReader);
          bool3 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.me.wvmpOverview.WvmpSourceInsightCard", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject2 = WvmpSourceInsightCardBuilder.INSTANCE;
          localObject2 = WvmpSourceInsightCardBuilder.build(paramDataReader);
          bool2 = true;
        }
        else if (paramDataReader.shouldReadField$11ca93e7("com.linkedin.voyager.identity.me.wvmpOverview.WvmpOnboardingCard", JSON_KEY_STORE))
        {
          paramDataReader.startField();
          localObject1 = WvmpOnboardingCardBuilder.INSTANCE;
          localObject1 = WvmpOnboardingCardBuilder.build(paramDataReader);
          bool1 = true;
        }
        else
        {
          paramDataReader.skipField();
        }
      }
      int j = 0;
      if (bool5) {
        j = 1;
      }
      int i = j;
      if (bool4)
      {
        if (j != 0) {
          throw new DataReaderException("Found more than 1 member when building .Value");
        }
        i = 1;
      }
      j = i;
      if (bool3)
      {
        if (i != 0) {
          throw new DataReaderException("Found more than 1 member when building .Value");
        }
        j = 1;
      }
      i = j;
      if (bool2)
      {
        if (j != 0) {
          throw new DataReaderException("Found more than 1 member when building .Value");
        }
        i = 1;
      }
      if ((bool1) && (i != 0)) {
        throw new DataReaderException("Found more than 1 member when building .Value");
      }
      return new WvmpInsightCard.Value((WvmpSummaryInsightCard)localObject5, (WvmpCompanyInsightCard)localObject4, (WvmpJobTitleInsightCard)localObject3, (WvmpSourceInsightCard)localObject2, (WvmpOnboardingCard)localObject1, bool5, bool4, bool3, bool2, bool1);
    }
    
    public static WvmpInsightCard.Value readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
      throws IOException
    {
      if ((paramByteBuffer == null) && (paramString == null)) {
        throw new IOException("Cannot read without at least one of key or input byteBuffer when building WvmpInsightCard.Value");
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
            localObject5 = paramString;
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
        throw new IOException("Invalid header prefix. Can't read cached data when building WvmpInsightCard.Value");
      }
      Object localObject5 = localObject1;
      if (((ByteBuffer)localObject1).get() != 1)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject1);
        throw new IOException("Invalid header prefix. Can't read cached data when building WvmpInsightCard.Value");
      }
      if (((ByteBuffer)localObject5).getInt() != 383855860)
      {
        paramFissionAdapter.recycle((ByteBuffer)localObject5);
        throw new IOException("UID mismatch. Can't read cached data when building WvmpInsightCard.Value");
      }
      paramString = null;
      WvmpSummaryInsightCardBuilder localWvmpSummaryInsightCardBuilder = null;
      localObject1 = null;
      WvmpCompanyInsightCardBuilder localWvmpCompanyInsightCardBuilder = null;
      Object localObject2 = null;
      WvmpJobTitleInsightCardBuilder localWvmpJobTitleInsightCardBuilder = null;
      Object localObject3 = null;
      WvmpSourceInsightCardBuilder localWvmpSourceInsightCardBuilder = null;
      Object localObject4 = null;
      WvmpOnboardingCardBuilder localWvmpOnboardingCardBuilder = null;
      boolean bool2;
      boolean bool1;
      label295:
      label321:
      boolean bool3;
      label333:
      label395:
      label424:
      boolean bool4;
      label436:
      label498:
      label527:
      boolean bool5;
      if (((ByteBuffer)localObject5).get() == 1)
      {
        bool2 = true;
        bool1 = bool2;
        if (bool2)
        {
          i = ((ByteBuffer)localObject5).get();
          paramString = localWvmpSummaryInsightCardBuilder;
          bool1 = bool2;
          if (i == 0)
          {
            paramString = paramFissionAdapter.readString((ByteBuffer)localObject5);
            localWvmpSummaryInsightCardBuilder = WvmpSummaryInsightCardBuilder.INSTANCE;
            paramString = WvmpSummaryInsightCardBuilder.readFromFission(paramFissionAdapter, null, paramString, paramFissionTransaction);
            if (paramString == null) {
              break label786;
            }
            bool1 = true;
          }
          if (i == 1)
          {
            paramString = WvmpSummaryInsightCardBuilder.INSTANCE;
            paramString = WvmpSummaryInsightCardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
            if (paramString == null) {
              break label792;
            }
            bool1 = true;
          }
        }
        if (((ByteBuffer)localObject5).get() != 1) {
          break label798;
        }
        bool3 = true;
        bool2 = bool3;
        if (bool3)
        {
          i = ((ByteBuffer)localObject5).get();
          localObject1 = localWvmpCompanyInsightCardBuilder;
          bool2 = bool3;
          if (i == 0)
          {
            localObject1 = paramFissionAdapter.readString((ByteBuffer)localObject5);
            localWvmpCompanyInsightCardBuilder = WvmpCompanyInsightCardBuilder.INSTANCE;
            localObject1 = WvmpCompanyInsightCardBuilder.readFromFission(paramFissionAdapter, null, (String)localObject1, paramFissionTransaction);
            if (localObject1 == null) {
              break label804;
            }
            bool2 = true;
          }
          if (i == 1)
          {
            localObject1 = WvmpCompanyInsightCardBuilder.INSTANCE;
            localObject1 = WvmpCompanyInsightCardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
            if (localObject1 == null) {
              break label810;
            }
            bool2 = true;
          }
        }
        if (((ByteBuffer)localObject5).get() != 1) {
          break label816;
        }
        bool4 = true;
        bool3 = bool4;
        if (bool4)
        {
          i = ((ByteBuffer)localObject5).get();
          localObject2 = localWvmpJobTitleInsightCardBuilder;
          bool3 = bool4;
          if (i == 0)
          {
            localObject2 = paramFissionAdapter.readString((ByteBuffer)localObject5);
            localWvmpJobTitleInsightCardBuilder = WvmpJobTitleInsightCardBuilder.INSTANCE;
            localObject2 = WvmpJobTitleInsightCardBuilder.readFromFission(paramFissionAdapter, null, (String)localObject2, paramFissionTransaction);
            if (localObject2 == null) {
              break label822;
            }
            bool3 = true;
          }
          if (i == 1)
          {
            localObject2 = WvmpJobTitleInsightCardBuilder.INSTANCE;
            localObject2 = WvmpJobTitleInsightCardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
            if (localObject2 == null) {
              break label828;
            }
            bool3 = true;
          }
        }
        if (((ByteBuffer)localObject5).get() != 1) {
          break label834;
        }
        bool5 = true;
        label539:
        bool4 = bool5;
        if (bool5)
        {
          i = ((ByteBuffer)localObject5).get();
          localObject3 = localWvmpSourceInsightCardBuilder;
          bool4 = bool5;
          if (i == 0)
          {
            localObject3 = paramFissionAdapter.readString((ByteBuffer)localObject5);
            localWvmpSourceInsightCardBuilder = WvmpSourceInsightCardBuilder.INSTANCE;
            localObject3 = WvmpSourceInsightCardBuilder.readFromFission(paramFissionAdapter, null, (String)localObject3, paramFissionTransaction);
            if (localObject3 == null) {
              break label840;
            }
            bool4 = true;
          }
          label601:
          if (i == 1)
          {
            localObject3 = WvmpSourceInsightCardBuilder.INSTANCE;
            localObject3 = WvmpSourceInsightCardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
            if (localObject3 == null) {
              break label846;
            }
            bool4 = true;
          }
        }
        label630:
        if (((ByteBuffer)localObject5).get() != 1) {
          break label852;
        }
        bool5 = true;
        label642:
        bool6 = bool5;
        if (bool5)
        {
          i = ((ByteBuffer)localObject5).get();
          localObject4 = localWvmpOnboardingCardBuilder;
          if (i == 0)
          {
            localObject4 = paramFissionAdapter.readString((ByteBuffer)localObject5);
            localWvmpOnboardingCardBuilder = WvmpOnboardingCardBuilder.INSTANCE;
            localObject4 = WvmpOnboardingCardBuilder.readFromFission(paramFissionAdapter, null, (String)localObject4, paramFissionTransaction);
            if (localObject4 == null) {
              break label858;
            }
            bool5 = true;
          }
          label700:
          bool6 = bool5;
          if (i == 1)
          {
            localObject4 = WvmpOnboardingCardBuilder.INSTANCE;
            localObject4 = WvmpOnboardingCardBuilder.readFromFission(paramFissionAdapter, (ByteBuffer)localObject5, null, paramFissionTransaction);
            if (localObject4 == null) {
              break label864;
            }
          }
        }
      }
      label786:
      label792:
      label798:
      label804:
      label810:
      label816:
      label822:
      label828:
      label834:
      label840:
      label846:
      label852:
      label858:
      label864:
      for (boolean bool6 = true;; bool6 = false)
      {
        if (paramByteBuffer == null) {
          paramFissionAdapter.recycle((ByteBuffer)localObject5);
        }
        j = 0;
        if (bool1) {
          j = 1;
        }
        i = j;
        if (!bool2) {
          break label873;
        }
        if (j == 0) {
          break label870;
        }
        throw new IOException("Found more than 1 member when reading .Value from fission.");
        bool2 = false;
        break;
        bool1 = false;
        break label295;
        bool1 = false;
        break label321;
        bool3 = false;
        break label333;
        bool2 = false;
        break label395;
        bool2 = false;
        break label424;
        bool4 = false;
        break label436;
        bool3 = false;
        break label498;
        bool3 = false;
        break label527;
        bool5 = false;
        break label539;
        bool4 = false;
        break label601;
        bool4 = false;
        break label630;
        bool5 = false;
        break label642;
        bool5 = false;
        break label700;
      }
      label870:
      int i = 1;
      label873:
      int j = i;
      if (bool3)
      {
        if (i != 0) {
          throw new IOException("Found more than 1 member when reading .Value from fission.");
        }
        j = 1;
      }
      i = j;
      if (bool4)
      {
        if (j != 0) {
          throw new IOException("Found more than 1 member when reading .Value from fission.");
        }
        i = 1;
      }
      if ((bool6) && (i != 0)) {
        throw new IOException("Found more than 1 member when reading .Value from fission.");
      }
      return new WvmpInsightCard.Value(paramString, (WvmpCompanyInsightCard)localObject1, (WvmpJobTitleInsightCard)localObject2, (WvmpSourceInsightCard)localObject3, (WvmpOnboardingCard)localObject4, bool1, bool2, bool3, bool4, bool6);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.wvmpOverview.WvmpInsightCardBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */