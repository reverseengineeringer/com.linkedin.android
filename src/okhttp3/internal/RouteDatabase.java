package okhttp3.internal;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.Route;

public final class RouteDatabase
{
  private final Set<Route> failedRoutes = new LinkedHashSet();
  
  public final void connected(Route paramRoute)
  {
    try
    {
      failedRoutes.remove(paramRoute);
      return;
    }
    finally
    {
      paramRoute = finally;
      throw paramRoute;
    }
  }
  
  public final void failed(Route paramRoute)
  {
    try
    {
      failedRoutes.add(paramRoute);
      return;
    }
    finally
    {
      paramRoute = finally;
      throw paramRoute;
    }
  }
  
  public final boolean shouldPostpone(Route paramRoute)
  {
    try
    {
      boolean bool = failedRoutes.contains(paramRoute);
      return bool;
    }
    finally
    {
      paramRoute = finally;
      throw paramRoute;
    }
  }
}

/* Location:
 * Qualified Name:     okhttp3.internal.RouteDatabase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */