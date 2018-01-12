package sicau.xxgc.chinamobilestore.util

import android.app.Activity

/**
 * Created by yanbi on 2018/1/11.
 */

//管理所有activity的工具类
object MyActivityManager {

    //定义存放所有activity的集合
    private var myActivities = ArrayList<Activity>()

    //添加一个activity
    fun add(activity: Activity) {
        myActivities.add(activity)
    }

    fun remove(activity: Activity){
        myActivities.remove(activity)
    }

    //关闭所有activity
    fun removeAll() {
        if (myActivities?.size>0)
            myActivities
                    .filterNot { it.isFinishing }
                    .forEach { it.finish() }
    }

    //关闭除本身外的其它所有activity
    fun removeAllButThis(activity: Activity) {
        if (myActivities?.size>1)
            myActivities
                    .filterNot { it.isFinishing }
                    .filterNot { it== activity}
                    .forEach { it.finish() }
    }

}