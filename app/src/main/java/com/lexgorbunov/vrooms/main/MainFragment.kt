package com.lexgorbunov.vrooms.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lexgorbunov.vrooms.R
import com.lexgorbunov.vrooms.main.di.MainComponentProvider
import javax.inject.Inject
import javax.inject.Provider

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    @Inject
    lateinit var pViewModel: Provider<MainViewModel>

    private val viewModel: MainViewModel by viewModels(factoryProducer = { vmFactory { pViewModel.get() } })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onAttach(context: Context) {
        (requireActivity() as MainComponentProvider).provideMainComponent().inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }
}

@Suppress("UNCHECKED_CAST")
inline fun <VM : ViewModel> vmFactory(crossinline initializer: () -> VM) =
    object : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T = initializer() as T
    }
