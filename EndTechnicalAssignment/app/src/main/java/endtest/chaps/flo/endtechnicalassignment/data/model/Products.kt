package endtest.chaps.flo.endtechnicalassignment.data.model

import com.google.gson.annotations.SerializedName

data class Products(
        @SerializedName("products") val products: List<Product>,
        @SerializedName("title") val title: String,
        @SerializedName("product_count") val product_count: Int
)

data class Product(
        @SerializedName("id") val id: String,
        @SerializedName("name") val name: String,
        @SerializedName("price") val price: String,
        @SerializedName("image") val image: String
)