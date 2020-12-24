package me.donnie.android.apps.general.ui.login

import android.os.Bundle
import androidx.fragment.app.activityViewModels
import me.donnie.android.apps.general.R
import me.donnie.android.apps.general.databinding.FragmentLoginBinding
import me.donnie.android.apps.general.navigation.NavigationDispatcher
import me.donnie.android.apps.general.ui.base.DataBindingFragment
import me.donnie.android.apps.general.util.viewModels

/**
 * @author: zhongzhan
 * @email: zhongzhan@weeget.cn
 * @date: 2020/12/21 14:49
 */
class LoginFragment : DataBindingFragment<FragmentLoginBinding>() {

    private val dispatcher: NavigationDispatcher by activityViewModels()

    private val model: LoginViewModel by viewModels {
        { LoginViewModel(dispatcher) }
    }

    override fun getLayoutResId(): Int = R.layout.fragment_login

    override fun initView(savedInstanceState: Bundle?) {
        with(binding) {
            loginButton.setOnClickListener {
                model.login()
            }
        }
    }
}