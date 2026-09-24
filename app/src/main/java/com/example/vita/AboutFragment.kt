package com.example.vita

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.vita.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {

    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Botão Voltar
        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }

        // Formata o texto em negrito no primeiro parágrafo
        val descText = "<b>Vita</b> ajuda você a manter o foco na sua jornada de saúde, registrando refeições, peso e hábitos com simplicidade."
        binding.tvAboutDesc1.text = Html.fromHtml(descText, Html.FROM_HTML_MODE_LEGACY)

        // Clique no Site Oficial
        binding.btnWebsite.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.vita.com"))
            try {
                startActivity(intent)
            } catch (_: Exception) {
                // Ignore
            }
        }

        // Clique no Email / Fale com a gente
        binding.btnEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:contato@foconutri.com")
                putExtra(Intent.EXTRA_SUBJECT, "Contato - App Vita")
            }
            try {
                startActivity(intent)
            } catch (_: Exception) {
                // Ignore
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
