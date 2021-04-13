package br.com.minhapizzaria.ui.view.detalhe

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by RubioAlves on 11/04/2021
 */
@Parcelize
data class DetalheArgs(
        val imageUrl: String,
        val nomePizza: String,
        val tamanhoPequeno: Float,
        val tamanhoMedio: Float,
        val tamanhoGrande: Float,
) : Parcelable

