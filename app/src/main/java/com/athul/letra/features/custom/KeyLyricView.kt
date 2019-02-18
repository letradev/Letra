package com.athul.letra.features.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.support.v7.widget.AppCompatTextView
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.view.ScaleGestureDetector
import android.view.View
import android.widget.FrameLayout
import com.athul.letra.domain.database.tables.Keys
import com.athul.letra.utils.ext.px
import org.xmlpull.v1.XmlPullParserFactory
import kotlin.properties.Delegates
import android.util.Xml.newPullParser
import com.athul.letra.domain.pojo.LyricXml
import org.xmlpull.v1.XmlPullParser
import java.io.ByteArrayInputStream
import java.nio.charset.StandardCharsets
import com.thoughtworks.xstream.XStream


class KeyLyricView : View {

    var isDirt: Boolean = false

    private var key_text: String = ""
    private var lyrics_text: String = ""
    lateinit var key_paint: TextPaint
    lateinit var lyric_paint: TextPaint

    private val params = FrameLayout.LayoutParams(0, 0)
    private val r = Rect()
    private val paint = Paint()
    private val rectPaint = Paint()
    private val mTextPaint: TextPaint = TextPaint()
    private var mCanvas: Canvas? = null
    lateinit var mTextLayout: StaticLayout


    constructor(context: Context) : super(context) {
        initialize()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initialize()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initialize()
    }


    private fun initialize() {
        key_paint = TextPaint()
        key_paint.textSize = 50f
        key_paint.color = Color.RED

        lyric_paint = TextPaint()
        lyric_paint.textSize = 50f
        lyric_paint.color = Color.BLACK
        mCanvas.let {
            mTextLayout = StaticLayout(lyrics_text, lyric_paint, it!!.getWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        }


    }

    fun setKeyLyric(key: Keys?, lyric: String) {

        key?.let {
            this.key_text = key.notes
        }


        /*val xstream = XStream()


        val inputAsString = (lyric)
        xstream.alias("lyric", LyricXml::class.java)
        xstream.addImplicitCollection(LyricXml::class.java, "verse", String::class.java)
        var ly: LyricXml = xstream.fromXML(inputAsString) as LyricXml*/
        // parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
        //parser.setInput(inputAsString, null)
        this.lyrics_text = lyric

        /* ly.getvers()?.forEach {



             this.lyrics_text = this.lyrics_text + "\n\n" + it.replace("//br//","\n").trim()
         }

         lyrics_text.split("<br>")*/
        //this.lyrics_text = lyric

    }


    private val LEFT_MARGIN: Float = 10f
    private val LEFT_PADDING: Float = 10f
    private val TOP_PADDING: Float = 50f
    private val TOP_MARGIN: Float = 10f
    private val SPACE_IN_BETWEEN: Float = 50f


    override fun onDraw(canvas: Canvas?) {
        //super.onDraw(canvas)

        //canvas?.drawText(key_text, LEFT_PADDING + LEFT_MARGIN, TOP_PADDING + TOP_MARGIN, key_paint)
        //canvas?.drawText(lyrics_text, LEFT_PADDING + LEFT_MARGIN, TOP_PADDING + TOP_MARGIN + SPACE_IN_BETWEEN, lyric_paint)


        canvas?.let {

            mCanvas = canvas


            //draw(canvas, lyric_paint, lyrics_text)
        }

        canvas?.save()
// calculate x and y position where your text will be placed


        canvas?.translate(10.px, 10.px);
        mTextLayout.draw(canvas);
        canvas?.restore();


    }

    private fun drawTextBounds(canvas: Canvas, rect: Rect, x: Int, y: Int) {
        rectPaint.color = Color.rgb(0, 0, 0)
        rectPaint.style = Paint.Style.STROKE
        rectPaint.strokeWidth = 3f
        rect.offset(x, y)
        canvas.drawRect(rect, rectPaint)
    }

    private fun draw(canvas: Canvas, paint: Paint, text: String) {
        paint.textAlign = Paint.Align.LEFT
        paint.color = Color.rgb(255, 255, 255)
        canvas.getClipBounds(r)
        val cHeight = r.height()
        val cWidth = r.width()
        paint.getTextBounds(text, 0, text.length, r)
        val x = cWidth / 2f - r.width() / 2f - r.left
        val y = cHeight / 2f + r.height() / 2f - r.bottom
        canvas.drawText(text, x, y, paint)
        drawTextBounds(canvas, r, x.toInt(), y.toInt())
    }

    // var texts by Delegates.observable(listOf<CharSequence>()) { _, _, _ -> updateText() }
    // var texts = listOf<CharSequence>()

    //  private var actualTextIndex: Int = 0

//    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
//        super.onSizeChanged(w, h, oldw, oldh)
//        updateText()
//    }
//
//    private fun updateText() {
//        if (this.lyrics_text.isEmpty()) {
//            text = ""
//            return
//        }
//        texts = listOf<CharSequence>(lyrics_text);
//
//        // TODO: add caching
//        val firstFittedIndex = texts.asSequence()
//                .map {
//                    paint.measureText(it.toString())
//                }
//                .indexOfFirst { it <= measuredWidth }
//
//        if (actualTextIndex == firstFittedIndex) return
//
//        actualTextIndex = firstFittedIndex
//        text = texts.getOrElse(firstFittedIndex) { texts.first() }
//        invalidate()
//    }
}