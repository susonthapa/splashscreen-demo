package np.com.susonthapa.splashscreendemo

import android.content.res.Resources
import android.graphics.*
import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.content.res.ResourcesCompat
import org.xmlpull.v1.XmlPullParser

/**
 * Created by suson on 9/18/20
 */

class SplashDrawable : Drawable() {

    private lateinit var animatedVectorDrawable: AnimatedVectorDrawable

    override fun draw(c: Canvas) {
        val height = bounds.height()
        val width = bounds.width()
        // centering the layout
        val centerX = c.width / 2
        val centerY = c.height /2
        // compute the bounds of the drawable
        val left = centerX - (width / 2)
        val top = centerY - (height / 2)
        val right = centerX + (width / 2)
        val bottom = centerY + (height / 2)
        val rect = Rect(left, top, right, bottom)
        // set the bounds to the animatedVector
        animatedVectorDrawable.bounds = rect
        animatedVectorDrawable.draw(c)
    }

    override fun setAlpha(alpha: Int) {
        animatedVectorDrawable.alpha = alpha
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        animatedVectorDrawable.colorFilter = colorFilter
    }

    override fun getOpacity(): Int {
        return animatedVectorDrawable.opacity
    }

    override fun inflate(
        r: Resources,
        parser: XmlPullParser,
        attrs: AttributeSet,
        theme: Resources.Theme?
    ) {
        super.inflate(r, parser, attrs, theme)
        initializeAnimation(r, theme)
    }

    private fun initializeAnimation(resources: Resources, theme: Resources.Theme?) {
        animatedVectorDrawable = ResourcesCompat.getDrawable(resources, R.drawable.avd_anim, theme) as AnimatedVectorDrawable
        animatedVectorDrawable.start()
    }

}