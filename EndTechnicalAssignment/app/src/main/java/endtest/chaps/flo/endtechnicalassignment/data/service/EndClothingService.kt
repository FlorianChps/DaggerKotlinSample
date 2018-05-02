package endtest.chaps.flo.endtechnicalassignment.data.service

import endtest.chaps.flo.endtechnicalassignment.data.model.Products
import io.reactivex.Single
import retrofit2.http.GET

interface EndClothingService {

    @GET("/media/catalog/example.json")
    fun getProducts(): Single<Products>
}