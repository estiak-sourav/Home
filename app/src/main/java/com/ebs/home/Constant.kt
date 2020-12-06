package com.ebs.home

import com.ebs.home.model.Contents
import com.ebs.home.model.HomeMainContent

object Constant {
    const val BASE_URL = "https://robiscreen.com/api/"
    val HOME_CONTENT = arrayListOf(
        HomeMainContent(
            "banner", "Banner", 1,
            arrayListOf(
                Contents("banner", "Banner 1", "xyz","demo",R.drawable.sa),
                Contents("banner", "Banner 1", "xyz","demo",R.drawable.sb),
                Contents("banner", "Banner 1", "xyz","demo",R.drawable.sc),
                Contents("banner", "Banner 1", "xyz","demo",R.drawable.sd)
            ),
        ),
        HomeMainContent(
            "entertainment", "Entertainment", 2,
            arrayListOf(
                Contents("entertainment", "title Name", "xyz","entertainment",R.drawable.a),
                Contents("entertainment", "title b", "xyz","entertainment",R.drawable.b),
                Contents("entertainment", "title c", "xyz","entertainment",R.drawable.c),
                Contents("entertainment", "title d", "xyz","entertainment",R.drawable.d)
            ),
        ),
        HomeMainContent(
            "bill", "Bill Pay", 3,
            arrayListOf(
                Contents("bill", "title Name", "xyz","entertainment",R.drawable.e),
                Contents("bill", "title f", "xyz","entertainment",R.drawable.f),
                Contents("bill", "title g", "xyz","entertainment",R.drawable.g),
                Contents("bill", "title h", "xyz","entertainment",R.drawable.h),
                Contents("bill", "title i", "xyz","entertainment",R.drawable.i)
            ),
        ),
        HomeMainContent(
            "info", "Info", 3,
            arrayListOf(
                Contents("info", "title j", "xyz","entertainment",R.drawable.j),
                Contents("info", "title k", "xyz","entertainment",R.drawable.k),
                Contents("info", "title l", "xyz","entertainment",R.drawable.l),
                Contents("info", "title m", "xyz","entertainment",R.drawable.m),
                Contents("info", "title n", "xyz","entertainment",R.drawable.n),
                Contents("info", "title o", "xyz","entertainment",R.drawable.o)
            ),
        )
    )
}
