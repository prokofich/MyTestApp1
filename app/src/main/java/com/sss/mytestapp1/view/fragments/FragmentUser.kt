package com.sss.mytestapp1.view.fragments

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.annotation.RequiresApi
import com.sss.mytestapp1.R
import com.sss.mytestapp1.databinding.FragmentUserBinding
import com.sss.mytestapp1.model.constant.MAIN
import com.sss.mytestapp1.model.modelUser.UserItem

class FragmentUser : Fragment() {

    private var binding: FragmentUserBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserBinding.inflate(inflater,container,false)
        return binding?.root
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val user = requireArguments().getParcelable<UserItem>("key")

        binding?.idFragment2TvName?.text = user?.name
        binding?.idFragment2TvUsername?.text = user?.username
        binding?.idFragment2TvMail?.text = user?.email

        binding?.idFragment2TvStreet?.text = getString(R.string.street, user?.address?.street)
        binding?.idFragment2TvSuite?.text = getString(R.string.suite, user?.address?.suite)
        binding?.idFragment2TvCity?.text = getString(R.string.city, user?.address?.city)
        binding?.idFragment2TvZipcode?.text = getString(R.string.zipcode, user?.address?.zipcode)

        binding?.idFragment2TvGeolat?.text = getString(R.string.geoLat, user?.address?.geo?.lat)
        binding?.idFragment2TvGeolng?.text = getString(R.string.geoLng, user?.address?.geo?.lng)

        binding?.idFragment2TvPhone?.text = getString(R.string.phone, user?.phone)
        binding?.idFragment2TvWebsite?.text = getString(R.string.website, user?.website)

        binding?.idFragment2TvNameCompany?.text = getString(R.string.nameCompany, user?.company?.name)
        binding?.idFragment2TvCatchPhrase?.text = getString(R.string.catchphrase, user?.company?.catchPhrase)
        binding?.idFragment2TvCompanyBs?.text = getString(R.string.companyBs, user?.company?.bs)

        binding?.idFragment2ButtonBack?.setOnClickListener {
            MAIN?.navController?.navigate(R.id.action_fragmentUser_to_fragmentUsersAndVideo)
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner){
            MAIN?.navController?.navigate(R.id.action_fragmentUser_to_fragmentUsersAndVideo)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}