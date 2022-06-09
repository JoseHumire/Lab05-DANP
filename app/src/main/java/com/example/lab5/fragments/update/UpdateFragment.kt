package com.example.lab5.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.lab5.R
import com.example.lab5.data.ProductViewModel


class UpdateFragment : Fragment() {
    private lateinit var mProductViewModel: ProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_update, container, false)


        setHasOptionsMenu(true)
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_delete){
            deleteProduct()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteProduct() {
        val builder = AlertDialog.Builder(requireContext())
        /*builder.setPositiveButton("SI"){_,_ ->
            mProductViewModel.deleteProduct(args.currentProduct)

        }
        builder.setNegativeButton("NO"){_,_ ->}
        builder.setTitle("Borrar ${args.currentProduct.name}?")
        builder.setMessage("Esta seguro que desea borrar el producto ${args.currentProduct.name}?")*/


    }

}