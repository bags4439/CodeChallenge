package com.test.codechallenge.ui.personal_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.test.codechallenge.R
import com.test.codechallenge.databinding.PersonFragmentBinding
import com.test.codechallenge.ui.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class PersonDetailsFragment : BaseFragment() {

    private val viewModel by viewModel<PersonalDetailsFragViewModel>()
    private lateinit var binding: PersonFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = PersonFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vFirstName.tvLabel.text = resources.getString(R.string.first_name)
        binding.vLastName.tvLabel.text = resources.getString(R.string.last_name)
        binding.vBirthPlace.tvLabel.text = resources.getString(R.string.birth_place)
        binding.vDob.tvLabel.text = resources.getString(R.string.dob)
        binding.vHouseNumber.tvLabel.text = resources.getString(R.string.house_number)
        binding.vCommunity.tvLabel.text = resources.getString(R.string.community)
        binding.vDistrict.tvLabel.text = resources.getString(R.string.district)
        binding.vRegion.tvLabel.text = resources.getString(R.string.region)
        binding.vMaritalStatus.tvLabel.text = resources.getString(R.string.marital_status)

        binding.vTakePhoto.ivIcon.setImageResource(R.drawable.dslr_camera)
        binding.vTakePhoto.ivIcon.setBackgroundResource(R.drawable.ring_black)
        binding.vTakePhoto.tvIconLabel.text = resources.getString(R.string.take_a_photo)

        binding.vUploadPhoto.ivIcon.setImageResource(R.drawable.cloud_computing_one)
        binding.vUploadPhoto.ivIcon.setBackgroundResource(R.drawable.round_black)
        binding.vUploadPhoto.tvIconLabel.text = resources.getString(R.string.upload_photo)
    }
}