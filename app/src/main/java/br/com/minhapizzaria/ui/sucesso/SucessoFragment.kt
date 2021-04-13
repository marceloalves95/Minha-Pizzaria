package br.com.minhapizzaria.ui.sucesso

import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import br.com.minhapizzaria.R

/**
 * Created by RubioAlves on 09/04/2021
 */

class SucessoFragment : Fragment() {

    private lateinit var viewFragment:View
    private lateinit var done:ImageView
    private lateinit var avd:AnimatedVectorDrawableCompat
    private lateinit var avd2: AnimatedVectorDrawable

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewFragment = inflater.inflate(R.layout.fragment_sucesso, container, false)

        return viewFragment
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        done = view.findViewById(R.id.done)

        initAnimationCircle()

        val teste = view.findViewById<Button>(R.id.voltar)
        teste.setOnClickListener {

            findNavController().navigate(R.id.action_sucessoFragment_to_escolhaFragment)

        }


    }
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun initAnimationCircle(){

        val drawable: Drawable = done.drawable

        if (drawable is AnimatedVectorDrawableCompat) {
            avd = drawable
            avd.start()
        } else if (drawable is AnimatedVectorDrawable) {
            avd2 = drawable
            avd2.start()
        }


    }

}


