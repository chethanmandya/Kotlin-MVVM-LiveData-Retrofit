package com.chethan.demoproject

import java.io.Serializable


data class ProductFamily(
    var id: Int,
    var products: List<Products>,
    var name: String,
    var description: String,
    var totalPages: Int
) : Serializable