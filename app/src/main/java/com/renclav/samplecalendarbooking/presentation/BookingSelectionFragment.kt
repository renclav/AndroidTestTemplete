package com.renclav.samplecalendarbooking.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.*
import androidx.fragment.app.Fragment
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.MapStyleOptions
import com.renclav.samplecalendarbooking.R
import com.renclav.samplecalendarbooking.databinding.BookingSelectionFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class BookingSelectionFragment : Fragment(), MavericksView, OnMapReadyCallback  {

    private var _binding: BookingSelectionFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DummyFeatureViewModel by fragmentViewModel()

    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BookingSelectionFragmentBinding.inflate(inflater, container, false)
        binding.composeView.apply {
          /*  setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                SampleCalendarBookingTheme {
                    val viewModel: DummyFeatureViewModel = mavericksViewModel()
                    val scaffoldState =
                        rememberBackdropScaffoldState(initialValue = BackdropValue.Revealed)
                    val scope = rememberCoroutineScope()


                    BackdropScaffold(
                        scaffoldState = scaffoldState,
                        appBar = {
                            TopAppBar(
                                title = { Text("Cool) },
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
                            AvailabilityContent(
                                modifier = Modifier.fillMaxSize(),
                                viewModel = viewModel,
                            )
                        },
                        peekHeight = 60.dp,
                    )
                }
            }*/
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMapFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initMapFragment() {

        val mapFragment: SupportMapFragment =
            childFragmentManager.findFragmentById(binding.map.id) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }


    override fun invalidate(): Unit = withState(viewModel) { state ->
 //       TODO("Not yet implemented")
    }

    override fun onMapReady(map: GoogleMap) {
        //
    }
}