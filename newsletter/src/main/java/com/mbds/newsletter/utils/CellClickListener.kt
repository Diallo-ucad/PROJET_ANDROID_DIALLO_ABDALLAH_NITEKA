package com.mbds.newsletter.utils

import com.mbds.newsletter.model.Category

interface CellClickListener {
    fun onCellClickListener(category: Category)
}