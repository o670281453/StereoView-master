package mr_immortalz.com.stereoview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.baidu.speech.EventListener;
import com.baidu.speech.EventManager;
import com.baidu.speech.EventManagerFactory;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by Mr_immortalZ on 2016/7/15.
 * email : mr_immortalz@qq.com
 */
public class MainActivity extends AppCompatActivity {

    private Button btnLogin;
    private Button btnSetting;
    private Button btnImage;

    private EventManager mWpEventManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnSetting = (Button) findViewById(R.id.btn_setting);
        btnImage = (Button) findViewById(R.id.btn_image);

//        Object service = getSystemService("statusbar");
//        if (service != null) {
//            try {
//                Log.d("test","11111111111111");
//                Method expand = service.getClass().getMethod("enterFullscreen");
//                if(expand!=null){
//                    Log.d("test","222222222222");
//                }
//                expand.invoke(service);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Object service = getSystemService("statusbar");
                    if (service != null) {
                        Method expand = service.getClass().getMethod("exitFullscreen");
                        expand.invoke(service);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//                startActivity(intent);
            }
        });
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Object service = getSystemService("statusbar");
                    if (service != null) {
                        Method expand = service.getClass().getMethod("enterFullscreen");
                        expand.invoke(service);

                        Method[] s = service.getClass().getDeclaredMethods();
                        for(int i=0; i<s.length; i++) {
                            Log.d("test", s[i].getName().toString() + "===");
                        }

//                            Method expand2 = service.getClass().getMethod(s[i].getName().toString());
//                            if (expand2 != null) {
//                                Log.d("test", "expand2 is not null");
//                            }
//                            Class<?> returnType = expand2.getReturnType();
//                            Log.d("test","1111111");
//                            Class<?> para[] = expand2.getParameterTypes();
//                            Log.d("test","2222222");
//                            int temp = expand2.getModifiers();
//                            Log.d("test", Modifier.toString(temp) + "+++");
//                            Log.d("test", returnType.getName() + "+++");
//                            Log.d("test", expand2.getName() + "+++");
//                            for (int j = 0; j < para.length; ++j) {
//                                Log.d("test", para[j].getName() + " " + "arg" + j);
//                                if (j < para.length - 1) {
//                                    Log.d("test", ",+++");
//                                }
//                            }
//                        }
//                        String state = (String) expand2.invoke(service);
//                        Log.d("test",state+"++++++");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
//                startActivity(intent);
            }
        });
        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NetWorkUtils netWorkUtils = new NetWorkUtils();
                btnImage.setText(netWorkUtils.getLocalIpAddress().toString());
//                Intent intent = new Intent(MainActivity.this, ImageActivity.class);
//                startActivity(intent);
            }
        });
        NetWorkUtils netWorkUtils = new NetWorkUtils();
        Toast.makeText(this,netWorkUtils.getLocalIpAddress().toString(),Toast.LENGTH_LONG).show();

//        File file = new File("storage/extSdCard/Navi/db.tpk");
//        if(file.exists()){
//            Log.d("test", "111111111111111111");
//        }
//        file = new File("mnt/extsd2/Navi/db.tpk");
//        if(file.exists()){
//            Log.d("test", "2222222222222222");
//        }
//        file = new File("storage/sdcard/1/Navi/db.tpk");
//        if(file.exists()){
//            Log.d("test", "333333333333");
//        }
//        file = new File("storage/sdcard/0/Navi/db.tpk");
//        if(file.exists()){
//            Log.d("test", "4444444444444");
//        }
//        file = new File("storage/sdcard/2/Navi/db.tpk");
//        if(file.exists()){
//            Log.d("test", "555555555555");
//        }
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        // 唤醒功能打开步骤
//        // 1) 创建唤醒事件管理器
//        mWpEventManager = EventManagerFactory.create(MainActivity.this, "wp");
//        // 2) 注册唤醒事件监听器
//        mWpEventManager.registerListener(new EventListener() {
//            @Override
//            public void onEvent(String name, String params, byte[] data, int offset, int length) {
//                try {
//                    JSONObject json = new JSONObject(params);
//                    Log.d("test",json.toString());
//                    if ("wp.data".equals(name)) { // 每次唤醒成功, 将会回调name=wp.data的时间, 被激活的唤醒词在params的word字段
//                        String word = json.getString("word"); // 唤醒词
//                        Log.d("test",word);
//                    } else if ("wp.exit".equals(name)) {
//                        // 唤醒已经停止
//                    }
//                } catch (JSONException e) {
//                    throw new AndroidRuntimeException(e);
//                }
//            }
//        });
//        // 3) 通知唤醒管理器, 启动唤醒功能
//        HashMap params = new HashMap();
//        params.put("kws-file", "assets:///WakeUp.bin"); // 设置唤醒资源, 唤醒资源请到 http://yuyin.baidu.com/wake#m4 来评估和导出
//        mWpEventManager.send("wp.start", new JSONObject(params).toString(), null, 0, 0);
//    }
//    @Override
//    protected void onPause() {
//        super.onPause();
//        // 停止唤醒监听
//        mWpEventManager.send("wp.stop", null, null, 0, 0);
//    }

}
