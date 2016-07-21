package com.conviva.session;

import java.util.List;
import java.util.Map;

public final class EventQueue
{
  List<Map<String, Object>> _events = null;
  private int _nextSeqNumber = 0;
  
  public final void enqueueEvent(String paramString, Map<String, Object> paramMap, int paramInt)
  {
    paramMap.put("t", paramString);
    paramMap.put("st", Integer.valueOf(paramInt));
    paramMap.put("seq", Integer.valueOf(_nextSeqNumber));
    _nextSeqNumber += 1;
    _events.add(paramMap);
  }
}

/* Location:
 * Qualified Name:     com.conviva.session.EventQueue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */