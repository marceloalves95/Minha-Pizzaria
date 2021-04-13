package br.com.minhapizzaria.ui.main.view.detalhe.login

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import br.com.minhapizzaria.R

public class LoginFragmentDirections private constructor() {
  public companion object {
    public fun actionLoginFragmentToEscolhaFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_loginFragment_to_escolhaFragment)
  }
}
