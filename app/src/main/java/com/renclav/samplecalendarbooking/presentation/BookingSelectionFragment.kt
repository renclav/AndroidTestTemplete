package com.renclav.samplecalendarbooking.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.airbnb.mvrx.compose.collectAsState
import com.airbnb.mvrx.compose.mavericksViewModel
import com.renclav.samplecalendarbooking.databinding.BookingSelectionFragmentBinding
import com.renclav.samplecalendarbooking.presentation.theme.SampleCalendarBookingTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
internal class BookingSelectionFragment : Fragment() {

    private var _binding: BookingSelectionFragmentBinding? = null
    private val binding get() = _binding!!

    @OptIn(ExperimentalMaterialApi::class)
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
                    val scaffoldState =
                        rememberBackdropScaffoldState(initialValue = BackdropValue.Revealed)
                    val scope = rememberCoroutineScope()

                    val title by viewModel.collectAsState(BookingSelectionStateModel::toolBarTitle)

                    BackdropScaffold(
                        scaffoldState = scaffoldState,
                        appBar = {
                            TopAppBar(
                                title = { Text(title) },
                                navigationIcon = {
                                    if (scaffoldState.isConcealed) {
                                        IconButton(
                                            onClick = {
                                                scope.launch { scaffoldState.reveal() }
                                            }
                                        ) {
                                            Icon(
                                                Icons.Default.Menu,
                                                contentDescription = "Menu"
                                            )
                                        }
                                    } else {
                                        IconButton(
                                            onClick = {
                                                scope.launch { scaffoldState.conceal() }
                                            }
                                        ) {
                                            Icon(
                                                Icons.Default.Close,
                                                contentDescription = "Close"
                                            )
                                        }
                                    }
                                },
                                elevation = 0.dp,
                                backgroundColor = Color.Transparent
                            )
                        },
                        backLayerContent = {
                            CalenderContent(
                                modifier = Modifier.fillMaxWidth(),
                                viewModel = viewModel,
                                dateSelected = {
                                    viewModel.daySelected(it)
                                    scope.launch { scaffoldState.conceal() }
                                }
                            )
                        },
                        frontLayerContent = {
                            Surface(
                                modifier = Modifier.fillMaxSize(),
                                color = MaterialTheme.colors.background
                            ) {
                                AvailabilityContent(
                                    modifier = Modifier.fillMaxSize(),
                                    viewModel = viewModel,
                                )
                            }
                        },
                        peekHeight = 60.dp,
                    )
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