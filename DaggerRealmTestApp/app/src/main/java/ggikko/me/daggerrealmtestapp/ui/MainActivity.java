package ggikko.me.daggerrealmtestapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import ggikko.me.daggerrealmtestapp.GgikkoApplication;
import ggikko.me.daggerrealmtestapp.R;
import ggikko.me.daggerrealmtestapp.dagger.injector.ApplicationInjector;
import ggikko.me.daggerrealmtestapp.dagger.injector.InjectorCreator;
import ggikko.me.daggerrealmtestapp.model.Code;
import ggikko.me.daggerrealmtestapp.repository.DatabaseRealm;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "ggikko";

    @Inject
    DatabaseRealm databaseRealm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG,"onCreate");

//        Code newCode1 = new Code(1, "haha1");
//        Code newCode2 = new Code(2, "haha2");
//        Code newCode3 = new Code(3, "haha3");

        ((GgikkoApplication)getApplication()).getGgikkoApplicationComponent().inject(this);

//        ((GgikkoApplication)getApplication()).getInjectorCreator().
//        ApplicationInjector.getApplicationComponent().inject(MainActivity.this);

//        databaseRealm.add(newCode1);
//        databaseRealm.add(newCode2);
//        databaseRealm.add(newCode3);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG,"onResume");

        List<Code> all = databaseRealm.findAll(Code.class);
        for(Code code : all){
            Log.e(TAG, "id : " + code.getId() + " code : " + code.getCode());
        }
    }
}
