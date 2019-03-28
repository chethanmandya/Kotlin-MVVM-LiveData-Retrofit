package com.chethan.demoproject

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import org.koin.standalone.KoinComponent


class ProductViewModel(val dataRepository: DataRepository) : ViewModel(), KoinComponent {

    var listOfProducts = MutableLiveData<List<ProductFamily>>()

    init {
        listOfProducts.value = listOf()
    }

    fun getProducts() {
        dataRepository.getProducts(object : DataRepository.OnProductData {
            override fun onSuccess(data: List<ProductFamily>) {
                listOfProducts.value = data
            }

            override fun onFailure() {
                //REQUEST FAILED
            }
        })
    }
}