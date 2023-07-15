package com.vaibhavrawat.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FirstFragment : Fragment(), ActivityInterface {
    private var param1: String? = null
    private var param2: String? = null
    lateinit var mainActivity: MainActivity
    private var initView: View? = null
    var tvText: TextView? = null
    var tvData : TextView?= null
    private var tvDataFromActivity: TextView? = null
    var number : Int = 0
    var btnClear : Button ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as MainActivity
        mainActivity.activityFragment = this
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initView = inflater.inflate(R.layout.fragment_first, container, false)
        return initView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvText = view.findViewById(R.id.tvText)
        tvDataFromActivity = view.findViewById(R.id.tvDataFromActivity)
        tvData = view.findViewById(R.id.tvData)
        btnClear = view.findViewById(R.id.btnClear)
        tvText?.setOnClickListener {
            Toast.makeText(requireActivity(), "clickedFromFragment", Toast.LENGTH_SHORT).show()
            mainActivity.changeFragmentText()
        }
        btnClear?.setOnClickListener {
            tvData?.text="0"
            tvDataFromActivity?.text = "Hello, NULL"
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    @SuppressLint("SetTextI18n")
    override fun changeFragmentName(text: String) {
        tvDataFromActivity?.text = "Hello, $text"
    }

    override fun changeFragmentIncrement() {
        number+=1
        tvData?.text="$number"
    }

    override fun changeFragmentDecrement() {
        number-=1
        tvData?.text="$number"

    }
}
