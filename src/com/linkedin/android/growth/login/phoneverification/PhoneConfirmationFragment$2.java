package com.linkedin.android.growth.login.phoneverification;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import com.linkedin.android.liauthlib.registration.CountryDialingCodeMap;
import com.linkedin.android.pegasus.gen.voyager.common.Country;
import com.linkedin.android.tracking.v2.event.PageViewEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class PhoneConfirmationFragment$2
  implements View.OnClickListener
{
  PhoneConfirmationFragment$2(PhoneConfirmationFragment paramPhoneConfirmationFragment) {}
  
  public final void onClick(View paramView)
  {
    PhoneConfirmationFragment localPhoneConfirmationFragment = this$0;
    dialingCodeChanged = newDialingCode.equalsIgnoreCase(dialingCode);
    new PageViewEvent(tracker, "wwe_code_typeahead", false).send();
    CountrySelectorManager localCountrySelectorManager = countrySelectorManager;
    paramView = countriesList;
    EditText localEditText = countrySelector;
    Object localObject1 = new AlertDialog.Builder(activity);
    Object localObject2 = (ScrollView)activity.findViewById(2131756163);
    localObject2 = activity.getLayoutInflater().inflate(2130968854, (ViewGroup)localObject2, false);
    ((AlertDialog.Builder)localObject1).setView((View)localObject2);
    AlertDialog localAlertDialog = ((AlertDialog.Builder)localObject1).show();
    ((Button)((View)localObject2).findViewById(2131756176)).setOnClickListener(new CountrySelectorManager.1(localCountrySelectorManager, localAlertDialog));
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramView.iterator();
    while (localIterator.hasNext())
    {
      paramView = (Country)localIterator.next();
      String str = countryName;
      localObject1 = (String)CountryDialingCodeMap.dialingCodeMap.get(countryCode);
      paramView = (View)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramView = "+1";
      }
      localObject1 = new CountryNameDialingCodeViewModel();
      countryName = str;
      dialingCode = paramView;
      listener = new CountryNameDialingCodeTransformer.1(localEditText, (CountryNameDialingCodeViewModel)localObject1, localAlertDialog);
      localArrayList.add(localObject1);
    }
    paramView = new ViewModelArrayAdapter(activity, applicationComponent.mediaCenter(), localArrayList);
    localObject1 = (RecyclerView)((View)localObject2).findViewById(2131756175);
    ((RecyclerView)localObject1).setLayoutManager(new LinearLayoutManager(activity));
    ((RecyclerView)localObject1).setAdapter(paramView);
    localAlertDialog.getWindow().setLayout(-1, -1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.phoneverification.PhoneConfirmationFragment.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */