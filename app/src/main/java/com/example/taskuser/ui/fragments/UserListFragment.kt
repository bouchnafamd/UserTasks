package com.example.taskuser.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.taskuser.ui.adapters.ItemUserListAdapter
import com.example.taskuser.databinding.FragmentUserListBinding
import com.example.taskuser.utils.extensions.setVisibility
import com.example.taskuser.ui.viewmodels.UserListViewModel
import com.example.taskuser.utils.NO_ERROR
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class UserListFragment : Fragment() {
    private var binding: FragmentUserListBinding?=null
    private val viewModel : UserListViewModel by viewModels()
    @Inject lateinit var itemUserListAdapter : ItemUserListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        binding?.userListRecyclerView?.adapter=itemUserListAdapter
    }

    override fun onResume() {
        super.onResume()
        viewModel.fetchUserList()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding=null
    }

    private fun observeViewModel(){
        viewModel.loading.observe(viewLifecycleOwner,{
            binding?.loadingBar?.setVisibility(it)
        })

        viewModel.listUser.observe(viewLifecycleOwner){
            itemUserListAdapter.update(it)
        }

        viewModel.errorMsg.observe(viewLifecycleOwner){
            binding?.userListRecyclerView?.setVisibility(it==NO_ERROR)
            binding?.userListMessageText?.setVisibility(it!= NO_ERROR)
            if(it!= NO_ERROR) binding?.userListMessageText?.setText(it)

        }

    }
}