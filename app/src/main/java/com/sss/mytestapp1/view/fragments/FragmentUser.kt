package com.sss.mytestapp1.view.fragments

import android.annotation.SuppressLint
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

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val user = requireArguments().getParcelable<UserItem>("key")

        binding?.idFragment2TvName?.text = user?.name
        binding?.idFragment2TvUsername?.text = user?.username
        binding?.idFragment2TvMail?.text = user?.email

        binding?.idFragment2TvStreet?.text = "Street: ${user?.address?.street}"
        binding?.idFragment2TvSuite?.text = "Suite: ${user?.address?.suite}"
        binding?.idFragment2TvCity?.text = "City: ${user?.address?.city}"
        binding?.idFragment2TvZipcode?.text = "Zipcode : ${user?.address?.zipcode}"

        binding?.idFragment2TvGeolat?.text = "Geo lat : ${user?.address?.geo?.lat}"
        binding?.idFragment2TvGeolng?.text = "Geo lng : ${user?.address?.geo?.lng}"

        binding?.idFragment2TvPhone?.text = "Phone : ${user?.phone}"
        binding?.idFragment2TvWebsite?.text = "Website : ${user?.website}"

        binding?.idFragment2TvNameCompany?.text = "Name company : ${user?.company?.name}"
        binding?.idFragment2TvCatchPhrase?.text = "Catchphrase : ${user?.company?.catchPhrase}"
        binding?.idFragment2TvCompanyBs?.text = "Company bs: ${user?.company?.bs}"

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