package com.example.phonebook2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class InfDetailFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_inf_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    companion object {
        fun newInstance(name: String): InfDetailFragment {
            val fragment = InfDetailFragment()

            return fragment
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.add_option -> {
                val addItemFragment = AddFragment()
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, addItemFragment)
                    .addToBackStack(null)
                    .commit()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

}
