import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel: ViewModel() {

    //data class for shoes
    data class Shoes(
        val name: String,
        val price: String,
        val description: String
    )


    //mutable list for shoes
    private lateinit var _shoeList: MutableList<Shoes>

    //sho live data
    private var _shoes = MutableLiveData<List<Shoes>>()
    val shoes: LiveData<List<Shoes>>
        get() = _shoes



    //initialisation
    init {
        setShoesList()
    }

    /**
     *setting shoes list
     * no parameter
     */
    private fun setShoesList() {
        _shoeList = mutableListOf(
            Shoes("Sebago", "30$", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
            Shoes("Nike air", "30$", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
            Shoes("Jordan air", "30$", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
            Shoes("D&G", "30$", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
            Shoes("Versace", "30$", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
        )
        _shoes.value = _shoeList
    }


    /*
    *initializes _shoes live data
    * no parameter
     */
    fun initialization() {
        _shoes.value = _shoeList
    }


    /*
    *Constructor for creating a new shoe instance
    * with parameters name: string
    * price: string
    * description: string
    * return the shoe created
     */
    fun createShoe(name: String, price: String, description: String): Shoes {
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
        _shoes.value = _shoeList
    }


}

