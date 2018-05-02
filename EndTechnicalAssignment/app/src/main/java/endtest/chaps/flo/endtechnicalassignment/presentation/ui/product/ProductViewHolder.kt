package endtest.chaps.flo.endtechnicalassignment.presentation.ui.product

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import endtest.chaps.flo.endtechnicalassignment.R
import endtest.chaps.flo.endtechnicalassignment.data.model.Product

class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val productImage: ImageView = itemView.findViewById(R.id.productImage)
    val productName: TextView = itemView.findViewById(R.id.productName)
    val productPrice: TextView = itemView.findViewById(R.id.productPrice)

    fun bindItem(item: Product) {
        Picasso.get().load(item.image).into(productImage)
        productName.text = item.name
        productPrice.text = item.price
    }
}