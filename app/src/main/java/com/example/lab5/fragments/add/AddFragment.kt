package com.example.lab5.fragments.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.lab5.R
import com.example.lab5.data.Product
import com.example.lab5.data.ProductViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*


class AddFragment : Fragment() {
    private lateinit var mProductViewModel:ProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view  = inflater.inflate(R.layout.fragment_add, container, false)
        mProductViewModel=ViewModelProvider(this).get(ProductViewModel::class.java)
        view.btnAdd.setOnClickListener{
            insertDataToDatabase()
        }
        return view
    }
    private fun insertDataToDatabase(){
        val productName = editNameProduct.text.toString()
        val productBrand = editBrand.text.toString()
        val productQuantity = editQuantity.text.toString()

        if(inputCheck(productName,productBrand,productQuantity)){
            val product = Product(0,productName,productBrand,productQuantity)
            mProductViewModel.addProduct(product)
            Toast.makeText(requireContext(),"Producto guardado",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(),"No se guardo el producto",Toast.LENGTH_LONG).show()
        }


    }
    private fun inputCheck(productName: String, productBrand: String, productQuantity:String):Boolean{
        return !(TextUtils.isEmpty(productName)&&TextUtils.isEmpty(productBrand)&&TextUtils.isEmpty(productQuantity))
    }

}