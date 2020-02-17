package ru.otus.demo.room

import java.util.*

object ListData {
    val publishers: ArrayList<Publisher>
        get() {
            val answer = ArrayList<Publisher>()
            answer.add(Publisher("Penguin Random House", 3300))
            answer.add(Publisher("Hachette Livre", 2700))
            answer.add(Publisher("HarperCollins", 1500))
            answer.add(Publisher("Macmillan Publishers", 1400))
            answer.add(Publisher("Simon & Schuster", 830))
            answer.add(Publisher("McGraw-Hill Education", 1700))
            answer.add(Publisher("Houghton Mifflin Harcourt", 1400))
            answer.add(Publisher("Pearson Education", 1000))
            answer.add(Publisher("Springer Nature", 1900))
            answer.add(Publisher("Bonnier Books", 760))
            answer.add(Publisher("Klett", 730))
            return answer
        }
}