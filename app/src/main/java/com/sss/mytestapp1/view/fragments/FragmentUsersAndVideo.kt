package com.sss.mytestapp1.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.sss.mytestapp1.R
import com.sss.mytestapp1.databinding.FragmentUsersAndVideoBinding
import com.sss.mytestapp1.model.adapter.InterfaceForUsersAdapter
import com.sss.mytestapp1.model.adapter.UsersAdapter
import com.sss.mytestapp1.model.constant.MAIN
import com.sss.mytestapp1.model.modelUser.UserItem
import com.sss.mytestapp1.viewmodel.UsersViewModel

class FragmentUsersAndVideo : Fragment(),InterfaceForUsersAdapter {

    private var binding:FragmentUsersAndVideoBinding? = null
    private var recyclerView: RecyclerView? = null
    private var usersAdapter: UsersAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUsersAndVideoBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val usersViewModel = ViewModelProvider(this)[UsersViewModel::class.java]

        recyclerView = binding?.idFragment1Rv
        usersAdapter = UsersAdapter(this)
        recyclerView?.adapter = usersAdapter

        usersViewModel.getUsers()

        usersViewModel.users.observe(viewLifecycleOwner){ data ->
            usersAdapter?.setList(data.body())
        }

        binding?.idFragment1CsButtonsButtonUsers?.setOnClickListener {
            binding?.idFragment1Webview?.isVisible = false
            binding?.idFragment1Rv?.isVisible = true
            usersViewModel.getUsers()
        }

        binding?.idFragment1CsButtonsButtonVideo?.setOnClickListener {
            binding?.idFragment1Rv?.isVisible = false
            binding?.idFragment1Webview?.isVisible = true
            showVideo()
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner){
            if(binding?.idFragment1Webview?.isVisible == true){
                binding?.idFragment1Webview?.isVisible = false
            }else{
                MAIN?.finishAffinity()
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun showFullDescription(user: UserItem) {
        val bundle = Bundle()
        bundle.putParcelable("key",user)
        MAIN?.navController?.navigate(R.id.action_fragmentUsersAndVideo_to_fragmentUser,bundle)
    }

    private fun showVideo(){
        binding?.idFragment1Webview?.loadUrl("https://www.youtube.com/watch?v=QKWAvLeayec&ab_channel=MARGO")
    }

}