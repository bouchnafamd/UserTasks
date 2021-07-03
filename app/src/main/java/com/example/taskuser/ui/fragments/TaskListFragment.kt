package com.example.taskuser.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.taskuser.databinding.FragmentTaskListBinding
import com.example.taskuser.ui.adapters.ItemTaskListAdapter
import com.example.taskuser.ui.viewmodels.TaskListViewModel
import com.example.taskuser.utils.NO_ERROR
import com.example.taskuser.utils.extensions.setVisibility
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TaskListFragment : Fragment() {
    private var binding: FragmentTaskListBinding? = null
    private val viewModel : TaskListViewModel by viewModels()
    private val args : TaskListFragmentArgs by navArgs()
    @Inject lateinit var itemTaskListAdapter: ItemTaskListAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTaskListBinding.inflate(layoutInflater,container,false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        binding?.userTaskListRecyclerView?.adapter=itemTaskListAdapter
    }

    override fun onResume() {
        super.onResume()
        viewModel.fetchTaskList(args.userId)
    }

    private fun observeViewModel() {
        viewModel.loading.observe(viewLifecycleOwner, {
            binding?.loadingBar?.setVisibility(it)
        })

        viewModel.userTaskList.observe(viewLifecycleOwner,{
            itemTaskListAdapter.update(it)
        })

        viewModel.errorMsg.observe(viewLifecycleOwner,{
            binding?.userTaskListRecyclerView?.setVisibility(it== NO_ERROR)
            binding?.taskListMessageText?.setVisibility(it!= NO_ERROR)
            if(it!= NO_ERROR) binding?.taskListMessageText?.setText(it)
        })
    }
}