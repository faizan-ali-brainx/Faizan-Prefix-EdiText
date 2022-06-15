package com.example.faizan_prefix_edittext

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText

class PrefixEditTextView(
    context: Context,
    attributes: AttributeSet
) : AppCompatEditText(context, attributes) {

    private val DEFAULT_PADDING = -1f
    private var defaultLeftPadding = DEFAULT_PADDING

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawText(
            prefix, defaultLeftPadding,
            getLineBounds(0, null).toFloat(), paint
        )
    }

    private var prefix: String = ""
        set(value) {
            field = value
            calculatePrefix(field)
            requestLayout()
            invalidate()
        }

    fun assignPrefix(prefix: String) {
        this.prefix = prefix
    }

    private fun calculatePrefix(prefix: String) {
        if (defaultLeftPadding == DEFAULT_PADDING) {
            val widths = FloatArray(prefix.length)
            paint.getTextWidths(prefix, widths)
            var textWidth = 0f
            for (w in widths) {
                textWidth += w
            }
            defaultLeftPadding = compoundPaddingLeft.toFloat()
            setPadding(
                (textWidth + defaultLeftPadding).toInt(),
                paddingRight, paddingTop, paddingBottom
            )
        }
    }


}