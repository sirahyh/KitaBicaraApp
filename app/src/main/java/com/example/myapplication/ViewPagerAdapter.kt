package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.viewpager.widget.PagerAdapter

class ViewPagerAdapter(private val ctx: Context) : PagerAdapter() {

    override fun getCount(): Int {
        return 3
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater = LayoutInflater.from(ctx)
        val view = layoutInflater.inflate(R.layout.fragment_onboarding1, container, false)

        view.apply {
            val logo = view.findViewById<ImageView>(R.id.logo)

            val ind1 = view.findViewById<ImageView>(R.id.ind1)
            val ind2 = view.findViewById<ImageView>(R.id.ind2)
            val ind3 = view.findViewById<ImageView>(R.id.ind3)

            val title = view.findViewById<TextView>(R.id.title)
            val desc = view.findViewById<TextView>(R.id.desc)

//            val next = findViewById<ImageView>(R.id.next)
//            val back = findViewById<ImageView>(R.id.back)
            val btnGetStarted = findViewById<Button>(R.id.btnGetStarted)

//            next.setOnClickListener {
//                SlideActivity.viewPager.setCurrentItem(position + 1, true)
//            }
//
//            back.setOnClickListener {
//                SlideActivity.viewPager.setCurrentItem(position - 1, true)
//            }

            btnGetStarted.setOnClickListener {
                val intent = Intent(ctx, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(ctx, intent, null)
            }

            when (position) {
                0 -> {
                    logo.setImageResource(R.drawable.logo1)
                    ind1.setImageResource(R.drawable.selected)
                    ind2.setImageResource(R.drawable.unselected)
                    ind3.setImageResource(R.drawable.unselected)

                    title.text = "Shoping Place"
                    desc.text = "This is random text taking from lorem ipsum tesing purpose"
//                    back.visibility = View.GONE
//                    next.visibility = View.VISIBLE
                }
                1 -> {
                    logo.setImageResource(R.drawable.logo2)
                    ind1.setImageResource(R.drawable.unselected)
                    ind2.setImageResource(R.drawable.selected)
                    ind3.setImageResource(R.drawable.unselected)

                    title.text = "Shopping on the way"
                    desc.text = "Ini isi slide kedua"
//                    back.visibility = View.VISIBLE
//                    next.visibility = View.VISIBLE
                }
                2 -> {
                    logo.setImageResource(R.drawable.logo3)
                    ind1.setImageResource(R.drawable.unselected)
                    ind2.setImageResource(R.drawable.unselected)
                    ind3.setImageResource(R.drawable.selected)

                    title.text = "Shopping on the way"
                    desc.text = "Ini isi slide ketiga"
//                    back.visibility = View.VISIBLE
//                    next.visibility = View.VISIBLE
                }
            }
        }

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View)
    }
}