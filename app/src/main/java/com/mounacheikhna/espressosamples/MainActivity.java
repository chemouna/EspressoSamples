package com.mounacheikhna.espressosamples;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button showDialogButton = (Button) findViewById(R.id.show_dialog);
    //TODO: show this dialog after click
    showDialogButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        showDialog();
      }
    });
  }

  private void showDialog() {
    FragmentManager fm = getFragmentManager();
    MyDialogFragment dialogFragment = MyDialogFragment.newInstance("Some Title");
    dialogFragment.show(fm, "fragment_dialog");
  }

}
