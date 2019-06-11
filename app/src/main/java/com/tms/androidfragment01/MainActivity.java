package com.tms.androidfragment01;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements Fragment1.OnFragmentInteractionListener, Fragment2.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openFragment(View view) {
        Fragment1 frag = new Fragment1();
        Bundle arg = new Bundle();
        arg.putString("text" , "Passing String to Fragment");
        arg.putInt("number" , 10);
        frag.setArguments(arg);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, frag)
                .commit();
    }


    //to pass data to fragment we use Factory method here
    // intead of creating the fragment here and passing the bundle
    // we do that in the Fragment2 class, in the newInstance method
    public void openFragment2(View view) {
        Fragment2 frag2 = Fragment2.newInstance("Passing via factory method", 50);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, frag2)
                .commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        //do nothing for now
    }


}
