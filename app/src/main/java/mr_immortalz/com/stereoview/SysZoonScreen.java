//package mr_immortalz.com.stereoview;
//
//import android.app.Activity;
//import android.app.StatusBarManager;
//import android.content.Context;
//import android.os.Bundle;
//
//public class SysZoonScreen extends Activity {
//	private Context context;
//	private StatusBarManager mStatusBarManager;
//	@Override
//	protected void onCreate(Bundle arg0) {
//		super.onCreate(arg0);
//		context = this;
//		//Context.STATUS_BAR_SERVICE 的值为"statusba" 字符串
//		mStatusBarManager = (StatusBarManager) context.getSystemService(Context.STATUS_BAR_SERVICE);
//	}
//
//	public void doSysFullScreenDisplay(String doorplate) {
//		try {
//			//第三方app进入全屏显示接口，第三方应用可以通过反射方法去调用
//			if(null!=mStatusBarManager) mStatusBarManager.enterFullscreen();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void doSysNormalScreenDisplay(String doorplate) {
//		try {
//			//第三方app退出全屏显示接口，第三方应用可以通过反射方法去调用
//			if(null!=mStatusBarManager) mStatusBarManager.exitFullscreen();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//}
