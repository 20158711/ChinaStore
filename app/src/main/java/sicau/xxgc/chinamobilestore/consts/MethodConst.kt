package sicau.xxgc.chinamobilestore.consts

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import sicau.xxgc.chinamobilestore.util.MyActivityManager
import sicau.xxgc.chinamobilestore.view.LoginActivity

/**
 * Created by yanbi on 2018/1/11.
 */
//SharedPreferences文件名
val dataFIleName="my_data"

//保存字符串键值对到文件
fun saveStringToStroe(context: Context,key:String,msg:String):Boolean{
    val edit=context.getSharedPreferences(dataFIleName,Context.MODE_PRIVATE).edit()
    return edit.putString(key,msg).commit()
}

//从文件读取字符串键值对
fun readStringFromStore(context: Context, key:String, def:String?):String?{
    var sh=context.getSharedPreferences(dataFIleName, Context.MODE_PRIVATE)
    return sh.getString(key,def)
}

//保存bool键值对到文件
fun saveBooleToStore(context: Context,key:String,value:Boolean): Boolean {
    var edit=context.getSharedPreferences(dataFIleName,Context.MODE_PRIVATE).edit()
    return edit.putBoolean(key,value).commit()
}

//从文件读取bool键值对
fun readBooleanFromStore(context: Context,key: String): Boolean {
    var sh=context.getSharedPreferences(dataFIleName,Context.MODE_PRIVATE)
    return sh.getBoolean(key,false)
}

//删除文件中指定的键值对
fun deleteFromStore(context: Context,key: String){
    var edit=context.getSharedPreferences(dataFIleName,Context.MODE_PRIVATE).edit()
    edit.remove(key).commit()
}

//删除文件中所有的键值对
fun deleteAllFrom(context: Context){
    var edit=context.getSharedPreferences(dataFIleName,Context.MODE_PRIVATE).edit()
    edit.clear().commit()
}

//封装通用logd
fun logd(str:String?){
    Log.d("chinaMobile",str)
}

//封装通用loge
fun loge(str:String?){
    Log.e("chinaMobile",str)
}

//封装UI线程Toast
fun toastOnUiThread(context: Context,str:String){
    context as Activity
    context.runOnUiThread {
        Toast.makeText(context,str,Toast.LENGTH_SHORT).show()
    }
}

//封装Toast
fun toast(context: Context,str: String?){
    Toast.makeText(context,str,Toast.LENGTH_SHORT).show()
}

//封装网络错误提示
fun internetErrorOnUiThread(context:Context){
    toastOnUiThread(context,"网络连接失败")
}

//处理服务端面返回代码为error的情况
fun stateErrorOnUiThread(context: Context,msg: String){

    //1,删除保存的cookie键值对
    deleteFromStore(context, cookie)

    //提示错误
    toastOnUiThread(context,msg)

    //重新进入登录页
    context as Activity
    context.runOnUiThread {
        context.startActivity(Intent(context, LoginActivity::class.java))
    }

    //关闭现存的所有页面
    MyActivityManager.removeAll()
}