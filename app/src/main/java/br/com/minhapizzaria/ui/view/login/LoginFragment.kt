package br.com.minhapizzaria.ui.main.view.detalhe.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.minhapizzaria.R
import br.com.minhapizzaria.databinding.FragmentLoginBinding
import br.com.minhapizzaria.domain.Signin
import br.com.minhapizzaria.domain.ValidadorLogin
import br.com.minhapizzaria.presenter.service.LoginService
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by RubioAlves on 09/04/2021
 */

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var usuario: String
    private lateinit var senha: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.entrar.setOnClickListener {

            initCampos()
            validarCampos()

        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initCampos() {

        usuario = binding.usuario.editableText.toString().trim()
        senha = binding.senha.editableText.toString().trim()

    }

    private fun validarCampos(): Boolean {

        var validador = true

        when {

            usuario.isEmpty() && senha.isEmpty() -> {
                Snackbar.make(requireView(), "Preencha os dados corretamente", Snackbar.LENGTH_LONG)
                    .show()
                validador = false
                return validador
            }
            usuario.isNotEmpty() && senha.isEmpty() -> {
                Snackbar.make(requireView(), "Preencha os dados corretamente", Snackbar.LENGTH_LONG)
                    .show()
                validador = false
                return validador
            }
            senha.isNotEmpty() && usuario.isEmpty() -> {
                Snackbar.make(requireView(), "Preencha os dados corretamente", Snackbar.LENGTH_LONG)
                    .show()
                validador = false
                return validador

            }
            else -> login()
        }

        return validador


    }

    private fun login() {

        val teste = ValidadorLogin(usuario,senha)
        val call: Call<Signin> =
            LoginService.instance?.getLoginApi()?.getLogin(teste) as Call<Signin>
        call.enqueue(object : Callback<Signin> {
            override fun onResponse(call: Call<Signin>, response: Response<Signin>) {

                if (response.isSuccessful) {
                    Snackbar.make(requireView(), "Login com Sucesso", Snackbar.LENGTH_LONG).show()
                    findNavController().navigate(R.id.action_loginFragment_to_escolhaFragment)
                } else {
                    Snackbar.make(requireView(), "Falha no Login", Snackbar.LENGTH_LONG).show()
                }

            }

            override fun onFailure(call: Call<Signin>, t: Throwable) {
                Toast.makeText(requireContext(), t.message, Toast.LENGTH_SHORT).show()
            }
        })



    }


}