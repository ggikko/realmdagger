package ggikko.me.daggerrealmtestapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ggikko.me.daggerrealmtestapp.GgikkoApplication;
import ggikko.me.daggerrealmtestapp.R;
import ggikko.me.daggerrealmtestapp.dagger.injector.ApplicationInjector;
import ggikko.me.daggerrealmtestapp.dagger.injector.InjectorCreator;
import ggikko.me.daggerrealmtestapp.model.Code;
import ggikko.me.daggerrealmtestapp.repository.DatabaseRealm;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "ggikko";

    StringBuffer stringBuffer = new StringBuffer();

    @Inject DatabaseRealm databaseRealm;

    @BindView(R.id.result) TextView result;

    @OnClick({R.id.get, R.id.add, R.id.delete, R.id.result_clear})
    void callGet(View view){
        switch (view.getId()){
            case R.id.get :{
                List<Code> all = databaseRealm.findAll(Code.class);
                for(Code code : all){
                    stringBuffer.append("id : " + code.getId() + " code : " + code.getCode());
//            Log.e(TAG, "id : " + code.getId() + " code : " + code.getCode());
                }
                result.setText(stringBuffer.toString());
                Log.e("ggikko","get");
                break;
            }
            case R.id.add :{

                Code newCode1 = new Code(1, "haha1");
                Code newCode2 = new Code(2, "haha2");
                Code newCode3 = new Code(3, "haha3");

                databaseRealm.add(newCode1);
                databaseRealm.add(newCode2);
                databaseRealm.add(newCode3);
                Log.e("ggikko","add");

                break;
            }

            case R.id.delete :{
                databaseRealm.deleteAll(Code.class);
                Log.e("ggikko","delete");

                break;
            }

            case R.id.result_clear:{
                result.setText("");
                stringBuffer.setLength(0);
                Log.e("ggikko","clear");

                break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG,"onCreate");

        ButterKnife.bind(this);

        ((GgikkoApplication)getApplication()).getGgikkoApplicationComponent().inject(this);

//        ((GgikkoApplication)getApplication()).getInjectorCreator().
//        ApplicationInjector.getApplicationComponent().inject(MainActivity.this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG,"onResume");


    }
}
