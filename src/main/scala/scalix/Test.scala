package scalix

import scalix.MovieObjects.FullName
import scalix.Scalix.*

import java.util.Date
import java.time.{Duration, Instant}

object Test {
  def main(args: Array[String]) = {
    val actor1: FullName = FullName("Jason", "Momoa")
    val actor2: FullName = FullName("Amber", "Heard")
    val actor3: FullName = FullName("Will", "Smith")
    val actor4: FullName = FullName("Margot", "Robbie")
    val actor5: FullName = FullName("Emma", "Watson")
    val actor6: FullName = FullName("Alan", "Rickman")

    val actorId = findActorId(actor1.name, actor1.surname)
    println(s"Actor ${actor1.name} ${actor1.surname} with id: ${actorId.get}")

    val actorMovies = findActorMovies(actorId.get) // id:117642
    println(s"Movies for actor ${actor1.name} ${actor1.surname} with id: ${actorMovies}")

    val movieDirector = findMovieDirector(297802) // id : 297802
    println(s"Movie director: ${movieDirector.get}")

    val before= Instant.now()
    val collaborations = collaboration(actor1, actor2)
    val after= Instant.now()
    println(s"Collaboration: ${collaborations}")
    println("Time spent running collaboration: "+ Duration.between(before, after).toMillis)

    //Quiz
    collaboration(actor3, actor4)
    collaboration(actor5, actor6)
    numberCollaboration()

  }
}
