package org.scala.data.science.code

import scala.collection.mutable.ListBuffer
/**
 * @author jzhang
 */
object KmeanExample {
    def main(args:Array[String]) {
      val ref = new KnearestNeighbors()  
      val kk=List(1,3,5,7)
      val cities = List((List(-86.75,33.5666666666667),"Python"),(List(-88.25,30.6833333333333),"Python"),(List(-112.016666666667,33.4333333333333),"Java"),
          (List(-110.933333333333,32.1166666666667),"Java"),(List(-92.2333333333333,34.7333333333333),"R"),(List(-121.95,37.7),"R"),(List(-118.15,33.8166666666667),"Python"),(List(-118.233333333333,34.05),"Java"),(List(-122.316666666667,37.8166666666667),"R"),(List(-117.6,34.05),"Python"),(List(-116.533333333333,33.8166666666667),"Python"),(List(-121.5,38.5166666666667),"R"),(List(-117.166666666667,32.7333333333333),"R"),(List(-122.383333333333,37.6166666666667),"R"),(List(-121.933333333333,37.3666666666667),"R"),(List(-122.016666666667,36.9833333333333),"Python"),(List(-104.716666666667,38.8166666666667),"Python"),(List(-104.866666666667,39.75),"Python"),(List(-72.65,41.7333333333333),"R"),(List(-75.6,39.6666666666667),"Python"),(List(-77.0333333333333,38.85),"Python"),(List(-80.2666666666667,25.8),"Java"),(List(-81.3833333333333,28.55),"Java"),(List(-82.5333333333333,27.9666666666667),"Java"),(List(-84.4333333333333,33.65),"Python"),(List(-116.216666666667,43.5666666666667),"Python"),(List(-87.75,41.7833333333333),"Java"),(List(-86.2833333333333,39.7333333333333),"Java"),(List(-93.65,41.5333333333333),"Java"),(List(-97.4166666666667,37.65),"Java"),(List(-85.7333333333333,38.1833333333333),"Python"),(List(-90.25,29.9833333333333),"Java"),(List(-70.3166666666667,43.65),"R"),(List(-76.6666666666667,39.1833333333333),"R"),(List(-71.0333333333333,42.3666666666667),"R"),(List(-72.5333333333333,42.2),"R"),(List(-83.0166666666667,42.4166666666667),"Python"),(List(-84.6,42.7833333333333),"Python"),(List(-93.2166666666667,44.8833333333333),"Python"),(List(-90.0833333333333,32.3166666666667),"Java"),(List(-94.5833333333333,39.1166666666667),"Java"),(List(-90.3833333333333,38.75),"Python"),(List(-108.533333333333,45.8),"Python"),(List(-95.9,41.3),"Python"),(List(-115.166666666667,36.0833333333333),"Java"),(List(-71.4333333333333,42.9333333333333),"R"),(List(-74.1666666666667,40.7),"R"),(List(-106.616666666667,35.05),"Python"),(List(-78.7333333333333,42.9333333333333),"R"),(List(-73.9666666666667,40.7833333333333),"R"),(List(-80.9333333333333,35.2166666666667),"Python"),(List(-78.7833333333333,35.8666666666667),"Python"),(List(-100.75,46.7666666666667),"Java"),(List(-84.5166666666667,39.15),"Java"),(List(-81.85,41.4),"Java"),(List(-82.8833333333333,40),"Java"),(List(-97.6,35.4),"Python"),(List(-122.666666666667,45.5333333333333),"Python"),(List(-75.25,39.8833333333333),"Python"),(List(-80.2166666666667,40.5),"Python"),(List(-71.4333333333333,41.7333333333333),"R"),(List(-81.1166666666667,33.95),"R"),(List(-96.7333333333333,43.5666666666667),"Python"),(List(-90,35.05),"R"),(List(-86.6833333333333,36.1166666666667),"R"),(List(-97.7,30.3),"Python"),(List(-96.85,32.85),"Java"),(List(-95.35,29.9666666666667),"Java"),(List(-98.4666666666667,29.5333333333333),"Java"),(List(-111.966666666667,40.7666666666667),"Python"),(List(-73.15,44.4666666666667),"R"),(List(-77.3333333333333,37.5),"Python"),(List(-122.3,47.5333333333333),"Python"),(List(-89.3333333333333,43.1333333333333),"R"),(List(-104.816666666667,41.15),"Java"))
      for (k<-kk) {
        var num_correct = 0
        var location=List[Double]()
        var actual_language=new String()        
         
        
        for (i<-0 until cities.length) {
            location =cities(i)._1
            actual_language = cities(i)._2
            val current_city = cities(i)
            
            var other_cities = cities.filter(x=>x!=current_city)       // drop is not started with 0, from 1     
             

            var predicted_language = ref.knn_classify(k, other_cities, location)

            if (predicted_language == actual_language) {
                num_correct += 1
            }
        }
        println( k+ " neighbor[s]:"+ num_correct+ " correct out of "+cities.size)  
      }
    }
}