import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.ShoeListFragment

class ShoeViewModel: ViewModel() {
    //data class for shoes
    data class Shoes(
        val name: String,
        val price: String,
        val description: String
    )
    private lateinit var _shoeList : MutableList<Shoes>

    private var _shoe = MutableLiveData<Shoes>()


    val shoe:LiveData<Shoes>
        get() = _shoe

    init {
        setShoesList()
    }

    /**
    *setting shoes list
    */
    private fun setShoesList(){
        _shoeList = mutableListOf(
            Shoes("Sebago", "30$", "@string/lorem_text"),
            Shoes("Nike air", "30$", "@string/lorem_text"),
            Shoes("Jordan air", "30$", "@string/lorem_text"),
            Shoes("D&G", "30$", "@string/lorem_text"),
            Shoes("Versace", "30$", "@string/lorem_text")
        )
    }

    private fun addShoes(shoe:Shoes) {
        _shoeList.add(shoe)
    }

    fun browseShoes() {
        var currentShoe = _shoe.value
        if (!_shoeList.isEmpty())
            _shoe.value = _shoeList.removeAt(0)
    }
    fun nextShoe(){
        do {
            browseShoes()
        }while (!_shoeList.isEmpty())
    }




}