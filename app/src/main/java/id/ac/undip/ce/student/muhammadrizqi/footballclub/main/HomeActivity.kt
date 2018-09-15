package id.ac.undip.ce.student.muhammadrizqi.footballclub.main;

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity;
import id.ac.undip.ce.student.muhammadrizqi.footballclub.R
import id.ac.undip.ce.student.muhammadrizqi.footballclub.R.id.favorites
import id.ac.undip.ce.student.muhammadrizqi.footballclub.R.id.teams
import id.ac.undip.ce.student.muhammadrizqi.footballclub.R.layout.activity_home
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity(){
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(activity_home)

         bottom_navigation.setOnNavigationItemSelectedListener { item ->
             when (item.itemId){
                 teams -> {
                     loadTeamsFragment(savedInstanceState)

                 }
                 favorites -> {
                    loadFavoritesFragment(savedInstanceState)
                 }
             }
             true
         }
         bottom_navigation.selectedItemId = teams
     }

    private fun loadTeamsFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, TeamsFragment(), TeamsFragment::class.java.simpleName)
                    .commit()
        }
    }

    private fun loadFavoritesFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, FavoriteTeamsFragment(), FavoriteTeamsFragment::class.java.simpleName)
                    .commit()
        }
    }
}