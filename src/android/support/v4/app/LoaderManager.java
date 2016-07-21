package android.support.v4.app;

import android.support.v4.content.Loader;

public abstract class LoaderManager
{
  public abstract void destroyLoader$13462e();
  
  public abstract <D> Loader<D> getLoader$5cca27bb();
  
  public boolean hasRunningLoaders()
  {
    return false;
  }
  
  public abstract <D> Loader<D> initLoader$71be8de6(LoaderCallbacks<D> paramLoaderCallbacks);
  
  public abstract <D> Loader<D> restartLoader$71be8de6(LoaderCallbacks<D> paramLoaderCallbacks);
  
  public static abstract interface LoaderCallbacks<D>
  {
    public abstract Loader<D> onCreateLoader$e57f803(int paramInt);
    
    public abstract void onLoadFinished$13079eae(D paramD);
    
    public abstract void onLoaderReset$5dda1f52();
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.LoaderManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */