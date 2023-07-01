package com.example.agroexpress


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.agroexpress.R
import android.widget.*
import androidx.navigation.Navigation


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 * Use the [MasOpcionesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MasOpcionesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var btnProducto: Button
    private lateinit var btnCampesinos:Button
    private lateinit var btnDespachos: Button
    private lateinit var btnEntrega:Button
    private lateinit var btnPedidos:Button
    private lateinit var btnDevolucion:Button
    private lateinit var btnTransportador:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val ll = inflater.inflate(R.layout.fragment_mas_opciones, container, false)

        this.btnProducto =ll.findViewById(R.id.btnProducto)
        this.btnCampesinos =ll.findViewById(R.id.btnCampesinos)
        this.btnDespachos = ll.findViewById(R.id.btnDespachos)
        this.btnEntrega = ll.findViewById(R.id.btnEntrega)
        this.btnPedidos = ll.findViewById(R.id.btnPedidos)
        this.btnDevolucion = ll.findViewById(R.id.btnDevolucion)
        this.btnTransportador = ll.findViewById(R.id.btnTransportador)


        btnProducto.setOnClickListener{
            val navController = Navigation.findNavController(requireActivity(), R.id.btnProducto)
            navController.navigate(R.id.produc_RecyclerFragment)
        }

        btnCampesinos.setOnClickListener {
            val navController = Navigation.findNavController(requireActivity(), R.id.btnCampesinos)
            navController.navigate(R.id.camp_RecyclerFragment)
        }

        btnDespachos.setOnClickListener {
            val navController = Navigation.findNavController(requireActivity(), R.id.btnDespachos)
            navController.navigate(R.id.despachos_RecyclerFragment)
        }

        btnEntrega.setOnClickListener {
            val navController = Navigation.findNavController(requireActivity(), R.id.btnEntrega)
            navController.navigate(R.id.entrega_RecyclerFragment)
        }

        btnPedidos.setOnClickListener {
            val navController = Navigation.findNavController(requireActivity(), R.id.btnPedidos)
            navController.navigate(R.id.pedidos_RecyclerFragment)
        }

        btnDevolucion.setOnClickListener {
            val navController = Navigation.findNavController(requireActivity(), R.id.btnDevolucion)
            navController.navigate(R.id.devolucion_recyclerFragment)
        }

        btnTransportador.setOnClickListener {
            val navController = Navigation.findNavController(requireActivity(), R.id.btnTransportador)
            navController.navigate(R.id.transp_RecyclerFragment)
        }
        return ll
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bottomSopor:Button=view.findViewById(R.id.btnSoporte)
        bottomSopor.setOnClickListener {
            val intent=Intent(getActivity(),Activity_soporte::class.java)
            startActivity(intent)
        }    
    }
}