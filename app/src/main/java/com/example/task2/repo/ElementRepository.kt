package com.example.task2.repo;

import com.example.task2.data.Element;
import kotlin.random.Random

class ElementRepository {

    private val elements: MutableList<Element> = mutableListOf()

    init {
        for (i in 1..100) {
            elements.add(
                Element(
                    i.toString(),
                    "Element $i",
                    "Subtitle $i",
                    getRandomImageUrl()
                )
            )
        }
    }

    fun getAll(): List<Element> {
        return elements
    }

    fun getById(id: String): Element? {
        return elements.find { it.id == id }
    }
}


fun getRandomImageUrl(): String {

    val imageUrls = listOf(
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRn65xFdbcNyNiKrp-B-uYLecJRcoa_-B-kmA&s",
        "https://i.pinimg.com/236x/de/20/7d/de207de56145f555e8b2b3c1fdec0fd5.jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR0mfkBfYqBu9MKpBNeILV4Vpwe21pqr4svvw&s",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcREMiXS62hL4CbZOEtiDHwKMWgkRC-VfVb-tg&s",
        "https://sun9-57.userapi.com/impg/UIULTng0I4Uy_d-xrUByo-sw3jrJVdk43sQI3Q/m0SGgjsd4BU.jpg?size=247x310&quality=95&sign=f96899a9ffa45f00dc6aa44d975f0102&type=album"
    )

    return imageUrls[Random.nextInt(imageUrls.size)]
}



