
package com.longngohoang.news.appcore.presentation2;

import android.app.Fragment;
import android.widget.Toast;

import com.fernandocejas.android10.sample.presentation.internal.di.HasComponent;


public abstract class BaseFragment extends Fragment {

  protected void showToastMessage(String message) {
    Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
  }


  @SuppressWarnings("unchecked")
  protected <C> C getComponent(Class<C> componentType) {
    return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
  }
}
