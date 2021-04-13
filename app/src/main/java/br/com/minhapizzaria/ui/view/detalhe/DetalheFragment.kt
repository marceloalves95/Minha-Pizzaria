package br.com.minhapizzaria.ui.view.detalhe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import br.com.minhapizzaria.R
import br.com.minhapizzaria.databinding.FragmentDetalheBinding
import com.bumptech.glide.Glide
import java.math.BigDecimal
import java.math.RoundingMode

/**
 * Created by RubioAlves on 09/04/2021
 */
class DetalheFragment : Fragment() {

    private var _binding: FragmentDetalheBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<DetalheFragmentArgs>()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDetalheBinding.inflate(inflater, container, false)

        initViewArgs()

        binding.comprar.setOnClickListener {

            findNavController().navigate(R.id.action_detalheFragment_to_sucessoFragment)

        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initViewArgs() {

        val saborPizza = "Pizza de ${args.detalhes?.nomePizza}"

        val pizzaPequenaDecimal = args.detalhes?.tamanhoPequeno?.let { BigDecimal(it.toDouble()).setScale(2, RoundingMode.HALF_EVEN) }
        val pizzaMediaDecimal = args.detalhes?.tamanhoMedio?.let { BigDecimal(it.toDouble()).setScale(2, RoundingMode.HALF_EVEN) }
        val pizzaGrandeDecimal = args.detalhes?.tamanhoGrande?.let { BigDecimal(it.toDouble()).setScale(2, RoundingMode.HALF_EVEN) }


        val precoPizzaPequena = "R$ $pizzaPequenaDecimal"
        val precoPizzaMedio = "R$ $pizzaMediaDecimal"
        val precoPizzaGrande = "R$ $pizzaGrandeDecimal"

        val precoPizzaPequenaCorrigido = precoPizzaPequena.replace(".", ",")
        val precoPizzaMediaCorrigida = precoPizzaMedio.replace(".", ",")
        val precoPizzaGrandeCorrigido = precoPizzaGrande.replace(".", ",")

        Glide.with(this).load(args.detalhes?.imageUrl).into(binding.image)
        binding.saborPizza.text = saborPizza
        binding.ratingBarPizza.rating = args.rating

        binding.precoPizza.text = precoPizzaPequenaCorrigido

        binding.pizzaPequena.setBackgroundColor(resources.getColor(R.color.botao_verde))
        binding.pizzaPequena.setTextColor(resources.getColor(R.color.branco_fundo))
        binding.pizzaMedia.setBackgroundColor(resources.getColor(R.color.branco_fundo))
        binding.pizzaMedia.setTextColor(resources.getColor(R.color.fundo))
        binding.pizzaGrande.setBackgroundColor(resources.getColor(R.color.branco_fundo))
        binding.pizzaGrande.setTextColor(resources.getColor(R.color.fundo))


        binding.pizzaPequena.setOnClickListener {

            binding.precoPizza.text = precoPizzaPequenaCorrigido
            binding.pizzaPequena.setBackgroundColor(resources.getColor(R.color.botao_verde))
            binding.pizzaPequena.setTextColor(resources.getColor(R.color.branco_fundo))
            binding.pizzaMedia.setBackgroundColor(resources.getColor(R.color.branco_fundo))
            binding.pizzaMedia.setTextColor(resources.getColor(R.color.fundo))
            binding.pizzaGrande.setBackgroundColor(resources.getColor(R.color.branco_fundo))
            binding.pizzaGrande.setTextColor(resources.getColor(R.color.fundo))

        }

        binding.pizzaMedia.setOnClickListener {

            binding.precoPizza.text = precoPizzaMediaCorrigida

            binding.pizzaMedia.setBackgroundColor(resources.getColor(R.color.botao_verde))
            binding.pizzaMedia.setTextColor(resources.getColor(R.color.branco_fundo))
            binding.pizzaPequena.setBackgroundColor(resources.getColor(R.color.branco_fundo))
            binding.pizzaPequena.setTextColor(resources.getColor(R.color.fundo))
            binding.pizzaGrande.setBackgroundColor(resources.getColor(R.color.branco_fundo))
            binding.pizzaGrande.setTextColor(resources.getColor(R.color.fundo))

        }

        binding.pizzaGrande.setOnClickListener {

            binding.precoPizza.text = precoPizzaGrandeCorrigido

            binding.pizzaGrande.setBackgroundColor(resources.getColor(R.color.botao_verde))
            binding.pizzaGrande.setTextColor(resources.getColor(R.color.branco_fundo))
            binding.pizzaMedia.setBackgroundColor(resources.getColor(R.color.branco_fundo))
            binding.pizzaMedia.setTextColor(resources.getColor(R.color.fundo))
            binding.pizzaPequena.setBackgroundColor(resources.getColor(R.color.branco_fundo))
            binding.pizzaPequena.setTextColor(resources.getColor(R.color.fundo))

        }


    }


}