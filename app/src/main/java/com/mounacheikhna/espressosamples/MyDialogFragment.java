package com.mounacheikhna.espressosamples;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by cheikhnamouna on 12/27/15.
 */
public class MyDialogFragment extends DialogFragment {

  public MyDialogFragment() {
  }

  public static MyDialogFragment newInstance(String title) {
    MyDialogFragment frag = new MyDialogFragment();
    Bundle args = new Bundle();
    args.putString("title", title);
    frag.setArguments(args);
    return frag;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_dialog, container);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    String title = getArguments().getString("title", "Dialog");
    getDialog().setTitle(title);

    Spinner spinner = (Spinner) view.findViewById(R.id.planets_spinner);
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
        R.array.planets_array, android.R.layout.simple_spinner_item);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner.setAdapter(adapter);

    Button okButton = (Button) view.findViewById(R.id.ok_dialog);
    okButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        dismiss();
      }
    });
  }

}
