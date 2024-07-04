package com.quyunshuo.androidbaseframemvvm.common.ui

import android.util.Log
import androidx.viewbinding.ViewBinding
import com.quyunshuo.androidbaseframemvvm.base.mvvm.v.BaseFrameActivity
import com.quyunshuo.androidbaseframemvvm.base.mvvm.vm.BaseViewModel
import com.quyunshuo.androidbaseframemvvm.base.utils.ActivityStackManager
import com.quyunshuo.androidbaseframemvvm.base.utils.AndroidBugFixUtils
import com.quyunshuo.androidbaseframemvvm.base.utils.BarUtils

/**
 * Activity基类
 *
 * @author Qu Yunshuo
 * @since 8/27/20
 */
abstract class BaseActivity<VB : ViewBinding, VM : BaseViewModel> : BaseFrameActivity<VB, VM>() {


    override fun onResume() {
        super.onResume()
        Log.d("ActivityLifecycle", "ActivityStack: ${ActivityStackManager.activityStack}")
    }

    override fun onDestroy() {
        super.onDestroy()
        // 解决某些特定机型会触发的Android本身的Bug
        AndroidBugFixUtils().fixSoftInputLeaks(this)
    }
}