package com.chethan.demoproject

import java.io.Serializable

data class Products(
    var id: Int,
    var categoryId: Int,
    var name: String,
    var url: String,
    var description: String,
    var salePrice: SalePrice
) : Serializable