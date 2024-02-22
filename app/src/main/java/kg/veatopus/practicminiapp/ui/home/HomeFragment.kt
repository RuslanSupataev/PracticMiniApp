package kg.veatopus.practicminiapp.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kg.veatopus.practicminiapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
	
	private var _binding: FragmentHomeBinding? = null
	private val binding get() = _binding!!
	
	private lateinit var viewModel: HomeViewModel
	
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
		_binding = FragmentHomeBinding.inflate(inflater, container, false)
		return binding.root
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		setObservers()
		setListeners()
	}
	
	private fun setListeners() {
		binding.btnCreate.setOnClickListener {
			viewModel.create(
				title = binding.etTitle.text.toString(),
				desc = binding.etDesc.text.toString()
			)
		}
	}
	
	private fun setObservers() {
		viewModel.error.observe(viewLifecycleOwner) { errorText ->
			Toast.makeText(requireContext(), errorText, Toast.LENGTH_SHORT).show()
		}
		
		viewModel.tasks.observe(viewLifecycleOwner) { tasks ->
			Log.e("ololo", "setObservers: got all tasks : $tasks")
		}
	}
	
	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}