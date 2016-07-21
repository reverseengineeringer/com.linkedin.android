package com.linkedin.android.growth.calendar.sync;

import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.logger.Log;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class CalendarMetadata
{
  public final String accountName;
  public final String accountType;
  final String displayName;
  public final String name;
  public boolean shouldSync;
  
  public CalendarMetadata(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    accountType = paramString1;
    accountName = paramString2;
    name = paramString3;
    displayName = paramString4;
    shouldSync = paramBoolean;
  }
  
  private static CalendarMetadata fromJson(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = new CalendarMetadata(paramJSONObject.getString("accountType"), paramJSONObject.getString("accountName"), paramJSONObject.getString("name"), paramJSONObject.getString("displayName"), paramJSONObject.getBoolean("shouldSync"));
      return paramJSONObject;
    }
    catch (JSONException paramJSONObject)
    {
      Util.safeThrow$7a8b4789(new RuntimeException(paramJSONObject));
    }
    return null;
  }
  
  public static List<CalendarMetadata> fromPreferencesJson(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      if (i < paramJSONArray.length()) {
        try
        {
          CalendarMetadata localCalendarMetadata = fromJson(paramJSONArray.getJSONObject(i));
          if (localCalendarMetadata == null) {
            break label59;
          }
          localArrayList.add(localCalendarMetadata);
        }
        catch (JSONException localJSONException)
        {
          Log.e("CalendarMetadata", "Exception reading from JSONArray");
        }
      }
      return localArrayList;
      label59:
      i += 1;
    }
  }
  
  public final JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("accountType", accountType);
      localJSONObject.put("accountName", accountName);
      localJSONObject.put("name", name);
      localJSONObject.put("displayName", displayName);
      localJSONObject.put("shouldSync", shouldSync);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      Util.safeThrow$7a8b4789(new RuntimeException(localJSONException));
    }
    return localJSONObject;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.calendar.sync.CalendarMetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */