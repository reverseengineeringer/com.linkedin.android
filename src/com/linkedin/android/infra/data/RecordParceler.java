package com.linkedin.android.infra.data;

import android.os.Bundle;
import com.linkedin.android.datamanager.DataManager;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.DataTemplateParser;
import com.linkedin.data.lite.DataTemplateParserFactory;
import com.linkedin.data.lite.JsonGenerator;
import com.linkedin.data.lite.JsonGeneratorException;
import com.linkedin.data.lite.JsonGeneratorFactory;
import com.linkedin.data.lite.RecordTemplate;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class RecordParceler
{
  public static void parcel(RecordTemplate paramRecordTemplate, String paramString, Bundle paramBundle)
    throws JsonGeneratorException
  {
    StringWriter localStringWriter = new StringWriter();
    DataManager.GENERATOR_FACTORY.createJsonGenerator().generate(paramRecordTemplate, localStringWriter);
    paramBundle.putString(paramString, localStringWriter.toString());
  }
  
  public static <E extends RecordTemplate<E>> void parcelList(List<E> paramList, String paramString, Bundle paramBundle)
    throws JsonGeneratorException
  {
    JsonGenerator localJsonGenerator = DataManager.GENERATOR_FACTORY.createJsonGenerator();
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecordTemplate localRecordTemplate = (RecordTemplate)paramList.next();
      StringWriter localStringWriter = new StringWriter();
      localJsonGenerator.generate(localRecordTemplate, localStringWriter);
      localArrayList.add(localStringWriter.toString());
    }
    paramBundle.putStringArrayList(paramString, localArrayList);
  }
  
  public static void quietParcel(RecordTemplate paramRecordTemplate, String paramString, Bundle paramBundle)
  {
    try
    {
      parcel(paramRecordTemplate, paramString, paramBundle);
      return;
    }
    catch (JsonGeneratorException paramRecordTemplate)
    {
      Util.safeThrow(new RuntimeException("couldn't write to bundle", paramRecordTemplate));
    }
  }
  
  public static <E extends RecordTemplate<E>> E quietUnparcel(DataTemplateBuilder<E> paramDataTemplateBuilder, String paramString, Bundle paramBundle)
  {
    try
    {
      paramDataTemplateBuilder = unparcel(paramDataTemplateBuilder, paramString, paramBundle);
      return paramDataTemplateBuilder;
    }
    catch (DataReaderException paramDataTemplateBuilder)
    {
      Util.safeThrow(new RuntimeException("can't unparcel this", paramDataTemplateBuilder));
    }
    return null;
  }
  
  public static <E extends RecordTemplate<E>> E unparcel(DataTemplateBuilder<E> paramDataTemplateBuilder, String paramString, Bundle paramBundle)
    throws DataReaderException
  {
    paramString = paramBundle.getString(paramString);
    if (paramString == null) {
      return null;
    }
    return DataManager.PARSER_FACTORY.createParser().parseRecord(new ByteArrayInputStream(paramString.getBytes()), paramDataTemplateBuilder);
  }
  
  public static <E extends RecordTemplate<E>> List<E> unparcelList(DataTemplateBuilder<E> paramDataTemplateBuilder, String paramString, Bundle paramBundle)
    throws DataReaderException
  {
    paramString = paramBundle.getStringArrayList(paramString);
    if (paramString == null)
    {
      paramString = null;
      return paramString;
    }
    DataTemplateParser localDataTemplateParser = DataManager.PARSER_FACTORY.createParser();
    paramBundle = new ArrayList();
    Iterator localIterator = paramString.iterator();
    for (;;)
    {
      paramString = paramBundle;
      if (!localIterator.hasNext()) {
        break;
      }
      paramBundle.add(localDataTemplateParser.parseRecord(new ByteArrayInputStream(((String)localIterator.next()).getBytes()), paramDataTemplateBuilder));
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.data.RecordParceler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */