package com.muslima.mygallery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.muslima.mygallery.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ItemClickedListener {
    private val showDataList = listOf(
        ShowData(
            "https://i.pinimg.com/736x/10/42/de/1042deed77f4a7b9859b39a9c95d14a0.jpg",
            "Mango",
            "Mangoes originated from the region between northwestern Myanmar, Bangladesh, and northeastern India.[1][2] The mango is considered an evolutionary anachronism, whereby seed dispersal was once accomplished by a now-extinct evolutionary forager, such as a megafauna mammal."
        ),
        ShowData(
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR6qrti1b4N_HG73y0vrLF75ODHZiLqzeKBwQ&usqp=CAU",
            "AGuava",
            "Psidium species are eaten by the caterpillars of some Lepidoptera, mainly moths like the Ello Sphinx (Erinnyis ello), Eupseudosoma aberrans, E. involutum, and Hypercompe icasia. Mites, like Pronematus pruni and Tydeus munsteri, are known to be crop pests of the apple guava (P. guajava) and perhaps other species.[2] The bacterium Erwinia psidii causes rot diseases of the apple guava"
        ),
        ShowData(
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT3myT2oGlaobhoIIrH_yYgS4h083T0TI7D0Q&usqp=CAU",
            "Lemon",
            "The tree's ellipsoidal yellow fruit is used for culinary and non-culinary purposes throughout the world, primarily for its juice, which has both culinary and cleaning uses.[2] The pulp and rind are also used in cooking and baking. The juice of the lemon is about 5-6% citric acid,[citation needed] with a pH of around 2.2,[3] giving it a sour taste. The distinctive sour taste of lemon juice, derived from the citric acid, makes it a key ingredient in drinks and foods[4] such as lemonade and lemon meringue pie."
        ),
        ShowData(
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFKnJKu6bbpalwTIi49hcbiN9PZP74u_mUsg&usqp=CAU",
            "Litchi",
            "It is a tropical tree native to South China, Malaysia, and northern Vietnam.[4][5] The tree has been introduced throughout Southeast Asia and South Asia.[5] Cultivation in China is documented from the 11th century.[4] China is the main producer of lychees, followed by Vietnam, India, other countries in Southeast Asia, other countries in the Indian subcontinent, Madagascar, and South Africa. A tall evergreen tree, it bears small fleshy sweet fruits. The outside of the fruit is a pink-red, rough-textured soft shell."
        ),
        ShowData(
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR9eIHw4Ku5Bx106EGaio8HGK6UjVDUHUpLNw&usqp=CAU",
            "Banana",
            "The banana plant is the largest herbaceous flowering plant.[10] All the above-ground parts of a banana plant grow from a structure usually called a \"corm\".[11] Plants are normally tall and fairly sturdy with a treelike appearance, but what appears to be a trunk is actually a \"false stem\" or pseudostem. Bananas grow in a wide variety of soils, as long as the soil is at least 60 centimetres (2.0 ft) deep, has good drainage and is not compacted.[12] Banana plants are among the fastest growing of all plants, with daily surface growth rates recorded from 1.4 square metres (15 sq ft) to 1.6 square metres (17 sq ft)."
        ),
        ShowData(
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRgvzJSZdSsqUj7onAVZtPywzrvwhkgCvQ4xg&usqp=CAU",
            "JackFruit",
            "Jackfruit, (Artocarpus heterophyllus), evergreen tree (family Moraceae) native to tropical Asia and widely grown throughout the wetland tropics for its large fruits and durable wood. The greenish unripe fruit is cooked as a vegetable, and the brown ripened fruit is eaten fresh for the sweetly acid but insipid pulp surrounding the seeds. The seeds are cooked and eaten locally. Jackfruit is considered a staple food crop in Bangladesh and other areas in South and Southeast Asia. Canned or processed jackfruit has gained popularity as a meat substitute in some places."
        ),
        ShowData(
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS4YX8CQqRqcHd4Bf5ACyzfJp54crL1qqWqJg&usqp=CAU",
            "Papaya",
            "Carica papaya is the scientific name of the orange and green fruit known more commonly as papaya. It tastes sweet and has a soft texture that many find appealing. The seeds are also edible, although they’re more bitter than the fruit itself."
        ),
        ShowData(
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR0sGX-4s9neE0iWAjGq8OXyqappD2EIJswYA&s",
            "hog plum",
            "hog plum is a fruit that grows on medium-sized deciduous trees Scientific name Spondias pinnaata Kurz."
        )
    )
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val show = binding.show
        show.layoutManager = GridLayoutManager(applicationContext,3)
        val adapter = MyGalleryAdapter(this)
        adapter.submitList(showDataList)
        show.adapter=adapter
    }

    override fun itemClicked(id: Int) {
        val showData = showDataList[id]
        Log.d("tag", "$id")
        val intent = Intent(applicationContext, FullActivity::class.java)
        intent.putExtra(FullActivity.pathKey, showData.path)
        intent.putExtra(FullActivity.titleKey, showData.title)
        intent.putExtra(FullActivity.descriptionKey, showData.description)
        startActivity(intent)
    }
}