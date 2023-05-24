package com.test.codechallenge.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.tabs.TabLayout
import com.test.codechallenge.R
import com.test.codechallenge.databinding.HomeFragmentBinding
import com.test.codechallenge.ui.BaseFragment
import com.test.codechallenge.ui.personal_details.PersonDetailsFragment
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : BaseFragment() {

    private lateinit var binding: HomeFragmentBinding
    private lateinit var homeAdapter: HomeAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        homeAdapter = HomeAdapter(childFragmentManager)
//        binding.pager.adapter = homeAdapter

//        binding.tabsLayout.setupWithViewPager(binding.pager)

//        binding.pager.currentItem=1

        binding.tabsLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
               when (tab?.position){
                   0 -> displayFragment(Fragment())
                   1 -> displayFragment(PersonDetailsFragment())
                   2 -> displayFragment(Fragment())
               }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })

        binding.tabsLayout.getTabAt(1)?.select()
    }

    private fun displayFragment(fragment: Fragment){
        val transaction = childFragmentManager.beginTransaction()
        transaction.disallowAddToBackStack()
        if(v_container.childCount>0){
            transaction.replace(R.id.v_container, fragment)
        } else {
            transaction.add(R.id.v_container, fragment)
        }
        transaction.commit()
    }
}