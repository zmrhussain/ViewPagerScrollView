package com.example.viewpagerscrollview

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.SCROLL_STATE_DRAGGING
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var adapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val quotes = listOf(
            "1 If you want to achieve greatness stop asking for permission.",
            "2 Things work out best for those who make the best of how things work out. --John Wooden",
            "3 To live a creative life, we must lose our fear of being wrong.",
            "4 If you are not willing to risk the usual you will have to settle for the ordinary. --Jim Rohn",
            "5 Trust because you are willing to accept the risk, not because it's safe or certain.",
            "6 All our dreams can come true if we have the courage to pursue them. --Walt Disney"
        )

        adapter = ViewPagerAdapter(quotes)
        viewPager.adapter = adapter


        val mViewPager : ViewPager2 = findViewById(R.id.viewPager)


        val handler = Handler()

        mViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                val runnable = Runnable { mViewPager.currentItem = position + 1 }
                if (position < mViewPager.adapter?.itemCount ?: 0) {
                    handler.postDelayed(runnable, 5000)

                }
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)

                if (state == SCROLL_STATE_DRAGGING) handler.removeMessages(0)

            }
        })



    }




}