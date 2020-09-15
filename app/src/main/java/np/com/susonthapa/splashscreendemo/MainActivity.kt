package np.com.susonthapa.splashscreendemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.math.atan
import kotlin.math.tan

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        simulateHeavyLayout()
        setContentView(R.layout.activity_main)
    }

    private fun simulateHeavyLayout() {
        // simulate some heavy UI inflation
        for (i in 0..1000000) {
            val d = tan(atan(tan(atan(tan(atan(tan(atan(tan(atan(123456789.123456789))))))))))
            d.toString()
        }
    }

}