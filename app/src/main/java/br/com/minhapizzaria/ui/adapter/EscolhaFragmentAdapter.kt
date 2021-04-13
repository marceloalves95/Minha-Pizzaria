package br.com.minhapizzaria.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import br.com.minhapizzaria.databinding.FragmentEscolhaAdapterBinding
import br.com.minhapizzaria.domain.Pizza
import br.com.minhapizzaria.ui.view.detalhe.DetalheArgs
import br.com.minhapizzaria.ui.view.escolha.EscolhaFragment
import br.com.minhapizzaria.ui.view.escolha.EscolhaFragmentDirections
import com.bumptech.glide.Glide
import java.math.BigDecimal
import java.math.RoundingMode

/**
 * Created by RubioAlves on 10/04/2021
 */
class EscolhaFragmentAdapter(private val escolhaFragment: EscolhaFragment, private var listaPizza:List<Pizza>) : RecyclerView.Adapter<EscolhaFragmentAdapter.EscolhaFragmentViewHolder>() {


    inner class EscolhaFragmentViewHolder(private val item: FragmentEscolhaAdapterBinding) : RecyclerView.ViewHolder(item.root) {

        fun bind(pizza: Pizza){

            val decimal = BigDecimal(pizza.priceP.toDouble()).setScale(2, RoundingMode.HALF_EVEN)
            val nomePizza =  "Pizza de ${pizza.name}"
            val valorPizza = "R$ $decimal"
            val precoPizzaCorrigido = valorPizza.replace(".", ",")

            item.pizza.text = nomePizza
            item.valorPizza.text = precoPizzaCorrigido
            Glide.with(escolhaFragment).load(pizza.imageUrl).into(item.imagePizza)
            item.ratingBar.rating = pizza.rating

            item.cardView.setOnClickListener {

                onItemClick?.invoke(adapterPosition)

                argumentosDetalhe(pizza)

            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EscolhaFragmentAdapter.EscolhaFragmentViewHolder {

        val itemBinding = FragmentEscolhaAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EscolhaFragmentViewHolder(itemBinding)

    }

    override fun onBindViewHolder(holder: EscolhaFragmentAdapter.EscolhaFragmentViewHolder, position: Int) {

        holder.bind(listaPizza[position])

    }

    override fun getItemCount(): Int = listaPizza.size

    var onItemClick: ((Int) -> Unit)? = null


    private fun argumentosDetalhe(pizza:Pizza){

        val pizzaArgs = DetalheArgs(pizza.imageUrl, pizza.name,pizza.priceP,pizza.priceM, pizza.priceG)
        val rating = pizza.rating
        val action = EscolhaFragmentDirections.actionEscolhaFragmentToDetalheFragment(pizzaArgs, rating)

        escolhaFragment.findNavController().navigate(action)

    }


    fun buscarPizzas(lista:MutableList<Pizza>){

        listaPizza = lista
        notifyDataSetChanged()

    }


}