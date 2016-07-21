package com.linkedin.android.growth.abi;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class AbiAdapter<T extends ViewModel>
  extends ViewModelArrayAdapter<T>
  implements Filterable
{
  private final List<T> contactsList;
  private final Context context;
  
  public AbiAdapter(Context paramContext, MediaCenter paramMediaCenter, List<T> paramList)
  {
    super(paramContext, paramMediaCenter, paramList);
    context = paramContext;
    contactsList = paramList;
  }
  
  public final Filter getFilter()
  {
    return new AbiResultFilter(context.getResources().getConfiguration().locale, this, contactsList);
  }
  
  static final class AbiResultFilter<T extends ViewModel>
    extends Filter
  {
    private AbiAdapter adapter;
    List<T> filteredList;
    private Locale locale;
    private List<T> originalList;
    
    AbiResultFilter(Locale paramLocale, AbiAdapter paramAbiAdapter, List<T> paramList)
    {
      locale = paramLocale;
      adapter = paramAbiAdapter;
      originalList = paramList;
      filteredList = new ArrayList();
    }
    
    protected final Filter.FilterResults performFiltering(CharSequence paramCharSequence)
    {
      filteredList.clear();
      Filter.FilterResults localFilterResults = new Filter.FilterResults();
      if (paramCharSequence.length() == 0) {
        filteredList.addAll(originalList);
      }
      for (;;)
      {
        values = filteredList;
        count = filteredList.size();
        return localFilterResults;
        paramCharSequence = paramCharSequence.toString().toLowerCase(locale).trim();
        Iterator localIterator = originalList.iterator();
        while (localIterator.hasNext())
        {
          ViewModel localViewModel = (ViewModel)localIterator.next();
          if (localViewModel.toString().toLowerCase(locale).trim().contains(paramCharSequence)) {
            filteredList.add(localViewModel);
          }
        }
      }
    }
    
    protected final void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
    {
      adapter.setValues((ArrayList)values);
      adapter.notifyDataSetChanged();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */