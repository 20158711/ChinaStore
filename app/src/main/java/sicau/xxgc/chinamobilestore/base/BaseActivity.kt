package sicau.xxgc.chinamobilestore.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import sicau.xxgc.chinamobilestore.util.MyActivityManager

/**
 * Created by yanbi on 2018/1/11.
 */
class BaseActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MyActivityManager.add(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        MyActivityManager.remove(this)
    }

}