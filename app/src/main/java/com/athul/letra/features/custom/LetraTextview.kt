package com.athul.letra.features.custom

import android.content.Context
import android.graphics.Canvas
import android.os.Build
import android.widget.TextView
import android.util.TypedValue
import android.view.ScaleGestureDetector
import android.view.MotionEvent
import android.support.annotation.NonNull
import android.text.Html
import android.util.AttributeSet


class LetraTextview : TextView {
    private var mScaleDetector: ScaleGestureDetector? = null

    private var mScaleFactor = 1f
    private var defaultSize: Float = 0.toFloat()

    private var zoomLimit = 3.0f


    constructor(context: Context) : super(context) {
        initialize()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initialize()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initialize()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }


    public fun setHtml(source: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            setText(Html.fromHtml(source, Html.FROM_HTML_MODE_LEGACY));
        } else {
            setText(Html.fromHtml(source));
        }
    }


    private fun initialize() {
        defaultSize = textSize
        mScaleDetector = ScaleGestureDetector(context, ScaleListener())

    }

    /***
     * @param zoomLimit
     * Default value is 3, 3 means text can zoom 3 times the default size
     */

    fun setZoomLimit(zoomLimit: Float) {
        this.zoomLimit = zoomLimit
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onTouchEvent(ev: MotionEvent): Boolean {
        super.onTouchEvent(ev)
        mScaleDetector!!.onTouchEvent(ev)
        return true
    }

    /*Scale Gesture listener class,
    mScaleFactor is getting the scaling value
    and mScaleFactor is mapped between 1.0 and and zoomLimit
    that is 3.0 by default. You can also change it. 3.0 means text
    can zoom to 3 times the default value.*/

    private inner class ScaleListener : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(detector: ScaleGestureDetector): Boolean {
            mScaleFactor *= detector.scaleFactor
            mScaleFactor = Math.max(1.0f, Math.min(mScaleFactor, zoomLimit))
            setTextSize(TypedValue.COMPLEX_UNIT_PX, defaultSize * mScaleFactor)
            // Log.e(TAG, mScaleFactor.toString())
            return true
        }
    }

    companion object {
        private val TAG = "ZoomTextView"
    }
}