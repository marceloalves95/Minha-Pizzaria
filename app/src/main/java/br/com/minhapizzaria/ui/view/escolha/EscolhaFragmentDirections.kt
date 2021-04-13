package br.com.minhapizzaria.ui.main.view.detalhe.escolha

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import br.com.minhapizzaria.R
import br.com.minhapizzaria.ui.main.view.detalhe.DetalheArgs
import java.io.Serializable
import kotlin.Float
import kotlin.Int
import kotlin.Suppress

public class EscolhaFragmentDirections private constructor() {
  private data class ActionEscolhaFragmentToDetalheFragment(
    public val detalhes: DetalheArgs? = null,
    public val rating: Float
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_escolhaFragment_to_detalheFragment

    @Suppress("CAST_NEVER_SUCCEEDS")
    public override fun getArguments(): Bundle {
      val result = Bundle()
      if (Parcelable::class.java.isAssignableFrom(DetalheArgs::class.java)) {
        result.putParcelable("detalhes", this.detalhes as Parcelable?)
      } else if (Serializable::class.java.isAssignableFrom(DetalheArgs::class.java)) {
        result.putSerializable("detalhes", this.detalhes as Serializable?)
      }
      result.putFloat("rating", this.rating)
      return result
    }
  }

  public companion object {
    public fun actionEscolhaFragmentToDetalheFragment(detalhes: DetalheArgs? = null, rating: Float):
        NavDirections = ActionEscolhaFragmentToDetalheFragment(detalhes, rating)
  }
}
