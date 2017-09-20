package widge.personal.com.drawbitmapdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var mDrawBean: DrawBean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_start.setOnClickListener(this)
    }

    override fun onClick(v: View) {

        if (!checkParams()) {
            Toast.makeText(this@MainActivity, "请输入完整参数", Toast.LENGTH_SHORT).show()
            return
        }

        var util = DrawBitmap()
        val drawBitmap = util.drawBitmap(resources, mDrawBean!!)

        imageView.setImageBitmap(drawBitmap)
    }

    fun checkParams(): Boolean {
        var mStrSendAddress = et_sendaddress.text.trim().toString()
        var mStrSendPhone = et_sendPhone.text.trim().toString()
        var mStrSendName = et_sendName.text.trim().toString()

        var mStrReceverAddress = et_receverAddress.text.trim().toString()
        var mStrReceverPhone = et_receverPhone.text.trim().toString()
        var mStrReceverName = et_receverName.text.trim().toString()
        val mStrnum = et_num.text.trim().toString()

        if (TextUtils.isEmpty(mStrSendAddress)) {
            return false
        } else if (TextUtils.isEmpty(mStrSendPhone)) {
            return false
        } else if (TextUtils.isEmpty(mStrSendName)) {
            return false
        }

        if (TextUtils.isEmpty(mStrReceverAddress)) {
            return false
        } else if (TextUtils.isEmpty(mStrReceverPhone)) {
            return false
        } else if (TextUtils.isEmpty(mStrReceverName)) {
            return false
        }

        if (TextUtils.isEmpty(mStrnum)) {
            return false
        }

        mDrawBean = DrawBean()
        mDrawBean?.sendAddress = mStrSendAddress
        mDrawBean?.sendPhone = mStrSendPhone
        mDrawBean?.sendName = mStrSendName

        mDrawBean?.receverAddress = mStrReceverAddress
        mDrawBean?.receverPhone = mStrReceverPhone
        mDrawBean?.receverName = mStrReceverName
        mDrawBean?.num = mStrnum

        return true
    }
}
