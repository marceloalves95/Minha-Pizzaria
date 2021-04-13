package br.com.minhapizzaria.ui.main.view.detalhe.sucesso

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import br.com.minhapizzaria.R

public class SucessoFragmentDirections private constructor() {
  public companion object {
    public fun actionSucessoFragmentToEscolhaFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_sucessoFragment_to_escolhaFragment)
  }
}
