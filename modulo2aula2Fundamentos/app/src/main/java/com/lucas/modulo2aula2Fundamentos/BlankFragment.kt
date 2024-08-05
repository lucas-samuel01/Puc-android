    package com.lucas.modulo2aula2Fundamentos

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

const val fragmenTAG:String = "FragmentTAg"

class BlankFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        println("$fragmenTAG${javaClass.simpleName} on atatach")

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        println("$fragmenTAG${javaClass.simpleName} on create")
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        println("$fragmenTAG${javaClass.simpleName} onCreateView")

        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        println("$fragmenTAG${javaClass.simpleName} on activityCreated")

    }

    override fun onStart() {
        super.onStart()
        println("$fragmenTAG${javaClass.simpleName} on create")
    }

    override fun onResume() {
        super.onResume()
        println("$fragmenTAG${javaClass.simpleName} on resume")

    }

    override fun onPause() {
        super.onPause()
        println("$fragmenTAG${javaClass.simpleName} pausou")

    }

    override fun onStop() {
        super.onStop()
        println("$fragmenTAG${javaClass.simpleName} on stop")

    }

    override fun onDestroyView() {
        super.onDestroyView()
        println("$fragmenTAG${javaClass.simpleName} on destroy view")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("$fragmenTAG${javaClass.simpleName} on destroy")

    }

    override fun onDetach() {
        super.onDetach()
        println("$fragmenTAG${javaClass.simpleName} on DEatach")

    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}