package br.com.minhapizzaria.ui.view.escolha

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.minhapizzaria.databinding.FragmentEscolhaBinding
import br.com.minhapizzaria.domain.Pizza
import br.com.minhapizzaria.presenter.service.RetrofitBuilder
import br.com.minhapizzaria.ui.adapter.EscolhaFragmentAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

/**
 * Created by RubioAlves on 09/04/2021
 */
class EscolhaFragment : Fragment() {

    private var _binding: FragmentEscolhaBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: EscolhaFragmentAdapter
    private lateinit var listaPizza: List<Pizza>

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentEscolhaBinding.inflate(inflater, container, false)

        getAllPizzas()

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBusca()
    }


    private fun getAllPizzas() {

        binding.progressBar.visibility = View.VISIBLE

        val call: Call<List<Pizza>> = RetrofitBuilder.pizzariaApi.getPizza()

        call.enqueue(object : Callback<List<Pizza>> {
            override fun onResponse(call: Call<List<Pizza>>, response: Response<List<Pizza>>) {
                listaPizza = response.body() as MutableList<Pizza>

                adapter = EscolhaFragmentAdapter(this@EscolhaFragment, listaPizza)
                setupUI()
                binding.recyclerView.adapter = adapter

                response.let {

                    it.body()
                    binding.recyclerView.visibility = View.VISIBLE
                    binding.progressBar.visibility = View.GONE
                }


            }

            override fun onFailure(call: Call<List<Pizza>>, t: Throwable) {
                Toast.makeText(requireContext(), t.message, Toast.LENGTH_SHORT).show()
                binding.progressBar.visibility = View.INVISIBLE
            }

        })

    }

    private fun initBusca() {

        binding.busca.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                buscaPizza(s.toString())
            }
        })


    }

    private fun buscaPizza(texto: String) {

        val listPizza: MutableList<Pizza> = mutableListOf()

        for (pizza in listaPizza) {

            if (pizza.name.toLowerCase(Locale.ROOT).contains(texto.toLowerCase(Locale.ROOT))) listPizza.add(pizza)
            Log.d("Lista", pizza.toString())

        }

        adapter.buscarPizzas(listPizza)


    }


    private fun setupUI() {

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.setHasFixedSize(true)


    }

}

