package com.example.agroexpress

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import org.imaginativeworld.whynotimagecarousel.CarouselItem
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import com.example.agroexpress.Adaptador.ItemListener
import org.json.JSONObject


class Activity_Inicio_Roles : AppCompatActivity() {

    private val list = mutableListOf<CarouselItem>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_roles)
        val carousel: ImageCarousel = findViewById(R.id.carousel)
        list.add(CarouselItem("https://static.vecteezy.com/system/resources/previews/002/266/395/original/mixed-fruits-with-apple-banana-orange-and-other-free-photo.jpg"))
        list.add(CarouselItem("https://static.vecteezy.com/system/resources/previews/002/266/395/original/mixed-fruits-with-apple-banana-orange-and-other-free-photo.jpg"))
        list.add(CarouselItem("https://cdn-bbolm.nitrocdn.com/rhVOyqGRzkOemInDdraPQRtaBJmVBfaM/assets/images/optimized/rev-8e07b84/wp-content/uploads/2023/03/30-nombres-de-frutas-en-ingles-y-sus-significados-1080x675.jpg"))
        carousel.addData(list)
        }
    }

