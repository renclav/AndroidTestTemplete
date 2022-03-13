package com.renclav.samplecalendarbooking.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.renclav.samplecalendarbooking.databinding.BookingSelectionFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class BookingSelectionFragment : Fragment(), MavericksView {

    private var _binding: BookingSelectionFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: BookingSelectionViewModel by fragmentViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BookingSelectionFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun invalidate(): Unit = withState(viewModel) { state ->
        binding.testview.text = state.currentBookings()?.toString()
    }
}