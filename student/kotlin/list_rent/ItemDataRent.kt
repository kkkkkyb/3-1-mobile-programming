package com.example.mobileprogramming.list_rent

import com.example.mobileprogramming.R

enum class ItemDataRent(val imageId: Int, val itemName: String, val itemAmount: String) {
    Item1(R.drawable.umbrella, "우산", "0개 남음"),
    Item2(R.drawable.calculator, "공학용 계산기", "5개 남음")
}
