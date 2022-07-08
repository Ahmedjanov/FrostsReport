package ordinary.frostsreport.ui.addOrder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import ordinary.frostsreport.R
import ordinary.frostsreport.ui.helper.CHOSENPRODUCTSDATAMODEL
import ordinary.frostsreport.ui.helper.items.Product


class ProductCountBlankFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_count_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val product_name = view.findViewById<TextView>(R.id.product_name)
        val product_price = view.findViewById<TextView>(R.id.product_price)
        val product_count = view.findViewById<EditText>(R.id.product_count)
        val product_amount = view.findViewById<TextView>(R.id.product_amount)
        val coninue = view.findViewById<Button>(R.id.save_count_product)

        val name = arguments?.getString("product_name").toString()
        val price = arguments?.getString("product_price").toString()
        var count:Double = 1.0

        product_name.text = name
        product_price.text = price
        product_count.setText(count.toString())

        product_count.isSelected = true

        var amount:Double = price.toDouble() * product_count.text.toString().toDouble()

        product_amount.text = amount.toString()

        product_count.addTextChangedListener {
            if (it != null && it.isNotEmpty()) {
                count = it.toString().toDouble()
                amount = price.toDouble() * count
                product_amount.text = amount.toString()
            }
        }

        coninue.setOnClickListener {
            val product = Product(name,price.toDouble())

            val pair = Pair(product,count)
            CHOSENPRODUCTSDATAMODEL.product.add(pair)
            CHOSENPRODUCTSDATAMODEL.productAmount.add(amount)
            findNavController().navigate(R.id.nav_add_order)
        }
    }

}