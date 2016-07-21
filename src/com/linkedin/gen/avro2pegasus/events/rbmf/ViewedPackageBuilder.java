package com.linkedin.gen.avro2pegasus.events.rbmf;

import com.linkedin.data.lite.DataReader;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;
import com.linkedin.gen.avro2pegasus.events.common.GridPosition;
import com.linkedin.gen.avro2pegasus.events.common.GridPositionBuilder;
import java.util.ArrayList;
import java.util.List;

public final class ViewedPackageBuilder
  implements DataTemplateBuilder<ViewedPackage>
{
  public static final ViewedPackageBuilder INSTANCE = new ViewedPackageBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("packageId");
    JSON_KEY_STORE.put("packageType");
    JSON_KEY_STORE.put("packageScreenPosition");
    JSON_KEY_STORE.put("packageFlowPosition");
    JSON_KEY_STORE.put("packageGridPosition");
    JSON_KEY_STORE.put("entities");
  }
  
  public static ViewedPackage build(DataReader paramDataReader)
    throws DataReaderException
  {
    int k = 0;
    PackageRecommendationType localPackageRecommendationType = null;
    int j = 0;
    int i = 0;
    Object localObject = null;
    ArrayList localArrayList = null;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    paramDataReader.startRecord();
    while (paramDataReader.hasMoreFields$255f299()) {
      if (paramDataReader.shouldReadField$11ca93e7("packageId", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        k = paramDataReader.readInt();
        bool6 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("packageType", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localPackageRecommendationType = (PackageRecommendationType)paramDataReader.readEnum(PackageRecommendationType.Builder.INSTANCE);
        bool5 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("packageScreenPosition", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        j = paramDataReader.readInt();
        bool4 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("packageFlowPosition", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        i = paramDataReader.readInt();
        bool3 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("packageGridPosition", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localObject = GridPositionBuilder.INSTANCE;
        localObject = GridPositionBuilder.build(paramDataReader);
        bool2 = true;
      }
      else if (paramDataReader.shouldReadField$11ca93e7("entities", JSON_KEY_STORE))
      {
        paramDataReader.startField();
        localArrayList = new ArrayList();
        if (paramDataReader.isStartOfArray()) {
          while (paramDataReader.hasMoreArrayElements$255f299())
          {
            RecommendedEntityBuilder localRecommendedEntityBuilder = RecommendedEntityBuilder.INSTANCE;
            localArrayList.add(RecommendedEntityBuilder.build(paramDataReader));
          }
        }
        bool1 = true;
      }
      else
      {
        paramDataReader.skipField();
      }
    }
    if (!bool3) {
      throw new DataReaderException("Failed to find required field: packageFlowPosition when building com.linkedin.gen.avro2pegasus.events.rbmf.ViewedPackage");
    }
    if (!bool1) {
      throw new DataReaderException("Failed to find required field: entities when building com.linkedin.gen.avro2pegasus.events.rbmf.ViewedPackage");
    }
    return new ViewedPackage(k, localPackageRecommendationType, j, i, (GridPosition)localObject, localArrayList, bool6, bool5, bool4, bool3, bool2, bool1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.rbmf.ViewedPackageBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */