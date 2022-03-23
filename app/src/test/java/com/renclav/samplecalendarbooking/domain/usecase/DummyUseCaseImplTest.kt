package com.renclav.samplecalendarbooking.domain.usecase

import app.cash.turbine.test
import com.renclav.samplecalendarbooking.MainCoroutineScopeRule
import com.renclav.samplecalendarbooking.data.model.ResultClass
import com.renclav.samplecalendarbooking.data.repository.PlaceholderRepository
import com.renclav.samplecalendarbooking.domain.mapper.DummyResponseMapperImpl
import com.renclav.samplecalendarbooking.util.coroutines.AppCoroutineDispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.stub

@OptIn(ExperimentalCoroutinesApi::class)
class DummyUseCaseImplTest {

    @get:Rule
    val coroutineRule = MainCoroutineScopeRule()

    private companion object {
        const val USER_ID = "id"
    }

    private lateinit var dummyUseCase: DummyUseCase
    private val placeholderRepository = mock<PlaceholderRepository>()
    private val currentBookingsResponseMapper = DummyResponseMapperImpl()

    @Before
    fun setUp() {
        dummyUseCase = DummyUseCaseImpl(
            dispatchers = AppCoroutineDispatchers(coroutineRule.dispatcher),
            placeholderRepository = placeholderRepository,
            currentBookingsResponseMapper = currentBookingsResponseMapper,
        )
    }

    @Test
    fun `Flow completes without error`() = coroutineRule.runBlockingTest {
        val repoResult = successRepoResult()

        placeholderRepository
            .stub {
                onBlocking {
                    getDummyThing(ArgumentMatchers.anyString())
                }.doReturn(repoResult)
            }

        dummyUseCase(USER_ID)
            .test {
                val result: List<String> = awaitItem()
               // assertThat(result.size).isEqualTo(repoResult.)
                awaitComplete()
            }
    }

    /**
     * Additional tests to check error states of null, empty and exception handling required
     */

    /**
     * Could be cleaner with a standalone 'fake' of the repo providing these fake results
     */
    private fun successRepoResult() =
        ResultClass()
}