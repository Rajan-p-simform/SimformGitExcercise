package simform.gitexcercise.authentication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.navigation.NavController
import androidx.navigation.Navigation
import simform.gitexcercise.android.R
import simform.gitexcercise.android.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentRegistrationBinding
    private val navigationController: NavController? by lazy {
        view?.let { Navigation.findNavController(it)}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_registration,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setVariable(BR.onButtonClick,this)
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.button_register -> Toast.makeText(activity, "Registered", Toast.LENGTH_SHORT).show()
            R.id.button_go_to_login -> view.let { navigationController?.navigate(R.id.action_registrationFragment_to_loginFragment) }
        }
    }
}