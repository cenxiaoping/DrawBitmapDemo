package widge.personal.com.drawbitmapdemo

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Point
import android.text.TextUtils

/**
 * @version V1.0
 * *
 * @createAuthor chenxiaoping
 * *
 * @createDate 2017/9/20 19:21
 * *
 * @updateAuthor
 * *
 * @updateDate
 * *
 * @company 跨越速运
 * *
 * @description
 * *
 * @copyright copyright(c)2017 Shenzhen Kye Technology Co., Ltd. Inc. All rights reserved.
 */
class DrawBitmap {

    private val SERVER_TYPE_X = 694

    //服务方式
    private val mServerType1 = Point(SERVER_TYPE_X, 192)
    private val mServerType2 = Point(SERVER_TYPE_X, 215)
    private val mServerType3 = Point(SERVER_TYPE_X, 234)
    private val mServerType4 = Point(SERVER_TYPE_X, 255)
    private val mServerType5 = Point(SERVER_TYPE_X, 277)
    private val mServerType6 = Point(SERVER_TYPE_X, 297)
    private val mServerType7 = Point(SERVER_TYPE_X, 319)

    fun drawBitmap(s: Resources?, bean: DrawBean): Bitmap {
        if (s == null && bean == null) {
            throw RuntimeException("请传入约定参数")
        }
        val mPaint = Paint()
        val bitmap = BitmapFactory.decodeResource(s, R.mipmap.yundan).copy(Bitmap.Config.ARGB_8888, true)
        val canvas = Canvas(bitmap)

        mPaint.textAlign = Paint.Align.CENTER
        //条码下的运单号
        val string = formatString(bean.num)
        canvas.drawText(string!!, 404f, 123f, mPaint)
        //服务方式
        val serviceType = getPoint("航空件")
        canvas.drawText("√", serviceType!!.x.toFloat(), serviceType.y.toFloat(), mPaint)


        mPaint.textAlign = Paint.Align.LEFT
        //寄件方地址
        canvas.drawText(bean.sendAddress, 80f, 216f, mPaint)
        //寄件人电话
        canvas.drawText(bean.sendPhone, 110f, 261f, mPaint)
        //寄件人姓名
        canvas.drawText(bean.sendName, 297f, 261f, mPaint)

        //收件方地址
        canvas.drawText(bean.receverAddress, 395f, 216f, mPaint)
        //收人电话
        canvas.drawText(bean.receverPhone, 425f, 261f, mPaint)
        //收件人姓名
        canvas.drawText(bean.receverName, 610f, 261f, mPaint)


        //托寄物资料
        canvas.drawText("托寄物资料", 66f, 344f, mPaint)
        //数量
        canvas.drawText("数量", 150f, 344f, mPaint)


        //件数
        canvas.drawText("件数", 72f, 488f, mPaint)
        //重量
        canvas.drawText("重量", 118f, 488f, mPaint)

        //寄件人签名
        canvas.drawText(bean.sendName, 687f, 408f, mPaint)

        //付款方式
        //        canvas.drawText("付款方式", 121f, 482f, mPaint);

        //底部运单号
        canvas.drawText(string, 220f, 520f, mPaint)

        return bitmap
    }


    fun getPoint(text: String): Point? {
        when (text) {
            "当天达" -> return mServerType1
            "次日达" -> return mServerType2
            "陆运件" -> return mServerType3
            "同城即日" -> return mServerType4
            "同城次日" -> return mServerType5
            "冷运件" -> return mServerType6
            "航空件" -> return mServerType7
            else -> return null
        }
    }


    /**
     * 格式化字符串，3个一组空格隔开
     */
    fun formatString(text: String): String? {
        if (TextUtils.isEmpty(text)) {
            return null
        }

        val sb = StringBuffer()
        for (i in 0..text.length - 1) {

            if (i == 0) {
                sb.append(text[i])
            } else if (i % 3 == 0) {
                sb.append("   ").append(text[i])
            } else {
                sb.append(" ").append(text[i])
            }
        }
        return sb.toString()
    }
}
