package np.com.susonthapa.splashscreendemo

import android.content.Intent
import android.graphics.drawable.Animatable
import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.ViewTreeObserver
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // check for android version, for API > 23 we delegate the animations to SplashDrawable for older versions
        // we implement the animations using the layout of the splash activity
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            val view = layoutInflater.inflate(R.layout.activity_splash, null, false)
            // we want to keep the logo of the app centered and at the same position the theme sets the logo to.
            // since the theme positions the logo with respect to the entire window, we need to add top margin
            // to our image view which should be equal to the height of the status bar
            view.viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
                override fun onPreDraw(): Boolean {
                    view.viewTreeObserver.removeOnPreDrawListener(this)
                    // set the margin to the image
                    val imageView = view.findViewById<ImageView>(R.id.splash_image)
                    val layoutParams = imageView.layoutParams as ConstraintLayout.LayoutParams
                    val statusBarHeight =
                        resources.displayMetrics.heightPixels - view.measuredHeight
                    layoutParams.setMargins(0, statusBarHeight, 0, 0)
                    imageView.layoutParams = layoutParams
                    (imageView.drawable as Animatable).start()
                    return true
                }
            })
            setContentView(view)
        }
        // simulate some async initialization like authenticating user from network
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 2000)
    }

}