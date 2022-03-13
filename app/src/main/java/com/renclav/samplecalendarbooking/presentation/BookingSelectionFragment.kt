package com.renclav.samplecalendarbooking.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.compose.collectAsState
import com.airbnb.mvrx.compose.mavericksViewModel
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.renclav.samplecalendarbooking.Greeting
import com.renclav.samplecalendarbooking.databinding.BookingSelectionFragmentBinding
import com.renclav.samplecalendarbooking.presentation.theme.SampleCalendarBookingTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class BookingSelectionFragment : Fragment() {

    private var _binding: BookingSelectionFragmentBinding? = null
    private val binding get() = _binding!!

   // private val viewModel: BookingSelectionViewModel by fragmentViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BookingSelectionFragmentBinding.inflate(inflater, container, false)
        binding.composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                SampleCalendarBookingTheme {
                    val viewModel: BookingSelectionViewModel = mavericksViewModel()
                    val state by viewModel.collectAsState()
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background
                    ) {
                        Greeting(state.currentBookings.toString())
                    }
                }
            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

/*    override fun invalidate(): Unit = withState(viewModel) { state ->
        binding.testview.text = state.currentBookings()?.toString()
    }*/
}