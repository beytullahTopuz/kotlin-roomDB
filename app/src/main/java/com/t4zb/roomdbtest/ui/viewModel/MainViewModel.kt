package com.t4zb.roomdbtest.ui.viewModel

import android.app.Application
import com.t4zb.roomdbtest.model.CountryModel
import com.t4zb.roomdbtest.model.PasswordModel
import com.t4zb.roomdbtest.services.CountryDatabase
import com.t4zb.roomdbtest.services.PasswordDatabase
import com.t4zb.roomdbtest.util.showLogDebug
import kotlinx.coroutines.launch


class MainViewModel(application: Application) : BaseViewModel(application) {


    private fun storeInSQLite(cmodel: CountryModel) {
        launch {
            val dao = CountryDatabase(getApplication()).CountryDao()
            var listLong = dao.insertAll(cmodel)
        }
    }

    public fun insertPassword() {
        var pvm = PasswordModel(
            category = "kalem",
            username = "klm@gmail.com",
            password = "1234564567982435'^+'%+^%%&"
        )
        launch {
            val dao = PasswordDatabase(getApplication()).PasswordDao()

            var lisLong = dao.insertAll(pvm)

            showLogDebug(TAG,lisLong.toString())

        }
    }

    public fun getAllPassword(){
        launch {
            val dao = PasswordDatabase(getApplication()).PasswordDao()

            var paswordList = dao.getAllPasswords()
            showLogDebug(TAG,paswordList.toString())
        }
    }

    fun getPassword(id: Int){
        launch {
            val dao = PasswordDatabase(getApplication()).PasswordDao()

            var passwordModel = dao.getPassword(id)
            showLogDebug(TAG,passwordModel.toString())
        }
    }


    companion object{
        private val TAG = "MAINVIEWMODEL"
    }
}