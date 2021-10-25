import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

open class ShoeViewModel: ViewModel() {

    var obervable:Observer = Observer()
    class Observer():BaseObservable(){

        //data class for shoes
        private var shoe:Shoe = Shoe("", "", "", "")

        //mutable list for shoes
        private lateinit var _shoeList: MutableList<Shoe>

        //sho live data
        private var _shoes = MutableLiveData<List<Shoe>>()
        val shoes: LiveData<List<Shoe>>
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
                Shoe("Sebago", "3", "sebago","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
                Shoe("Nike air", "4", "Nike","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
                Shoe("Jordan air", "5", "Jordan","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
                Shoe("D&G", "4", "D&G","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
                Shoe("Versace", "6", "Versace","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
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
        fun createShoe(name: String, price: String, description: String): Shoe {
            return Shoe(name, price,name, description)
        }

        /*
        *adding a new shoe to shoes' list
        * with a shoe: Shoes as a parameter
        * change the value of _shoe to the last element in the list
        * so that it can be added to the list screen
         */
        fun addShoe(newShoe: Shoe) {

            _shoeList.add(newShoe)
            _shoes.value = _shoeList
        }

        @Bindable
        fun getShoe():Shoe{
            return shoe
        }
        fun setShoe(newShoe: Shoe) {
            if (shoe != newShoe) {
                _shoeList.add(newShoe)
                _shoes.value = _shoeList
                notifyPropertyChanged(BR.shoe)
            }
        }
    }



}

