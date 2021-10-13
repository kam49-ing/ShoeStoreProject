import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.R

class ShoeViewModel: ViewModel() {

    //data class for shoes
    data class Shoes(
        val name: String,
        val price: String,
        val description: String
    )
    //mutable list for shoes
    private lateinit var _shoeList : MutableList<Shoes>

    //sho live data
    private var _shoe = MutableLiveData<Shoes>()
    val shoe:LiveData<Shoes>
        get() = _shoe

    //initialisation
    init {
        setShoesList()
    }

    /**
     *setting shoes list
     * no parameter
     */
    private fun setShoesList(){
        _shoeList = mutableListOf(
            Shoes("Sebago", "30$", R.string.lorem_text.toString()),
            Shoes("Nike air", "30$", R.string.lorem_text.toString()),
            Shoes("Jordan air", "30$", R.string.lorem_text.toString()),
            Shoes("D&G", "30$", R.string.lorem_text.toString()),
            Shoes("Versace", "30$", R.string.lorem_text.toString())
        )
    }




    /*
    *Browsing shoes' list
    * no parameter
     */
    fun browseShoes() {

        if (!_shoeList.isEmpty())
            _shoe.value = _shoeList.removeAt(0)
    }

    /*
    *Constructor for creating a new shoe instance
    * with parameters name: string
    * price: string
    * description: string
    * return the shoe created
     */
    fun createShoe(name:String, price: String, description: String):Shoes{
        return Shoes(name, price, description)
    }

    /*
    *adding a new shoe to shoes' list
    * with a shoe: Shoes as a parameter
    * change the value of _shoe to the last element in the list
    * so that it can be added to the list screen
     */
    fun addShoe(newShoe: Shoes) {

        _shoeList.add(newShoe)
        _shoe.value = _shoeList.last()

    }

}