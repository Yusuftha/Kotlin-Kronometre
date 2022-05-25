package com.aydsoft.kronometre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import com.aydsoft.kronometre.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var zamaniDurdur:Long=0
        binding.btnbaslat.setOnClickListener{
            binding.kronometre.base=SystemClock.elapsedRealtime()+zamaniDurdur
            binding.kronometre.start()
            binding.btnbaslat.visibility= View.GONE
            binding.btndurdur.visibility= View.VISIBLE
            binding.imageView3.setImageDrawable(getDrawable(R.drawable.durdur))
        }
        binding.btndurdur.setOnClickListener{
            zamaniDurdur=binding.kronometre.base-SystemClock.elapsedRealtime()
            binding.kronometre.stop()
            binding.btndurdur.visibility= View.GONE
            binding.btnbaslat.visibility= View.VISIBLE
            binding.imageView3.setImageDrawable(getDrawable(R.drawable.baslat))

        }
        binding.btnreset.setOnClickListener{
            binding.kronometre.base=SystemClock.elapsedRealtime()
            binding.kronometre.stop()
            zamaniDurdur=0
            binding.btndurdur.visibility= View.GONE
            binding.btnbaslat.visibility= View.VISIBLE
            binding.imageView3.setImageDrawable(getDrawable(R.drawable.baslat))
        }
    }
}