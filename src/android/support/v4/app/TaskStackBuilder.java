package android.support.v4.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class TaskStackBuilder
  implements Iterable<Intent>
{
  private static final TaskStackBuilderImpl IMPL = new TaskStackBuilderImplBase();
  private final ArrayList<Intent> mIntents = new ArrayList();
  public final Context mSourceContext;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      IMPL = new TaskStackBuilderImplHoneycomb();
      return;
    }
  }
  
  private TaskStackBuilder(Context paramContext)
  {
    mSourceContext = paramContext;
  }
  
  public static TaskStackBuilder create(Context paramContext)
  {
    return new TaskStackBuilder(paramContext);
  }
  
  public final TaskStackBuilder addNextIntent(Intent paramIntent)
  {
    mIntents.add(paramIntent);
    return this;
  }
  
  public final TaskStackBuilder addNextIntentWithParentStack(Intent paramIntent)
  {
    ComponentName localComponentName2 = paramIntent.getComponent();
    ComponentName localComponentName1 = localComponentName2;
    if (localComponentName2 == null) {
      localComponentName1 = paramIntent.resolveActivity(mSourceContext.getPackageManager());
    }
    if (localComponentName1 != null) {
      addParentStack(localComponentName1);
    }
    addNextIntent(paramIntent);
    return this;
  }
  
  public final TaskStackBuilder addParentStack(ComponentName paramComponentName)
  {
    int i = mIntents.size();
    try
    {
      for (paramComponentName = NavUtils.getParentActivityIntent(mSourceContext, paramComponentName); paramComponentName != null; paramComponentName = NavUtils.getParentActivityIntent(mSourceContext, paramComponentName.getComponent())) {
        mIntents.add(i, paramComponentName);
      }
      return this;
    }
    catch (PackageManager.NameNotFoundException paramComponentName)
    {
      Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
      throw new IllegalArgumentException(paramComponentName);
    }
  }
  
  public final Iterator<Intent> iterator()
  {
    return mIntents.iterator();
  }
  
  public final void startActivities()
  {
    if (mIntents.isEmpty()) {
      throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }
    Object localObject = (Intent[])mIntents.toArray(new Intent[mIntents.size()]);
    localObject[0] = new Intent(localObject[0]).addFlags(268484608);
    if (!ContextCompat.startActivities$5b3ef247(mSourceContext, (Intent[])localObject))
    {
      localObject = new Intent(localObject[(localObject.length - 1)]);
      ((Intent)localObject).addFlags(268435456);
      mSourceContext.startActivity((Intent)localObject);
    }
  }
  
  public static abstract interface SupportParentable
  {
    public abstract Intent getSupportParentActivityIntent();
  }
  
  static abstract interface TaskStackBuilderImpl {}
  
  static final class TaskStackBuilderImplBase
    implements TaskStackBuilder.TaskStackBuilderImpl
  {}
  
  static final class TaskStackBuilderImplHoneycomb
    implements TaskStackBuilder.TaskStackBuilderImpl
  {}
}

/* Location:
 * Qualified Name:     android.support.v4.app.TaskStackBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */