package com.game.textadventure.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.game.textadventure.databinding.FragmentTextBinding
import com.game.textadventure.dataViewmodel

class TextFragment : Fragment() {

    lateinit var binding: FragmentTextBinding
    private val handler = Handler(Looper.getMainLooper())
    private val dataViewmodel : dataViewmodel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTextBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        typeText(0,0)
        binding.tvText.setOnClickListener {
            fullText(0,0)
        }
        binding.tvSkip.setOnClickListener {
            fullText(0,0)
        }
    }

    private fun typeText(mainStory: Int, subStory: Int) {
        val tmpText = dataViewmodel.storyArray[mainStory][subStory]

        var delay = 0L

        for(ch in tmpText) {
            handler.postDelayed({
                binding.tvText.text = binding.tvText.text.toString() + ch
                binding.svText.post{
                    binding.svText.fullScroll(View.FOCUS_DOWN)
                }
            }, delay) // 1초마다 실행
            delay += 50
        }
    }
    private fun fullText(mainStory: Int, subStory: Int) {
        val tmpText = dataViewmodel.storyArray[mainStory][subStory]
        if(tmpText == binding.tvText.text.toString()) return
        handler.removeCallbacksAndMessages(null)
        binding.tvText.text = tmpText
        binding.svText.post{
            binding.svText.fullScroll(View.FOCUS_DOWN)
        }
    }

}