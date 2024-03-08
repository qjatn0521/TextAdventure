package com.game.textadventure

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.game.textadventure.databinding.ActivityMainBinding
import com.game.textadventure.fragment.TextFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomNav()


    }


    private fun initBottomNav() {
        // 자리를 비워놓은(플로팅 버튼) 아이템에 대해 비활성화
        binding.mainBottomNav.menu.getItem(2).isEnabled = false
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.main_frm) as NavHostFragment
        val navController = navHostFragment.findNavController()
        binding.mainBottomNav.setupWithNavController(navController)

        binding.mainFloatingAddBtn.setOnClickListener {
            navController.navigate(R.id.fragment_text)
        }
    }

}